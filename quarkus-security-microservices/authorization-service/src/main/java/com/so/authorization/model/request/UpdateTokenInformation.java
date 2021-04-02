package com.so.authorization.model.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.StringJoiner;

public final class UpdateTokenInformation {

    @NotNull
    private final String algorithm;

    @NotNull
    private final String hash;

    @NotNull
    @Valid
    private final UpdateUserCredentials userCredentials;

    @JsonCreator
    public UpdateTokenInformation(
            @JsonProperty("algorithm") final String algorithm,
            @JsonProperty("hash") final String hash,
            @JsonProperty("userCredentials") final UpdateUserCredentials userCredentials
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

    public UpdateUserCredentials getUserCredentials() {
        return userCredentials;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final UpdateTokenInformation that = (UpdateTokenInformation) o;
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
        return new StringJoiner(", ", UpdateTokenInformation.class.getSimpleName() + "[", "]")
                .add("algorithm='" + algorithm + "'")
                .add("hash='" + hash + "'")
                .add("userCredentials=" + userCredentials)
                .toString();
    }
}
