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

public final class FileManagerPlugin extends AMPAPI {
    public FileManagerPlugin(AuthProvider authprovider) {
        super(authprovider);
    }

    /**
     * Name Description Optional
     * @param Filename 
     * @param Data 
     * @param Delete 
     * @return Void
     */
    public Void AppendFileChunk(String Filename, String Data, Boolean Delete) {
        Map<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("Data", Data);
        args.put("Delete", Delete);
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("FileManagerPlugin/AppendFileChunk", args, type);
    }

    /**
     * Name Description Optional
     * @param FilePath 
     * @return ActionResult<String>
     */
    public ActionResult<String> CalculateFileMD5Sum(String FilePath) {
        Map<String, Object> args = new HashMap<>();
        args.put("FilePath", FilePath);
        Type type = new TypeToken<ActionResult<String>>() {}.getType();
        return this.APICall("FileManagerPlugin/CalculateFileMD5Sum", args, type);
    }

    /**
     * Name Description Optional
     * @param ModifyPath 
     * @param AsDirectory 
     * @param Exclude 
     * @return ActionResult
     */
    public ActionResult ChangeExclusion(String ModifyPath, Boolean AsDirectory, Boolean Exclude) {
        Map<String, Object> args = new HashMap<>();
        args.put("ModifyPath", ModifyPath);
        args.put("AsDirectory", AsDirectory);
        args.put("Exclude", Exclude);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("FileManagerPlugin/ChangeExclusion", args, type);
    }

    /**
     * Name Description Optional
     * @param Origin 
     * @param TargetDirectory 
     * @return ActionResult
     */
    public ActionResult CopyFile(String Origin, String TargetDirectory) {
        Map<String, Object> args = new HashMap<>();
        args.put("Origin", Origin);
        args.put("TargetDirectory", TargetDirectory);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("FileManagerPlugin/CopyFile", args, type);
    }

    /**
     * Name Description Optional
     * @param PathToArchive 
     * @return ActionResult
     */
    public ActionResult CreateArchive(String PathToArchive) {
        Map<String, Object> args = new HashMap<>();
        args.put("PathToArchive", PathToArchive);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("FileManagerPlugin/CreateArchive", args, type);
    }

    /**Creates a new directory. The parent directory must already exist.
     * Name Description Optional
     * @param NewPath 
     * @return ActionResult
     */
    public ActionResult CreateDirectory(String NewPath) {
        Map<String, Object> args = new HashMap<>();
        args.put("NewPath", NewPath);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("FileManagerPlugin/CreateDirectory", args, type);
    }

    /**
     * Name Description Optional
     * @param Source 
     * @param TargetDirectory 
     * @return ActionResult
     */
    public ActionResult DownloadFileFromURL(URI Source, String TargetDirectory) {
        Map<String, Object> args = new HashMap<>();
        args.put("Source", Source);
        args.put("TargetDirectory", TargetDirectory);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("FileManagerPlugin/DownloadFileFromURL", args, type);
    }

    /**
     * Name Description Optional

     * @return Void
     */
    public Void Dummy() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>() {}.getType();
        return this.APICall("FileManagerPlugin/Dummy", args, type);
    }

    /**Empties a trash bin
     * Name Description Optional
     * @param TrashDirectoryName 
     * @return ActionResult
     */
    public ActionResult EmptyTrash(String TrashDirectoryName) {
        Map<String, Object> args = new HashMap<>();
        args.put("TrashDirectoryName", TrashDirectoryName);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("FileManagerPlugin/EmptyTrash", args, type);
    }

    /**
     * Name Description Optional
     * @param ArchivePath 
     * @param DestinationPath 
     * @return ActionResult
     */
    public ActionResult ExtractArchive(String ArchivePath, @Nullable String DestinationPath) {
        Map<String, Object> args = new HashMap<>();
        args.put("ArchivePath", ArchivePath);
        args.put("DestinationPath", DestinationPath);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("FileManagerPlugin/ExtractArchive", args, type);
    }

    /**
     * Name Description Optional
     * @param Dir 
     * @return List<DirectoryListing>
     */
    public List<DirectoryListing> GetDirectoryListing(String Dir) {
        Map<String, Object> args = new HashMap<>();
        args.put("Dir", Dir);
        Type type = new TypeToken<List<DirectoryListing>>() {}.getType();
        return this.APICall("FileManagerPlugin/GetDirectoryListing", args, type);
    }

    /**
     * Name Description Optional
     * @param Filename 
     * @param Position 
     * @param Length 
     * @return FileChunkData
     */
    public FileChunkData GetFileChunk(String Filename, Integer Position, Integer Length) {
        Map<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("Position", Position);
        args.put("Length", Length);
        Type type = new TypeToken<FileChunkData>() {}.getType();
        return this.APICall("FileManagerPlugin/GetFileChunk", args, type);
    }

    /**
     * Name Description Optional
     * @param Filename 
     * @param Offset 
     * @param ChunkSize 
     * @return ActionResult<String>
     */
    public ActionResult<String> ReadFileChunk(String Filename, Integer Offset, @Nullable Integer ChunkSize) {
        Map<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("Offset", Offset);
        args.put("ChunkSize", ChunkSize);
        Type type = new TypeToken<ActionResult<String>>() {}.getType();
        return this.APICall("FileManagerPlugin/ReadFileChunk", args, type);
    }

    /**
     * Name Description Optional
     * @param Filename 
     * @return ActionResult
     */
    public ActionResult ReleaseFileUploadLock(String Filename) {
        Map<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("FileManagerPlugin/ReleaseFileUploadLock", args, type);
    }

    /**Renames a directory
     * Name Description Optional
     * @param oldDirectory The full path to the old directory
     * @param NewDirectoryName The name component of the new directory (not the full path)
     * @return ActionResult
     */
    public ActionResult RenameDirectory(String oldDirectory, String NewDirectoryName) {
        Map<String, Object> args = new HashMap<>();
        args.put("oldDirectory", oldDirectory);
        args.put("NewDirectoryName", NewDirectoryName);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("FileManagerPlugin/RenameDirectory", args, type);
    }

    /**
     * Name Description Optional
     * @param Filename 
     * @param NewFilename 
     * @return ActionResult
     */
    public ActionResult RenameFile(String Filename, String NewFilename) {
        Map<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("NewFilename", NewFilename);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("FileManagerPlugin/RenameFile", args, type);
    }

    /**Moves a directory to trash, files must be trashed before they can be deleted.
     * Name Description Optional
     * @param DirectoryName 
     * @return ActionResult
     */
    public ActionResult TrashDirectory(String DirectoryName) {
        Map<String, Object> args = new HashMap<>();
        args.put("DirectoryName", DirectoryName);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("FileManagerPlugin/TrashDirectory", args, type);
    }

    /**Moves a file to trash, files must be trashed before they can be deleted.
     * Name Description Optional
     * @param Filename 
     * @return ActionResult
     */
    public ActionResult TrashFile(String Filename) {
        Map<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("FileManagerPlugin/TrashFile", args, type);
    }

    /**
     * Name Description Optional
     * @param Filename 
     * @param Data 
     * @param Offset 
     * @param FinalChunk 
     * @return ActionResult
     */
    public ActionResult WriteFileChunk(String Filename, String Data, Integer Offset, Boolean FinalChunk) {
        Map<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("Data", Data);
        args.put("Offset", Offset);
        args.put("FinalChunk", FinalChunk);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return this.APICall("FileManagerPlugin/WriteFileChunk", args, type);
    }


}