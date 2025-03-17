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

public final class srcdsModule extends AMPAPI {
    public srcdsModule(AuthProvider authprovider) {
        super(authprovider);
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
        return this.APICall("srcdsModule/BanUserByID", args, type);
    }

    /**
     * Name Description Optional

     * @return List<String>
     */
    public List<String> GetMapCycle() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<String>>() {}.getType();
        return this.APICall("srcdsModule/GetMapCycle", args, type);
    }

    /**
     * Name Description Optional
     * @param MapName 
     * @return Void
     */
    public Void InsertMapEntry(String MapName) {
        Map<String, Object> args = new HashMap<>();
        args.put("MapName", MapName);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("srcdsModule/InsertMapEntry", args, type);
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
        return this.APICall("srcdsModule/KickUserByID", args, type);
    }

    /**
     * Name Description Optional
     * @param Index 
     * @param NewIndex 
     * @return Void
     */
    public Void MoveMapEntry(Integer Index, Integer NewIndex) {
        Map<String, Object> args = new HashMap<>();
        args.put("Index", Index);
        args.put("NewIndex", NewIndex);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("srcdsModule/MoveMapEntry", args, type);
    }

    /**
     * Name Description Optional
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
     * @param Index 
     * @return Void
     */
    public Void RemoveMapEntry(Integer Index) {
        Map<String, Object> args = new HashMap<>();
        args.put("Index", Index);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("srcdsModule/RemoveMapEntry", args, type);
    }

    /**
     * Name Description Optional
     * @param MapList 
     * @return Void
     */
    public Void ReplaceMapList(String[] MapList) {
        Map<String, Object> args = new HashMap<>();
        args.put("MapList", MapList);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("srcdsModule/ReplaceMapList", args, type);
    }


}