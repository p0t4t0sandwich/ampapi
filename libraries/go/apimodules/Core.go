package apimodules

// A Go library for the AMP API
// Author: p0t4t0sandich

import (
	"encoding/json"

	"github.com/p0t4t0sandwich/ampapi-go"
)

// struct Core
type Core struct {
    *ampapi.AMPAPI
}

// Function NewCore
// Creates a new Core object
func NewCore(api *ampapi.AMPAPI) *Core {
	return &Core{api}
}

/* AcknowledgeAMPUpdate - 
 * Name Description Optional
 * return any
 */
func (a *Core) AcknowledgeAMPUpdate() (any, error) {
    var args = make(map[string]any)
    var res any
    bytes, err := a.ApiCall("Core/AcknowledgeAMPUpdate", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* ActivateAMPLicence - 
 * Name Description Optional
 * param LicenceKey string  False
 * param QueryOnly bool  True
 * return ampapi.ActionResult[ampapi.LicenceInfo]
 */
func (a *Core) ActivateAMPLicence(LicenceKey string, QueryOnly bool) (ampapi.ActionResult[ampapi.LicenceInfo], error) {
    var args = make(map[string]any)
    args["LicenceKey"] = LicenceKey
    args["QueryOnly"] = QueryOnly
    var res ampapi.ActionResult[ampapi.LicenceInfo]
    bytes, err := a.ApiCall("Core/ActivateAMPLicence", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* AddEventTrigger - 
 * Name Description Optional
 * param triggerId ampapi.UUID  False
 * return ampapi.ActionResult[any]
 */
func (a *Core) AddEventTrigger(triggerId ampapi.UUID) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["triggerId"] = triggerId
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("Core/AddEventTrigger", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* AddIntervalTrigger - 
 * Name Description Optional
 * param months []int32  False
 * param days []int32  False
 * param hours []int32  False
 * param minutes []int32  False
 * param daysOfMonth []int32  False
 * param description string  False
 * return ampapi.ActionResult[any]
 */
func (a *Core) AddIntervalTrigger(months []int32, days []int32, hours []int32, minutes []int32, daysOfMonth []int32, description string) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["months"] = months
    args["days"] = days
    args["hours"] = hours
    args["minutes"] = minutes
    args["daysOfMonth"] = daysOfMonth
    args["description"] = description
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("Core/AddIntervalTrigger", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* AddTask - 
 * Name Description Optional
 * param TriggerID ampapi.UUID  False
 * param MethodID string  False
 * param ParameterMapping map[string]string  False
 * return ampapi.ActionResult[any]
 */
func (a *Core) AddTask(TriggerID ampapi.UUID, MethodID string, ParameterMapping map[string]string) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["TriggerID"] = TriggerID
    args["MethodID"] = MethodID
    args["ParameterMapping"] = ParameterMapping
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("Core/AddTask", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* AsyncTest - 
     * DEV: Async test method
 * Name Description Optional
 * return string
 */
func (a *Core) AsyncTest() (string, error) {
    var args = make(map[string]any)
    var res string
    bytes, err := a.ApiCall("Core/AsyncTest", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* CancelTask - 
 * Name Description Optional
 * param TaskId ampapi.UUID  False
 * return ampapi.ActionResult[any]
 */
func (a *Core) CancelTask(TaskId ampapi.UUID) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["TaskId"] = TaskId
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("Core/CancelTask", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* ChangeTaskOrder - 
 * Name Description Optional
 * param TriggerID ampapi.UUID  False
 * param TaskID ampapi.UUID  False
 * param NewOrder int32  False
 * return ampapi.ActionResult[any]
 */
func (a *Core) ChangeTaskOrder(TriggerID ampapi.UUID, TaskID ampapi.UUID, NewOrder int32) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["TriggerID"] = TriggerID
    args["TaskID"] = TaskID
    args["NewOrder"] = NewOrder
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("Core/ChangeTaskOrder", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* ChangeUserPassword - 
 * Name Description Optional
 * param Username string  False
 * param OldPassword string  False
 * param NewPassword string  False
 * param TwoFactorPIN string  False
 * return ampapi.ActionResult[any]
 */
func (a *Core) ChangeUserPassword(Username string, OldPassword string, NewPassword string, TwoFactorPIN string) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["Username"] = Username
    args["OldPassword"] = OldPassword
    args["NewPassword"] = NewPassword
    args["TwoFactorPIN"] = TwoFactorPIN
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("Core/ChangeUserPassword", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* ConfirmTwoFactorSetup - 
 * Name Description Optional
 * param Username string  False
 * param TwoFactorCode string  False
 * return ampapi.ActionResult[any]
 */
func (a *Core) ConfirmTwoFactorSetup(Username string, TwoFactorCode string) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["Username"] = Username
    args["TwoFactorCode"] = TwoFactorCode
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("Core/ConfirmTwoFactorSetup", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* CreateRole - 
 * Name Description Optional
 * param Name string  False
 * param AsCommonRole bool  True
 * return ampapi.ActionResult[ampapi.UUID]
 */
func (a *Core) CreateRole(Name string, AsCommonRole bool) (ampapi.ActionResult[ampapi.UUID], error) {
    var args = make(map[string]any)
    args["Name"] = Name
    args["AsCommonRole"] = AsCommonRole
    var res ampapi.ActionResult[ampapi.UUID]
    bytes, err := a.ApiCall("Core/CreateRole", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* CreateTestTask - 
     * DEV: Creates a non-ending task with 50% progress for testing purposes
 * Name Description Optional
 * return any
 */
func (a *Core) CreateTestTask() (any, error) {
    var args = make(map[string]any)
    var res any
    bytes, err := a.ApiCall("Core/CreateTestTask", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* CreateUser - 
 * Name Description Optional
 * param Username string  False
 * return ampapi.ActionResult[ampapi.UUID]
 */
func (a *Core) CreateUser(Username string) (ampapi.ActionResult[ampapi.UUID], error) {
    var args = make(map[string]any)
    args["Username"] = Username
    var res ampapi.ActionResult[ampapi.UUID]
    bytes, err := a.ApiCall("Core/CreateUser", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* CurrentSessionHasPermission - 
 * Name Description Optional
 * param PermissionNode string  False
 * return bool
 */
func (a *Core) CurrentSessionHasPermission(PermissionNode string) (bool, error) {
    var args = make(map[string]any)
    args["PermissionNode"] = PermissionNode
    var res bool
    bytes, err := a.ApiCall("Core/CurrentSessionHasPermission", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* DeleteInstanceUsers - 
 * Name Description Optional
 * param InstanceId ampapi.UUID  False
 * return ampapi.ActionResult[any]
 */
func (a *Core) DeleteInstanceUsers(InstanceId ampapi.UUID) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["InstanceId"] = InstanceId
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("Core/DeleteInstanceUsers", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* DeleteRole - 
 * Name Description Optional
 * param RoleId ampapi.UUID  False
 * return ampapi.ActionResult[any]
 */
func (a *Core) DeleteRole(RoleId ampapi.UUID) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["RoleId"] = RoleId
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("Core/DeleteRole", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* DeleteTask - 
 * Name Description Optional
 * param TriggerID ampapi.UUID  False
 * param TaskID ampapi.UUID  False
 * return ampapi.ActionResult[any]
 */
func (a *Core) DeleteTask(TriggerID ampapi.UUID, TaskID ampapi.UUID) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["TriggerID"] = TriggerID
    args["TaskID"] = TaskID
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("Core/DeleteTask", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* DeleteTrigger - 
 * Name Description Optional
 * param TriggerID ampapi.UUID  False
 * return ampapi.ActionResult[any]
 */
func (a *Core) DeleteTrigger(TriggerID ampapi.UUID) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["TriggerID"] = TriggerID
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("Core/DeleteTrigger", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* DeleteUser - 
 * Name Description Optional
 * param Username string  False
 * return ampapi.ActionResult[any]
 */
func (a *Core) DeleteUser(Username string) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["Username"] = Username
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("Core/DeleteUser", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* DisableTwoFactor - 
 * Name Description Optional
 * param Password string  False
 * param TwoFactorCode string  False
 * return ampapi.ActionResult[any]
 */
func (a *Core) DisableTwoFactor(Password string, TwoFactorCode string) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["Password"] = Password
    args["TwoFactorCode"] = TwoFactorCode
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("Core/DisableTwoFactor", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* DismissAllTasks - 
 * Name Description Optional
 * return ampapi.ActionResult[any]
 */
func (a *Core) DismissAllTasks() (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("Core/DismissAllTasks", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* DismissTask - 
 * Name Description Optional
 * param TaskId ampapi.UUID  False
 * return ampapi.ActionResult[any]
 */
func (a *Core) DismissTask(TaskId ampapi.UUID) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["TaskId"] = TaskId
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("Core/DismissTask", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* EditIntervalTrigger - 
 * Name Description Optional
 * param Id ampapi.UUID  False
 * param months []int32  False
 * param days []int32  False
 * param hours []int32  False
 * param minutes []int32  False
 * param daysOfMonth []int32  False
 * param description string  False
 * return ampapi.ActionResult[any]
 */
func (a *Core) EditIntervalTrigger(Id ampapi.UUID, months []int32, days []int32, hours []int32, minutes []int32, daysOfMonth []int32, description string) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["Id"] = Id
    args["months"] = months
    args["days"] = days
    args["hours"] = hours
    args["minutes"] = minutes
    args["daysOfMonth"] = daysOfMonth
    args["description"] = description
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("Core/EditIntervalTrigger", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* EditTask - 
 * Name Description Optional
 * param TriggerID ampapi.UUID  False
 * param TaskID ampapi.UUID  False
 * param ParameterMapping map[string]string  False
 * return ampapi.ActionResult[any]
 */
func (a *Core) EditTask(TriggerID ampapi.UUID, TaskID ampapi.UUID, ParameterMapping map[string]string) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["TriggerID"] = TriggerID
    args["TaskID"] = TaskID
    args["ParameterMapping"] = ParameterMapping
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("Core/EditTask", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* EnableTwoFactor - 
 * Name Description Optional
 * param Username string  False
 * param Password string  False
 * return ampapi.ActionResult[any]
 */
func (a *Core) EnableTwoFactor(Username string, Password string) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["Username"] = Username
    args["Password"] = Password
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("Core/EnableTwoFactor", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* EndUserSession - 
 * Name Description Optional
 * param Id ampapi.UUID  False
 * return any
 */
func (a *Core) EndUserSession(Id ampapi.UUID) (any, error) {
    var args = make(map[string]any)
    args["Id"] = Id
    var res any
    bytes, err := a.ApiCall("Core/EndUserSession", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetAMPRolePermissions - 
 * Name Description Optional
 * param RoleId ampapi.UUID  False
 * return []string
 */
func (a *Core) GetAMPRolePermissions(RoleId ampapi.UUID) ([]string, error) {
    var args = make(map[string]any)
    args["RoleId"] = RoleId
    var res []string
    bytes, err := a.ApiCall("Core/GetAMPRolePermissions", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetAMPUserInfo - 
 * Name Description Optional
 * param Username string  False
 * return ampapi.UserInfo
 */
func (a *Core) GetAMPUserInfo(Username string) (ampapi.UserInfo, error) {
    var args = make(map[string]any)
    args["Username"] = Username
    var res ampapi.UserInfo
    bytes, err := a.ApiCall("Core/GetAMPUserInfo", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetAMPUsersSummary - 
 * Name Description Optional
 * return []any
 */
func (a *Core) GetAMPUsersSummary() ([]any, error) {
    var args = make(map[string]any)
    var res []any
    bytes, err := a.ApiCall("Core/GetAMPUsersSummary", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetAPISpec - 
 * Name Description Optional
 * return map[string]map[string]any
 */
func (a *Core) GetAPISpec() (map[string]map[string]any, error) {
    var args = make(map[string]any)
    var res map[string]map[string]any
    bytes, err := a.ApiCall("Core/GetAPISpec", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetActiveAMPSessions - 
 * Name Description Optional
 * return []any
 */
func (a *Core) GetActiveAMPSessions() ([]any, error) {
    var args = make(map[string]any)
    var res []any
    bytes, err := a.ApiCall("Core/GetActiveAMPSessions", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetAllAMPUserInfo - 
 * Name Description Optional
 * return []ampapi.UserInfo
 */
func (a *Core) GetAllAMPUserInfo() ([]ampapi.UserInfo, error) {
    var args = make(map[string]any)
    var res []ampapi.UserInfo
    bytes, err := a.ApiCall("Core/GetAllAMPUserInfo", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetAuditLogEntries - 
 * Name Description Optional
 * param Before any  False
 * param Count int32  False
 * return []any
 */
func (a *Core) GetAuditLogEntries(Before any, Count int32) ([]any, error) {
    var args = make(map[string]any)
    args["Before"] = Before
    args["Count"] = Count
    var res []any
    bytes, err := a.ApiCall("Core/GetAuditLogEntries", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetConfig - 
 * Name Description Optional
 * param node string  False
 * return map[string]any
 */
func (a *Core) GetConfig(node string) (map[string]any, error) {
    var args = make(map[string]any)
    args["node"] = node
    var res map[string]any
    bytes, err := a.ApiCall("Core/GetConfig", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetConfigs - 
 * Name Description Optional
 * param nodes []string  False
 * return []map[string]any
 */
func (a *Core) GetConfigs(nodes []string) ([]map[string]any, error) {
    var args = make(map[string]any)
    args["nodes"] = nodes
    var res []map[string]any
    bytes, err := a.ApiCall("Core/GetConfigs", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetDiagnosticsInfo - 
 * Name Description Optional
 * return map[string]string
 */
func (a *Core) GetDiagnosticsInfo() (map[string]string, error) {
    var args = make(map[string]any)
    var res map[string]string
    bytes, err := a.ApiCall("Core/GetDiagnosticsInfo", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetModuleInfo - 
 * Name Description Optional
 * return ampapi.ModuleInfo
 */
func (a *Core) GetModuleInfo() (ampapi.ModuleInfo, error) {
    var args = make(map[string]any)
    var res ampapi.ModuleInfo
    bytes, err := a.ApiCall("Core/GetModuleInfo", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetNewGuid - 
 * Name Description Optional
 * return ampapi.UUID
 */
func (a *Core) GetNewGuid() (ampapi.UUID, error) {
    var args = make(map[string]any)
    var res ampapi.UUID
    bytes, err := a.ApiCall("Core/GetNewGuid", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetPermissionsSpec - 
 * Name Description Optional
 * return []any
 */
func (a *Core) GetPermissionsSpec() ([]any, error) {
    var args = make(map[string]any)
    var res []any
    bytes, err := a.ApiCall("Core/GetPermissionsSpec", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetPortSummaries - 
 * Name Description Optional
 * return []any
 */
func (a *Core) GetPortSummaries() ([]any, error) {
    var args = make(map[string]any)
    var res []any
    bytes, err := a.ApiCall("Core/GetPortSummaries", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetProvisionSpec - 
 * Name Description Optional
 * return []map[string]any
 */
func (a *Core) GetProvisionSpec() ([]map[string]any, error) {
    var args = make(map[string]any)
    var res []map[string]any
    bytes, err := a.ApiCall("Core/GetProvisionSpec", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetRemoteLoginToken - 
 * Name Description Optional
 * param Description string  True
 * param IsTemporary bool  True
 * return string
 */
func (a *Core) GetRemoteLoginToken(Description string, IsTemporary bool) (string, error) {
    var args = make(map[string]any)
    args["Description"] = Description
    args["IsTemporary"] = IsTemporary
    var res string
    bytes, err := a.ApiCall("Core/GetRemoteLoginToken", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetRole - 
 * Name Description Optional
 * param RoleId ampapi.UUID  False
 * return any
 */
func (a *Core) GetRole(RoleId ampapi.UUID) (any, error) {
    var args = make(map[string]any)
    args["RoleId"] = RoleId
    var res any
    bytes, err := a.ApiCall("Core/GetRole", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetRoleData - 
 * Name Description Optional
 * return []any
 */
func (a *Core) GetRoleData() ([]any, error) {
    var args = make(map[string]any)
    var res []any
    bytes, err := a.ApiCall("Core/GetRoleData", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetRoleIds - 
 * Name Description Optional
 * return map[ampapi.UUID]string
 */
func (a *Core) GetRoleIds() (map[ampapi.UUID]string, error) {
    var args = make(map[string]any)
    var res map[ampapi.UUID]string
    bytes, err := a.ApiCall("Core/GetRoleIds", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetScheduleData - 
 * Name Description Optional
 * return any
 */
func (a *Core) GetScheduleData() (any, error) {
    var args = make(map[string]any)
    var res any
    bytes, err := a.ApiCall("Core/GetScheduleData", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetSettingValues - 
 * Name Description Optional
 * param SettingNode string  False
 * param WithRefresh bool  True
 * return map[string]string
 */
func (a *Core) GetSettingValues(SettingNode string, WithRefresh bool) (map[string]string, error) {
    var args = make(map[string]any)
    args["SettingNode"] = SettingNode
    args["WithRefresh"] = WithRefresh
    var res map[string]string
    bytes, err := a.ApiCall("Core/GetSettingValues", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetSettingsSpec - 
 * Name Description Optional
 * return map[string]ampapi.SettingSpec
 */
func (a *Core) GetSettingsSpec() (map[string]ampapi.SettingSpec, error) {
    var args = make(map[string]any)
    var res map[string]ampapi.SettingSpec
    bytes, err := a.ApiCall("Core/GetSettingsSpec", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetStatus - 
 * Name Description Optional
 * return ampapi.Status
 */
func (a *Core) GetStatus() (ampapi.Status, error) {
    var args = make(map[string]any)
    var res ampapi.Status
    bytes, err := a.ApiCall("Core/GetStatus", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetTasks - 
 * Name Description Optional
 * return []ampapi.RunningTask
 */
func (a *Core) GetTasks() ([]ampapi.RunningTask, error) {
    var args = make(map[string]any)
    var res []ampapi.RunningTask
    bytes, err := a.ApiCall("Core/GetTasks", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetTimeIntervalTrigger - 
 * Name Description Optional
 * param Id ampapi.UUID  False
 * return any
 */
func (a *Core) GetTimeIntervalTrigger(Id ampapi.UUID) (any, error) {
    var args = make(map[string]any)
    args["Id"] = Id
    var res any
    bytes, err := a.ApiCall("Core/GetTimeIntervalTrigger", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetUpdateInfo - 
 * Name Description Optional
 * return ampapi.UpdateInfo
 */
func (a *Core) GetUpdateInfo() (ampapi.UpdateInfo, error) {
    var args = make(map[string]any)
    var res ampapi.UpdateInfo
    bytes, err := a.ApiCall("Core/GetUpdateInfo", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetUpdates - 
     * Gets changes to the server status, in addition to any notifications or console output that have occured since the last time GetUpdates() was called by the current session.
 * Name Description Optional
 * return ampapi.Updates
 */
func (a *Core) GetUpdates() (ampapi.Updates, error) {
    var args = make(map[string]any)
    var res ampapi.Updates
    bytes, err := a.ApiCall("Core/GetUpdates", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetUserActionsSpec - 
 * Name Description Optional
 * return any
 */
func (a *Core) GetUserActionsSpec() (any, error) {
    var args = make(map[string]any)
    var res any
    bytes, err := a.ApiCall("Core/GetUserActionsSpec", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetUserInfo - 
 * Name Description Optional
 * param UID string  False
 * return any
 */
func (a *Core) GetUserInfo(UID string) (any, error) {
    var args = make(map[string]any)
    args["UID"] = UID
    var res any
    bytes, err := a.ApiCall("Core/GetUserInfo", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetUserList - 
     * Returns a list of in-application users
 * Name Description Optional
 * return map[string]string
 */
func (a *Core) GetUserList() (map[string]string, error) {
    var args = make(map[string]any)
    var res map[string]string
    bytes, err := a.ApiCall("Core/GetUserList", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetWebauthnChallenge - 
 * Name Description Optional
 * return ampapi.ActionResult[string]
 */
func (a *Core) GetWebauthnChallenge() (ampapi.ActionResult[string], error) {
    var args = make(map[string]any)
    var res ampapi.ActionResult[string]
    bytes, err := a.ApiCall("Core/GetWebauthnChallenge", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetWebauthnCredentialIDs - 
 * Name Description Optional
 * param username string  False
 * return any
 */
func (a *Core) GetWebauthnCredentialIDs(username string) (any, error) {
    var args = make(map[string]any)
    args["username"] = username
    var res any
    bytes, err := a.ApiCall("Core/GetWebauthnCredentialIDs", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetWebauthnCredentialSummaries - 
 * Name Description Optional
 * return []any
 */
func (a *Core) GetWebauthnCredentialSummaries() ([]any, error) {
    var args = make(map[string]any)
    var res []any
    bytes, err := a.ApiCall("Core/GetWebauthnCredentialSummaries", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetWebserverMetrics - 
 * Name Description Optional
 * return any
 */
func (a *Core) GetWebserverMetrics() (any, error) {
    var args = make(map[string]any)
    var res any
    bytes, err := a.ApiCall("Core/GetWebserverMetrics", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* Kill - 
 * Name Description Optional
 * return any
 */
func (a *Core) Kill() (any, error) {
    var args = make(map[string]any)
    var res any
    bytes, err := a.ApiCall("Core/Kill", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* Login - 
 * Name Description Optional
 * param username string  False
 * param password string  False
 * param token string  False
 * param rememberMe bool  False
 * return ampapi.LoginResult
 */
func (a *Core) Login(username string, password string, token string, rememberMe bool) (ampapi.LoginResult, error) {
    var args = make(map[string]any)
    args["username"] = username
    args["password"] = password
    args["token"] = token
    args["rememberMe"] = rememberMe
    var res ampapi.LoginResult
    bytes, err := a.ApiCall("Core/Login", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* Logout - 
 * Name Description Optional
 * return any
 */
func (a *Core) Logout() (any, error) {
    var args = make(map[string]any)
    var res any
    bytes, err := a.ApiCall("Core/Logout", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* RefreshSettingValueList - 
 * Name Description Optional
 * param Node string  False
 * return ampapi.ActionResult[any]
 */
func (a *Core) RefreshSettingValueList(Node string) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["Node"] = Node
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("Core/RefreshSettingValueList", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* RefreshSettingsSourceCache - 
 * Name Description Optional
 * return any
 */
func (a *Core) RefreshSettingsSourceCache() (any, error) {
    var args = make(map[string]any)
    var res any
    bytes, err := a.ApiCall("Core/RefreshSettingsSourceCache", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* RenameRole - 
 * Name Description Optional
 * param RoleId ampapi.UUID  False
 * param NewName string  False
 * return ampapi.ActionResult[any]
 */
func (a *Core) RenameRole(RoleId ampapi.UUID, NewName string) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["RoleId"] = RoleId
    args["NewName"] = NewName
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("Core/RenameRole", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* ResetUserPassword - 
 * Name Description Optional
 * param Username string  False
 * param NewPassword string  False
 * return ampapi.ActionResult[any]
 */
func (a *Core) ResetUserPassword(Username string, NewPassword string) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["Username"] = Username
    args["NewPassword"] = NewPassword
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("Core/ResetUserPassword", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* Restart - 
 * Name Description Optional
 * return ampapi.ActionResult[any]
 */
func (a *Core) Restart() (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("Core/Restart", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* RestartAMP - 
 * Name Description Optional
 * return any
 */
func (a *Core) RestartAMP() (any, error) {
    var args = make(map[string]any)
    var res any
    bytes, err := a.ApiCall("Core/RestartAMP", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* Resume - 
     * Allows the service to be re-started after previously being suspended.
 * Name Description Optional
 * return any
 */
func (a *Core) Resume() (any, error) {
    var args = make(map[string]any)
    var res any
    bytes, err := a.ApiCall("Core/Resume", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* RevokeWebauthnCredential - 
 * Name Description Optional
 * param ID int32  False
 * return ampapi.ActionResult[any]
 */
func (a *Core) RevokeWebauthnCredential(ID int32) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["ID"] = ID
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("Core/RevokeWebauthnCredential", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* RunEventTriggerImmediately - 
 * Name Description Optional
 * param triggerId ampapi.UUID  False
 * return ampapi.ActionResult[any]
 */
func (a *Core) RunEventTriggerImmediately(triggerId ampapi.UUID) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["triggerId"] = triggerId
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("Core/RunEventTriggerImmediately", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* SendConsoleMessage - 
 * Name Description Optional
 * param message string  False
 * return any
 */
func (a *Core) SendConsoleMessage(message string) (any, error) {
    var args = make(map[string]any)
    args["message"] = message
    var res any
    bytes, err := a.ApiCall("Core/SendConsoleMessage", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* SetAMPRolePermission - 
 * Name Description Optional
 * param RoleId ampapi.UUID  False
 * param PermissionNode string  False
 * param Enabled bool  False
 * return ampapi.ActionResult[any]
 */
func (a *Core) SetAMPRolePermission(RoleId ampapi.UUID, PermissionNode string, Enabled bool) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["RoleId"] = RoleId
    args["PermissionNode"] = PermissionNode
    args["Enabled"] = Enabled
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("Core/SetAMPRolePermission", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* SetAMPUserRoleMembership - 
 * Name Description Optional
 * param UserId ampapi.UUID  False
 * param RoleId ampapi.UUID  False
 * param IsMember bool  False
 * return ampapi.ActionResult[any]
 */
func (a *Core) SetAMPUserRoleMembership(UserId ampapi.UUID, RoleId ampapi.UUID, IsMember bool) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["UserId"] = UserId
    args["RoleId"] = RoleId
    args["IsMember"] = IsMember
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("Core/SetAMPUserRoleMembership", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* SetConfig - 
 * Name Description Optional
 * param node string  False
 * param value string  False
 * return ampapi.ActionResult[any]
 */
func (a *Core) SetConfig(node string, value string) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["node"] = node
    args["value"] = value
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("Core/SetConfig", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* SetConfigs - 
 * Name Description Optional
 * param data map[string]string  False
 * return bool
 */
func (a *Core) SetConfigs(data map[string]string) (bool, error) {
    var args = make(map[string]any)
    args["data"] = data
    var res bool
    bytes, err := a.ApiCall("Core/SetConfigs", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* SetTriggerEnabled - 
 * Name Description Optional
 * param Id ampapi.UUID  False
 * param Enabled bool  False
 * return ampapi.ActionResult[any]
 */
func (a *Core) SetTriggerEnabled(Id ampapi.UUID, Enabled bool) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["Id"] = Id
    args["Enabled"] = Enabled
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("Core/SetTriggerEnabled", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* Sleep - 
 * Name Description Optional
 * return ampapi.ActionResult[any]
 */
func (a *Core) Sleep() (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("Core/Sleep", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* Start - 
 * Name Description Optional
 * return ampapi.ActionResult[any]
 */
func (a *Core) Start() (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("Core/Start", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* Stop - 
 * Name Description Optional
 * return any
 */
func (a *Core) Stop() (any, error) {
    var args = make(map[string]any)
    var res any
    bytes, err := a.ApiCall("Core/Stop", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* Suspend - 
     * Prevents the current instance from being started, and stops it if it's currently running.
 * Name Description Optional
 * return any
 */
func (a *Core) Suspend() (any, error) {
    var args = make(map[string]any)
    var res any
    bytes, err := a.ApiCall("Core/Suspend", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* UpdateAMPInstance - 
 * Name Description Optional
 * return any
 */
func (a *Core) UpdateAMPInstance() (any, error) {
    var args = make(map[string]any)
    var res any
    bytes, err := a.ApiCall("Core/UpdateAMPInstance", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* UpdateAccountInfo - 
 * Name Description Optional
 * param EmailAddress string  False
 * param TwoFactorPIN string  False
 * return ampapi.ActionResult[any]
 */
func (a *Core) UpdateAccountInfo(EmailAddress string, TwoFactorPIN string) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["EmailAddress"] = EmailAddress
    args["TwoFactorPIN"] = TwoFactorPIN
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("Core/UpdateAccountInfo", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* UpdateApplication - 
 * Name Description Optional
 * return ampapi.ActionResult[any]
 */
func (a *Core) UpdateApplication() (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("Core/UpdateApplication", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* UpdateUserInfo - 
 * Name Description Optional
 * param Username string  False
 * param Disabled bool  False
 * param PasswordExpires bool  False
 * param CannotChangePassword bool  False
 * param MustChangePassword bool  False
 * param EmailAddress string  True
 * return ampapi.ActionResult[any]
 */
func (a *Core) UpdateUserInfo(Username string, Disabled bool, PasswordExpires bool, CannotChangePassword bool, MustChangePassword bool, EmailAddress string) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["Username"] = Username
    args["Disabled"] = Disabled
    args["PasswordExpires"] = PasswordExpires
    args["CannotChangePassword"] = CannotChangePassword
    args["MustChangePassword"] = MustChangePassword
    args["EmailAddress"] = EmailAddress
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("Core/UpdateUserInfo", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* UpgradeAMP - 
 * Name Description Optional
 * return any
 */
func (a *Core) UpgradeAMP() (any, error) {
    var args = make(map[string]any)
    var res any
    bytes, err := a.ApiCall("Core/UpgradeAMP", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* WebauthnRegister - 
 * Name Description Optional
 * param attestationObject string  False
 * param clientDataJSON string  False
 * param description string  True
 * return ampapi.ActionResult[any]
 */
func (a *Core) WebauthnRegister(attestationObject string, clientDataJSON string, description string) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["attestationObject"] = attestationObject
    args["clientDataJSON"] = clientDataJSON
    args["description"] = description
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("Core/WebauthnRegister", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

