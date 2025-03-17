package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * A simple user object
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
public record SimpleUser(String IPAddress, String Id, String JoinTime, String Name, Integer Port, String SessionID, List<String> Tags, String TimeLoggedIn, String UID, UUID UserSessionId) {}
