/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.exceptions;

public class AMPAPIException extends RuntimeException {
    public AMPAPIException(APIError err) {
        super(err.Title + ": " + err.Message + "\n" + err.StackTrace);
    }

    public static class APIError {
        public String Title;
        public String Message;
        public String StackTrace;
    }
}
