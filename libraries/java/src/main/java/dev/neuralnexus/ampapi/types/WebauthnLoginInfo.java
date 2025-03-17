package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * Information about a WebAuthn login
 * @param Challenge The challenge
 * @param Ids The IDs
 */
public record WebauthnLoginInfo(String Challenge, List<String> Ids) {}
