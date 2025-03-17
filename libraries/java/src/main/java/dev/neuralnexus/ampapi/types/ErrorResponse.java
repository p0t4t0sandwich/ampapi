package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * An error object
 * @param Message The error message
 * @param StackTrace The stack trace of the error
 * @param Title The title of the error
 */
public record ErrorResponse(String Message, String StackTrace, String Title) {}
