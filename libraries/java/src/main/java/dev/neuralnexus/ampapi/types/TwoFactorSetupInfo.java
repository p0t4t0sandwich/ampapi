package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * Information about two-factor setup
 * @param ManualKey The manual key
 * @param Url The URL
 */
public record TwoFactorSetupInfo(String ManualKey, String Url) {}
