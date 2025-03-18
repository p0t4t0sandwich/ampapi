/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.plugins;

import com.github.sviperll.result4j.Result;
import com.google.gson.reflect.TypeToken;

import dev.neuralnexus.ampapi.AMPAPI;
import dev.neuralnexus.ampapi.auth.AuthProvider;
import dev.neuralnexus.ampapi.AMPError;
import dev.neuralnexus.ampapi.types.*;

import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Type;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class FileManagerPlugin extends AMPAPI {
    public FileManagerPlugin(AuthProvider authprovider) {
        super(authprovider);
    }

    /**
     * Name Description
     *
     * @param Filename
     * @param Data
     * @param Delete
     * @return Void
     */
    public Result<Void, AMPError> AppendFileChunk(String Filename, String Data, Boolean Delete) {
        Map<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("Data", Data);
        args.put("Delete", Delete);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("FileManagerPlugin/AppendFileChunk", args, type);
    }

    /**
     * Name Description
     *
     * @param FilePath
     * @return ActionResult&lt;String&gt;
     */
    public Result<ActionResult<String>, AMPError> CalculateFileMD5Sum(String FilePath) {
        Map<String, Object> args = new HashMap<>();
        args.put("FilePath", FilePath);
        Type type = new TypeToken<ActionResult<String>>() {}.getType();
        return this.APICall("FileManagerPlugin/CalculateFileMD5Sum", args, type);
    }

    /**
     * Name Description
     *
     * @param ModifyPath
     * @param AsDirectory
     * @param Exclude
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> ChangeExclusion(
            String ModifyPath, Boolean AsDirectory, Boolean Exclude) {
        Map<String, Object> args = new HashMap<>();
        args.put("ModifyPath", ModifyPath);
        args.put("AsDirectory", AsDirectory);
        args.put("Exclude", Exclude);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("FileManagerPlugin/ChangeExclusion", args, type);
    }

    /**
     * Name Description
     *
     * @param Origin
     * @param TargetDirectory
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> CopyFile(String Origin, String TargetDirectory) {
        Map<String, Object> args = new HashMap<>();
        args.put("Origin", Origin);
        args.put("TargetDirectory", TargetDirectory);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("FileManagerPlugin/CopyFile", args, type);
    }

    /**
     * Name Description
     *
     * @param PathToArchive
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> CreateArchive(String PathToArchive) {
        Map<String, Object> args = new HashMap<>();
        args.put("PathToArchive", PathToArchive);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("FileManagerPlugin/CreateArchive", args, type);
    }

    /**
     * Creates a new directory. The parent directory must already exist. Name Description
     *
     * @param NewPath
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> CreateDirectory(String NewPath) {
        Map<String, Object> args = new HashMap<>();
        args.put("NewPath", NewPath);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("FileManagerPlugin/CreateDirectory", args, type);
    }

    /**
     * Name Description
     *
     * @param Source
     * @param TargetDirectory
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> DownloadFileFromURL(URI Source, String TargetDirectory) {
        Map<String, Object> args = new HashMap<>();
        args.put("Source", Source);
        args.put("TargetDirectory", TargetDirectory);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("FileManagerPlugin/DownloadFileFromURL", args, type);
    }

    /**
     * Name Description
     *
     * @return Void
     */
    public Result<Void, AMPError> Dummy() {
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("FileManagerPlugin/Dummy", type);
    }

    /**
     * Empties a trash bin Name Description
     *
     * @param TrashDirectoryName
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> EmptyTrash(String TrashDirectoryName) {
        Map<String, Object> args = new HashMap<>();
        args.put("TrashDirectoryName", TrashDirectoryName);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("FileManagerPlugin/EmptyTrash", args, type);
    }

    /**
     * Name Description
     *
     * @param ArchivePath
     * @param DestinationPath
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> ExtractArchive(
            String ArchivePath, @Nullable String DestinationPath) {
        Map<String, Object> args = new HashMap<>();
        args.put("ArchivePath", ArchivePath);
        args.put("DestinationPath", DestinationPath);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("FileManagerPlugin/ExtractArchive", args, type);
    }

    /**
     * Name Description
     *
     * @param Dir
     * @return List&lt;DirectoryListing&gt;
     */
    public Result<List<DirectoryListing>, AMPError> GetDirectoryListing(String Dir) {
        Map<String, Object> args = new HashMap<>();
        args.put("Dir", Dir);
        Type type = new TypeToken<List<DirectoryListing>>() {}.getType();
        return this.APICall("FileManagerPlugin/GetDirectoryListing", args, type);
    }

    /**
     * Name Description
     *
     * @param Filename
     * @param Position
     * @param Length
     * @return FileChunkData
     */
    public Result<FileChunkData, AMPError> GetFileChunk(
            String Filename, Integer Position, Integer Length) {
        Map<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("Position", Position);
        args.put("Length", Length);
        Type type = new TypeToken<FileChunkData>() {}.getType();
        return this.APICall("FileManagerPlugin/GetFileChunk", args, type);
    }

    /**
     * Name Description
     *
     * @param Filename
     * @param Offset
     * @param ChunkSize
     * @return ActionResult&lt;String&gt;
     */
    public Result<ActionResult<String>, AMPError> ReadFileChunk(
            String Filename, Integer Offset, @Nullable Integer ChunkSize) {
        Map<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("Offset", Offset);
        args.put("ChunkSize", ChunkSize);
        Type type = new TypeToken<ActionResult<String>>() {}.getType();
        return this.APICall("FileManagerPlugin/ReadFileChunk", args, type);
    }

    /**
     * Name Description
     *
     * @param Filename
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> ReleaseFileUploadLock(String Filename) {
        Map<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("FileManagerPlugin/ReleaseFileUploadLock", args, type);
    }

    /**
     * Renames a directory Name Description
     *
     * @param oldDirectory The full path to the old directory
     * @param NewDirectoryName The name component of the new directory (not the full path)
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> RenameDirectory(
            String oldDirectory, String NewDirectoryName) {
        Map<String, Object> args = new HashMap<>();
        args.put("oldDirectory", oldDirectory);
        args.put("NewDirectoryName", NewDirectoryName);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("FileManagerPlugin/RenameDirectory", args, type);
    }

    /**
     * Name Description
     *
     * @param Filename
     * @param NewFilename
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> RenameFile(String Filename, String NewFilename) {
        Map<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("NewFilename", NewFilename);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("FileManagerPlugin/RenameFile", args, type);
    }

    /**
     * Moves a directory to trash, files must be trashed before they can be deleted. Name
     * Description
     *
     * @param DirectoryName
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> TrashDirectory(String DirectoryName) {
        Map<String, Object> args = new HashMap<>();
        args.put("DirectoryName", DirectoryName);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("FileManagerPlugin/TrashDirectory", args, type);
    }

    /**
     * Moves a file to trash, files must be trashed before they can be deleted. Name Description
     *
     * @param Filename
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> TrashFile(String Filename) {
        Map<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("FileManagerPlugin/TrashFile", args, type);
    }

    /**
     * Name Description
     *
     * @param Filename
     * @param Data
     * @param Offset
     * @param FinalChunk
     * @return ActionResult
     */
    public Result<ActionResult, AMPError> WriteFileChunk(
            String Filename, String Data, Integer Offset, Boolean FinalChunk) {
        Map<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("Data", Data);
        args.put("Offset", Offset);
        args.put("FinalChunk", FinalChunk);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("FileManagerPlugin/WriteFileChunk", args, type);
    }
}
