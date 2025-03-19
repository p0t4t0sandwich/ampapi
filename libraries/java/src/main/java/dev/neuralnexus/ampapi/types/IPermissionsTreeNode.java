/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

import java.util.List;

/**
 * A permissions tree node
 *
 * @param Children The children
 * @param Description The description
 * @param DisplayName The display name
 * @param Name The name
 * @param Node The node
 */
public record IPermissionsTreeNode(
        List<IPermissionsTreeNode> Children,
        String Description,
        String DisplayName,
        String Name,
        String Node) {}
