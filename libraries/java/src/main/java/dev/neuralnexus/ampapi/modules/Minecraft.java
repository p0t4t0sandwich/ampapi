package dev.neuralnexus.ampapi.modules;

import dev.neuralnexus.ampapi.auth.AuthProvider;
import dev.neuralnexus.ampapi.plugins.*;

public class Minecraft extends CommonAPI {
    public final AnalyticsPlugin AnalyticsPlugin;
    public final LocalFileBackupPlugin LocalFileBackupPlugin;
    public final MinecraftModule MinecraftModule;

    public Minecraft(AuthProvider authProvider) {
        super(authProvider);
        this.AnalyticsPlugin = new AnalyticsPlugin(authProvider);
        this.LocalFileBackupPlugin = new LocalFileBackupPlugin(authProvider);
        this.MinecraftModule = new MinecraftModule(authProvider);
    }
}