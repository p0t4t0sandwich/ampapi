/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

/**
 * Represents the container memory policy NotSpecified: Not specified Reserve: Reserve Restrict:
 * Restrict
 */
public enum ContainerMemoryPolicy {
    @SerializedName("0")
    NotSpecified(0),
    @SerializedName("100")
    Reserve(100),
    @SerializedName("200")
    Restrict(200);

    /** The value of the enum. */
    private final int value;

    ContainerMemoryPolicy(int i) {
        this.value = i;
    }

    ContainerMemoryPolicy(double i) {
        this.value = (int) i;
    }
}
