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

public final class ADSModule extends AMPAPI {
    public ADSModule(AuthProvider authprovider) {
        super(authprovider);
    }

    /**
     * Name Description Optional
     * @param newDatastore 
     * @return ActionResult
     */
    public ActionResult AddDatastore(InstanceDatastore newDatastore) {
        Map<String, Object> args = new HashMap<>();
        args.put("newDatastore", newDatastore);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/AddDatastore", args, type);
    }

    /**
     * Name Description Optional
     * @param InstanceID 
     * @param Args 
     * @param RebuildConfiguration 
     * @return ActionResult
     */
    public ActionResult ApplyInstanceConfiguration(UUID InstanceID, Map<String, String> Args, @Nullable Boolean RebuildConfiguration) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceID", InstanceID);
        args.put("Args", Args);
        args.put("RebuildConfiguration", RebuildConfiguration);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/ApplyInstanceConfiguration", args, type);
    }

    /**Overlays an existing template on an existing instance. Used to perform package reconfigurations. Do not use this to 'transform' an existing application into another. The instance should be deleted and re-created in that situation.
     * Name Description Optional
     * @param InstanceID 
     * @param TemplateID 
     * @param NewFriendlyName 
     * @param Secret 
     * @param RestartIfPreviouslyRunning 
     * @return ActionResult
     */
    public ActionResult ApplyTemplate(UUID InstanceID, Integer TemplateID, @Nullable String NewFriendlyName, @Nullable String Secret, @Nullable Boolean RestartIfPreviouslyRunning) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceID", InstanceID);
        args.put("TemplateID", TemplateID);
        args.put("NewFriendlyName", NewFriendlyName);
        args.put("Secret", Secret);
        args.put("RestartIfPreviouslyRunning", RestartIfPreviouslyRunning);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/ApplyTemplate", args, type);
    }

    /**
     * Name Description Optional
     * @param Friendly 
     * @param IsHTTPS 
     * @param Host 
     * @param Port 
     * @param InstanceID 
     * @return ActionResult
     */
    public ActionResult AttachADS(String Friendly, Boolean IsHTTPS, String Host, Integer Port, UUID InstanceID) {
        Map<String, Object> args = new HashMap<>();
        args.put("Friendly", Friendly);
        args.put("IsHTTPS", IsHTTPS);
        args.put("Host", Host);
        args.put("Port", Port);
        args.put("InstanceID", InstanceID);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/AttachADS", args, type);
    }

    /**
     * Name Description Optional
     * @param Id 
     * @param NewName 
     * @return ActionResult
     */
    public ActionResult CloneTemplate(Integer Id, String NewName) {
        Map<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        args.put("NewName", NewName);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/CloneTemplate", args, type);
    }

    /**
     * Name Description Optional
     * @param Name 
     * @return ActionResult
     */
    public ActionResult CreateDeploymentTemplate(String Name) {
        Map<String, Object> args = new HashMap<>();
        args.put("Name", Name);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/CreateDeploymentTemplate", args, type);
    }

    /**
     * Name Description Optional
     * @param TargetADSInstance 
     * @param NewInstanceId 
     * @param Module 
     * @param InstanceName 
     * @param FriendlyName 
     * @param IPBinding 
     * @param PortNumber 
     * @param AdminUsername 
     * @param AdminPassword 
     * @param ProvisionSettings 
     * @param AutoConfigure When enabled, all settings other than the Module, Target and FriendlyName are ignored and replaced with automatically generated values.
     * @param StartOnBoot 
     * @param DisplayImageSource 
     * @param TargetDatastore 
     * @param PostCreate 
     * @return ActionResult
     */
    public ActionResult CreateInstance(UUID TargetADSInstance, UUID NewInstanceId, String Module, String InstanceName, String FriendlyName, String IPBinding, Integer PortNumber, String AdminUsername, String AdminPassword, Map<String, String> ProvisionSettings, @Nullable Boolean AutoConfigure, @Nullable Boolean StartOnBoot, @Nullable String DisplayImageSource, @Nullable Integer TargetDatastore, @Nullable PostCreateAppActions PostCreate) {
        Map<String, Object> args = new HashMap<>();
        args.put("TargetADSInstance", TargetADSInstance);
        args.put("NewInstanceId", NewInstanceId);
        args.put("Module", Module);
        args.put("InstanceName", InstanceName);
        args.put("FriendlyName", FriendlyName);
        args.put("IPBinding", IPBinding);
        args.put("PortNumber", PortNumber);
        args.put("AdminUsername", AdminUsername);
        args.put("AdminPassword", AdminPassword);
        args.put("ProvisionSettings", ProvisionSettings);
        args.put("AutoConfigure", AutoConfigure);
        args.put("StartOnBoot", StartOnBoot);
        args.put("DisplayImageSource", DisplayImageSource);
        args.put("TargetDatastore", TargetDatastore);
        args.put("PostCreate", PostCreate);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/CreateInstance", args, type);
    }

    /**
     * Name Description Optional
     * @param SpecId 
     * @param TargetADSInstance 
     * @param FriendlyName 
     * @param PostCreate 
     * @param StartOnBoot 
     * @param TargetDatastore 
     * @return ActionResult
     */
    public ActionResult CreateInstanceFromSpec(UUID SpecId, UUID TargetADSInstance, String FriendlyName, @Nullable PostCreateAppActions PostCreate, @Nullable Boolean StartOnBoot, @Nullable Integer TargetDatastore) {
        Map<String, Object> args = new HashMap<>();
        args.put("SpecId", SpecId);
        args.put("TargetADSInstance", TargetADSInstance);
        args.put("FriendlyName", FriendlyName);
        args.put("PostCreate", PostCreate);
        args.put("StartOnBoot", StartOnBoot);
        args.put("TargetDatastore", TargetDatastore);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/CreateInstanceFromSpec", args, type);
    }

    /**
     * Name Description Optional
     * @param Instance 
     * @param PostCreate 
     * @return ActionResult
     */
    public ActionResult CreateLocalInstance(LocalAMPInstance Instance, @Nullable PostCreateAppActions PostCreate) {
        Map<String, Object> args = new HashMap<>();
        args.put("Instance", Instance);
        args.put("PostCreate", PostCreate);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/CreateLocalInstance", args, type);
    }

    /**
     * Name Description Optional
     * @param id 
     * @return ActionResult
     */
    public ActionResult DeleteDatastore(Integer id) {
        Map<String, Object> args = new HashMap<>();
        args.put("id", id);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/DeleteDatastore", args, type);
    }

    /**
     * Name Description Optional
     * @param Id 
     * @return ActionResult
     */
    public ActionResult DeleteDeploymentTemplate(Integer Id) {
        Map<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/DeleteDeploymentTemplate", args, type);
    }

    /**
     * Name Description Optional
     * @param InstanceName 
     * @return RunningTask
     */
    public RunningTask DeleteInstance(String InstanceName) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        Type type = new TypeToken<RunningTask>() {}.getType();
        return this.APICall("ADSModule/DeleteInstance", args, type);
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
        return this.APICall("ADSModule/DeleteInstanceUsers", args, type);
    }

    /**
     * Name Description Optional
     * @param TemplateID The ID of the template to be deployed, as per the Template Management UI in AMP itself.
     * @param NewUsername If specified, AMP will create a new user with this name for this instance. Must be unique. If this user already exists, this will be ignored but the new instance will be assigned to this user.
     * @param NewPassword If 'NewUsername' is specified and the user doesn't already exist, the password that will be assigned to this user.
     * @param NewEmail If 'NewUsername' is specified and the user doesn't already exist, the email address that will be assigned to this user.
     * @param RequiredTags If specified, AMP will only deploy this template to targets that have every single 'tag' specified in their target configuration. You can adjust this via the controller by clicking 'Edit' on the target settings.
     * @param Tag Unrelated to RequiredTags. This is to uniquely identify this instance to your own systems. It may be something like an order ID or service ID so you can find the associated instance again at a later time. If 'UseTagAsInstanceName' is enabled, then this will also be used as the instance name for the created instance - but it must be unique.
     * @param FriendlyName A friendly name for this instance. If left blank, AMP will generate one for you.
     * @param Secret Must be a non-empty strong in order to get a callback on deployment state change. This secret will be passed back to you in the callback so you can verify the request.
     * @param ExtraProvisionSettings A dictionary of setting nodes and values to create the new instance with. Identical in function to the provisioning arguments in the template itself.
     * @param PostCreate 0: Do Nothing, 1: Update Once, 2: Update Always, 3: Update and Start Once, 4: Update and Start Always, 5. Start Always
     * @return RunningTask
     */
    public RunningTask DeployTemplate(Integer TemplateID, @Nullable String NewUsername, @Nullable String NewPassword, @Nullable String NewEmail, @Nullable List<String> RequiredTags, @Nullable String Tag, @Nullable String FriendlyName, @Nullable String Secret, @Nullable Map<String, String> ExtraProvisionSettings, @Nullable PostCreateAppActions PostCreate) {
        Map<String, Object> args = new HashMap<>();
        args.put("TemplateID", TemplateID);
        args.put("NewUsername", NewUsername);
        args.put("NewPassword", NewPassword);
        args.put("NewEmail", NewEmail);
        args.put("RequiredTags", RequiredTags);
        args.put("Tag", Tag);
        args.put("FriendlyName", FriendlyName);
        args.put("Secret", Secret);
        args.put("ExtraProvisionSettings", ExtraProvisionSettings);
        args.put("PostCreate", PostCreate);
        Type type = new TypeToken<RunningTask>() {}.getType();
        return this.APICall("ADSModule/DeployTemplate", args, type);
    }

    /**
     * Name Description Optional
     * @param Id 
     * @return ActionResult
     */
    public ActionResult DetachTarget(UUID Id) {
        Map<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/DetachTarget", args, type);
    }

    /**
     * Name Description Optional
     * @param SourceArchive 
     * @return ActionResult
     */
    public ActionResult ExtractEverywhere(String SourceArchive) {
        Map<String, Object> args = new HashMap<>();
        args.put("SourceArchive", SourceArchive);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/ExtractEverywhere", args, type);
    }

    /**
     * Name Description Optional
     * @param instanceId 
     * @return List<EndpointInfo>
     */
    public List<EndpointInfo> GetApplicationEndpoints(UUID instanceId) {
        Map<String, Object> args = new HashMap<>();
        args.put("instanceId", instanceId);
        Type type = new TypeToken<List<EndpointInfo>>() {}.getType();
        return this.APICall("ADSModule/GetApplicationEndpoints", args, type);
    }

    /**
     * Name Description Optional
     * @param id 
     * @return InstanceDatastore
     */
    public InstanceDatastore GetDatastore(Integer id) {
        Map<String, Object> args = new HashMap<>();
        args.put("id", id);
        Type type = new TypeToken<InstanceDatastore>() {}.getType();
        return this.APICall("ADSModule/GetDatastore", args, type);
    }

    /**
     * Name Description Optional
     * @param datastoreId 
     * @return List<InstanceSummary>
     */
    public List<InstanceSummary> GetDatastoreInstances(Integer datastoreId) {
        Map<String, Object> args = new HashMap<>();
        args.put("datastoreId", datastoreId);
        Type type = new TypeToken<List<InstanceSummary>>() {}.getType();
        return this.APICall("ADSModule/GetDatastoreInstances", args, type);
    }

    /**
     * Name Description Optional

     * @return List<InstanceDatastore>
     */
    public List<InstanceDatastore> GetDatastores() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<InstanceDatastore>>() {}.getType();
        return this.APICall("ADSModule/GetDatastores", args, type);
    }

    /**
     * Name Description Optional

     * @return List<DeploymentTemplate>
     */
    public List<DeploymentTemplate> GetDeploymentTemplates() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<DeploymentTemplate>>() {}.getType();
        return this.APICall("ADSModule/GetDeploymentTemplates", args, type);
    }

    /**
     * Name Description Optional
     * @param GroupId 
     * @return IADSInstance
     */
    public IADSInstance GetGroup(UUID GroupId) {
        Map<String, Object> args = new HashMap<>();
        args.put("GroupId", GroupId);
        Type type = new TypeToken<IADSInstance>() {}.getType();
        return this.APICall("ADSModule/GetGroup", args, type);
    }

    /**
     * Name Description Optional
     * @param InstanceId 
     * @return InstanceSummary
     */
    public InstanceSummary GetInstance(UUID InstanceId) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        Type type = new TypeToken<InstanceSummary>() {}.getType();
        return this.APICall("ADSModule/GetInstance", args, type);
    }

    /**
     * Name Description Optional
     * @param InstanceName 
     * @return List<PortUsage>
     */
    public List<PortUsage> GetInstanceNetworkInfo(String InstanceName) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        Type type = new TypeToken<List<PortUsage>>() {}.getType();
        return this.APICall("ADSModule/GetInstanceNetworkInfo", args, type);
    }

    /**
     * Name Description Optional

     * @return List<InstanceStatus>
     */
    public List<InstanceStatus> GetInstanceStatuses() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<InstanceStatus>>() {}.getType();
        return this.APICall("ADSModule/GetInstanceStatuses", args, type);
    }

    /**
     * Name Description Optional
     * @param ForceIncludeSelf 
     * @return List<IADSInstance>
     */
    public List<IADSInstance> GetInstances(@Nullable Boolean ForceIncludeSelf) {
        Map<String, Object> args = new HashMap<>();
        args.put("ForceIncludeSelf", ForceIncludeSelf);
        Type type = new TypeToken<List<IADSInstance>>() {}.getType();
        return this.APICall("ADSModule/GetInstances", args, type);
    }

    /**
     * Name Description Optional

     * @return List<InstanceSummary>
     */
    public List<InstanceSummary> GetLocalInstances() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<InstanceSummary>>() {}.getType();
        return this.APICall("ADSModule/GetLocalInstances", args, type);
    }

    /**
     * Name Description Optional
     * @param ModuleName 
     * @return List<ProvisionSettingInfo>
     */
    public List<ProvisionSettingInfo> GetProvisionArguments(String ModuleName) {
        Map<String, Object> args = new HashMap<>();
        args.put("ModuleName", ModuleName);
        Type type = new TypeToken<List<ProvisionSettingInfo>>() {}.getType();
        return this.APICall("ADSModule/GetProvisionArguments", args, type);
    }

    /**
     * Name Description Optional

     * @return ProvisionFitness
     */
    public ProvisionFitness GetProvisionFitness() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<ProvisionFitness>() {}.getType();
        return this.APICall("ADSModule/GetProvisionFitness", args, type);
    }

    /**
     * Name Description Optional

     * @return List<ApplicationSpecSummary>
     */
    public List<ApplicationSpecSummary> GetSupportedAppSummaries() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<ApplicationSpecSummary>>() {}.getType();
        return this.APICall("ADSModule/GetSupportedAppSummaries", args, type);
    }

    /**
     * Name Description Optional

     * @return List<ApplicationSpec>
     */
    public List<ApplicationSpec> GetSupportedApplications() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<ApplicationSpec>>() {}.getType();
        return this.APICall("ADSModule/GetSupportedApplications", args, type);
    }

    /**
     * Name Description Optional

     * @return RemoteTargetInfo
     */
    public RemoteTargetInfo GetTargetInfo() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<RemoteTargetInfo>() {}.getType();
        return this.APICall("ADSModule/GetTargetInfo", args, type);
    }

    /**
     * Name Description Optional
     * @param ForModule 
     * @param SettingNode 
     * @param Values 
     * @return ActionResult
     */
    public ActionResult HandoutInstanceConfigs(String ForModule, String SettingNode, List<String> Values) {
        Map<String, Object> args = new HashMap<>();
        args.put("ForModule", ForModule);
        args.put("SettingNode", SettingNode);
        args.put("Values", Values);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/HandoutInstanceConfigs", args, type);
    }

    /**
     * Name Description Optional
     * @param InstanceId 
     * @return ActionResult<String>
     */
    public ActionResult<String> ManageInstance(UUID InstanceId) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        Type type = new TypeToken<ActionResult<String>>() {}.getType();
        return this.APICall("ADSModule/ManageInstance", args, type);
    }

    /**
     * Name Description Optional
     * @param instanceId 
     * @param PortNumber 
     * @param Range 
     * @param Protocol 
     * @param Description 
     * @param Open 
     * @return ActionResult
     */
    public ActionResult ModifyCustomFirewallRule(UUID instanceId, Integer PortNumber, Integer Range, PortProtocol Protocol, String Description, Boolean Open) {
        Map<String, Object> args = new HashMap<>();
        args.put("instanceId", instanceId);
        args.put("PortNumber", PortNumber);
        args.put("Range", Range);
        args.put("Protocol", Protocol);
        args.put("Description", Description);
        args.put("Open", Open);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/ModifyCustomFirewallRule", args, type);
    }

    /**
     * Name Description Optional
     * @param instanceId 
     * @param datastoreId 
     * @return RunningTask
     */
    public RunningTask MoveInstanceDatastore(UUID instanceId, Integer datastoreId) {
        Map<String, Object> args = new HashMap<>();
        args.put("instanceId", instanceId);
        args.put("datastoreId", datastoreId);
        Type type = new TypeToken<RunningTask>() {}.getType();
        return this.APICall("ADSModule/MoveInstanceDatastore", args, type);
    }

    /**
     * Name Description Optional
     * @param instanceId 
     * @return RunningTask
     */
    public RunningTask ReactivateInstance(UUID instanceId) {
        Map<String, Object> args = new HashMap<>();
        args.put("instanceId", instanceId);
        Type type = new TypeToken<RunningTask>() {}.getType();
        return this.APICall("ADSModule/ReactivateInstance", args, type);
    }

    /**
     * Name Description Optional

     * @return RunningTask
     */
    public RunningTask ReactivateLocalInstances() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<RunningTask>() {}.getType();
        return this.APICall("ADSModule/ReactivateLocalInstances", args, type);
    }

    /**
     * Name Description Optional

     * @return Void
     */
    public Void RefreshAppCache() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("ADSModule/RefreshAppCache", args, type);
    }

    /**
     * Name Description Optional
     * @param GroupId 
     * @return ActionResult
     */
    public ActionResult RefreshGroup(UUID GroupId) {
        Map<String, Object> args = new HashMap<>();
        args.put("GroupId", GroupId);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/RefreshGroup", args, type);
    }

    /**
     * Name Description Optional
     * @param InstanceId 
     * @return ActionResult
     */
    public ActionResult RefreshInstanceConfig(String InstanceId) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/RefreshInstanceConfig", args, type);
    }

    /**
     * Name Description Optional
     * @param force 
     * @return Void
     */
    public Void RefreshRemoteConfigStores(@Nullable Boolean force) {
        Map<String, Object> args = new HashMap<>();
        args.put("force", force);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("ADSModule/RefreshRemoteConfigStores", args, type);
    }

    /**
     * Name Description Optional
     * @param controllerUrl 
     * @param myUrl 
     * @param username 
     * @param password 
     * @param twoFactorToken 
     * @param friendlyName 
     * @return ActionResult
     */
    public ActionResult RegisterTarget(String controllerUrl, String myUrl, String username, String password, String twoFactorToken, String friendlyName) {
        Map<String, Object> args = new HashMap<>();
        args.put("controllerUrl", controllerUrl);
        args.put("myUrl", myUrl);
        args.put("username", username);
        args.put("password", password);
        args.put("twoFactorToken", twoFactorToken);
        args.put("friendlyName", friendlyName);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/RegisterTarget", args, type);
    }

    /**
     * Name Description Optional
     * @param id 
     * @return RunningTask
     */
    public RunningTask RepairDatastore(Integer id) {
        Map<String, Object> args = new HashMap<>();
        args.put("id", id);
        Type type = new TypeToken<RunningTask>() {}.getType();
        return this.APICall("ADSModule/RepairDatastore", args, type);
    }

    /**
     * Name Description Optional
     * @param datastoreId 
     * @return RunningTask
     */
    public RunningTask RequestDatastoreSizeCalculation(Integer datastoreId) {
        Map<String, Object> args = new HashMap<>();
        args.put("datastoreId", datastoreId);
        Type type = new TypeToken<RunningTask>() {}.getType();
        return this.APICall("ADSModule/RequestDatastoreSizeCalculation", args, type);
    }

    /**
     * Name Description Optional
     * @param InstanceName 
     * @return ActionResult
     */
    public ActionResult RestartInstance(String InstanceName) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/RestartInstance", args, type);
    }

    /**
     * Name Description Optional
     * @param Data 
     * @param RealIP 
     * @return Map<String, Object>
     */
    public Map<String, Object> Servers(Map<String, Object> Data, InetAddress RealIP) {
        Map<String, Object> args = new HashMap<>();
        args.put("Data", Data);
        args.put("RealIP", RealIP);
        Type type = new TypeToken<Map<String, Object>>() {}.getType();
        return this.APICall("ADSModule/Servers", args, type);
    }

    /**
     * Name Description Optional
     * @param InstanceName 
     * @param SettingNode 
     * @param Value 
     * @return ActionResult
     */
    public ActionResult SetInstanceConfig(String InstanceName, String SettingNode, String Value) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        args.put("SettingNode", SettingNode);
        args.put("Value", Value);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/SetInstanceConfig", args, type);
    }

    /**
     * Name Description Optional
     * @param InstanceId 
     * @param PortMappings 
     * @return ActionResult
     */
    public ActionResult SetInstanceNetworkInfo(UUID InstanceId, Map<String, Integer> PortMappings) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        args.put("PortMappings", PortMappings);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/SetInstanceNetworkInfo", args, type);
    }

    /**
     * Name Description Optional
     * @param InstanceName 
     * @param Suspended 
     * @return ActionResult
     */
    public ActionResult SetInstanceSuspended(String InstanceName, Boolean Suspended) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        args.put("Suspended", Suspended);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/SetInstanceSuspended", args, type);
    }

    /**
     * Name Description Optional
     * @param TargetADSInstance 
     * @return ActionResult
     */
    public ActionResult StartAllInstances(UUID TargetADSInstance) {
        Map<String, Object> args = new HashMap<>();
        args.put("TargetADSInstance", TargetADSInstance);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/StartAllInstances", args, type);
    }

    /**
     * Name Description Optional
     * @param InstanceName 
     * @return ActionResult
     */
    public ActionResult StartInstance(String InstanceName) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/StartInstance", args, type);
    }

    /**
     * Name Description Optional
     * @param TargetADSInstance 
     * @return ActionResult
     */
    public ActionResult StopAllInstances(UUID TargetADSInstance) {
        Map<String, Object> args = new HashMap<>();
        args.put("TargetADSInstance", TargetADSInstance);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/StopAllInstances", args, type);
    }

    /**
     * Name Description Optional
     * @param InstanceName 
     * @return ActionResult
     */
    public ActionResult StopInstance(String InstanceName) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/StopInstance", args, type);
    }

    /**
     * Name Description Optional
     * @param url 
     * @param username 
     * @param password 
     * @param twoFactorToken 
     * @return ActionResult
     */
    public ActionResult TestADSLoginDetails(String url, String username, String password, String twoFactorToken) {
        Map<String, Object> args = new HashMap<>();
        args.put("url", url);
        args.put("username", username);
        args.put("password", password);
        args.put("twoFactorToken", twoFactorToken);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/TestADSLoginDetails", args, type);
    }

    /**
     * Name Description Optional
     * @param updatedDatastore 
     * @return ActionResult
     */
    public ActionResult UpdateDatastore(InstanceDatastore updatedDatastore) {
        Map<String, Object> args = new HashMap<>();
        args.put("updatedDatastore", updatedDatastore);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/UpdateDatastore", args, type);
    }

    /**
     * Name Description Optional
     * @param templateToUpdate 
     * @return ActionResult
     */
    public ActionResult UpdateDeploymentTemplate(DeploymentTemplate templateToUpdate) {
        Map<String, Object> args = new HashMap<>();
        args.put("templateToUpdate", templateToUpdate);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/UpdateDeploymentTemplate", args, type);
    }

    /**
     * Name Description Optional
     * @param InstanceId 
     * @param FriendlyName 
     * @param Description 
     * @param StartOnBoot 
     * @param Suspended 
     * @param ExcludeFromFirewall 
     * @param RunInContainer 
     * @param ContainerMemory 
     * @param MemoryPolicy 
     * @param ContainerMaxCPU 
     * @param ContainerImage 
     * @param ContainerSwap 
     * @param WelcomeMessage 
     * @return ActionResult
     */
    public ActionResult UpdateInstanceInfo(String InstanceId, String FriendlyName, String Description, Boolean StartOnBoot, Boolean Suspended, Boolean ExcludeFromFirewall, Boolean RunInContainer, Integer ContainerMemory, ContainerMemoryPolicy MemoryPolicy, Float ContainerMaxCPU, String ContainerImage, Integer ContainerSwap, @Nullable String WelcomeMessage) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        args.put("FriendlyName", FriendlyName);
        args.put("Description", Description);
        args.put("StartOnBoot", StartOnBoot);
        args.put("Suspended", Suspended);
        args.put("ExcludeFromFirewall", ExcludeFromFirewall);
        args.put("RunInContainer", RunInContainer);
        args.put("ContainerMemory", ContainerMemory);
        args.put("MemoryPolicy", MemoryPolicy);
        args.put("ContainerMaxCPU", ContainerMaxCPU);
        args.put("ContainerImage", ContainerImage);
        args.put("ContainerSwap", ContainerSwap);
        args.put("WelcomeMessage", WelcomeMessage);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/UpdateInstanceInfo", args, type);
    }

    /**
     * Name Description Optional
     * @param TargetID 
     * @return Void
     */
    public Void UpdateTarget(UUID TargetID) {
        Map<String, Object> args = new HashMap<>();
        args.put("TargetID", TargetID);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("ADSModule/UpdateTarget", args, type);
    }

    /**
     * Name Description Optional
     * @param Id 
     * @param FriendlyName 
     * @param Url 
     * @param Description 
     * @param Tags 
     * @return ActionResult
     */
    public ActionResult UpdateTargetInfo(UUID Id, String FriendlyName, URI Url, String Description, List<String> Tags) {
        Map<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        args.put("FriendlyName", FriendlyName);
        args.put("Url", Url);
        args.put("Description", Description);
        args.put("Tags", Tags);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/UpdateTargetInfo", args, type);
    }

    /**
     * Name Description Optional
     * @param RestartRunning 
     * @param TargetADSInstance 
     * @return ActionResult
     */
    public ActionResult UpgradeAllInstances(Boolean RestartRunning, UUID TargetADSInstance) {
        Map<String, Object> args = new HashMap<>();
        args.put("RestartRunning", RestartRunning);
        args.put("TargetADSInstance", TargetADSInstance);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/UpgradeAllInstances", args, type);
    }

    /**
     * Name Description Optional
     * @param InstanceName 
     * @return ActionResult
     */
    public ActionResult UpgradeInstance(String InstanceName) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/UpgradeInstance", args, type);
    }


}