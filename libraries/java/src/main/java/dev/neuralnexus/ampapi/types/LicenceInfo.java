/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

import java.util.UUID;

/**
 * A struct to represent the object returned by Core#ActivateAMPLicence(Guid, Boolean)
 *
 * @param Expires The expiry date
 * @param Grade The grade
 * @param GradeName The grade name
 * @param LicenceKey The licence key
 * @param Product The product
 * @param ProductName The product name
 * @param Usage The usage
 */
public record LicenceInfo(
        String Expires,
        UUID Grade,
        String GradeName,
        UUID LicenceKey,
        UUID Product,
        String ProductName,
        Integer Usage) {}
