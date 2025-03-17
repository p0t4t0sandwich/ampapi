package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * User access data
 * @param OPList The OP list
 * @param Whitelist The whitelist
 */
public record UserAccessData(List<OPEntry> OPList, List<WhitelistEntry> Whitelist) {}
