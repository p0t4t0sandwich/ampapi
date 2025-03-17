package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * Represents the post create app actions
 * DoNothing: Do nothing
 * UpdateOnce: Update once
 * UpdateAlways: Update always
 * UpdateAndStartOnce: Update and start once
 * UpdateAndStartAlways: Update and start always
 * StartAlways: Start always
 */
public enum PostCreateAppActions {
    @SerializedName("0")
    DoNothing(0),
    @SerializedName("1")
    UpdateOnce(1),
    @SerializedName("2")
    UpdateAlways(2),
    @SerializedName("3")
    UpdateAndStartOnce(3),
    @SerializedName("4")
    UpdateAndStartAlways(4),
    @SerializedName("5")
    StartAlways(5);

    /** The value of the enum. */
    private final int value;

    PostCreateAppActions(int i) {
        this.value = i;
    }

    PostCreateAppActions(double i) {
        this.value = (int) i;
    }
}
