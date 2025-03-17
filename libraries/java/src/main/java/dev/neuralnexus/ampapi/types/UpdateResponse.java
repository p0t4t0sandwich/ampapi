/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

import java.util.List;

/**
 * Response type for Core.GetUpdates
 *
 * @param ConsoleEntries The console entries of the server
 * @param Messages The messages of the server
 * @param Ports The ports of the server
 * @param Status The status of the server
 * @param Tasks The tasks of the server
 */
public record UpdateResponse(
        List<ConsoleEntry> ConsoleEntries,
        List<PushedMessage> Messages,
        List<ListeningPortSummary> Ports,
        StatusResponse Status,
        List<RunningTask> Tasks) {}
