package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * A summary of a method parameter
 * @param Description The description
 * @param Name The name
 * @param Optional Whether the parameter is optional
 * @param TypeName The type name
 * @param ParamEnumValues The parameter enum values
 */
public record MethodParameterSummary(String Description, String Name, Boolean Optional, String TypeName, Optional<Map<String, Object>> ParamEnumValues) {}
