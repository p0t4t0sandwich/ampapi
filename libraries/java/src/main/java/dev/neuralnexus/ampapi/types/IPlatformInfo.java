package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * Platform information object
 * @param CPUInfo The CPU information object
 * @param DockerNetworkIsHostMode Whether the Docker network is in host mode
 * @param InstalledRAMMB The installed RAM in MB
 * @param OS The OS
 * @param PlatformName The platform name
 * @param SystemType The system type
 * @param Virtualization The virtualization type
 */
public record IPlatformInfo(ProcessorInfo CPUInfo, Boolean DockerNetworkIsHostMode, Integer InstalledRAMMB, SupportedOS OS, String PlatformName, Architecture SystemType, VirtualizationType Virtualization) {}
