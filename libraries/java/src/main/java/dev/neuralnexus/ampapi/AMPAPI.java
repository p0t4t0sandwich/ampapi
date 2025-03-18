/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi;

import com.github.sviperll.result4j.Result;

import dev.neuralnexus.ampapi.auth.AuthProvider;

import java.lang.reflect.Type;
import java.util.Map;

public class AMPAPI {
    protected final AuthProvider authProvider;

    /**
     * Constructor
     *
     * @param authProvider The auth provider to use when making API calls
     */
    public AMPAPI(AuthProvider authProvider) {
        this.authProvider = authProvider;
    }

    public <T> Result<T, AMPError> APICall(
            String endpoint, Map<String, Object> args, Type returnType) {
        return this.authProvider.APICall(endpoint, args, returnType);
    }

    public <T> Result<T, AMPError> APICall(String endpoint, Type returnType) {
        return this.authProvider.APICall(endpoint, returnType);
    }

    public void APICall(String endpoint, Map<String, Object> args) {
        this.authProvider.APICall(endpoint, args);
    }

    public void APICall(String endpoint) {
        this.authProvider.APICall(endpoint);
    }
}
