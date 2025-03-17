/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi-java/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.auth;

import dev.neuralnexus.ampapi.types.LoginResponse;

import java.lang.reflect.Type;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/** Generalized Auth Provider for working with AMP instances */
public interface AuthProvider {
    String dataSource();

    String username();

    String password();

    String token();

    boolean rememberMe();

    String sessionId();

    String instanceName();

    UUID instanceId();

    <T> T APICall(String endpoint, Map<String, Object> args, Type returnType);

    default <T> T APICall(String endpoint, Type returnType) {
        return this.APICall(endpoint, new HashMap<>(), returnType);
    }

    /**
     * Method to log into the remote AMP instance
     *
     * @param rememberMe Whether to enable "remember me"
     */
    LoginResponse Login(boolean rememberMe);

    /** Method to log into the remote AMP instance */
    default LoginResponse Login() {
        return this.Login(this.rememberMe());
    }

    interface Builder {
        /**
         * Sets the panelUrl property (required)
         *
         * @param panelUrl The panel URL to connect to
         */
        Builder panelUrl(String panelUrl);

        /**
         * Sets the panelUrl property (required)
         *
         * @param panelUrl The panel URL to connect to
         */
        Builder panelUrl(URL panelUrl);

        /**
         * Sets the requestMethod property (optional, defaults to POST)
         *
         * @param requestMethod The request method to use with the API
         */
        Builder requestMethod(String requestMethod);

        /**
         * Sets the username property (required)
         *
         * @param username The username to use
         */
        Builder username(String username);

        /**
         * Sets the password property (required when not using a one-use or rememberMe token)
         *
         * @param password The password to use
         */
        Builder password(String password);

        /**
         * Sets the token property (required when not using a password, or for 2FA)
         *
         * @param token The token to use
         */
        Builder token(String token);

        /**
         * Sets the token property (required when not using a password, or for 2FA)
         *
         * @param token The token to use
         */
        Builder token(UUID token);

        /**
         * Sets the token property (required when not using a password, or for 2FA)
         *
         * @param token The token to use
         */
        Builder token(int token);

        /**
         * Sets the rememberMe property (used with refreshing auth)
         *
         * @param rememberMe The state of rememberMe
         */
        Builder rememberMe(boolean rememberMe);

        /**
         * Sets the sessionId property (optional)
         *
         * @param sessionId The sessionId to use
         */
        AuthProvider.Builder sessionId(String sessionId);

        /**
         * Sets the sessionId property (optional)
         *
         * @param sessionId The sessionId to use
         */
        AuthProvider.Builder sessionId(UUID sessionId);

        AuthProvider build();
    }
}
