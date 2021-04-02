package com.so.security;

public class WebTokenPrincipal implements TokenPrincipal {

    private final Long userId;
    private final String name;
    private final String token;

    public WebTokenPrincipal() {
        this.userId = null;
        this.name = null;
        this.token = null;
    }

    public WebTokenPrincipal(Long userId, String name, String token) {
        this.userId = userId;
        this.name = name;
        this.token = token;
    }

    @Override
    public Long getUserId() {
        return userId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String token() {
        return token;
    }

    @Override
    public String toString() {
        return "WebTokenPrincipal{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
