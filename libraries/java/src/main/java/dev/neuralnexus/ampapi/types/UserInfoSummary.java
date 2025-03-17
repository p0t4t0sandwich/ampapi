package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * Information about the user
 * @param AvatarBase64 The avatar base64
 * @param Disabled Whether the user is disabled
 * @param EmailAddress The email address
 * @param GravatarHash The Gravatar hash
 * @param ID The user ID
 * @param IsLDAPUser Whether the user is an LDAP user
 * @param IsTwoFactorEnabled Whether 2FA is enabled
 * @param LastLogin The last login
 * @param Username The username
 */
public record UserInfoSummary(String AvatarBase64, Boolean Disabled, String EmailAddress, String GravatarHash, UUID ID, Boolean IsLDAPUser, Boolean IsTwoFactorEnabled, String LastLogin, String Username) {}
