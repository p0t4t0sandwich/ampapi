/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.plugins;

import com.github.sviperll.result4j.Result;
import com.google.gson.reflect.TypeToken;

import dev.neuralnexus.ampapi.AMPAPI;
import dev.neuralnexus.ampapi.auth.AuthProvider;
import dev.neuralnexus.ampapi.AMPError;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public final class steamcmdplugin extends AMPAPI {
    public steamcmdplugin(AuthProvider authprovider) {
        super(authprovider);
    }

    /**
     * Name Description
     *
     * @return Void
     */
    public Result<Void, AMPError> CancelSteamGuard() {
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("steamcmdplugin/CancelSteamGuard", type);
    }

    /**
     * Name Description
     *
     * @param code
     * @return Void
     */
    public Result<Void, AMPError> SteamGuardCode(String code) {
        Map<String, Object> args = new HashMap<>();
        args.put("code", code);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("steamcmdplugin/SteamGuardCode", args, type);
    }

    /**
     * Name Description
     *
     * @param username
     * @param password
     * @return Void
     */
    public Result<Void, AMPError> SteamUsernamePassword(String username, String password) {
        Map<String, Object> args = new HashMap<>();
        args.put("username", username);
        args.put("password", password);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("steamcmdplugin/SteamUsernamePassword", args, type);
    }
}
