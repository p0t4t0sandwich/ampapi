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

public final class RustModule extends AMPAPI {
    public RustModule(AuthProvider authprovider) {
        super(authprovider);
    }

    /**
     * Name Description
     *
     * @param ID
     * @return Void
     */
    public Result<Void, AMPError> Ban(String ID) {
        Map<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("RustModule/Ban", args, type);
    }

    /**
     * Name Description
     *
     * @param ID
     * @return Void
     */
    public CompletionStage<Result<Void, AMPError>> BanAsync(String ID) {
        return CompletableFuture.supplyAsync(() -> this.Ban(ID));
    }

    /**
     * Name Description
     *
     * @param ID
     * @return Void
     */
    public Result<Void, AMPError> Kick(String ID) {
        Map<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("RustModule/Kick", args, type);
    }

    /**
     * Name Description
     *
     * @param ID
     * @return Void
     */
    public CompletionStage<Result<Void, AMPError>> KickAsync(String ID) {
        return CompletableFuture.supplyAsync(() -> this.Kick(ID));
    }

    /**
     * Name Description
     *
     * @return Void
     */
    public Result<Void, AMPError> WipeBlueprints() {
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("RustModule/WipeBlueprints", type);
    }

    /**
     * Name Description
     *
     * @return Void
     */
    public CompletionStage<Result<Void, AMPError>> WipeBlueprintsAsync() {
        return CompletableFuture.supplyAsync(() -> this.WipeBlueprints());
    }

    /**
     * Name Description
     *
     * @return Void
     */
    public Result<Void, AMPError> WipeMap() {
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("RustModule/WipeMap", type);
    }

    /**
     * Name Description
     *
     * @return Void
     */
    public CompletionStage<Result<Void, AMPError>> WipeMapAsync() {
        return CompletableFuture.supplyAsync(() -> this.WipeMap());
    }
}
