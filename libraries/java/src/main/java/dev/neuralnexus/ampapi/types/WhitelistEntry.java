package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * A whitelist entry
 * @param Name The name
 * @param UUID The UUID
 */
public record WhitelistEntry(String Name, String UUID) {}
