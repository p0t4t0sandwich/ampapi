/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.plugins;

import dev.neuralnexus.ampapi.AMPAPI;
import dev.neuralnexus.ampapi.auth.AuthProvider;
import dev.neuralnexus.ampapi.types.*;

public final class RCONPlugin extends AMPAPI {
    public RCONPlugin(AuthProvider authprovider) {
        super(authprovider);
    }

    /** Name Description */
    public void Dummy() {
        this.APICall("RCONPlugin/Dummy");
    }
}
