package com.so.security;

import io.quarkus.security.credential.TokenCredential;
import io.quarkus.security.identity.AuthenticationRequestContext;
import io.quarkus.security.identity.IdentityProvider;
import io.quarkus.security.identity.SecurityIdentity;
import io.quarkus.security.identity.request.TokenAuthenticationRequest;
import io.quarkus.security.runtime.QuarkusSecurityIdentity;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import java.util.Random;
import java.util.Set;

@ApplicationScoped
public class TokenIdentityProvider implements IdentityProvider<TokenAuthenticationRequest> {

    @Override
    public Class<TokenAuthenticationRequest> getRequestType() {
        return TokenAuthenticationRequest.class;
    }

    @Override
    public Uni<SecurityIdentity> authenticate(final TokenAuthenticationRequest tokenAuthenticationRequest, final AuthenticationRequestContext authenticationRequestContext) {
        final TokenCredential tokenCredential = tokenAuthenticationRequest.getToken();
        final String token = tokenCredential.getToken();
        final Long userId = new Random().nextLong();
        final WebTokenPrincipal principal = new WebTokenPrincipal(userId, "Name", token);

        return Uni.createFrom().emitter(uniEmitter -> {
            final QuarkusSecurityIdentity securityIdentity = QuarkusSecurityIdentity.builder()
                    .setPrincipal(principal)
                    .addRoles(Set.of("user", "admin"))
                    .addAttribute("quarkus.user", "TokenAuthenticationRequestIdentityProvider")
                    .build();

            uniEmitter.complete(securityIdentity);
        });
    }
}
