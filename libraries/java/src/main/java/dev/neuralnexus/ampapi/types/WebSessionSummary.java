package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * A summary of a web session
 * @param LastActivity The last activity
 * @param SessionID The session ID
 * @param SessionType The session type
 * @param Source The source
 * @param StartTime The start time
 * @param Username The username
 */
public record WebSessionSummary(String LastActivity, String SessionID, String SessionType, String Source, String StartTime, String Username) {}
