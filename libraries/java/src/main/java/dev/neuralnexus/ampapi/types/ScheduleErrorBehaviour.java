package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * Represents the schedule error behaviour
 * Normal: Normal
 * ContinueSilently: Continue silently
 */
public enum ScheduleErrorBehaviour {
    @SerializedName("0")
    Normal(0),
    @SerializedName("1")
    ContinueSilently(1);

    /** The value of the enum. */
    private final int value;

    ScheduleErrorBehaviour(int i) {
        this.value = i;
    }

    ScheduleErrorBehaviour(double i) {
        this.value = (int) i;
    }
}
