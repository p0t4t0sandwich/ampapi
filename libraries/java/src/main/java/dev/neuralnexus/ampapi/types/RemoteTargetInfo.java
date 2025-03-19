/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

import java.util.List;

/**
 * Information about a remote target, returned by ADSModule#GetTargetInfo()
 *
 * @param Datastores The datastores
 * @param DeploysInContainers Whether the target deploys in containers
 * @param IPAddressList The IP address list
 * @param PlatformInfo The remote target's platform info
 */
public record RemoteTargetInfo(
        List<DatastoreSummary> Datastores,
        Boolean DeploysInContainers,
        List<String> IPAddressList,
        IPlatformInfo PlatformInfo) {}
