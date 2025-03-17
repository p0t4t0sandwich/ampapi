/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

/**
 * A struct to represent the object returned by the Core.GetUpdateInfo() method
 *
 * @param Build The build of the update
 * @param PatchOnly Whether the update is a patch
 * @param ReleaseNotesURL The URL to the release notes
 * @param ToolsVersion The version of the tools
 * @param UpdateAvailable Whether an update is available
 * @param Version The version of the update
 */
public record UpdateInfo(
        String Build,
        Boolean PatchOnly,
        String ReleaseNotesURL,
        String ToolsVersion,
        Boolean UpdateAvailable,
        String Version) {}
