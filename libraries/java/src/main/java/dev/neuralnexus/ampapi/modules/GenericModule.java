/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.modules;

import dev.neuralnexus.ampapi.auth.AuthProvider;
import dev.neuralnexus.ampapi.plugins.*;

public class GenericModule extends CommonAPI {
    public final AnalyticsPlugin AnalyticsPlugin;
    public final GenericModule GenericModule;
    public final LocalFileBackupPlugin LocalFileBackupPlugin;
    public final RCONPlugin RCONPlugin;
    public final steamcmdplugin steamcmdplugin;

    public GenericModule(AuthProvider authProvider) {
        super(authProvider);
        this.AnalyticsPlugin = new AnalyticsPlugin(authProvider);
        this.GenericModule = new GenericModule(authProvider);
        this.LocalFileBackupPlugin = new LocalFileBackupPlugin(authProvider);
        this.RCONPlugin = new RCONPlugin(authProvider);
        this.steamcmdplugin = new steamcmdplugin(authProvider);
    }
}
