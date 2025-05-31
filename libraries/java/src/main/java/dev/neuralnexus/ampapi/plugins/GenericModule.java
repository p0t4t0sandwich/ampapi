/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.plugins;

import com.github.sviperll.result4j.Result;
import com.google.gson.reflect.TypeToken;

import dev.neuralnexus.ampapi.AMPAPI;
import dev.neuralnexus.ampapi.AMPError;
import dev.neuralnexus.ampapi.auth.AuthProvider;
import dev.neuralnexus.ampapi.types.*;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

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
    public Result<Map<String, String>, AMPError> ImportConfig(String filename) {
        Map<String, Object> args = new HashMap<>();
        args.put("filename", filename);
        Type type = new TypeToken<Map<String, String>>() {}.getType();
        return this.APICall("GenericModule/ImportConfig", args, type);
    }

    /**
     * Name Description
     *
     * @param filename
     * @return Map&lt;String, String&gt;
     */
    public CompletionStage<Result<Map<String, String>, AMPError>> ImportConfigAsync(
            String filename) {
        return CompletableFuture.supplyAsync(() -> this.ImportConfig(filename));
    }

    /**
     * Name Description
     *
     * @return Void
     */
    public Result<Void, AMPError> ReloadGenericConfig() {
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("GenericModule/ReloadGenericConfig", type);
    }

    /**
     * Name Description
     *
     * @return Void
     */
    public CompletionStage<Result<Void, AMPError>> ReloadGenericConfigAsync() {
        return CompletableFuture.supplyAsync(() -> this.ReloadGenericConfig());
    }

    /**
     * Name Description
     *
     * @return Void
     */
    public Result<Void, AMPError> RequestServerInfo() {
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("GenericModule/RequestServerInfo", type);
    }

    /**
     * Name Description
     *
     * @return Void
     */
    public CompletionStage<Result<Void, AMPError>> RequestServerInfoAsync() {
        return CompletableFuture.supplyAsync(() -> this.RequestServerInfo());
    }
}
