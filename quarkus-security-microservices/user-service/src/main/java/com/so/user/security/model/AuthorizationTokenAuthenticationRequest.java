package com.so.user.security.model;

import io.quarkus.security.identity.request.AuthenticationRequest;
import io.quarkus.security.identity.request.BaseAuthenticationRequest;

import java.util.Objects;
import java.util.StringJoiner;

public class AuthorizationTokenAuthenticationRequest extends BaseAuthenticationRequest implements AuthenticationRequest {
    private final AuthorizationTokenCredential authorizationTokenCredential;

    public AuthorizationTokenAuthenticationRequest(final AuthorizationTokenCredential authorizationTokenCredential) {
        this.authorizationTokenCredential = Objects.requireNonNull(authorizationTokenCredential);
    }

    public AuthorizationTokenCredential getAuthorizationTokenCredential() {
        return authorizationTokenCredential;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final AuthorizationTokenAuthenticationRequest that = (AuthorizationTokenAuthenticationRequest) o;
        return Objects.equals(authorizationTokenCredential, that.authorizationTokenCredential);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorizationTokenCredential);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AuthorizationTokenAuthenticationRequest.class.getSimpleName() + "[", "]")
                .add("authorizationTokenCredential=" + authorizationTokenCredential)
                .toString();
    }
}
