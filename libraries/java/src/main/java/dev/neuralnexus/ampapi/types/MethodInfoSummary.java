package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * A summary of a method
 * @param Description The description
 * @param IsComplexType Whether the method is a complex type
 * @param Parameters The parameters
 * @param ReturnTypeName The return type name
 * @param Returns The methods return value (deprecated)
 */
public record MethodInfoSummary(String Description, Boolean IsComplexType, List<MethodParameterSummary> Parameters, String ReturnTypeName, Optional<String> Returns) {}
