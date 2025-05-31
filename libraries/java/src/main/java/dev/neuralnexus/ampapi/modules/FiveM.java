/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.modules;

import dev.neuralnexus.ampapi.auth.AuthProvider;
import dev.neuralnexus.ampapi.plugins.*;

/** FiveM Module */
public class FiveM extends CommonAPI {
    /** AnalyticsPlugin plugin */
    public final AnalyticsPlugin AnalyticsPlugin;

    /** FiveMModule plugin */
    public final FiveMModule FiveMModule;

    /** LocalFileBackupPlugin plugin */
    public final LocalFileBackupPlugin LocalFileBackupPlugin;

    /**
     * Constructor
     *
     * @param authProvider The AuthProvider to use
     */
    public FiveM(AuthProvider authProvider) {
        super(authProvider);
        this.AnalyticsPlugin = new AnalyticsPlugin(authProvider);
        this.FiveMModule = new FiveMModule(authProvider);
        this.LocalFileBackupPlugin = new LocalFileBackupPlugin(authProvider);
    }
}
