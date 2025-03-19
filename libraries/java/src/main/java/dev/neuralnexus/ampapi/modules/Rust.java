/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.modules;

import dev.neuralnexus.ampapi.auth.AuthProvider;
import dev.neuralnexus.ampapi.plugins.*;

/** Rust Module */
public class Rust extends CommonAPI {
    /** AnalyticsPlugin plugin */
    public final AnalyticsPlugin AnalyticsPlugin;

    /** LocalFileBackupPlugin plugin */
    public final LocalFileBackupPlugin LocalFileBackupPlugin;

    /** RCONPlugin plugin */
    public final RCONPlugin RCONPlugin;

    /** RustModule plugin */
    public final RustModule RustModule;

    /** steamcmdplugin plugin */
    public final steamcmdplugin steamcmdplugin;

    /**
     * Constructor
     *
     * @param authProvider The AuthProvider to use
     */
    public Rust(AuthProvider authProvider) {
        super(authProvider);
        this.AnalyticsPlugin = new AnalyticsPlugin(authProvider);
        this.LocalFileBackupPlugin = new LocalFileBackupPlugin(authProvider);
        this.RCONPlugin = new RCONPlugin(authProvider);
        this.RustModule = new RustModule(authProvider);
        this.steamcmdplugin = new steamcmdplugin(authProvider);
    }
}
