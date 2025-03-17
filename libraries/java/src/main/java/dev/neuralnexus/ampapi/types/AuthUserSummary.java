package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * A summary of an authenticated user
 * @param ID The ID
 * @param Name The name
 */
public record AuthUserSummary(UUID ID, String Name) {}
