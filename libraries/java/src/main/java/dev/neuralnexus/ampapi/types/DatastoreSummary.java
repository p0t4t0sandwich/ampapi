/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

/**
 * A datastore object
 *
 * @param FriendlyName The friendly name
 * @param Id The datastore ID
 */
public record DatastoreSummary(String FriendlyName, Integer Id) {}
