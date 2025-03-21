/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

/** Represents the port protocol TCP: TCP UDP: UDP Both: Both */
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
