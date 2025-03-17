/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

import java.util.List;

/**
 * Information about a schedule
 *
 * @param AvailableMethods The available methods
 * @param AvailableTriggers The available triggers
 * @param PopulatedTriggers The populated triggers
 */
public record ScheduleInfo(
        List<APIMethodInfo> AvailableMethods,
        List<TriggerInfo> AvailableTriggers,
        List<TriggerInfo> PopulatedTriggers) {}
