package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * A permissions tree node
 * @param Children The children
 * @param Description The description
 * @param DisplayName The display name
 * @param Name The name
 * @param Node The node
 */
public record IPermissionsTreeNode(List<IPermissionsTreeNode> Children, String Description, String DisplayName, String Name, String Node) {}
