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