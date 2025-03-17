package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * Represents the schedule enabled state
 * Disabled: Disabled
 * Enabled: Enabled
 * RunOnce: Run once
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
