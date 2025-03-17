package dev.neuralnexus.ampapi.plugins;

import com.google.gson.reflect.TypeToken;

import dev.neuralnexus.ampapi.AMPAPI;
import dev.neuralnexus.ampapi.types.*;
import dev.neuralnexus.ampapi.auth.AuthProvider;

import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Type;
import java.net.InetAddress;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class Core extends AMPAPI {
    public Core(AuthProvider authprovider) {
        super(authprovider);
    }

    /**
     * Name Description Optional

     * @return Void
     */
    public Void AcknowledgeAMPUpdate() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("Core/AcknowledgeAMPUpdate", args, type);
    }

    /**
     * Name Description Optional
     * @param LicenceKey 
     * @param QueryOnly 
     * @return ActionResult<LicenceInfo>
     */
    public ActionResult<LicenceInfo> ActivateAMPLicence(String LicenceKey, @Nullable Boolean QueryOnly) {
        Map<String, Object> args = new HashMap<>();
        args.put("LicenceKey", LicenceKey);
        args.put("QueryOnly", QueryOnly);
        Type type = new TypeToken<ActionResult<LicenceInfo>>() {}.getType();
        return this.APICall("Core/ActivateAMPLicence", args, type);
    }

    /**
     * Name Description Optional
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
     * @param months 
     * @param days 
     * @param hours 
     * @param minutes 
     * @param daysOfMonth 
     * @param description 
     * @return ActionResult
     */
    public ActionResult AddIntervalTrigger(List<Integer> months, List<Integer> days, List<Integer> hours, List<Integer> minutes, List<Integer> daysOfMonth, String description) {
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
     * @param TriggerID 
     * @param MethodID 
     * @param ParameterMapping 
     * @return ActionResult
     */
    public ActionResult AddTask(UUID TriggerID, String MethodID, Map<String, String> ParameterMapping) {
        Map<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        args.put("MethodID", MethodID);
        args.put("ParameterMapping", ParameterMapping);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/AddTask", args, type);
    }

    /**DEV: Async test method
     * Name Description Optional

     * @return String
     */
    public String AsyncTest() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<String>() {}.getType();
        return this.APICall("Core/AsyncTest", args, type);
    }

    /**
     * Name Description Optional
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

    /**For a user to change their own password, requires knowing the old password
     * Name Description Optional
     * @param Username 
     * @param OldPassword 
     * @param NewPassword 
     * @param TwoFactorPIN 
     * @return ActionResult
     */
    public ActionResult ChangeUserPassword(String Username, String OldPassword, String NewPassword, String TwoFactorPIN) {
        Map<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("OldPassword", OldPassword);
        args.put("NewPassword", NewPassword);
        args.put("TwoFactorPIN", TwoFactorPIN);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/ChangeUserPassword", args, type);
    }

    /**Completes two-factor setup by supplying a valid two factor code based on the secret provided by EnableTwoFactor
     * Name Description Optional
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
     * @param Name 
     * @param AsCommonRole 
     * @return ActionResult<UUID>
     */
    public ActionResult<UUID> CreateRole(String Name, @Nullable Boolean AsCommonRole) {
        Map<String, Object> args = new HashMap<>();
        args.put("Name", Name);
        args.put("AsCommonRole", AsCommonRole);
        Type type = new TypeToken<ActionResult<UUID>>() {}.getType();
        return this.APICall("Core/CreateRole", args, type);
    }

    /**DEV: Creates a non-ending task with 50% progress for testing purposes
     * Name Description Optional

     * @return Void
     */
    public Void CreateTestTask() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("Core/CreateTestTask", args, type);
    }

    /**
     * Name Description Optional
     * @param Username 
     * @return ActionResult<UUID>
     */
    public ActionResult<UUID> CreateUser(String Username) {
        Map<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        Type type = new TypeToken<ActionResult<UUID>>() {}.getType();
        return this.APICall("Core/CreateUser", args, type);
    }

    /**
     * Name Description Optional
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

     * @return ActionResult
     */
    public ActionResult DismissAllTasks() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/DismissAllTasks", args, type);
    }

    /**
     * Name Description Optional
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
     * @param Id 
     * @param months 
     * @param days 
     * @param hours 
     * @param minutes 
     * @param daysOfMonth 
     * @param description 
     * @return ActionResult
     */
    public ActionResult EditIntervalTrigger(UUID Id, List<Integer> months, List<Integer> days, List<Integer> hours, List<Integer> minutes, List<Integer> daysOfMonth, String description) {
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
     * @param TriggerID 
     * @param TaskID 
     * @param ParameterMapping 
     * @return ActionResult
     */
    public ActionResult EditTask(UUID TriggerID, UUID TaskID, Map<String, String> ParameterMapping) {
        Map<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        args.put("TaskID", TaskID);
        args.put("ParameterMapping", ParameterMapping);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/EditTask", args, type);
    }

    /**Sets up two-factor authentication for the given user. ConfirmTwoFactorSetup must be invoked to complete setup.
     * Name Description Optional
     * @param Username 
     * @param Password 
     * @return ActionResult<TwoFactorSetupInfo>
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
     * @param Id 
     * @return Void
     */
    public Void EndUserSession(UUID Id) {
        Map<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("Core/EndUserSession", args, type);
    }

    /**
     * Name Description Optional
     * @param RoleId 
     * @return List<String>
     */
    public List<String> GetAMPRolePermissions(UUID RoleId) {
        Map<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        Type type = new TypeToken<List<String>>() {}.getType();
        return this.APICall("Core/GetAMPRolePermissions", args, type);
    }

    /**
     * Name Description Optional
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

     * @return List<UserInfoSummary>
     */
    public List<UserInfoSummary> GetAMPUsersSummary() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<UserInfoSummary>>() {}.getType();
        return this.APICall("Core/GetAMPUsersSummary", args, type);
    }

    /**
     * Name Description Optional

     * @return Map<String, Map<String, MethodInfoSummary>>
     */
    public Map<String, Map<String, MethodInfoSummary>> GetAPISpec() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Map<String, Map<String, MethodInfoSummary>>>() {}.getType();
        return this.APICall("Core/GetAPISpec", args, type);
    }

    /**
     * Name Description Optional

     * @return List<WebSessionSummary>
     */
    public List<WebSessionSummary> GetActiveAMPSessions() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<WebSessionSummary>>() {}.getType();
        return this.APICall("Core/GetActiveAMPSessions", args, type);
    }

    /**
     * Name Description Optional

     * @return List<UserInfo>
     */
    public List<UserInfo> GetAllAMPUserInfo() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<UserInfo>>() {}.getType();
        return this.APICall("Core/GetAllAMPUserInfo", args, type);
    }

    /**
     * Name Description Optional
     * @param Before 
     * @param Count 
     * @return List<IAuditLogEntry>
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
     * @param username 
     * @return List<AuthenticationRequirement>
     */
    public List<AuthenticationRequirement> GetAuthenticationRequirements(String username) {
        Map<String, Object> args = new HashMap<>();
        args.put("username", username);
        Type type = new TypeToken<List<AuthenticationRequirement>>() {}.getType();
        return this.APICall("Core/GetAuthenticationRequirements", args, type);
    }

    /**
     * Name Description Optional
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
     * @param nodes 
     * @return List<SettingSpec>
     */
    public List<SettingSpec> GetConfigs(List<String> nodes) {
        Map<String, Object> args = new HashMap<>();
        args.put("nodes", nodes);
        Type type = new TypeToken<List<SettingSpec>>() {}.getType();
        return this.APICall("Core/GetConfigs", args, type);
    }

    /**
     * Name Description Optional

     * @return Map<String, String>
     */
    public Map<String, String> GetDiagnosticsInfo() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Map<String, String>>() {}.getType();
        return this.APICall("Core/GetDiagnosticsInfo", args, type);
    }

    /**
     * Name Description Optional

     * @return ModuleInfo
     */
    public ModuleInfo GetModuleInfo() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<ModuleInfo>() {}.getType();
        return this.APICall("Core/GetModuleInfo", args, type);
    }

    /**
     * Name Description Optional

     * @return UUID
     */
    public UUID GetNewGuid() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<UUID>() {}.getType();
        return this.APICall("Core/GetNewGuid", args, type);
    }

    /**
     * Name Description Optional

     * @return List<IPermissionsTreeNode>
     */
    public List<IPermissionsTreeNode> GetPermissionsSpec() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<IPermissionsTreeNode>>() {}.getType();
        return this.APICall("Core/GetPermissionsSpec", args, type);
    }

    /**
     * Name Description Optional

     * @return List<ListeningPortSummary>
     */
    public List<ListeningPortSummary> GetPortSummaries() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<ListeningPortSummary>>() {}.getType();
        return this.APICall("Core/GetPortSummaries", args, type);
    }

    /**
     * Name Description Optional

     * @return List<SettingSpec>
     */
    public List<SettingSpec> GetProvisionSpec() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<SettingSpec>>() {}.getType();
        return this.APICall("Core/GetProvisionSpec", args, type);
    }

    /**
     * Name Description Optional
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

     * @return List<AuthRoleSummary>
     */
    public List<AuthRoleSummary> GetRoleData() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<AuthRoleSummary>>() {}.getType();
        return this.APICall("Core/GetRoleData", args, type);
    }

    /**
     * Name Description Optional

     * @return Map<UUID, String>
     */
    public Map<UUID, String> GetRoleIds() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Map<UUID, String>>() {}.getType();
        return this.APICall("Core/GetRoleIds", args, type);
    }

    /**
     * Name Description Optional

     * @return ScheduleInfo
     */
    public ScheduleInfo GetScheduleData() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<ScheduleInfo>() {}.getType();
        return this.APICall("Core/GetScheduleData", args, type);
    }

    /**
     * Name Description Optional
     * @param SettingNode 
     * @param WithRefresh 
     * @return Map<String, String>
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

     * @return Map<String, List<SettingSpec>>
     */
    public Map<String, List<SettingSpec>> GetSettingsSpec() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Map<String, List<SettingSpec>>>() {}.getType();
        return this.APICall("Core/GetSettingsSpec", args, type);
    }

    /**
     * Name Description Optional

     * @return StatusResponse
     */
    public StatusResponse GetStatus() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<StatusResponse>() {}.getType();
        return this.APICall("Core/GetStatus", args, type);
    }

    /**
     * Name Description Optional

     * @return List<RunningTask>
     */
    public List<RunningTask> GetTasks() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<RunningTask>>() {}.getType();
        return this.APICall("Core/GetTasks", args, type);
    }

    /**
     * Name Description Optional
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

     * @return UpdateInfo
     */
    public UpdateInfo GetUpdateInfo() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<UpdateInfo>() {}.getType();
        return this.APICall("Core/GetUpdateInfo", args, type);
    }

    /**Gets changes to the server status, in addition to any notifications or console output that have occured since the last time GetUpdates() was called by the current session.
     * Name Description Optional

     * @return UpdateResponse
     */
    public UpdateResponse GetUpdates() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<UpdateResponse>() {}.getType();
        return this.APICall("Core/GetUpdates", args, type);
    }

    /**
     * Name Description Optional

     * @return Object
     */
    public Object GetUserActionsSpec() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Object>() {}.getType();
        return this.APICall("Core/GetUserActionsSpec", args, type);
    }

    /**Provides information about a given in-application user (as opposed to AMP system users)
     * Name Description Optional
     * @param UID 
     * @return SimpleUser
     */
    public SimpleUser GetUserInfo(String UID) {
        Map<String, Object> args = new HashMap<>();
        args.put("UID", UID);
        Type type = new TypeToken<SimpleUser>() {}.getType();
        return this.APICall("Core/GetUserInfo", args, type);
    }

    /**Returns a list of in-application users
     * Name Description Optional

     * @return Map<String, String>
     */
    public Map<String, String> GetUserList() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Map<String, String>>() {}.getType();
        return this.APICall("Core/GetUserList", args, type);
    }

    /**
     * Name Description Optional

     * @return ActionResult<String>
     */
    public ActionResult<String> GetWebauthnChallenge() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<ActionResult<String>>() {}.getType();
        return this.APICall("Core/GetWebauthnChallenge", args, type);
    }

    /**
     * Name Description Optional
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

     * @return List<WebauthnCredentialSummary>
     */
    public List<WebauthnCredentialSummary> GetWebauthnCredentialSummaries() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<WebauthnCredentialSummary>>() {}.getType();
        return this.APICall("Core/GetWebauthnCredentialSummaries", args, type);
    }

    /**
     * Name Description Optional

     * @return Void
     */
    public Void Kill() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("Core/Kill", args, type);
    }

    /**
     * Name Description Optional
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

    /**
     * Name Description Optional

     * @return Void
     */
    public Void Logout() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("Core/Logout", args, type);
    }

    /**
     * Name Description Optional
     * @param Node 
     * @return ActionResult
     */
    public ActionResult RefreshSettingValueList(String Node) {
        Map<String, Object> args = new HashMap<>();
        args.put("Node", Node);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/RefreshSettingValueList", args, type);
    }

    /**
     * Name Description Optional

     * @return Void
     */
    public Void RefreshSettingsSourceCache() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("Core/RefreshSettingsSourceCache", args, type);
    }

    /**
     * Name Description Optional
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

    /**For administrative users to alter the password of another user
     * Name Description Optional
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

     * @return ActionResult
     */
    public ActionResult Restart() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/Restart", args, type);
    }

    /**
     * Name Description Optional

     * @return Void
     */
    public Void RestartAMP() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("Core/RestartAMP", args, type);
    }

    /**Allows the service to be re-started after previously being suspended.
     * Name Description Optional

     * @return Void
     */
    public Void Resume() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("Core/Resume", args, type);
    }

    /**
     * Name Description Optional
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

     * @return List<SecurityCheckResult>
     */
    public List<SecurityCheckResult> RunSecurityCheck() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<SecurityCheckResult>>() {}.getType();
        return this.APICall("Core/RunSecurityCheck", args, type);
    }

    /**
     * Name Description Optional
     * @param message 
     * @return Void
     */
    public Void SendConsoleMessage(String message) {
        Map<String, Object> args = new HashMap<>();
        args.put("message", message);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("Core/SendConsoleMessage", args, type);
    }

    /**
     * Name Description Optional
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

     * @return ActionResult
     */
    public ActionResult Sleep() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/Sleep", args, type);
    }

    /**
     * Name Description Optional

     * @return ActionResult
     */
    public ActionResult Start() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/Start", args, type);
    }

    /**
     * Name Description Optional

     * @return Void
     */
    public Void Stop() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("Core/Stop", args, type);
    }

    /**Prevents the current instance from being started, and stops it if it's currently running.
     * Name Description Optional

     * @return Void
     */
    public Void Suspend() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("Core/Suspend", args, type);
    }

    /**
     * Name Description Optional

     * @return Void
     */
    public Void UpdateAMPInstance() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("Core/UpdateAMPInstance", args, type);
    }

    /**
     * Name Description Optional
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

     * @return ActionResult
     */
    public ActionResult UpdateApplication() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/UpdateApplication", args, type);
    }

    /**
     * Name Description Optional
     * @param Username 
     * @param Disabled 
     * @param PasswordExpires 
     * @param CannotChangePassword 
     * @param MustChangePassword 
     * @param EmailAddress 
     * @return ActionResult
     */
    public ActionResult UpdateUserInfo(String Username, Boolean Disabled, Boolean PasswordExpires, Boolean CannotChangePassword, Boolean MustChangePassword, @Nullable String EmailAddress) {
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
     * Name Description Optional

     * @return Void
     */
    public Void UpgradeAMP() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("Core/UpgradeAMP", args, type);
    }

    /**
     * Name Description Optional
     * @param attestationObject 
     * @param clientDataJSON 
     * @param description 
     * @return ActionResult
     */
    public ActionResult WebauthnRegister(String attestationObject, String clientDataJSON, @Nullable String description) {
        Map<String, Object> args = new HashMap<>();
        args.put("attestationObject", attestationObject);
        args.put("clientDataJSON", clientDataJSON);
        args.put("description", description);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("Core/WebauthnRegister", args, type);
    }


}