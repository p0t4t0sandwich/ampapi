/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

import java.util.List;
import java.util.Optional;

/**
 * A summary of a method
 *
 * @param Description The description
 * @param IsComplexType Whether the method is a complex type
 * @param Parameters The parameters
 * @param ReturnTypeName The return type name
 * @param Returns The methods return value (deprecated)
 */
public record MethodInfoSummary(
        String Description,
        Boolean IsComplexType,
        List<MethodParameterSummary> Parameters,
        String ReturnTypeName,
        Optional<String> Returns) {}
