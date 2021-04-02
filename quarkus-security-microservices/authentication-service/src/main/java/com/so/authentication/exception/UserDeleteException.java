package com.so.authentication.exception;

public class UserDeleteException extends Exception {
    public UserDeleteException() {
        super();
    }

    public UserDeleteException(final String message) {
        super(message);
    }

    public UserDeleteException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public UserDeleteException(final Throwable cause) {
        super(cause);
    }

    public UserDeleteException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
