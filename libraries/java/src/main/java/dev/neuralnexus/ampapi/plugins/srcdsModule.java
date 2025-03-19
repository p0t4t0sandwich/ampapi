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
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public final class srcdsModule extends AMPAPI {
    public srcdsModule(AuthProvider authprovider) {
        super(authprovider);
    }

    /**
     * Name Description
     *
     * @param ID
     * @return Void
     */
    public Result<Void, AMPError> BanUserByID(String ID) {
        Map<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("srcdsModule/BanUserByID", args, type);
    }

    /**
     * Name Description
     *
     * @param ID
     * @return Void
     */
    public CompletionStage<Result<Void, AMPError>> BanUserByIDAsync(String ID) {
        return CompletableFuture.supplyAsync(() -> this.BanUserByID(ID));
    }

    /**
     * Name Description
     *
     * @return List&lt;String&gt;
     */
    public Result<List<String>, AMPError> GetMapCycle() {
        Type type = new TypeToken<List<String>>() {}.getType();
        return this.APICall("srcdsModule/GetMapCycle", type);
    }

    /**
     * Name Description
     *
     * @return List&lt;String&gt;
     */
    public CompletionStage<Result<List<String>, AMPError>> GetMapCycleAsync() {
        return CompletableFuture.supplyAsync(() -> this.GetMapCycle());
    }

    /**
     * Name Description
     *
     * @param MapName
     * @return Void
     */
    public Result<Void, AMPError> InsertMapEntry(String MapName) {
        Map<String, Object> args = new HashMap<>();
        args.put("MapName", MapName);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("srcdsModule/InsertMapEntry", args, type);
    }

    /**
     * Name Description
     *
     * @param MapName
     * @return Void
     */
    public CompletionStage<Result<Void, AMPError>> InsertMapEntryAsync(String MapName) {
        return CompletableFuture.supplyAsync(() -> this.InsertMapEntry(MapName));
    }

    /**
     * Name Description
     *
     * @param ID
     * @return Void
     */
    public Result<Void, AMPError> KickUserByID(String ID) {
        Map<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("srcdsModule/KickUserByID", args, type);
    }

    /**
     * Name Description
     *
     * @param ID
     * @return Void
     */
    public CompletionStage<Result<Void, AMPError>> KickUserByIDAsync(String ID) {
        return CompletableFuture.supplyAsync(() -> this.KickUserByID(ID));
    }

    /**
     * Name Description
     *
     * @param Index
     * @param NewIndex
     * @return Void
     */
    public Result<Void, AMPError> MoveMapEntry(Integer Index, Integer NewIndex) {
        Map<String, Object> args = new HashMap<>();
        args.put("Index", Index);
        args.put("NewIndex", NewIndex);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("srcdsModule/MoveMapEntry", args, type);
    }

    /**
     * Name Description
     *
     * @param Index
     * @param NewIndex
     * @return Void
     */
    public CompletionStage<Result<Void, AMPError>> MoveMapEntryAsync(
            Integer Index, Integer NewIndex) {
        return CompletableFuture.supplyAsync(() -> this.MoveMapEntry(Index, NewIndex));
    }

    /**
     * Name Description
     *
     * @param Name
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> RecordDemo(String Name) {
        Map<String, Object> args = new HashMap<>();
        args.put("Name", Name);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("srcdsModule/RecordDemo", args, type);
    }

    /**
     * Name Description
     *
     * @param Name
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> RecordDemoAsync(String Name) {
        return CompletableFuture.supplyAsync(() -> this.RecordDemo(Name));
    }

    /**
     * Name Description
     *
     * @param Index
     * @return Void
     */
    public Result<Void, AMPError> RemoveMapEntry(Integer Index) {
        Map<String, Object> args = new HashMap<>();
        args.put("Index", Index);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("srcdsModule/RemoveMapEntry", args, type);
    }

    /**
     * Name Description
     *
     * @param Index
     * @return Void
     */
    public CompletionStage<Result<Void, AMPError>> RemoveMapEntryAsync(Integer Index) {
        return CompletableFuture.supplyAsync(() -> this.RemoveMapEntry(Index));
    }

    /**
     * Name Description
     *
     * @param MapList
     * @return Void
     */
    public Result<Void, AMPError> ReplaceMapList(String[] MapList) {
        Map<String, Object> args = new HashMap<>();
        args.put("MapList", MapList);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("srcdsModule/ReplaceMapList", args, type);
    }

    /**
     * Name Description
     *
     * @param MapList
     * @return Void
     */
    public CompletionStage<Result<Void, AMPError>> ReplaceMapListAsync(String[] MapList) {
        return CompletableFuture.supplyAsync(() -> this.ReplaceMapList(MapList));
    }
}
