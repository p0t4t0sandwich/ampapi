package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * A local AMP instance object
 * @param AMPBuild The AMP build
 * @param AMPVersion The AMP version
 * @param AutomaticUPnP Whether to use automatic UPnP
 * @param ContainerCPUs The container CPUs
 * @param ContainerMemoryMB The container memory in MB
 * @param ContainerMemoryPolicy The container memory policy
 * @param ContainerSwapMB The container swap in MB
 * @param CreatedBy The creator ID
 * @param CustomMountBinds The custom mount binds
 * @param CustomPorts The custom ports
 * @param Daemon Whether the instance is a daemon
 * @param DaemonAutostart Whether the daemon should autostart
 * @param DatastoreId The datastore ID
 * @param DeploymentArgs The deployment arguments
 * @param Description The description
 * @param DiskUsageMB The disk usage in MB
 * @param DisplayImageSource The display image source
 * @param DockerBaseReadOnly Whether the Docker base is read-only
 * @param ExcludeFromFirewall Whether to exclude from the firewall
 * @param ExtraContainerPackages The extra container packages
 * @param ForceDocker Whether to force Docker
 * @param FriendlyName The friendly name
 * @param Group The group
 * @param HasOverlayApplied Whether the instance has an overlay applied
 * @param IP The IP
 * @param InstanceID The instance ID
 * @param InstanceName The instance name
 * @param IsContainerInstance Whether the instance is a container
 * @param IsDaemonUserManaged Whether the instance is a daemon user managed
 * @param IsHTTPS Whether the instance is HTTPS
 * @param IsSharedInstance Whether the instance is a shared instance
 * @param ManagementMode The management mode
 * @param MatchVersion Whether to match the version
 * @param MetricsPublishingHMAC The metrics publishing HMAC
 * @param Module The module
 * @param ModuleDisplayName The module display name
 * @param OS The OS
 * @param OverlayPath The overlay path
 * @param OverlayURL The overlay URL
 * @param Path The path
 * @param PendingSettingChanges The pending setting changes
 * @param Plugins The plugins
 * @param Port The port
 * @param PreviousBuild The previous build
 * @param PreviousVersion The previous version
 * @param ReleaseStream The release stream
 * @param SpecificDockerImage The specific Docker image
 * @param Suspended Whether the instance is suspended
 * @param Tag The tag
 * @param Tags The tags
 * @param TagsUsedForConfiguration Whether tags are used for configuration
 * @param TargetID The target ID
 * @param UseHostModeNetwork Whether to use host mode networking
 * @param User The user
 * @param WelcomeMessage The welcome message
 * @param LastReactivationAttempt The last reactivation attempt
 */
public record LocalAMPInstance(String AMPBuild, String AMPVersion, Boolean AutomaticUPnP, Float ContainerCPUs, Integer ContainerMemoryMB, ContainerMemoryPolicy ContainerMemoryPolicy, Integer ContainerSwapMB, UUID CreatedBy, Map<String, String> CustomMountBinds, List<PortUsage> CustomPorts, Boolean Daemon, Boolean DaemonAutostart, Integer DatastoreId, Map<String, String> DeploymentArgs, String Description, Integer DiskUsageMB, String DisplayImageSource, Boolean DockerBaseReadOnly, Boolean ExcludeFromFirewall, List<String> ExtraContainerPackages, Boolean ForceDocker, String FriendlyName, String Group, Boolean HasOverlayApplied, String IP, UUID InstanceID, String InstanceName, Boolean IsContainerInstance, Boolean IsDaemonUserManaged, Boolean IsHTTPS, Boolean IsSharedInstance, ManagementModes ManagementMode, Boolean MatchVersion, String MetricsPublishingHMAC, String Module, String ModuleDisplayName, SupportedOS OS, String OverlayPath, String OverlayURL, String Path, Map<String, String> PendingSettingChanges, List<String> Plugins, Integer Port, String PreviousBuild, String PreviousVersion, AMPReleaseStreams ReleaseStream, String SpecificDockerImage, Boolean Suspended, String Tag, List<String> Tags, Boolean TagsUsedForConfiguration, UUID TargetID, Boolean UseHostModeNetwork, String User, String WelcomeMessage, Optional<String> LastReactivationAttempt) {}
