package com.so.user.security.authentication;

import com.so.user.security.model.AuthorizationTokenAuthenticationRequest;
import com.so.user.security.model.AuthorizationTokenCredential;
import io.quarkus.security.identity.IdentityProviderManager;
import io.quarkus.security.identity.SecurityIdentity;
import io.quarkus.security.identity.request.AuthenticationRequest;
import io.quarkus.vertx.http.runtime.security.ChallengeData;
import io.quarkus.vertx.http.runtime.security.HttpAuthenticationMechanism;
import io.quarkus.vertx.http.runtime.security.HttpCredentialTransport;
import io.smallrye.mutiny.Uni;
import io.vertx.core.MultiMap;
import io.vertx.ext.web.RoutingContext;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import java.util.Set;

@ApplicationScoped
public class AuthorizationTokenHttpAuthenticationMechanism implements HttpAuthenticationMechanism {
    private static final Logger LOG = Logger.getLogger(AuthorizationTokenHttpAuthenticationMechanism.class);

    @Override
    public Uni<SecurityIdentity> authenticate(final RoutingContext context, final IdentityProviderManager identityProviderManager) {
        LOG.infov("Method: authenticate, RoutingContext: {0}, IdentityProviderManager: {1}", context, identityProviderManager);
        return Uni.createFrom()
                .item(context.request())
                .onItem().transformToUni((request) -> {
                    final MultiMap headers = request.headers();
                    final String authorizationToken = headers.get(HttpHeaders.AUTHORIZATION);

                    if (authorizationToken == null) {
                        LOG.infov("Method: authenticate, Status: Failure, Headers: {0}", headers.entries());
                        return Uni.createFrom().nullItem();
                    }

                    LOG.infov("Method: authenticate, Status: Success, Headers: {0}", headers.entries());
                    final String userAgent = headers.get(HttpHeaders.USER_AGENT);
                    final String forwarded = "";
                    final AuthorizationTokenCredential credential = new AuthorizationTokenCredential(authorizationToken, userAgent, forwarded);
                    final AuthorizationTokenAuthenticationRequest authenticationRequest = new AuthorizationTokenAuthenticationRequest(credential);
                    return identityProviderManager.authenticate(authenticationRequest);
                });
    }

    @Override
    public Uni<ChallengeData> getChallenge(final RoutingContext context) {
        LOG.infov("Method: getChallenge, RoutingContext: {0}", context);
        final ChallengeData result = new ChallengeData(
                Response.Status.UNAUTHORIZED.getStatusCode(),
                HttpHeaders.WWW_AUTHENTICATE,
                "Bearer {token}"
        );
        return Uni.createFrom().item(result);
    }

    @Override
    public Set<Class<? extends AuthenticationRequest>> getCredentialTypes() {
        LOG.info("Method: getCredentialTypes");
        return Set.of(AuthorizationTokenAuthenticationRequest.class);
    }

    @Override
    public HttpCredentialTransport getCredentialTransport() {
        LOG.info("Method: getCredentialTransport");
        return new HttpCredentialTransport(HttpCredentialTransport.Type.AUTHORIZATION, AuthorizationTokenCredential.authorizationType);
    }
}
