package ampapi

import (
	"time"

	"github.com/google/uuid"
)

// ActionResult Generic response type for calls that return a result and a reason for failure
type ActionResult[T any] struct {
	Reason       string `json:"Reason"`       // Reason Reason for failure
	Status       bool   `json:"Status"`       // Status true if successful, false if not
	SupportTitle string `json:"SupportTitle"` // SupportTitle Support title
	SupportURL   string `json:"SupportURL"`   // SupportURL Support URL
	Result       T      `json:"Result"`       // Optional, Result Result of the call
}

// AMPInstanceBase Base class for an AMP instance
type AMPInstanceBase struct {
	AMPBuild                 string                `json:"AMPBuild"`                 // AMPBuild The AMP build
	AMPVersion               string                `json:"AMPVersion"`               // AMPVersion The AMP version
	AutomaticUPnP            bool                  `json:"AutomaticUPnP"`            // AutomaticUPnP Whether to use automatic UPnP
	ContainerCPUs            float64               `json:"ContainerCPUs"`            // ContainerCPUs The container CPUs
	ContainerMemoryMB        int32                 `json:"ContainerMemoryMB"`        // ContainerMemoryMB The container memory in MB
	ContainerMemoryPolicy    ContainerMemoryPolicy `json:"ContainerMemoryPolicy"`    // ContainerMemoryPolicy The container memory policy
	ContainerSwapMB          int32                 `json:"ContainerSwapMB"`          // ContainerSwapMB The container swap in MB
	CreatedBy                uuid.UUID             `json:"CreatedBy"`                // CreatedBy The creator ID
	CustomMountBinds         map[string]string     `json:"CustomMountBinds"`         // CustomMountBinds The custom mount binds
	CustomPorts              []PortUsage           `json:"CustomPorts"`              // CustomPorts The custom ports
	Daemon                   bool                  `json:"Daemon"`                   // Daemon Whether the instance is a daemon
	DaemonAutostart          bool                  `json:"DaemonAutostart"`          // DaemonAutostart Whether the daemon should autostart
	DatastoreId              int32                 `json:"DatastoreId"`              // DatastoreId The datastore ID
	DeploymentArgs           map[string]string     `json:"DeploymentArgs"`           // DeploymentArgs The deployment arguments
	Description              string                `json:"Description"`              // Description The description
	DiskUsageMB              int32                 `json:"DiskUsageMB"`              // DiskUsageMB The disk usage in MB
	DisplayImageSource       string                `json:"DisplayImageSource"`       // DisplayImageSource The display image source
	DockerBaseReadOnly       bool                  `json:"DockerBaseReadOnly"`       // DockerBaseReadOnly Whether the Docker base is read-only
	ExcludeFromFirewall      bool                  `json:"ExcludeFromFirewall"`      // ExcludeFromFirewall Whether to exclude from the firewall
	ExtraContainerPackages   []string              `json:"ExtraContainerPackages"`   // ExtraContainerPackages The extra container packages
	ForceDocker              bool                  `json:"ForceDocker"`              // ForceDocker Whether to force Docker
	FriendlyName             string                `json:"FriendlyName"`             // FriendlyName The friendly name
	Group                    string                `json:"Group"`                    // Group The group
	IP                       string                `json:"IP"`                       // IP The IP
	InstanceID               uuid.UUID             `json:"InstanceID"`               // InstanceID The instance ID
	InstanceName             string                `json:"InstanceName"`             // InstanceName The instance name
	IsContainerInstance      bool                  `json:"IsContainerInstance"`      // IsContainerInstance Whether the instance is a container
	IsHTTPS                  bool                  `json:"IsHTTPS"`                  // IsHTTPS Whether the instance is HTTPS
	ManagementMode           ManagementModes       `json:"ManagementMode"`           // ManagementMode The management mode
	MatchVersion             bool                  `json:"MatchVersion"`             // MatchVersion Whether to match the version
	MetricsPublishingHMAC    string                `json:"MetricsPublishingHMAC"`    // MetricsPublishingHMAC The metrics publishing HMAC
	Module                   string                `json:"Module"`                   // Module The module
	ModuleDisplayName        string                `json:"ModuleDisplayName"`        // ModuleDisplayName The module display name
	OS                       SupportedOS           `json:"OS"`                       // OS The OS
	OverlayPath              string                `json:"OverlayPath"`              // OverlayPath The overlay path
	Path                     string                `json:"Path"`                     // Path The path
	PendingSettingChanges    map[string]string     `json:"PendingSettingChanges"`    // PendingSettingChanges The pending setting changes
	Plugins                  []string              `json:"Plugins"`                  // Plugins The plugins
	Port                     int32                 `json:"Port"`                     // Port The port
	PreviousBuild            string                `json:"PreviousBuild"`            // PreviousBuild The previous build
	PreviousVersion          string                `json:"PreviousVersion"`          // PreviousVersion The previous version
	ReleaseStream            AMPReleaseStreams     `json:"ReleaseStream"`            // ReleaseStream The release stream
	SpecificDockerImage      string                `json:"SpecificDockerImage"`      // SpecificDockerImage The specific Docker image
	Suspended                bool                  `json:"Suspended"`                // Suspended Whether the instance is suspended
	Tag                      string                `json:"Tag"`                      // Tag The tag
	Tags                     []string              `json:"Tags"`                     // Tags The tags
	TagsUsedForConfiguration bool                  `json:"TagsUsedForConfiguration"` // TagsUsedForConfiguration Whether tags are used for configuration
	TargetID                 uuid.UUID             `json:"TargetID"`                 // TargetID The target ID
	UseHostModeNetwork       bool                  `json:"UseHostModeNetwork"`       // UseHostModeNetwork Whether to use host mode networking
	User                     string                `json:"User"`                     // User The user
	WelcomeMessage           string                `json:"WelcomeMessage"`           // WelcomeMessage The welcome message
	LastReactivationAttempt  time.Time             `json:"LastReactivationAttempt"`  // Optional, LastReactivationAttempt The last reactivation attempt
}

// AMPReleaseStreams Represents the AMP release streams
type AMPReleaseStreams int

// AMPReleaseStreamsMap A map of AMPReleaseStreamss to their integer values
// AMPReleaseStreamsMapReverse A map of integer values to their AMPReleaseStreamss
var (
	AMPReleaseStreamsMap = map[string]int{
		"NotSpecified": 0,     // Not specified
		"LTS":          5,     // LTS
		"Mainline":     10,    // Mainline
		"Preview":      15,    // Preview
		"Development":  20,    // Development
		"FastTrack":    100,   // Fast track
		"Nightly":      1000,  // Nightly
		"Bleeding":     10000, // Bleeding
	}

	AMPReleaseStreamsMapReverse = map[int]string{
		0:     "NotSpecified",
		5:     "LTS",
		10:    "Mainline",
		15:    "Preview",
		20:    "Development",
		100:   "FastTrack",
		1000:  "Nightly",
		10000: "Bleeding",
	}
)

// String Returns the string representation of the AMPReleaseStreams
// Author: p0t4t0sandwich
func (e AMPReleaseStreams) String() string {
	if val, ok := AMPReleaseStreamsMapReverse[int(e)]; ok {
		return val
	}
	return "Undefined"
}

// APIMethodInfo Information about an API method
type APIMethodInfo struct {
	Consumes      []ScheduleTaskParameter `json:"Consumes"`      // Consumes The parameters
	Description   string                  `json:"Description"`   // Description The description
	DisplayFormat string                  `json:"DisplayFormat"` // DisplayFormat The display format
	Id            string                  `json:"Id"`            // Id The ID
	Name          string                  `json:"Name"`          // Name The name
}

// ApplicationSpec A specification for an application
type ApplicationSpec struct {
	Author             string            `json:"Author"`             // Author The author
	ContainerReason    string            `json:"ContainerReason"`    // ContainerReason The container reason
	ContainerSupport   ContainerSupport  `json:"ContainerSupport"`   // ContainerSupport The container support
	DeprecatedReason   string            `json:"DeprecatedReason"`   // DeprecatedReason The deprecated reason
	Description        string            `json:"Description"`        // Description The description
	DisplayImageSource string            `json:"DisplayImageSource"` // DisplayImageSource The display image source
	ExtraSetupStepsURI string            `json:"ExtraSetupStepsURI"` // ExtraSetupStepsURI The extra setup steps URI
	FriendlyName       string            `json:"FriendlyName"`       // FriendlyName The friendly name
	Id                 uuid.UUID         `json:"Id"`                 // Id The ID
	IsServiceSpec      bool              `json:"IsServiceSpec"`      // IsServiceSpec Whether the spec is a service spec
	ModuleName         string            `json:"ModuleName"`         // ModuleName The module name
	NoCommercialUsage  bool              `json:"NoCommercialUsage"`  // NoCommercialUsage Whether commercial usage is allowed
	Origin             string            `json:"Origin"`             // Origin The origin
	Settings           map[string]string `json:"Settings"`           // Settings The settings
	SupportedPlatforms SupportedOS       `json:"SupportedPlatforms"` // SupportedPlatforms The supported platforms
}

