/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

/**
 * Represents the supported OS None_: None Windows: Windows Linux: Linux MacOS: MacOS BSD: BSD
 * Other: Other All: All
 */
public enum SupportedOS {
    @SerializedName("0")
    None_(0),
    @SerializedName("1")
    Windows(1),
    @SerializedName("2")
    Linux(2),
    @SerializedName("4")
    MacOS(4),
    @SerializedName("8")
    BSD(8),
    @SerializedName("16")
    Other(16),
    @SerializedName("31")
    All(31);

    /** The value of the enum. */
    private final int value;

    SupportedOS(int i) {
        this.value = i;
    }

    SupportedOS(double i) {
        this.value = (int) i;
    }
}
