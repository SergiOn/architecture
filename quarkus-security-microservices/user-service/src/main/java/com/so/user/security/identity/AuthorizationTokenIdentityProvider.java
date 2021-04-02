package com.so.user.security.identity;

import com.so.user.security.client.AuthorizationServiceClient;
import com.so.user.security.model.AuthorizationTokenAuthenticationRequest;
import io.quarkus.security.AuthenticationFailedException;
import io.quarkus.security.identity.AuthenticationRequestContext;
import io.quarkus.security.identity.IdentityProvider;
import io.quarkus.security.identity.SecurityIdentity;
import io.quarkus.security.runtime.QuarkusSecurityIdentity;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class AuthorizationTokenIdentityProvider implements IdentityProvider<AuthorizationTokenAuthenticationRequest> {
    private static final Logger LOG = Logger.getLogger(AuthorizationTokenIdentityProvider.class);

    private final AuthorizationServiceClient authorizationServiceClient;

    @Inject
    public AuthorizationTokenIdentityProvider(@RestClient final AuthorizationServiceClient authorizationServiceClient) {
        this.authorizationServiceClient = authorizationServiceClient;
    }

    @Override
    public Class<AuthorizationTokenAuthenticationRequest> getRequestType() {
        LOG.info("Method: getRequestType");
        return AuthorizationTokenAuthenticationRequest.class;
    }

    @Override
    public Uni<SecurityIdentity> authenticate(
            final AuthorizationTokenAuthenticationRequest authorizationTokenAuthenticationRequest,
            final AuthenticationRequestContext authenticationRequestContext
    ) {
        LOG.infov(
                "Method: authenticate, AuthorizationTokenAuthenticationRequest: {0}, AuthenticationRequestContext: {1}",
                authorizationTokenAuthenticationRequest,
                authenticationRequestContext
        );
        return Uni.createFrom().item(authorizationTokenAuthenticationRequest.getAuthorizationTokenCredential())
                .onItem().transformToUni(credential -> authorizationServiceClient.getUserCredential(
                        credential.getToken(),
                        credential.getUserAgent()
                ))
                .onItem().transform(userCredential -> {
                    LOG.infov("Method: authenticate, Status: Success, UserCredential: {0}", userCredential);
                    return (SecurityIdentity) QuarkusSecurityIdentity.builder()
                            .setPrincipal(userCredential::getName)
                            .addRoles(userCredential.getRoles())
                            .addCredentials(userCredential.getCredentials())
                            .addAttributes(userCredential.getAttributes())
                            .build();
                })
                .onFailure().transform(exception -> {
                    LOG.infov("Method: authenticate, Status: Failure, Exception: {0}", exception);
                    return new AuthenticationFailedException("Authentication failed", exception);
                });
    }
}
