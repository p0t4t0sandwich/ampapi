/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

import java.util.UUID;

/**
 * Type for API.Core.GetUpdates#Messages[i] (along with WS keep alive)
 *
 * @param AgeMinutes The age of the message in minutes
 * @param Expired Whether the message has expired
 * @param Id The message ID
 * @param Message The message
 * @param Source The source of the message
 */
public record PushedMessage(
        Integer AgeMinutes, Boolean Expired, UUID Id, String Message, String Source) {}
