package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * A time interval trigger
 * @param Description The description
 * @param EnabledState The enabled state
 * @param Id The ID
 * @param Name The name
 * @param Order The order
 * @param LastExecuted The last executed
 */
public record ScheduleTrigger(String Description, ScheduleEnabledState EnabledState, UUID Id, String Name, Integer Order, Optional<String> LastExecuted) {}
