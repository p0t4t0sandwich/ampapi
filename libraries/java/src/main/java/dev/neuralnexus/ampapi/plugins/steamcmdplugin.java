package dev.neuralnexus.ampapi.plugins;

import com.google.gson.reflect.TypeToken;

import dev.neuralnexus.ampapi.AMPAPI;
import dev.neuralnexus.ampapi.types.*;
import dev.neuralnexus.ampapi.auth.AuthProvider;

import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Type;
import java.net.InetAddress;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class steamcmdplugin extends AMPAPI {
    public steamcmdplugin(AuthProvider authprovider) {
        super(authprovider);
    }

    /**
     * Name Description Optional

     * @return Void
     */
    public Void CancelSteamGuard() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("steamcmdplugin/CancelSteamGuard", args, type);
    }

    /**
     * Name Description Optional
     * @param code 
     * @return Void
     */
    public Void SteamGuardCode(String code) {
        Map<String, Object> args = new HashMap<>();
        args.put("code", code);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("steamcmdplugin/SteamGuardCode", args, type);
    }

    /**
     * Name Description Optional
     * @param username 
     * @param password 
     * @return Void
     */
    public Void SteamUsernamePassword(String username, String password) {
        Map<String, Object> args = new HashMap<>();
        args.put("username", username);
        args.put("password", password);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("steamcmdplugin/SteamUsernamePassword", args, type);
    }


}