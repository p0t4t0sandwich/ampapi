/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

/**
 * Information about two-factor setup
 *
 * @param ManualKey The manual key
 * @param Url The URL
 */
public record TwoFactorSetupInfo(String ManualKey, String Url) {}
