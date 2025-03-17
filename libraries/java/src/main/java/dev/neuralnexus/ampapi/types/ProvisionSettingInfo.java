package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * A provision setting object
 * @param CustomFieldType The custom field type
 * @param DefaultValue The default value
 * @param Description The description
 * @param EndpointFormat The endpoint format
 * @param EndpointName The endpoint name
 * @param Node The node
 * @param RelatedSetting The related setting
 * @param Type The type
 * @param ValueRange The value range
 */
public record ProvisionSettingInfo(String CustomFieldType, Object DefaultValue, String Description, String EndpointFormat, String EndpointName, String Node, String RelatedSetting, String Type, Integer ValueRange) {}
