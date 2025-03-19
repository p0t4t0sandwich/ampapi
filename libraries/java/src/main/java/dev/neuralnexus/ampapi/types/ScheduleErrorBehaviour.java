/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

/** Represents the schedule error behaviour Normal: Normal ContinueSilently: Continue silently */
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
