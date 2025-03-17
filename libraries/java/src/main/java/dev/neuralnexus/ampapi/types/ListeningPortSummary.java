package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * A listening port object
 * @param IsDelayedOpen Whether the port is delayed open
 * @param Listening Whether the port is listening
 * @param Name The name
 * @param Port The port
 * @param Protocol The protocol
 * @param Required Whether the port is required
 */
public record ListeningPortSummary(Boolean IsDelayedOpen, Boolean Listening, String Name, Integer Port, PortProtocol Protocol, Boolean Required) {}
