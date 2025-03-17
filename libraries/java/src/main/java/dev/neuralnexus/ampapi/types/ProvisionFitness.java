/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

/**
 * Fitness information object
 *
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
public record ProvisionFitness(
        Boolean Available,
        Double CPUServiceRatio,
        Integer FreeDiskMB,
        Integer FreeRAMMB,
        Float LoadAvg,
        Integer RemainingInstanceSlots,
        Double Score,
        Integer ThreadQueueLength,
        Integer TotalServices) {}
