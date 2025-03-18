/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.plugins;

import com.google.gson.reflect.TypeToken;

import dev.neuralnexus.ampapi.AMPAPI;
import dev.neuralnexus.ampapi.auth.AuthProvider;
import dev.neuralnexus.ampapi.types.*;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public final class GenericModule extends AMPAPI {
    public GenericModule(AuthProvider authprovider) {
        super(authprovider);
    }

    /**
     * Name Description
     *
     * @param filename
     * @return Map&lt;String, String&gt;
     */
    public Map<String, String> ImportConfig(String filename) {
        Map<String, Object> args = new HashMap<>();
        args.put("filename", filename);
        Type type = new TypeToken<Map<String, String>>() {}.getType();
        return this.APICall("GenericModule/ImportConfig", args, type);
    }

    /** Name Description */
    public void ReloadGenericConfig() {
        this.APICall("GenericModule/ReloadGenericConfig");
    }
}
