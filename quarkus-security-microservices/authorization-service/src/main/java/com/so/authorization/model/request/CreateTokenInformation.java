package com.so.authorization.model.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.StringJoiner;

public final class CreateTokenInformation {

    @NotNull
    private final String algorithm;

    @NotNull
    private final String hash;

    @NotNull
    @Valid
    private final CreateUserCredentials userCredentials;

    @JsonCreator
    public CreateTokenInformation(
            @JsonProperty("algorithm") final String algorithm,
            @JsonProperty("hash") final String hash,
            @JsonProperty("userCredentials") final CreateUserCredentials userCredentials
    ) {
        this.algorithm = algorithm;
        this.hash = hash;
        this.userCredentials = userCredentials != null ? userCredentials.copy() : null;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public String getHash() {
        return hash;
    }

    public CreateUserCredentials getUserCredentials() {
        return userCredentials;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final CreateTokenInformation that = (CreateTokenInformation) o;
        return Objects.equals(algorithm, that.algorithm)
                && Objects.equals(hash, that.hash)
                && Objects.equals(userCredentials, that.userCredentials);
    }

    @Override
    public int hashCode() {
        return Objects.hash(algorithm, hash, userCredentials);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CreateTokenInformation.class.getSimpleName() + "[", "]")
                .add("algorithm='" + algorithm + "'")
                .add("hash='" + hash + "'")
                .add("userCredentials=" + userCredentials)
                .toString();
    }
}
