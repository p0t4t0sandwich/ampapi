package ampapi

// ActionResult - Generic response type for calls that return a result and a reason for failure
// Author: p0t4t0sandwich
type ActionResult[T any] struct {
	Status bool   `json:"Status"` // true if successful, false if not
	Reason string `json:"Reason"` // reason for failure
	Result T      `json:"Result"` // result of the call
}

// AMPVersion - AMP version information
// Author: p0t4t0sandwich
type AMPVersion struct {
	Major         int `json:"Major"`         // The major version number
	Minor         int `json:"Minor"`         // The minor version number
	Build         int `json:"Build"`         // The build number
	Revision      int `json:"Revision"`      // The revision number
	MajorRevision int `json:"MajorRevision"` // The major revision number
	MinorRevision int `json:"MinorRevision"` // The minor revision number
}

// Branding - Defines the Branding object as part of the ModuleInfo object
// Author: p0t4t0sandwich
type Branding struct {
	DisplayBranding      bool   `json:"DisplayBranding"`      // Whether to display branding
	PageTitle            string `json:"PageTitle"`            // The page title
	CompanyName          string `json:"CompanyName"`          // The company name
	WelcomeMessage       string `json:"WelcomeMessage"`       // The welcome message
	BrandingMessage      string `json:"BrandingMessage"`      // The branding message
	ShortBrandingMessage string `json:"ShortBrandingMessage"` // The short branding message
	URL                  string `json:"URL"`                  // The URL
	SupportURL           string `json:"SupportURL"`           // The support URL
	SupportText          string `json:"SupportText"`          // The support text
	SubmitTicketURL      string `json:"SubmitTicketURL"`      // The submit ticket URL
	LogoURL              string `json:"LogoURL"`              // The logo URL
	BackgroundURL        string `json:"BackgroundURL"`        // The background URL
	SplashFrameURL       string `json:"SplashFrameURL"`       // The splash frame URL
	ForgotPasswordURL    string `json:"ForgotPasswordURL"`    // The forgot password URL
}

// ConsoleEntry - Struct for the result of API.Core#GetUpdates.ConsoleEntries
// Author: p0t4t0sandwich
type ConsoleEntry struct {
	Timestamp string `json:"Timestamp"` // The timestamp of the console entry
	Source    string `json:"Source"`    // The source of the console entry
	SourceId  string `json:"SourceId"`  // The source ID of the console entry
	Type      string `json:"Type"`      // The type of the console entry
	Contents  string `json:"Contents"`  // The contents of the console entry
}

// CPUInfo - CPU information object
// Author: p0t4t0sandwich
type CPUInfo struct {
	Sockets      int    `json:"Sockets"`      // Number of CPU sockets
	Cores        int    `json:"Cores"`        // Number of CPU cores
	Threads      int    `json:"Threads"`      // Number of CPU threads
	Vendor       int    `json:"Vendor"`       // CPU vendor
	ModelName    string `json:"ModelName"`    // CPU model name
	TotalCores   int    `json:"TotalCores"`   // Total number of CPU cores
	TotalThreads int    `json:"TotalThreads"` // Total number of CPU threads
}

// EndpointInfo - An application endpoint object
// Author: p0t4t0sandwich
type EndpointInfo struct {
	DisplayName string `json:"DisplayName"` // The display name of the endpoint
	Endpoint    string `json:"Endpoint"`    // The endpoint address
	Uri         string `json:"Uri"`         // The URI of the endpoint
}

