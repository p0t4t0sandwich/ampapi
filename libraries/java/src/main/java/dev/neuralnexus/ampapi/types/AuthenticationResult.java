/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

/**
 * Represents the authentication result Failure: Failure TokenRejected: Token rejected
 * FullLoginRequired: Full callback required NoInstanceAccess: No instance access InstanceSuspended:
 * Instance suspended Success: Success PasswordChangeRequired: Password change required
 * AccountDisabled: Account disabled Ignored: Ignored TwoFactorChallenge: Two-factor challenge
 * TwoFactorSetupRequired: Two-factor setup required TwoFactorFailed: Two-factor failed
 * PassthruDisabled: Passthru disabled PassthruRejected: Passthru rejected LoginServerUnavailable:
 * Login server unavailable
 */
public enum AuthenticationResult {
    @SerializedName("0")
    Failure(0),
    @SerializedName("1")
    TokenRejected(1),
    @SerializedName("2")
    FullLoginRequired(2),
    @SerializedName("5")
    NoInstanceAccess(5),
    @SerializedName("6")
    InstanceSuspended(6),
    @SerializedName("10")
    Success(10),
    @SerializedName("20")
    PasswordChangeRequired(20),
    @SerializedName("25")
    AccountDisabled(25),
    @SerializedName("30")
    Ignored(30),
    @SerializedName("40")
    TwoFactorChallenge(40),
    @SerializedName("45")
    TwoFactorSetupRequired(45),
    @SerializedName("50")
    TwoFactorFailed(50),
    @SerializedName("100")
    PassthruDisabled(100),
    @SerializedName("110")
    PassthruRejected(110),
    @SerializedName("500")
    LoginServerUnavailable(500);

    /** The value of the enum. */
    private final int value;

    AuthenticationResult(int i) {
        this.value = i;
    }

    AuthenticationResult(double i) {
        this.value = (int) i;
    }
}
