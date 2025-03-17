/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

/**
 * A metric info object
 *
 * @param Color The color
 * @param Color2 The second color
 * @param Color3 The third color
 * @param MaxValue The maximum value
 * @param Percent The percentage
 * @param RawValue The raw value
 * @param ShortName The short name
 * @param Units The units
 */
public record MetricInfo(
        String Color,
        String Color2,
        String Color3,
        Integer MaxValue,
        Integer Percent,
        Integer RawValue,
        String ShortName,
        String Units) {}
