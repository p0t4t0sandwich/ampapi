package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * Represents the state of a remote instance
 * Pending: Pending
 * Connecting: Connecting
 * Offline: Offline
 * Unavailable: Unavailable
 * AuthFailure: Authentication failure
 * Online: Online
 * Disabled: Disabled
 * UpdateInProgress: Update in progress
 */
public enum RemoteInstanceState {
    @SerializedName("0")
    Pending(0),
    @SerializedName("5")
    Connecting(5),
    @SerializedName("10")
    Offline(10),
    @SerializedName("15")
    Unavailable(15),
    @SerializedName("16")
    AuthFailure(16),
    @SerializedName("20")
    Online(20),
    @SerializedName("30")
    Disabled(30),
    @SerializedName("100")
    UpdateInProgress(100);

    /** The value of the enum. */
    private final int value;

    RemoteInstanceState(int i) {
        this.value = i;
    }

    RemoteInstanceState(double i) {
        this.value = (int) i;
    }
}
