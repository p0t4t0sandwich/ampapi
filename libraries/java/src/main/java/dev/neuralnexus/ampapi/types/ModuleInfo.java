package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * A struct to represent the object returned by the Core.GetModuleInfo() method
 * @param AMPBuild The AMP build
 * @param AMPVersion The AMP version
 * @param APIVersion The API version
 * @param AllowRememberMe Whether remember me is allowed
 * @param Analytics Whether analytics are enabled
 * @param AppName The application name
 * @param Author The author of the module
 * @param BasePort The base port
 * @param Branding The branding object
 * @param BuildSpec The build spec
 * @param DisplayBaseURI The display base URI
 * @param EndpointURI The endpoint URI
 * @param FeatureSet The feature set
 * @param FriendlyName The friendly name
 * @param InstanceId The instance ID
 * @param InstanceName The instance name
 * @param IsRemoteInstance Whether the instance is remote
 * @param LoadedPlugins The loaded plugins
 * @param ModuleName The module name
 * @param Name The name of the module
 * @param PrimaryEndpoint The primary endpoint
 * @param RequiresFullLoad Whether the module requires a full load
 * @param SupportsSleep Whether the module supports sleep mode
 * @param Timestamp The timestamp
 * @param ToolsVersion The tools version
 * @param VersionCodename The version codename
 */
public record ModuleInfo(String AMPBuild, String AMPVersion, String APIVersion, Boolean AllowRememberMe, Boolean Analytics, String AppName, String Author, Integer BasePort, BrandingSettings Branding, String BuildSpec, String DisplayBaseURI, String EndpointURI, List<String> FeatureSet, String FriendlyName, UUID InstanceId, String InstanceName, Boolean IsRemoteInstance, List<String> LoadedPlugins, String ModuleName, String Name, String PrimaryEndpoint, Boolean RequiresFullLoad, Boolean SupportsSleep, String Timestamp, String ToolsVersion, String VersionCodename) {}
