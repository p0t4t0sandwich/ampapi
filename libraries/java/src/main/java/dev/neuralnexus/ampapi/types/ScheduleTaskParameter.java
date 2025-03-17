package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * A parameter for a scheduled task
 * @param Description The description
 * @param DisplayName The display name
 * @param InputType The input type
 * @param Name The name
 * @param SelectionSource The selection source
 * @param ValueType The value type
 * @param EnumValues The enum values
 */
public record ScheduleTaskParameter(String Description, String DisplayName, String InputType, String Name, StringSelectionSourceAttribute SelectionSource, String ValueType, Optional<Map<String, String>> EnumValues) {}
