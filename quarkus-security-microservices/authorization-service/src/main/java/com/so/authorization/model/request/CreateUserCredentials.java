package com.so.authorization.model.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

public final class CreateUserCredentials {

    @NotNull
    private final String token;

    @NotNull
    private final String tokenType;

    @NotNull
    private final String tokenValue;

    @NotNull
    private final LocalDateTime created;

    @NotNull
    private final Long id;

    @NotNull
    private final String name;

    @NotNull
    private final Set<String> roles;

    @NotNull
    private final Set<Object> credentials;

    @NotNull
    private final Map<String, Object> attributes;

    @JsonCreator
    public CreateUserCredentials(
            @JsonProperty("token") final String token,
            @JsonProperty("tokenType") final String tokenType,
            @JsonProperty("tokenValue") final String tokenValue,
            @JsonProperty("created") final LocalDateTime created,
            @JsonProperty("id") final Long id,
            @JsonProperty("name") final String name,
            @JsonProperty("roles") final Set<String> roles,
            @JsonProperty("credentials") final Set<Object> credentials,
            @JsonProperty("attributes") final Map<String, Object> attributes
    ) {
        this.token = token;
        this.tokenType = tokenType;
        this.tokenValue = tokenValue;
        this.created = created != null ? LocalDateTime.from(created) : null;
        this.id = id;
        this.name = name;
        this.roles = roles != null ? Set.copyOf(roles) : null;
        this.credentials = credentials != null ? Set.copyOf(credentials) : null;
        this.attributes = attributes != null ? Map.copyOf(attributes) : null;
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
        return created != null ? LocalDateTime.from(created) : null;
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

    public CreateUserCredentials copy() {
        return new CreateUserCredentials(
                token,
                tokenType,
                tokenValue,
                created,
                id,
                name,
                roles,
                credentials,
                attributes
        );
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final CreateUserCredentials that = (CreateUserCredentials) o;
        return Objects.equals(token, that.token) && Objects.equals(tokenType, that.tokenType)
                && Objects.equals(tokenValue, that.tokenValue) && Objects.equals(created, that.created)
                && Objects.equals(id, that.id) && Objects.equals(name, that.name)
                && Objects.equals(roles, that.roles) && Objects.equals(credentials, that.credentials)
                && Objects.equals(attributes, that.attributes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token, tokenType, tokenValue, created, id, name, roles, credentials, attributes);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CreateUserCredentials.class.getSimpleName() + "[", "]")
                .add("token='" + token + "'")
                .add("tokenType='" + tokenType + "'")
                .add("tokenValue='" + tokenValue + "'")
                .add("created=" + created)
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("roles=" + roles)
                .add("credentials=" + credentials)
                .add("attributes=" + attributes)
                .toString();
    }
}
