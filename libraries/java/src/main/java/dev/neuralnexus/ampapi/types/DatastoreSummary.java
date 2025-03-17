package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * A datastore object
 * @param FriendlyName The friendly name
 * @param Id The datastore ID
 */
public record DatastoreSummary(String FriendlyName, Integer Id) {}
