package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * A struct to represent the object returned by the Core.GetUpdateInfo() method
 * @param Build The build of the update
 * @param PatchOnly Whether the update is a patch
 * @param ReleaseNotesURL The URL to the release notes
 * @param ToolsVersion The version of the tools
 * @param UpdateAvailable Whether an update is available
 * @param Version The version of the update
 */
public record UpdateInfo(String Build, Boolean PatchOnly, String ReleaseNotesURL, String ToolsVersion, Boolean UpdateAvailable, String Version) {}
