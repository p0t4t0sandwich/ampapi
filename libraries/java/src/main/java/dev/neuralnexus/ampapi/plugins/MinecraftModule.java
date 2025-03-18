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
import java.util.List;
import java.util.Map;

public final class MinecraftModule extends AMPAPI {
    public MinecraftModule(AuthProvider authprovider) {
        super(authprovider);
    }

    /**
     * Name Description
     *
     * @return Boolean
     */
    public Boolean AcceptEULA() {
        Type type = new TypeToken<Boolean>() {}.getType();
        return this.APICall("MinecraftModule/AcceptEULA", type);
    }

    /**
     * Name Description
     *
     * @param UserOrUUID
     * @return ActionResult
     */
    public ActionResult AddOPEntry(String UserOrUUID) {
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
    public ActionResult AddToWhitelist(String UserOrUUID) {
        Map<String, Object> args = new HashMap<>();
        args.put("UserOrUUID", UserOrUUID);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("MinecraftModule/AddToWhitelist", args, type);
    }

    /**
     * Name Description
     *
     * @param ID
     */
    public void BanUserByID(String ID) {
        Map<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        this.APICall("MinecraftModule/BanUserByID", args);
    }

    /**
     * Name Description
     *
     * @return Map&lt;String, Object&gt;
     */
    public Map<String, Object> BukGetCategories() {
        Type type = new TypeToken<Map<String, Object>>() {}.getType();
        return this.APICall("MinecraftModule/BukGetCategories", type);
    }

    /**
     * Name Description
     *
     * @param pluginId
     * @return RunningTask
     */
    public RunningTask BukGetInstallUpdatePlugin(Integer pluginId) {
        Map<String, Object> args = new HashMap<>();
        args.put("pluginId", pluginId);
        Type type = new TypeToken<RunningTask>() {}.getType();
        return this.APICall("MinecraftModule/BukGetInstallUpdatePlugin", args, type);
    }

    /**
     * Name Description
     *
     * @return Map&lt;String, Object&gt;
     */
    public Map<String, Object> BukGetInstalledPlugins() {
        Type type = new TypeToken<Map<String, Object>>() {}.getType();
        return this.APICall("MinecraftModule/BukGetInstalledPlugins", type);
    }

    /**
     * Name Description
     *
     * @param PluginId
     * @return Map&lt;String, Object&gt;
     */
    public Map<String, Object> BukGetPluginInfo(Integer PluginId) {
        Map<String, Object> args = new HashMap<>();
        args.put("PluginId", PluginId);
        Type type = new TypeToken<Map<String, Object>>() {}.getType();
        return this.APICall("MinecraftModule/BukGetPluginInfo", args, type);
    }

    /**
     * Name Description
     *
     * @param CategoryId
     * @param PageNumber
     * @param PageSize
     * @return Map&lt;String, Object&gt;
     */
    public Map<String, Object> BukGetPluginsForCategory(
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
     * @return Map&lt;String, Object&gt;
     */
    public Map<String, Object> BukGetPopularPlugins() {
        Type type = new TypeToken<Map<String, Object>>() {}.getType();
        return this.APICall("MinecraftModule/BukGetPopularPlugins", type);
    }

    /**
     * Name Description
     *
     * @param PluginId
     */
    public void BukGetRemovePlugin(Integer PluginId) {
        Map<String, Object> args = new HashMap<>();
        args.put("PluginId", PluginId);
        this.APICall("MinecraftModule/BukGetRemovePlugin", args);
    }

    /**
     * Name Description
     *
     * @param Query
     * @param PageNumber
     * @param PageSize
     * @return Map&lt;String, Object&gt;
     */
    public Map<String, Object> BukGetSearch(String Query, Integer PageNumber, Integer PageSize) {
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
     * @param ID
     */
    public void ClearInventoryByID(String ID) {
        Map<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        this.APICall("MinecraftModule/ClearInventoryByID", args);
    }

    /**
     * Name Description
     *
     * @return String
     */
    public String GetFailureReason() {
        Type type = new TypeToken<String>() {}.getType();
        return this.APICall("MinecraftModule/GetFailureReason", type);
    }

    /**
     * Get a skin as a base64 string Name Description
     *
     * @param id
     * @return String
     */
    public String GetHeadByUUID(String id) {
        Map<String, Object> args = new HashMap<>();
        args.put("id", id);
        Type type = new TypeToken<String>() {}.getType();
        return this.APICall("MinecraftModule/GetHeadByUUID", args, type);
    }

    /**
     * Name Description
     *
     * @return UserAccessData
     */
    public UserAccessData GetOPWhitelist() {
        Type type = new TypeToken<UserAccessData>() {}.getType();
        return this.APICall("MinecraftModule/GetOPWhitelist", type);
    }

    /**
     * Name Description
     *
     * @return List&lt;WhitelistEntry&gt;
     */
    public List<WhitelistEntry> GetWhitelist() {
        Type type = new TypeToken<List<WhitelistEntry>>() {}.getType();
        return this.APICall("MinecraftModule/GetWhitelist", type);
    }

    /**
     * Name Description
     *
     * @param ID
     */
    public void KickUserByID(String ID) {
        Map<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        this.APICall("MinecraftModule/KickUserByID", args);
    }

    /**
     * Name Description
     *
     * @param ID
     */
    public void KillByID(String ID) {
        Map<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        this.APICall("MinecraftModule/KillByID", args);
    }

    /**
     * Name Description
     *
     * @return List&lt;OPEntry&gt;
     */
    public List<OPEntry> LoadOPList() {
        Type type = new TypeToken<List<OPEntry>>() {}.getType();
        return this.APICall("MinecraftModule/LoadOPList", type);
    }

    /**
     * Name Description
     *
     * @param UserOrUUID
     */
    public void RemoveOPEntry(String UserOrUUID) {
        Map<String, Object> args = new HashMap<>();
        args.put("UserOrUUID", UserOrUUID);
        this.APICall("MinecraftModule/RemoveOPEntry", args);
    }

    /**
     * Name Description
     *
     * @param UserOrUUID
     */
    public void RemoveWhitelistEntry(String UserOrUUID) {
        Map<String, Object> args = new HashMap<>();
        args.put("UserOrUUID", UserOrUUID);
        this.APICall("MinecraftModule/RemoveWhitelistEntry", args);
    }

    /**
     * Strike a player with lightning Name Description
     *
     * @param ID
     */
    public void SmiteByID(String ID) {
        Map<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        this.APICall("MinecraftModule/SmiteByID", args);
    }
}
