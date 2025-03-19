/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.modules;

import dev.neuralnexus.ampapi.AMPAPI;
import dev.neuralnexus.ampapi.auth.AuthProvider;
import dev.neuralnexus.ampapi.plugins.*;

/** Module containing all the common plugins. */
public class CommonAPI extends AMPAPI {
    /** Core plugin */
    public final Core Core;

    /** EmailSenderPlugin plugin */
    public final EmailSenderPlugin EmailSenderPlugin;

    /** FileManagerPlugin plugin */
    public final FileManagerPlugin FileManagerPlugin;

    public CommonAPI(AuthProvider authProvider) {
        super(authProvider);
        this.Core = new Core(authProvider);
        this.EmailSenderPlugin = new EmailSenderPlugin(authProvider);
        this.FileManagerPlugin = new FileManagerPlugin(authProvider);
    }
}
