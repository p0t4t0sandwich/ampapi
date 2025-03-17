package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * Represents the container memory policy
 * NotSpecified: Not specified
 * Reserve: Reserve
 * Restrict: Restrict
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
