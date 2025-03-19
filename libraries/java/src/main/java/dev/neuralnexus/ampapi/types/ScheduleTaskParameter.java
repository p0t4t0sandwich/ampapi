/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

import java.util.Map;
import java.util.Optional;

/**
 * A parameter for a scheduled task
 *
 * @param Description The description
 * @param DisplayName The display name
 * @param InputType The input type
 * @param Name The name
 * @param SelectionSource The selection source
 * @param ValueType The value type
 * @param EnumValues The enum values
 */
public record ScheduleTaskParameter(
        String Description,
        String DisplayName,
        String InputType,
        String Name,
        StringSelectionSourceAttribute SelectionSource,
        String ValueType,
        Optional<Map<String, String>> EnumValues) {}
