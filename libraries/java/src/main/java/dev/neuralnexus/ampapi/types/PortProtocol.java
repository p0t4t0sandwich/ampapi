package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * Represents the port protocol
 * TCP: TCP
 * UDP: UDP
 * Both: Both
 */
public enum PortProtocol {
    @SerializedName("0")
    TCP(0),
    @SerializedName("1")
    UDP(1),
    @SerializedName("2")
    Both(2);

    /** The value of the enum. */
    private final int value;

    PortProtocol(int i) {
        this.value = i;
    }

    PortProtocol(double i) {
        this.value = (int) i;
    }
}
