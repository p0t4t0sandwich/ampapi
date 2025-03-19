/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

/**
 * An application endpoint object
 *
 * @param DisplayName The display name of the endpoint
 * @param Endpoint The endpoint address
 * @param Uri The URI of the endpoint
 */
public record EndpointInfo(String DisplayName, String Endpoint, String Uri) {}
