/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

/**
 * Platform information object
 *
 * @param CPUInfo The CPU information object
 * @param DockerNetworkIsHostMode Whether the Docker network is in host mode
 * @param InstalledRAMMB The installed RAM in MB
 * @param OS The OS
 * @param PlatformName The platform name
 * @param SystemType The system type
 * @param Virtualization The virtualization type
 */
public record IPlatformInfo(
        ProcessorInfo CPUInfo,
        Boolean DockerNetworkIsHostMode,
        Integer InstalledRAMMB,
        SupportedOS OS,
        String PlatformName,
        Architecture SystemType,
        VirtualizationType Virtualization) {}