// IADSInstance - An ADS instance object
// Author: p0t4t0sandwich
type IADSInstance struct {
	Id                  int                 `json:"Id"`                  // The ADS instance ID
	InstanceId          UUID                `json:"InstanceId"`          // The instance ID
	FriendlyName        string              `json:"FriendlyName"`        // The friendly name
	Description         string              `json:"Description"`         // The description
	Disabled            bool                `json:"Disabled"`            // Whether the instance is disabled
	IsRemote            bool                `json:"isRemote"`            // Whether the instance is remote
	Platform            PlatformInfo        `json:"Platform"`            // The platform information object
	Datastores          []InstanceDatastore `json:"Datastores"`          // The datastores
	CreatesInContainers bool                `json:"CreatesInContainers"` // Whether the instance creates in containers
	State               State               `json:"State"`               // The state
	StateReason         string              `json:"StateReason"`         // The state reason
	CanCreate           bool                `json:"CanCreate"`           // Whether the instance can create
	LastUpdated         string              `json:"LastUpdated"`         // The last updated
	AvailableInstances  []Instance          `json:"AvailableInstances"`  // The available instances
	AvailableIPs        []string            `json:"AvailableIPs"`        // The available IPs
	URL                 string              `json:"URL"`                 // The URL
	Tags                []string            `json:"Tags"`                // The tags
	TagNames            []string            `json:"TagNames"`            // The tag names
}

// Instance - An instance object
// Author: p0t4t0sandwich
type Instance struct {
	InstanceID            UUID              `json:"InstanceID"`            // The instance ID
	TargetID              UUID              `json:"TargetID"`              // The target ID
	InstanceName          string            `json:"InstanceName"`          // The instance name
	FriendlyName          string            `json:"FriendlyName"`          // The friendly name
	Description           string            `json:"Description"`           // The description
	Module                string            `json:"Module"`                // The module
	ModuleDisplayName     string            `json:"ModuleDisplayName"`     // The module display name
	AMPVersion            AMPVersion        `json:"AMPVersion"`            // The AMP version
	IsHTTPS               bool              `json:"IsHTTPS"`               // Whether HTTPS is enabled
	IP                    string            `json:"IP"`                    // The IP address
	Port                  int               `json:"Port"`                  // The port
	Daemon                bool              `json:"Daemon"`                // Whether the instance is a daemon
	DaemonAutostart       bool              `json:"DaemonAutostart"`       // Whether the instance daemon autostarts
	ExcludeFromFirewall   bool              `json:"ExcludeFromFirewall"`   // Whether the instance is excluded from the firewall
	Running               bool              `json:"Running"`               // Whether the instance is running
	AppState              State             `json:"AppState"`              // The application state
	Tags                  []string          `json:"Tags"`                  // The tags
	DiskUsageMB           int               `json:"DiskUsageMB"`           // The disk usage in MB
	ReleaseStream         string            `json:"ReleaseStream"`         // The release stream
	ManagementMode        string            `json:"ManagementMode"`        // The management mode
	Suspended             bool              `json:"Suspended"`             // Whether the instance is suspended
	IsContainerInstance   bool              `json:"IsContainerInstance"`   // Whether the instance is a container instance
	ContainerMemoryMB     int               `json:"ContainerMemoryMB"`     // The container memory in MB
	ContainerMemoryPolicy string            `json:"ContainerMemoryPolicy"` // The container memory policy
	ContainerCPUs         int               `json:"ContainerCPUs"`         // The container CPUs
	SpecificDockerImage   string            `json:"SpecificDockerImage"`   // The specific Docker image
	Metrics               map[string]Metric `json:"Metrics"`               // The metrics
	ApplicationEndpoints  []EndpointInfo    `json:"ApplicationEndpoints"`  // The application endpoints
	DeploymentArgs        map[string]string `json:"DeploymentArgs"`        // The deployment arguments
	DisplayImageSource    string            `json:"DisplayImageSource"`    // The display image source
}

// InstanceDatastore - A datastore object
// Author: p0t4t0sandwich
type InstanceDatastore struct {
	Id           int    `json:"Id"`           // The datastore ID
	FriendlyName string `json:"FriendlyName"` // The friendly name
}

// InstanceStatus - A struct to represent the object returned by the ADSModule#GetInstanceStatuses() method
// Author: p0t4t0sandwich
type InstanceStatus struct {
	InstanceID UUID `json:"InstanceID"` // The instance ID
	Running    bool `json:"Running"`    // Whether the instance is running
}

