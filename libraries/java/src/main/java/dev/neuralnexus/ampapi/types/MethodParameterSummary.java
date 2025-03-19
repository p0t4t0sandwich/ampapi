/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

import java.util.Map;
import java.util.Optional;

/**
 * A summary of a method parameter
 *
 * @param Description The description
 * @param Name The name
 * @param Optional Whether the parameter is optional
 * @param TypeName The type name
 * @param ParamEnumValues The parameter enum values
 */
public record MethodParameterSummary(
        String Description,
        String Name,
        Boolean Optional,
        String TypeName,
        Optional<Map<String, Object>> ParamEnumValues) {}
