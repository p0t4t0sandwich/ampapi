/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

/**
 * Type for Core.GetUpdates#ConsoleEntries
 *
 * @param Contents The contents of the console entry
 * @param Source The source of the console entry
 * @param SourceId The ID of the message's source, eg from a player/user
 * @param Timestamp The timestamp of the console entry
 * @param Type The type of the console entry
 */
public record ConsoleEntry(
        String Contents, String Source, String SourceId, String Timestamp, String Type) {}
