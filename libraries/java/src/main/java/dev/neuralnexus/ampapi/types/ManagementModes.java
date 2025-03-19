/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

/** Represents the management modes Standalone: Standalone ViaADS: Via ADS */
public enum ManagementModes {
    @SerializedName("0")
    Standalone(0),
    @SerializedName("10")
    ViaADS(10);

    /** The value of the enum. */
    private final int value;

    ManagementModes(int i) {
        this.value = i;
    }

    ManagementModes(double i) {
        this.value = (int) i;
    }
}
