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

public final class RCONPlugin extends AMPAPI {
    public RCONPlugin(AuthProvider authprovider) {
        super(authprovider);
    }

    /**
     * Name Description Optional

     * @return Void
     */
    public Void Dummy() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("RCONPlugin/Dummy", args, type);
    }


}