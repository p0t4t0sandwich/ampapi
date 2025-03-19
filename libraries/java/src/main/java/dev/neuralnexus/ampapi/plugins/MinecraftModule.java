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

public final class MinecraftModule extends AMPAPI {
    public MinecraftModule(AuthProvider authprovider) {
        super(authprovider);
    }

    /**
     * Name Description
     *
     * @return Boolean
     */
    public Result<Boolean, AMPError> AcceptEULA() {
        Type type = new TypeToken<Boolean>() {}.getType();
        return this.APICall("MinecraftModule/AcceptEULA", type);
    }

    /**
     * Name Description
     *
     * @return Boolean
     */
    public CompletionStage<Result<Boolean, AMPError>> AcceptEULAAsync() {
        return CompletableFuture.supplyAsync(() -> this.AcceptEULA());
    }

    /**
     * Name Description
     *
     * @param UserOrUUID
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> AddOPEntry(String UserOrUUID) {
        Map<String, Object> args = new HashMap<>();
        args.put("UserOrUUID", UserOrUUID);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("MinecraftModule/AddOPEntry", args, type);
    }

    /**
     * Name Description
     *
     * @param UserOrUUID
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> AddOPEntryAsync(String UserOrUUID) {
        return CompletableFuture.supplyAsync(() -> this.AddOPEntry(UserOrUUID));
    }

    /**
     * Name Description
     *
     * @param UserOrUUID
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> AddToWhitelist(String UserOrUUID) {
        Map<String, Object> args = new HashMap<>();
        args.put("UserOrUUID", UserOrUUID);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("MinecraftModule/AddToWhitelist", args, type);
    }

    /**
     * Name Description
     *
     * @param UserOrUUID
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> AddToWhitelistAsync(String UserOrUUID) {
        return CompletableFuture.supplyAsync(() -> this.AddToWhitelist(UserOrUUID));
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
        return this.APICall("MinecraftModule/BanUserByID", args, type);
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
     * @return Map&lt;String, Object&gt;
     */
    public Result<Map<String, Object>, AMPError> BukGetCategories() {
        Type type = new TypeToken<Map<String, Object>>() {}.getType();
        return this.APICall("MinecraftModule/BukGetCategories", type);
    }

    /**
     * Name Description
     *
     * @return Map&lt;String, Object&gt;
     */
    public CompletionStage<Result<Map<String, Object>, AMPError>> BukGetCategoriesAsync() {
        return CompletableFuture.supplyAsync(() -> this.BukGetCategories());
    }

    /**
     * Name Description
     *
     * @param pluginId
     * @return RunningTask
     */
    public Result<RunningTask, AMPError> BukGetInstallUpdatePlugin(Integer pluginId) {
        Map<String, Object> args = new HashMap<>();
        args.put("pluginId", pluginId);
        Type type = new TypeToken<RunningTask>() {}.getType();
        return this.APICall("MinecraftModule/BukGetInstallUpdatePlugin", args, type);
    }

    /**
     * Name Description
     *
     * @param pluginId
     * @return RunningTask
     */
    public CompletionStage<Result<RunningTask, AMPError>> BukGetInstallUpdatePluginAsync(
            Integer pluginId) {
        return CompletableFuture.supplyAsync(() -> this.BukGetInstallUpdatePlugin(pluginId));
    }

    /**
     * Name Description
     *
     * @return Map&lt;String, Object&gt;
     */
    public Result<Map<String, Object>, AMPError> BukGetInstalledPlugins() {
        Type type = new TypeToken<Map<String, Object>>() {}.getType();
        return this.APICall("MinecraftModule/BukGetInstalledPlugins", type);
    }

    /**
     * Name Description
     *
     * @return Map&lt;String, Object&gt;
     */
    public CompletionStage<Result<Map<String, Object>, AMPError>> BukGetInstalledPluginsAsync() {
        return CompletableFuture.supplyAsync(() -> this.BukGetInstalledPlugins());
    }

    /**
     * Name Description
     *
     * @param PluginId
     * @return Map&lt;String, Object&gt;
     */
    public Result<Map<String, Object>, AMPError> BukGetPluginInfo(Integer PluginId) {
        Map<String, Object> args = new HashMap<>();
        args.put("PluginId", PluginId);
        Type type = new TypeToken<Map<String, Object>>() {}.getType();
        return this.APICall("MinecraftModule/BukGetPluginInfo", args, type);
    }

    /**
     * Name Description
     *
     * @param PluginId
     * @return Map&lt;String, Object&gt;
     */
    public CompletionStage<Result<Map<String, Object>, AMPError>> BukGetPluginInfoAsync(
            Integer PluginId) {
        return CompletableFuture.supplyAsync(() -> this.BukGetPluginInfo(PluginId));
    }

