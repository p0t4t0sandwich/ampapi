package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * Information about a schedule
 * @param AvailableMethods The available methods
 * @param AvailableTriggers The available triggers
 * @param PopulatedTriggers The populated triggers
 */
public record ScheduleInfo(List<APIMethodInfo> AvailableMethods, List<TriggerInfo> AvailableTriggers, List<TriggerInfo> PopulatedTriggers) {}
