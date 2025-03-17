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

public final class LocalFileBackupPlugin extends AMPAPI {
    public LocalFileBackupPlugin(AuthProvider authprovider) {
        super(authprovider);
    }

    /**
     * Name Description Optional
     * @param BackupId 
     * @return ActionResult
     */
    public ActionResult DeleteFromS3(UUID BackupId) {
        Map<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("LocalFileBackupPlugin/DeleteFromS3", args, type);
    }

    /**
     * Name Description Optional
     * @param BackupId 
     * @return Void
     */
    public Void DeleteLocalBackup(UUID BackupId) {
        Map<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("LocalFileBackupPlugin/DeleteLocalBackup", args, type);
    }

    /**
     * Name Description Optional
     * @param BackupId 
     * @return RunningTask
     */
    public RunningTask DownloadFromS3(UUID BackupId) {
        Map<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        Type type = new TypeToken<RunningTask>() {}.getType();
        return this.APICall("LocalFileBackupPlugin/DownloadFromS3", args, type);
    }

    /**
     * Name Description Optional

     * @return List<BackupManifest>
     */
    public List<BackupManifest> GetBackups() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<BackupManifest>>() {}.getType();
        return this.APICall("LocalFileBackupPlugin/GetBackups", args, type);
    }

    /**
     * Name Description Optional

     * @return Void
     */
    public Void RefreshBackupList() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("LocalFileBackupPlugin/RefreshBackupList", args, type);
    }

    /**
     * Name Description Optional
     * @param BackupId 
     * @param DeleteExistingData 
     * @return ActionResult
     */
    public ActionResult RestoreBackup(UUID BackupId, @Nullable Boolean DeleteExistingData) {
        Map<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        args.put("DeleteExistingData", DeleteExistingData);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("LocalFileBackupPlugin/RestoreBackup", args, type);
    }

    /**
     * Name Description Optional
     * @param BackupId 
     * @param Sticky 
     * @return Void
     */
    public Void SetBackupSticky(UUID BackupId, Boolean Sticky) {
        Map<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        args.put("Sticky", Sticky);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("LocalFileBackupPlugin/SetBackupSticky", args, type);
    }

    /**
     * Name Description Optional
     * @param Title 
     * @param Description 
     * @param Sticky 
     * @param WasCreatedAutomatically 
     * @return ActionResult
     */
    public ActionResult TakeBackup(String Title, String Description, Boolean Sticky, @Nullable Boolean WasCreatedAutomatically) {
        Map<String, Object> args = new HashMap<>();
        args.put("Title", Title);
        args.put("Description", Description);
        args.put("Sticky", Sticky);
        args.put("WasCreatedAutomatically", WasCreatedAutomatically);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("LocalFileBackupPlugin/TakeBackup", args, type);
    }

    /**
     * Name Description Optional
     * @param BackupId 
     * @return RunningTask
     */
    public RunningTask UploadToS3(UUID BackupId) {
        Map<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        Type type = new TypeToken<RunningTask>() {}.getType();
        return this.APICall("LocalFileBackupPlugin/UploadToS3", args, type);
    }


}