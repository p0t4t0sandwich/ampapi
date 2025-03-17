package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * Type for Core.GetUpdates#ConsoleEntries
 * @param Contents The contents of the console entry
 * @param Source The source of the console entry
 * @param SourceId The ID of the message's source, eg from a player/user
 * @param Timestamp The timestamp of the console entry
 * @param Type The type of the console entry
 */
public record ConsoleEntry(String Contents, String Source, String SourceId, String Timestamp, String Type) {}
