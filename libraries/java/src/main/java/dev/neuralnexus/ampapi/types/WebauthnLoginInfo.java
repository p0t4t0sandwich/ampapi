/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

import java.util.List;

/**
 * Information about a WebAuthn callback
 *
 * @param Challenge The challenge
 * @param Ids The IDs
 */
public record WebauthnLoginInfo(String Challenge, List<String> Ids) {}
