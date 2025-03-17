/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi-java/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.exceptions;

import dev.neuralnexus.ampapi.types.LoginResponse;

public class APILoginException extends RuntimeException {
    public APILoginException(LoginResult loginResult) {
        super(loginResult.resultReason + ": " + loginResult.result + "\n" + loginResult);
    }
}
