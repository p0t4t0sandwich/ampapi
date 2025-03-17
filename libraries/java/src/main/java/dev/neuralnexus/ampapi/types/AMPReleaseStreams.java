package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * Represents the AMP release streams
 * NotSpecified: Not specified
 * LTS: LTS
 * Mainline: Mainline
 * Preview: Preview
 * Development: Development
 * FastTrack: Fast track
 * Nightly: Nightly
 * Bleeding: Bleeding
 */
public enum AMPReleaseStreams {
    @SerializedName("0")
    NotSpecified(0),
    @SerializedName("5")
    LTS(5),
    @SerializedName("10")
    Mainline(10),
    @SerializedName("15")
    Preview(15),
    @SerializedName("20")
    Development(20),
    @SerializedName("100")
    FastTrack(100),
    @SerializedName("1000")
    Nightly(1000),
    @SerializedName("10000")
    Bleeding(10000);

    /** The value of the enum. */
    private final int value;

    AMPReleaseStreams(int i) {
        this.value = i;
    }

    AMPReleaseStreams(double i) {
        this.value = (int) i;
    }
}
