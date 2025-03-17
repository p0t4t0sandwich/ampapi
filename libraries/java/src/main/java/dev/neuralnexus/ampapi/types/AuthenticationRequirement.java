package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * Represents the authentication requirement
 * None_: None
 * Username: Username
 * Password: Password
 * TOTP: TOTP
 * Passkeys: Passkeys
 */
public enum AuthenticationRequirement {
    @SerializedName("0")
    None_(0),
    @SerializedName("1")
    Username(1),
    @SerializedName("2")
    Password(2),
    @SerializedName("4")
    TOTP(4),
    @SerializedName("8")
    Passkeys(8);

    /** The value of the enum. */
    private final int value;

    AuthenticationRequirement(int i) {
        this.value = i;
    }

    AuthenticationRequirement(double i) {
        this.value = (int) i;
    }
}
