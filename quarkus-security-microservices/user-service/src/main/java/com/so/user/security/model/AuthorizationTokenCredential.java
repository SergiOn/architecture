package com.so.user.security.model;

import io.quarkus.security.credential.Credential;

import java.util.Objects;
import java.util.StringJoiner;

public class AuthorizationTokenCredential implements Credential {
    public static final String authorizationType = "Bearer";

    private final String token;
    private final String type;
    private final String userAgent;
    private final String forwarded;

    public AuthorizationTokenCredential(final String token, final String userAgent, final String forwarded) {
        this.token = token;
        this.type = authorizationType;
        this.userAgent = userAgent;
        this.forwarded = forwarded;
    }

    public AuthorizationTokenCredential(final String token, final String type, final String userAgent, final String forwarded) {
        this.token = token;
        this.type = type;
        this.userAgent = userAgent;
        this.forwarded = forwarded;
    }

    public static String getAuthorizationType() {
        return authorizationType;
    }

    public String getToken() {
        return token;
    }

    public String getType() {
        return type;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public String getForwarded() {
        return forwarded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final AuthorizationTokenCredential that = (AuthorizationTokenCredential) o;
        return Objects.equals(token, that.token) && Objects.equals(type, that.type)
                && Objects.equals(userAgent, that.userAgent) && Objects.equals(forwarded, that.forwarded);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token, type, userAgent, forwarded);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AuthorizationTokenCredential.class.getSimpleName() + "[", "]")
                .add("token='" + token + "'")
                .add("type='" + type + "'")
                .add("userAgent='" + userAgent + "'")
                .add("forwarded='" + forwarded + "'")
                .toString();
    }
}
