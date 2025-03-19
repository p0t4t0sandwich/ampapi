/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

import java.util.UUID;

/**
 * A summary of an authenticated user
 *
 * @param ID The ID
 * @param Name The name
 */
public record AuthUserSummary(UUID ID, String Name) {}
