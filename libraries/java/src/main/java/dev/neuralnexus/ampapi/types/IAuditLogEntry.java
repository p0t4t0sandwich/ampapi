/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

/**
 * An audit log entry
 *
 * @param Category The category
 * @param Id The ID
 * @param Message The message
 * @param Source The source
 * @param Timestamp The timestamp
 * @param User The user
 */
public record IAuditLogEntry(
        String Category,
        Integer Id,
        String Message,
        String Source,
        String Timestamp,
        String User) {}
