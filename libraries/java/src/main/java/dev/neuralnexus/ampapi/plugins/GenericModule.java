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

public final class GenericModule extends AMPAPI {
    public GenericModule(AuthProvider authprovider) {
        super(authprovider);
    }

    /**
     * Name Description Optional
     * @param filename 
     * @return Map<String, String>
     */
    public Map<String, String> ImportConfig(String filename) {
        Map<String, Object> args = new HashMap<>();
        args.put("filename", filename);
        Type type = new TypeToken<Map<String, String>>() {}.getType();
        return this.APICall("GenericModule/ImportConfig", args, type);
    }

    /**
     * Name Description Optional

     * @return Void
     */
    public Void ReloadGenericConfig() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("GenericModule/ReloadGenericConfig", args, type);
    }


}