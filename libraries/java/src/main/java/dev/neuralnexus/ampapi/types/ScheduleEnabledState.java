/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

/**
 * Represents the schedule enabled state Disabled: Disabled Enabled: Enabled RunOnce: Run once
 * DeleteOnRun: Delete on run
 */
public enum ScheduleEnabledState {
    @SerializedName("0")
    Disabled(0),
    @SerializedName("1")
    Enabled(1),
    @SerializedName("2")
    RunOnce(2),
    @SerializedName("4")
    DeleteOnRun(4);

    /** The value of the enum. */
    private final int value;

    ScheduleEnabledState(int i) {
        this.value = i;
    }

    ScheduleEnabledState(double i) {
        this.value = (int) i;
    }
}
