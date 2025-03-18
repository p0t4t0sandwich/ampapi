/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.auth;

import com.github.sviperll.result4j.Result;

import dev.neuralnexus.ampapi.AMPError;
import dev.neuralnexus.ampapi.types.LoginResponse;

import java.lang.reflect.Type;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

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
     * The token currently in use, used for rememberMe, 2FA, or one-time callback tokens
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
     */
    <T> Result<T, AMPError> APICall(String endpoint, Map<String, Object> args, Type returnType);

    /**
     * Method to make an API call to the remote AMP instance
     *
     * @param endpoint The endpoint to call
     * @param returnType The expected return type
     * @return The return value from the API call
     * @param <T> The expected return type
     */
    default <T> Result<T, AMPError> APICall(String endpoint, Type returnType) {
        return this.APICall(endpoint, new HashMap<>(), returnType);
    }

    /**
     * Asynchronous API call
     *
     * @param endpoint The endpoint to call
     * @param requestMethod The request method to use
     * @param args The arguments to pass to the endpoint
     * @param returnType The expected return type
     * @return The return value from the API call
     * @param <T> The expected return type
     */
    default <T> CompletionStage<Result<T, AMPError>> APICallAsync(
            String endpoint, String requestMethod, Map<String, Object> args, Type returnType) {
        return CompletableFuture.supplyAsync(() -> this.APICall(endpoint, args, returnType));
    }

    /**
     * Asynchronous API call
     *
     * @param endpoint The endpoint to call
     * @param args The arguments to pass to the endpoint
     * @param returnType The expected return type
     * @return The return value from the API call
     * @param <T> The expected return type
     */
    default <T> CompletionStage<Result<T, AMPError>> APICallAsync(
            String endpoint, Map<String, Object> args, Type returnType) {
        return this.APICallAsync(endpoint, "POST", args, returnType);
    }

    /**
     * Asynchronous API call
     *
     * @param endpoint The endpoint to call
     * @param returnType The expected return type
     * @return The return value from the API call
     * @param <T> The expected return type
     */
    default <T> CompletionStage<Result<T, AMPError>> APICallAsync(
            String endpoint, Type returnType) {
        return this.APICallAsync(endpoint, new HashMap<>(), returnType);
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
     * @return The LoginResponse from the callback attempt
     */
    Result<LoginResponse, AMPError> Login(boolean rememberMe);

    /**
     * Method to log into the remote AMP instance
     *
     * @return The LoginResponse from the callback attempt
     */
    default Result<LoginResponse, AMPError> Login() {
        return this.Login(this.rememberMe());
    }

    /**
     * Async method to log into the remote AMP instance
     *
     * @param rememberMe Whether to enable "remember me"
     * @return The LoginResponse from the callback attempt
     */
    default CompletionStage<Result<LoginResponse, AMPError>> LoginAsync(boolean rememberMe) {
        return CompletableFuture.supplyAsync(() -> this.Login(rememberMe));
    }

    /**
     * Async method to log into the remote AMP instance
     *
     * @return The LoginResponse from the callback attempt
     */
    default CompletionStage<Result<LoginResponse, AMPError>> LoginAsync() {
        return this.LoginAsync(this.rememberMe());
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
