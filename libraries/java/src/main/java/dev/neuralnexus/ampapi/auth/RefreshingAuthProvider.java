/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.auth;

import com.github.sviperll.result4j.Result;

import dev.neuralnexus.ampapi.AMPError;
import dev.neuralnexus.ampapi.types.LoginResponse;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/** AuthProvider implementation for refreshing auth sessions with long-running processes */
public class RefreshingAuthProvider extends BasicAuthProvider {
    private final int relogInterval;
    private final LoginCallback relogCallback;
    private long lastCall = System.currentTimeMillis();

    RefreshingAuthProvider(
            String dataSource,
            String requestMethod,
            String username,
            String password,
            String token,
            boolean rememberMe,
            String sessionId,
            int relogInterval,
            LoginCallback relogCallback) {
        super(dataSource, requestMethod, username, password, token, rememberMe, sessionId);
        this.relogInterval = relogInterval;
        this.relogCallback =
                Objects.requireNonNullElseGet(relogCallback, () -> AuthProvider::Login);
    }

    public int relogInterval() {
        return this.relogInterval;
    }

    @Override
    public <T> Result<T, AMPError> APICall(
            String endpoint, Map<String, Object> args, Type returnType) {
        long now = System.currentTimeMillis();
        if (now - this.lastCall > this.relogInterval) {
            this.relogCallback.callback(this);
        }

        this.lastCall = now;
        if (this.sessionId.isEmpty()) {
            this.Login();
        }
        args.put("SESSIONID", this.sessionId);
        return HTTPReq.APICall(this.dataSource + endpoint, this.requestMethod, args, returnType);
    }

    @Override
    public Result<LoginResponse, AMPError> Login(boolean rememberMe) {
        Map<String, Object> args = new HashMap<>();
        args.put("username", this.username);

        if (rememberMe && !this.token.isEmpty()) {
            args.put("password", "");
            args.put("token", this.token);
        } else {
            args.put("password", this.password);
            args.put("token", "");
        }
        args.put("rememberMe", rememberMe);

        return HTTPReq.<LoginResponse>APICall(
                        this.dataSource + "Core/Login",
                        this.requestMethod,
                        args,
                        LoginResponse.class)
                .map(
                        loginResponse -> {
                            if (loginResponse.success()) {
                                this.update(loginResponse);
                            }
                            return loginResponse;
                        });
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends BasicAuthProvider.Builder {
        private boolean rememberMe = true;
        private int relogInterval = 1000 * 60 * 5;
        private LoginCallback relogCallback = null;

        /**
         * Set the relog interval for the AuthProvider
         * @param relogInterval The relog interval to use
         * @return The builder
         */
        public Builder relogInterval(int relogInterval) {
            this.relogInterval = relogInterval;
            return this;
        }

        /**
         * Set the relog callback for the AuthProvider, you can use this to set up token storage and the like
         * @param relogCallback The relog callback to use
         * @return The builder
         */
        public Builder relogCallback(LoginCallback relogCallback) {
            this.relogCallback = relogCallback;
            return this;
        }

        @Override
        public Builder rememberMe(boolean rememberMe) {
            this.rememberMe = rememberMe;
            return this;
        }

        @Override
        public AuthProvider build() {
            if (this.dataSource.isEmpty()) {
                throw new IllegalStateException("Panel URL must be defined");
            }
            if (this.username.isEmpty()) {
                throw new IllegalStateException("Username must be defined for refreshing auth");
            }
            if (this.password.isEmpty() && this.token.isEmpty()) {
                throw new IllegalStateException(
                        "You must provide a Password or a valid RememberMe Token for refreshing auth");
            }
            return new RefreshingAuthProvider(
                    this.dataSource,
                    this.requestMethod,
                    this.username,
                    this.password,
                    this.token,
                    this.rememberMe,
                    this.sessionId,
                    this.relogInterval,
                    this.relogCallback);
        }
    }

    /** Callback for the relog event */
    @FunctionalInterface
    public interface LoginCallback {
        void callback(RefreshingAuthProvider authProvider);
    }
}