// LicenceInfo - A struct to represent the object returned by the ADSModule#GetLicenceInfo() method
// Author: p0t4t0sandwich
type LicenceInfo struct {
	LicenceKey  UUID   `json:"LicenceKey"`  // The licence key
	Grade       UUID   `json:"Grade"`       // The grade
	GradeName   string `json:"GradeName"`   // The grade name
	Product     UUID   `json:"Product"`     // The product
	ProductName string `json:"ProductName"` // The product name
	Expires     string `json:"Expires"`     // The expiry date
	Usage       int    `json:"Usage"`       // The usage
}

// LoginResult - Response type for API.Core.Login
// Author: p0t4t0sandwich
type LoginResult struct {
	Success         bool     `json:"success"`         // Whether the login was successful
	Permissions     []string `json:"permissions"`     // The user's permissions
	SessionId       string   `json:"sessionID"`       // The session ID
	RememberMeToken string   `json:"rememberMeToken"` // The remember me token
	UserInfo        UserInfo `json:"userInfo"`        // The user information
	ResultReason    string   `json:"resultReason"`    // The reason of the result
	Result          float64  `json:"result"`          // The result
}

// Message - Message type for API.Core.GetUpdates status messages (along with WS keep alive)
// Author: p0t4t0sandwich
type Message struct {
	Id         UUID   `json:"Id"`         // The message ID
	Expired    bool   `json:"Expired"`    // Whether the message has expired
	Source     string `json:"Source"`     // The source of the message
	Message    string `json:"Message"`    // The message
	AgeMinutes int    `json:"AgeMinutes"` // The age of the message in minutes
}

// Metric - A metric object
// Author: p0t4t0sandwich
type Metric struct {
	RawValue int     `json:"RawValue"` // The raw value
	MaxValue int     `json:"MaxValue"` // The maximum value
	Percent  float64 `json:"Percent"`  // The percentage
	Units    string  `json:"Units"`    // The units
	Color    string  `json:"Color"`    // The color
	Color2   string  `json:"Color2"`   // The second color
	Color3   string  `json:"Color3"`   // The third color
}

// ModuleInfo - A struct to represent the object returned by the ADSModule#GetModuleInfo() method
// Author: p0t4t0sandwich
type ModuleInfo struct {
	Name             string     `json:"Name"`             // The name of the module
	Author           string     `json:"Author"`           // The author of the module
	AppName          string     `json:"AppName"`          // The application name
	SupportsSleep    bool       `json:"SupportsSleep"`    // Whether the module supports sleep mode
	LoadedPlugins    []string   `json:"LoadedPlugins"`    // The loaded plugins
	AMPVersion       AMPVersion `json:"AMPVersion"`       // The AMP version
	AMPBuild         string     `json:"AMPBuild"`         // The AMP build
	ToolsVersion     AMPVersion `json:"ToolsVersion"`     // The tools version
	APIVersion       AMPVersion `json:"APIVersion"`       // The API version
	VersionCodename  string     `json:"VersionCodename"`  // The version codename
	Timestamp        string     `json:"Timestamp"`        // The timestamp
	BuildSpec        string     `json:"BuildSpec"`        // The build spec
	Branding         Branding   `json:"Branding"`         // The branding object
	Analytics        bool       `json:"Analytics"`        // Whether analytics are enabled
	FeatureSet       []string   `json:"FeatureSet"`       // The feature set
	InstanceId       UUID       `json:"InstanceId"`       // The instance ID
	InstanceName     string     `json:"InstanceName"`     // The instance name
	FriendlyName     string     `json:"FriendlyName"`     // The friendly name
	EndpointURI      string     `json:"EndpointURI"`      // The endpoint URI
	PrimaryEndpoint  string     `json:"PrimaryEndpoint"`  // The primary endpoint
	ModuleName       string     `json:"ModuleName"`       // The module name
	IsRemoteInstance bool       `json:"IsRemoteInstance"` // Whether the instance is remote
	DisplayBaseURI   string     `json:"DisplayBaseURI"`   // The display base URI
	RequiresFullLoad bool       `json:"RequiresFullLoad"` // Whether the module requires a full load
	AllowRememberMe  bool       `json:"AllowRememberMe"`  // Whether remember me is allowed
}

