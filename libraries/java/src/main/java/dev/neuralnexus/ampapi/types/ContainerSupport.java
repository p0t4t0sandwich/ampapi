package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * Represents the container support
 * NoPreference: No preference
 * NotSupported: Not supported
 * SupportedOnLinux: Supported on Linux
 * SupportedOnWindows: Supported on Windows
 * Supported: Supported
 * RecommendedOnLinux: Recommended on Linux
 * RecommendedOnWindows: Recommended on Windows
 * Recommended: Recommended
 * RequiredOnLinux: Required on Linux
 * RequiredOnWindows: Required on Windows
 * Required: Required
 */
public enum ContainerSupport {
    @SerializedName("0")
    NoPreference(0),
    @SerializedName("1")
    NotSupported(1),
    @SerializedName("2")
    SupportedOnLinux(2),
    @SerializedName("4")
    SupportedOnWindows(4),
    @SerializedName("6")
    Supported(6),
    @SerializedName("8")
    RecommendedOnLinux(8),
    @SerializedName("16")
    RecommendedOnWindows(16),
    @SerializedName("24")
    Recommended(24),
    @SerializedName("32")
    RequiredOnLinux(32),
    @SerializedName("64")
    RequiredOnWindows(64),
    @SerializedName("96")
    Required(96);

    /** The value of the enum. */
    private final int value;

    ContainerSupport(int i) {
        this.value = i;
    }

    ContainerSupport(double i) {
        this.value = (int) i;
    }
}
