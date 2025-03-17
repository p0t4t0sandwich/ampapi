/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.modules;

import dev.neuralnexus.ampapi.auth.AuthProvider;
import dev.neuralnexus.ampapi.plugins.*;

public class ADS extends CommonAPI {
    public final ADSModule ADSModule;

    public ADS(AuthProvider authProvider) {
        super(authProvider);
        this.ADSModule = new ADSModule(authProvider);
    }
}
