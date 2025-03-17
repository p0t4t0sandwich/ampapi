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

public final class MinecraftModule extends AMPAPI {
    public MinecraftModule(AuthProvider authprovider) {
        super(authprovider);
    }

    /**
     * Name Description Optional

     * @return Boolean
     */
    public Boolean AcceptEULA() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Boolean>() {}.getType();
        return this.APICall("MinecraftModule/AcceptEULA", args, type);
    }

    /**
     * Name Description Optional
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
     * Name Description Optional
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
     * Name Description Optional
     * @param ID 
     * @return Void
     */
    public Void BanUserByID(String ID) {
        Map<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("MinecraftModule/BanUserByID", args, type);
    }

    /**
     * Name Description Optional

     * @return Map<String, Object>
     */
    public Map<String, Object> BukGetCategories() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Map<String, Object>>() {}.getType();
        return this.APICall("MinecraftModule/BukGetCategories", args, type);
    }

    /**
     * Name Description Optional
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
     * Name Description Optional

     * @return Map<String, Object>
     */
    public Map<String, Object> BukGetInstalledPlugins() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Map<String, Object>>() {}.getType();
        return this.APICall("MinecraftModule/BukGetInstalledPlugins", args, type);
    }

    /**
     * Name Description Optional
     * @param PluginId 
     * @return Map<String, Object>
     */
    public Map<String, Object> BukGetPluginInfo(Integer PluginId) {
        Map<String, Object> args = new HashMap<>();
        args.put("PluginId", PluginId);
        Type type = new TypeToken<Map<String, Object>>() {}.getType();
        return this.APICall("MinecraftModule/BukGetPluginInfo", args, type);
    }

    /**
     * Name Description Optional
     * @param CategoryId 
     * @param PageNumber 
     * @param PageSize 
     * @return Map<String, Object>
     */
    public Map<String, Object> BukGetPluginsForCategory(String CategoryId, Integer PageNumber, Integer PageSize) {
        Map<String, Object> args = new HashMap<>();
        args.put("CategoryId", CategoryId);
        args.put("PageNumber", PageNumber);
        args.put("PageSize", PageSize);
        Type type = new TypeToken<Map<String, Object>>() {}.getType();
        return this.APICall("MinecraftModule/BukGetPluginsForCategory", args, type);
    }

    /**
     * Name Description Optional

     * @return Map<String, Object>
     */
    public Map<String, Object> BukGetPopularPlugins() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Map<String, Object>>() {}.getType();
        return this.APICall("MinecraftModule/BukGetPopularPlugins", args, type);
    }

    /**
     * Name Description Optional
     * @param PluginId 
     * @return Void
     */
    public Void BukGetRemovePlugin(Integer PluginId) {
        Map<String, Object> args = new HashMap<>();
        args.put("PluginId", PluginId);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("MinecraftModule/BukGetRemovePlugin", args, type);
    }

    /**
     * Name Description Optional
     * @param Query 
     * @param PageNumber 
     * @param PageSize 
     * @return Map<String, Object>
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
     * Name Description Optional
     * @param ID 
     * @return Void
     */
    public Void ClearInventoryByID(String ID) {
        Map<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("MinecraftModule/ClearInventoryByID", args, type);
    }

    /**
     * Name Description Optional

     * @return String
     */
    public String GetFailureReason() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<String>() {}.getType();
        return this.APICall("MinecraftModule/GetFailureReason", args, type);
    }

    /**Get a skin as a base64 string
     * Name Description Optional
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
     * Name Description Optional

     * @return UserAccessData
     */
    public UserAccessData GetOPWhitelist() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<UserAccessData>() {}.getType();
        return this.APICall("MinecraftModule/GetOPWhitelist", args, type);
    }

    /**
     * Name Description Optional

     * @return List<WhitelistEntry>
     */
    public List<WhitelistEntry> GetWhitelist() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<WhitelistEntry>>() {}.getType();
        return this.APICall("MinecraftModule/GetWhitelist", args, type);
    }

    /**
     * Name Description Optional
     * @param ID 
     * @return Void
     */
    public Void KickUserByID(String ID) {
        Map<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("MinecraftModule/KickUserByID", args, type);
    }

    /**
     * Name Description Optional
     * @param ID 
     * @return Void
     */
    public Void KillByID(String ID) {
        Map<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("MinecraftModule/KillByID", args, type);
    }

    /**
     * Name Description Optional

     * @return List<OPEntry>
     */
    public List<OPEntry> LoadOPList() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<OPEntry>>() {}.getType();
        return this.APICall("MinecraftModule/LoadOPList", args, type);
    }

    /**
     * Name Description Optional
     * @param UserOrUUID 
     * @return Void
     */
    public Void RemoveOPEntry(String UserOrUUID) {
        Map<String, Object> args = new HashMap<>();
        args.put("UserOrUUID", UserOrUUID);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("MinecraftModule/RemoveOPEntry", args, type);
    }

    /**
     * Name Description Optional
     * @param UserOrUUID 
     * @return Void
     */
    public Void RemoveWhitelistEntry(String UserOrUUID) {
        Map<String, Object> args = new HashMap<>();
        args.put("UserOrUUID", UserOrUUID);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("MinecraftModule/RemoveWhitelistEntry", args, type);
    }

    /**Strike a player with lightning
     * Name Description Optional
     * @param ID 
     * @return Void
     */
    public Void SmiteByID(String ID) {
        Map<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("MinecraftModule/SmiteByID", args, type);
    }


}