    /**
     * Name Description
     *
     * @param CategoryId
     * @param PageNumber
     * @param PageSize
     * @return Map&lt;String, Object&gt;
     */
    public Result<Map<String, Object>, AMPError> BukGetPluginsForCategory(
            String CategoryId, Integer PageNumber, Integer PageSize) {
        Map<String, Object> args = new HashMap<>();
        args.put("CategoryId", CategoryId);
        args.put("PageNumber", PageNumber);
        args.put("PageSize", PageSize);
        Type type = new TypeToken<Map<String, Object>>() {}.getType();
        return this.APICall("MinecraftModule/BukGetPluginsForCategory", args, type);
    }

    /**
     * Name Description
     *
     * @param CategoryId
     * @param PageNumber
     * @param PageSize
     * @return Map&lt;String, Object&gt;
     */
    public CompletionStage<Result<Map<String, Object>, AMPError>> BukGetPluginsForCategoryAsync(
            String CategoryId, Integer PageNumber, Integer PageSize) {
        return CompletableFuture.supplyAsync(
                () -> this.BukGetPluginsForCategory(CategoryId, PageNumber, PageSize));
    }

    /**
     * Name Description
     *
     * @return Map&lt;String, Object&gt;
     */
    public Result<Map<String, Object>, AMPError> BukGetPopularPlugins() {
        Type type = new TypeToken<Map<String, Object>>() {}.getType();
        return this.APICall("MinecraftModule/BukGetPopularPlugins", type);
    }

    /**
     * Name Description
     *
     * @return Map&lt;String, Object&gt;
     */
    public CompletionStage<Result<Map<String, Object>, AMPError>> BukGetPopularPluginsAsync() {
        return CompletableFuture.supplyAsync(() -> this.BukGetPopularPlugins());
    }

    /**
     * Name Description
     *
     * @param PluginId
     * @return Void
     */
    public Result<Void, AMPError> BukGetRemovePlugin(Integer PluginId) {
        Map<String, Object> args = new HashMap<>();
        args.put("PluginId", PluginId);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("MinecraftModule/BukGetRemovePlugin", args, type);
    }

    /**
     * Name Description
     *
     * @param PluginId
     * @return Void
     */
    public CompletionStage<Result<Void, AMPError>> BukGetRemovePluginAsync(Integer PluginId) {
        return CompletableFuture.supplyAsync(() -> this.BukGetRemovePlugin(PluginId));
    }

    /**
     * Name Description
     *
     * @param Query
     * @param PageNumber
     * @param PageSize
     * @return Map&lt;String, Object&gt;
     */
    public Result<Map<String, Object>, AMPError> BukGetSearch(
            String Query, Integer PageNumber, Integer PageSize) {
        Map<String, Object> args = new HashMap<>();
        args.put("Query", Query);
        args.put("PageNumber", PageNumber);
        args.put("PageSize", PageSize);
        Type type = new TypeToken<Map<String, Object>>() {}.getType();
        return this.APICall("MinecraftModule/BukGetSearch", args, type);
    }

    /**
     * Name Description
     *
     * @param Query
     * @param PageNumber
     * @param PageSize
     * @return Map&lt;String, Object&gt;
     */
    public CompletionStage<Result<Map<String, Object>, AMPError>> BukGetSearchAsync(
            String Query, Integer PageNumber, Integer PageSize) {
        return CompletableFuture.supplyAsync(() -> this.BukGetSearch(Query, PageNumber, PageSize));
    }

    /**
     * Name Description
     *
     * @param ID
     * @return Void
     */
    public Result<Void, AMPError> ClearInventoryByID(String ID) {
        Map<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("MinecraftModule/ClearInventoryByID", args, type);
    }

    /**
     * Name Description
     *
     * @param ID
     * @return Void
     */
    public CompletionStage<Result<Void, AMPError>> ClearInventoryByIDAsync(String ID) {
        return CompletableFuture.supplyAsync(() -> this.ClearInventoryByID(ID));
    }

    /**
     * Name Description
     *
     * @return String
     */
    public Result<String, AMPError> GetFailureReason() {
        Type type = new TypeToken<String>() {}.getType();
        return this.APICall("MinecraftModule/GetFailureReason", type);
    }

    /**
     * Name Description
     *
     * @return String
     */
    public CompletionStage<Result<String, AMPError>> GetFailureReasonAsync() {
        return CompletableFuture.supplyAsync(() -> this.GetFailureReason());
    }

