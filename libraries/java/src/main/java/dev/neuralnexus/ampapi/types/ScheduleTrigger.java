/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

import java.util.Optional;
import java.util.UUID;

/**
 * A time interval trigger
 *
 * @param Description The description
 * @param EnabledState The enabled state
 * @param Id The ID
 * @param Name The name
 * @param Order The order
 * @param LastExecuted The last executed
 */
public record ScheduleTrigger(
        String Description,
        ScheduleEnabledState EnabledState,
        UUID Id,
        String Name,
        Integer Order,
        Optional<String> LastExecuted) {}
