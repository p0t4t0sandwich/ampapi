package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * A file directory object
 * @param Created The creation date
 * @param Filename The filename
 * @param IsArchive Whether the file is an archive
 * @param IsDirectory Whether the file is a directory
 * @param IsDownloadable Whether the file is downloadable
 * @param IsEditable Whether the file is editable
 * @param IsExcludedFromBackups Whether the file is excluded from backups
 * @param IsVirtualDirectory Whether the file is a virtual directory
 * @param Modified The modification date
 * @param SizeBytes The size in bytes
 */
public record DirectoryListing(String Created, String Filename, Boolean IsArchive, Boolean IsDirectory, Boolean IsDownloadable, Boolean IsEditable, Boolean IsExcludedFromBackups, Boolean IsVirtualDirectory, String Modified, Integer SizeBytes) {}
