/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

import java.util.List;
import java.util.UUID;

/**
 * A simple user object
 *
 * @param IPAddress The IP address
 * @param Id The ID
 * @param JoinTime The join time
 * @param Name The name
 * @param Port The port
 * @param SessionID The session ID
 * @param Tags The tags
 * @param TimeLoggedIn The time logged in
 * @param UID The UID
 * @param UserSessionId The user session ID
 */
public record SimpleUser(
        String IPAddress,
        String Id,
        String JoinTime,
        String Name,
        Integer Port,
        String SessionID,
        List<String> Tags,
        String TimeLoggedIn,
        String UID,
        UUID UserSessionId) {}
