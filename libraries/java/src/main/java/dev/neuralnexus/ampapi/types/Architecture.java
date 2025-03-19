/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

/** Represents the architecture Unknown: Unknown x86_64: x86_64 aarch64: aarch64 All: All */
public enum Architecture {
    @SerializedName("0")
    Unknown(0),
    @SerializedName("1")
    x86_64(1),
    @SerializedName("2")
    aarch64(2),
    @SerializedName("3")
    All(3);

    /** The value of the enum. */
    private final int value;

    Architecture(int i) {
        this.value = i;
    }

    Architecture(double i) {
        this.value = (int) i;
    }
}