// ApplicationSpecSummary A summary of an application spec
type ApplicationSpecSummary struct {
	Author             string           `json:"Author"`             // Author The author
	ContainerReason    string           `json:"ContainerReason"`    // ContainerReason The container reason
	ContainerSupport   ContainerSupport `json:"ContainerSupport"`   // ContainerSupport The container support
	DeprecatedReason   string           `json:"DeprecatedReason"`   // DeprecatedReason The deprecated reason
	Description        string           `json:"Description"`        // Description The description
	DisplayImageSource string           `json:"DisplayImageSource"` // DisplayImageSource The display image source
	ExtraSetupStepsURI string           `json:"ExtraSetupStepsURI"` // ExtraSetupStepsURI The extra setup steps URI
	FriendlyName       string           `json:"FriendlyName"`       // FriendlyName The friendly name
	Id                 uuid.UUID        `json:"Id"`                 // Id The ID
	IsServiceSpec      bool             `json:"IsServiceSpec"`      // IsServiceSpec Whether the spec is a service spec
	NoCommercialUsage  bool             `json:"NoCommercialUsage"`  // NoCommercialUsage Whether commercial usage is allowed
	Origin             string           `json:"Origin"`             // Origin The origin
	SupportedPlatforms SupportedOS      `json:"SupportedPlatforms"` // SupportedPlatforms The supported platforms
}

// ApplicationState Represents the state of an instance's application
type ApplicationState int

