/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.plugins;

import com.google.gson.reflect.TypeToken;

import dev.neuralnexus.ampapi.AMPAPI;
import dev.neuralnexus.ampapi.auth.AuthProvider;
import dev.neuralnexus.ampapi.types.*;

import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class Core extends AMPAPI {
    public Core(AuthProvider authprovider) {
        super(authprovider);
    }

    /** */
    public void AcknowledgeAMPUpdate() {
        this.APICall("Core/AcknowledgeAMPUpdate");
    }

    /**
     * Name Description Optional
     *
     * @param LicenceKey
     * @param QueryOnly
     * @return ActionResult&lt;LicenceInfo&gt;
     */
    public ActionResult<LicenceInfo> ActivateAMPLicence(
            String LicenceKey, @Nullable Boolean QueryOnly) {
        Map<String, Object> args = new HashMap<>();
        args.put("LicenceKey", LicenceKey);
        args.put("QueryOnly", QueryOnly);
        Type type = new TypeToken<ActionResult<LicenceInfo>>() {}.getType();
        return this.APICall("Core/ActivateAMPLicence", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param triggerId
     * @return ActionResult
     */
    public ActionResult AddEventTrigger(UUID triggerId) {
        Map<String, Object> args = new HashMap<>();
        args.put("triggerId", triggerId);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/AddEventTrigger", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param months
     * @param days
     * @param hours
     * @param minutes
     * @param daysOfMonth
     * @param description
     * @return ActionResult
     */
    public ActionResult AddIntervalTrigger(
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
     * Name Description Optional
     *
     * @param TriggerID
     * @param MethodID
     * @param ParameterMapping
     * @return ActionResult
     */
    public ActionResult AddTask(
            UUID TriggerID, String MethodID, Map<String, String> ParameterMapping) {
        Map<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        args.put("MethodID", MethodID);
        args.put("ParameterMapping", ParameterMapping);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/AddTask", args, type);
    }

    /**
     * DEV: Async test method Name Description Optional
     *
     * @return String
     */
    public String AsyncTest() {
        Type type = new TypeToken<String>() {}.getType();
        return this.APICall("Core/AsyncTest", type);
    }

    /**
     * Name Description Optional
     *
     * @param TaskId
     * @return ActionResult
     */
    public ActionResult CancelTask(UUID TaskId) {
        Map<String, Object> args = new HashMap<>();
        args.put("TaskId", TaskId);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/CancelTask", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param TriggerID
     * @param TaskID
     * @param NewOrder
     * @return ActionResult
     */
    public ActionResult ChangeTaskOrder(UUID TriggerID, UUID TaskID, Integer NewOrder) {
        Map<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        args.put("TaskID", TaskID);
        args.put("NewOrder", NewOrder);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/ChangeTaskOrder", args, type);
    }

    /**
     * For a user to change their own password, requires knowing the old password Name Description
     * Optional
     *
     * @param Username
     * @param OldPassword
     * @param NewPassword
     * @param TwoFactorPIN
     * @return ActionResult
     */
    public ActionResult ChangeUserPassword(
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
     * Completes two-factor setup by supplying a valid two factor code based on the secret provided
     * by EnableTwoFactor Name Description Optional
     *
     * @param Username
     * @param TwoFactorCode
     * @return ActionResult
     */
    public ActionResult ConfirmTwoFactorSetup(String Username, String TwoFactorCode) {
        Map<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("TwoFactorCode", TwoFactorCode);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/ConfirmTwoFactorSetup", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param Name
     * @param AsCommonRole
     * @return ActionResult&lt;UUID&gt;
     */
    public ActionResult<UUID> CreateRole(String Name, @Nullable Boolean AsCommonRole) {
        Map<String, Object> args = new HashMap<>();
        args.put("Name", Name);
        args.put("AsCommonRole", AsCommonRole);
        Type type = new TypeToken<ActionResult<UUID>>() {}.getType();
        return this.APICall("Core/CreateRole", args, type);
    }

    /** DEV: Creates a non-ending task with 50% progress for testing purposes */
    public void CreateTestTask() {
        this.APICall("Core/CreateTestTask");
    }

    /**
     * Name Description Optional
     *
     * @param Username
     * @return ActionResult&lt;UUID&gt;
     */
    public ActionResult<UUID> CreateUser(String Username) {
        Map<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        Type type = new TypeToken<ActionResult<UUID>>() {}.getType();
        return this.APICall("Core/CreateUser", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param PermissionNode
     * @return Boolean
     */
    public Boolean CurrentSessionHasPermission(String PermissionNode) {
        Map<String, Object> args = new HashMap<>();
        args.put("PermissionNode", PermissionNode);
        Type type = new TypeToken<Boolean>() {}.getType();
        return this.APICall("Core/CurrentSessionHasPermission", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param InstanceId
     * @return ActionResult
     */
    public ActionResult DeleteInstanceUsers(UUID InstanceId) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/DeleteInstanceUsers", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param RoleId
     * @return ActionResult
     */
    public ActionResult DeleteRole(UUID RoleId) {
        Map<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/DeleteRole", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param TriggerID
     * @param TaskID
     * @return ActionResult
     */
    public ActionResult DeleteTask(UUID TriggerID, UUID TaskID) {
        Map<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        args.put("TaskID", TaskID);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/DeleteTask", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param TriggerID
     * @return ActionResult
     */
    public ActionResult DeleteTrigger(UUID TriggerID) {
        Map<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/DeleteTrigger", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param Username
     * @return ActionResult
     */
    public ActionResult DeleteUser(String Username) {
        Map<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/DeleteUser", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param Password
     * @param TwoFactorCode
     * @return ActionResult
     */
    public ActionResult DisableTwoFactor(String Password, String TwoFactorCode) {
        Map<String, Object> args = new HashMap<>();
        args.put("Password", Password);
        args.put("TwoFactorCode", TwoFactorCode);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/DisableTwoFactor", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return ActionResult
     */
    public ActionResult DismissAllTasks() {
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/DismissAllTasks", type);
    }

    /**
     * Name Description Optional
     *
     * @param TaskId
     * @return ActionResult
     */
    public ActionResult DismissTask(UUID TaskId) {
        Map<String, Object> args = new HashMap<>();
        args.put("TaskId", TaskId);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/DismissTask", args, type);
    }

    /**
     * Name Description Optional
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
    public ActionResult EditIntervalTrigger(
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
     * Name Description Optional
     *
     * @param TriggerID
     * @param TaskID
     * @param ParameterMapping
     * @return ActionResult
     */
    public ActionResult EditTask(
            UUID TriggerID, UUID TaskID, Map<String, String> ParameterMapping) {
        Map<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        args.put("TaskID", TaskID);
        args.put("ParameterMapping", ParameterMapping);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/EditTask", args, type);
    }

    /**
     * Sets up two-factor authentication for the given user. ConfirmTwoFactorSetup must be invoked
     * to complete setup. Name Description Optional
     *
     * @param Username
     * @param Password
     * @return ActionResult&lt;TwoFactorSetupInfo&gt;
     */
    public ActionResult<TwoFactorSetupInfo> EnableTwoFactor(String Username, String Password) {
        Map<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("Password", Password);
        Type type = new TypeToken<ActionResult<TwoFactorSetupInfo>>() {}.getType();
        return this.APICall("Core/EnableTwoFactor", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param Id
     */
    public void EndUserSession(UUID Id) {
        Map<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        this.APICall("Core/EndUserSession", args);
    }

    /**
     * Name Description Optional
     *
     * @param RoleId
     * @return List&lt;String&gt;
     */
    public List<String> GetAMPRolePermissions(UUID RoleId) {
        Map<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        Type type = new TypeToken<List<String>>() {}.getType();
        return this.APICall("Core/GetAMPRolePermissions", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param Username
     * @return UserInfo
     */
    public UserInfo GetAMPUserInfo(String Username) {
        Map<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        Type type = new TypeToken<UserInfo>() {}.getType();
        return this.APICall("Core/GetAMPUserInfo", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return List&lt;UserInfoSummary&gt;
     */
    public List<UserInfoSummary> GetAMPUsersSummary() {
        Type type = new TypeToken<List<UserInfoSummary>>() {}.getType();
        return this.APICall("Core/GetAMPUsersSummary", type);
    }

    /**
     * Name Description Optional
     *
     * @return Map&lt;String, Map&lt;String, MethodInfoSummary&gt;&gt;
     */
    public Map<String, Map<String, MethodInfoSummary>> GetAPISpec() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Map<String, Map<String, MethodInfoSummary>>>() {}.getType();
        return this.APICall("Core/GetAPISpec", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return List&lt;WebSessionSummary&gt;
     */
    public List<WebSessionSummary> GetActiveAMPSessions() {
        Type type = new TypeToken<List<WebSessionSummary>>() {}.getType();
        return this.APICall("Core/GetActiveAMPSessions", type);
    }

    /**
     * Name Description Optional
     *
     * @return List&lt;UserInfo&gt;
     */
    public List<UserInfo> GetAllAMPUserInfo() {
        Type type = new TypeToken<List<UserInfo>>() {}.getType();
        return this.APICall("Core/GetAllAMPUserInfo", type);
    }

    /**
     * Name Description Optional
     *
     * @param Before
     * @param Count
     * @return List&lt;IAuditLogEntry&gt;
     */
    public List<IAuditLogEntry> GetAuditLogEntries(String Before, Integer Count) {
        Map<String, Object> args = new HashMap<>();
        args.put("Before", Before);
        args.put("Count", Count);
        Type type = new TypeToken<List<IAuditLogEntry>>() {}.getType();
        return this.APICall("Core/GetAuditLogEntries", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param username
     * @return List&lt;AuthenticationRequirement&gt;
     */
    public List<AuthenticationRequirement> GetAuthenticationRequirements(String username) {
        Map<String, Object> args = new HashMap<>();
        args.put("username", username);
        Type type = new TypeToken<List<AuthenticationRequirement>>() {}.getType();
        return this.APICall("Core/GetAuthenticationRequirements", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param node
     * @return SettingSpec
     */
    public SettingSpec GetConfig(String node) {
        Map<String, Object> args = new HashMap<>();
        args.put("node", node);
        Type type = new TypeToken<SettingSpec>() {}.getType();
        return this.APICall("Core/GetConfig", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param nodes
     * @return List&lt;SettingSpec&gt;
     */
    public List<SettingSpec> GetConfigs(List<String> nodes) {
        Map<String, Object> args = new HashMap<>();
        args.put("nodes", nodes);
        Type type = new TypeToken<List<SettingSpec>>() {}.getType();
        return this.APICall("Core/GetConfigs", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return Map&lt;String, String&gt;
     */
    public Map<String, String> GetDiagnosticsInfo() {
        Type type = new TypeToken<Map<String, String>>() {}.getType();
        return this.APICall("Core/GetDiagnosticsInfo", type);
    }

    /**
     * Name Description Optional
     *
     * @return ModuleInfo
     */
    public ModuleInfo GetModuleInfo() {
        Type type = new TypeToken<ModuleInfo>() {}.getType();
        return this.APICall("Core/GetModuleInfo", type);
    }

    /**
     * Name Description Optional
     *
     * @return UUID
     */
    public UUID GetNewGuid() {
        Type type = new TypeToken<UUID>() {}.getType();
        return this.APICall("Core/GetNewGuid", type);
    }

    /**
     * Name Description Optional
     *
     * @return List&lt;IPermissionsTreeNode&gt;
     */
    public List<IPermissionsTreeNode> GetPermissionsSpec() {
        Type type = new TypeToken<List<IPermissionsTreeNode>>() {}.getType();
        return this.APICall("Core/GetPermissionsSpec", type);
    }

    /**
     * Name Description Optional
     *
     * @return List&lt;ListeningPortSummary&gt;
     */
    public List<ListeningPortSummary> GetPortSummaries() {
        Type type = new TypeToken<List<ListeningPortSummary>>() {}.getType();
        return this.APICall("Core/GetPortSummaries", type);
    }

    /**
     * Name Description Optional
     *
     * @return List&lt;SettingSpec&gt;
     */
    public List<SettingSpec> GetProvisionSpec() {
        Type type = new TypeToken<List<SettingSpec>>() {}.getType();
        return this.APICall("Core/GetProvisionSpec", type);
    }

    /**
     * Name Description Optional
     *
     * @param Description
     * @param IsTemporary
     * @return String
     */
    public String GetRemoteLoginToken(@Nullable String Description, @Nullable Boolean IsTemporary) {
        Map<String, Object> args = new HashMap<>();
        args.put("Description", Description);
        args.put("IsTemporary", IsTemporary);
        Type type = new TypeToken<String>() {}.getType();
        return this.APICall("Core/GetRemoteLoginToken", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param RoleId
     * @return AuthRoleSummary
     */
    public AuthRoleSummary GetRole(UUID RoleId) {
        Map<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        Type type = new TypeToken<AuthRoleSummary>() {}.getType();
        return this.APICall("Core/GetRole", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return List&lt;AuthRoleSummary&gt;
     */
    public List<AuthRoleSummary> GetRoleData() {
        Type type = new TypeToken<List<AuthRoleSummary>>() {}.getType();
        return this.APICall("Core/GetRoleData", type);
    }

    /**
     * Name Description Optional
     *
     * @return Map&lt;UUID, String&gt;
     */
    public Map<UUID, String> GetRoleIds() {
        Type type = new TypeToken<Map<UUID, String>>() {}.getType();
        return this.APICall("Core/GetRoleIds", type);
    }

    /**
     * Name Description Optional
     *
     * @return ScheduleInfo
     */
    public ScheduleInfo GetScheduleData() {
        Type type = new TypeToken<ScheduleInfo>() {}.getType();
        return this.APICall("Core/GetScheduleData", type);
    }

    /**
     * Name Description Optional
     *
     * @param SettingNode
     * @param WithRefresh
     * @return Map&lt;String, String&gt;
     */
    public Map<String, String> GetSettingValues(String SettingNode, @Nullable Boolean WithRefresh) {
        Map<String, Object> args = new HashMap<>();
        args.put("SettingNode", SettingNode);
        args.put("WithRefresh", WithRefresh);
        Type type = new TypeToken<Map<String, String>>() {}.getType();
        return this.APICall("Core/GetSettingValues", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return Map&lt;String, List&lt;SettingSpec&gt;&gt;
     */
    public Map<String, List<SettingSpec>> GetSettingsSpec() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Map<String, List<SettingSpec>>>() {}.getType();
        return this.APICall("Core/GetSettingsSpec", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return StatusResponse
     */
    public StatusResponse GetStatus() {
        Type type = new TypeToken<StatusResponse>() {}.getType();
        return this.APICall("Core/GetStatus", type);
    }

    /**
     * Name Description Optional
     *
     * @return List&lt;RunningTask&gt;
     */
    public List<RunningTask> GetTasks() {
        Type type = new TypeToken<List<RunningTask>>() {}.getType();
        return this.APICall("Core/GetTasks", type);
    }

    /**
     * Name Description Optional
     *
     * @param Id
     * @return TimeIntervalTrigger
     */
    public TimeIntervalTrigger GetTimeIntervalTrigger(UUID Id) {
        Map<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        Type type = new TypeToken<TimeIntervalTrigger>() {}.getType();
        return this.APICall("Core/GetTimeIntervalTrigger", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return UpdateInfo
     */
    public UpdateInfo GetUpdateInfo() {
        Type type = new TypeToken<UpdateInfo>() {}.getType();
        return this.APICall("Core/GetUpdateInfo", type);
    }

    /**
     * Gets changes to the server status, in addition to any notifications or console output that
     * have occured since the last time GetUpdates() was called by the current session. Name
     * Description Optional
     *
     * @return UpdateResponse
     */
    public UpdateResponse GetUpdates() {
        Type type = new TypeToken<UpdateResponse>() {}.getType();
        return this.APICall("Core/GetUpdates", type);
    }

    /**
     * Name Description Optional
     *
     * @return Object
     */
    public Object GetUserActionsSpec() {
        Type type = new TypeToken<Object>() {}.getType();
        return this.APICall("Core/GetUserActionsSpec", type);
    }

    /**
     * Provides information about a given in-application user (as opposed to AMP system users) Name
     * Description Optional
     *
     * @param UID
     * @return SimpleUser
     */
    public SimpleUser GetUserInfo(String UID) {
        Map<String, Object> args = new HashMap<>();
        args.put("UID", UID);
        Type type = new TypeToken<SimpleUser>() {}.getType();
        return this.APICall("Core/GetUserInfo", args, type);
    }

    /**
     * Returns a list of in-application users Name Description Optional
     *
     * @return Map&lt;String, String&gt;
     */
    public Map<String, String> GetUserList() {
        Type type = new TypeToken<Map<String, String>>() {}.getType();
        return this.APICall("Core/GetUserList", type);
    }

    /**
     * Name Description Optional
     *
     * @return ActionResult&lt;String&gt;
     */
    public ActionResult<String> GetWebauthnChallenge() {
        Type type = new TypeToken<ActionResult<String>>() {}.getType();
        return this.APICall("Core/GetWebauthnChallenge", type);
    }

    /**
     * Name Description Optional
     *
     * @param username
     * @return WebauthnLoginInfo
     */
    public WebauthnLoginInfo GetWebauthnCredentialIDs(String username) {
        Map<String, Object> args = new HashMap<>();
        args.put("username", username);
        Type type = new TypeToken<WebauthnLoginInfo>() {}.getType();
        return this.APICall("Core/GetWebauthnCredentialIDs", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return List&lt;WebauthnCredentialSummary&gt;
     */
    public List<WebauthnCredentialSummary> GetWebauthnCredentialSummaries() {
        Type type = new TypeToken<List<WebauthnCredentialSummary>>() {}.getType();
        return this.APICall("Core/GetWebauthnCredentialSummaries", type);
    }

    /** */
    public void Kill() {
        this.APICall("Core/Kill");
    }

    /**
     * Name Description Optional
     *
     * @param username
     * @param password
     * @param token
     * @param rememberMe
     * @return LoginResponse
     */
    public LoginResponse Login(String username, String password, String token, Boolean rememberMe) {
        Map<String, Object> args = new HashMap<>();
        args.put("username", username);
        args.put("password", password);
        args.put("token", token);
        args.put("rememberMe", rememberMe);
        Type type = new TypeToken<LoginResponse>() {}.getType();
        return this.APICall("Core/Login", args, type);
    }

    /** */
    public void Logout() {
        this.APICall("Core/Logout");
    }

    /**
     * Name Description Optional
     *
     * @param Node
     * @return ActionResult
     */
    public ActionResult RefreshSettingValueList(String Node) {
        Map<String, Object> args = new HashMap<>();
        args.put("Node", Node);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/RefreshSettingValueList", args, type);
    }

    /** */
    public void RefreshSettingsSourceCache() {
        this.APICall("Core/RefreshSettingsSourceCache");
    }

    /**
     * Name Description Optional
     *
     * @param RoleId
     * @param NewName
     * @return ActionResult
     */
    public ActionResult RenameRole(UUID RoleId, String NewName) {
        Map<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        args.put("NewName", NewName);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/RenameRole", args, type);
    }

    /**
     * For administrative users to alter the password of another user Name Description Optional
     *
     * @param Username
     * @param NewPassword
     * @return ActionResult
     */
    public ActionResult ResetUserPassword(String Username, String NewPassword) {
        Map<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("NewPassword", NewPassword);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/ResetUserPassword", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return ActionResult
     */
    public ActionResult Restart() {
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/Restart", type);
    }

    /** */
    public void RestartAMP() {
        this.APICall("Core/RestartAMP");
    }

    /** Allows the service to be re-started after previously being suspended. */
    public void Resume() {
        this.APICall("Core/Resume");
    }

    /**
     * Name Description Optional
     *
     * @param ID
     * @return ActionResult
     */
    public ActionResult RevokeWebauthnCredential(Integer ID) {
        Map<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/RevokeWebauthnCredential", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param triggerId
     * @return ActionResult
     */
    public ActionResult RunEventTriggerImmediately(UUID triggerId) {
        Map<String, Object> args = new HashMap<>();
        args.put("triggerId", triggerId);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/RunEventTriggerImmediately", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return List&lt;SecurityCheckResult&gt;
     */
    public List<SecurityCheckResult> RunSecurityCheck() {
        Type type = new TypeToken<List<SecurityCheckResult>>() {}.getType();
        return this.APICall("Core/RunSecurityCheck", type);
    }

    /**
     * Name Description Optional
     *
     * @param message
     */
    public void SendConsoleMessage(String message) {
        Map<String, Object> args = new HashMap<>();
        args.put("message", message);
        this.APICall("Core/SendConsoleMessage", args);
    }

    /**
     * Name Description Optional
     *
     * @param RoleId
     * @param PermissionNode
     * @param Enabled
     * @return ActionResult
     */
    public ActionResult SetAMPRolePermission(UUID RoleId, String PermissionNode, Boolean Enabled) {
        Map<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        args.put("PermissionNode", PermissionNode);
        args.put("Enabled", Enabled);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/SetAMPRolePermission", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param UserId
     * @param RoleId
     * @param IsMember
     * @return ActionResult
     */
    public ActionResult SetAMPUserRoleMembership(UUID UserId, UUID RoleId, Boolean IsMember) {
        Map<String, Object> args = new HashMap<>();
        args.put("UserId", UserId);
        args.put("RoleId", RoleId);
        args.put("IsMember", IsMember);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/SetAMPUserRoleMembership", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param node
     * @param value
     * @return ActionResult
     */
    public ActionResult SetConfig(String node, String value) {
        Map<String, Object> args = new HashMap<>();
        args.put("node", node);
        args.put("value", value);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/SetConfig", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param data
     * @return Boolean
     */
    public Boolean SetConfigs(Map<String, String> data) {
        Map<String, Object> args = new HashMap<>();
        args.put("data", data);
        Type type = new TypeToken<Boolean>() {}.getType();
        return this.APICall("Core/SetConfigs", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param Id
     * @param Enabled
     * @return ActionResult
     */
    public ActionResult SetTriggerEnabled(UUID Id, Boolean Enabled) {
        Map<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        args.put("Enabled", Enabled);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/SetTriggerEnabled", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return ActionResult
     */
    public ActionResult Sleep() {
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/Sleep", type);
    }

    /**
     * Name Description Optional
     *
     * @return ActionResult
     */
    public ActionResult Start() {
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/Start", type);
    }

    /** */
    public void Stop() {
        this.APICall("Core/Stop");
    }

    /** Prevents the current instance from being started, and stops it if it's currently running. */
    public void Suspend() {
        this.APICall("Core/Suspend");
    }

    /** */
    public void UpdateAMPInstance() {
        this.APICall("Core/UpdateAMPInstance");
    }

    /**
     * Name Description Optional
     *
     * @param EmailAddress
     * @param TwoFactorPIN
     * @return ActionResult
     */
    public ActionResult UpdateAccountInfo(String EmailAddress, String TwoFactorPIN) {
        Map<String, Object> args = new HashMap<>();
        args.put("EmailAddress", EmailAddress);
        args.put("TwoFactorPIN", TwoFactorPIN);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/UpdateAccountInfo", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return ActionResult
     */
    public ActionResult UpdateApplication() {
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/UpdateApplication", type);
    }

    /**
     * Name Description Optional
     *
     * @param Username
     * @param Disabled
     * @param PasswordExpires
     * @param CannotChangePassword
     * @param MustChangePassword
     * @param EmailAddress
     * @return ActionResult
     */
    public ActionResult UpdateUserInfo(
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

    /** */
    public void UpgradeAMP() {
        this.APICall("Core/UpgradeAMP");
    }

    /**
     * Name Description Optional
     *
     * @param attestationObject
     * @param clientDataJSON
     * @param description
     * @return ActionResult
     */
    public ActionResult WebauthnRegister(
            String attestationObject, String clientDataJSON, @Nullable String description) {
        Map<String, Object> args = new HashMap<>();
        args.put("attestationObject", attestationObject);
        args.put("clientDataJSON", clientDataJSON);
        args.put("description", description);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/WebauthnRegister", args, type);
    }
}
