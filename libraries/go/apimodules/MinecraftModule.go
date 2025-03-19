package apimodules

// A Go library for the AMP API
// Author: p0t4t0sandich

import (
	"encoding/json"

	"github.com/p0t4t0sandwich/ampapi-go"
)

// struct MinecraftModule
type MinecraftModule struct {
    *ampapi.AMPAPI
}

// Function NewMinecraftModule
// Creates a new MinecraftModule object
func NewMinecraftModule(api *ampapi.AMPAPI) *MinecraftModule {
	return &MinecraftModule{api}
}

/* AcceptEULA - 
 * Name Description Optional
 * return bool
 */
func (a *MinecraftModule) AcceptEULA() (bool, error) {
    var args = make(map[string]any)
    var res bool
    bytes, err := a.ApiCall("MinecraftModule/AcceptEULA", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* AddOPEntry - 
 * Name Description Optional
 * param UserOrUUID string  False
 * return ampapi.ActionResult[any]
 */
func (a *MinecraftModule) AddOPEntry(UserOrUUID string) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["UserOrUUID"] = UserOrUUID
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("MinecraftModule/AddOPEntry", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* AddToWhitelist - 
 * Name Description Optional
 * param UserOrUUID string  False
 * return ampapi.ActionResult[any]
 */
func (a *MinecraftModule) AddToWhitelist(UserOrUUID string) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["UserOrUUID"] = UserOrUUID
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("MinecraftModule/AddToWhitelist", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* BanUserByID - 
 * Name Description Optional
 * param ID string  False
 * return any
 */
func (a *MinecraftModule) BanUserByID(ID string) (any, error) {
    var args = make(map[string]any)
    args["ID"] = ID
    var res any
    bytes, err := a.ApiCall("MinecraftModule/BanUserByID", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* BukGetCategories - 
 * Name Description Optional
 * return map[string]any
 */
func (a *MinecraftModule) BukGetCategories() (map[string]any, error) {
    var args = make(map[string]any)
    var res map[string]any
    bytes, err := a.ApiCall("MinecraftModule/BukGetCategories", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* BukGetInstallUpdatePlugin - 
 * Name Description Optional
 * param pluginId int32  False
 * return ampapi.RunningTask
 */
func (a *MinecraftModule) BukGetInstallUpdatePlugin(pluginId int32) (ampapi.RunningTask, error) {
    var args = make(map[string]any)
    args["pluginId"] = pluginId
    var res ampapi.RunningTask
    bytes, err := a.ApiCall("MinecraftModule/BukGetInstallUpdatePlugin", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* BukGetInstalledPlugins - 
 * Name Description Optional
 * return map[string]any
 */
func (a *MinecraftModule) BukGetInstalledPlugins() (map[string]any, error) {
    var args = make(map[string]any)
    var res map[string]any
    bytes, err := a.ApiCall("MinecraftModule/BukGetInstalledPlugins", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* BukGetPluginInfo - 
 * Name Description Optional
 * param PluginId int32  False
 * return map[string]any
 */
func (a *MinecraftModule) BukGetPluginInfo(PluginId int32) (map[string]any, error) {
    var args = make(map[string]any)
    args["PluginId"] = PluginId
    var res map[string]any
    bytes, err := a.ApiCall("MinecraftModule/BukGetPluginInfo", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* BukGetPluginsForCategory - 
 * Name Description Optional
 * param CategoryId string  False
 * param PageNumber int32  False
 * param PageSize int32  False
 * return map[string]any
 */
func (a *MinecraftModule) BukGetPluginsForCategory(CategoryId string, PageNumber int32, PageSize int32) (map[string]any, error) {
    var args = make(map[string]any)
    args["CategoryId"] = CategoryId
    args["PageNumber"] = PageNumber
    args["PageSize"] = PageSize
    var res map[string]any
    bytes, err := a.ApiCall("MinecraftModule/BukGetPluginsForCategory", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* BukGetPopularPlugins - 
 * Name Description Optional
 * return map[string]any
 */
func (a *MinecraftModule) BukGetPopularPlugins() (map[string]any, error) {
    var args = make(map[string]any)
    var res map[string]any
    bytes, err := a.ApiCall("MinecraftModule/BukGetPopularPlugins", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* BukGetRemovePlugin - 
 * Name Description Optional
 * param PluginId int32  False
 * return any
 */
func (a *MinecraftModule) BukGetRemovePlugin(PluginId int32) (any, error) {
    var args = make(map[string]any)
    args["PluginId"] = PluginId
    var res any
    bytes, err := a.ApiCall("MinecraftModule/BukGetRemovePlugin", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* BukGetSearch - 
 * Name Description Optional
 * param Query string  False
 * param PageNumber int32  False
 * param PageSize int32  False
 * return map[string]any
 */
func (a *MinecraftModule) BukGetSearch(Query string, PageNumber int32, PageSize int32) (map[string]any, error) {
    var args = make(map[string]any)
    args["Query"] = Query
    args["PageNumber"] = PageNumber
    args["PageSize"] = PageSize
    var res map[string]any
    bytes, err := a.ApiCall("MinecraftModule/BukGetSearch", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* ClearInventoryByID - 
 * Name Description Optional
 * param ID string  False
 * return any
 */
func (a *MinecraftModule) ClearInventoryByID(ID string) (any, error) {
    var args = make(map[string]any)
    args["ID"] = ID
    var res any
    bytes, err := a.ApiCall("MinecraftModule/ClearInventoryByID", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetFailureReason - 
 * Name Description Optional
 * return string
 */
func (a *MinecraftModule) GetFailureReason() (string, error) {
    var args = make(map[string]any)
    var res string
    bytes, err := a.ApiCall("MinecraftModule/GetFailureReason", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetHeadByUUID - 
 * Name Description Optional
 * param id string  False
 * return string
 */
func (a *MinecraftModule) GetHeadByUUID(id string) (string, error) {
    var args = make(map[string]any)
    args["id"] = id
    var res string
    bytes, err := a.ApiCall("MinecraftModule/GetHeadByUUID", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetOPWhitelist - 
 * Name Description Optional
 * return map[string]any
 */
func (a *MinecraftModule) GetOPWhitelist() (map[string]any, error) {
    var args = make(map[string]any)
    var res map[string]any
    bytes, err := a.ApiCall("MinecraftModule/GetOPWhitelist", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetWhitelist - 
 * Name Description Optional
 * return []map[string]any
 */
func (a *MinecraftModule) GetWhitelist() ([]map[string]any, error) {
    var args = make(map[string]any)
    var res []map[string]any
    bytes, err := a.ApiCall("MinecraftModule/GetWhitelist", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* KickUserByID - 
 * Name Description Optional
 * param ID string  False
 * return any
 */
func (a *MinecraftModule) KickUserByID(ID string) (any, error) {
    var args = make(map[string]any)
    args["ID"] = ID
    var res any
    bytes, err := a.ApiCall("MinecraftModule/KickUserByID", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* KillByID - 
 * Name Description Optional
 * param ID string  False
 * return any
 */
func (a *MinecraftModule) KillByID(ID string) (any, error) {
    var args = make(map[string]any)
    args["ID"] = ID
    var res any
    bytes, err := a.ApiCall("MinecraftModule/KillByID", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* LoadOPList - 
 * Name Description Optional
 * return []map[string]any
 */
func (a *MinecraftModule) LoadOPList() ([]map[string]any, error) {
    var args = make(map[string]any)
    var res []map[string]any
    bytes, err := a.ApiCall("MinecraftModule/LoadOPList", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* RemoveOPEntry - 
 * Name Description Optional
 * param UserOrUUID string  False
 * return any
 */
func (a *MinecraftModule) RemoveOPEntry(UserOrUUID string) (any, error) {
    var args = make(map[string]any)
    args["UserOrUUID"] = UserOrUUID
    var res any
    bytes, err := a.ApiCall("MinecraftModule/RemoveOPEntry", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* RemoveWhitelistEntry - 
 * Name Description Optional
 * param UserOrUUID string  False
 * return any
 */
func (a *MinecraftModule) RemoveWhitelistEntry(UserOrUUID string) (any, error) {
    var args = make(map[string]any)
    args["UserOrUUID"] = UserOrUUID
    var res any
    bytes, err := a.ApiCall("MinecraftModule/RemoveWhitelistEntry", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* SmiteByID - 
 * Name Description Optional
 * param ID string  False
 * return any
 */
func (a *MinecraftModule) SmiteByID(ID string) (any, error) {
    var args = make(map[string]any)
    args["ID"] = ID
    var res any
    bytes, err := a.ApiCall("MinecraftModule/SmiteByID", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

