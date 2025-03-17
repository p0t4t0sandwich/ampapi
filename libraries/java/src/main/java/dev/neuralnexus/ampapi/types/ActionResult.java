package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * Generic response type for calls that return a result and a reason for failure
 * @param Reason Reason for failure
 * @param Status true if successful, false if not
 * @param SupportTitle Support title
 * @param SupportURL Support URL
 * @param Result Result of the call
 */
public record ActionResult<T>(String Reason, Boolean Status, String SupportTitle, String SupportURL, Optional<T> Result) {}
