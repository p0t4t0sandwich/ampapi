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
    public Result<ActionResult, AMPError> DeleteFromS3(UUID BackupId) {
        Map<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("LocalFileBackupPlugin/DeleteFromS3", args, type);
    }

    /**
     * Name Description
     *
     * @param BackupId
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> DeleteFromS3Async(UUID BackupId) {
        return CompletableFuture.supplyAsync(() -> this.DeleteFromS3(BackupId));
    }

    /**
     * Name Description
     *
     * @param BackupId
     * @return Void
     */
    public Result<Void, AMPError> DeleteLocalBackup(UUID BackupId) {
        Map<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("LocalFileBackupPlugin/DeleteLocalBackup", args, type);
    }

    /**
     * Name Description
     *
     * @param BackupId
     * @return Void
     */
    public CompletionStage<Result<Void, AMPError>> DeleteLocalBackupAsync(UUID BackupId) {
        return CompletableFuture.supplyAsync(() -> this.DeleteLocalBackup(BackupId));
    }

    /**
     * Name Description
     *
     * @param BackupId
     * @return RunningTask
     */
    public Result<RunningTask, AMPError> DownloadFromS3(UUID BackupId) {
        Map<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        Type type = new TypeToken<RunningTask>() {}.getType();
        return this.APICall("LocalFileBackupPlugin/DownloadFromS3", args, type);
    }

    /**
     * Name Description
     *
     * @param BackupId
     * @return RunningTask
     */
    public CompletionStage<Result<RunningTask, AMPError>> DownloadFromS3Async(UUID BackupId) {
        return CompletableFuture.supplyAsync(() -> this.DownloadFromS3(BackupId));
    }

    /**
     * Name Description
     *
     * @return List&lt;BackupManifest&gt;
     */
    public Result<List<BackupManifest>, AMPError> GetBackups() {
        Type type = new TypeToken<List<BackupManifest>>() {}.getType();
        return this.APICall("LocalFileBackupPlugin/GetBackups", type);
    }

    /**
     * Name Description
     *
     * @return List&lt;BackupManifest&gt;
     */
    public CompletionStage<Result<List<BackupManifest>, AMPError>> GetBackupsAsync() {
        return CompletableFuture.supplyAsync(() -> this.GetBackups());
    }

    /**
     * Name Description
     *
     * @return Void
     */
    public Result<Void, AMPError> RefreshBackupList() {
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("LocalFileBackupPlugin/RefreshBackupList", type);
    }

    /**
     * Name Description
     *
     * @return Void
     */
    public CompletionStage<Result<Void, AMPError>> RefreshBackupListAsync() {
        return CompletableFuture.supplyAsync(() -> this.RefreshBackupList());
    }

    /**
     * Name Description
     *
     * @param BackupId
     * @param DeleteExistingData
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> RestoreBackup(
            UUID BackupId, @Nullable Boolean DeleteExistingData) {
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
     * @param DeleteExistingData
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> RestoreBackupAsync(
            UUID BackupId, @Nullable Boolean DeleteExistingData) {
        return CompletableFuture.supplyAsync(
                () -> this.RestoreBackup(BackupId, DeleteExistingData));
    }

    /**
     * Name Description
     *
     * @param BackupId
     * @param Sticky
     * @return Void
     */
    public Result<Void, AMPError> SetBackupSticky(UUID BackupId, Boolean Sticky) {
        Map<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        args.put("Sticky", Sticky);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("LocalFileBackupPlugin/SetBackupSticky", args, type);
    }

    /**
     * Name Description
     *
     * @param BackupId
     * @param Sticky
     * @return Void
     */
    public CompletionStage<Result<Void, AMPError>> SetBackupStickyAsync(
            UUID BackupId, Boolean Sticky) {
        return CompletableFuture.supplyAsync(() -> this.SetBackupSticky(BackupId, Sticky));
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
    public Result<ActionResult, AMPError> TakeBackup(
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
     * @param Title
     * @param Description
     * @param Sticky
     * @param WasCreatedAutomatically
     * @return ActionResult
     */
    public CompletionStage<Result<ActionResult, AMPError>> TakeBackupAsync(
            String Title,
            String Description,
            Boolean Sticky,
            @Nullable Boolean WasCreatedAutomatically) {
        return CompletableFuture.supplyAsync(
                () -> this.TakeBackup(Title, Description, Sticky, WasCreatedAutomatically));
    }

    /**
     * Name Description
     *
     * @param BackupId
     * @return RunningTask
     */
    public Result<RunningTask, AMPError> UploadToS3(UUID BackupId) {
        Map<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        Type type = new TypeToken<RunningTask>() {}.getType();
        return this.APICall("LocalFileBackupPlugin/UploadToS3", args, type);
    }

    /**
     * Name Description
     *
     * @param BackupId
     * @return RunningTask
     */
    public CompletionStage<Result<RunningTask, AMPError>> UploadToS3Async(UUID BackupId) {
        return CompletableFuture.supplyAsync(() -> this.UploadToS3(BackupId));
    }
}
