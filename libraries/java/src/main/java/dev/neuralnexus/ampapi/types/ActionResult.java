/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

import java.util.Optional;

/**
 * Generic response type for calls that return a result and a reason for failure
 *
 * @param Reason Reason for failure
 * @param Status true if successful, false if not
 * @param SupportTitle Support title
 * @param SupportURL Support URL
 * @param Result Result of the call
 */
public record ActionResult<T>(
        String Reason,
        Boolean Status,
        String SupportTitle,
        String SupportURL,
        Optional<T> Result) {}
