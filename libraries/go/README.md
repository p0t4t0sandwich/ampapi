# ampapi-go

[![License](https://img.shields.io/github/license/p0t4t0sandwich/ampapi-go?color=blue)](https://img.shields.io/github/downloads/p0t4t0sandwich/ampapi-go/LICENSE)
[![Github](https://img.shields.io/github/stars/p0t4t0sandwich/ampapi-go)](https://github.com/p0t4t0sandwich/ampapi-go)
[![Github Issues](https://img.shields.io/github/issues/p0t4t0sandwich/ampapi-go?label=Issues)](https://github.com/p0t4t0sandwich/ampapi-go/issues)
[![Discord](https://img.shields.io/discord/1067482396246683708?color=7289da&logo=discord&logoColor=white)](https://discord.neuralnexus.dev)
[![wakatime](https://wakatime.com/badge/github/p0t4t0sandwich/ampapi-go.svg)](https://wakatime.com/badge/github/p0t4t0sandwich/ampapi-go)

[![Github Releases](https://img.shields.io/github/downloads/p0t4t0sandwich/ampapi-go/total?label=Github&logo=github&color=181717)](https://github.com/p0t4t0sandwich/ampapi-go/releases)
[![Go Reference](https://pkg.go.dev/badge/github.com/p0t4t0sandwich/ampapi-go.svg)](https://pkg.go.dev/github.com/p0t4t0sandwich/ampapi-go)
[![Go Report Card](https://goreportcard.com/badge/github.com/p0t4t0sandwich/ampapi-go)](https://goreportcard.com/report/github.com/p0t4t0sandwich/ampapi-go)

An API that allows you to communicate with AMP installations from within Go.

Documentation for available API calls can be found by appending /API to the URL of any existing AMP installation.

Support:

- Ping `@thepotatoking3452` in the `#development` channel of the [AMP Discord](https://discord.gg/cubecoders)
- My own [development Discord](https://discord.neuralnexus.dev/)

## Installation

```bash
go get github.com/p0t4t0sandwich/ampapi-go
```

## Examples

### CommonAPI Example

```go
package main

import (
    "github.com/p0t4t0sandwich/ampapi-go"
    "github.com/p0t4t0sandwich/ampapi-go/apimodules"
)

func main() {
    // If you know the module that the instance is using, specify it instead of CommonAPI
    API, err := modules.NewCommonAPI("http://localhost:8080/", "admin", "myfancypassword123")
    if err != nil {
        panic(err)
    }

    // API call parameters are simply in the same order as shown in the documentation.
    API.Core.SendConsoleMessage("say Hello Everyone, this message was sent from the Go API!")

    var currentStatus ampapi.Status = API.Core.GetStatus()
    CPUUsagePercent := currentStatus.Metrics["CPU Usage"].Percent

    fmt.Printf("Current CPU usage is: %v%%\n", CPUUsagePercent)
}
```

### Example using the ADS to manage an instance

```go
package main

import (
    "strconv"

    "github.com/p0t4t0sandwich/ampapi-go"
    "github.com/p0t4t0sandwich/ampapi-go/apimodules"
)

func main() {
    API, err := modules.NewADS("http://localhost:8080/", "admin", "myfancypassword123")
    if err != nil {
        panic(err)
    }

    // Get the available instances
    targets, err := API.ADSModule.GetInstances()
    if err != nil {
        panic(err)
    }

    // In this example, my Hub server is on the second target
    // If you're running a standalone setup, you can just use targets[1]
    target := targets[1]

    var hub_instance_id ampapi.UUID

    // Get the instance ID of the Hub server
    for _, instance := range target.AvailableInstances {
        if instance.InstanceName == "Hub" {
            hub_instance_id = instance.InstanceID
            break
        }
    }

    // Use the instance ID to get the API for the instance
    HubInstance, err := API.InstanceLogin(hub_instance_id, "Minecraft")
    if err != nil {
        panic(err)
    }
    Hub, ok := HubInstance.(*modules.Minecraft)
    if !ok {
        panic("Failed to login to instance")
    }

    // Get the current CPU usage
    currentStatus, err := Hub.Core.GetStatus()
    if err != nil {
        panic(err)
    }
    CPUUsagePercent := currentStatus.Metrics["CPU Usage"].Percent

    // Send a message to the console
    Hub.Core.SendConsoleMessage("say Current CPU usage is: " + strconv.FormatFloat(CPUUsagePercent, 'f', 2, 64) + "%")
}
```

### CommonAPI Example, handling the sessionId and rememberMeToken manually (not recommended)

```go
package main

import (
    "github.com/p0t4t0sandwich/ampapi-go"
    "github.com/p0t4t0sandwich/ampapi-go/apimodules"
)

func main() {
    API, err := modules.NewCommonAPI("http://localhost:8080/")
    if err != nil {
        panic(err)
    }

    // The third parameter is either used for 2FA logins, or if no password is specified to use a remembered token from a previous login, or a service login token.
    loginResult := API.Core.Login("admin", "myfancypassword123", "", false)

    if loginResult.Success {
        fmt.Println("Login successful!")
        API.AMPAPI.SessionId = loginResult.SessionId

        // API call parameters are simply in the same order as shown in the documentation.
        API.Core.SendConsoleMessage("say Hello Everyone, this message was sent from the Go API!")
        var currentStatus ampapi.Status = API.Core.GetStatus()
        CPUUsagePercent := currentStatus.Metrics["CPU Usage"].Percent
        fmt.Printf("Current CPU usage is: %v%%\n", CPUUsagePercent)
    } else {
        fmt.Println("Login failed!")
        fmt.Println(loginResult)
    }
}
```