// PlatformInfo - Platform information object
// Author: p0t4t0sandwich
type PlatformInfo struct {
	CPUInfo        CPUInfo `json:"CPUInfo"`        // The CPU information object
	InstalledRAMMB int     `json:"InstalledRAMMB"` // The installed RAM in MB
	OS             int     `json:"OS"`             // The OS
	PlatformName   string  `json:"PlatformName"`   // The platform name
	SystemType     int     `json:"SystemType"`     // The system type
	Virtualization int     `json:"Virtualization"` // The virtualization
}

// RemoteTargetInfo - A struct to represent the object returned by the ADSModule#GetTargetInfo() method
// Author: p0t4t0sandwich
type RemoteTargetInfo struct {
	IPAddressList       []string            `json:"IPAddressList"`       // The IP address list
	PlatformInfo        PlatformInfo        `json:"PlatformInfo"`        // The platform information object
	Datastores          []InstanceDatastore `json:"Datastores"`          // The datastores
	DeploysInContainers bool                `json:"DeploysInContainers"` // Whether the target deploys in containers
}

// RunningTask - A running task object returned by the Core#GetTasks() method
// Author: p0t4t0sandwich
type RunningTask struct {
	IsPrimaryTask    bool    `json:"IsPrimaryTask"`    // Whether the task is the primary task
	StartTime        string  `json:"StartTime"`        // The start time
	Id               UUID    `json:"Id"`               // The task ID
	Name             string  `json:"Name"`             // The task name
	Description      string  `json:"Description"`      // The task description
	HideFromUI       bool    `json:"HideFromUI"`       // Whether the task is hidden from the UI
	FastDismiss      bool    `json:"FastDismiss"`      // Whether the task can be dismissed quickly
	LastUpdatePushed string  `json:"LastUpdatePushed"` // The last update pushed
	ProgressPercent  float64 `json:"ProgressPercent"`  // The progress percentage
	IsCancellable    bool    `json:"IsCancellable"`    // Whether the task is cancellable
	Origin           string  `json:"Origin"`           // The origin
	IsIndeterminate  bool    `json:"IsIndeterminate"`  // Whether the task is indeterminate
	State            int     `json:"State"`            // The state
	Status           string  `json:"Status"`           // The status
}

// Spec - A setting specification object
// Author: p0t4t0sandwich
type SettingSpec struct {
	ReadOnly              bool   `json:"ReadOnly"`              // Whether the setting is read-only
	Name                  string `json:"Name"`                  // The name
	Description           string `json:"Description"`           // The description
	Category              string `json:"Category"`              // The category
	CurrentValue          any    `json:"CurrentValue"`          // The current value
	ValType               string `json:"ValType"`               // The value type
	EnumValues            any    `json:"EnumValues"`            // The enum values
	EnumValuesAreDeferred bool   `json:"EnumValuesAreDeferred"` // Whether the enum values are deferred
	Node                  string `json:"Node"`                  // The node
	InputType             string `json:"InputType"`             // The input type
	SelectionSource       any    `json:"SelectionSource"`       // The selection source
	IsProvisionSpec       bool   `json:"IsProvisionSpec"`       // Whether the setting is a provision spec
	ReadOnlyProvision     bool   `json:"ReadOnlyProvision"`     // Whether the provision is read-only
	Actions               []any  `json:"Actions"`               // The actions
	Keywords              any    `json:"Keywords"`              // The keywords
	AlwaysAllowRead       bool   `json:"AlwaysAllowRead"`       // Whether the setting is always allowed to be read
	Tag                   string `json:"Tag"`                   // The tag
	MaxLength             int    `json:"MaxLength"`             // The max length
	Placeholder           string `json:"Placeholder"`           // The placeholder
	Suffix                string `json:"Suffix"`                // The suffix
	Meta                  string `json:"Meta"`                  // The meta
	RequiresRestart       bool   `json:"RequiresRestart"`       // Whether the setting requires a restart
}

// State - Represents the state of an instance
// Author: p0t4t0sandwich
type State int

