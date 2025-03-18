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

public final class RCONPlugin extends AMPAPI {
    public RCONPlugin(AuthProvider authprovider) {
        super(authprovider);
    }

    /**
     * Name Description
     *
     * @return Void
     */
    public Result<Void, AMPError> Dummy() {
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("RCONPlugin/Dummy", type);
    }
}
