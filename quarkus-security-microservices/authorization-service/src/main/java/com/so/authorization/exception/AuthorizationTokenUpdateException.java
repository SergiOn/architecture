package com.so.authorization.exception;

public final class AuthorizationTokenUpdateException extends Exception {
    public AuthorizationTokenUpdateException() {
        super();
    }

    public AuthorizationTokenUpdateException(String message) {
        super(message);
    }

    public AuthorizationTokenUpdateException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthorizationTokenUpdateException(Throwable cause) {
        super(cause);
    }

    public AuthorizationTokenUpdateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
