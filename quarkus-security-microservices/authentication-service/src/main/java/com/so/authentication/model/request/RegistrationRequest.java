package com.so.authentication.model.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.StringJoiner;

public class RegistrationRequest {

    @NotNull
    private final String name;

    @NotNull
    private final String email;

    @NotNull
    private final String password;

    @NotNull
    private final String phone;

    @JsonCreator
    public RegistrationRequest(
            @JsonProperty("name") final String name,
            @JsonProperty("email") String email,
            @JsonProperty("password") String password,
            @JsonProperty("phone") String phone
    ) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final RegistrationRequest that = (RegistrationRequest) o;
        return Objects.equals(name, that.name) && Objects.equals(email, that.email)
                && Objects.equals(password, that.password) && Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, password, phone);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RegistrationRequest.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("email='" + email + "'")
                .add("password='" + password + "'")
                .add("phone='" + phone + "'")
                .toString();
    }
}
