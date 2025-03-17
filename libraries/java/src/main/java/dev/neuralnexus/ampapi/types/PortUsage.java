/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

/**
 * A port usage object
 *
 * @param Description The description
 * @param IsUserDefined Whether the port is user-defined
 * @param PortNumber The port number
 * @param Protocol The protocol
 * @param ProvisionNodeName The provision node name
 * @param Range The range
 * @param Verified Whether the port is verified
 */
public record PortUsage(
        String Description,
        Boolean IsUserDefined,
        Integer PortNumber,
        PortProtocol Protocol,
        String ProvisionNodeName,
        Integer Range,
        Boolean Verified) {}