// ApplicationStateMap A map of ApplicationStates to their integer values
// ApplicationStateMapReverse A map of integer values to their ApplicationStates
var (
	ApplicationStateMap = map[string]int{
		"Undefined":         -1,  // Undefined
		"Stopped":           0,   // Stopped
		"PreStart":          5,   // The server is performing some first-time-start configuration.
		"Configuring":       7,   // The server is performing some first-time-start configuration.
		"Starting":          10,  // Starting
		"Ready":             20,  // Ready
		"Restarting":        30,  // Server is in the middle of stopping, but once shutdown has finished it will automatically restart.
		"Stopping":          40,  // Stopping
		"PreparingForSleep": 45,  // Preparing for sleep
		"Sleeping":          50,  // The application should be able to be resumed quickly if using this state. Otherwise use Stopped.
		"Waiting":           60,  // The application is waiting for some external service/application to respond/become available.
		"Installing":        70,  // Installing
		"Updating":          75,  // Updating
		"AwaitingUserInput": 80,  // Used during installation, means that some user input is required to complete setup (authentication etc).
		"Failed":            100, // Failed
		"Suspended":         200, // Suspended
		"Maintainence":      250, // Maintainence
		"Indeterminate":     999, // The state is unknown, or doesn't apply (for modules that don't start an external process)
	}

	ApplicationStateMapReverse = map[int]string{
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

// String Returns the string representation of the ApplicationState
// Author: p0t4t0sandwich
func (e ApplicationState) String() string {
	if val, ok := ApplicationStateMapReverse[int(e)]; ok {
		return val
	}
	return "Undefined"
}

// Architecture Represents the architecture
type Architecture int

// ArchitectureMap A map of Architectures to their integer values
// ArchitectureMapReverse A map of integer values to their Architectures
var (
	ArchitectureMap = map[string]int{
		"Unknown": 0, // Unknown
		"x86_64":  1, // x86_64
		"aarch64": 2, // aarch64
		"All":     3, // All
	}

	ArchitectureMapReverse = map[int]string{
		0: "Unknown",
		1: "x86_64",
		2: "aarch64",
		3: "All",
	}
)

// String Returns the string representation of the Architecture
// Author: p0t4t0sandwich
func (e Architecture) String() string {
	if val, ok := ArchitectureMapReverse[int(e)]; ok {
		return val
	}
	return "Undefined"
}

// AuthenticationRequirement Represents the authentication requirement
type AuthenticationRequirement int

// AuthenticationRequirementMap A map of AuthenticationRequirements to their integer values
// AuthenticationRequirementMapReverse A map of integer values to their AuthenticationRequirements
var (
	AuthenticationRequirementMap = map[string]int{
		"None_":    0, // None
		"Username": 1, // Username
		"Password": 2, // Password
		"TOTP":     4, // TOTP
		"Passkeys": 8, // Passkeys
	}

	AuthenticationRequirementMapReverse = map[int]string{
		0: "None_",
		1: "Username",
		2: "Password",
		4: "TOTP",
		8: "Passkeys",
	}
)

// String Returns the string representation of the AuthenticationRequirement
// Author: p0t4t0sandwich
func (e AuthenticationRequirement) String() string {
	if val, ok := AuthenticationRequirementMapReverse[int(e)]; ok {
		return val
	}
	return "Undefined"
}

// AuthenticationResult Represents the authentication result
type AuthenticationResult int

// AuthenticationResultMap A map of AuthenticationResults to their integer values
// AuthenticationResultMapReverse A map of integer values to their AuthenticationResults
var (
	AuthenticationResultMap = map[string]int{
		"Failure":                0,   // Failure
		"TokenRejected":          1,   // Token rejected
		"FullLoginRequired":      2,   // Full login required
		"NoInstanceAccess":       5,   // No instance access
		"InstanceSuspended":      6,   // Instance suspended
		"Success":                10,  // Success
		"PasswordChangeRequired": 20,  // Password change required
		"AccountDisabled":        25,  // Account disabled
		"Ignored":                30,  // Ignored
		"TwoFactorChallenge":     40,  // Two-factor challenge
		"TwoFactorSetupRequired": 45,  // Two-factor setup required
		"TwoFactorFailed":        50,  // Two-factor failed
		"PassthruDisabled":       100, // Passthru disabled
		"PassthruRejected":       110, // Passthru rejected
		"LoginServerUnavailable": 500, // Login server unavailable
	}

	AuthenticationResultMapReverse = map[int]string{
		0:   "Failure",
		1:   "TokenRejected",
		2:   "FullLoginRequired",
		5:   "NoInstanceAccess",
		6:   "InstanceSuspended",
		10:  "Success",
		20:  "PasswordChangeRequired",
		25:  "AccountDisabled",
		30:  "Ignored",
		40:  "TwoFactorChallenge",
		45:  "TwoFactorSetupRequired",
		50:  "TwoFactorFailed",
		100: "PassthruDisabled",
		110: "PassthruRejected",
		500: "LoginServerUnavailable",
	}
)

// String Returns the string representation of the AuthenticationResult
// Author: p0t4t0sandwich
func (e AuthenticationResult) String() string {
	if val, ok := AuthenticationResultMapReverse[int(e)]; ok {
		return val
	}
	return "Undefined"
}

// AuthRoleSummary A summary of an authenticated role
type AuthRoleSummary struct {
	Description        string            `json:"Description"`        // Description The description
	DisableEdits       bool              `json:"DisableEdits"`       // DisableEdits Whether edits are disabled
	Hidden             bool              `json:"Hidden"`             // Hidden Whether the role is hidden
	ID                 uuid.UUID         `json:"ID"`                 // ID The ID
	IsCommonRole       bool              `json:"IsCommonRole"`       // IsCommonRole Whether the role is common
	IsDefault          bool              `json:"IsDefault"`          // IsDefault Whether the role is default
	IsInstanceSpecific bool              `json:"IsInstanceSpecific"` // IsInstanceSpecific Whether the role is instance specific
	Members            []AuthUserSummary `json:"Members"`            // Members The members
	Name               string            `json:"Name"`               // Name The name
	Permissions        []string          `json:"Permissions"`        // Permissions The permissions
}

// AuthUserSummary A summary of an authenticated user
type AuthUserSummary struct {
	ID   uuid.UUID `json:"ID"`   // ID The ID
	Name string    `json:"Name"` // Name The name
}

// BackupManifest A backup manifest
type BackupManifest struct {
	CreatedAutomatically bool        `json:"CreatedAutomatically"` // CreatedAutomatically Whether the backup was created automatically
	Description          string      `json:"Description"`          // Description The description
	HashSHA1             string      `json:"HashSHA1"`             // HashSHA1 The SHA1 hash
	Id                   uuid.UUID   `json:"Id"`                   // Id The ID
	META                 string      `json:"META"`                 // META The meta
	ModuleName           string      `json:"ModuleName"`           // ModuleName The module name
	Name                 string      `json:"Name"`                 // Name The name
	RemoteStoreId        string      `json:"RemoteStoreId"`        // RemoteStoreId The remote store ID
	SourceOS             SupportedOS `json:"SourceOS"`             // SourceOS The source OS
	Sticky               bool        `json:"Sticky"`               // Sticky Whether the backup is sticky
	StoredLocally        bool        `json:"StoredLocally"`        // StoredLocally Whether the backup is stored locally
	StoredRemotely       bool        `json:"StoredRemotely"`       // StoredRemotely Whether the backup is stored remotely
	TakenBy              string      `json:"TakenBy"`              // TakenBy The user who took the backup
	Timestamp            time.Time   `json:"Timestamp"`            // Timestamp The timestamp
	TotalSizeBytes       int64       `json:"TotalSizeBytes"`       // TotalSizeBytes The total size in bytes
	ParentManifest       uuid.UUID   `json:"ParentManifest"`       // Optional, ParentManifest The parent manifest
}

// Branding Branding information
type Branding struct {
	BackgroundURL        string `json:"BackgroundURL"`        // BackgroundURL The background URL
	BrandingMessage      string `json:"BrandingMessage"`      // BrandingMessage The branding message
	CompanyName          string `json:"CompanyName"`          // CompanyName The company name
	DisplayBranding      bool   `json:"DisplayBranding"`      // DisplayBranding Whether to display branding
	ForgotPasswordURL    string `json:"ForgotPasswordURL"`    // ForgotPasswordURL The forgot password URL
	LogoURL              string `json:"LogoURL"`              // LogoURL The logo URL
	PageTitle            string `json:"PageTitle"`            // PageTitle The page title
	ShortBrandingMessage string `json:"ShortBrandingMessage"` // ShortBrandingMessage The short branding message
	SplashFrameURL       string `json:"SplashFrameURL"`       // SplashFrameURL The splash frame URL
	SubmitTicketURL      string `json:"SubmitTicketURL"`      // SubmitTicketURL The submit ticket URL
	SupportText          string `json:"SupportText"`          // SupportText The support text
	SupportURL           string `json:"SupportURL"`           // SupportURL The support URL
	URL                  string `json:"URL"`                  // URL The URL
	WelcomeMessage       string `json:"WelcomeMessage"`       // WelcomeMessage The welcome message
}

// BrandingSettings Branding information
type BrandingSettings struct {
	BackgroundURL        string `json:"BackgroundURL"`        // BackgroundURL The background URL
	BrandingMessage      string `json:"BrandingMessage"`      // BrandingMessage The branding message
	CompanyName          string `json:"CompanyName"`          // CompanyName The company name
	DisplayBranding      bool   `json:"DisplayBranding"`      // DisplayBranding Whether to display branding
	ForgotPasswordURL    string `json:"ForgotPasswordURL"`    // ForgotPasswordURL The forgot password URL
	LogoURL              string `json:"LogoURL"`              // LogoURL The logo URL
	PageTitle            string `json:"PageTitle"`            // PageTitle The page title
	ShortBrandingMessage string `json:"ShortBrandingMessage"` // ShortBrandingMessage The short branding message
	SplashFrameURL       string `json:"SplashFrameURL"`       // SplashFrameURL The splash frame URL
	SubmitTicketURL      string `json:"SubmitTicketURL"`      // SubmitTicketURL The submit ticket URL
	SupportText          string `json:"SupportText"`          // SupportText The support text
	SupportURL           string `json:"SupportURL"`           // SupportURL The support URL
	URL                  string `json:"URL"`                  // URL The URL
	WelcomeMessage       string `json:"WelcomeMessage"`       // WelcomeMessage The welcome message
}

// ConsoleEntry Type for Core.GetUpdates#ConsoleEntries
type ConsoleEntry struct {
	Contents  string `json:"Contents"`  // Contents The contents of the console entry
	Source    string `json:"Source"`    // Source The source of the console entry
	SourceId  string `json:"SourceId"`  // SourceId The ID of the message's source, eg from a player/user
	Timestamp string `json:"Timestamp"` // Timestamp The timestamp of the console entry
	Type      string `json:"Type"`      // Type The type of the console entry
}

// ContainerMemoryPolicy Represents the container memory policy
type ContainerMemoryPolicy int

// ContainerMemoryPolicyMap A map of ContainerMemoryPolicys to their integer values
// ContainerMemoryPolicyMapReverse A map of integer values to their ContainerMemoryPolicys
var (
	ContainerMemoryPolicyMap = map[string]int{
		"NotSpecified": 0,   // Not specified
		"Reserve":      100, // Reserve
		"Restrict":     200, // Restrict
	}

	ContainerMemoryPolicyMapReverse = map[int]string{
		0:   "NotSpecified",
		100: "Reserve",
		200: "Restrict",
	}
)

// String Returns the string representation of the ContainerMemoryPolicy
// Author: p0t4t0sandwich
func (e ContainerMemoryPolicy) String() string {
	if val, ok := ContainerMemoryPolicyMapReverse[int(e)]; ok {
		return val
	}
	return "Undefined"
}

// ContainerSupport Represents the container support
type ContainerSupport int

// ContainerSupportMap A map of ContainerSupports to their integer values
// ContainerSupportMapReverse A map of integer values to their ContainerSupports
var (
	ContainerSupportMap = map[string]int{
		"NoPreference":         0,  // No preference
		"NotSupported":         1,  // Not supported
		"SupportedOnLinux":     2,  // Supported on Linux
		"SupportedOnWindows":   4,  // Supported on Windows
		"Supported":            6,  // Supported
		"RecommendedOnLinux":   8,  // Recommended on Linux
		"RecommendedOnWindows": 16, // Recommended on Windows
		"Recommended":          24, // Recommended
		"RequiredOnLinux":      32, // Required on Linux
		"RequiredOnWindows":    64, // Required on Windows
		"Required":             96, // Required
	}

	ContainerSupportMapReverse = map[int]string{
		0:  "NoPreference",
		1:  "NotSupported",
		2:  "SupportedOnLinux",
		4:  "SupportedOnWindows",
		6:  "Supported",
		8:  "RecommendedOnLinux",
		16: "RecommendedOnWindows",
		24: "Recommended",
		32: "RequiredOnLinux",
		64: "RequiredOnWindows",
		96: "Required",
	}
)

// String Returns the string representation of the ContainerSupport
// Author: p0t4t0sandwich
func (e ContainerSupport) String() string {
	if val, ok := ContainerSupportMapReverse[int(e)]; ok {
		return val
	}
	return "Undefined"
}

// DatastoreSummary A datastore object
type DatastoreSummary struct {
	FriendlyName string `json:"FriendlyName"` // FriendlyName The friendly name
	Id           int32  `json:"Id"`           // Id The datastore ID
}

// DeploymentTemplate A deployment template object
type DeploymentTemplate struct {
	CloneRoleIntoUser  bool              `json:"CloneRoleIntoUser"`  // CloneRoleIntoUser Whether to clone the role into the user
	Description        string            `json:"Description"`        // Description The description
	Id                 int32             `json:"Id"`                 // Id The ID
	MatchDatastoreTags bool              `json:"MatchDatastoreTags"` // MatchDatastoreTags Whether to match datastore tags
	Module             string            `json:"Module"`             // Module The module
	Name               string            `json:"Name"`               // Name The name
	SettingMappings    map[string]string `json:"SettingMappings"`    // SettingMappings The setting mappings
	StartOnBoot        bool              `json:"StartOnBoot"`        // StartOnBoot Whether to start on boot
	Tags               []string          `json:"Tags"`               // Tags The tags
	TemplateBaseApp    string            `json:"TemplateBaseApp"`    // TemplateBaseApp The template base app
	ZipOverlayPath     string            `json:"ZipOverlayPath"`     // ZipOverlayPath The zip overlay path
	TemplateInstance   uuid.UUID         `json:"TemplateInstance"`   // Optional, TemplateInstance The template instance
	TemplateRole       uuid.UUID         `json:"TemplateRole"`       // Optional, TemplateRole The template role
}

// DirectoryListing A file directory object
type DirectoryListing struct {
	Created               time.Time `json:"Created"`               // Created The creation date
	Filename              string    `json:"Filename"`              // Filename The filename
	IsArchive             bool      `json:"IsArchive"`             // IsArchive Whether the file is an archive
	IsDirectory           bool      `json:"IsDirectory"`           // IsDirectory Whether the file is a directory
	IsDownloadable        bool      `json:"IsDownloadable"`        // IsDownloadable Whether the file is downloadable
	IsEditable            bool      `json:"IsEditable"`            // IsEditable Whether the file is editable
	IsExcludedFromBackups bool      `json:"IsExcludedFromBackups"` // IsExcludedFromBackups Whether the file is excluded from backups
	IsVirtualDirectory    bool      `json:"IsVirtualDirectory"`    // IsVirtualDirectory Whether the file is a virtual directory
	Modified              time.Time `json:"Modified"`              // Modified The modification date
	SizeBytes             int64     `json:"SizeBytes"`             // SizeBytes The size in bytes
}

// EndpointInfo An application endpoint object
type EndpointInfo struct {
	DisplayName string `json:"DisplayName"` // DisplayName The display name of the endpoint
	Endpoint    string `json:"Endpoint"`    // Endpoint The endpoint address
	Uri         string `json:"Uri"`         // Uri The URI of the endpoint
}

// ErrorResponse An error object
type ErrorResponse struct {
	Message    string `json:"Message"`    // Message The error message
	StackTrace string `json:"StackTrace"` // StackTrace The stack trace of the error
	Title      string `json:"Title"`      // Title The title of the error
}

// FileChunkData A chunk of file data
type FileChunkData struct {
	Base64Data  string `json:"Base64Data"`  // Base64Data The base64 data
	BytesLength int32  `json:"BytesLength"` // BytesLength The length of the data in bytes
}

// IADSInstance An ADS instance object
type IADSInstance struct {
	AvailableIPs        []string            `json:"AvailableIPs"`        // AvailableIPs Available IPs
	AvailableInstances  []InstanceSummary   `json:"AvailableInstances"`  // AvailableInstances Available instances
	CanCreate           bool                `json:"CanCreate"`           // CanCreate Whether the instance can be created
	CreatesInContainers bool                `json:"CreatesInContainers"` // CreatesInContainers Whether the instance creates in containers
	Datastores          []DatastoreSummary  `json:"Datastores"`          // Datastores The datastores
	Description         string              `json:"Description"`         // Description The description
	Disabled            bool                `json:"Disabled"`            // Disabled Whether the instance is disabled
	FriendlyName        string              `json:"FriendlyName"`        // FriendlyName The friendly name
	Id                  int32               `json:"Id"`                  // Id The ID
	InstanceId          uuid.UUID           `json:"InstanceId"`          // InstanceId The instance ID
	IsRemote            bool                `json:"IsRemote"`            // IsRemote Whether the instance is remote
	LastUpdated         string              `json:"LastUpdated"`         // LastUpdated The last updated date
	Platform            IPlatformInfo       `json:"Platform"`            // Platform The platform information object
	State               RemoteInstanceState `json:"State"`               // State The state
	StateReason         string              `json:"StateReason"`         // StateReason The state reason
	Tags                []string            `json:"Tags"`                // Tags The tags
	TagsList            string              `json:"TagsList"`            // TagsList The tags list
	URL                 string              `json:"URL"`                 // URL The URL
	Fitness             ProvisionFitness    `json:"Fitness"`             // Optional, Fitness The fitness information object
}

// IAuditLogEntry An audit log entry
type IAuditLogEntry struct {
	Category  string    `json:"Category"`  // Category The category
	Id        int32     `json:"Id"`        // Id The ID
	Message   string    `json:"Message"`   // Message The message
	Source    string    `json:"Source"`    // Source The source
	Timestamp time.Time `json:"Timestamp"` // Timestamp The timestamp
	User      string    `json:"User"`      // User The user
}

// InlineActionAttribute An inline action object
type InlineActionAttribute struct {
	Argument     string `json:"Argument"`     // Argument The argument
	Caption      string `json:"Caption"`      // Caption The caption
	IsClientSide bool   `json:"IsClientSide"` // IsClientSide Whether the action is client-side
	Method       string `json:"Method"`       // Method The method
	Module       string `json:"Module"`       // Module The module
}

// InstanceDatastore A datastore object
type InstanceDatastore struct {
	Active         bool     `json:"Active"`         // Active Whether the datastore is active
	CurrentUsageMB int64    `json:"CurrentUsageMB"` // CurrentUsageMB The current usage in MB
	Description    string   `json:"Description"`    // Description The description
	Directory      string   `json:"Directory"`      // Directory The directory
	FriendlyName   string   `json:"FriendlyName"`   // FriendlyName The friendly name
	Id             int32    `json:"Id"`             // Id The datastore ID
	InstanceLimit  int32    `json:"InstanceLimit"`  // InstanceLimit The instance limit
	IsInternal     bool     `json:"IsInternal"`     // IsInternal Whether the datastore is internal
	Priority       int32    `json:"Priority"`       // Priority The priority
	SanitisedName  string   `json:"SanitisedName"`  // SanitisedName The sanitised name
	SoftLimitMB    int64    `json:"SoftLimitMB"`    // SoftLimitMB The soft limit in MB
	Tags           []string `json:"Tags"`           // Tags The tags
}

// InstanceStatus An instance status object
type InstanceStatus struct {
	InstanceID uuid.UUID `json:"InstanceID"` // InstanceID The instance ID
	Running    bool      `json:"Running"`    // Running Whether the instance is running
}

// InstanceSummary An instance object
type InstanceSummary struct {
	AMPVersion            string                `json:"AMPVersion"`            // AMPVersion The AMP version
	AppState              ApplicationState      `json:"AppState"`              // AppState The application state
	ApplicationEndpoints  []EndpointInfo        `json:"ApplicationEndpoints"`  // ApplicationEndpoints The application endpoints
	ContainerCPUs         float64               `json:"ContainerCPUs"`         // ContainerCPUs The container CPUs
	ContainerMemoryMB     int32                 `json:"ContainerMemoryMB"`     // ContainerMemoryMB The container memory in MB
	ContainerMemoryPolicy ContainerMemoryPolicy `json:"ContainerMemoryPolicy"` // ContainerMemoryPolicy The container memory policy
	ContainerSwapMB       int32                 `json:"ContainerSwapMB"`       // ContainerSwapMB The container swap in MB
	Daemon                bool                  `json:"Daemon"`                // Daemon Whether the instance is a daemon
	DaemonAutostart       bool                  `json:"DaemonAutostart"`       // DaemonAutostart Whether the instance daemon autostarts
	DeploymentArgs        map[string]string     `json:"DeploymentArgs"`        // DeploymentArgs The deployment arguments
	Description           string                `json:"Description"`           // Description The description
	DiskUsageMB           int32                 `json:"DiskUsageMB"`           // DiskUsageMB The disk usage in MB
	DisplayImageSource    string                `json:"DisplayImageSource"`    // DisplayImageSource The display image source
	ExcludeFromFirewall   bool                  `json:"ExcludeFromFirewall"`   // ExcludeFromFirewall Whether the instance is excluded from the firewall
	FriendlyName          string                `json:"FriendlyName"`          // FriendlyName The friendly name
	IP                    string                `json:"IP"`                    // IP The IP address
	InstanceID            uuid.UUID             `json:"InstanceID"`            // InstanceID The instance ID
	InstanceName          string                `json:"InstanceName"`          // InstanceName The instance name
	IsContainerInstance   bool                  `json:"IsContainerInstance"`   // IsContainerInstance Whether the instance is a container instance
	IsHTTPS               bool                  `json:"IsHTTPS"`               // IsHTTPS Whether HTTPS is enabled
	ManagementMode        ManagementModes       `json:"ManagementMode"`        // ManagementMode The management mode
	Metrics               map[string]MetricInfo `json:"Metrics"`               // Metrics The metrics
	Module                string                `json:"Module"`                // Module The module
	ModuleDisplayName     string                `json:"ModuleDisplayName"`     // ModuleDisplayName The module display name
	Port                  int32                 `json:"Port"`                  // Port The port
	ReleaseStream         AMPReleaseStreams     `json:"ReleaseStream"`         // ReleaseStream The release stream
	Running               bool                  `json:"Running"`               // Running Whether the instance is running
	SpecificDockerImage   string                `json:"SpecificDockerImage"`   // SpecificDockerImage The specific Docker image
	Suspended             bool                  `json:"Suspended"`             // Suspended Whether the instance is suspended
	Tags                  []string              `json:"Tags"`                  // Tags The tags
	TargetID              uuid.UUID             `json:"TargetID"`              // TargetID The target ID
	UseHostModeNetwork    bool                  `json:"UseHostModeNetwork"`    // UseHostModeNetwork Whether the container uses host mode network
	WelcomeMessage        string                `json:"WelcomeMessage"`        // WelcomeMessage The instance's welcome message
}

// IPermissionsTreeNode A permissions tree node
type IPermissionsTreeNode struct {
	Children    []IPermissionsTreeNode `json:"Children"`    // Children The children
	Description string                 `json:"Description"` // Description The description
	DisplayName string                 `json:"DisplayName"` // DisplayName The display name
	Name        string                 `json:"Name"`        // Name The name
	Node        string                 `json:"Node"`        // Node The node
}

// IPlatformInfo Platform information object
type IPlatformInfo struct {
	CPUInfo                 ProcessorInfo      `json:"CPUInfo"`                 // CPUInfo The CPU information object
	DockerNetworkIsHostMode bool               `json:"DockerNetworkIsHostMode"` // DockerNetworkIsHostMode Whether the Docker network is in host mode
	InstalledRAMMB          int32              `json:"InstalledRAMMB"`          // InstalledRAMMB The installed RAM in MB
	OS                      SupportedOS        `json:"OS"`                      // OS The OS
	PlatformName            string             `json:"PlatformName"`            // PlatformName The platform name
	SystemType              Architecture       `json:"SystemType"`              // SystemType The system type
	Virtualization          VirtualizationType `json:"Virtualization"`          // Virtualization The virtualization type
}

// LicenceInfo A struct to represent the object returned by Core#ActivateAMPLicence(Guid, Boolean)
type LicenceInfo struct {
	Expires     string    `json:"Expires"`     // Expires The expiry date
	Grade       uuid.UUID `json:"Grade"`       // Grade The grade
	GradeName   string    `json:"GradeName"`   // GradeName The grade name
	LicenceKey  uuid.UUID `json:"LicenceKey"`  // LicenceKey The licence key
	Product     uuid.UUID `json:"Product"`     // Product The product
	ProductName string    `json:"ProductName"` // ProductName The product name
	Usage       int32     `json:"Usage"`       // Usage The usage
}

// ListeningPortSummary A listening port object
type ListeningPortSummary struct {
	IsDelayedOpen bool         `json:"IsDelayedOpen"` // IsDelayedOpen Whether the port is delayed open
	Listening     bool         `json:"Listening"`     // Listening Whether the port is listening
	Name          string       `json:"Name"`          // Name The name
	Port          int32        `json:"Port"`          // Port The port
	Protocol      PortProtocol `json:"Protocol"`      // Protocol The protocol
	Required      bool         `json:"Required"`      // Required Whether the port is required
}

// LocalAMPInstance A local AMP instance object
type LocalAMPInstance struct {
	AMPBuild                 string                `json:"AMPBuild"`                 // AMPBuild The AMP build
	AMPVersion               string                `json:"AMPVersion"`               // AMPVersion The AMP version
	AutomaticUPnP            bool                  `json:"AutomaticUPnP"`            // AutomaticUPnP Whether to use automatic UPnP
	ContainerCPUs            float64               `json:"ContainerCPUs"`            // ContainerCPUs The container CPUs
	ContainerMemoryMB        int32                 `json:"ContainerMemoryMB"`        // ContainerMemoryMB The container memory in MB
	ContainerMemoryPolicy    ContainerMemoryPolicy `json:"ContainerMemoryPolicy"`    // ContainerMemoryPolicy The container memory policy
	ContainerSwapMB          int32                 `json:"ContainerSwapMB"`          // ContainerSwapMB The container swap in MB
	CreatedBy                uuid.UUID             `json:"CreatedBy"`                // CreatedBy The creator ID
	CustomMountBinds         map[string]string     `json:"CustomMountBinds"`         // CustomMountBinds The custom mount binds
	CustomPorts              []PortUsage           `json:"CustomPorts"`              // CustomPorts The custom ports
	Daemon                   bool                  `json:"Daemon"`                   // Daemon Whether the instance is a daemon
	DaemonAutostart          bool                  `json:"DaemonAutostart"`          // DaemonAutostart Whether the daemon should autostart
	DatastoreId              int32                 `json:"DatastoreId"`              // DatastoreId The datastore ID
	DeploymentArgs           map[string]string     `json:"DeploymentArgs"`           // DeploymentArgs The deployment arguments
	Description              string                `json:"Description"`              // Description The description
	DiskUsageMB              int32                 `json:"DiskUsageMB"`              // DiskUsageMB The disk usage in MB
	DisplayImageSource       string                `json:"DisplayImageSource"`       // DisplayImageSource The display image source
	DockerBaseReadOnly       bool                  `json:"DockerBaseReadOnly"`       // DockerBaseReadOnly Whether the Docker base is read-only
	ExcludeFromFirewall      bool                  `json:"ExcludeFromFirewall"`      // ExcludeFromFirewall Whether to exclude from the firewall
	ExtraContainerPackages   []string              `json:"ExtraContainerPackages"`   // ExtraContainerPackages The extra container packages
	ForceDocker              bool                  `json:"ForceDocker"`              // ForceDocker Whether to force Docker
	FriendlyName             string                `json:"FriendlyName"`             // FriendlyName The friendly name
	Group                    string                `json:"Group"`                    // Group The group
	HasOverlayApplied        bool                  `json:"HasOverlayApplied"`        // HasOverlayApplied Whether the instance has an overlay applied
	IP                       string                `json:"IP"`                       // IP The IP
	InstanceID               uuid.UUID             `json:"InstanceID"`               // InstanceID The instance ID
	InstanceName             string                `json:"InstanceName"`             // InstanceName The instance name
	IsContainerInstance      bool                  `json:"IsContainerInstance"`      // IsContainerInstance Whether the instance is a container
	IsDaemonUserManaged      bool                  `json:"IsDaemonUserManaged"`      // IsDaemonUserManaged Whether the instance is a daemon user managed
	IsHTTPS                  bool                  `json:"IsHTTPS"`                  // IsHTTPS Whether the instance is HTTPS
	IsSharedInstance         bool                  `json:"IsSharedInstance"`         // IsSharedInstance Whether the instance is a shared instance
	ManagementMode           ManagementModes       `json:"ManagementMode"`           // ManagementMode The management mode
	MatchVersion             bool                  `json:"MatchVersion"`             // MatchVersion Whether to match the version
	MetricsPublishingHMAC    string                `json:"MetricsPublishingHMAC"`    // MetricsPublishingHMAC The metrics publishing HMAC
	Module                   string                `json:"Module"`                   // Module The module
	ModuleDisplayName        string                `json:"ModuleDisplayName"`        // ModuleDisplayName The module display name
	OS                       SupportedOS           `json:"OS"`                       // OS The OS
	OverlayPath              string                `json:"OverlayPath"`              // OverlayPath The overlay path
	OverlayURL               string                `json:"OverlayURL"`               // OverlayURL The overlay URL
	Path                     string                `json:"Path"`                     // Path The path
	PendingSettingChanges    map[string]string     `json:"PendingSettingChanges"`    // PendingSettingChanges The pending setting changes
	Plugins                  []string              `json:"Plugins"`                  // Plugins The plugins
	Port                     int32                 `json:"Port"`                     // Port The port
	PreviousBuild            string                `json:"PreviousBuild"`            // PreviousBuild The previous build
	PreviousVersion          string                `json:"PreviousVersion"`          // PreviousVersion The previous version
	ReleaseStream            AMPReleaseStreams     `json:"ReleaseStream"`            // ReleaseStream The release stream
	SpecificDockerImage      string                `json:"SpecificDockerImage"`      // SpecificDockerImage The specific Docker image
	Suspended                bool                  `json:"Suspended"`                // Suspended Whether the instance is suspended
	Tag                      string                `json:"Tag"`                      // Tag The tag
	Tags                     []string              `json:"Tags"`                     // Tags The tags
	TagsUsedForConfiguration bool                  `json:"TagsUsedForConfiguration"` // TagsUsedForConfiguration Whether tags are used for configuration
	TargetID                 uuid.UUID             `json:"TargetID"`                 // TargetID The target ID
	UseHostModeNetwork       bool                  `json:"UseHostModeNetwork"`       // UseHostModeNetwork Whether to use host mode networking
	User                     string                `json:"User"`                     // User The user
	WelcomeMessage           string                `json:"WelcomeMessage"`           // WelcomeMessage The welcome message
	LastReactivationAttempt  time.Time             `json:"LastReactivationAttempt"`  // Optional, LastReactivationAttempt The last reactivation attempt
}

// LoginResponse Type for the result of Core.Login
type LoginResponse struct {
	Permissions     []string             `json:"permissions"`     // permissions The permissions
	RememberMeToken string               `json:"rememberMeToken"` // rememberMeToken The remember me token
	Result          AuthenticationResult `json:"result"`          // result The result
	ResultReason    string               `json:"resultReason"`    // resultReason The result reason
	SessionID       string               `json:"sessionID"`       // sessionID The session ID
	Success         bool                 `json:"success"`         // success Whether the login was successful
	UserInfo        UserInfoSummary      `json:"userInfo"`        // userInfo The user info
}

// ManagementModes Represents the management modes
type ManagementModes int

// ManagementModesMap A map of ManagementModess to their integer values
// ManagementModesMapReverse A map of integer values to their ManagementModess
var (
	ManagementModesMap = map[string]int{
		"Standalone": 0,  // Standalone
		"ViaADS":     10, // Via ADS
	}

	ManagementModesMapReverse = map[int]string{
		0:  "Standalone",
		10: "ViaADS",
	}
)

// String Returns the string representation of the ManagementModes
// Author: p0t4t0sandwich
func (e ManagementModes) String() string {
	if val, ok := ManagementModesMapReverse[int(e)]; ok {
		return val
	}
	return "Undefined"
}

// MethodInfoSummary A summary of a method
type MethodInfoSummary struct {
	Description    string                   `json:"Description"`    // Description The description
	IsComplexType  bool                     `json:"IsComplexType"`  // IsComplexType Whether the method is a complex type
	Parameters     []MethodParameterSummary `json:"Parameters"`     // Parameters The parameters
	ReturnTypeName string                   `json:"ReturnTypeName"` // ReturnTypeName The return type name
	Returns        string                   `json:"Returns"`        // Optional, Returns The methods return value (deprecated)
}

// MethodParameterSummary A summary of a method parameter
type MethodParameterSummary struct {
	Description     string         `json:"Description"`     // Description The description
	Name            string         `json:"Name"`            // Name The name
	Optional        bool           `json:"Optional"`        // Optional Whether the parameter is optional
	TypeName        string         `json:"TypeName"`        // TypeName The type name
	ParamEnumValues map[string]any `json:"ParamEnumValues"` // Optional, ParamEnumValues The parameter enum values
}

// MetricInfo A metric info object
type MetricInfo struct {
	Color     string `json:"Color"`     // Color The color
	Color2    string `json:"Color2"`    // Color2 The second color
	Color3    string `json:"Color3"`    // Color3 The third color
	MaxValue  int32  `json:"MaxValue"`  // MaxValue The maximum value
	Percent   int32  `json:"Percent"`   // Percent The percentage
	RawValue  int32  `json:"RawValue"`  // RawValue The raw value
	ShortName string `json:"ShortName"` // ShortName The short name
	Units     string `json:"Units"`     // Units The units
}

// ModuleInfo A struct to represent the object returned by the Core.GetModuleInfo() method
type ModuleInfo struct {
	AMPBuild         string           `json:"AMPBuild"`         // AMPBuild The AMP build
	AMPVersion       string           `json:"AMPVersion"`       // AMPVersion The AMP version
	APIVersion       string           `json:"APIVersion"`       // APIVersion The API version
	AllowRememberMe  bool             `json:"AllowRememberMe"`  // AllowRememberMe Whether remember me is allowed
	Analytics        bool             `json:"Analytics"`        // Analytics Whether analytics are enabled
	AppName          string           `json:"AppName"`          // AppName The application name
	Author           string           `json:"Author"`           // Author The author of the module
	BasePort         int32            `json:"BasePort"`         // BasePort The base port
	Branding         BrandingSettings `json:"Branding"`         // Branding The branding object
	BuildSpec        string           `json:"BuildSpec"`        // BuildSpec The build spec
	DisplayBaseURI   string           `json:"DisplayBaseURI"`   // DisplayBaseURI The display base URI
	EndpointURI      string           `json:"EndpointURI"`      // EndpointURI The endpoint URI
	FeatureSet       []string         `json:"FeatureSet"`       // FeatureSet The feature set
	FriendlyName     string           `json:"FriendlyName"`     // FriendlyName The friendly name
	InstanceId       uuid.UUID        `json:"InstanceId"`       // InstanceId The instance ID
	InstanceName     string           `json:"InstanceName"`     // InstanceName The instance name
	IsRemoteInstance bool             `json:"IsRemoteInstance"` // IsRemoteInstance Whether the instance is remote
	LoadedPlugins    []string         `json:"LoadedPlugins"`    // LoadedPlugins The loaded plugins
	ModuleName       string           `json:"ModuleName"`       // ModuleName The module name
	Name             string           `json:"Name"`             // Name The name of the module
	PrimaryEndpoint  string           `json:"PrimaryEndpoint"`  // PrimaryEndpoint The primary endpoint
	RequiresFullLoad bool             `json:"RequiresFullLoad"` // RequiresFullLoad Whether the module requires a full load
	SupportsSleep    bool             `json:"SupportsSleep"`    // SupportsSleep Whether the module supports sleep mode
	Timestamp        string           `json:"Timestamp"`        // Timestamp The timestamp
	ToolsVersion     string           `json:"ToolsVersion"`     // ToolsVersion The tools version
	VersionCodename  string           `json:"VersionCodename"`  // VersionCodename The version codename
}

// OPEntry An OP entry
type OPEntry struct {
	Level int32  `json:"Level"` // Level The level
	Name  string `json:"Name"`  // Name The name
	UUID  string `json:"UUID"`  // UUID The UUID
}

// PortProtocol Represents the port protocol
type PortProtocol int

// PortProtocolMap A map of PortProtocols to their integer values
// PortProtocolMapReverse A map of integer values to their PortProtocols
var (
	PortProtocolMap = map[string]int{
		"TCP":  0, // TCP
		"UDP":  1, // UDP
		"Both": 2, // Both
	}

	PortProtocolMapReverse = map[int]string{
		0: "TCP",
		1: "UDP",
		2: "Both",
	}
)

// String Returns the string representation of the PortProtocol
// Author: p0t4t0sandwich
func (e PortProtocol) String() string {
	if val, ok := PortProtocolMapReverse[int(e)]; ok {
		return val
	}
	return "Undefined"
}

// PortSummary A port object
type PortSummary struct {
	IsDelayedOpen bool         `json:"IsDelayedOpen"` // IsDelayedOpen Whether the port is delayed open
	Name          string       `json:"Name"`          // Name The name
	Port          int32        `json:"Port"`          // Port The port
	Protocol      PortProtocol `json:"Protocol"`      // Protocol The protocol
	Required      bool         `json:"Required"`      // Required Whether the port is required
}

// PortUsage A port usage object
type PortUsage struct {
	Description       string       `json:"Description"`       // Description The description
	IsUserDefined     bool         `json:"IsUserDefined"`     // IsUserDefined Whether the port is user-defined
	PortNumber        int32        `json:"PortNumber"`        // PortNumber The port number
	Protocol          PortProtocol `json:"Protocol"`          // Protocol The protocol
	ProvisionNodeName string       `json:"ProvisionNodeName"` // ProvisionNodeName The provision node name
	Range             int32        `json:"Range"`             // Range The range
	Verified          bool         `json:"Verified"`          // Verified Whether the port is verified
}

// PostCreateAppActions Represents the post create app actions
type PostCreateAppActions int

// PostCreateAppActionsMap A map of PostCreateAppActionss to their integer values
// PostCreateAppActionsMapReverse A map of integer values to their PostCreateAppActionss
var (
	PostCreateAppActionsMap = map[string]int{
		"DoNothing":            0, // Do nothing
		"UpdateOnce":           1, // Update once
		"UpdateAlways":         2, // Update always
		"UpdateAndStartOnce":   3, // Update and start once
		"UpdateAndStartAlways": 4, // Update and start always
		"StartAlways":          5, // Start always
	}

	PostCreateAppActionsMapReverse = map[int]string{
		0: "DoNothing",
		1: "UpdateOnce",
		2: "UpdateAlways",
		3: "UpdateAndStartOnce",
		4: "UpdateAndStartAlways",
		5: "StartAlways",
	}
)

// String Returns the string representation of the PostCreateAppActions
// Author: p0t4t0sandwich
func (e PostCreateAppActions) String() string {
	if val, ok := PostCreateAppActionsMapReverse[int(e)]; ok {
		return val
	}
	return "Undefined"
}

// ProcessorInfo CPU information object
type ProcessorInfo struct {
	Cores        int32  `json:"Cores"`        // Cores Number of CPU cores
	ModelName    string `json:"ModelName"`    // ModelName CPU model name
	Sockets      int32  `json:"Sockets"`      // Sockets Number of CPU sockets
	Threads      int32  `json:"Threads"`      // Threads Number of CPU threads
	TotalCores   int32  `json:"TotalCores"`   // TotalCores Total number of CPU cores
	TotalThreads int32  `json:"TotalThreads"` // TotalThreads Total number of CPU threads
	Vendor       string `json:"Vendor"`       // Vendor CPU vendor
}

// ProvisionFitness Fitness information object
type ProvisionFitness struct {
	Available              bool    `json:"Available"`              // Available Availability
	CPUServiceRatio        float64 `json:"CPUServiceRatio"`        // CPUServiceRatio CPU service ratio
	FreeDiskMB             int64   `json:"FreeDiskMB"`             // FreeDiskMB Unallocated disk space in MB
	FreeRAMMB              int32   `json:"FreeRAMMB"`              // FreeRAMMB Unallocated RAM in MB
	LoadAvg                float64 `json:"LoadAvg"`                // LoadAvg Load average
	RemainingInstanceSlots int32   `json:"RemainingInstanceSlots"` // RemainingInstanceSlots Remaining instance slots
	Score                  float64 `json:"Score"`                  // Score Fitness score
	ThreadQueueLength      int32   `json:"ThreadQueueLength"`      // ThreadQueueLength Thread queue length
	TotalServices          int32   `json:"TotalServices"`          // TotalServices Service count
}

// ProvisionSettingInfo A provision setting object
type ProvisionSettingInfo struct {
	CustomFieldType string `json:"CustomFieldType"` // CustomFieldType The custom field type
	DefaultValue    any    `json:"DefaultValue"`    // DefaultValue The default value
	Description     string `json:"Description"`     // Description The description
	EndpointFormat  string `json:"EndpointFormat"`  // EndpointFormat The endpoint format
	EndpointName    string `json:"EndpointName"`    // EndpointName The endpoint name
	Node            string `json:"Node"`            // Node The node
	RelatedSetting  string `json:"RelatedSetting"`  // RelatedSetting The related setting
	Type            string `json:"Type"`            // Type The type
	ValueRange      int32  `json:"ValueRange"`      // ValueRange The value range
}

// PushedMessage Type for API.Core.GetUpdates#Messages[i] (along with WS keep alive)
type PushedMessage struct {
	AgeMinutes int32     `json:"AgeMinutes"` // AgeMinutes The age of the message in minutes
	Expired    bool      `json:"Expired"`    // Expired Whether the message has expired
	Id         uuid.UUID `json:"Id"`         // Id The message ID
	Message    string    `json:"Message"`    // Message The message
	Source     string    `json:"Source"`     // Source The source of the message
}

// RemoteInstanceState Represents the state of a remote instance
type RemoteInstanceState int

// RemoteInstanceStateMap A map of RemoteInstanceStates to their integer values
// RemoteInstanceStateMapReverse A map of integer values to their RemoteInstanceStates
var (
	RemoteInstanceStateMap = map[string]int{
		"Pending":          0,   // Pending
		"Connecting":       5,   // Connecting
		"Offline":          10,  // Offline
		"Unavailable":      15,  // Unavailable
		"AuthFailure":      16,  // Authentication failure
		"Online":           20,  // Online
		"Disabled":         30,  // Disabled
		"UpdateInProgress": 100, // Update in progress
	}

	RemoteInstanceStateMapReverse = map[int]string{
		0:   "Pending",
		5:   "Connecting",
		10:  "Offline",
		15:  "Unavailable",
		16:  "AuthFailure",
		20:  "Online",
		30:  "Disabled",
		100: "UpdateInProgress",
	}
)

// String Returns the string representation of the RemoteInstanceState
// Author: p0t4t0sandwich
func (e RemoteInstanceState) String() string {
	if val, ok := RemoteInstanceStateMapReverse[int(e)]; ok {
		return val
	}
	return "Undefined"
}

// RemoteTargetInfo Information about a remote target, returned by ADSModule#GetTargetInfo()
type RemoteTargetInfo struct {
	Datastores          []DatastoreSummary `json:"Datastores"`          // Datastores The datastores
	DeploysInContainers bool               `json:"DeploysInContainers"` // DeploysInContainers Whether the target deploys in containers
	IPAddressList       []string           `json:"IPAddressList"`       // IPAddressList The IP address list
	PlatformInfo        IPlatformInfo      `json:"PlatformInfo"`        // PlatformInfo The remote target's platform info
}

// RunningTask A running task object
type RunningTask struct {
	Description      string    `json:"Description"`      // Description The description
	DontPropagate    bool      `json:"DontPropagate"`    // DontPropagate Whether the task should not propagate
	FastDismiss      bool      `json:"FastDismiss"`      // FastDismiss Whether the task can be dismissed quickly
	HideFromUI       bool      `json:"HideFromUI"`       // HideFromUI Whether the task is hidden from the UI
	Id               uuid.UUID `json:"Id"`               // Id The task ID
	IsCancellable    bool      `json:"IsCancellable"`    // IsCancellable Whether the task is cancellable
	IsIndeterminate  bool      `json:"IsIndeterminate"`  // IsIndeterminate Whether the task is indeterminate
	IsPrimaryTask    bool      `json:"IsPrimaryTask"`    // IsPrimaryTask Whether the task is primary
	LastUpdatePushed time.Time `json:"LastUpdatePushed"` // LastUpdatePushed The last update pushed
	Name             string    `json:"Name"`             // Name The name
	Origin           string    `json:"Origin"`           // Origin The origin
	ProgressPercent  int32     `json:"ProgressPercent"`  // ProgressPercent The progress percentage
	Speed            string    `json:"Speed"`            // Speed The speed
	StartTime        time.Time `json:"StartTime"`        // StartTime The start time
	State            TaskState `json:"State"`            // State The state
	StateMessage     string    `json:"StateMessage"`     // StateMessage The state message
	RemoteInstanceId uuid.UUID `json:"RemoteInstanceId"` // Optional, RemoteInstanceId The remote instance ID
	EndTime          time.Time `json:"EndTime"`          // Optional, EndTime The end time
	ParentTaskId     uuid.UUID `json:"ParentTaskId"`     // Optional, ParentTaskId The parent task ID
}

// ScheduleEnabledState Represents the schedule enabled state
type ScheduleEnabledState int

// ScheduleEnabledStateMap A map of ScheduleEnabledStates to their integer values
// ScheduleEnabledStateMapReverse A map of integer values to their ScheduleEnabledStates
var (
	ScheduleEnabledStateMap = map[string]int{
		"Disabled":    0, // Disabled
		"Enabled":     1, // Enabled
		"RunOnce":     2, // Run once
		"DeleteOnRun": 4, // Delete on run
	}

	ScheduleEnabledStateMapReverse = map[int]string{
		0: "Disabled",
		1: "Enabled",
		2: "RunOnce",
		4: "DeleteOnRun",
	}
)

// String Returns the string representation of the ScheduleEnabledState
// Author: p0t4t0sandwich
func (e ScheduleEnabledState) String() string {
	if val, ok := ScheduleEnabledStateMapReverse[int(e)]; ok {
		return val
	}
	return "Undefined"
}

// ScheduleEntryDefinition A schedule entry definition
type ScheduleEntryDefinition struct {
	EnabledState     ScheduleEnabledState   `json:"EnabledState"`     // EnabledState The enabled state
	ErrorBehaviour   ScheduleErrorBehaviour `json:"ErrorBehaviour"`   // ErrorBehaviour The error behaviour
	Id               uuid.UUID              `json:"Id"`               // Id The ID
	LastErrorReason  string                 `json:"LastErrorReason"`  // LastErrorReason The last error reason
	LastExecuteError bool                   `json:"LastExecuteError"` // LastExecuteError Whether the last execution had an error
	Locked           bool                   `json:"Locked"`           // Locked Whether the entry is locked
	Order            int32                  `json:"Order"`            // Order The order
	ParameterMapping map[string]string      `json:"ParameterMapping"` // ParameterMapping The parameter mapping
	TaskMethodName   string                 `json:"TaskMethodName"`   // TaskMethodName The task method name
	WaitForComplete  bool                   `json:"WaitForComplete"`  // WaitForComplete Whether to wait for completion
	CreatedBy        uuid.UUID              `json:"CreatedBy"`        // Optional, CreatedBy The creator
}

// ScheduleErrorBehaviour Represents the schedule error behaviour
type ScheduleErrorBehaviour int

// ScheduleErrorBehaviourMap A map of ScheduleErrorBehaviours to their integer values
// ScheduleErrorBehaviourMapReverse A map of integer values to their ScheduleErrorBehaviours
var (
	ScheduleErrorBehaviourMap = map[string]int{
		"Normal":           0, // Normal
		"ContinueSilently": 1, // Continue silently
	}

	ScheduleErrorBehaviourMapReverse = map[int]string{
		0: "Normal",
		1: "ContinueSilently",
	}
)

// String Returns the string representation of the ScheduleErrorBehaviour
// Author: p0t4t0sandwich
func (e ScheduleErrorBehaviour) String() string {
	if val, ok := ScheduleErrorBehaviourMapReverse[int(e)]; ok {
		return val
	}
	return "Undefined"
}

// ScheduleInfo Information about a schedule
type ScheduleInfo struct {
	AvailableMethods  []APIMethodInfo `json:"AvailableMethods"`  // AvailableMethods The available methods
	AvailableTriggers []TriggerInfo   `json:"AvailableTriggers"` // AvailableTriggers The available triggers
	PopulatedTriggers []TriggerInfo   `json:"PopulatedTriggers"` // PopulatedTriggers The populated triggers
}

// ScheduleTaskParameter A parameter for a scheduled task
type ScheduleTaskParameter struct {
	Description     string                         `json:"Description"`     // Description The description
	DisplayName     string                         `json:"DisplayName"`     // DisplayName The display name
	InputType       string                         `json:"InputType"`       // InputType The input type
	Name            string                         `json:"Name"`            // Name The name
	SelectionSource StringSelectionSourceAttribute `json:"SelectionSource"` // SelectionSource The selection source
	ValueType       string                         `json:"ValueType"`       // ValueType The value type
	EnumValues      map[string]string              `json:"EnumValues"`      // Optional, EnumValues The enum values
}

// ScheduleTrigger A time interval trigger
type ScheduleTrigger struct {
	Description  string               `json:"Description"`  // Description The description
	EnabledState ScheduleEnabledState `json:"EnabledState"` // EnabledState The enabled state
	Id           uuid.UUID            `json:"Id"`           // Id The ID
	Name         string               `json:"Name"`         // Name The name
	Order        int32                `json:"Order"`        // Order The order
	LastExecuted time.Time            `json:"LastExecuted"` // Optional, LastExecuted The last executed
}

// SecurityCheckResult A security check result
type SecurityCheckResult struct {
	Description string `json:"Description"` // Description The description
	Hidden      bool   `json:"Hidden"`      // Hidden Whether the check is hidden
	Pass        bool   `json:"Pass"`        // Pass Whether the check passed
	Resolution  string `json:"Resolution"`  // Resolution The resolution
	Severity    int32  `json:"Severity"`    // Severity The severity
	Title       string `json:"Title"`       // Title The title
}

// SettingSpec A setting specification object
type SettingSpec struct {
	Actions               []InlineActionAttribute        `json:"Actions"`               // Actions The actions
	AlwaysAllowRead       bool                           `json:"AlwaysAllowRead"`       // AlwaysAllowRead Whether the setting is always allowed to be read
	Attributes            any                            `json:"Attributes"`            // Attributes The attributes
	Category              string                         `json:"Category"`              // Category The category
	CurrentValue          any                            `json:"CurrentValue"`          // CurrentValue The current value
	Description           string                         `json:"Description"`           // Description The description
	EnumValuesAreDeferred bool                           `json:"EnumValuesAreDeferred"` // EnumValuesAreDeferred Whether the enum values are deferred
	InputType             string                         `json:"InputType"`             // InputType The input type
	IsProvisionSpec       bool                           `json:"IsProvisionSpec"`       // IsProvisionSpec Whether the setting is a provision spec
	Keywords              string                         `json:"Keywords"`              // Keywords The keywords
	MaxLength             int32                          `json:"MaxLength"`             // MaxLength The max length
	Meta                  string                         `json:"Meta"`                  // Meta The meta
	Name                  string                         `json:"Name"`                  // Name The name
	Node                  string                         `json:"Node"`                  // Node The node
	Order                 int32                          `json:"Order"`                 // Order The order
	Placeholder           string                         `json:"Placeholder"`           // Placeholder The placeholder
	ReadOnly              bool                           `json:"ReadOnly"`              // ReadOnly Whether the setting is read-only
	ReadOnlyProvision     bool                           `json:"ReadOnlyProvision"`     // ReadOnlyProvision Whether the provision is read-only
	Required              bool                           `json:"Required"`              // Required Whether the setting is required
	RequiresRestart       bool                           `json:"RequiresRestart"`       // RequiresRestart Whether the setting requires a restart
	Subcategory           string                         `json:"Subcategory"`           // Subcategory The subcategory
	Suffix                string                         `json:"Suffix"`                // Suffix The suffix
	Tag                   string                         `json:"Tag"`                   // Tag The tag
	ValType               string                         `json:"ValType"`               // ValType The value type
	EnumValues            map[string]string              `json:"EnumValues"`            // Optional, EnumValues The enum values
	MaxValue              float64                        `json:"MaxValue"`              // Optional, MaxValue The max value
	MinValue              float64                        `json:"MinValue"`              // Optional, MinValue The min value
	SelectionSource       StringSelectionSourceAttribute `json:"SelectionSource"`       // Optional, SelectionSource The selection source
}

// SimpleUser A simple user object
type SimpleUser struct {
	IPAddress     string    `json:"IPAddress"`     // IPAddress The IP address
	Id            string    `json:"Id"`            // Id The ID
	JoinTime      time.Time `json:"JoinTime"`      // JoinTime The join time
	Name          string    `json:"Name"`          // Name The name
	Port          int32     `json:"Port"`          // Port The port
	SessionID     string    `json:"SessionID"`     // SessionID The session ID
	Tags          []string  `json:"Tags"`          // Tags The tags
	TimeLoggedIn  time.Time `json:"TimeLoggedIn"`  // TimeLoggedIn The time logged in
	UID           string    `json:"UID"`           // UID The UID
	UserSessionId uuid.UUID `json:"UserSessionId"` // UserSessionId The user session ID
}

// StatusResponse Type for the result of Core.GetStatus
type StatusResponse struct {
	Metrics map[string]MetricInfo `json:"Metrics"` // Metrics The metrics
	State   ApplicationState      `json:"State"`   // State The state of the instance
	Uptime  string                `json:"Uptime"`  // Uptime The uptime of the instance
}

// StringSelectionSourceAttribute A string selection source object
type StringSelectionSourceAttribute struct {
	Deferred     bool `json:"Deferred"`     // Deferred Whether the selection source is deferred
	MustValidate bool `json:"MustValidate"` // MustValidate Whether the selection source must validate
}

// SupportedOS Represents the supported OS
type SupportedOS int

// SupportedOSMap A map of SupportedOSs to their integer values
// SupportedOSMapReverse A map of integer values to their SupportedOSs
var (
	SupportedOSMap = map[string]int{
		"None_":   0,  // None
		"Windows": 1,  // Windows
		"Linux":   2,  // Linux
		"MacOS":   4,  // MacOS
		"BSD":     8,  // BSD
		"Other":   16, // Other
		"All":     31, // All
	}

	SupportedOSMapReverse = map[int]string{
		0:  "None_",
		1:  "Windows",
		2:  "Linux",
		4:  "MacOS",
		8:  "BSD",
		16: "Other",
		31: "All",
	}
)

// String Returns the string representation of the SupportedOS
// Author: p0t4t0sandwich
func (e SupportedOS) String() string {
	if val, ok := SupportedOSMapReverse[int(e)]; ok {
		return val
	}
	return "Undefined"
}

// TaskState Represents the state of a task
type TaskState int

// TaskStateMap A map of TaskStates to their integer values
// TaskStateMapReverse A map of integer values to their TaskStates
var (
	TaskStateMap = map[string]int{
		"Running":             0,   // Running
		"Waiting":             1,   // Waiting
		"Queued":              2,   // Queued
		"Failed":              3,   // Failed
		"Finished":            4,   // Finished
		"PendingCancellation": 5,   // Pending cancellation
		"Cancelled":           6,   // Cancelled
		"Acknowledged":        7,   // Acknowledged
		"UserActionRequired":  100, // User action required
		"TimedOut":            254, // Timed out
	}

	TaskStateMapReverse = map[int]string{
		0:   "Running",
		1:   "Waiting",
		2:   "Queued",
		3:   "Failed",
		4:   "Finished",
		5:   "PendingCancellation",
		6:   "Cancelled",
		7:   "Acknowledged",
		100: "UserActionRequired",
		254: "TimedOut",
	}
)

// String Returns the string representation of the TaskState
// Author: p0t4t0sandwich
func (e TaskState) String() string {
	if val, ok := TaskStateMapReverse[int(e)]; ok {
		return val
	}
	return "Undefined"
}

// TimeIntervalTrigger A time interval trigger
type TimeIntervalTrigger struct {
	Description      string               `json:"Description"`      // Description The description
	EnabledState     ScheduleEnabledState `json:"EnabledState"`     // EnabledState The enabled state
	Id               uuid.UUID            `json:"Id"`               // Id The ID
	Name             string               `json:"Name"`             // Name The name
	Order            int32                `json:"Order"`            // Order The order
	MatchMinutes     []int32              `json:"MatchMinutes"`     // MatchMinutes The match minutes
	MatchHours       []int32              `json:"MatchHours"`       // MatchHours The match hours
	MatchDays        []int32              `json:"MatchDays"`        // MatchDays The match days
	MatchDaysOfMonth []int32              `json:"MatchDaysOfMonth"` // MatchDaysOfMonth The match days of month
	MatchMonths      []int32              `json:"MatchMonths"`      // MatchMonths The match months
	LastExecuted     time.Time            `json:"LastExecuted"`     // Optional, LastExecuted The last executed
}

// TriggerInfo Information about a trigger
type TriggerInfo struct {
	Description  string                    `json:"Description"`  // Description The description
	Emits        []string                  `json:"Emits"`        // Emits The emits
	EnabledState ScheduleEnabledState      `json:"EnabledState"` // EnabledState The enabled state
	Id           string                    `json:"Id"`           // Id The ID
	Tasks        []ScheduleEntryDefinition `json:"Tasks"`        // Tasks The tasks
	TriggerType  string                    `json:"TriggerType"`  // TriggerType The trigger type
	Type         string                    `json:"Type"`         // Type The type
}

// TwoFactorSetupInfo Information about two-factor setup
type TwoFactorSetupInfo struct {
	ManualKey string `json:"ManualKey"` // ManualKey The manual key
	Url       string `json:"Url"`       // Url The URL
}

// UpdateInfo A struct to represent the object returned by the Core.GetUpdateInfo() method
type UpdateInfo struct {
	Build           string `json:"Build"`           // Build The build of the update
	PatchOnly       bool   `json:"PatchOnly"`       // PatchOnly Whether the update is a patch
	ReleaseNotesURL string `json:"ReleaseNotesURL"` // ReleaseNotesURL The URL to the release notes
	ToolsVersion    string `json:"ToolsVersion"`    // ToolsVersion The version of the tools
	UpdateAvailable bool   `json:"UpdateAvailable"` // UpdateAvailable Whether an update is available
	Version         string `json:"Version"`         // Version The version of the update
}

// UpdateResponse Response type for Core.GetUpdates
type UpdateResponse struct {
	ConsoleEntries []ConsoleEntry         `json:"ConsoleEntries"` // ConsoleEntries The console entries of the server
	Messages       []PushedMessage        `json:"Messages"`       // Messages The messages of the server
	Ports          []ListeningPortSummary `json:"Ports"`          // Ports The ports of the server
	Status         StatusResponse         `json:"Status"`         // Status The status of the server
	Tasks          []RunningTask          `json:"Tasks"`          // Tasks The tasks of the server
}

// UserAccessData User access data
type UserAccessData struct {
	OPList    []OPEntry        `json:"OPList"`    // OPList The OP list
	Whitelist []WhitelistEntry `json:"Whitelist"` // Whitelist The whitelist
}

// UserInfo Information about a user
type UserInfo struct {
	AvatarBase64         string      `json:"AvatarBase64"`         // AvatarBase64 The avatar base64
	CannotChangePassword bool        `json:"CannotChangePassword"` // CannotChangePassword Whether the password cannot be changed
	Disabled             bool        `json:"Disabled"`             // Disabled Whether the user is disabled
	EmailAddress         string      `json:"EmailAddress"`         // EmailAddress The email address
	GravatarHash         string      `json:"GravatarHash"`         // GravatarHash The gravatar hash
	ID                   uuid.UUID   `json:"ID"`                   // ID The ID
	IsLDAPUser           bool        `json:"IsLDAPUser"`           // IsLDAPUser Whether the user is an LDAP user
	IsSuperUser          bool        `json:"IsSuperUser"`          // IsSuperUser Whether the user is a super user
	IsTwoFactorEnabled   bool        `json:"IsTwoFactorEnabled"`   // IsTwoFactorEnabled Whether two-factor is enabled
	LastLogin            string      `json:"LastLogin"`            // LastLogin The last login
	MustChangePassword   bool        `json:"MustChangePassword"`   // MustChangePassword Whether the password must be changed
	Name                 string      `json:"Name"`                 // Name The name
	PasswordExpires      bool        `json:"PasswordExpires"`      // PasswordExpires Whether the password expires
	Permissions          []string    `json:"Permissions"`          // Permissions The permissions
	Roles                []uuid.UUID `json:"Roles"`                // Roles The roles
}

// UserInfoSummary Information about the user
type UserInfoSummary struct {
	AvatarBase64       string    `json:"AvatarBase64"`       // AvatarBase64 The avatar base64
	Disabled           bool      `json:"Disabled"`           // Disabled Whether the user is disabled
	EmailAddress       string    `json:"EmailAddress"`       // EmailAddress The email address
	GravatarHash       string    `json:"GravatarHash"`       // GravatarHash The Gravatar hash
	ID                 uuid.UUID `json:"ID"`                 // ID The user ID
	IsLDAPUser         bool      `json:"IsLDAPUser"`         // IsLDAPUser Whether the user is an LDAP user
	IsTwoFactorEnabled bool      `json:"IsTwoFactorEnabled"` // IsTwoFactorEnabled Whether 2FA is enabled
	LastLogin          string    `json:"LastLogin"`          // LastLogin The last login
	Username           string    `json:"Username"`           // Username The username
}

// VirtualizationType Represents the virtualization type
type VirtualizationType int

// VirtualizationTypeMap A map of VirtualizationTypes to their integer values
// VirtualizationTypeMapReverse A map of integer values to their VirtualizationTypes
var (
	VirtualizationTypeMap = map[string]int{
		"None_":      0,  // None/Bare Metal
		"VMware":     1,  // VMware
		"VMwareESX":  2,  // VMware ESX
		"VirtualBox": 3,  // VirtualBox
		"Xen":        4,  // Xen
		"QEMU_KVM":   5,  // QEMU KVM
		"OpenVZ":     6,  // OpenVZ
		"HyperV":     7,  // HyperV
		"Docker":     8,  // Docker
		"LXC":        9,  // LXC
		"WSL":        10, // Windows Subsystem for Linux
		"ProxmoxVM":  11, // ProxmoxVM
		"ProxmoxLXC": 12, // Proxmox LXC Container
	}

	VirtualizationTypeMapReverse = map[int]string{
		0:  "None_",
		1:  "VMware",
		2:  "VMwareESX",
		3:  "VirtualBox",
		4:  "Xen",
		5:  "QEMU_KVM",
		6:  "OpenVZ",
		7:  "HyperV",
		8:  "Docker",
		9:  "LXC",
		10: "WSL",
		11: "ProxmoxVM",
		12: "ProxmoxLXC",
	}
)

// String Returns the string representation of the VirtualizationType
// Author: p0t4t0sandwich
func (e VirtualizationType) String() string {
	if val, ok := VirtualizationTypeMapReverse[int(e)]; ok {
		return val
	}
	return "Undefined"
}

// WebauthnCredentialSummary A summary of a WebAuthn credential
type WebauthnCredentialSummary struct {
	CreatedUTC  time.Time `json:"CreatedUTC"`  // CreatedUTC The created time
	Description string    `json:"Description"` // Description The description
	ID          int32     `json:"ID"`          // ID The ID
	LastUsedUTC time.Time `json:"LastUsedUTC"` // LastUsedUTC The last used time
}

// WebauthnLoginInfo Information about a WebAuthn login
type WebauthnLoginInfo struct {
	Challenge string   `json:"Challenge"` // Challenge The challenge
	Ids       []string `json:"Ids"`       // Ids The IDs
}

// WebSessionSummary A summary of a web session
type WebSessionSummary struct {
	LastActivity time.Time `json:"LastActivity"` // LastActivity The last activity
	SessionID    string    `json:"SessionID"`    // SessionID The session ID
	SessionType  string    `json:"SessionType"`  // SessionType The session type
	Source       string    `json:"Source"`       // Source The source
	StartTime    time.Time `json:"StartTime"`    // StartTime The start time
	Username     string    `json:"Username"`     // Username The username
}

// WhitelistEntry A whitelist entry
type WhitelistEntry struct {
	Name string `json:"Name"` // Name The name
	UUID string `json:"UUID"` // UUID The UUID
}
