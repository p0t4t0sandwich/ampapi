package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * Information about a remote target, returned by ADSModule#GetTargetInfo()
 * @param Datastores The datastores
 * @param DeploysInContainers Whether the target deploys in containers
 * @param IPAddressList The IP address list
 * @param PlatformInfo The remote target's platform info
 */
public record RemoteTargetInfo(List<DatastoreSummary> Datastores, Boolean DeploysInContainers, List<String> IPAddressList, IPlatformInfo PlatformInfo) {}
