# ampapi-java

[![License](https://img.shields.io/github/license/p0t4t0sandwich/ampapi-java?color=blue)](https://img.shields.io/github/downloads/p0t4t0sandwich/ampapi-java/LICENSE)
[![Github](https://img.shields.io/github/stars/p0t4t0sandwich/ampapi-java)](https://github.com/p0t4t0sandwich/ampapi-java)
[![Github Issues](https://img.shields.io/github/issues/p0t4t0sandwich/ampapi-java?label=Issues)](https://github.com/p0t4t0sandwich/ampapi-java/issues)
[![Discord](https://img.shields.io/discord/1067482396246683708?color=7289da&logo=discord&logoColor=white)](https://discord.neuralnexus.dev)
[![wakatime](https://wakatime.com/badge/github/p0t4t0sandwich/ampapi-java.svg)](https://wakatime.com/badge/github/p0t4t0sandwich/ampapi-java)

[![Github Releases](https://img.shields.io/github/downloads/p0t4t0sandwich/ampapi-java/total?label=Github&logo=github&color=181717)](https://github.com/p0t4t0sandwich/ampapi-java/releases)
[![Maven Repo](https://img.shields.io/maven-metadata/v?label=Release&metadataUrl=https%3A%2F%2Fmaven.neuralnexus.dev%2Freleases%2Fdev%2Fneuralnexus%2Fampapi%2Fmaven-metadata.xml)](https://maven.neuralnexus.dev/#/releases/dev/neuralnexus/ampapi)
[![Maven Repo](https://img.shields.io/maven-metadata/v?label=Snapshot&metadataUrl=https%3A%2F%2Fmaven.neuralnexus.dev%2Fsnapshots%2Fdev%2Fneuralnexus%2Fampapi%2Fmaven-metadata.xml)](https://maven.neuralnexus.dev/#/snapshots/dev/neuralnexus/ampapi)

An API that allows you to communicate with AMP installations from within Java.

Documentation for available API calls can be found by appending /API to the URL of any existing AMP installation.

Support:

- Ping `@thepotatoking3452` in the `#development` channel of the [AMP Discord](https://discord.gg/cubecoders)
- My own [development Discord](https://discord.neuralnexus.dev/)

## Installation

`{version}` just refers to the release tag, without the `v` prefix.

### Maven

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

Note: Be sure to remove the `<scope>provided</scope>` if you're shading the library.

### Gradle

```gradle
maven {
    name "NerualNexus"
    url "https://maven.neuralnexus.dev/releases"
}

dependencies {
    implementation 'dev.neuralnexus:ampapi:{version}'
}
```

## Notes

- If a function returns anything in the form of `Map<String, Object>`, then you can treat it as `JSON` and parse it as
  such (Feel free to draft up a return type if you'd like).
- If you're running into a `GSON`/`JSON` error, the API return type may be missing a `Task<T>` or `Result<T>` wrapper (
  or the return type could just be wrong in general).

## Examples

### CommonAPI Example

```java
import dev.neuralnexus.ampapi.modules_old.CommonAPI;
import dev.neuralnexus.ampapi.types_old.GetStatusResult;

public class Main {
  public static void main(String[] args) {
    // If you know the module that the instance is using, specify it instead of CommonAPI
    CommonAPI API = new CommonAPI("http://localhost:8080/", "admin", "myfancypassword123");

    // API call parameters are simply in the same order as shown in the documentation.
    API.Core.SendConsoleMessage("say Hello Everyone, this message was sent from the Java API!");

    Status currentStatus = API.Core.GetStatus();
    double CPUUsagePercent = currentStatus.Metrics.get("CPU Usage").Percent;

    System.out.println("Current CPU usage is: " + CPUUsagePercent + "%");
  }
}
```

### Example using the ADS to manage an instance

```java
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
    List<IADSInstance> targets = API.ADSModule.GetInstances(false);

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
    StatusResponse currentStatus = Hub.Core.GetStatus();
    double CPUUsagePercent = currentStatus.Metrics().get("CPU Usage").Percent();

    // Send a message to the console
    Hub.Core.SendConsoleMessage("say Current CPU usage is: " + CPUUsagePercent + "%");
  }
}
```

### CommonAPI Example, handling the sessionId and rememberMeToken manually (not recommended)

```java
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
                      authProvider.rememberMe());

      if (loginResult.success()) {
        System.out.println("Login successful");

        // Update the session ID
        authProvider.update(loginResult);

        // API call parameters are simply in the same order as shown in the
        // documentation.
        API.Core.SendConsoleMessage(
                "say Hello Everyone, this message was sent from the Java API!");

        StatusResponse currentStatus = API.Core.GetStatus();
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

## TODO

- Might want to look into `CompletableFuture`s for async calls
- Some sort of optional notation for when an API call fails? How would GSON handle two possible outcomes?
- Create custom types:
    - DeploymentTemplate
    - PostCreateActions
    - ApplicationSpec
    - PortProtocol
    - PortUsage
    - LocalAMPInstance
    - ContainerMemoryPolicy
    - Single
    - FileChunkData
    - BackupManifest
    - DateTime
    - IAuditLogEntry
    - Nullable -> might be able to use an Optional for this
    - ScheduleInfo
    - TimeIntervalTrigger
    - WebSessionSummary
    - IPermissionsTreeNode
    - WebauthnLoginInfo
    - WebauthnCredentialSummary
    - MethodInfoSummary
    - ListeningPortSummary
    - TwoFactorSetupInfo
    - UserInfoSummary
    - AuthRoleSummary

## In-Progress Release Notes
