package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * Type for API.Core.GetUpdates#Messages[i] (along with WS keep alive)
 * @param AgeMinutes The age of the message in minutes
 * @param Expired Whether the message has expired
 * @param Id The message ID
 * @param Message The message
 * @param Source The source of the message
 */
public record PushedMessage(Integer AgeMinutes, Boolean Expired, UUID Id, String Message, String Source) {}
