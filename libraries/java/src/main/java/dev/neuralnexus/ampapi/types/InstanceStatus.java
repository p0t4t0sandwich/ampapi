package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * An instance status object
 * @param InstanceID The instance ID
 * @param Running Whether the instance is running
 */
public record InstanceStatus(UUID InstanceID, Boolean Running) {}
