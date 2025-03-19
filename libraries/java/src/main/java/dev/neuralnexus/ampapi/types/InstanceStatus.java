/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

import java.util.UUID;

/**
 * An instance status object
 *
 * @param InstanceID The instance ID
 * @param Running Whether the instance is running
 */
public record InstanceStatus(UUID InstanceID, Boolean Running) {}
