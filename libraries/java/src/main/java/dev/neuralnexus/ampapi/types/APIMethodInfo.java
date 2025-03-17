package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * Information about an API method
 * @param Consumes The parameters
 * @param Description The description
 * @param DisplayFormat The display format
 * @param Id The ID
 * @param Name The name
 */
public record APIMethodInfo(List<ScheduleTaskParameter> Consumes, String Description, String DisplayFormat, String Id, String Name) {}
