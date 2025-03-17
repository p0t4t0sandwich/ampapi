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

public final class RustModule extends AMPAPI {
    public RustModule(AuthProvider authprovider) {
        super(authprovider);
    }

    /**
     * Name Description Optional
     * @param ID 
     * @return Void
     */
    public Void Ban(String ID) {
        Map<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("RustModule/Ban", args, type);
    }

    /**
     * Name Description Optional
     * @param ID 
     * @return Void
     */
    public Void Kick(String ID) {
        Map<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("RustModule/Kick", args, type);
    }

    /**
     * Name Description Optional

     * @return Void
     */
    public Void WipeBlueprints() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("RustModule/WipeBlueprints", args, type);
    }

    /**
     * Name Description Optional

     * @return Void
     */
    public Void WipeMap() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("RustModule/WipeMap", args, type);
    }


}