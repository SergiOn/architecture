package com.so.authentication.model.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

public final class UserCredentialsResponse {

    private final String token;
    private final LocalDateTime created;
    private final String name;
    private final String email;
    private final String phone;
    private final Long id;
    private final Set<String> roles;
    private final Set<Object> credentials;
    private final Map<String, Object> attributes;

    @JsonCreator
    public UserCredentialsResponse(
            @JsonProperty("token") final String token,
            @JsonProperty("created") final LocalDateTime created,
            @JsonProperty("name") final String name,
            @JsonProperty("email") final String email,
            @JsonProperty("phone") final String phone,
            @JsonProperty("id") final Long id,
            @JsonProperty("roles") final Set<String> roles,
            @JsonProperty("credentials") final Set<Object> credentials,
            @JsonProperty("attributes") final Map<String, Object> attributes
    ) {
        this.token = Objects.requireNonNull(token);
        this.created = Objects.requireNonNull(created);
        this.name = Objects.requireNonNull(name);
        this.email = Objects.requireNonNull(email);
        this.phone = Objects.requireNonNull(phone);
        this.id = Objects.requireNonNull(id);
        this.roles = Set.copyOf(Objects.requireNonNull(roles));
        this.credentials = Set.copyOf(Objects.requireNonNull(credentials));
        this.attributes = Map.copyOf(Objects.requireNonNull(attributes));
    }

    public String getToken() {
        return token;
    }

    public LocalDateTime getCreated() {
        return LocalDateTime.from(created);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Long getId() {
        return id;
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

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final UserCredentialsResponse that = (UserCredentialsResponse) o;
        return Objects.equals(token, that.token) && Objects.equals(created, that.created)
                && Objects.equals(name, that.name) && Objects.equals(email, that.email)
                && Objects.equals(phone, that.phone) && Objects.equals(id, that.id)
                && Objects.equals(roles, that.roles) && Objects.equals(credentials, that.credentials)
                && Objects.equals(attributes, that.attributes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token, created, name, email, phone, id, roles, credentials, attributes);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserCredentialsResponse.class.getSimpleName() + "[", "]")
                .add("token='" + token + "'")
                .add("created=" + created)
                .add("name='" + name + "'")
                .add("email='" + email + "'")
                .add("phone='" + phone + "'")
                .add("id=" + id)
                .add("roles=" + roles)
                .add("credentials=" + credentials)
                .add("attributes=" + attributes)
                .toString();
    }
}
