/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * An ADS instance object
 *
 * @param AvailableIPs Available IPs
 * @param AvailableInstances Available instances
 * @param CanCreate Whether the instance can be created
 * @param CreatesInContainers Whether the instance creates in containers
 * @param Datastores The datastores
 * @param Description The description
 * @param Disabled Whether the instance is disabled
 * @param FriendlyName The friendly name
 * @param Id The ID
 * @param InstanceId The instance ID
 * @param IsRemote Whether the instance is remote
 * @param LastUpdated The last updated date
 * @param Platform The platform information object
 * @param State The state
 * @param StateReason The state reason
 * @param Tags The tags
 * @param TagsList The tags list
 * @param URL The URL
 * @param Fitness The fitness information object
 */
public record IADSInstance(
        List<String> AvailableIPs,
        List<InstanceSummary> AvailableInstances,
        Boolean CanCreate,
        Boolean CreatesInContainers,
        List<DatastoreSummary> Datastores,
        String Description,
        Boolean Disabled,
        String FriendlyName,
        Integer Id,
        UUID InstanceId,
        Boolean IsRemote,
        String LastUpdated,
        IPlatformInfo Platform,
        RemoteInstanceState State,
        String StateReason,
        List<String> Tags,
        String TagsList,
        String URL,
        Optional<ProvisionFitness> Fitness) {}
