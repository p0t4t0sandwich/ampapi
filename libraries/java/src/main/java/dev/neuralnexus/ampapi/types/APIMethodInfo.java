/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

import java.util.List;

/**
 * Information about an API method
 *
 * @param Consumes The parameters
 * @param Description The description
 * @param DisplayFormat The display format
 * @param Id The ID
 * @param Name The name
 */
public record APIMethodInfo(
        List<ScheduleTaskParameter> Consumes,
        String Description,
        String DisplayFormat,
        String Id,
        String Name) {}
