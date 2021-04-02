package com.so.authorization.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

@Tag("unit")
class ForwardedTest {

    private String forwardedHeader;
    private List<Forwarded> forwardedList;

    @BeforeEach
    public void beforeEach() {
        forwardedHeader = "by=127.0.0.1;for=127.0.0.1;host=localhost:8081;proto=http, " +
                "by=127.0.0.2;for=127.0.0.2;host=localhost:8082;proto=https, " +
                "by=127.0.0.3;for=127.0.0.3";
        forwardedList = List.of(
                new Forwarded("127.0.0.1", "127.0.0.1", "localhost:8081", "http"),
                new Forwarded("127.0.0.2", "127.0.0.2", "localhost:8082", "https"),
                new Forwarded("127.0.0.3", "127.0.0.3", null, null)
        );
    }

    @Test
    public void of() {
        final List<Forwarded> result = Forwarded.of(forwardedHeader);
        assertIterableEquals(forwardedList, result);
    }
}
