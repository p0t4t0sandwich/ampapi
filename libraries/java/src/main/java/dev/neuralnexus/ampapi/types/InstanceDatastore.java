/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

import java.util.List;

/**
 * A datastore object
 *
 * @param Active Whether the datastore is active
 * @param CurrentUsageMB The current usage in MB
 * @param Description The description
 * @param Directory The directory
 * @param FriendlyName The friendly name
 * @param Id The datastore ID
 * @param InstanceLimit The instance limit
 * @param IsInternal Whether the datastore is internal
 * @param Priority The priority
 * @param SanitisedName The sanitised name
 * @param SoftLimitMB The soft limit in MB
 * @param Tags The tags
 */
public record InstanceDatastore(
        Boolean Active,
        Integer CurrentUsageMB,
        String Description,
        String Directory,
        String FriendlyName,
        Integer Id,
        Integer InstanceLimit,
        Boolean IsInternal,
        Integer Priority,
        String SanitisedName,
        Integer SoftLimitMB,
        List<String> Tags) {}
