package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * A metric info object
 * @param Color The color
 * @param Color2 The second color
 * @param Color3 The third color
 * @param MaxValue The maximum value
 * @param Percent The percentage
 * @param RawValue The raw value
 * @param ShortName The short name
 * @param Units The units
 */
public record MetricInfo(String Color, String Color2, String Color3, Integer MaxValue, Integer Percent, Integer RawValue, String ShortName, String Units) {}
