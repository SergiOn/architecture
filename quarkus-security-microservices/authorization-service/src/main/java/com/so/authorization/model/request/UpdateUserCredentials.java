package com.so.authorization.model.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

public final class UpdateUserCredentials {

    @NotNull
    private final LocalDateTime updated;

    @NotNull
    private final Long id;

    private final String name;
    private final Set<String> roles;
    private final Set<Object> credentials;
    private final Map<String, Object> attributes;

    @JsonCreator
    public UpdateUserCredentials(
            @JsonProperty("updated") final LocalDateTime updated,
            @JsonProperty("id") final Long id,
            @JsonProperty("name") final String name,
            @JsonProperty("roles") final Set<String> roles,
            @JsonProperty("credentials") final Set<Object> credentials,
            @JsonProperty("attributes") final Map<String, Object> attributes
    ) {
        this.updated = updated != null ? LocalDateTime.from(updated) : null;
        this.id = id;
        this.name = name;
        this.roles = roles != null ? Set.copyOf(roles) : null;
        this.credentials = credentials != null ? Set.copyOf(credentials) : null;
        this.attributes = attributes != null ? Map.copyOf(attributes) : null;
    }

    public LocalDateTime getUpdated() {
        return updated != null ? LocalDateTime.from(updated) : null;
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

    public UpdateUserCredentials copy() {
        return new UpdateUserCredentials(
                updated,
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
        final UpdateUserCredentials that = (UpdateUserCredentials) o;
        return Objects.equals(updated, that.updated)
                && Objects.equals(id, that.id)
                && Objects.equals(name, that.name)
                && Objects.equals(roles, that.roles)
                && Objects.equals(credentials, that.credentials)
                && Objects.equals(attributes, that.attributes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(updated, id, name, roles, credentials, attributes);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UpdateUserCredentials.class.getSimpleName() + "[", "]")
                .add("updated=" + updated)
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("roles=" + roles)
                .add("credentials=" + credentials)
                .add("attributes=" + attributes)
                .toString();
    }
}
