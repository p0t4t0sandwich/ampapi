/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi-java/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.auth;

import dev.neuralnexus.ampapi.exceptions.APILoginException;
import dev.neuralnexus.ampapi.types.LoginResponse;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/** AuthProvider implementation for refreshing auth sessions with long-running processes */
public class RefreshingAuthProvider extends BasicAuthProvider {
    private final int relogInterval;
    private final Consumer<RefreshingAuthProvider> relogCallback;
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
            Consumer<RefreshingAuthProvider> relogCallback) {
        super(dataSource, requestMethod, username, password, token, rememberMe, sessionId);
        this.relogInterval = relogInterval;
        if (relogCallback != null) {
            this.relogCallback = relogCallback;
        } else {
            this.relogCallback = AuthProvider::Login;
        }
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int relogInterval() {
        return this.relogInterval;
    }

    @Override
    public <T> T APICall(String endpoint, Map<String, Object> args, Type returnType) {
        long now = System.currentTimeMillis();
        if (now - this.lastCall > this.relogInterval) {
            this.relogCallback.accept(this);
        }

        this.lastCall = now;
        if (this.sessionId.isEmpty()) {
            this.Login();
        }
        args.put("SESSIONID", this.sessionId);
        return HTTPReq.APICall(this.dataSource + endpoint, this.requestMethod, args, returnType);
    }

    @Override
    public LoginResult Login(boolean rememberMe) {
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

        //
        System.out.println("PrevToken: " + this.token);
        System.out.println("LoginResult: " + this.instanceId + " (" + this.instanceName + ")");
        //

        LoginResult loginResult =
                HTTPReq.APICall(
                        this.dataSource + "Core/Login",
                        this.requestMethod,
                        args,
                        LoginResult.class);

        //
        System.out.println(loginResult);
        System.out.println("PostToken: " + loginResult.rememberMeToken);
        //

        //
        if (!loginResult.success) {
            throw new APILoginException(loginResult);
        }
        //
        this.token = loginResult.rememberMeToken;
        this.sessionId = loginResult.sessionID;

        return loginResult;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends BasicAuthProvider.Builder {
        private boolean rememberMe = true;
        private int relogInterval = 1000 * 60 * 5;
        private Consumer<RefreshingAuthProvider> relogCallback = null;

        public Builder relogInterval(int relogInterval) {
            this.relogInterval = relogInterval;
            return this;
        }

        public Builder relogCallback(Consumer<RefreshingAuthProvider> relogCallback) {
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
}
