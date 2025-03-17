package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * Represents the state of a task
 * Running: Running
 * Waiting: Waiting
 * Queued: Queued
 * Failed: Failed
 * Finished: Finished
 * PendingCancellation: Pending cancellation
 * Cancelled: Cancelled
 * Acknowledged: Acknowledged
 * UserActionRequired: User action required
 * TimedOut: Timed out
 */
public enum TaskState {
    @SerializedName("0")
    Running(0),
    @SerializedName("1")
    Waiting(1),
    @SerializedName("2")
    Queued(2),
    @SerializedName("3")
    Failed(3),
    @SerializedName("4")
    Finished(4),
    @SerializedName("5")
    PendingCancellation(5),
    @SerializedName("6")
    Cancelled(6),
    @SerializedName("7")
    Acknowledged(7),
    @SerializedName("100")
    UserActionRequired(100),
    @SerializedName("254")
    TimedOut(254);

    /** The value of the enum. */
    private final int value;

    TaskState(int i) {
        this.value = i;
    }

    TaskState(double i) {
        this.value = (int) i;
    }
}
