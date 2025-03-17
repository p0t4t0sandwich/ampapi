package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * A summary of a WebAuthn credential
 * @param CreatedUTC The created time
 * @param Description The description
 * @param ID The ID
 * @param LastUsedUTC The last used time
 */
public record WebauthnCredentialSummary(String CreatedUTC, String Description, Integer ID, String LastUsedUTC) {}
