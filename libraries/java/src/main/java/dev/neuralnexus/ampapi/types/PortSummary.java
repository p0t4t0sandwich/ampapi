/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

/**
 * A port object
 *
 * @param IsDelayedOpen Whether the port is delayed open
 * @param Name The name
 * @param Port The port
 * @param Protocol The protocol
 * @param Required Whether the port is required
 */
public record PortSummary(
        Boolean IsDelayedOpen,
        String Name,
        Integer Port,
        PortProtocol Protocol,
        Boolean Required) {}
