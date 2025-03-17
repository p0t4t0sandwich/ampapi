package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * Type for the result of Core.Login
 * @param permissions The permissions
 * @param rememberMeToken The remember me token
 * @param result The result
 * @param resultReason The result reason
 * @param sessionID The session ID
 * @param success Whether the login was successful
 * @param userInfo The user info
 */
public record LoginResponse(List<String> permissions, String rememberMeToken, AuthenticationResult result, String resultReason, String sessionID, Boolean success, UserInfoSummary userInfo) {}
