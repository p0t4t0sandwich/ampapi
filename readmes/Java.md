# ampapi-java

## Installation

`{version}` just refers to the release tag, without the `v` prefix. This library is built using Java 21, use the `downgraded-8-shaded` classifier if you're working in an older Java runtime.

### Maven

Note: Be sure to remove the `<scope>provided</scope>` if you're shading the library.

```xml
<repository>
    <id>neural-nexus</id>
    <name>NerualNexus</name>
    <url>https://maven.neuralnexus.dev/releases</url>
</repository>

<dependency>
    <groupId>dev.neuralnexus</groupId>
    <artifactId>ampapi</artifactId>
    <version>{version}</version>
    <scope>provided</scope>
</dependency>
```

### Gradle (Groovy DSL)

```gradle
repositories {
    maven {
        name = "NerualNexus"
        url = "https://maven.neuralnexus.dev/releases"
    }
}

dependencies {
    implementation "dev.neuralnexus:ampapi:{version}"
}
```

### Gradle (KDSL)

```gradle
repositories {
    maven("https://maven.neuralnexus.dev/releases")
}

dependencies {
    implementation("dev.neuralnexus:ampapi:{version}")
}
```

## Notes

- As much as I disklike the look, Java 16's records ended up being the nicest option in terms of codegen, so as a result you access nested properties with their getter rather than accessing the field itself.

## Examples

### CommonAPI Example

```java
import com.github.sviperll.result4j.Result;

import dev.neuralnexus.ampapi.AMPError;
import dev.neuralnexus.ampapi.auth.AuthProvider;
import dev.neuralnexus.ampapi.auth.BasicAuthProvider;
import dev.neuralnexus.ampapi.modules.CommonAPI;
import dev.neuralnexus.ampapi.types.StatusResponse;

public class Main {
    public static void main(String[] args) {
        AuthProvider authProvider =
                BasicAuthProvider.builder()
                        .panelUrl("http://localhost:8080/")
                        .username("admin")
                        .password("myfancypassword123")
                        .token("")
                        .rememberMe(false)
                        .build();

        // If you know the module that the instance is using, specify it instead of CommonAPI
        CommonAPI API = new CommonAPI(authProvider);

        // API call parameters are simply in the same order as shown in the documentation.
        API.Core.SendConsoleMessage("say Hello Everyone, this message was sent from the Java API!");

        Result<StatusResponse, AMPError> result = API.Core.GetStatus();
        if (result.isError()) {
            result.peekError(err -> System.out.println("An error occurred: " + err.toString()));
            return;
        }
        StatusResponse currentStatus = result.discardError().get();
        double CPUUsagePercent = currentStatus.Metrics().get("CPU Usage").Percent();

        System.out.println("Current CPU usage is: " + CPUUsagePercent + "%");
    }
}
```

### Example using the ADS to manage an instance

