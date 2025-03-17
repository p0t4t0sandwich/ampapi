package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * Fitness information object
 * @param Available Availability
 * @param CPUServiceRatio CPU service ratio
 * @param FreeDiskMB Unallocated disk space in MB
 * @param FreeRAMMB Unallocated RAM in MB
 * @param LoadAvg Load average
 * @param RemainingInstanceSlots Remaining instance slots
 * @param Score Fitness score
 * @param ThreadQueueLength Thread queue length
 * @param TotalServices Service count
 */
public record ProvisionFitness(Boolean Available, Double CPUServiceRatio, Integer FreeDiskMB, Integer FreeRAMMB, Float LoadAvg, Integer RemainingInstanceSlots, Double Score, Integer ThreadQueueLength, Integer TotalServices) {}
