/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

import java.util.UUID;

/**
 * A summary of an application spec
 *
 * @param Author The author
 * @param ContainerReason The container reason
 * @param ContainerSupport The container support
 * @param DeprecatedReason The deprecated reason
 * @param Description The description
 * @param DisplayImageSource The display image source
 * @param ExtraSetupStepsURI The extra setup steps URI
 * @param FriendlyName The friendly name
 * @param Id The ID
 * @param IsServiceSpec Whether the spec is a service spec
 * @param NoCommercialUsage Whether commercial usage is allowed
 * @param Origin The origin
 * @param SupportedPlatforms The supported platforms
 */
public record ApplicationSpecSummary(
        String Author,
        String ContainerReason,
        ContainerSupport ContainerSupport,
        String DeprecatedReason,
        String Description,
        String DisplayImageSource,
        String ExtraSetupStepsURI,
        String FriendlyName,
        UUID Id,
        Boolean IsServiceSpec,
        Boolean NoCommercialUsage,
        String Origin,
        SupportedOS SupportedPlatforms) {}
