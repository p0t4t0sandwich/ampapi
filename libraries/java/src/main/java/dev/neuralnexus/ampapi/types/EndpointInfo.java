package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * An application endpoint object
 * @param DisplayName The display name of the endpoint
 * @param Endpoint The endpoint address
 * @param Uri The URI of the endpoint
 */
public record EndpointInfo(String DisplayName, String Endpoint, String Uri) {}
