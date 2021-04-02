package com.so.security;

import io.quarkus.security.identity.SecurityIdentity;

import javax.annotation.Priority;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Produces;

@Priority(1)
@Alternative
@RequestScoped
public class TokenPrincipalProducer {

    private final SecurityIdentity identity;

    public TokenPrincipalProducer(SecurityIdentity identity) {
        this.identity = identity;
    }

    @Produces
    @RequestScoped
    public TokenPrincipal currentJWTPrincipalOrNull() {
        if (this.identity.isAnonymous()) {
            return new WebTokenPrincipal();
        } else if (this.identity.getPrincipal() instanceof TokenPrincipal) {
            return (TokenPrincipal) this.identity.getPrincipal();
        } else {
            throw new IllegalStateException("Current principal " + this.identity.getPrincipal() + " is not a JSON web token");
        }
    }
}
