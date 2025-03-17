/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

/**
 * A file directory object
 *
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
public record DirectoryListing(
        String Created,
        String Filename,
        Boolean IsArchive,
        Boolean IsDirectory,
        Boolean IsDownloadable,
        Boolean IsEditable,
        Boolean IsExcludedFromBackups,
        Boolean IsVirtualDirectory,
        String Modified,
        Integer SizeBytes) {}