    /**
     * Get a skin as a base64 string Name Description
     *
     * @param id
     * @return String
     */
    public Result<String, AMPError> GetHeadByUUID(String id) {
        Map<String, Object> args = new HashMap<>();
        args.put("id", id);
        Type type = new TypeToken<String>() {}.getType();
        return this.APICall("MinecraftModule/GetHeadByUUID", args, type);
    }

    /**
     * Get a skin as a base64 string Name Description
     *
     * @param id
     * @return String
     */
    public CompletionStage<Result<String, AMPError>> GetHeadByUUIDAsync(String id) {
        return CompletableFuture.supplyAsync(() -> this.GetHeadByUUID(id));
    }

    /**
     * Name Description
     *
     * @return UserAccessData
     */
    public Result<UserAccessData, AMPError> GetOPWhitelist() {
        Type type = new TypeToken<UserAccessData>() {}.getType();
        return this.APICall("MinecraftModule/GetOPWhitelist", type);
    }

    /**
     * Name Description
     *
     * @return UserAccessData
     */
    public CompletionStage<Result<UserAccessData, AMPError>> GetOPWhitelistAsync() {
        return CompletableFuture.supplyAsync(() -> this.GetOPWhitelist());
    }

    /**
     * Name Description
     *
     * @return List&lt;WhitelistEntry&gt;
     */
    public Result<List<WhitelistEntry>, AMPError> GetWhitelist() {
        Type type = new TypeToken<List<WhitelistEntry>>() {}.getType();
        return this.APICall("MinecraftModule/GetWhitelist", type);
    }

    /**
     * Name Description
     *
     * @return List&lt;WhitelistEntry&gt;
     */
    public CompletionStage<Result<List<WhitelistEntry>, AMPError>> GetWhitelistAsync() {
        return CompletableFuture.supplyAsync(() -> this.GetWhitelist());
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
        return this.APICall("MinecraftModule/KickUserByID", args, type);
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
     * @param ID
     * @return Void
     */
    public Result<Void, AMPError> KillByID(String ID) {
        Map<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("MinecraftModule/KillByID", args, type);
    }

    /**
     * Name Description
     *
     * @param ID
     * @return Void
     */
    public CompletionStage<Result<Void, AMPError>> KillByIDAsync(String ID) {
        return CompletableFuture.supplyAsync(() -> this.KillByID(ID));
    }

    /**
     * Name Description
     *
     * @return List&lt;OPEntry&gt;
     */
    public Result<List<OPEntry>, AMPError> LoadOPList() {
        Type type = new TypeToken<List<OPEntry>>() {}.getType();
        return this.APICall("MinecraftModule/LoadOPList", type);
    }

    /**
     * Name Description
     *
     * @return List&lt;OPEntry&gt;
     */
    public CompletionStage<Result<List<OPEntry>, AMPError>> LoadOPListAsync() {
        return CompletableFuture.supplyAsync(() -> this.LoadOPList());
    }

    /**
     * Name Description
     *
     * @param UserOrUUID
     * @return Void
     */
    public Result<Void, AMPError> RemoveOPEntry(String UserOrUUID) {
        Map<String, Object> args = new HashMap<>();
        args.put("UserOrUUID", UserOrUUID);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("MinecraftModule/RemoveOPEntry", args, type);
    }

    /**
     * Name Description
     *
     * @param UserOrUUID
     * @return Void
     */
    public CompletionStage<Result<Void, AMPError>> RemoveOPEntryAsync(String UserOrUUID) {
        return CompletableFuture.supplyAsync(() -> this.RemoveOPEntry(UserOrUUID));
    }

    /**
     * Name Description
     *
     * @param UserOrUUID
     * @return Void
     */
    public Result<Void, AMPError> RemoveWhitelistEntry(String UserOrUUID) {
        Map<String, Object> args = new HashMap<>();
        args.put("UserOrUUID", UserOrUUID);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("MinecraftModule/RemoveWhitelistEntry", args, type);
    }

    /**
     * Name Description
     *
     * @param UserOrUUID
     * @return Void
     */
    public CompletionStage<Result<Void, AMPError>> RemoveWhitelistEntryAsync(String UserOrUUID) {
        return CompletableFuture.supplyAsync(() -> this.RemoveWhitelistEntry(UserOrUUID));
    }

    /**
     * Strike a player with lightning Name Description
     *
     * @param ID
     * @return Void
     */
    public Result<Void, AMPError> SmiteByID(String ID) {
        Map<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("MinecraftModule/SmiteByID", args, type);
    }

    /**
     * Strike a player with lightning Name Description
     *
     * @param ID
     * @return Void
     */
    public CompletionStage<Result<Void, AMPError>> SmiteByIDAsync(String ID) {
        return CompletableFuture.supplyAsync(() -> this.SmiteByID(ID));
    }
}