```java
import dev.neuralnexus.ampapi.AMPAPIException;
import dev.neuralnexus.ampapi.auth.AuthProvider;
import dev.neuralnexus.ampapi.auth.AuthStore;
import dev.neuralnexus.ampapi.auth.RefreshingAuthProvider;
import dev.neuralnexus.ampapi.modules.ADS;
import dev.neuralnexus.ampapi.modules.Minecraft;
import dev.neuralnexus.ampapi.types.IADSInstance;
import dev.neuralnexus.ampapi.types.InstanceSummary;
import dev.neuralnexus.ampapi.types.StatusResponse;

import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        AuthStore authStore = new AuthStore();
        AuthProvider adsAuthProvider =
                RefreshingAuthProvider.builder()
                        .relogInterval(30 * 1000)
                        .panelUrl("http://localhost:8080/")
                        .username("admin")
                        .password("myfancypassword123")
                        .build();
        authStore.add(adsAuthProvider);

        ADS API = new ADS(adsAuthProvider);

        // Get the available instances
        List<IADSInstance> targets = API.ADSModule.GetInstances(false)
                .orOnErrorThrow(AMPAPIException::new);
                // .discardError().orElse(null) or .discardError().get() also work

        // In this example, my Hub server is on the second target
        // If you're running a standalone setup, you can just use targets.get(0)
        IADSInstance target = targets.get(1);

        UUID hub_instance_id = null;

        // Get the available instances
        List<InstanceSummary> instances = target.AvailableInstances();
        for (InstanceSummary instance : instances) {
            // Find the instance named "Hub"
            if (instance.InstanceName().equals("Hub01")) {
                hub_instance_id = instance.InstanceID();
                break;
            }
        }

        // Use the instance ID to get the API for the instance
        AuthProvider hubAuthProvider =
                RefreshingAuthProvider.builder()
                        .relogInterval(30 * 1000)
                        .panelUrl(adsAuthProvider.dataSource() + "ADSModule/Servers/" + hub_instance_id)
                        // .panelUrl(adsAuthProvider.dataSource() + "ADSModule/Servers/" + "Hub01") Would also work
                        .username("admin")
                        .password("myfancypassword123")
                        .build();
        authStore.add(hubAuthProvider, hub_instance_id);

        Minecraft Hub = new Minecraft(authStore.get(hub_instance_id));

        // Get the current CPU usage
        StatusResponse currentStatus = Hub.Core.GetStatus()
                .orOnErrorThrow(AMPAPIException::new);
        double CPUUsagePercent = currentStatus.Metrics().get("CPU Usage").Percent();

        // Send a message to the console
        Hub.Core.SendConsoleMessage("say Current CPU usage is: " + CPUUsagePercent + "%");
    }
}
```

### CommonAPI Example, handling the sessionId and rememberMeToken manually (not recommended)

```java
import dev.neuralnexus.ampapi.AMPAPIException;
import dev.neuralnexus.ampapi.auth.AuthProvider;
import dev.neuralnexus.ampapi.auth.BasicAuthProvider;
import dev.neuralnexus.ampapi.modules.CommonAPI;
import dev.neuralnexus.ampapi.types.LoginResponse;
import dev.neuralnexus.ampapi.types.StatusResponse;

public class Main {
    public static void main(String[] args) {
        try {
            // The third parameter is either used for 2FA logins, or if no password is specified
            // to use a remembered token from a previous login, or a service login token.
            AuthProvider authProvider =
                    BasicAuthProvider.builder()
                            .panelUrl("http://localhost:8080/")
                            .username("admin")
                            .password("myfancypassword123")
                            .token("")
                            .rememberMe(false)
                            .build();
            CommonAPI API = new CommonAPI(authProvider);

            // NOTE: THE AUTH FLOW BELOW CAN BE REPLACED WITH THE FOLLOWING:
            // authProvider.Login();
            // if (!authProvider.sessionId().isEmpty()) {
            //     ...
            // }

            LoginResponse loginResult =
                    API.Core.Login(
                            authProvider.username(),
                            authProvider.password(),
                            authProvider.token(),
                            authProvider.rememberMe())
                            .orOnErrorThrow(AMPAPIException::new);

            if (loginResult.success()) {
                System.out.println("Login successful");

                // Update the session ID
                authProvider.update(loginResult);

                // API call parameters are simply in the same order as shown in the
                // documentation.
                API.Core.SendConsoleMessage(
                        "say Hello Everyone, this message was sent from the Java API!");

                StatusResponse currentStatus = API.Core.GetStatus()
                        .orOnErrorThrow(AMPAPIException::new);
                double CPUUsagePercent = currentStatus.Metrics().get("CPU Usage").Percent();

                System.out.println("Current CPU usage is: " + CPUUsagePercent + "%");

            } else {
                System.out.println("Login failed");
                System.out.println(loginResult);
            }
        } catch (RuntimeException e) {
            // In reality, you'd handle this exception better
            throw new RuntimeException(e);
        }
    }
}
```
