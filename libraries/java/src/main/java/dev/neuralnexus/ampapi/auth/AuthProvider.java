/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.auth;

import dev.neuralnexus.ampapi.exceptions.LoginException;
import dev.neuralnexus.ampapi.types.LoginResponse;

import java.lang.reflect.Type;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/** Generalized Auth Provider for working with AMP instances */
public interface AuthProvider {
    /**
     * Method to get the panel URL with the API path appended
     *
     * @return The panel URL with the API path appended
     */
    String dataSource();

    /**
     * Method to get the username used for the AuthProvider
     *
     * @return The username used for the AuthProvider
     */
    String username();

    /**
     * Method to get the password used for the AuthProvider
     *
     * @return The password used for the AuthProvider
     */
    String password();

    /**
     * The token currently in use, used for rememberMe, 2FA, or one-time login tokens
     *
     * @return The token currently in use
     */
    String token();

    /**
     * Whether to enable "remember me" for the AuthProvider
     *
     * @return The state of rememberMe
     */
    boolean rememberMe();

    /**
     * The sessionId currently in use, used in all API calls
     *
     * @return The sessionId currently in use
     */
    String sessionId();

    /**
     * The instanceName of the AMP instance
     *
     * @return The instanceName of the AMP instance
     */
    String instanceName();

    /**
     * The instanceId of the AMP instance
     *
     * @return The instanceId of the AMP instance
     */
    UUID instanceId();

    /**
     * Method to make an API call to the remote AMP instance
     *
     * @param endpoint The endpoint to call
     * @param args The arguments to pass to the endpoint
     * @param returnType The expected return type
     * @return The return value from the API call
     * @param <T> The expected return type
     * @throws LoginException If the API call fails
     */
    <T> T APICall(String endpoint, Map<String, Object> args, Type returnType) throws LoginException;

    /**
     * Method to make an API call to the remote AMP instance
     *
     * @param endpoint The endpoint to call
     * @param returnType The expected return type
     * @return The return value from the API call
     * @param <T> The expected return type
     * @throws LoginException If the API call fails
     */
    default <T> T APICall(String endpoint, Type returnType) throws LoginException {
        return this.APICall(endpoint, new HashMap<>(), returnType);
    }

    /**
     * Method to make an API call to the remote AMP instance
     *
     * @param endpoint The endpoint to call
     * @param args The arguments to pass to the endpoint
     * @throws LoginException If the API call fails
     */
    default void APICall(String endpoint, Map<String, Object> args) throws LoginException {
        this.APICall(endpoint, args, Void.class);
    }

    /**
     * Method to make an API call to the remote AMP instance
     *
     * @param endpoint The endpoint to call
     * @throws LoginException If the API call fails
     */
    default void APICall(String endpoint) throws LoginException {
        this.APICall(endpoint, new HashMap<>(), Void.class);
    }

    /**
     * Method to update the AuthProvider with a new LoginResponse
     *
     * @param loginResponse The new LoginResponse to use
     */
    void update(LoginResponse loginResponse);

    /**
     * Method to log into the remote AMP instance
     *
     * @param rememberMe Whether to enable "remember me"
     * @return The LoginResponse from the login attempt
     * @throws LoginException If the login attempt fails
     */
    LoginResponse Login(boolean rememberMe) throws LoginException;

    /**
     * Method to log into the remote AMP instance
     *
     * @return The LoginResponse from the login attempt
     * @throws LoginException If the login attempt fails
     */
    default LoginResponse Login() throws LoginException {
        return this.Login(this.rememberMe());
    }

    /** Builder for AuthProvider */
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

        /**
         * Builds the AuthProvider using the provided properties
         *
         * @param loginResponse The LoginResponse to build the AuthProvider from
         * @return The AuthProvider built from the provided properties
         */
        default AuthProvider.Builder from(LoginResponse loginResponse) {
            return this.token(loginResponse.rememberMeToken()).sessionId(loginResponse.sessionID());
        }

        /**
         * Builds the AuthProvider
         *
         * @return The AuthProvider
         */
        AuthProvider build();
    }
}
