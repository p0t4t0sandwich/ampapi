package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * A security check result
 * @param Description The description
 * @param Hidden Whether the check is hidden
 * @param Pass Whether the check passed
 * @param Resolution The resolution
 * @param Severity The severity
 * @param Title The title
 */
public record SecurityCheckResult(String Description, Boolean Hidden, Boolean Pass, String Resolution, Integer Severity, String Title) {}
