package com.so.user.security.client.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.security.credential.Credential;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

public final class UserCredentialResponse {

    private final String token;
    private final Long id;
    private final String name;
    private final Set<String> roles;
    private final Set<Credential> credentials;
    private final Map<String, Object> attributes;

    @JsonCreator
    public UserCredentialResponse(
            @JsonProperty("token") final String token,
            @JsonProperty("id") final Long id,
            @JsonProperty("name") final String name,
            @JsonProperty("roles") final Set<String> roles,
            @JsonProperty("credentials") final Set<Credential> credentials,
            @JsonProperty("attributes") final Map<String, Object> attributes
    ) {
        this.token = token;
        this.id = id;
        this.name = name;
        this.roles = Set.copyOf(roles);
        this.credentials = Set.copyOf(credentials);
        this.attributes = Map.copyOf(attributes);
    }

    public String getToken() {
        return token;
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

    public Set<Credential> getCredentials() {
        return credentials;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final UserCredentialResponse that = (UserCredentialResponse) o;
        return Objects.equals(token, that.token) && Objects.equals(id, that.id)
                && Objects.equals(name, that.name) && Objects.equals(roles, that.roles)
                && Objects.equals(credentials, that.credentials) && Objects.equals(attributes, that.attributes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token, id, name, roles, credentials, attributes);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserCredentialResponse.class.getSimpleName() + "[", "]")
                .add("token='" + token + "'")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("roles=" + roles)
                .add("credentials=" + credentials)
                .add("attributes=" + attributes)
                .toString();
    }
}