// StateMap - A map of states to their integer values
// StateMapReverse - A map of integer values to their states
var (
	StateMap = map[string]int{
		"Undefined":         -1,
		"Stopped":           0,
		"PreStart":          5,
		"Configuring":       7, // The server is performing some first-time-start configuration.
		"Starting":          10,
		"Ready":             20,
		"Restarting":        30, // Server is in the middle of stopping, but once shutdown has finished it will automatically restart.
		"Stopping":          40,
		"PreparingForSleep": 45,
		"Sleeping":          50, // The application should be able to be resumed quickly if using this state. Otherwise use Stopped.
		"Waiting":           60, // The application is waiting for some external service/application to respond/become available.
		"Installing":        70,
		"Updating":          75,
		"AwaitingUserInput": 80, // Used during installation, means that some user input is required to complete setup (authentication etc).
		"Failed":            100,
		"Suspended":         200,
		"Maintainence":      250,
		"Indeterminate":     999, // The state is unknown, or doesn't apply (for modules that don't start an external process)
	}

	StateMapReverse = map[int]string{
		-1:  "Undefined",
		0:   "Stopped",
		5:   "PreStart",
		7:   "Configuring",
		10:  "Starting",
		20:  "Ready",
		30:  "Restarting",
		40:  "Stopping",
		45:  "PreparingForSleep",
		50:  "Sleeping",
		60:  "Waiting",
		70:  "Installing",
		75:  "Updating",
		80:  "AwaitingUserInput",
		100: "Failed",
		200: "Suspended",
		250: "Maintainence",
		999: "Indeterminate",
	}
)

// String - Returns the string representation of the state
// Author: p0t4t0sandwich
func (s State) String() string {
	if val, ok := StateMapReverse[int(s)]; ok {
		return val
	}
	return "Undefined"
}

// Status - Struct for the result of API.Core.GetStatus
// Author: p0t4t0sandwich
type Status struct {
	State   State             `json:"State"`   // The state of the instance
	Uptime  string            `json:"Uptime"`  // The uptime of the instance
	Metrics map[string]Metric `json:"Metrics"` // The metrics
}

// UpdateInfo - A struct to represent the object returned by the ADSModule#GetUpdateInfo() method
// Author: p0t4t0sandwich
type UpdateInfo struct {
	UpdateAvailable bool   `json:"UpdateAvailable"` // Whether an update is available
	Version         string `json:"Version"`         // The version of the update
	Build           string `json:"Build"`           // The build of the update
	ReleaseNotesURL string `json:"ReleaseNotesURL"` // The URL to the release notes
	ToolsVersion    string `json:"ToolsVersion"`    // The version of the tools
	PatchOnly       bool   `json:"PatchOnly"`       // Whether the update is a patch
}

// Updates - Response type for API.Core.GetUpdates
// Author: p0t4t0sandwich
type Updates struct {
	Status         Status         `json:"Status"`         // The status of the server
	ConsoleEntries []ConsoleEntry `json:"ConsoleEntries"` // The console entries of the server
	Messages       []Message      `json:"Messages"`       // The messages of the server
	Tasks          []string       `json:"Tasks"`          // The tasks of the server
	Ports          []string       `json:"Ports"`          // The ports of the server
}

// UserInfo - Information about the user
// Author: p0t4t0sandwich
type UserInfo struct {
	ID                 UUID   `json:"ID"`                 // The user ID
	Username           string `json:"Username"`           // The username
	EmailAddress       string `json:"EmailAddress"`       // The email address
	IsTwoFactorEnabled bool   `json:"IsTwoFactorEnabled"` // Wether 2FA is enabled
	Disabled           bool   `json:"Disabled"`           // Whether the user is disabled
	LastLogin          string `json:"LastLogin"`          // The last login
	GravatarHash       string `json:"GravatarHash"`       // The Gravatar hash
	IsLDAPUser         bool   `json:"IsLDAPUser"`         // Whether the user is an LDAP user
}

// URL - A URL is a string that represents a URL
// Author: p0t4t0sandwich
type URL string

// UUID - A UUID is a string that represents a UUID
// Author: p0t4t0sandwich
type UUID string

// String - Returns the string representation of the UUID
func (u UUID) String() string {
	return string(u)
}
