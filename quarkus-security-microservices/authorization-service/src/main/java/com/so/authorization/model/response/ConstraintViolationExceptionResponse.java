package com.so.authorization.model.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.StringJoiner;

public class ConstraintViolationExceptionResponse {
    private final String path;
    private final Object value;
    private final String message;

    @JsonCreator
    public ConstraintViolationExceptionResponse(
            @JsonProperty("path") final String path,
            @JsonProperty("value") final Object value,
            @JsonProperty("message") final String message
    ) {
        this.path = path;
        this.value = value;
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public Object getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ConstraintViolationExceptionResponse that = (ConstraintViolationExceptionResponse) o;
        return Objects.equals(path, that.path) && Objects.equals(value, that.value) && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path, value, message);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ConstraintViolationExceptionResponse.class.getSimpleName() + "[", "]")
                .add("path='" + path + "'")
                .add("value='" + value + "'")
                .add("message='" + message + "'")
                .toString();
    }
}
