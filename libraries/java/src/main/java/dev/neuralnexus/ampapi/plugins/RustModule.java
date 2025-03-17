/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.plugins;

import dev.neuralnexus.ampapi.AMPAPI;
import dev.neuralnexus.ampapi.auth.AuthProvider;
import dev.neuralnexus.ampapi.types.*;

import java.util.HashMap;
import java.util.Map;

public final class RustModule extends AMPAPI {
    public RustModule(AuthProvider authprovider) {
        super(authprovider);
    }

    /**
     * Name Description Optional
     *
     * @param ID
     */
    public void Ban(String ID) {
        Map<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        this.APICall("RustModule/Ban", args);
    }

    /**
     * Name Description Optional
     *
     * @param ID
     */
    public void Kick(String ID) {
        Map<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        this.APICall("RustModule/Kick", args);
    }

    /** */
    public void WipeBlueprints() {
        this.APICall("RustModule/WipeBlueprints");
    }

    /** */
    public void WipeMap() {
        this.APICall("RustModule/WipeMap");
    }
}
