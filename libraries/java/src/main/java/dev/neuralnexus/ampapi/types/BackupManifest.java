/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

import java.util.Optional;
import java.util.UUID;

/**
 * A backup manifest
 *
 * @param CreatedAutomatically Whether the backup was created automatically
 * @param Description The description
 * @param HashSHA1 The SHA1 hash
 * @param Id The ID
 * @param META The meta
 * @param ModuleName The module name
 * @param Name The name
 * @param RemoteStoreId The remote store ID
 * @param SourceOS The source OS
 * @param Sticky Whether the backup is sticky
 * @param StoredLocally Whether the backup is stored locally
 * @param StoredRemotely Whether the backup is stored remotely
 * @param TakenBy The user who took the backup
 * @param Timestamp The timestamp
 * @param TotalSizeBytes The total size in bytes
 * @param ParentManifest The parent manifest
 */
public record BackupManifest(
        Boolean CreatedAutomatically,
        String Description,
        String HashSHA1,
        UUID Id,
        String META,
        String ModuleName,
        String Name,
        String RemoteStoreId,
        SupportedOS SourceOS,
        Boolean Sticky,
        Boolean StoredLocally,
        Boolean StoredRemotely,
        String TakenBy,
        String Timestamp,
        Integer TotalSizeBytes,
        Optional<UUID> ParentManifest) {}
