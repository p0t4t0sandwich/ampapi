package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * A port usage object
 * @param Description The description
 * @param IsUserDefined Whether the port is user-defined
 * @param PortNumber The port number
 * @param Protocol The protocol
 * @param ProvisionNodeName The provision node name
 * @param Range The range
 * @param Verified Whether the port is verified
 */
public record PortUsage(String Description, Boolean IsUserDefined, Integer PortNumber, PortProtocol Protocol, String ProvisionNodeName, Integer Range, Boolean Verified) {}
