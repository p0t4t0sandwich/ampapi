package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * A specification for an application
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
 * @param ModuleName The module name
 * @param NoCommercialUsage Whether commercial usage is allowed
 * @param Origin The origin
 * @param Settings The settings
 * @param SupportedPlatforms The supported platforms
 */
public record ApplicationSpec(String Author, String ContainerReason, ContainerSupport ContainerSupport, String DeprecatedReason, String Description, String DisplayImageSource, String ExtraSetupStepsURI, String FriendlyName, UUID Id, Boolean IsServiceSpec, String ModuleName, Boolean NoCommercialUsage, String Origin, Map<String, String> Settings, SupportedOS SupportedPlatforms) {}
