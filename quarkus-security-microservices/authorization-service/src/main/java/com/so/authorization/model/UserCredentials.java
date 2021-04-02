package com.so.authorization.model;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

public final class UserCredentials {

    private final String token;
    private final String tokenType;
    private final String tokenValue;
    private final LocalDateTime created;
    private final LocalDateTime updated;
    private final Long id;
    private final String name;
    private final Set<String> roles;
    private final Set<Object> credentials;
    private final Map<String, Object> attributes;
    private final String userAgent;
    private final String forwarded;

    public UserCredentials(
            final String token,
            final String tokenType,
            final String tokenValue,
            final LocalDateTime created,
            final LocalDateTime updated,
            final Long id,
            final String name,
            final Set<String> roles,
            final Set<Object> credentials,
            final Map<String, Object> attributes,
            final String userAgent,
            final String forwarded
    ) {
        this.token = token;
        this.tokenType = tokenType;
        this.tokenValue = tokenValue;
        this.created = LocalDateTime.from(created);
        this.updated = LocalDateTime.from(updated);
        this.id = id;
        this.name = name;
        this.roles = Set.copyOf(roles);
        this.credentials = Set.copyOf(credentials);
        this.attributes = Map.copyOf(attributes);
        this.userAgent = userAgent;
        this.forwarded = forwarded;
    }

    public String getToken() {
        return token;
    }

    public String getTokenType() {
        return tokenType;
    }

    public String getTokenValue() {
        return tokenValue;
    }

    public LocalDateTime getCreated() {
        return LocalDateTime.from(created);
    }

    public LocalDateTime getUpdated() {
        return LocalDateTime.from(updated);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public Set<Object> getCredentials() {
        return credentials;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public String getForwarded() {
        return forwarded;
    }

    public UserCredentials copy() {
        return new UserCredentials(
                token,
                tokenType,
                tokenValue,
                created,
                updated,
                id,
                name,
                roles,
                credentials,
                attributes,
                userAgent,
                forwarded
        );
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final UserCredentials that = (UserCredentials) o;
        return Objects.equals(token, that.token) && Objects.equals(tokenType, that.tokenType)
                && Objects.equals(tokenValue, that.tokenValue) && Objects.equals(created, that.created)
                && Objects.equals(updated, that.updated) && Objects.equals(id, that.id)
                && Objects.equals(name, that.name) && Objects.equals(roles, that.roles)
                && Objects.equals(credentials, that.credentials) && Objects.equals(attributes, that.attributes)
                && Objects.equals(userAgent, that.userAgent) && Objects.equals(forwarded, that.forwarded);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token, tokenType, tokenValue, created, updated, id, name, roles, credentials, attributes, userAgent, forwarded);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserCredentials.class.getSimpleName() + "[", "]")
                .add("token='" + token + "'")
                .add("tokenType='" + tokenType + "'")
                .add("tokenValue='" + tokenValue + "'")
                .add("created=" + created)
                .add("updated=" + updated)
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("roles=" + roles)
                .add("credentials=" + credentials)
                .add("attributes=" + attributes)
                .add("userAgent='" + userAgent + "'")
                .add("forwarded=" + forwarded)
                .toString();
    }
}
