package com.so.authorization.exception;

public final class AuthorizationTokenNotFoundException extends Exception {
    public AuthorizationTokenNotFoundException() {
        super();
    }

    public AuthorizationTokenNotFoundException(final String message) {
        super(message);
    }

    public AuthorizationTokenNotFoundException(final String message, Throwable cause) {
        super(message, cause);
    }

    public AuthorizationTokenNotFoundException(final Throwable cause) {
        super(cause);
    }

    public AuthorizationTokenNotFoundException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
