package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * An audit log entry
 * @param Category The category
 * @param Id The ID
 * @param Message The message
 * @param Source The source
 * @param Timestamp The timestamp
 * @param User The user
 */
public record IAuditLogEntry(String Category, Integer Id, String Message, String Source, String Timestamp, String User) {}
