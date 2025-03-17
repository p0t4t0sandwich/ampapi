package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * Represents the management modes
 * Standalone: Standalone
 * ViaADS: Via ADS
 */
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
