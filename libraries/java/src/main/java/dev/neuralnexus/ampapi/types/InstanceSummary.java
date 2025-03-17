package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * An instance object
 * @param AMPVersion The AMP version
 * @param AppState The application state
 * @param ApplicationEndpoints The application endpoints
 * @param ContainerCPUs The container CPUs
 * @param ContainerMemoryMB The container memory in MB
 * @param ContainerMemoryPolicy The container memory policy
 * @param ContainerSwapMB The container swap in MB
 * @param Daemon Whether the instance is a daemon
 * @param DaemonAutostart Whether the instance daemon autostarts
 * @param DeploymentArgs The deployment arguments
 * @param Description The description
 * @param DiskUsageMB The disk usage in MB
 * @param DisplayImageSource The display image source
 * @param ExcludeFromFirewall Whether the instance is excluded from the firewall
 * @param FriendlyName The friendly name
 * @param IP The IP address
 * @param InstanceID The instance ID
 * @param InstanceName The instance name
 * @param IsContainerInstance Whether the instance is a container instance
 * @param IsHTTPS Whether HTTPS is enabled
 * @param ManagementMode The management mode
 * @param Metrics The metrics
 * @param Module The module
 * @param ModuleDisplayName The module display name
 * @param Port The port
 * @param ReleaseStream The release stream
 * @param Running Whether the instance is running
 * @param SpecificDockerImage The specific Docker image
 * @param Suspended Whether the instance is suspended
 * @param Tags The tags
 * @param TargetID The target ID
 * @param UseHostModeNetwork Whether the container uses host mode network
 * @param WelcomeMessage The instance's welcome message
 */
public record InstanceSummary(String AMPVersion, ApplicationState AppState, List<EndpointInfo> ApplicationEndpoints, Float ContainerCPUs, Integer ContainerMemoryMB, ContainerMemoryPolicy ContainerMemoryPolicy, Integer ContainerSwapMB, Boolean Daemon, Boolean DaemonAutostart, Map<String, String> DeploymentArgs, String Description, Integer DiskUsageMB, String DisplayImageSource, Boolean ExcludeFromFirewall, String FriendlyName, String IP, UUID InstanceID, String InstanceName, Boolean IsContainerInstance, Boolean IsHTTPS, ManagementModes ManagementMode, Map<String, MetricInfo> Metrics, String Module, String ModuleDisplayName, Integer Port, AMPReleaseStreams ReleaseStream, Boolean Running, String SpecificDockerImage, Boolean Suspended, List<String> Tags, UUID TargetID, Boolean UseHostModeNetwork, String WelcomeMessage) {}
