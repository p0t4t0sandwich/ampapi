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

public final class LocalFileBackupPlugin extends AMPAPI {
    public LocalFileBackupPlugin(AuthProvider authprovider) {
        super(authprovider);
    }

    /**
     * Name Description
     *
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
     * Name Description
     *
     * @param BackupId
     */
    public void DeleteLocalBackup(UUID BackupId) {
        Map<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        this.APICall("LocalFileBackupPlugin/DeleteLocalBackup", args);
    }

    /**
     * Name Description
     *
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
     * Name Description
     *
     * @return List&lt;BackupManifest&gt;
     */
    public List<BackupManifest> GetBackups() {
        Type type = new TypeToken<List<BackupManifest>>() {}.getType();
        return this.APICall("LocalFileBackupPlugin/GetBackups", type);
    }

    /** Name Description */
    public void RefreshBackupList() {
        this.APICall("LocalFileBackupPlugin/RefreshBackupList");
    }

    /**
     * Name Description
     *
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
     * Name Description
     *
     * @param BackupId
     * @param Sticky
     */
    public void SetBackupSticky(UUID BackupId, Boolean Sticky) {
        Map<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        args.put("Sticky", Sticky);
        this.APICall("LocalFileBackupPlugin/SetBackupSticky", args);
    }

    /**
     * Name Description
     *
     * @param Title
     * @param Description
     * @param Sticky
     * @param WasCreatedAutomatically
     * @return ActionResult
     */
    public ActionResult TakeBackup(
            String Title,
            String Description,
            Boolean Sticky,
            @Nullable Boolean WasCreatedAutomatically) {
        Map<String, Object> args = new HashMap<>();
        args.put("Title", Title);
        args.put("Description", Description);
        args.put("Sticky", Sticky);
        args.put("WasCreatedAutomatically", WasCreatedAutomatically);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("LocalFileBackupPlugin/TakeBackup", args, type);
    }

    /**
     * Name Description
     *
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
