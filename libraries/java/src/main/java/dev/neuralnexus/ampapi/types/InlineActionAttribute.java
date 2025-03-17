package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * An inline action object
 * @param Argument The argument
 * @param Caption The caption
 * @param IsClientSide Whether the action is client-side
 * @param Method The method
 * @param Module The module
 */
public record InlineActionAttribute(String Argument, String Caption, Boolean IsClientSide, String Method, String Module) {}
