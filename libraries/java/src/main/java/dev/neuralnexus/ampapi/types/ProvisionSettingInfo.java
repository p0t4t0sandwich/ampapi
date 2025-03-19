/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

/**
 * A provision setting object
 *
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
public record ProvisionSettingInfo(
        String CustomFieldType,
        Object DefaultValue,
        String Description,
        String EndpointFormat,
        String EndpointName,
        String Node,
        String RelatedSetting,
        String Type,
        Integer ValueRange) {}
