package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * A summary of an authenticated role
 * @param Description The description
 * @param DisableEdits Whether edits are disabled
 * @param Hidden Whether the role is hidden
 * @param ID The ID
 * @param IsCommonRole Whether the role is common
 * @param IsDefault Whether the role is default
 * @param IsInstanceSpecific Whether the role is instance specific
 * @param Members The members
 * @param Name The name
 * @param Permissions The permissions
 */
public record AuthRoleSummary(String Description, Boolean DisableEdits, Boolean Hidden, UUID ID, Boolean IsCommonRole, Boolean IsDefault, Boolean IsInstanceSpecific, List<AuthUserSummary> Members, String Name, List<String> Permissions) {}
