/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

/**
 * A summary of a web session
 *
 * @param LastActivity The last activity
 * @param SessionID The session ID
 * @param SessionType The session type
 * @param Source The source
 * @param StartTime The start time
 * @param Username The username
 */
public record WebSessionSummary(
        String LastActivity,
        String SessionID,
        String SessionType,
        String Source,
        String StartTime,
        String Username) {}
