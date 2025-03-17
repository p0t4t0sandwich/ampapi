/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.modules;

import dev.neuralnexus.ampapi.auth.AuthProvider;
import dev.neuralnexus.ampapi.plugins.*;

public class srcds extends CommonAPI {
    public final AnalyticsPlugin AnalyticsPlugin;
    public final LocalFileBackupPlugin LocalFileBackupPlugin;
    public final RCONPlugin RCONPlugin;
    public final srcdsModule srcdsModule;
    public final steamcmdplugin steamcmdplugin;

    public srcds(AuthProvider authProvider) {
        super(authProvider);
        this.AnalyticsPlugin = new AnalyticsPlugin(authProvider);
        this.LocalFileBackupPlugin = new LocalFileBackupPlugin(authProvider);
        this.RCONPlugin = new RCONPlugin(authProvider);
        this.srcdsModule = new srcdsModule(authProvider);
        this.steamcmdplugin = new steamcmdplugin(authProvider);
    }
}
