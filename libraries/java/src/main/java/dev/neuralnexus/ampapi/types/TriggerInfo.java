/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

import java.util.List;

/**
 * Information about a trigger
 *
 * @param Description The description
 * @param Emits The emits
 * @param EnabledState The enabled state
 * @param Id The ID
 * @param Tasks The tasks
 * @param TriggerType The trigger type
 * @param Type The type
 */
public record TriggerInfo(
        String Description,
        List<String> Emits,
        ScheduleEnabledState EnabledState,
        String Id,
        List<ScheduleEntryDefinition> Tasks,
        String TriggerType,
        String Type) {}
