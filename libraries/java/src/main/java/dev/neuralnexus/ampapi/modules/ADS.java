/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.modules;

import dev.neuralnexus.ampapi.auth.AuthProvider;
import dev.neuralnexus.ampapi.plugins.*;

/** ADS Module */
public class ADS extends CommonAPI {
    /** ADSModule plugin */
    public final ADSModule ADSModule;

    /**
     * Constructor
     *
     * @param authProvider The AuthProvider to use
     */
    public ADS(AuthProvider authProvider) {
        super(authProvider);
        this.ADSModule = new ADSModule(authProvider);
    }
}
