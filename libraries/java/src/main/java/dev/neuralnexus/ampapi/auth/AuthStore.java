/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.auth;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/** Store for AuthProviders */
public class AuthStore {
    private final Map<UUID, AuthProvider> authProviders = new HashMap<>();

    /**
     * Get an AuthProvider from the store
     *
     * @param instanceId The instance ID of the AuthProvider to get
     * @return The AuthProvider with the given instance ID
     */
    public AuthProvider get(UUID instanceId) {
        return this.authProviders.get(instanceId);
    }

    /**
     * Add an AuthProvider to the store
     *
     * @param instanceId The instance ID of the AuthProvider to add
     * @param authProvider The AuthProvider to add
     */
    public void add(UUID instanceId, AuthProvider authProvider) {
        this.authProviders.put(instanceId, authProvider);
    }

    /**
     * Add an AuthProvider to the store
     *
     * @param authProvider The AuthProvider to add
     */
    public void add(AuthProvider authProvider) {
        this.add(authProvider.instanceId(), authProvider);
    }

    /**
     * Add an AuthProvider to the store
     *
     * @param authProvider The AuthProvider to add
     * @param instanceId The instance ID of the AuthProvider to add
     */
    public void add(AuthProvider authProvider, UUID instanceId) {
        this.add(instanceId, authProvider);
    }

    /**
     * Remove an AuthProvider from the store
     *
     * @param instanceId The instance ID of the AuthProvider to remove
     */
    public void remove(UUID instanceId) {
        this.authProviders.remove(instanceId);
    }
}
