package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * Type for the result of Core.GetStatus
 * @param Metrics The metrics
 * @param State The state of the instance
 * @param Uptime The uptime of the instance
 */
public record StatusResponse(Map<String, MetricInfo> Metrics, ApplicationState State, String Uptime) {}
