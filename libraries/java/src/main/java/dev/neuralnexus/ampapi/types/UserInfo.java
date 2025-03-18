/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

import java.util.List;
import java.util.UUID;

/**
 * Information about a user
 *
 * @param AvatarBase64 The avatar base64
 * @param CannotChangePassword Whether the password cannot be changed
 * @param Disabled Whether the user is disabled
 * @param EmailAddress The email address
 * @param GravatarHash The gravatar hash
 * @param ID The ID
 * @param IsLDAPUser Whether the user is an LDAP user
 * @param IsSuperUser Whether the user is a super user
 * @param IsTwoFactorEnabled Whether two-factor is enabled
 * @param LastLogin The last callback
 * @param MustChangePassword Whether the password must be changed
 * @param Name The name
 * @param PasswordExpires Whether the password expires
 * @param Permissions The permissions
 * @param Roles The roles
 */
public record UserInfo(
        String AvatarBase64,
        Boolean CannotChangePassword,
        Boolean Disabled,
        String EmailAddress,
        String GravatarHash,
        UUID ID,
        Boolean IsLDAPUser,
        Boolean IsSuperUser,
        Boolean IsTwoFactorEnabled,
        String LastLogin,
        Boolean MustChangePassword,
        String Name,
        Boolean PasswordExpires,
        List<String> Permissions,
        List<UUID> Roles) {}
