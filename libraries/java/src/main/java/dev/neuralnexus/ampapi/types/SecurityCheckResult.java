/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

/**
 * A security check result
 *
 * @param Description The description
 * @param Hidden Whether the check is hidden
 * @param Pass Whether the check passed
 * @param Resolution The resolution
 * @param Severity The severity
 * @param Title The title
 */
public record SecurityCheckResult(
        String Description,
        Boolean Hidden,
        Boolean Pass,
        String Resolution,
        Integer Severity,
        String Title) {}
