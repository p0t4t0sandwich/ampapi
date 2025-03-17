/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.plugins;

import dev.neuralnexus.ampapi.AMPAPI;
import dev.neuralnexus.ampapi.auth.AuthProvider;
import dev.neuralnexus.ampapi.types.*;

import java.util.HashMap;
import java.util.Map;

public final class steamcmdplugin extends AMPAPI {
    public steamcmdplugin(AuthProvider authprovider) {
        super(authprovider);
    }

    /** */
    public void CancelSteamGuard() {
        this.APICall("steamcmdplugin/CancelSteamGuard");
    }

    /**
     * Name Description Optional
     *
     * @param code
     */
    public void SteamGuardCode(String code) {
        Map<String, Object> args = new HashMap<>();
        args.put("code", code);
        this.APICall("steamcmdplugin/SteamGuardCode", args);
    }

    /**
     * Name Description Optional
     *
     * @param username
     * @param password
     */
    public void SteamUsernamePassword(String username, String password) {
        Map<String, Object> args = new HashMap<>();
        args.put("username", username);
        args.put("password", password);
        this.APICall("steamcmdplugin/SteamUsernamePassword", args);
    }
}
