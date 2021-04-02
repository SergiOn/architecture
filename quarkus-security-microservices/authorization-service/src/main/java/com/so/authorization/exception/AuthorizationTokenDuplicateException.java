package com.so.authorization.exception;

public final class AuthorizationTokenDuplicateException extends Exception {
    public AuthorizationTokenDuplicateException() {
        super();
    }

    public AuthorizationTokenDuplicateException(final String message) {
        super(message);
    }

    public AuthorizationTokenDuplicateException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public AuthorizationTokenDuplicateException(final Throwable cause) {
        super(cause);
    }

    public AuthorizationTokenDuplicateException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
