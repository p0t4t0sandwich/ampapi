/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

/**
 * A string selection source object
 *
 * @param Deferred Whether the selection source is deferred
 * @param MustValidate Whether the selection source must validate
 */
public record StringSelectionSourceAttribute(Boolean Deferred, Boolean MustValidate) {}
