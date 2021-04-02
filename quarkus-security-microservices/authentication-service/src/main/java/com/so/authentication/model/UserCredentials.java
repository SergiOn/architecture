package com.so.authentication.model;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

public final class UserCredentials {

    private final String name;
    private final String password;
    private final String email;
    private final String phone;
    private final Long id;
    private final Set<String> roles;
    private final Set<Object> credentials;
    private final Map<String, Object> attributes;

    public UserCredentials(
            final String name,
            final String password,
            final String email,
            final String phone,
            final Long id,
            final Set<String> roles,
            final Set<Object> credentials,
            final Map<String, Object> attributes
    ) {
        this.name = Objects.requireNonNull(name);
        this.password = Objects.requireNonNull(password);
        this.email = Objects.requireNonNull(email);
        this.phone = Objects.requireNonNull(phone);
        this.id = Objects.requireNonNull(id);
        this.roles = Set.copyOf(Objects.requireNonNull(roles));
        this.credentials = Set.copyOf(Objects.requireNonNull(credentials));
        this.attributes = Map.copyOf(Objects.requireNonNull(attributes));
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
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

    public UserCredentials copy() {
        return new UserCredentials(
                name,
                password,
                email,
                phone,
                id,
                roles,
                credentials,
                attributes
        );
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final UserCredentials that = (UserCredentials) o;
        return Objects.equals(name, that.name) && Objects.equals(password, that.password)
                && Objects.equals(email, that.email) && Objects.equals(phone, that.phone)
                && Objects.equals(id, that.id) && Objects.equals(roles, that.roles)
                && Objects.equals(credentials, that.credentials) && Objects.equals(attributes, that.attributes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password, email, phone, id, roles, credentials, attributes);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserCredentials.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("password='" + password + "'")
                .add("email='" + email + "'")
                .add("phone='" + phone + "'")
                .add("id=" + id)
                .add("roles=" + roles)
                .add("credentials=" + credentials)
                .add("attributes=" + attributes)
                .toString();
    }
}
