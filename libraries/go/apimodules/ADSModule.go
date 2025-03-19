package apimodules

// A Go library for the AMP API
// Author: p0t4t0sandich

import (
	"encoding/json"

	"github.com/p0t4t0sandwich/ampapi-go"
)

// struct ADSModule
type ADSModule struct {
    *ampapi.AMPAPI
}

// Function NewADSModule
// Creates a new ADSModule object
func NewADSModule(api *ampapi.AMPAPI) *ADSModule {
	return &ADSModule{api}
}

/* AddDatastore - 
 * Name Description Optional
 * param newDatastore ampapi.InstanceDatastore  False
 * return ampapi.ActionResult[any]
 */
func (a *ADSModule) AddDatastore(newDatastore ampapi.InstanceDatastore) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["newDatastore"] = newDatastore
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("ADSModule/AddDatastore", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* ApplyInstanceConfiguration - 
 * Name Description Optional
 * param InstanceID ampapi.UUID  False
 * param Args map[string]string  False
 * param RebuildConfiguration bool  True
 * return ampapi.ActionResult[any]
 */
func (a *ADSModule) ApplyInstanceConfiguration(InstanceID ampapi.UUID, Args map[string]string, RebuildConfiguration bool) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["InstanceID"] = InstanceID
    args["Args"] = Args
    args["RebuildConfiguration"] = RebuildConfiguration
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("ADSModule/ApplyInstanceConfiguration", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* ApplyTemplate - 
 * Name Description Optional
 * param InstanceID ampapi.UUID  False
 * param TemplateID int32  False
 * param NewFriendlyName string  True
 * param Secret string  True
 * param RestartIfPreviouslyRunning bool  True
 * return ampapi.ActionResult[any]
 */
func (a *ADSModule) ApplyTemplate(InstanceID ampapi.UUID, TemplateID int32, NewFriendlyName string, Secret string, RestartIfPreviouslyRunning bool) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["InstanceID"] = InstanceID
    args["TemplateID"] = TemplateID
    args["NewFriendlyName"] = NewFriendlyName
    args["Secret"] = Secret
    args["RestartIfPreviouslyRunning"] = RestartIfPreviouslyRunning
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("ADSModule/ApplyTemplate", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* AttachADS - 
 * Name Description Optional
 * param Friendly string  False
 * param IsHTTPS bool  False
 * param Host string  False
 * param Port int32  False
 * param InstanceID ampapi.UUID  False
 * return ampapi.ActionResult[any]
 */
func (a *ADSModule) AttachADS(Friendly string, IsHTTPS bool, Host string, Port int32, InstanceID ampapi.UUID) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["Friendly"] = Friendly
    args["IsHTTPS"] = IsHTTPS
    args["Host"] = Host
    args["Port"] = Port
    args["InstanceID"] = InstanceID
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("ADSModule/AttachADS", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* CloneTemplate - 
 * Name Description Optional
 * param Id int32  False
 * param NewName string  False
 * return ampapi.ActionResult[any]
 */
func (a *ADSModule) CloneTemplate(Id int32, NewName string) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["Id"] = Id
    args["NewName"] = NewName
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("ADSModule/CloneTemplate", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* ConvertToManaged - 
 * Name Description Optional
 * param InstanceName string  False
 * return ampapi.ActionResult[any]
 */
func (a *ADSModule) ConvertToManaged(InstanceName string) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["InstanceName"] = InstanceName
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("ADSModule/ConvertToManaged", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* CreateDeploymentTemplate - 
 * Name Description Optional
 * param Name string  False
 * return ampapi.ActionResult[any]
 */
func (a *ADSModule) CreateDeploymentTemplate(Name string) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["Name"] = Name
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("ADSModule/CreateDeploymentTemplate", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* CreateInstance - 
 * Name Description Optional
 * param TargetADSInstance ampapi.UUID  False
 * param NewInstanceId ampapi.UUID  False
 * param Module string  False
 * param InstanceName string  False
 * param FriendlyName string  False
 * param IPBinding string  False
 * param PortNumber int32  False
 * param AdminUsername string  False
 * param AdminPassword string  False
 * param ProvisionSettings map[string]string  False
 * param AutoConfigure bool When enabled, all settings other than the Module, Target and FriendlyName are ignored and replaced with automatically generated values. True
 * param PostCreate any  True
 * param StartOnBoot bool  True
 * param DisplayImageSource string  True
 * param TargetDatastore int32  True
 * return ampapi.ActionResult[any]
 */
func (a *ADSModule) CreateInstance(TargetADSInstance ampapi.UUID, NewInstanceId ampapi.UUID, Module string, InstanceName string, FriendlyName string, IPBinding string, PortNumber int32, AdminUsername string, AdminPassword string, ProvisionSettings map[string]string, AutoConfigure bool, PostCreate any, StartOnBoot bool, DisplayImageSource string, TargetDatastore int32) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["TargetADSInstance"] = TargetADSInstance
    args["NewInstanceId"] = NewInstanceId
    args["Module"] = Module
    args["InstanceName"] = InstanceName
    args["FriendlyName"] = FriendlyName
    args["IPBinding"] = IPBinding
    args["PortNumber"] = PortNumber
    args["AdminUsername"] = AdminUsername
    args["AdminPassword"] = AdminPassword
    args["ProvisionSettings"] = ProvisionSettings
    args["AutoConfigure"] = AutoConfigure
    args["PostCreate"] = PostCreate
    args["StartOnBoot"] = StartOnBoot
    args["DisplayImageSource"] = DisplayImageSource
    args["TargetDatastore"] = TargetDatastore
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("ADSModule/CreateInstance", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* CreateLocalInstance - 
 * Name Description Optional
 * param Instance any  False
 * param PostCreate any  True
 * return ampapi.ActionResult[any]
 */
func (a *ADSModule) CreateLocalInstance(Instance any, PostCreate any) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["Instance"] = Instance
    args["PostCreate"] = PostCreate
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("ADSModule/CreateLocalInstance", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* DeleteDatastore - 
 * Name Description Optional
 * param id int32  False
 * return ampapi.ActionResult[any]
 */
func (a *ADSModule) DeleteDatastore(id int32) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["id"] = id
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("ADSModule/DeleteDatastore", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* DeleteDeploymentTemplate - 
 * Name Description Optional
 * param Id int32  False
 * return ampapi.ActionResult[any]
 */
func (a *ADSModule) DeleteDeploymentTemplate(Id int32) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["Id"] = Id
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("ADSModule/DeleteDeploymentTemplate", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* DeleteInstance - 
 * Name Description Optional
 * param InstanceName string  False
 * return ampapi.RunningTask
 */
func (a *ADSModule) DeleteInstance(InstanceName string) (ampapi.RunningTask, error) {
    var args = make(map[string]any)
    args["InstanceName"] = InstanceName
    var res ampapi.RunningTask
    bytes, err := a.ApiCall("ADSModule/DeleteInstance", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* DeleteInstanceUsers - 
 * Name Description Optional
 * param InstanceId ampapi.UUID  False
 * return ampapi.ActionResult[any]
 */
func (a *ADSModule) DeleteInstanceUsers(InstanceId ampapi.UUID) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["InstanceId"] = InstanceId
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("ADSModule/DeleteInstanceUsers", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* DeployTemplate - A dictionary of setting nodes and values to create the new instance with. Identical in function to the provisioning arguments in the template itself.
 * Name Description Optional
 * param TemplateID int32 The ID of the template to be deployed, as per the Template Management UI in AMP itself. False
 * param NewUsername string If specified, AMP will create a new user with this name for this instance. Must be unique. If this user already exists, this will be ignored but the new instance will be assigned to this user. True
 * param NewPassword string If 'NewUsername' is specified and the user doesn't already exist, the password that will be assigned to this user. True
 * param NewEmail string If 'NewUsername' is specified and the user doesn't already exist, the email address that will be assigned to this user. True
 * param RequiredTags []string If specified, AMP will only deploy this template to targets that have every single 'tag' specified in their target configuration. You can adjust this via the controller by clicking 'Edit' on the target settings. True
 * param Tag string Unrelated to RequiredTags. This is to uniquely identify this instance to your own systems. It may be something like an order ID or service ID so you can find the associated instance again at a later time. If 'UseTagAsInstanceName' is enabled, then this will also be used as the instance name for the created instance - but it must be unique. True
 * param FriendlyName string A friendly name for this instance. If left blank, AMP will generate one for you. True
 * param Secret string Must be a non-empty strong in order to get a callback on deployment state change. This secret will be passed back to you in the callback so you can verify the request. True
 * param PostCreate any 0: Do nothing, 1: Start instance only, 2: Start instance and update application, 3: Full application startup. True
 * param ExtraProvisionSettings map[string]string A dictionary of setting nodes and values to create the new instance with. Identical in function to the provisioning arguments in the template itself. True
 * return ampapi.RunningTask
 */
func (a *ADSModule) DeployTemplate(TemplateID int32, NewUsername string, NewPassword string, NewEmail string, RequiredTags []string, Tag string, FriendlyName string, Secret string, PostCreate any, ExtraProvisionSettings map[string]string) (ampapi.RunningTask, error) {
    var args = make(map[string]any)
    args["TemplateID"] = TemplateID
    args["NewUsername"] = NewUsername
    args["NewPassword"] = NewPassword
    args["NewEmail"] = NewEmail
    args["RequiredTags"] = RequiredTags
    args["Tag"] = Tag
    args["FriendlyName"] = FriendlyName
    args["Secret"] = Secret
    args["PostCreate"] = PostCreate
    args["ExtraProvisionSettings"] = ExtraProvisionSettings
    var res ampapi.RunningTask
    bytes, err := a.ApiCall("ADSModule/DeployTemplate", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* DetatchTarget - 
 * Name Description Optional
 * param Id ampapi.UUID  False
 * return ampapi.ActionResult[any]
 */
func (a *ADSModule) DetatchTarget(Id ampapi.UUID) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["Id"] = Id
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("ADSModule/DetatchTarget", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* ExtractEverywhere - 
 * Name Description Optional
 * param SourceArchive string  False
 * return ampapi.ActionResult[any]
 */
func (a *ADSModule) ExtractEverywhere(SourceArchive string) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["SourceArchive"] = SourceArchive
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("ADSModule/ExtractEverywhere", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetApplicationEndpoints - 
 * Name Description Optional
 * param instanceId ampapi.UUID  False
 * return []ampapi.EndpointInfo
 */
func (a *ADSModule) GetApplicationEndpoints(instanceId ampapi.UUID) ([]ampapi.EndpointInfo, error) {
    var args = make(map[string]any)
    args["instanceId"] = instanceId
    var res []ampapi.EndpointInfo
    bytes, err := a.ApiCall("ADSModule/GetApplicationEndpoints", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetDatastore - 
 * Name Description Optional
 * param id int32  False
 * return ampapi.InstanceDatastore
 */
func (a *ADSModule) GetDatastore(id int32) (ampapi.InstanceDatastore, error) {
    var args = make(map[string]any)
    args["id"] = id
    var res ampapi.InstanceDatastore
    bytes, err := a.ApiCall("ADSModule/GetDatastore", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetDatastoreInstances - 
 * Name Description Optional
 * param datastoreId int32  False
 * return []map[string]any
 */
func (a *ADSModule) GetDatastoreInstances(datastoreId int32) ([]map[string]any, error) {
    var args = make(map[string]any)
    args["datastoreId"] = datastoreId
    var res []map[string]any
    bytes, err := a.ApiCall("ADSModule/GetDatastoreInstances", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetDatastores - 
 * Name Description Optional
 * return []ampapi.InstanceDatastore
 */
func (a *ADSModule) GetDatastores() ([]ampapi.InstanceDatastore, error) {
    var args = make(map[string]any)
    var res []ampapi.InstanceDatastore
    bytes, err := a.ApiCall("ADSModule/GetDatastores", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetDeploymentTemplates - 
 * Name Description Optional
 * return []any
 */
func (a *ADSModule) GetDeploymentTemplates() ([]any, error) {
    var args = make(map[string]any)
    var res []any
    bytes, err := a.ApiCall("ADSModule/GetDeploymentTemplates", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetGroup - 
 * Name Description Optional
 * param GroupId ampapi.UUID  False
 * return ampapi.IADSInstance
 */
func (a *ADSModule) GetGroup(GroupId ampapi.UUID) (ampapi.IADSInstance, error) {
    var args = make(map[string]any)
    args["GroupId"] = GroupId
    var res ampapi.IADSInstance
    bytes, err := a.ApiCall("ADSModule/GetGroup", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetInstance - 
 * Name Description Optional
 * param InstanceId ampapi.UUID  False
 * return ampapi.Instance
 */
func (a *ADSModule) GetInstance(InstanceId ampapi.UUID) (ampapi.Instance, error) {
    var args = make(map[string]any)
    args["InstanceId"] = InstanceId
    var res ampapi.Instance
    bytes, err := a.ApiCall("ADSModule/GetInstance", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetInstanceNetworkInfo - 
 * Name Description Optional
 * param InstanceName string  False
 * return []any
 */
func (a *ADSModule) GetInstanceNetworkInfo(InstanceName string) ([]any, error) {
    var args = make(map[string]any)
    args["InstanceName"] = InstanceName
    var res []any
    bytes, err := a.ApiCall("ADSModule/GetInstanceNetworkInfo", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetInstanceStatuses - 
 * Name Description Optional
 * return []ampapi.InstanceStatus
 */
func (a *ADSModule) GetInstanceStatuses() ([]ampapi.InstanceStatus, error) {
    var args = make(map[string]any)
    var res []ampapi.InstanceStatus
    bytes, err := a.ApiCall("ADSModule/GetInstanceStatuses", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetInstances - 
 * Name Description Optional
 * return []ampapi.IADSInstance
 */
func (a *ADSModule) GetInstances() ([]ampapi.IADSInstance, error) {
    var args = make(map[string]any)
    var res []ampapi.IADSInstance
    bytes, err := a.ApiCall("ADSModule/GetInstances", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetLocalInstances - 
 * Name Description Optional
 * return []map[string]any
 */
func (a *ADSModule) GetLocalInstances() ([]map[string]any, error) {
    var args = make(map[string]any)
    var res []map[string]any
    bytes, err := a.ApiCall("ADSModule/GetLocalInstances", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetProvisionArguments - 
 * Name Description Optional
 * param ModuleName string  False
 * return []map[string]any
 */
func (a *ADSModule) GetProvisionArguments(ModuleName string) ([]map[string]any, error) {
    var args = make(map[string]any)
    args["ModuleName"] = ModuleName
    var res []map[string]any
    bytes, err := a.ApiCall("ADSModule/GetProvisionArguments", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetProvisionFitness - 
 * Name Description Optional
 * return map[string]any
 */
func (a *ADSModule) GetProvisionFitness() (map[string]any, error) {
    var args = make(map[string]any)
    var res map[string]any
    bytes, err := a.ApiCall("ADSModule/GetProvisionFitness", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetSupportedApplications - 
 * Name Description Optional
 * return []any
 */
func (a *ADSModule) GetSupportedApplications() ([]any, error) {
    var args = make(map[string]any)
    var res []any
    bytes, err := a.ApiCall("ADSModule/GetSupportedApplications", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* GetTargetInfo - 
 * Name Description Optional
 * return ampapi.RemoteTargetInfo
 */
func (a *ADSModule) GetTargetInfo() (ampapi.RemoteTargetInfo, error) {
    var args = make(map[string]any)
    var res ampapi.RemoteTargetInfo
    bytes, err := a.ApiCall("ADSModule/GetTargetInfo", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* HandoutInstanceConfigs - 
 * Name Description Optional
 * param ForModule string  False
 * param SettingNode string  False
 * param Values []string  False
 * return ampapi.ActionResult[any]
 */
func (a *ADSModule) HandoutInstanceConfigs(ForModule string, SettingNode string, Values []string) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["ForModule"] = ForModule
    args["SettingNode"] = SettingNode
    args["Values"] = Values
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("ADSModule/HandoutInstanceConfigs", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* ManageInstance - 
 * Name Description Optional
 * param InstanceId ampapi.UUID  False
 * return ampapi.ActionResult[string]
 */
func (a *ADSModule) ManageInstance(InstanceId ampapi.UUID) (ampapi.ActionResult[string], error) {
    var args = make(map[string]any)
    args["InstanceId"] = InstanceId
    var res ampapi.ActionResult[string]
    bytes, err := a.ApiCall("ADSModule/ManageInstance", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* ModifyCustomFirewallRule - 
 * Name Description Optional
 * param instanceId ampapi.UUID  False
 * param PortNumber int32  False
 * param Range int32  False
 * param Protocol any  False
 * param Description string  False
 * param Open bool  False
 * return ampapi.ActionResult[any]
 */
func (a *ADSModule) ModifyCustomFirewallRule(instanceId ampapi.UUID, PortNumber int32, Range int32, Protocol any, Description string, Open bool) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["instanceId"] = instanceId
    args["PortNumber"] = PortNumber
    args["Range"] = Range
    args["Protocol"] = Protocol
    args["Description"] = Description
    args["Open"] = Open
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("ADSModule/ModifyCustomFirewallRule", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* MoveInstanceDatastore - 
 * Name Description Optional
 * param instanceId ampapi.UUID  False
 * param datastoreId int32  False
 * return ampapi.RunningTask
 */
func (a *ADSModule) MoveInstanceDatastore(instanceId ampapi.UUID, datastoreId int32) (ampapi.RunningTask, error) {
    var args = make(map[string]any)
    args["instanceId"] = instanceId
    args["datastoreId"] = datastoreId
    var res ampapi.RunningTask
    bytes, err := a.ApiCall("ADSModule/MoveInstanceDatastore", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* ReactivateLocalInstances - 
 * Name Description Optional
 * return ampapi.RunningTask
 */
func (a *ADSModule) ReactivateLocalInstances() (ampapi.RunningTask, error) {
    var args = make(map[string]any)
    var res ampapi.RunningTask
    bytes, err := a.ApiCall("ADSModule/ReactivateLocalInstances", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* RefreshAppCache - 
 * Name Description Optional
 * return any
 */
func (a *ADSModule) RefreshAppCache() (any, error) {
    var args = make(map[string]any)
    var res any
    bytes, err := a.ApiCall("ADSModule/RefreshAppCache", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* RefreshGroup - 
 * Name Description Optional
 * param GroupId ampapi.UUID  False
 * return ampapi.ActionResult[any]
 */
func (a *ADSModule) RefreshGroup(GroupId ampapi.UUID) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["GroupId"] = GroupId
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("ADSModule/RefreshGroup", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* RefreshInstanceConfig - 
 * Name Description Optional
 * param InstanceId string  False
 * return ampapi.ActionResult[any]
 */
func (a *ADSModule) RefreshInstanceConfig(InstanceId string) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["InstanceId"] = InstanceId
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("ADSModule/RefreshInstanceConfig", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* RefreshRemoteConfigStores - 
 * Name Description Optional
 * param force bool  True
 * return any
 */
func (a *ADSModule) RefreshRemoteConfigStores(force bool) (any, error) {
    var args = make(map[string]any)
    args["force"] = force
    var res any
    bytes, err := a.ApiCall("ADSModule/RefreshRemoteConfigStores", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* RegisterTarget - 
 * Name Description Optional
 * param controllerUrl string  False
 * param myUrl string  False
 * param username string  False
 * param password string  False
 * param twoFactorToken string  False
 * param friendlyName string  False
 * return ampapi.ActionResult[any]
 */
func (a *ADSModule) RegisterTarget(controllerUrl string, myUrl string, username string, password string, twoFactorToken string, friendlyName string) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["controllerUrl"] = controllerUrl
    args["myUrl"] = myUrl
    args["username"] = username
    args["password"] = password
    args["twoFactorToken"] = twoFactorToken
    args["friendlyName"] = friendlyName
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("ADSModule/RegisterTarget", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* RepairDatastore - 
 * Name Description Optional
 * param id int32  False
 * return ampapi.RunningTask
 */
func (a *ADSModule) RepairDatastore(id int32) (ampapi.RunningTask, error) {
    var args = make(map[string]any)
    args["id"] = id
    var res ampapi.RunningTask
    bytes, err := a.ApiCall("ADSModule/RepairDatastore", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* RequestDatastoreSizeCalculation - 
 * Name Description Optional
 * param datastoreId int32  False
 * return ampapi.RunningTask
 */
func (a *ADSModule) RequestDatastoreSizeCalculation(datastoreId int32) (ampapi.RunningTask, error) {
    var args = make(map[string]any)
    args["datastoreId"] = datastoreId
    var res ampapi.RunningTask
    bytes, err := a.ApiCall("ADSModule/RequestDatastoreSizeCalculation", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* RestartInstance - 
 * Name Description Optional
 * param InstanceName string  False
 * return ampapi.ActionResult[any]
 */
func (a *ADSModule) RestartInstance(InstanceName string) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["InstanceName"] = InstanceName
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("ADSModule/RestartInstance", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* Servers - 
 * Name Description Optional
 * param id string  False
 * param REQ_RAWJSON string  False
 * return map[string]any
 */
func (a *ADSModule) Servers(id string, REQ_RAWJSON string) (map[string]any, error) {
    var args = make(map[string]any)
    args["id"] = id
    args["REQ_RAWJSON"] = REQ_RAWJSON
    var res map[string]any
    bytes, err := a.ApiCall("ADSModule/Servers", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* SetInstanceConfig - 
 * Name Description Optional
 * param InstanceName string  False
 * param SettingNode string  False
 * param Value string  False
 * return ampapi.ActionResult[any]
 */
func (a *ADSModule) SetInstanceConfig(InstanceName string, SettingNode string, Value string) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["InstanceName"] = InstanceName
    args["SettingNode"] = SettingNode
    args["Value"] = Value
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("ADSModule/SetInstanceConfig", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* SetInstanceNetworkInfo - 
 * Name Description Optional
 * param InstanceId ampapi.UUID  False
 * param PortMappings map[string]int32  False
 * return ampapi.ActionResult[any]
 */
func (a *ADSModule) SetInstanceNetworkInfo(InstanceId ampapi.UUID, PortMappings map[string]int32) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["InstanceId"] = InstanceId
    args["PortMappings"] = PortMappings
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("ADSModule/SetInstanceNetworkInfo", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* SetInstanceSuspended - 
 * Name Description Optional
 * param InstanceName string  False
 * param Suspended bool  False
 * return ampapi.ActionResult[any]
 */
func (a *ADSModule) SetInstanceSuspended(InstanceName string, Suspended bool) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["InstanceName"] = InstanceName
    args["Suspended"] = Suspended
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("ADSModule/SetInstanceSuspended", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* StartAllInstances - 
 * Name Description Optional
 * return ampapi.ActionResult[any]
 */
func (a *ADSModule) StartAllInstances() (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("ADSModule/StartAllInstances", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* StartInstance - 
 * Name Description Optional
 * param InstanceName string  False
 * return ampapi.ActionResult[any]
 */
func (a *ADSModule) StartInstance(InstanceName string) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["InstanceName"] = InstanceName
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("ADSModule/StartInstance", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* StopAllInstances - 
 * Name Description Optional
 * return ampapi.ActionResult[any]
 */
func (a *ADSModule) StopAllInstances() (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("ADSModule/StopAllInstances", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* StopInstance - 
 * Name Description Optional
 * param InstanceName string  False
 * return ampapi.ActionResult[any]
 */
func (a *ADSModule) StopInstance(InstanceName string) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["InstanceName"] = InstanceName
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("ADSModule/StopInstance", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* TestADSLoginDetails - 
 * Name Description Optional
 * param url string  False
 * param username string  False
 * param password string  False
 * return ampapi.ActionResult[any]
 */
func (a *ADSModule) TestADSLoginDetails(url string, username string, password string) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["url"] = url
    args["username"] = username
    args["password"] = password
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("ADSModule/TestADSLoginDetails", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* UpdateDatastore - 
 * Name Description Optional
 * param updatedDatastore ampapi.InstanceDatastore  False
 * return ampapi.ActionResult[any]
 */
func (a *ADSModule) UpdateDatastore(updatedDatastore ampapi.InstanceDatastore) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["updatedDatastore"] = updatedDatastore
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("ADSModule/UpdateDatastore", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* UpdateDeploymentTemplate - 
 * Name Description Optional
 * param templateToUpdate any  False
 * return ampapi.ActionResult[any]
 */
func (a *ADSModule) UpdateDeploymentTemplate(templateToUpdate any) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["templateToUpdate"] = templateToUpdate
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("ADSModule/UpdateDeploymentTemplate", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* UpdateInstanceInfo - 
 * Name Description Optional
 * param InstanceId string  False
 * param FriendlyName string  False
 * param Description string  False
 * param StartOnBoot bool  False
 * param Suspended bool  False
 * param ExcludeFromFirewall bool  False
 * param RunInContainer bool  False
 * param ContainerMemory int32  False
 * param MemoryPolicy any  False
 * param ContainerMaxCPU any  False
 * param ContainerImage string  False
 * return ampapi.ActionResult[any]
 */
func (a *ADSModule) UpdateInstanceInfo(InstanceId string, FriendlyName string, Description string, StartOnBoot bool, Suspended bool, ExcludeFromFirewall bool, RunInContainer bool, ContainerMemory int32, MemoryPolicy any, ContainerMaxCPU any, ContainerImage string) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["InstanceId"] = InstanceId
    args["FriendlyName"] = FriendlyName
    args["Description"] = Description
    args["StartOnBoot"] = StartOnBoot
    args["Suspended"] = Suspended
    args["ExcludeFromFirewall"] = ExcludeFromFirewall
    args["RunInContainer"] = RunInContainer
    args["ContainerMemory"] = ContainerMemory
    args["MemoryPolicy"] = MemoryPolicy
    args["ContainerMaxCPU"] = ContainerMaxCPU
    args["ContainerImage"] = ContainerImage
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("ADSModule/UpdateInstanceInfo", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* UpdateTarget - 
 * Name Description Optional
 * param TargetID ampapi.UUID  False
 * return any
 */
func (a *ADSModule) UpdateTarget(TargetID ampapi.UUID) (any, error) {
    var args = make(map[string]any)
    args["TargetID"] = TargetID
    var res any
    bytes, err := a.ApiCall("ADSModule/UpdateTarget", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* UpdateTargetInfo - 
 * Name Description Optional
 * param Id ampapi.UUID  False
 * param FriendlyName string  False
 * param Url ampapi.URL  False
 * param Description string  False
 * param Tags []string  False
 * return ampapi.ActionResult[any]
 */
func (a *ADSModule) UpdateTargetInfo(Id ampapi.UUID, FriendlyName string, Url ampapi.URL, Description string, Tags []string) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["Id"] = Id
    args["FriendlyName"] = FriendlyName
    args["Url"] = Url
    args["Description"] = Description
    args["Tags"] = Tags
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("ADSModule/UpdateTargetInfo", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* UpgradeAllInstances - 
 * Name Description Optional
 * param RestartRunning bool  False
 * return ampapi.ActionResult[any]
 */
func (a *ADSModule) UpgradeAllInstances(RestartRunning bool) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["RestartRunning"] = RestartRunning
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("ADSModule/UpgradeAllInstances", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

/* UpgradeInstance - 
 * Name Description Optional
 * param InstanceName string  False
 * return ampapi.ActionResult[any]
 */
func (a *ADSModule) UpgradeInstance(InstanceName string) (ampapi.ActionResult[any], error) {
    var args = make(map[string]any)
    args["InstanceName"] = InstanceName
    var res ampapi.ActionResult[any]
    bytes, err := a.ApiCall("ADSModule/UpgradeInstance", args)
    json.Unmarshal(bytes, &res)
    return res, err
}

