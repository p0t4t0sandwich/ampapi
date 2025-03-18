/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

import java.util.List;

/**
 * Type for the result of Core.Login
 *
 * @param permissions The permissions
 * @param rememberMeToken The remember me token
 * @param result The result
 * @param resultReason The result reason
 * @param sessionID The session ID
 * @param success Whether the callback was successful
 * @param userInfo The user info
 */
public record LoginResponse(
        List<String> permissions,
        String rememberMeToken,
        AuthenticationResult result,
        String resultReason,
        String sessionID,
        Boolean success,
        UserInfoSummary userInfo) {}
