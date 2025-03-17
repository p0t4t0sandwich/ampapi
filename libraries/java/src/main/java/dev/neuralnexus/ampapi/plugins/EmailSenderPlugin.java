/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.plugins;

import com.google.gson.reflect.TypeToken;

import dev.neuralnexus.ampapi.AMPAPI;
import dev.neuralnexus.ampapi.auth.AuthProvider;
import dev.neuralnexus.ampapi.types.*;

import java.lang.reflect.Type;

public final class EmailSenderPlugin extends AMPAPI {
    public EmailSenderPlugin(AuthProvider authprovider) {
        super(authprovider);
    }

    /**
     * Name Description Optional
     *
     * @return ActionResult
     */
    public ActionResult TestSMTPSettings() {
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("EmailSenderPlugin/TestSMTPSettings", type);
    }
}
