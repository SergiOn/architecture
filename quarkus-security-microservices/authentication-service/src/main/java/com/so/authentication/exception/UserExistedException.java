package com.so.authentication.exception;

public class UserExistedException extends Exception {
    public UserExistedException() {
        super();
    }

    public UserExistedException(final String message) {
        super(message);
    }

    public UserExistedException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public UserExistedException(final Throwable cause) {
        super(cause);
    }

    public UserExistedException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
