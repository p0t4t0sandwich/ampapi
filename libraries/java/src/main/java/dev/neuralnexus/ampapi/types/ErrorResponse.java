/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

/**
 * An error object
 *
 * @param Message The error message
 * @param StackTrace The stack trace of the error
 * @param Title The title of the error
 */
public record ErrorResponse(String Message, String StackTrace, String Title) {}
