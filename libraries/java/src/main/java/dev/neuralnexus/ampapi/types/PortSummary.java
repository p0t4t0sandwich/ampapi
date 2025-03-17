package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * A port object
 * @param IsDelayedOpen Whether the port is delayed open
 * @param Name The name
 * @param Port The port
 * @param Protocol The protocol
 * @param Required Whether the port is required
 */
public record PortSummary(Boolean IsDelayedOpen, String Name, Integer Port, PortProtocol Protocol, Boolean Required) {}
