/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.plugins;

import com.github.sviperll.result4j.Result;
import com.google.gson.reflect.TypeToken;

import dev.neuralnexus.ampapi.AMPAPI;
import dev.neuralnexus.ampapi.AMPError;
import dev.neuralnexus.ampapi.auth.AuthProvider;
import dev.neuralnexus.ampapi.types.*;

import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public final class Core extends AMPAPI {
    public Core(AuthProvider authprovider) {
        super(authprovider);
    }

    /**
     * Name Description
     *
     * @return Void
     */
    public Result<Void, AMPError> AcknowledgeAMPUpdate() {
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("Core/AcknowledgeAMPUpdate", type);
    }

    /**
     * Name Description
     *
     * @return Void
     */
    public CompletionStage<Result<Void, AMPError>> AcknowledgeAMPUpdateAsync() {
        return CompletableFuture.supplyAsync(() -> this.AcknowledgeAMPUpdate());
    }

    /**
     * Name Description
     *
     * @param LicenceKey
     * @param QueryOnly
     * @return ActionResult&lt;LicenceInfo&gt;
     */
    public Result<ActionResult<LicenceInfo>, AMPError> ActivateAMPLicence(
            String LicenceKey, @Nullable Boolean QueryOnly) {
        Map<String, Object> args = new HashMap<>();
        args.put("LicenceKey", LicenceKey);
        args.put("QueryOnly", QueryOnly);
        Type type = new TypeToken<ActionResult<LicenceInfo>>() {}.getType();
        return this.APICall("Core/ActivateAMPLicence", args, type);
    }

    /**
     * Name Description
     *
     * @param LicenceKey
     * @param QueryOnly
     * @return ActionResult&lt;LicenceInfo&gt;
     */
    public CompletionStage<Result<ActionResult<LicenceInfo>, AMPError>> ActivateAMPLicenceAsync(
            String LicenceKey, @Nullable Boolean QueryOnly) {
        return CompletableFuture.supplyAsync(() -> this.ActivateAMPLicence(LicenceKey, QueryOnly));
    }

    /**
     * Name Description
     *
     * @param triggerId
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> AddEventTrigger(UUID triggerId) {
        Map<String, Object> args = new HashMap<>();
        args.put("triggerId", triggerId);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/AddEventTrigger", args, type);
    }

    /**
     * Name Description
     *
     * @param triggerId
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> AddEventTriggerAsync(UUID triggerId) {
        return CompletableFuture.supplyAsync(() -> this.AddEventTrigger(triggerId));
    }

    /**
     * Name Description
     *
     * @param months
     * @param days
     * @param hours
     * @param minutes
     * @param daysOfMonth
     * @param description
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> AddIntervalTrigger(
            List<Integer> months,
            List<Integer> days,
            List<Integer> hours,
            List<Integer> minutes,
            List<Integer> daysOfMonth,
            String description) {
        Map<String, Object> args = new HashMap<>();
        args.put("months", months);
        args.put("days", days);
        args.put("hours", hours);
        args.put("minutes", minutes);
        args.put("daysOfMonth", daysOfMonth);
        args.put("description", description);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/AddIntervalTrigger", args, type);
    }

    /**
     * Name Description
     *
     * @param months
     * @param days
     * @param hours
     * @param minutes
     * @param daysOfMonth
     * @param description
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> AddIntervalTriggerAsync(
            List<Integer> months,
            List<Integer> days,
            List<Integer> hours,
            List<Integer> minutes,
            List<Integer> daysOfMonth,
            String description) {
        return CompletableFuture.supplyAsync(
                () ->
                        this.AddIntervalTrigger(
                                months, days, hours, minutes, daysOfMonth, description));
    }

    /**
     * Name Description
     *
     * @param TriggerID
     * @param MethodID
     * @param ParameterMapping
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> AddTask(
            UUID TriggerID, String MethodID, Map<String, String> ParameterMapping) {
        Map<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        args.put("MethodID", MethodID);
        args.put("ParameterMapping", ParameterMapping);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/AddTask", args, type);
    }

    /**
     * Name Description
     *
     * @param TriggerID
     * @param MethodID
     * @param ParameterMapping
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> AddTaskAsync(
            UUID TriggerID, String MethodID, Map<String, String> ParameterMapping) {
        return CompletableFuture.supplyAsync(
                () -> this.AddTask(TriggerID, MethodID, ParameterMapping));
    }

    /**
     * DEV: Async test method Name Description
     *
     * @return String
     */
    public Result<String, AMPError> AsyncTest() {
        Type type = new TypeToken<String>() {}.getType();
        return this.APICall("Core/AsyncTest", type);
    }

    /**
     * DEV: Async test method Name Description
     *
     * @return String
     */
    public CompletionStage<Result<String, AMPError>> AsyncTestAsync() {
        return CompletableFuture.supplyAsync(() -> this.AsyncTest());
    }

    /**
     * Name Description
     *
     * @param TaskId
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> CancelTask(UUID TaskId) {
        Map<String, Object> args = new HashMap<>();
        args.put("TaskId", TaskId);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/CancelTask", args, type);
    }

    /**
     * Name Description
     *
     * @param TaskId
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> CancelTaskAsync(UUID TaskId) {
        return CompletableFuture.supplyAsync(() -> this.CancelTask(TaskId));
    }

    /**
     * Name Description
     *
     * @param TriggerID
     * @param TaskID
     * @param NewOrder
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> ChangeTaskOrder(
            UUID TriggerID, UUID TaskID, Integer NewOrder) {
        Map<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        args.put("TaskID", TaskID);
        args.put("NewOrder", NewOrder);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/ChangeTaskOrder", args, type);
    }

    /**
     * Name Description
     *
     * @param TriggerID
     * @param TaskID
     * @param NewOrder
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> ChangeTaskOrderAsync(
            UUID TriggerID, UUID TaskID, Integer NewOrder) {
        return CompletableFuture.supplyAsync(
                () -> this.ChangeTaskOrder(TriggerID, TaskID, NewOrder));
    }

    /**
     * For a user to change their own password, requires knowing the old password Name Description
     *
     * @param Username
     * @param OldPassword
     * @param NewPassword
     * @param TwoFactorPIN
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> ChangeUserPassword(
            String Username, String OldPassword, String NewPassword, String TwoFactorPIN) {
        Map<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("OldPassword", OldPassword);
        args.put("NewPassword", NewPassword);
        args.put("TwoFactorPIN", TwoFactorPIN);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/ChangeUserPassword", args, type);
    }

    /**
     * For a user to change their own password, requires knowing the old password Name Description
     *
     * @param Username
     * @param OldPassword
     * @param NewPassword
     * @param TwoFactorPIN
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> ChangeUserPasswordAsync(
            String Username, String OldPassword, String NewPassword, String TwoFactorPIN) {
        return CompletableFuture.supplyAsync(
                () -> this.ChangeUserPassword(Username, OldPassword, NewPassword, TwoFactorPIN));
    }

    /**
     * Completes two-factor setup by supplying a valid two factor code based on the secret provided
     * by EnableTwoFactor Name Description
     *
     * @param Username
     * @param TwoFactorCode
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> ConfirmTwoFactorSetup(
            String Username, String TwoFactorCode) {
        Map<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("TwoFactorCode", TwoFactorCode);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/ConfirmTwoFactorSetup", args, type);
    }

    /**
     * Completes two-factor setup by supplying a valid two factor code based on the secret provided
     * by EnableTwoFactor Name Description
     *
     * @param Username
     * @param TwoFactorCode
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> ConfirmTwoFactorSetupAsync(
            String Username, String TwoFactorCode) {
        return CompletableFuture.supplyAsync(
                () -> this.ConfirmTwoFactorSetup(Username, TwoFactorCode));
    }

    /**
     * Name Description
     *
     * @param Name
     * @param AsCommonRole
     * @return ActionResult&lt;UUID&gt;
     */
    public Result<ActionResult<UUID>, AMPError> CreateRole(
            String Name, @Nullable Boolean AsCommonRole) {
        Map<String, Object> args = new HashMap<>();
        args.put("Name", Name);
        args.put("AsCommonRole", AsCommonRole);
        Type type = new TypeToken<ActionResult<UUID>>() {}.getType();
        return this.APICall("Core/CreateRole", args, type);
    }

    /**
     * Name Description
     *
     * @param Name
     * @param AsCommonRole
     * @return ActionResult&lt;UUID&gt;
     */
    public CompletionStage<Result<ActionResult<UUID>, AMPError>> CreateRoleAsync(
            String Name, @Nullable Boolean AsCommonRole) {
        return CompletableFuture.supplyAsync(() -> this.CreateRole(Name, AsCommonRole));
    }

    /**
     * DEV: Creates a non-ending task with 50% progress for testing purposes Name Description
     *
     * @return Void
     */
    public Result<Void, AMPError> CreateTestTask() {
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("Core/CreateTestTask", type);
    }

    /**
     * DEV: Creates a non-ending task with 50% progress for testing purposes Name Description
     *
     * @return Void
     */
    public CompletionStage<Result<Void, AMPError>> CreateTestTaskAsync() {
        return CompletableFuture.supplyAsync(() -> this.CreateTestTask());
    }

    /**
     * Name Description
     *
     * @param Username
     * @return ActionResult&lt;UUID&gt;
     */
    public Result<ActionResult<UUID>, AMPError> CreateUser(String Username) {
        Map<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        Type type = new TypeToken<ActionResult<UUID>>() {}.getType();
        return this.APICall("Core/CreateUser", args, type);
    }

    /**
     * Name Description
     *
     * @param Username
     * @return ActionResult&lt;UUID&gt;
     */
    public CompletionStage<Result<ActionResult<UUID>, AMPError>> CreateUserAsync(String Username) {
        return CompletableFuture.supplyAsync(() -> this.CreateUser(Username));
    }

    /**
     * Name Description
     *
     * @param PermissionNode
     * @return Boolean
     */
    public Result<Boolean, AMPError> CurrentSessionHasPermission(String PermissionNode) {
        Map<String, Object> args = new HashMap<>();
        args.put("PermissionNode", PermissionNode);
        Type type = new TypeToken<Boolean>() {}.getType();
        return this.APICall("Core/CurrentSessionHasPermission", args, type);
    }

    /**
     * Name Description
     *
     * @param PermissionNode
     * @return Boolean
     */
    public CompletionStage<Result<Boolean, AMPError>> CurrentSessionHasPermissionAsync(
            String PermissionNode) {
        return CompletableFuture.supplyAsync(
                () -> this.CurrentSessionHasPermission(PermissionNode));
    }

    /**
     * Name Description
     *
     * @param InstanceId
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> DeleteInstanceUsers(UUID InstanceId) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/DeleteInstanceUsers", args, type);
    }

    /**
     * Name Description
     *
     * @param InstanceId
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> DeleteInstanceUsersAsync(
            UUID InstanceId) {
        return CompletableFuture.supplyAsync(() -> this.DeleteInstanceUsers(InstanceId));
    }

    /**
     * Name Description
     *
     * @param RoleId
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> DeleteRole(UUID RoleId) {
        Map<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/DeleteRole", args, type);
    }

    /**
     * Name Description
     *
     * @param RoleId
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> DeleteRoleAsync(UUID RoleId) {
        return CompletableFuture.supplyAsync(() -> this.DeleteRole(RoleId));
    }

    /**
     * Name Description
     *
     * @param TriggerID
     * @param TaskID
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> DeleteTask(UUID TriggerID, UUID TaskID) {
        Map<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        args.put("TaskID", TaskID);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/DeleteTask", args, type);
    }

    /**
     * Name Description
     *
     * @param TriggerID
     * @param TaskID
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> DeleteTaskAsync(
            UUID TriggerID, UUID TaskID) {
        return CompletableFuture.supplyAsync(() -> this.DeleteTask(TriggerID, TaskID));
    }

    /**
     * Name Description
     *
     * @param TriggerID
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> DeleteTrigger(UUID TriggerID) {
        Map<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/DeleteTrigger", args, type);
    }

    /**
     * Name Description
     *
     * @param TriggerID
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> DeleteTriggerAsync(UUID TriggerID) {
        return CompletableFuture.supplyAsync(() -> this.DeleteTrigger(TriggerID));
    }

    /**
     * Name Description
     *
     * @param Username
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> DeleteUser(String Username) {
        Map<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/DeleteUser", args, type);
    }

    /**
     * Name Description
     *
     * @param Username
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> DeleteUserAsync(String Username) {
        return CompletableFuture.supplyAsync(() -> this.DeleteUser(Username));
    }

    /**
     * Name Description
     *
     * @param Password
     * @param TwoFactorCode
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> DisableTwoFactor(String Password, String TwoFactorCode) {
        Map<String, Object> args = new HashMap<>();
        args.put("Password", Password);
        args.put("TwoFactorCode", TwoFactorCode);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/DisableTwoFactor", args, type);
    }

    /**
     * Name Description
     *
     * @param Password
     * @param TwoFactorCode
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> DisableTwoFactorAsync(
            String Password, String TwoFactorCode) {
        return CompletableFuture.supplyAsync(() -> this.DisableTwoFactor(Password, TwoFactorCode));
    }

    /**
     * Name Description
     *
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> DismissAllTasks() {
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/DismissAllTasks", type);
    }

    /**
     * Name Description
     *
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> DismissAllTasksAsync() {
        return CompletableFuture.supplyAsync(() -> this.DismissAllTasks());
    }

    /**
     * Name Description
     *
     * @param TaskId
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> DismissTask(UUID TaskId) {
        Map<String, Object> args = new HashMap<>();
        args.put("TaskId", TaskId);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/DismissTask", args, type);
    }

    /**
     * Name Description
     *
     * @param TaskId
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> DismissTaskAsync(UUID TaskId) {
        return CompletableFuture.supplyAsync(() -> this.DismissTask(TaskId));
    }

    /**
     * Name Description
     *
     * @param Id
     * @param months
     * @param days
     * @param hours
     * @param minutes
     * @param daysOfMonth
     * @param description
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> EditIntervalTrigger(
            UUID Id,
            List<Integer> months,
            List<Integer> days,
            List<Integer> hours,
            List<Integer> minutes,
            List<Integer> daysOfMonth,
            String description) {
        Map<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        args.put("months", months);
        args.put("days", days);
        args.put("hours", hours);
        args.put("minutes", minutes);
        args.put("daysOfMonth", daysOfMonth);
        args.put("description", description);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/EditIntervalTrigger", args, type);
    }

    /**
     * Name Description
     *
     * @param Id
     * @param months
     * @param days
     * @param hours
     * @param minutes
     * @param daysOfMonth
     * @param description
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> EditIntervalTriggerAsync(
            UUID Id,
            List<Integer> months,
            List<Integer> days,
            List<Integer> hours,
            List<Integer> minutes,
            List<Integer> daysOfMonth,
            String description) {
        return CompletableFuture.supplyAsync(
                () ->
                        this.EditIntervalTrigger(
                                Id, months, days, hours, minutes, daysOfMonth, description));
    }

    /**
     * Name Description
     *
     * @param TriggerID
     * @param TaskID
     * @param ParameterMapping
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> EditTask(
            UUID TriggerID, UUID TaskID, Map<String, String> ParameterMapping) {
        Map<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        args.put("TaskID", TaskID);
        args.put("ParameterMapping", ParameterMapping);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/EditTask", args, type);
    }

    /**
     * Name Description
     *
     * @param TriggerID
     * @param TaskID
     * @param ParameterMapping
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> EditTaskAsync(
            UUID TriggerID, UUID TaskID, Map<String, String> ParameterMapping) {
        return CompletableFuture.supplyAsync(
                () -> this.EditTask(TriggerID, TaskID, ParameterMapping));
    }

    /**
     * Sets up two-factor authentication for the given user. ConfirmTwoFactorSetup must be invoked
     * to complete setup. Name Description
     *
     * @param Username
     * @param Password
     * @return ActionResult&lt;TwoFactorSetupInfo&gt;
     */
    public Result<ActionResult<TwoFactorSetupInfo>, AMPError> EnableTwoFactor(
            String Username, String Password) {
        Map<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("Password", Password);
        Type type = new TypeToken<ActionResult<TwoFactorSetupInfo>>() {}.getType();
        return this.APICall("Core/EnableTwoFactor", args, type);
    }

    /**
     * Sets up two-factor authentication for the given user. ConfirmTwoFactorSetup must be invoked
     * to complete setup. Name Description
     *
     * @param Username
     * @param Password
     * @return ActionResult&lt;TwoFactorSetupInfo&gt;
     */
    public CompletionStage<Result<ActionResult<TwoFactorSetupInfo>, AMPError>> EnableTwoFactorAsync(
            String Username, String Password) {
        return CompletableFuture.supplyAsync(() -> this.EnableTwoFactor(Username, Password));
    }

    /**
     * Name Description
     *
     * @param Id
     * @return Void
     */
    public Result<Void, AMPError> EndUserSession(UUID Id) {
        Map<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("Core/EndUserSession", args, type);
    }

    /**
     * Name Description
     *
     * @param Id
     * @return Void
     */
    public CompletionStage<Result<Void, AMPError>> EndUserSessionAsync(UUID Id) {
        return CompletableFuture.supplyAsync(() -> this.EndUserSession(Id));
    }

    /**
     * Name Description
     *
     * @param RoleId
     * @return List&lt;String&gt;
     */
    public Result<List<String>, AMPError> GetAMPRolePermissions(UUID RoleId) {
        Map<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        Type type = new TypeToken<List<String>>() {}.getType();
        return this.APICall("Core/GetAMPRolePermissions", args, type);
    }

    /**
     * Name Description
     *
     * @param RoleId
     * @return List&lt;String&gt;
     */
    public CompletionStage<Result<List<String>, AMPError>> GetAMPRolePermissionsAsync(UUID RoleId) {
        return CompletableFuture.supplyAsync(() -> this.GetAMPRolePermissions(RoleId));
    }

    /**
     * Name Description
     *
     * @param Username
     * @return UserInfo
     */
    public Result<UserInfo, AMPError> GetAMPUserInfo(String Username) {
        Map<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        Type type = new TypeToken<UserInfo>() {}.getType();
        return this.APICall("Core/GetAMPUserInfo", args, type);
    }

    /**
     * Name Description
     *
     * @param Username
     * @return UserInfo
     */
    public CompletionStage<Result<UserInfo, AMPError>> GetAMPUserInfoAsync(String Username) {
        return CompletableFuture.supplyAsync(() -> this.GetAMPUserInfo(Username));
    }

    /**
     * Name Description
     *
     * @return List&lt;UserInfoSummary&gt;
     */
    public Result<List<UserInfoSummary>, AMPError> GetAMPUsersSummary() {
        Type type = new TypeToken<List<UserInfoSummary>>() {}.getType();
        return this.APICall("Core/GetAMPUsersSummary", type);
    }

    /**
     * Name Description
     *
     * @return List&lt;UserInfoSummary&gt;
     */
    public CompletionStage<Result<List<UserInfoSummary>, AMPError>> GetAMPUsersSummaryAsync() {
        return CompletableFuture.supplyAsync(() -> this.GetAMPUsersSummary());
    }

    /**
     * Name Description
     *
     * @return Map&lt;String, Map&lt;String, MethodInfoSummary&gt;&gt;
     */
    public Result<Map<String, Map<String, MethodInfoSummary>>, AMPError> GetAPISpec() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Map<String, Map<String, MethodInfoSummary>>>() {}.getType();
        return this.APICall("Core/GetAPISpec", args, type);
    }

    /**
     * Name Description
     *
     * @return Map&lt;String, Map&lt;String, MethodInfoSummary&gt;&gt;
     */
    public CompletionStage<Result<Map<String, Map<String, MethodInfoSummary>>, AMPError>>
            GetAPISpecAsync() {
        return CompletableFuture.supplyAsync(() -> this.GetAPISpec());
    }

    /**
     * Name Description
     *
     * @return List&lt;WebSessionSummary&gt;
     */
    public Result<List<WebSessionSummary>, AMPError> GetActiveAMPSessions() {
        Type type = new TypeToken<List<WebSessionSummary>>() {}.getType();
        return this.APICall("Core/GetActiveAMPSessions", type);
    }

    /**
     * Name Description
     *
     * @return List&lt;WebSessionSummary&gt;
     */
    public CompletionStage<Result<List<WebSessionSummary>, AMPError>> GetActiveAMPSessionsAsync() {
        return CompletableFuture.supplyAsync(() -> this.GetActiveAMPSessions());
    }

    /**
     * Name Description
     *
     * @return List&lt;UserInfo&gt;
     */
    public Result<List<UserInfo>, AMPError> GetAllAMPUserInfo() {
        Type type = new TypeToken<List<UserInfo>>() {}.getType();
        return this.APICall("Core/GetAllAMPUserInfo", type);
    }

    /**
     * Name Description
     *
     * @return List&lt;UserInfo&gt;
     */
    public CompletionStage<Result<List<UserInfo>, AMPError>> GetAllAMPUserInfoAsync() {
        return CompletableFuture.supplyAsync(() -> this.GetAllAMPUserInfo());
    }

    /**
     * Name Description
     *
     * @param Before
     * @param Count
     * @return List&lt;IAuditLogEntry&gt;
     */
    public Result<List<IAuditLogEntry>, AMPError> GetAuditLogEntries(String Before, Integer Count) {
        Map<String, Object> args = new HashMap<>();
        args.put("Before", Before);
        args.put("Count", Count);
        Type type = new TypeToken<List<IAuditLogEntry>>() {}.getType();
        return this.APICall("Core/GetAuditLogEntries", args, type);
    }

    /**
     * Name Description
     *
     * @param Before
     * @param Count
     * @return List&lt;IAuditLogEntry&gt;
     */
    public CompletionStage<Result<List<IAuditLogEntry>, AMPError>> GetAuditLogEntriesAsync(
            String Before, Integer Count) {
        return CompletableFuture.supplyAsync(() -> this.GetAuditLogEntries(Before, Count));
    }

    /**
     * Name Description
     *
     * @param username
     * @return List&lt;AuthenticationRequirement&gt;
     */
    public Result<List<AuthenticationRequirement>, AMPError> GetAuthenticationRequirements(
            String username) {
        Map<String, Object> args = new HashMap<>();
        args.put("username", username);
        Type type = new TypeToken<List<AuthenticationRequirement>>() {}.getType();
        return this.APICall("Core/GetAuthenticationRequirements", args, type);
    }

    /**
     * Name Description
     *
     * @param username
     * @return List&lt;AuthenticationRequirement&gt;
     */
    public CompletionStage<Result<List<AuthenticationRequirement>, AMPError>>
            GetAuthenticationRequirementsAsync(String username) {
        return CompletableFuture.supplyAsync(() -> this.GetAuthenticationRequirements(username));
    }

    /**
     * Name Description
     *
     * @param node
     * @return SettingSpec
     */
    public Result<SettingSpec, AMPError> GetConfig(String node) {
        Map<String, Object> args = new HashMap<>();
        args.put("node", node);
        Type type = new TypeToken<SettingSpec>() {}.getType();
        return this.APICall("Core/GetConfig", args, type);
    }

    /**
     * Name Description
     *
     * @param node
     * @return SettingSpec
     */
    public CompletionStage<Result<SettingSpec, AMPError>> GetConfigAsync(String node) {
        return CompletableFuture.supplyAsync(() -> this.GetConfig(node));
    }

    /**
     * Name Description
     *
     * @param nodes
     * @return List&lt;SettingSpec&gt;
     */
    public Result<List<SettingSpec>, AMPError> GetConfigs(List<String> nodes) {
        Map<String, Object> args = new HashMap<>();
        args.put("nodes", nodes);
        Type type = new TypeToken<List<SettingSpec>>() {}.getType();
        return this.APICall("Core/GetConfigs", args, type);
    }

    /**
     * Name Description
     *
     * @param nodes
     * @return List&lt;SettingSpec&gt;
     */
    public CompletionStage<Result<List<SettingSpec>, AMPError>> GetConfigsAsync(
            List<String> nodes) {
        return CompletableFuture.supplyAsync(() -> this.GetConfigs(nodes));
    }

    /**
     * Name Description
     *
     * @return Map&lt;String, String&gt;
     */
    public Result<Map<String, String>, AMPError> GetDiagnosticsInfo() {
        Type type = new TypeToken<Map<String, String>>() {}.getType();
        return this.APICall("Core/GetDiagnosticsInfo", type);
    }

    /**
     * Name Description
     *
     * @return Map&lt;String, String&gt;
     */
    public CompletionStage<Result<Map<String, String>, AMPError>> GetDiagnosticsInfoAsync() {
        return CompletableFuture.supplyAsync(() -> this.GetDiagnosticsInfo());
    }

    /**
     * Name Description
     *
     * @return ModuleInfo
     */
    public Result<ModuleInfo, AMPError> GetModuleInfo() {
        Type type = new TypeToken<ModuleInfo>() {}.getType();
        return this.APICall("Core/GetModuleInfo", type);
    }

    /**
     * Name Description
     *
     * @return ModuleInfo
     */
    public CompletionStage<Result<ModuleInfo, AMPError>> GetModuleInfoAsync() {
        return CompletableFuture.supplyAsync(() -> this.GetModuleInfo());
    }

    /**
     * Name Description
     *
     * @return UUID
     */
    public Result<UUID, AMPError> GetNewGuid() {
        Type type = new TypeToken<UUID>() {}.getType();
        return this.APICall("Core/GetNewGuid", type);
    }

    /**
     * Name Description
     *
     * @return UUID
     */
    public CompletionStage<Result<UUID, AMPError>> GetNewGuidAsync() {
        return CompletableFuture.supplyAsync(() -> this.GetNewGuid());
    }

    /**
     * Name Description
     *
     * @return List&lt;IPermissionsTreeNode&gt;
     */
    public Result<List<IPermissionsTreeNode>, AMPError> GetPermissionsSpec() {
        Type type = new TypeToken<List<IPermissionsTreeNode>>() {}.getType();
        return this.APICall("Core/GetPermissionsSpec", type);
    }

    /**
     * Name Description
     *
     * @return List&lt;IPermissionsTreeNode&gt;
     */
    public CompletionStage<Result<List<IPermissionsTreeNode>, AMPError>> GetPermissionsSpecAsync() {
        return CompletableFuture.supplyAsync(() -> this.GetPermissionsSpec());
    }

    /**
     * Name Description
     *
     * @return List&lt;ListeningPortSummary&gt;
     */
    public Result<List<ListeningPortSummary>, AMPError> GetPortSummaries() {
        Type type = new TypeToken<List<ListeningPortSummary>>() {}.getType();
        return this.APICall("Core/GetPortSummaries", type);
    }

    /**
     * Name Description
     *
     * @return List&lt;ListeningPortSummary&gt;
     */
    public CompletionStage<Result<List<ListeningPortSummary>, AMPError>> GetPortSummariesAsync() {
        return CompletableFuture.supplyAsync(() -> this.GetPortSummaries());
    }

    /**
     * Name Description
     *
     * @return List&lt;SettingSpec&gt;
     */
    public Result<List<SettingSpec>, AMPError> GetProvisionSpec() {
        Type type = new TypeToken<List<SettingSpec>>() {}.getType();
        return this.APICall("Core/GetProvisionSpec", type);
    }

    /**
     * Name Description
     *
     * @return List&lt;SettingSpec&gt;
     */
    public CompletionStage<Result<List<SettingSpec>, AMPError>> GetProvisionSpecAsync() {
        return CompletableFuture.supplyAsync(() -> this.GetProvisionSpec());
    }

    /**
     * Name Description
     *
     * @param Description
     * @param IsTemporary
     * @return String
     */
    public Result<String, AMPError> GetRemoteLoginToken(
            @Nullable String Description, @Nullable Boolean IsTemporary) {
        Map<String, Object> args = new HashMap<>();
        args.put("Description", Description);
        args.put("IsTemporary", IsTemporary);
        Type type = new TypeToken<String>() {}.getType();
        return this.APICall("Core/GetRemoteLoginToken", args, type);
    }

    /**
     * Name Description
     *
     * @param Description
     * @param IsTemporary
     * @return String
     */
    public CompletionStage<Result<String, AMPError>> GetRemoteLoginTokenAsync(
            @Nullable String Description, @Nullable Boolean IsTemporary) {
        return CompletableFuture.supplyAsync(
                () -> this.GetRemoteLoginToken(Description, IsTemporary));
    }

    /**
     * Name Description
     *
     * @param RoleId
     * @return AuthRoleSummary
     */
    public Result<AuthRoleSummary, AMPError> GetRole(UUID RoleId) {
        Map<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        Type type = new TypeToken<AuthRoleSummary>() {}.getType();
        return this.APICall("Core/GetRole", args, type);
    }

    /**
     * Name Description
     *
     * @param RoleId
     * @return AuthRoleSummary
     */
    public CompletionStage<Result<AuthRoleSummary, AMPError>> GetRoleAsync(UUID RoleId) {
        return CompletableFuture.supplyAsync(() -> this.GetRole(RoleId));
    }

    /**
     * Name Description
     *
     * @return List&lt;AuthRoleSummary&gt;
     */
    public Result<List<AuthRoleSummary>, AMPError> GetRoleData() {
        Type type = new TypeToken<List<AuthRoleSummary>>() {}.getType();
        return this.APICall("Core/GetRoleData", type);
    }

    /**
     * Name Description
     *
     * @return List&lt;AuthRoleSummary&gt;
     */
    public CompletionStage<Result<List<AuthRoleSummary>, AMPError>> GetRoleDataAsync() {
        return CompletableFuture.supplyAsync(() -> this.GetRoleData());
    }

    /**
     * Name Description
     *
     * @return Map&lt;UUID, String&gt;
     */
    public Result<Map<UUID, String>, AMPError> GetRoleIds() {
        Type type = new TypeToken<Map<UUID, String>>() {}.getType();
        return this.APICall("Core/GetRoleIds", type);
    }

    /**
     * Name Description
     *
     * @return Map&lt;UUID, String&gt;
     */
    public CompletionStage<Result<Map<UUID, String>, AMPError>> GetRoleIdsAsync() {
        return CompletableFuture.supplyAsync(() -> this.GetRoleIds());
    }

    /**
     * Name Description
     *
     * @return ScheduleInfo
     */
    public Result<ScheduleInfo, AMPError> GetScheduleData() {
        Type type = new TypeToken<ScheduleInfo>() {}.getType();
        return this.APICall("Core/GetScheduleData", type);
    }

    /**
     * Name Description
     *
     * @return ScheduleInfo
     */
    public CompletionStage<Result<ScheduleInfo, AMPError>> GetScheduleDataAsync() {
        return CompletableFuture.supplyAsync(() -> this.GetScheduleData());
    }

    /**
     * Name Description
     *
     * @param SettingNode
     * @param WithRefresh
     * @return Map&lt;String, String&gt;
     */
    public Result<Map<String, String>, AMPError> GetSettingValues(
            String SettingNode, @Nullable Boolean WithRefresh) {
        Map<String, Object> args = new HashMap<>();
        args.put("SettingNode", SettingNode);
        args.put("WithRefresh", WithRefresh);
        Type type = new TypeToken<Map<String, String>>() {}.getType();
        return this.APICall("Core/GetSettingValues", args, type);
    }

    /**
     * Name Description
     *
     * @param SettingNode
     * @param WithRefresh
     * @return Map&lt;String, String&gt;
     */
    public CompletionStage<Result<Map<String, String>, AMPError>> GetSettingValuesAsync(
            String SettingNode, @Nullable Boolean WithRefresh) {
        return CompletableFuture.supplyAsync(() -> this.GetSettingValues(SettingNode, WithRefresh));
    }

    /**
     * Name Description
     *
     * @return Map&lt;String, List&lt;SettingSpec&gt;&gt;
     */
    public Result<Map<String, List<SettingSpec>>, AMPError> GetSettingsSpec() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Map<String, List<SettingSpec>>>() {}.getType();
        return this.APICall("Core/GetSettingsSpec", args, type);
    }

    /**
     * Name Description
     *
     * @return Map&lt;String, List&lt;SettingSpec&gt;&gt;
     */
    public CompletionStage<Result<Map<String, List<SettingSpec>>, AMPError>>
            GetSettingsSpecAsync() {
        return CompletableFuture.supplyAsync(() -> this.GetSettingsSpec());
    }

    /**
     * Name Description
     *
     * @return StatusResponse
     */
    public Result<StatusResponse, AMPError> GetStatus() {
        Type type = new TypeToken<StatusResponse>() {}.getType();
        return this.APICall("Core/GetStatus", type);
    }

    /**
     * Name Description
     *
     * @return StatusResponse
     */
    public CompletionStage<Result<StatusResponse, AMPError>> GetStatusAsync() {
        return CompletableFuture.supplyAsync(() -> this.GetStatus());
    }

    /**
     * Name Description
     *
     * @return List&lt;RunningTask&gt;
     */
    public Result<List<RunningTask>, AMPError> GetTasks() {
        Type type = new TypeToken<List<RunningTask>>() {}.getType();
        return this.APICall("Core/GetTasks", type);
    }

    /**
     * Name Description
     *
     * @return List&lt;RunningTask&gt;
     */
    public CompletionStage<Result<List<RunningTask>, AMPError>> GetTasksAsync() {
        return CompletableFuture.supplyAsync(() -> this.GetTasks());
    }

    /**
     * Name Description
     *
     * @param Id
     * @return TimeIntervalTrigger
     */
    public Result<TimeIntervalTrigger, AMPError> GetTimeIntervalTrigger(UUID Id) {
        Map<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        Type type = new TypeToken<TimeIntervalTrigger>() {}.getType();
        return this.APICall("Core/GetTimeIntervalTrigger", args, type);
    }

    /**
     * Name Description
     *
     * @param Id
     * @return TimeIntervalTrigger
     */
    public CompletionStage<Result<TimeIntervalTrigger, AMPError>> GetTimeIntervalTriggerAsync(
            UUID Id) {
        return CompletableFuture.supplyAsync(() -> this.GetTimeIntervalTrigger(Id));
    }

    /**
     * Name Description
     *
     * @return UpdateInfo
     */
    public Result<UpdateInfo, AMPError> GetUpdateInfo() {
        Type type = new TypeToken<UpdateInfo>() {}.getType();
        return this.APICall("Core/GetUpdateInfo", type);
    }

    /**
     * Name Description
     *
     * @return UpdateInfo
     */
    public CompletionStage<Result<UpdateInfo, AMPError>> GetUpdateInfoAsync() {
        return CompletableFuture.supplyAsync(() -> this.GetUpdateInfo());
    }

    /**
     * Gets changes to the server status, in addition to any notifications or console output that
     * have occured since the last time GetUpdates() was called by the current session. Name
     * Description
     *
     * @return UpdateResponse
     */
    public Result<UpdateResponse, AMPError> GetUpdates() {
        Type type = new TypeToken<UpdateResponse>() {}.getType();
        return this.APICall("Core/GetUpdates", type);
    }

    /**
     * Gets changes to the server status, in addition to any notifications or console output that
     * have occured since the last time GetUpdates() was called by the current session. Name
     * Description
     *
     * @return UpdateResponse
     */
    public CompletionStage<Result<UpdateResponse, AMPError>> GetUpdatesAsync() {
        return CompletableFuture.supplyAsync(() -> this.GetUpdates());
    }

    /**
     * Name Description
     *
     * @return Object
     */
    public Result<Object, AMPError> GetUserActionsSpec() {
        Type type = new TypeToken<Object>() {}.getType();
        return this.APICall("Core/GetUserActionsSpec", type);
    }

    /**
     * Name Description
     *
     * @return Object
     */
    public CompletionStage<Result<Object, AMPError>> GetUserActionsSpecAsync() {
        return CompletableFuture.supplyAsync(() -> this.GetUserActionsSpec());
    }

    /**
     * Provides information about a given in-application user (as opposed to AMP system users) Name
     * Description
     *
     * @param UID
     * @return SimpleUser
     */
    public Result<SimpleUser, AMPError> GetUserInfo(String UID) {
        Map<String, Object> args = new HashMap<>();
        args.put("UID", UID);
        Type type = new TypeToken<SimpleUser>() {}.getType();
        return this.APICall("Core/GetUserInfo", args, type);
    }

    /**
     * Provides information about a given in-application user (as opposed to AMP system users) Name
     * Description
     *
     * @param UID
     * @return SimpleUser
     */
    public CompletionStage<Result<SimpleUser, AMPError>> GetUserInfoAsync(String UID) {
        return CompletableFuture.supplyAsync(() -> this.GetUserInfo(UID));
    }

    /**
     * Returns a list of in-application users Name Description
     *
     * @return Map&lt;String, String&gt;
     */
    public Result<Map<String, String>, AMPError> GetUserList() {
        Type type = new TypeToken<Map<String, String>>() {}.getType();
        return this.APICall("Core/GetUserList", type);
    }

    /**
     * Returns a list of in-application users Name Description
     *
     * @return Map&lt;String, String&gt;
     */
    public CompletionStage<Result<Map<String, String>, AMPError>> GetUserListAsync() {
        return CompletableFuture.supplyAsync(() -> this.GetUserList());
    }

    /**
     * Name Description
     *
     * @return ActionResult&lt;String&gt;
     */
    public Result<ActionResult<String>, AMPError> GetWebauthnChallenge() {
        Type type = new TypeToken<ActionResult<String>>() {}.getType();
        return this.APICall("Core/GetWebauthnChallenge", type);
    }

    /**
     * Name Description
     *
     * @return ActionResult&lt;String&gt;
     */
    public CompletionStage<Result<ActionResult<String>, AMPError>> GetWebauthnChallengeAsync() {
        return CompletableFuture.supplyAsync(() -> this.GetWebauthnChallenge());
    }

    /**
     * Name Description
     *
     * @param username
     * @return WebauthnLoginInfo
     */
    public Result<WebauthnLoginInfo, AMPError> GetWebauthnCredentialIDs(String username) {
        Map<String, Object> args = new HashMap<>();
        args.put("username", username);
        Type type = new TypeToken<WebauthnLoginInfo>() {}.getType();
        return this.APICall("Core/GetWebauthnCredentialIDs", args, type);
    }

    /**
     * Name Description
     *
     * @param username
     * @return WebauthnLoginInfo
     */
    public CompletionStage<Result<WebauthnLoginInfo, AMPError>> GetWebauthnCredentialIDsAsync(
            String username) {
        return CompletableFuture.supplyAsync(() -> this.GetWebauthnCredentialIDs(username));
    }

    /**
     * Name Description
     *
     * @return List&lt;WebauthnCredentialSummary&gt;
     */
    public Result<List<WebauthnCredentialSummary>, AMPError> GetWebauthnCredentialSummaries() {
        Type type = new TypeToken<List<WebauthnCredentialSummary>>() {}.getType();
        return this.APICall("Core/GetWebauthnCredentialSummaries", type);
    }

    /**
     * Name Description
     *
     * @return List&lt;WebauthnCredentialSummary&gt;
     */
    public CompletionStage<Result<List<WebauthnCredentialSummary>, AMPError>>
            GetWebauthnCredentialSummariesAsync() {
        return CompletableFuture.supplyAsync(() -> this.GetWebauthnCredentialSummaries());
    }

    /**
     * Name Description
     *
     * @return Void
     */
    public Result<Void, AMPError> Kill() {
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("Core/Kill", type);
    }

    /**
     * Name Description
     *
     * @return Void
     */
    public CompletionStage<Result<Void, AMPError>> KillAsync() {
        return CompletableFuture.supplyAsync(() -> this.Kill());
    }

    /**
     * Name Description
     *
     * @param username
     * @param password
     * @param token
     * @param rememberMe
     * @return LoginResponse
     */
    public Result<LoginResponse, AMPError> Login(
            String username, String password, String token, Boolean rememberMe) {
        Map<String, Object> args = new HashMap<>();
        args.put("username", username);
        args.put("password", password);
        args.put("token", token);
        args.put("rememberMe", rememberMe);
        Type type = new TypeToken<LoginResponse>() {}.getType();
        return this.APICall("Core/Login", args, type);
    }

    /**
     * Name Description
     *
     * @param username
     * @param password
     * @param token
     * @param rememberMe
     * @return LoginResponse
     */
    public CompletionStage<Result<LoginResponse, AMPError>> LoginAsync(
            String username, String password, String token, Boolean rememberMe) {
        return CompletableFuture.supplyAsync(
                () -> this.Login(username, password, token, rememberMe));
    }

    /**
     * Name Description
     *
     * @return Void
     */
    public Result<Void, AMPError> Logout() {
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("Core/Logout", type);
    }

    /**
     * Name Description
     *
     * @return Void
     */
    public CompletionStage<Result<Void, AMPError>> LogoutAsync() {
        return CompletableFuture.supplyAsync(() -> this.Logout());
    }

    /**
     * Name Description
     *
     * @param Node
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> RefreshSettingValueList(String Node) {
        Map<String, Object> args = new HashMap<>();
        args.put("Node", Node);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/RefreshSettingValueList", args, type);
    }

    /**
     * Name Description
     *
     * @param Node
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> RefreshSettingValueListAsync(
            String Node) {
        return CompletableFuture.supplyAsync(() -> this.RefreshSettingValueList(Node));
    }

    /**
     * Name Description
     *
     * @return Void
     */
    public Result<Void, AMPError> RefreshSettingsSourceCache() {
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("Core/RefreshSettingsSourceCache", type);
    }

    /**
     * Name Description
     *
     * @return Void
     */
    public CompletionStage<Result<Void, AMPError>> RefreshSettingsSourceCacheAsync() {
        return CompletableFuture.supplyAsync(() -> this.RefreshSettingsSourceCache());
    }

    /**
     * Name Description
     *
     * @param RoleId
     * @param NewName
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> RenameRole(UUID RoleId, String NewName) {
        Map<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        args.put("NewName", NewName);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/RenameRole", args, type);
    }

    /**
     * Name Description
     *
     * @param RoleId
     * @param NewName
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> RenameRoleAsync(
            UUID RoleId, String NewName) {
        return CompletableFuture.supplyAsync(() -> this.RenameRole(RoleId, NewName));
    }

    /**
     * For administrative users to alter the password of another user Name Description
     *
     * @param Username
     * @param NewPassword
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> ResetUserPassword(String Username, String NewPassword) {
        Map<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("NewPassword", NewPassword);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/ResetUserPassword", args, type);
    }

    /**
     * For administrative users to alter the password of another user Name Description
     *
     * @param Username
     * @param NewPassword
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> ResetUserPasswordAsync(
            String Username, String NewPassword) {
        return CompletableFuture.supplyAsync(() -> this.ResetUserPassword(Username, NewPassword));
    }

    /**
     * Name Description
     *
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> Restart() {
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/Restart", type);
    }

    /**
     * Name Description
     *
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> RestartAsync() {
        return CompletableFuture.supplyAsync(() -> this.Restart());
    }

    /**
     * Name Description
     *
     * @return Void
     */
    public Result<Void, AMPError> RestartAMP() {
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("Core/RestartAMP", type);
    }

    /**
     * Name Description
     *
     * @return Void
     */
    public CompletionStage<Result<Void, AMPError>> RestartAMPAsync() {
        return CompletableFuture.supplyAsync(() -> this.RestartAMP());
    }

    /**
     * Allows the service to be re-started after previously being suspended. Name Description
     *
     * @return Void
     */
    public Result<Void, AMPError> Resume() {
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("Core/Resume", type);
    }

    /**
     * Allows the service to be re-started after previously being suspended. Name Description
     *
     * @return Void
     */
    public CompletionStage<Result<Void, AMPError>> ResumeAsync() {
        return CompletableFuture.supplyAsync(() -> this.Resume());
    }

    /**
     * Name Description
     *
     * @param ID
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> RevokeWebauthnCredential(Integer ID) {
        Map<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/RevokeWebauthnCredential", args, type);
    }

    /**
     * Name Description
     *
     * @param ID
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> RevokeWebauthnCredentialAsync(
            Integer ID) {
        return CompletableFuture.supplyAsync(() -> this.RevokeWebauthnCredential(ID));
    }

    /**
     * Name Description
     *
     * @param triggerId
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> RunEventTriggerImmediately(UUID triggerId) {
        Map<String, Object> args = new HashMap<>();
        args.put("triggerId", triggerId);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/RunEventTriggerImmediately", args, type);
    }

    /**
     * Name Description
     *
     * @param triggerId
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> RunEventTriggerImmediatelyAsync(
            UUID triggerId) {
        return CompletableFuture.supplyAsync(() -> this.RunEventTriggerImmediately(triggerId));
    }

    /**
     * Name Description
     *
     * @return List&lt;SecurityCheckResult&gt;
     */
    public Result<List<SecurityCheckResult>, AMPError> RunSecurityCheck() {
        Type type = new TypeToken<List<SecurityCheckResult>>() {}.getType();
        return this.APICall("Core/RunSecurityCheck", type);
    }

    /**
     * Name Description
     *
     * @return List&lt;SecurityCheckResult&gt;
     */
    public CompletionStage<Result<List<SecurityCheckResult>, AMPError>> RunSecurityCheckAsync() {
        return CompletableFuture.supplyAsync(() -> this.RunSecurityCheck());
    }

    /**
     * Name Description
     *
     * @param message
     * @return Void
     */
    public Result<Void, AMPError> SendConsoleMessage(String message) {
        Map<String, Object> args = new HashMap<>();
        args.put("message", message);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("Core/SendConsoleMessage", args, type);
    }

    /**
     * Name Description
     *
     * @param message
     * @return Void
     */
    public CompletionStage<Result<Void, AMPError>> SendConsoleMessageAsync(String message) {
        return CompletableFuture.supplyAsync(() -> this.SendConsoleMessage(message));
    }

    /**
     * Name Description
     *
     * @param RoleId
     * @param PermissionNode
     * @param Enabled
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> SetAMPRolePermission(
            UUID RoleId, String PermissionNode, Boolean Enabled) {
        Map<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        args.put("PermissionNode", PermissionNode);
        args.put("Enabled", Enabled);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/SetAMPRolePermission", args, type);
    }

    /**
     * Name Description
     *
     * @param RoleId
     * @param PermissionNode
     * @param Enabled
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> SetAMPRolePermissionAsync(
            UUID RoleId, String PermissionNode, Boolean Enabled) {
        return CompletableFuture.supplyAsync(
                () -> this.SetAMPRolePermission(RoleId, PermissionNode, Enabled));
    }

    /**
     * Name Description
     *
     * @param UserId
     * @param RoleId
     * @param IsMember
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> SetAMPUserRoleMembership(
            UUID UserId, UUID RoleId, Boolean IsMember) {
        Map<String, Object> args = new HashMap<>();
        args.put("UserId", UserId);
        args.put("RoleId", RoleId);
        args.put("IsMember", IsMember);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/SetAMPUserRoleMembership", args, type);
    }

    /**
     * Name Description
     *
     * @param UserId
     * @param RoleId
     * @param IsMember
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> SetAMPUserRoleMembershipAsync(
            UUID UserId, UUID RoleId, Boolean IsMember) {
        return CompletableFuture.supplyAsync(
                () -> this.SetAMPUserRoleMembership(UserId, RoleId, IsMember));
    }

    /**
     * Name Description
     *
     * @param node
     * @param value
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> SetConfig(String node, String value) {
        Map<String, Object> args = new HashMap<>();
        args.put("node", node);
        args.put("value", value);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/SetConfig", args, type);
    }

    /**
     * Name Description
     *
     * @param node
     * @param value
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> SetConfigAsync(
            String node, String value) {
        return CompletableFuture.supplyAsync(() -> this.SetConfig(node, value));
    }

    /**
     * Name Description
     *
     * @param data
     * @return Boolean
     */
    public Result<Boolean, AMPError> SetConfigs(Map<String, String> data) {
        Map<String, Object> args = new HashMap<>();
        args.put("data", data);
        Type type = new TypeToken<Boolean>() {}.getType();
        return this.APICall("Core/SetConfigs", args, type);
    }

    /**
     * Name Description
     *
     * @param data
     * @return Boolean
     */
    public CompletionStage<Result<Boolean, AMPError>> SetConfigsAsync(Map<String, String> data) {
        return CompletableFuture.supplyAsync(() -> this.SetConfigs(data));
    }

    /**
     * Name Description
     *
     * @param Id
     * @param Enabled
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> SetTriggerEnabled(UUID Id, Boolean Enabled) {
        Map<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        args.put("Enabled", Enabled);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/SetTriggerEnabled", args, type);
    }

    /**
     * Name Description
     *
     * @param Id
     * @param Enabled
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> SetTriggerEnabledAsync(
            UUID Id, Boolean Enabled) {
        return CompletableFuture.supplyAsync(() -> this.SetTriggerEnabled(Id, Enabled));
    }

    /**
     * Name Description
     *
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> Sleep() {
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/Sleep", type);
    }

    /**
     * Name Description
     *
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> SleepAsync() {
        return CompletableFuture.supplyAsync(() -> this.Sleep());
    }

    /**
     * Name Description
     *
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> Start() {
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/Start", type);
    }

    /**
     * Name Description
     *
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> StartAsync() {
        return CompletableFuture.supplyAsync(() -> this.Start());
    }

    /**
     * Name Description
     *
     * @return Void
     */
    public Result<Void, AMPError> Stop() {
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("Core/Stop", type);
    }

    /**
     * Name Description
     *
     * @return Void
     */
    public CompletionStage<Result<Void, AMPError>> StopAsync() {
        return CompletableFuture.supplyAsync(() -> this.Stop());
    }

    /**
     * Prevents the current instance from being started, and stops it if it's currently running.
     * Name Description
     *
     * @return Void
     */
    public Result<Void, AMPError> Suspend() {
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("Core/Suspend", type);
    }

    /**
     * Prevents the current instance from being started, and stops it if it's currently running.
     * Name Description
     *
     * @return Void
     */
    public CompletionStage<Result<Void, AMPError>> SuspendAsync() {
        return CompletableFuture.supplyAsync(() -> this.Suspend());
    }

    /**
     * Name Description
     *
     * @return Void
     */
    public Result<Void, AMPError> UpdateAMPInstance() {
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("Core/UpdateAMPInstance", type);
    }

    /**
     * Name Description
     *
     * @return Void
     */
    public CompletionStage<Result<Void, AMPError>> UpdateAMPInstanceAsync() {
        return CompletableFuture.supplyAsync(() -> this.UpdateAMPInstance());
    }

    /**
     * Name Description
     *
     * @param EmailAddress
     * @param TwoFactorPIN
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> UpdateAccountInfo(
            String EmailAddress, String TwoFactorPIN) {
        Map<String, Object> args = new HashMap<>();
        args.put("EmailAddress", EmailAddress);
        args.put("TwoFactorPIN", TwoFactorPIN);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/UpdateAccountInfo", args, type);
    }

    /**
     * Name Description
     *
     * @param EmailAddress
     * @param TwoFactorPIN
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> UpdateAccountInfoAsync(
            String EmailAddress, String TwoFactorPIN) {
        return CompletableFuture.supplyAsync(
                () -> this.UpdateAccountInfo(EmailAddress, TwoFactorPIN));
    }

    /**
     * Name Description
     *
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> UpdateApplication() {
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/UpdateApplication", type);
    }

    /**
     * Name Description
     *
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> UpdateApplicationAsync() {
        return CompletableFuture.supplyAsync(() -> this.UpdateApplication());
    }

    /**
     * Name Description
     *
     * @param Username
     * @param Disabled
     * @param PasswordExpires
     * @param CannotChangePassword
     * @param MustChangePassword
     * @param EmailAddress
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> UpdateUserInfo(
            String Username,
            Boolean Disabled,
            Boolean PasswordExpires,
            Boolean CannotChangePassword,
            Boolean MustChangePassword,
            @Nullable String EmailAddress) {
        Map<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("Disabled", Disabled);
        args.put("PasswordExpires", PasswordExpires);
        args.put("CannotChangePassword", CannotChangePassword);
        args.put("MustChangePassword", MustChangePassword);
        args.put("EmailAddress", EmailAddress);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/UpdateUserInfo", args, type);
    }

    /**
     * Name Description
     *
     * @param Username
     * @param Disabled
     * @param PasswordExpires
     * @param CannotChangePassword
     * @param MustChangePassword
     * @param EmailAddress
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> UpdateUserInfoAsync(
            String Username,
            Boolean Disabled,
            Boolean PasswordExpires,
            Boolean CannotChangePassword,
            Boolean MustChangePassword,
            @Nullable String EmailAddress) {
        return CompletableFuture.supplyAsync(
                () ->
                        this.UpdateUserInfo(
                                Username,
                                Disabled,
                                PasswordExpires,
                                CannotChangePassword,
                                MustChangePassword,
                                EmailAddress));
    }

    /**
     * Name Description
     *
     * @return Void
     */
    public Result<Void, AMPError> UpgradeAMP() {
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("Core/UpgradeAMP", type);
    }

    /**
     * Name Description
     *
     * @return Void
     */
    public CompletionStage<Result<Void, AMPError>> UpgradeAMPAsync() {
        return CompletableFuture.supplyAsync(() -> this.UpgradeAMP());
    }

    /**
     * Name Description
     *
     * @param attestationObject
     * @param clientDataJSON
     * @param description
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> WebauthnRegister(
            String attestationObject, String clientDataJSON, @Nullable String description) {
        Map<String, Object> args = new HashMap<>();
        args.put("attestationObject", attestationObject);
        args.put("clientDataJSON", clientDataJSON);
        args.put("description", description);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/WebauthnRegister", args, type);
    }

    /**
     * Name Description
     *
     * @param attestationObject
     * @param clientDataJSON
     * @param description
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> WebauthnRegisterAsync(
            String attestationObject, String clientDataJSON, @Nullable String description) {
        return CompletableFuture.supplyAsync(
                () -> this.WebauthnRegister(attestationObject, clientDataJSON, description));
    }
}
