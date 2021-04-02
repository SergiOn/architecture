package com.so.authorization.service;

import com.so.authorization.exception.AuthorizationTokenDuplicateException;
import com.so.authorization.exception.AuthorizationTokenNotFoundException;
import com.so.authorization.exception.AuthorizationTokenUpdateException;
import com.so.authorization.model.UserCredentials;
import com.so.authorization.model.request.CreateTokenInformation;
import com.so.authorization.model.request.UpdateTokenInformation;
import com.so.authorization.model.request.CreateUserCredentials;
import com.so.authorization.model.request.UpdateUserCredentials;
import com.so.authorization.model.response.UserCredentialsResponse;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class AuthorizationServiceImpl implements AuthorizationService {
    private static final Logger LOG = Logger.getLogger(AuthorizationServiceImpl.class);

    private final Map<String, UserCredentials> tokenStore = new ConcurrentHashMap<>();
    private final Map<Long, Set<String>> userTokens = new ConcurrentHashMap<>();

    @Override
    public UserCredentialsResponse getUserCredentials(
            final String authorizationHeader,
            final String userAgentHeader,
            final String forwardedHeader
    ) throws AuthorizationTokenNotFoundException {
        LOG.info("getUserCredentials");

        return Optional.ofNullable(authorizationHeader)
                .map(tokenStore::get)
                .map(UserCredentialsResponse::of)
                .orElseThrow(() -> new AuthorizationTokenNotFoundException(
                        "Authorization token is not registered \"" + authorizationHeader + "\""
                ));
    }

    @Override
    public void registerUserCredentials(
            final String userAgentHeader,
            final String forwardedHeader,
            final CreateTokenInformation createTokenInformation
    ) throws AuthorizationTokenDuplicateException {
        LOG.info("registerUserCredentials");

        final CreateUserCredentials createUserCredentials = createTokenInformation.getUserCredentials();
        final String token = createUserCredentials.getToken();
        final Long id = createUserCredentials.getId();

        final UserCredentials userCredentialsFromTokenStore = tokenStore.get(token);

        if (userCredentialsFromTokenStore != null) {
            throw new AuthorizationTokenDuplicateException("Token cannot be saved in duplicate reason");
        }

        final UserCredentials userCredentials = new UserCredentials(
                token,
                createUserCredentials.getTokenType(),
                createUserCredentials.getTokenValue(),
                createUserCredentials.getCreated(),
                createUserCredentials.getCreated(),
                id,
                createUserCredentials.getName(),
                createUserCredentials.getRoles(),
                createUserCredentials.getCredentials(),
                createUserCredentials.getAttributes(),
                userAgentHeader,
                forwardedHeader
        );

        tokenStore.put(token, userCredentials);

        final Set<String> tokensFromUserTokens = userTokens.get(id);

        if (tokensFromUserTokens == null) {
            userTokens.put(id, Set.of(token));
        } else {
            final Set<String> tokens = new HashSet<>(tokensFromUserTokens);
            tokens.add(token);
            userTokens.put(id, Set.copyOf(tokens));
        }
    }

    @Override
    public void updateUserCredentials(final UpdateTokenInformation updateTokenInformation) throws AuthorizationTokenUpdateException {
        LOG.info("updateUserCredentials");

        final UpdateUserCredentials updateUserCredentials = updateTokenInformation.getUserCredentials();
        final Long id = updateUserCredentials.getId();
        final LocalDateTime updated = updateUserCredentials.getUpdated();

        final String name = updateUserCredentials.getName();
        final Set<String> roles = updateUserCredentials.getRoles();
        final Set<Object> credentials = updateUserCredentials.getCredentials();
        final Map<String, Object> attributes = updateUserCredentials.getAttributes();
        final boolean nameShouldBeUpdated = name != null;
        final boolean rolesShouldBeUpdated = roles != null;
        final boolean credentialsShouldBeUpdated = credentials != null;
        final boolean attributesShouldBeUpdated = attributes != null;

        final Set<String> tokens = userTokens.get(id);

        if (tokens == null || tokens.isEmpty()) {
            throw new AuthorizationTokenUpdateException("Token cannot be updated");
        }

        tokens.forEach(token -> {
            final UserCredentials userCredentials = tokenStore.get(token);
            if (userCredentials == null) {
                return;
            }

            final UserCredentials userCredentialsUpdated = new UserCredentials(
                    userCredentials.getToken(),
                    userCredentials.getTokenType(),
                    userCredentials.getTokenValue(),
                    userCredentials.getCreated(),
                    updated,
                    id,
                    nameShouldBeUpdated ? name : userCredentials.getName(),
                    rolesShouldBeUpdated ? roles : userCredentials.getRoles(),
                    credentialsShouldBeUpdated ? credentials : userCredentials.getCredentials(),
                    attributesShouldBeUpdated ? attributes : userCredentials.getAttributes(),
                    userCredentials.getUserAgent(),
                    userCredentials.getForwarded()
            );

            tokenStore.put(token, userCredentialsUpdated);
        });
    }

    @Override
    public void deleteUserCredentials(final String authorizationHeader) {
        LOG.info("deleteUserCredentials");

        final UserCredentials createUserCredentialsFromTokenStore = tokenStore.get(authorizationHeader);

        if (createUserCredentialsFromTokenStore == null) {
            return;
        }

        tokenStore.remove(authorizationHeader);

        final Long id = createUserCredentialsFromTokenStore.getId();
        final Set<String> tokensFromUserTokens = userTokens.get(id);
        final Set<String> tokens = new HashSet<>(tokensFromUserTokens);
        tokens.remove(authorizationHeader);

        if (tokens.isEmpty()) {
            userTokens.remove(id);
        } else {
            userTokens.put(id, Set.copyOf(tokens));
        }
    }

    @Override
    public void deleteAllUserCredentials(final Long userId) {
        LOG.info("deleteAllUserCredentials");

        final Set<String> tokens = userTokens.get(userId);
        tokens.forEach(tokenStore::remove);
        userTokens.remove(userId);
    }
}
