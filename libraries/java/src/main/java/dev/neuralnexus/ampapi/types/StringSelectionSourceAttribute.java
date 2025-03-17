package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * A string selection source object
 * @param Deferred Whether the selection source is deferred
 * @param MustValidate Whether the selection source must validate
 */
public record StringSelectionSourceAttribute(Boolean Deferred, Boolean MustValidate) {}
