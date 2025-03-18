/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi;

/**
 * AMPError
 *
 * @param Title The title of the error
 * @param Message The message of the error
 * @param StackTrace The stack trace of the error
 */
public record AMPError(String Title, String Message, String StackTrace) {
    @Override
    public String toString() {
        return this.Title + ": " + this.Message + "\n" + this.StackTrace;
    }
}
