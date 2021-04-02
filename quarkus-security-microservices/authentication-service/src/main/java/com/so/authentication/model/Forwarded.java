package com.so.authentication.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class Forwarded {

    private final String byIdentifier;
    private final String forIdentifier;
    private final String host;
    private final String proto;

    @JsonCreator
    public Forwarded(
            @JsonProperty("by") final String byIdentifier,
            @JsonProperty("for") final String forIdentifier,
            @JsonProperty("host") final String host,
            @JsonProperty("proto") final String proto
    ) {
        this.byIdentifier = Objects.requireNonNull(byIdentifier);
        this.forIdentifier = Objects.requireNonNull(forIdentifier);
        this.host = Objects.requireNonNull(host);
        this.proto = Objects.requireNonNull(proto);
    }

    public String getByIdentifier() {
        return byIdentifier;
    }

    public String getForIdentifier() {
        return forIdentifier;
    }

    public String getHost() {
        return host;
    }

    public String getProto() {
        return proto;
    }

    public Forwarded copy() {
        return new Forwarded(
                byIdentifier,
                forIdentifier,
                host,
                proto
        );
    }

    public static List<Forwarded> of(final String headerString) {
        final Function<String, Map<String, String>> forwardedStringToMapFunction =
                (forwardedStrings) -> Arrays.stream(forwardedStrings.split(";"))
                        .map(forwardedStringPair -> Arrays.asList(forwardedStringPair.split("=")))
                        .collect(Collectors.toMap(listPair -> listPair.get(0).trim(), r -> r.get(1).trim()));

        return Arrays.stream(headerString.split(","))
                .map(forwardedStringToMapFunction)
                .map(forwardedMap -> new Forwarded(
                        forwardedMap.get("by"),
                        forwardedMap.get("for"),
                        forwardedMap.get("host"),
                        forwardedMap.get("proto")
                ))
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Forwarded forwarded = (Forwarded) o;
        return Objects.equals(byIdentifier, forwarded.byIdentifier)
                && Objects.equals(forIdentifier, forwarded.forIdentifier)
                && Objects.equals(host, forwarded.host)
                && Objects.equals(proto, forwarded.proto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(byIdentifier, forIdentifier, host, proto);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Forwarded.class.getSimpleName() + "[", "]")
                .add("byIdentifier='" + byIdentifier + "'")
                .add("forIdentifier='" + forIdentifier + "'")
                .add("host='" + host + "'")
                .add("proto='" + proto + "'")
                .toString();
    }
}
