package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * Response type for Core.GetUpdates
 * @param ConsoleEntries The console entries of the server
 * @param Messages The messages of the server
 * @param Ports The ports of the server
 * @param Status The status of the server
 * @param Tasks The tasks of the server
 */
public record UpdateResponse(List<ConsoleEntry> ConsoleEntries, List<PushedMessage> Messages, List<ListeningPortSummary> Ports, StatusResponse Status, List<RunningTask> Tasks) {}
