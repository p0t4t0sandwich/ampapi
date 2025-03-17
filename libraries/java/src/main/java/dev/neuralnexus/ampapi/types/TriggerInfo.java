package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * Information about a trigger
 * @param Description The description
 * @param Emits The emits
 * @param EnabledState The enabled state
 * @param Id The ID
 * @param Tasks The tasks
 * @param TriggerType The trigger type
 * @param Type The type
 */
public record TriggerInfo(String Description, List<String> Emits, ScheduleEnabledState EnabledState, String Id, List<ScheduleEntryDefinition> Tasks, String TriggerType, String Type) {}
