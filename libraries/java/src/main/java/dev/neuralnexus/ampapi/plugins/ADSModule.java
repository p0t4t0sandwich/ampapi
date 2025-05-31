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
import java.net.InetAddress;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public final class ADSModule extends AMPAPI {
    public ADSModule(AuthProvider authprovider) {
        super(authprovider);
    }

    /**
     * Name Description
     *
     * @param newDatastore
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> AddDatastore(InstanceDatastore newDatastore) {
        Map<String, Object> args = new HashMap<>();
        args.put("newDatastore", newDatastore);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/AddDatastore", args, type);
    }

    /**
     * Name Description
     *
     * @param newDatastore
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> AddDatastoreAsync(
            InstanceDatastore newDatastore) {
        return CompletableFuture.supplyAsync(() -> this.AddDatastore(newDatastore));
    }

    /**
     * Name Description
     *
     * @param InstanceID
     * @param Args
     * @param RebuildConfiguration
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> ApplyInstanceConfiguration(
            UUID InstanceID, Map<String, String> Args, @Nullable Boolean RebuildConfiguration) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceID", InstanceID);
        args.put("Args", Args);
        args.put("RebuildConfiguration", RebuildConfiguration);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/ApplyInstanceConfiguration", args, type);
    }

    /**
     * Name Description
     *
     * @param InstanceID
     * @param Args
     * @param RebuildConfiguration
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> ApplyInstanceConfigurationAsync(
            UUID InstanceID, Map<String, String> Args, @Nullable Boolean RebuildConfiguration) {
        return CompletableFuture.supplyAsync(
                () -> this.ApplyInstanceConfiguration(InstanceID, Args, RebuildConfiguration));
    }

    /**
     * Overlays an existing template on an existing instance. Used to perform package
     * reconfigurations. Do not use this to 'transform' an existing application into another. The
     * instance should be deleted and re-created in that situation. Name Description
     *
     * @param InstanceID
     * @param TemplateID
     * @param NewFriendlyName
     * @param Secret
     * @param RestartIfPreviouslyRunning
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> ApplyTemplate(
            UUID InstanceID,
            Integer TemplateID,
            @Nullable String NewFriendlyName,
            @Nullable String Secret,
            @Nullable Boolean RestartIfPreviouslyRunning) {
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
     * Overlays an existing template on an existing instance. Used to perform package
     * reconfigurations. Do not use this to 'transform' an existing application into another. The
     * instance should be deleted and re-created in that situation. Name Description
     *
     * @param InstanceID
     * @param TemplateID
     * @param NewFriendlyName
     * @param Secret
     * @param RestartIfPreviouslyRunning
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> ApplyTemplateAsync(
            UUID InstanceID,
            Integer TemplateID,
            @Nullable String NewFriendlyName,
            @Nullable String Secret,
            @Nullable Boolean RestartIfPreviouslyRunning) {
        return CompletableFuture.supplyAsync(
                () ->
                        this.ApplyTemplate(
                                InstanceID,
                                TemplateID,
                                NewFriendlyName,
                                Secret,
                                RestartIfPreviouslyRunning));
    }

    /**
     * Name Description
     *
     * @param Friendly
     * @param IsHTTPS
     * @param Host
     * @param Port
     * @param InstanceID
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> AttachADS(
            String Friendly, Boolean IsHTTPS, String Host, Integer Port, UUID InstanceID) {
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
     * Name Description
     *
     * @param Friendly
     * @param IsHTTPS
     * @param Host
     * @param Port
     * @param InstanceID
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> AttachADSAsync(
            String Friendly, Boolean IsHTTPS, String Host, Integer Port, UUID InstanceID) {
        return CompletableFuture.supplyAsync(
                () -> this.AttachADS(Friendly, IsHTTPS, Host, Port, InstanceID));
    }

    /**
     * Name Description
     *
     * @param PairingCode
     * @param Friendly
     * @param IsHTTPS
     * @param Host
     * @param Port
     * @param InstanceID
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> AttachADSWithPairingCode(
            String PairingCode,
            String Friendly,
            Boolean IsHTTPS,
            String Host,
            Integer Port,
            UUID InstanceID) {
        Map<String, Object> args = new HashMap<>();
        args.put("PairingCode", PairingCode);
        args.put("Friendly", Friendly);
        args.put("IsHTTPS", IsHTTPS);
        args.put("Host", Host);
        args.put("Port", Port);
        args.put("InstanceID", InstanceID);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/AttachADSWithPairingCode", args, type);
    }

    /**
     * Name Description
     *
     * @param PairingCode
     * @param Friendly
     * @param IsHTTPS
     * @param Host
     * @param Port
     * @param InstanceID
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> AttachADSWithPairingCodeAsync(
            String PairingCode,
            String Friendly,
            Boolean IsHTTPS,
            String Host,
            Integer Port,
            UUID InstanceID) {
        return CompletableFuture.supplyAsync(
                () ->
                        this.AttachADSWithPairingCode(
                                PairingCode, Friendly, IsHTTPS, Host, Port, InstanceID));
    }

    /**
     * Name Description
     *
     * @return Void
     */
    public Result<Void, AMPError> CancelPairing() {
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("ADSModule/CancelPairing", type);
    }

    /**
     * Name Description
     *
     * @return Void
     */
    public CompletionStage<Result<Void, AMPError>> CancelPairingAsync() {
        return CompletableFuture.supplyAsync(() -> this.CancelPairing());
    }

    /**
     * Name Description
     *
     * @param Id
     * @param NewName
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> CloneTemplate(Integer Id, String NewName) {
        Map<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        args.put("NewName", NewName);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/CloneTemplate", args, type);
    }

    /**
     * Name Description
     *
     * @param Id
     * @param NewName
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> CloneTemplateAsync(
            Integer Id, String NewName) {
        return CompletableFuture.supplyAsync(() -> this.CloneTemplate(Id, NewName));
    }

    /**
     * Name Description
     *
     * @param Name
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> CreateDeploymentTemplate(String Name) {
        Map<String, Object> args = new HashMap<>();
        args.put("Name", Name);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/CreateDeploymentTemplate", args, type);
    }

    /**
     * Name Description
     *
     * @param Name
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> CreateDeploymentTemplateAsync(
            String Name) {
        return CompletableFuture.supplyAsync(() -> this.CreateDeploymentTemplate(Name));
    }

    /**
     * Name Description
     *
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
     * @param AutoConfigure When enabled, all settings other than the Module, Target and
     *     FriendlyName are ignored and replaced with automatically generated values.
     * @param StartOnBoot
     * @param DisplayImageSource
     * @param TargetDatastore
     * @param PostCreate
     * @param Group
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> CreateInstance(
            UUID TargetADSInstance,
            UUID NewInstanceId,
            String Module,
            String InstanceName,
            String FriendlyName,
            String IPBinding,
            Integer PortNumber,
            String AdminUsername,
            String AdminPassword,
            Map<String, String> ProvisionSettings,
            @Nullable Boolean AutoConfigure,
            @Nullable Boolean StartOnBoot,
            @Nullable String DisplayImageSource,
            @Nullable Integer TargetDatastore,
            @Nullable PostCreateAppActions PostCreate,
            @Nullable String Group) {
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
        args.put("Group", Group);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/CreateInstance", args, type);
    }

    /**
     * Name Description
     *
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
     * @param AutoConfigure When enabled, all settings other than the Module, Target and
     *     FriendlyName are ignored and replaced with automatically generated values.
     * @param StartOnBoot
     * @param DisplayImageSource
     * @param TargetDatastore
     * @param PostCreate
     * @param Group
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> CreateInstanceAsync(
            UUID TargetADSInstance,
            UUID NewInstanceId,
            String Module,
            String InstanceName,
            String FriendlyName,
            String IPBinding,
            Integer PortNumber,
            String AdminUsername,
            String AdminPassword,
            Map<String, String> ProvisionSettings,
            @Nullable Boolean AutoConfigure,
            @Nullable Boolean StartOnBoot,
            @Nullable String DisplayImageSource,
            @Nullable Integer TargetDatastore,
            @Nullable PostCreateAppActions PostCreate,
            @Nullable String Group) {
        return CompletableFuture.supplyAsync(
                () ->
                        this.CreateInstance(
                                TargetADSInstance,
                                NewInstanceId,
                                Module,
                                InstanceName,
                                FriendlyName,
                                IPBinding,
                                PortNumber,
                                AdminUsername,
                                AdminPassword,
                                ProvisionSettings,
                                AutoConfigure,
                                StartOnBoot,
                                DisplayImageSource,
                                TargetDatastore,
                                PostCreate,
                                Group));
    }

    /**
     * Name Description
     *
     * @param SpecId
     * @param TargetADSInstance
     * @param FriendlyName
     * @param PostCreate
     * @param StartOnBoot
     * @param TargetDatastore
     * @param Group
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> CreateInstanceFromSpec(
            UUID SpecId,
            UUID TargetADSInstance,
            String FriendlyName,
            @Nullable PostCreateAppActions PostCreate,
            @Nullable Boolean StartOnBoot,
            @Nullable Integer TargetDatastore,
            @Nullable String Group) {
        Map<String, Object> args = new HashMap<>();
        args.put("SpecId", SpecId);
        args.put("TargetADSInstance", TargetADSInstance);
        args.put("FriendlyName", FriendlyName);
        args.put("PostCreate", PostCreate);
        args.put("StartOnBoot", StartOnBoot);
        args.put("TargetDatastore", TargetDatastore);
        args.put("Group", Group);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/CreateInstanceFromSpec", args, type);
    }

    /**
     * Name Description
     *
     * @param SpecId
     * @param TargetADSInstance
     * @param FriendlyName
     * @param PostCreate
     * @param StartOnBoot
     * @param TargetDatastore
     * @param Group
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> CreateInstanceFromSpecAsync(
            UUID SpecId,
            UUID TargetADSInstance,
            String FriendlyName,
            @Nullable PostCreateAppActions PostCreate,
            @Nullable Boolean StartOnBoot,
            @Nullable Integer TargetDatastore,
            @Nullable String Group) {
        return CompletableFuture.supplyAsync(
                () ->
                        this.CreateInstanceFromSpec(
                                SpecId,
                                TargetADSInstance,
                                FriendlyName,
                                PostCreate,
                                StartOnBoot,
                                TargetDatastore,
                                Group));
    }

    /**
     * Name Description
     *
     * @param Instance
     * @param PostCreate
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> CreateLocalInstance(
            LocalAMPInstance Instance, @Nullable PostCreateAppActions PostCreate) {
        Map<String, Object> args = new HashMap<>();
        args.put("Instance", Instance);
        args.put("PostCreate", PostCreate);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/CreateLocalInstance", args, type);
    }

    /**
     * Name Description
     *
     * @param Instance
     * @param PostCreate
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> CreateLocalInstanceAsync(
            LocalAMPInstance Instance, @Nullable PostCreateAppActions PostCreate) {
        return CompletableFuture.supplyAsync(() -> this.CreateLocalInstance(Instance, PostCreate));
    }

    /**
     * Name Description
     *
     * @param id
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> DeleteDatastore(Integer id) {
        Map<String, Object> args = new HashMap<>();
        args.put("id", id);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/DeleteDatastore", args, type);
    }

    /**
     * Name Description
     *
     * @param id
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> DeleteDatastoreAsync(Integer id) {
        return CompletableFuture.supplyAsync(() -> this.DeleteDatastore(id));
    }

    /**
     * Name Description
     *
     * @param Id
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> DeleteDeploymentTemplate(Integer Id) {
        Map<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/DeleteDeploymentTemplate", args, type);
    }

    /**
     * Name Description
     *
     * @param Id
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> DeleteDeploymentTemplateAsync(
            Integer Id) {
        return CompletableFuture.supplyAsync(() -> this.DeleteDeploymentTemplate(Id));
    }

    /**
     * Name Description
     *
     * @param InstanceName
     * @return RunningTask
     */
    public Result<RunningTask, AMPError> DeleteInstance(String InstanceName) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        Type type = new TypeToken<RunningTask>() {}.getType();
        return this.APICall("ADSModule/DeleteInstance", args, type);
    }

    /**
     * Name Description
     *
     * @param InstanceName
     * @return RunningTask
     */
    public CompletionStage<Result<RunningTask, AMPError>> DeleteInstanceAsync(String InstanceName) {
        return CompletableFuture.supplyAsync(() -> this.DeleteInstance(InstanceName));
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
        return this.APICall("ADSModule/DeleteInstanceUsers", args, type);
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
     * @param TemplateID The ID of the template to be deployed, as per the Template Management UI in
     *     AMP itself.
     * @param NewUsername If specified, AMP will create a new user with this name for this instance.
     *     Must be unique. If this user already exists, this will be ignored but the new instance
     *     will be assigned to this user.
     * @param NewPassword If 'NewUsername' is specified and the user doesn't already exist, the
     *     password that will be assigned to this user.
     * @param NewEmail If 'NewUsername' is specified and the user doesn't already exist, the email
     *     address that will be assigned to this user.
     * @param RequiredTags If specified, AMP will only deploy this template to targets that have
     *     every single 'tag' specified in their target configuration. You can adjust this via the
     *     controller by clicking 'Edit' on the target settings.
     * @param Tag Unrelated to RequiredTags. This is to uniquely identify this instance to your own
     *     systems. It may be something like an order ID or service ID so you can find the
     *     associated instance again at a later time. If 'UseTagAsInstanceName' is enabled, then
     *     this will also be used as the instance name for the created instance - but it must be
     *     unique.
     * @param FriendlyName A friendly name for this instance. If left blank, AMP will generate one
     *     for you.
     * @param Secret Must be a non-empty strong in order to get a callback on deployment state
     *     change. This secret will be passed back to you in the callback so you can verify the
     *     request.
     * @param ExtraProvisionSettings A dictionary of setting nodes and values to create the new
     *     instance with. Identical in function to the provisioning arguments in the template
     *     itself.
     * @param PostCreate 0: Do Nothing, 1: Update Once, 2: Update Always, 3: Update and Start Once,
     *     4: Update and Start Always, 5. Start Always
     * @return RunningTask
     */
    public Result<RunningTask, AMPError> DeployTemplate(
            Integer TemplateID,
            @Nullable String NewUsername,
            @Nullable String NewPassword,
            @Nullable String NewEmail,
            @Nullable List<String> RequiredTags,
            @Nullable String Tag,
            @Nullable String FriendlyName,
            @Nullable String Secret,
            @Nullable Map<String, String> ExtraProvisionSettings,
            @Nullable PostCreateAppActions PostCreate) {
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
     * Name Description
     *
     * @param TemplateID The ID of the template to be deployed, as per the Template Management UI in
     *     AMP itself.
     * @param NewUsername If specified, AMP will create a new user with this name for this instance.
     *     Must be unique. If this user already exists, this will be ignored but the new instance
     *     will be assigned to this user.
     * @param NewPassword If 'NewUsername' is specified and the user doesn't already exist, the
     *     password that will be assigned to this user.
     * @param NewEmail If 'NewUsername' is specified and the user doesn't already exist, the email
     *     address that will be assigned to this user.
     * @param RequiredTags If specified, AMP will only deploy this template to targets that have
     *     every single 'tag' specified in their target configuration. You can adjust this via the
     *     controller by clicking 'Edit' on the target settings.
     * @param Tag Unrelated to RequiredTags. This is to uniquely identify this instance to your own
     *     systems. It may be something like an order ID or service ID so you can find the
     *     associated instance again at a later time. If 'UseTagAsInstanceName' is enabled, then
     *     this will also be used as the instance name for the created instance - but it must be
     *     unique.
     * @param FriendlyName A friendly name for this instance. If left blank, AMP will generate one
     *     for you.
     * @param Secret Must be a non-empty strong in order to get a callback on deployment state
     *     change. This secret will be passed back to you in the callback so you can verify the
     *     request.
     * @param ExtraProvisionSettings A dictionary of setting nodes and values to create the new
     *     instance with. Identical in function to the provisioning arguments in the template
     *     itself.
     * @param PostCreate 0: Do Nothing, 1: Update Once, 2: Update Always, 3: Update and Start Once,
     *     4: Update and Start Always, 5. Start Always
     * @return RunningTask
     */
    public CompletionStage<Result<RunningTask, AMPError>> DeployTemplateAsync(
            Integer TemplateID,
            @Nullable String NewUsername,
            @Nullable String NewPassword,
            @Nullable String NewEmail,
            @Nullable List<String> RequiredTags,
            @Nullable String Tag,
            @Nullable String FriendlyName,
            @Nullable String Secret,
            @Nullable Map<String, String> ExtraProvisionSettings,
            @Nullable PostCreateAppActions PostCreate) {
        return CompletableFuture.supplyAsync(
                () ->
                        this.DeployTemplate(
                                TemplateID,
                                NewUsername,
                                NewPassword,
                                NewEmail,
                                RequiredTags,
                                Tag,
                                FriendlyName,
                                Secret,
                                ExtraProvisionSettings,
                                PostCreate));
    }

    /**
     * Name Description
     *
     * @param Id
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> DetachTarget(UUID Id) {
        Map<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/DetachTarget", args, type);
    }

    /**
     * Name Description
     *
     * @param Id
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> DetachTargetAsync(UUID Id) {
        return CompletableFuture.supplyAsync(() -> this.DetachTarget(Id));
    }

    /**
     * Name Description
     *
     * @param SourceArchive
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> ExtractEverywhere(String SourceArchive) {
        Map<String, Object> args = new HashMap<>();
        args.put("SourceArchive", SourceArchive);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/ExtractEverywhere", args, type);
    }

    /**
     * Name Description
     *
     * @param SourceArchive
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> ExtractEverywhereAsync(
            String SourceArchive) {
        return CompletableFuture.supplyAsync(() -> this.ExtractEverywhere(SourceArchive));
    }

    /**
     * Name Description
     *
     * @param instanceId
     * @return List&lt;EndpointInfo&gt;
     */
    public Result<List<EndpointInfo>, AMPError> GetApplicationEndpoints(UUID instanceId) {
        Map<String, Object> args = new HashMap<>();
        args.put("instanceId", instanceId);
        Type type = new TypeToken<List<EndpointInfo>>() {}.getType();
        return this.APICall("ADSModule/GetApplicationEndpoints", args, type);
    }

    /**
     * Name Description
     *
     * @param instanceId
     * @return List&lt;EndpointInfo&gt;
     */
    public CompletionStage<Result<List<EndpointInfo>, AMPError>> GetApplicationEndpointsAsync(
            UUID instanceId) {
        return CompletableFuture.supplyAsync(() -> this.GetApplicationEndpoints(instanceId));
    }

    /**
     * Name Description
     *
     * @param id
     * @return InstanceDatastore
     */
    public Result<InstanceDatastore, AMPError> GetDatastore(Integer id) {
        Map<String, Object> args = new HashMap<>();
        args.put("id", id);
        Type type = new TypeToken<InstanceDatastore>() {}.getType();
        return this.APICall("ADSModule/GetDatastore", args, type);
    }

    /**
     * Name Description
     *
     * @param id
     * @return InstanceDatastore
     */
    public CompletionStage<Result<InstanceDatastore, AMPError>> GetDatastoreAsync(Integer id) {
        return CompletableFuture.supplyAsync(() -> this.GetDatastore(id));
    }

    /**
     * Name Description
     *
     * @param datastoreId
     * @return List&lt;InstanceSummary&gt;
     */
    public Result<List<InstanceSummary>, AMPError> GetDatastoreInstances(Integer datastoreId) {
        Map<String, Object> args = new HashMap<>();
        args.put("datastoreId", datastoreId);
        Type type = new TypeToken<List<InstanceSummary>>() {}.getType();
        return this.APICall("ADSModule/GetDatastoreInstances", args, type);
    }

    /**
     * Name Description
     *
     * @param datastoreId
     * @return List&lt;InstanceSummary&gt;
     */
    public CompletionStage<Result<List<InstanceSummary>, AMPError>> GetDatastoreInstancesAsync(
            Integer datastoreId) {
        return CompletableFuture.supplyAsync(() -> this.GetDatastoreInstances(datastoreId));
    }

    /**
     * Name Description
     *
     * @return List&lt;InstanceDatastore&gt;
     */
    public Result<List<InstanceDatastore>, AMPError> GetDatastores() {
        Type type = new TypeToken<List<InstanceDatastore>>() {}.getType();
        return this.APICall("ADSModule/GetDatastores", type);
    }

    /**
     * Name Description
     *
     * @return List&lt;InstanceDatastore&gt;
     */
    public CompletionStage<Result<List<InstanceDatastore>, AMPError>> GetDatastoresAsync() {
        return CompletableFuture.supplyAsync(() -> this.GetDatastores());
    }

    /**
     * Name Description
     *
     * @return List&lt;DeploymentTemplate&gt;
     */
    public Result<List<DeploymentTemplate>, AMPError> GetDeploymentTemplates() {
        Type type = new TypeToken<List<DeploymentTemplate>>() {}.getType();
        return this.APICall("ADSModule/GetDeploymentTemplates", type);
    }

    /**
     * Name Description
     *
     * @return List&lt;DeploymentTemplate&gt;
     */
    public CompletionStage<Result<List<DeploymentTemplate>, AMPError>>
            GetDeploymentTemplatesAsync() {
        return CompletableFuture.supplyAsync(() -> this.GetDeploymentTemplates());
    }

    /**
     * Name Description
     *
     * @param GroupId
     * @return IADSInstance
     */
    public Result<IADSInstance, AMPError> GetGroup(UUID GroupId) {
        Map<String, Object> args = new HashMap<>();
        args.put("GroupId", GroupId);
        Type type = new TypeToken<IADSInstance>() {}.getType();
        return this.APICall("ADSModule/GetGroup", args, type);
    }

    /**
     * Name Description
     *
     * @param GroupId
     * @return IADSInstance
     */
    public CompletionStage<Result<IADSInstance, AMPError>> GetGroupAsync(UUID GroupId) {
        return CompletableFuture.supplyAsync(() -> this.GetGroup(GroupId));
    }

    /**
     * Name Description
     *
     * @param InstanceId
     * @return InstanceSummary
     */
    public Result<InstanceSummary, AMPError> GetInstance(UUID InstanceId) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        Type type = new TypeToken<InstanceSummary>() {}.getType();
        return this.APICall("ADSModule/GetInstance", args, type);
    }

    /**
     * Name Description
     *
     * @param InstanceId
     * @return InstanceSummary
     */
    public CompletionStage<Result<InstanceSummary, AMPError>> GetInstanceAsync(UUID InstanceId) {
        return CompletableFuture.supplyAsync(() -> this.GetInstance(InstanceId));
    }

    /**
     * Name Description
     *
     * @param InstanceName
     * @return List&lt;PortUsage&gt;
     */
    public Result<List<PortUsage>, AMPError> GetInstanceNetworkInfo(String InstanceName) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        Type type = new TypeToken<List<PortUsage>>() {}.getType();
        return this.APICall("ADSModule/GetInstanceNetworkInfo", args, type);
    }

    /**
     * Name Description
     *
     * @param InstanceName
     * @return List&lt;PortUsage&gt;
     */
    public CompletionStage<Result<List<PortUsage>, AMPError>> GetInstanceNetworkInfoAsync(
            String InstanceName) {
        return CompletableFuture.supplyAsync(() -> this.GetInstanceNetworkInfo(InstanceName));
    }

    /**
     * Name Description
     *
     * @return List&lt;InstanceStatus&gt;
     */
    public Result<List<InstanceStatus>, AMPError> GetInstanceStatuses() {
        Type type = new TypeToken<List<InstanceStatus>>() {}.getType();
        return this.APICall("ADSModule/GetInstanceStatuses", type);
    }

    /**
     * Name Description
     *
     * @return List&lt;InstanceStatus&gt;
     */
    public CompletionStage<Result<List<InstanceStatus>, AMPError>> GetInstanceStatusesAsync() {
        return CompletableFuture.supplyAsync(() -> this.GetInstanceStatuses());
    }

    /**
     * Name Description
     *
     * @param ForceIncludeSelf
     * @return List&lt;IADSInstance&gt;
     */
    public Result<List<IADSInstance>, AMPError> GetInstances(@Nullable Boolean ForceIncludeSelf) {
        Map<String, Object> args = new HashMap<>();
        args.put("ForceIncludeSelf", ForceIncludeSelf);
        Type type = new TypeToken<List<IADSInstance>>() {}.getType();
        return this.APICall("ADSModule/GetInstances", args, type);
    }

    /**
     * Name Description
     *
     * @param ForceIncludeSelf
     * @return List&lt;IADSInstance&gt;
     */
    public CompletionStage<Result<List<IADSInstance>, AMPError>> GetInstancesAsync(
            @Nullable Boolean ForceIncludeSelf) {
        return CompletableFuture.supplyAsync(() -> this.GetInstances(ForceIncludeSelf));
    }

    /**
     * Name Description
     *
     * @return List&lt;InstanceSummary&gt;
     */
    public Result<List<InstanceSummary>, AMPError> GetLocalInstances() {
        Type type = new TypeToken<List<InstanceSummary>>() {}.getType();
        return this.APICall("ADSModule/GetLocalInstances", type);
    }

    /**
     * Name Description
     *
     * @return List&lt;InstanceSummary&gt;
     */
    public CompletionStage<Result<List<InstanceSummary>, AMPError>> GetLocalInstancesAsync() {
        return CompletableFuture.supplyAsync(() -> this.GetLocalInstances());
    }

    /**
     * Name Description
     *
     * @param ModuleName
     * @return List&lt;ProvisionSettingInfo&gt;
     */
    public Result<List<ProvisionSettingInfo>, AMPError> GetProvisionArguments(String ModuleName) {
        Map<String, Object> args = new HashMap<>();
        args.put("ModuleName", ModuleName);
        Type type = new TypeToken<List<ProvisionSettingInfo>>() {}.getType();
        return this.APICall("ADSModule/GetProvisionArguments", args, type);
    }

    /**
     * Name Description
     *
     * @param ModuleName
     * @return List&lt;ProvisionSettingInfo&gt;
     */
    public CompletionStage<Result<List<ProvisionSettingInfo>, AMPError>> GetProvisionArgumentsAsync(
            String ModuleName) {
        return CompletableFuture.supplyAsync(() -> this.GetProvisionArguments(ModuleName));
    }

    /**
     * Name Description
     *
     * @return ProvisionFitness
     */
    public Result<ProvisionFitness, AMPError> GetProvisionFitness() {
        Type type = new TypeToken<ProvisionFitness>() {}.getType();
        return this.APICall("ADSModule/GetProvisionFitness", type);
    }

    /**
     * Name Description
     *
     * @return ProvisionFitness
     */
    public CompletionStage<Result<ProvisionFitness, AMPError>> GetProvisionFitnessAsync() {
        return CompletableFuture.supplyAsync(() -> this.GetProvisionFitness());
    }

    /**
     * Name Description
     *
     * @return List&lt;ApplicationSpecSummary&gt;
     */
    public Result<List<ApplicationSpecSummary>, AMPError> GetSupportedAppSummaries() {
        Type type = new TypeToken<List<ApplicationSpecSummary>>() {}.getType();
        return this.APICall("ADSModule/GetSupportedAppSummaries", type);
    }

    /**
     * Name Description
     *
     * @return List&lt;ApplicationSpecSummary&gt;
     */
    public CompletionStage<Result<List<ApplicationSpecSummary>, AMPError>>
            GetSupportedAppSummariesAsync() {
        return CompletableFuture.supplyAsync(() -> this.GetSupportedAppSummaries());
    }

    /**
     * Name Description
     *
     * @return List&lt;ApplicationSpec&gt;
     */
    public Result<List<ApplicationSpec>, AMPError> GetSupportedApplications() {
        Type type = new TypeToken<List<ApplicationSpec>>() {}.getType();
        return this.APICall("ADSModule/GetSupportedApplications", type);
    }

    /**
     * Name Description
     *
     * @return List&lt;ApplicationSpec&gt;
     */
    public CompletionStage<Result<List<ApplicationSpec>, AMPError>>
            GetSupportedApplicationsAsync() {
        return CompletableFuture.supplyAsync(() -> this.GetSupportedApplications());
    }

    /**
     * Name Description
     *
     * @return RemoteTargetInfo
     */
    public Result<RemoteTargetInfo, AMPError> GetTargetInfo() {
        Type type = new TypeToken<RemoteTargetInfo>() {}.getType();
        return this.APICall("ADSModule/GetTargetInfo", type);
    }

    /**
     * Name Description
     *
     * @return RemoteTargetInfo
     */
    public CompletionStage<Result<RemoteTargetInfo, AMPError>> GetTargetInfoAsync() {
        return CompletableFuture.supplyAsync(() -> this.GetTargetInfo());
    }

    /**
     * Name Description
     *
     * @return ActionResult&lt;String&gt;
     */
    public Result<ActionResult<String>, AMPError> GetTargetPairingCode() {
        Type type = new TypeToken<ActionResult<String>>() {}.getType();
        return this.APICall("ADSModule/GetTargetPairingCode", type);
    }

    /**
     * Name Description
     *
     * @return ActionResult&lt;String&gt;
     */
    public CompletionStage<Result<ActionResult<String>, AMPError>> GetTargetPairingCodeAsync() {
        return CompletableFuture.supplyAsync(() -> this.GetTargetPairingCode());
    }

    /**
     * Name Description
     *
     * @param ForModule
     * @param SettingNode
     * @param Values
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> HandoutInstanceConfigs(
            String ForModule, String SettingNode, List<String> Values) {
        Map<String, Object> args = new HashMap<>();
        args.put("ForModule", ForModule);
        args.put("SettingNode", SettingNode);
        args.put("Values", Values);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/HandoutInstanceConfigs", args, type);
    }

    /**
     * Name Description
     *
     * @param ForModule
     * @param SettingNode
     * @param Values
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> HandoutInstanceConfigsAsync(
            String ForModule, String SettingNode, List<String> Values) {
        return CompletableFuture.supplyAsync(
                () -> this.HandoutInstanceConfigs(ForModule, SettingNode, Values));
    }

    /**
     * Name Description
     *
     * @param InstanceId
     * @return ActionResult&lt;String&gt;
     */
    public Result<ActionResult<String>, AMPError> ManageInstance(UUID InstanceId) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        Type type = new TypeToken<ActionResult<String>>() {}.getType();
        return this.APICall("ADSModule/ManageInstance", args, type);
    }

    /**
     * Name Description
     *
     * @param InstanceId
     * @return ActionResult&lt;String&gt;
     */
    public CompletionStage<Result<ActionResult<String>, AMPError>> ManageInstanceAsync(
            UUID InstanceId) {
        return CompletableFuture.supplyAsync(() -> this.ManageInstance(InstanceId));
    }

    /**
     * Name Description
     *
     * @param instanceId
     * @param PortNumber
     * @param Range
     * @param Protocol
     * @param Description
     * @param Open
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> ModifyCustomFirewallRule(
            UUID instanceId,
            Integer PortNumber,
            Integer Range,
            PortProtocol Protocol,
            String Description,
            Boolean Open) {
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
     * Name Description
     *
     * @param instanceId
     * @param PortNumber
     * @param Range
     * @param Protocol
     * @param Description
     * @param Open
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> ModifyCustomFirewallRuleAsync(
            UUID instanceId,
            Integer PortNumber,
            Integer Range,
            PortProtocol Protocol,
            String Description,
            Boolean Open) {
        return CompletableFuture.supplyAsync(
                () ->
                        this.ModifyCustomFirewallRule(
                                instanceId, PortNumber, Range, Protocol, Description, Open));
    }

    /**
     * Name Description
     *
     * @param instanceId
     * @param datastoreId
     * @return RunningTask
     */
    public Result<RunningTask, AMPError> MoveInstanceDatastore(
            UUID instanceId, Integer datastoreId) {
        Map<String, Object> args = new HashMap<>();
        args.put("instanceId", instanceId);
        args.put("datastoreId", datastoreId);
        Type type = new TypeToken<RunningTask>() {}.getType();
        return this.APICall("ADSModule/MoveInstanceDatastore", args, type);
    }

    /**
     * Name Description
     *
     * @param instanceId
     * @param datastoreId
     * @return RunningTask
     */
    public CompletionStage<Result<RunningTask, AMPError>> MoveInstanceDatastoreAsync(
            UUID instanceId, Integer datastoreId) {
        return CompletableFuture.supplyAsync(
                () -> this.MoveInstanceDatastore(instanceId, datastoreId));
    }

    /**
     * Name Description
     *
     * @param instanceId
     * @return RunningTask
     */
    public Result<RunningTask, AMPError> ReactivateInstance(UUID instanceId) {
        Map<String, Object> args = new HashMap<>();
        args.put("instanceId", instanceId);
        Type type = new TypeToken<RunningTask>() {}.getType();
        return this.APICall("ADSModule/ReactivateInstance", args, type);
    }

    /**
     * Name Description
     *
     * @param instanceId
     * @return RunningTask
     */
    public CompletionStage<Result<RunningTask, AMPError>> ReactivateInstanceAsync(UUID instanceId) {
        return CompletableFuture.supplyAsync(() -> this.ReactivateInstance(instanceId));
    }

    /**
     * Name Description
     *
     * @return RunningTask
     */
    public Result<RunningTask, AMPError> ReactivateLocalInstances() {
        Type type = new TypeToken<RunningTask>() {}.getType();
        return this.APICall("ADSModule/ReactivateLocalInstances", type);
    }

    /**
     * Name Description
     *
     * @return RunningTask
     */
    public CompletionStage<Result<RunningTask, AMPError>> ReactivateLocalInstancesAsync() {
        return CompletableFuture.supplyAsync(() -> this.ReactivateLocalInstances());
    }

    /**
     * Name Description
     *
     * @return Void
     */
    public Result<Void, AMPError> RefreshAppCache() {
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("ADSModule/RefreshAppCache", type);
    }

    /**
     * Name Description
     *
     * @return Void
     */
    public CompletionStage<Result<Void, AMPError>> RefreshAppCacheAsync() {
        return CompletableFuture.supplyAsync(() -> this.RefreshAppCache());
    }

    /**
     * Name Description
     *
     * @param GroupId
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> RefreshGroup(UUID GroupId) {
        Map<String, Object> args = new HashMap<>();
        args.put("GroupId", GroupId);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/RefreshGroup", args, type);
    }

    /**
     * Name Description
     *
     * @param GroupId
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> RefreshGroupAsync(UUID GroupId) {
        return CompletableFuture.supplyAsync(() -> this.RefreshGroup(GroupId));
    }

    /**
     * Name Description
     *
     * @param InstanceId
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> RefreshInstanceConfig(String InstanceId) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/RefreshInstanceConfig", args, type);
    }

    /**
     * Name Description
     *
     * @param InstanceId
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> RefreshInstanceConfigAsync(
            String InstanceId) {
        return CompletableFuture.supplyAsync(() -> this.RefreshInstanceConfig(InstanceId));
    }

    /**
     * Name Description
     *
     * @param force
     * @return Void
     */
    public Result<Void, AMPError> RefreshRemoteConfigStores(@Nullable Boolean force) {
        Map<String, Object> args = new HashMap<>();
        args.put("force", force);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("ADSModule/RefreshRemoteConfigStores", args, type);
    }

    /**
     * Name Description
     *
     * @param force
     * @return Void
     */
    public CompletionStage<Result<Void, AMPError>> RefreshRemoteConfigStoresAsync(
            @Nullable Boolean force) {
        return CompletableFuture.supplyAsync(() -> this.RefreshRemoteConfigStores(force));
    }

    /**
     * Name Description
     *
     * @param controllerUrl
     * @param myUrl
     * @param username
     * @param password
     * @param twoFactorToken
     * @param friendlyName
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> RegisterTarget(
            String controllerUrl,
            String myUrl,
            String username,
            String password,
            String twoFactorToken,
            String friendlyName) {
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
     * Name Description
     *
     * @param controllerUrl
     * @param myUrl
     * @param username
     * @param password
     * @param twoFactorToken
     * @param friendlyName
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> RegisterTargetAsync(
            String controllerUrl,
            String myUrl,
            String username,
            String password,
            String twoFactorToken,
            String friendlyName) {
        return CompletableFuture.supplyAsync(
                () ->
                        this.RegisterTarget(
                                controllerUrl,
                                myUrl,
                                username,
                                password,
                                twoFactorToken,
                                friendlyName));
    }

    /**
     * Name Description
     *
     * @param controllerUrl
     * @param myUrl
     * @param code
     * @param friendlyName
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> RegisterTargetWithCode(
            String controllerUrl, String myUrl, String code, String friendlyName) {
        Map<String, Object> args = new HashMap<>();
        args.put("controllerUrl", controllerUrl);
        args.put("myUrl", myUrl);
        args.put("code", code);
        args.put("friendlyName", friendlyName);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/RegisterTargetWithCode", args, type);
    }

    /**
     * Name Description
     *
     * @param controllerUrl
     * @param myUrl
     * @param code
     * @param friendlyName
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> RegisterTargetWithCodeAsync(
            String controllerUrl, String myUrl, String code, String friendlyName) {
        return CompletableFuture.supplyAsync(
                () -> this.RegisterTargetWithCode(controllerUrl, myUrl, code, friendlyName));
    }

    /**
     * Name Description
     *
     * @param id
     * @return RunningTask
     */
    public Result<RunningTask, AMPError> RepairDatastore(Integer id) {
        Map<String, Object> args = new HashMap<>();
        args.put("id", id);
        Type type = new TypeToken<RunningTask>() {}.getType();
        return this.APICall("ADSModule/RepairDatastore", args, type);
    }

    /**
     * Name Description
     *
     * @param id
     * @return RunningTask
     */
    public CompletionStage<Result<RunningTask, AMPError>> RepairDatastoreAsync(Integer id) {
        return CompletableFuture.supplyAsync(() -> this.RepairDatastore(id));
    }

    /**
     * Name Description
     *
     * @param datastoreId
     * @return RunningTask
     */
    public Result<RunningTask, AMPError> RequestDatastoreSizeCalculation(Integer datastoreId) {
        Map<String, Object> args = new HashMap<>();
        args.put("datastoreId", datastoreId);
        Type type = new TypeToken<RunningTask>() {}.getType();
        return this.APICall("ADSModule/RequestDatastoreSizeCalculation", args, type);
    }

    /**
     * Name Description
     *
     * @param datastoreId
     * @return RunningTask
     */
    public CompletionStage<Result<RunningTask, AMPError>> RequestDatastoreSizeCalculationAsync(
            Integer datastoreId) {
        return CompletableFuture.supplyAsync(
                () -> this.RequestDatastoreSizeCalculation(datastoreId));
    }

    /**
     * Name Description
     *
     * @param InstanceName
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> RestartInstance(String InstanceName) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/RestartInstance", args, type);
    }

    /**
     * Name Description
     *
     * @param InstanceName
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> RestartInstanceAsync(
            String InstanceName) {
        return CompletableFuture.supplyAsync(() -> this.RestartInstance(InstanceName));
    }

    /**
     * Name Description
     *
     * @param Data
     * @param RealIP
     * @return Map&lt;String, Object&gt;
     */
    public Result<Map<String, Object>, AMPError> Servers(
            Map<String, Object> Data, InetAddress RealIP) {
        Map<String, Object> args = new HashMap<>();
        args.put("Data", Data);
        args.put("RealIP", RealIP);
        Type type = new TypeToken<Map<String, Object>>() {}.getType();
        return this.APICall("ADSModule/Servers", args, type);
    }

    /**
     * Name Description
     *
     * @param Data
     * @param RealIP
     * @return Map&lt;String, Object&gt;
     */
    public CompletionStage<Result<Map<String, Object>, AMPError>> ServersAsync(
            Map<String, Object> Data, InetAddress RealIP) {
        return CompletableFuture.supplyAsync(() -> this.Servers(Data, RealIP));
    }

    /**
     * Name Description
     *
     * @param InstanceName
     * @param SettingNode
     * @param Value
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> SetInstanceConfig(
            String InstanceName, String SettingNode, String Value) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        args.put("SettingNode", SettingNode);
        args.put("Value", Value);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/SetInstanceConfig", args, type);
    }

    /**
     * Name Description
     *
     * @param InstanceName
     * @param SettingNode
     * @param Value
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> SetInstanceConfigAsync(
            String InstanceName, String SettingNode, String Value) {
        return CompletableFuture.supplyAsync(
                () -> this.SetInstanceConfig(InstanceName, SettingNode, Value));
    }

    /**
     * Name Description
     *
     * @param InstanceId
     * @param PortMappings
     * @param ApplicationIP
     * @param mustStop
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> SetInstanceNetworkInfo(
            UUID InstanceId,
            Map<String, Integer> PortMappings,
            @Nullable String ApplicationIP,
            @Nullable Boolean mustStop) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        args.put("PortMappings", PortMappings);
        args.put("ApplicationIP", ApplicationIP);
        args.put("mustStop", mustStop);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/SetInstanceNetworkInfo", args, type);
    }

    /**
     * Name Description
     *
     * @param InstanceId
     * @param PortMappings
     * @param ApplicationIP
     * @param mustStop
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> SetInstanceNetworkInfoAsync(
            UUID InstanceId,
            Map<String, Integer> PortMappings,
            @Nullable String ApplicationIP,
            @Nullable Boolean mustStop) {
        return CompletableFuture.supplyAsync(
                () ->
                        this.SetInstanceNetworkInfo(
                                InstanceId, PortMappings, ApplicationIP, mustStop));
    }

    /**
     * Name Description
     *
     * @param InstanceName
     * @param Suspended
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> SetInstanceSuspended(
            String InstanceName, Boolean Suspended) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        args.put("Suspended", Suspended);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/SetInstanceSuspended", args, type);
    }

    /**
     * Name Description
     *
     * @param InstanceName
     * @param Suspended
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> SetInstanceSuspendedAsync(
            String InstanceName, Boolean Suspended) {
        return CompletableFuture.supplyAsync(
                () -> this.SetInstanceSuspended(InstanceName, Suspended));
    }

    /**
     * Name Description
     *
     * @param TargetADSInstance
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> StartAllInstances(UUID TargetADSInstance) {
        Map<String, Object> args = new HashMap<>();
        args.put("TargetADSInstance", TargetADSInstance);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/StartAllInstances", args, type);
    }

    /**
     * Name Description
     *
     * @param TargetADSInstance
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> StartAllInstancesAsync(
            UUID TargetADSInstance) {
        return CompletableFuture.supplyAsync(() -> this.StartAllInstances(TargetADSInstance));
    }

    /**
     * Name Description
     *
     * @param InstanceName
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> StartInstance(String InstanceName) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/StartInstance", args, type);
    }

    /**
     * Name Description
     *
     * @param InstanceName
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> StartInstanceAsync(String InstanceName) {
        return CompletableFuture.supplyAsync(() -> this.StartInstance(InstanceName));
    }

    /**
     * Name Description
     *
     * @param TargetADSInstance
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> StopAllInstances(UUID TargetADSInstance) {
        Map<String, Object> args = new HashMap<>();
        args.put("TargetADSInstance", TargetADSInstance);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/StopAllInstances", args, type);
    }

    /**
     * Name Description
     *
     * @param TargetADSInstance
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> StopAllInstancesAsync(
            UUID TargetADSInstance) {
        return CompletableFuture.supplyAsync(() -> this.StopAllInstances(TargetADSInstance));
    }

    /**
     * Name Description
     *
     * @param InstanceName
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> StopInstance(String InstanceName) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/StopInstance", args, type);
    }

    /**
     * Name Description
     *
     * @param InstanceName
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> StopInstanceAsync(String InstanceName) {
        return CompletableFuture.supplyAsync(() -> this.StopInstance(InstanceName));
    }

    /**
     * Name Description
     *
     * @param updatedDatastore
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> UpdateDatastore(InstanceDatastore updatedDatastore) {
        Map<String, Object> args = new HashMap<>();
        args.put("updatedDatastore", updatedDatastore);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/UpdateDatastore", args, type);
    }

    /**
     * Name Description
     *
     * @param updatedDatastore
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> UpdateDatastoreAsync(
            InstanceDatastore updatedDatastore) {
        return CompletableFuture.supplyAsync(() -> this.UpdateDatastore(updatedDatastore));
    }

    /**
     * Name Description
     *
     * @param templateToUpdate
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> UpdateDeploymentTemplate(
            DeploymentTemplate templateToUpdate) {
        Map<String, Object> args = new HashMap<>();
        args.put("templateToUpdate", templateToUpdate);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/UpdateDeploymentTemplate", args, type);
    }

    /**
     * Name Description
     *
     * @param templateToUpdate
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> UpdateDeploymentTemplateAsync(
            DeploymentTemplate templateToUpdate) {
        return CompletableFuture.supplyAsync(() -> this.UpdateDeploymentTemplate(templateToUpdate));
    }

    /**
     * Name Description
     *
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
     * @param DisplayGroup
     * @param CustomMountBindings
     * @param ExtraContainerPackages
     * @param IsMultiIPAware
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> UpdateInstanceInfo(
            String InstanceId,
            String FriendlyName,
            String Description,
            Boolean StartOnBoot,
            Boolean Suspended,
            Boolean ExcludeFromFirewall,
            Boolean RunInContainer,
            Integer ContainerMemory,
            ContainerMemoryPolicy MemoryPolicy,
            Float ContainerMaxCPU,
            String ContainerImage,
            Integer ContainerSwap,
            @Nullable String WelcomeMessage,
            @Nullable String DisplayGroup,
            @Nullable Map<String, String> CustomMountBindings,
            @Nullable List<String> ExtraContainerPackages,
            @Nullable Boolean IsMultiIPAware) {
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
        args.put("DisplayGroup", DisplayGroup);
        args.put("CustomMountBindings", CustomMountBindings);
        args.put("ExtraContainerPackages", ExtraContainerPackages);
        args.put("IsMultiIPAware", IsMultiIPAware);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/UpdateInstanceInfo", args, type);
    }

    /**
     * Name Description
     *
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
     * @param DisplayGroup
     * @param CustomMountBindings
     * @param ExtraContainerPackages
     * @param IsMultiIPAware
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> UpdateInstanceInfoAsync(
            String InstanceId,
            String FriendlyName,
            String Description,
            Boolean StartOnBoot,
            Boolean Suspended,
            Boolean ExcludeFromFirewall,
            Boolean RunInContainer,
            Integer ContainerMemory,
            ContainerMemoryPolicy MemoryPolicy,
            Float ContainerMaxCPU,
            String ContainerImage,
            Integer ContainerSwap,
            @Nullable String WelcomeMessage,
            @Nullable String DisplayGroup,
            @Nullable Map<String, String> CustomMountBindings,
            @Nullable List<String> ExtraContainerPackages,
            @Nullable Boolean IsMultiIPAware) {
        return CompletableFuture.supplyAsync(
                () ->
                        this.UpdateInstanceInfo(
                                InstanceId,
                                FriendlyName,
                                Description,
                                StartOnBoot,
                                Suspended,
                                ExcludeFromFirewall,
                                RunInContainer,
                                ContainerMemory,
                                MemoryPolicy,
                                ContainerMaxCPU,
                                ContainerImage,
                                ContainerSwap,
                                WelcomeMessage,
                                DisplayGroup,
                                CustomMountBindings,
                                ExtraContainerPackages,
                                IsMultiIPAware));
    }

    /**
     * Name Description
     *
     * @param TargetID
     * @return Void
     */
    public Result<Void, AMPError> UpdateTarget(UUID TargetID) {
        Map<String, Object> args = new HashMap<>();
        args.put("TargetID", TargetID);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("ADSModule/UpdateTarget", args, type);
    }

    /**
     * Name Description
     *
     * @param TargetID
     * @return Void
     */
    public CompletionStage<Result<Void, AMPError>> UpdateTargetAsync(UUID TargetID) {
        return CompletableFuture.supplyAsync(() -> this.UpdateTarget(TargetID));
    }

    /**
     * Name Description
     *
     * @param Id
     * @param FriendlyName
     * @param Url
     * @param Description
     * @param Tags
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> UpdateTargetInfo(
            UUID Id, String FriendlyName, URI Url, String Description, List<String> Tags) {
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
     * Name Description
     *
     * @param Id
     * @param FriendlyName
     * @param Url
     * @param Description
     * @param Tags
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> UpdateTargetInfoAsync(
            UUID Id, String FriendlyName, URI Url, String Description, List<String> Tags) {
        return CompletableFuture.supplyAsync(
                () -> this.UpdateTargetInfo(Id, FriendlyName, Url, Description, Tags));
    }

    /**
     * Name Description
     *
     * @param RestartRunning
     * @param TargetADSInstance
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> UpgradeAllInstances(
            Boolean RestartRunning, UUID TargetADSInstance) {
        Map<String, Object> args = new HashMap<>();
        args.put("RestartRunning", RestartRunning);
        args.put("TargetADSInstance", TargetADSInstance);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/UpgradeAllInstances", args, type);
    }

    /**
     * Name Description
     *
     * @param RestartRunning
     * @param TargetADSInstance
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> UpgradeAllInstancesAsync(
            Boolean RestartRunning, UUID TargetADSInstance) {
        return CompletableFuture.supplyAsync(
                () -> this.UpgradeAllInstances(RestartRunning, TargetADSInstance));
    }

    /**
     * Name Description
     *
     * @param InstanceName
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> UpgradeInstance(String InstanceName) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("ADSModule/UpgradeInstance", args, type);
    }

    /**
     * Name Description
     *
     * @param InstanceName
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> UpgradeInstanceAsync(
            String InstanceName) {
        return CompletableFuture.supplyAsync(() -> this.UpgradeInstance(InstanceName));
    }
}
