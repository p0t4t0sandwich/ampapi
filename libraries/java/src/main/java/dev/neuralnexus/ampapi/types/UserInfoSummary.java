/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

import java.util.UUID;

/**
 * Information about the user
 *
 * @param AvatarBase64 The avatar base64
 * @param Disabled Whether the user is disabled
 * @param EmailAddress The email address
 * @param GravatarHash The Gravatar hash
 * @param ID The user ID
 * @param IsLDAPUser Whether the user is an LDAP user
 * @param IsTwoFactorEnabled Whether 2FA is enabled
 * @param LastLogin The last callback
 * @param Username The username
 */
public record UserInfoSummary(
        String AvatarBase64,
        Boolean Disabled,
        String EmailAddress,
        String GravatarHash,
        UUID ID,
        Boolean IsLDAPUser,
        Boolean IsTwoFactorEnabled,
        String LastLogin,
        String Username) {}
