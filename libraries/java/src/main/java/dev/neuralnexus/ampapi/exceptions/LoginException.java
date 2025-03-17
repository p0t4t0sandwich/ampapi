/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.exceptions;

import dev.neuralnexus.ampapi.types.LoginResponse;

public class LoginException extends RuntimeException {
    public LoginException(LoginResponse loginResult) {
        super(loginResult.resultReason() + ": " + loginResult.result() + "\n" + loginResult);
    }
}
