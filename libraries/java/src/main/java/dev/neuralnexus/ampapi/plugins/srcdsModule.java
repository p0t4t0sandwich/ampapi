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

public final class srcdsModule extends AMPAPI {
    public srcdsModule(AuthProvider authprovider) {
        super(authprovider);
    }

    /**
     * Name Description Optional
     *
     * @param ID
     */
    public void BanUserByID(String ID) {
        Map<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        this.APICall("srcdsModule/BanUserByID", args);
    }

    /**
     * Name Description Optional
     *
     * @return List&lt;String&gt;
     */
    public List<String> GetMapCycle() {
        Type type = new TypeToken<List<String>>() {}.getType();
        return this.APICall("srcdsModule/GetMapCycle", type);
    }

    /**
     * Name Description Optional
     *
     * @param MapName
     */
    public void InsertMapEntry(String MapName) {
        Map<String, Object> args = new HashMap<>();
        args.put("MapName", MapName);
        this.APICall("srcdsModule/InsertMapEntry", args);
    }

    /**
     * Name Description Optional
     *
     * @param ID
     */
    public void KickUserByID(String ID) {
        Map<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        this.APICall("srcdsModule/KickUserByID", args);
    }

    /**
     * Name Description Optional
     *
     * @param Index
     * @param NewIndex
     */
    public void MoveMapEntry(Integer Index, Integer NewIndex) {
        Map<String, Object> args = new HashMap<>();
        args.put("Index", Index);
        args.put("NewIndex", NewIndex);
        this.APICall("srcdsModule/MoveMapEntry", args);
    }

    /**
     * Name Description Optional
     *
     * @param Name
     * @return ActionResult
     */
    public ActionResult RecordDemo(String Name) {
        Map<String, Object> args = new HashMap<>();
        args.put("Name", Name);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("srcdsModule/RecordDemo", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param Index
     */
    public void RemoveMapEntry(Integer Index) {
        Map<String, Object> args = new HashMap<>();
        args.put("Index", Index);
        this.APICall("srcdsModule/RemoveMapEntry", args);
    }

    /**
     * Name Description Optional
     *
     * @param MapList
     */
    public void ReplaceMapList(String[] MapList) {
        Map<String, Object> args = new HashMap<>();
        args.put("MapList", MapList);
        this.APICall("srcdsModule/ReplaceMapList", args);
    }
}
