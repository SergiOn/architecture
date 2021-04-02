package com.so.authorization.service;

import com.so.authorization.exception.AuthorizationTokenDuplicateException;
import com.so.authorization.exception.AuthorizationTokenNotFoundException;
import com.so.authorization.exception.AuthorizationTokenUpdateException;
import com.so.authorization.model.UserCredentials;
import com.so.authorization.model.request.CreateTokenInformation;
import com.so.authorization.model.request.CreateUserCredentials;
import com.so.authorization.model.request.UpdateTokenInformation;
import com.so.authorization.model.request.UpdateUserCredentials;
import com.so.authorization.model.response.UserCredentialsResponse;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.powermock.reflect.Whitebox;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anEmptyMap;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

@QuarkusTest
@Tag("unit")
class AuthorizationServiceImplTest {

//    @Inject
    private AuthorizationService sut;

    private Map<String, UserCredentials> tokenStore;
    private Map<Long, Set<String>> userTokens;

    private String token;
    private Long id;
    private String userAgentHeader;
    private String forwardedHeader;
    private CreateUserCredentials createUserCredentials;
    private UpdateUserCredentials updateUserCredentials;
    private String algorithm;
    private String hash;
    private CreateTokenInformation createTokenInformation;
    private UpdateTokenInformation updateTokenInformation;
    private UserCredentials userCredentials;
    private UserCredentials userCredentialsUpdated;
    private UserCredentialsResponse userCredentialsResponse;

    @BeforeEach
    public void beforeEach() {
        sut = new AuthorizationServiceImpl();

        tokenStore = Whitebox.getInternalState(sut, "tokenStore");
        userTokens = Whitebox.getInternalState(sut, "userTokens");

        final String tokenType = "Bearer";
        final String tokenValue = "token-value";
        token = tokenType + " " + tokenValue;
        id = 1L;
        userAgentHeader = "Mozilla/5.0 (Macintosh; Intel Mac OS X 11_2_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.90 Safari/537.36";
        forwardedHeader = "by=127.0.0.1;for=127.0.0.1;host=localhost:8081;proto=http";

        final LocalDateTime created = LocalDateTime.of(2021, Month.MARCH, 22, 1, 1);
        final LocalDateTime updated = LocalDateTime.of(2021, Month.APRIL, 23, 1, 1);
        final String name = "User name";
        final Set<String> roles = Set.of("ADMIN");
        final Set<String> rolesUpdate = Set.of("ADMIN", "USER");
        final Set<Object> credentials = Set.of();
        final Map<String, Object> attributes = Map.of();

        createUserCredentials = new CreateUserCredentials(token, tokenType, tokenValue, created, id, name, roles, credentials, attributes);
        updateUserCredentials = new UpdateUserCredentials(updated, id, name, rolesUpdate, credentials, attributes);
        algorithm = "RSA";
        hash = "hash";
        createTokenInformation = new CreateTokenInformation(algorithm, hash, createUserCredentials);
        updateTokenInformation = new UpdateTokenInformation(algorithm, hash, updateUserCredentials);
        userCredentials = new UserCredentials(token, tokenType, tokenValue, created, created, id, name, roles, credentials, attributes, userAgentHeader, forwardedHeader);
        userCredentialsUpdated = new UserCredentials(token, tokenType, tokenValue, created, updated, id, name, rolesUpdate, credentials, attributes, userAgentHeader, forwardedHeader);
        userCredentialsResponse = new UserCredentialsResponse(token, id, name, roles, credentials, attributes);
    }

    @Test
    public void getUserCredentials() throws AuthorizationTokenNotFoundException {
        assertThat(tokenStore, anEmptyMap());
        assertThat(userTokens, anEmptyMap());

        tokenStore.put(token, userCredentials);
        userTokens.put(id, Set.of(token));

        final UserCredentialsResponse result = sut.getUserCredentials(token, userAgentHeader, forwardedHeader);
        assertThat(result, is(userCredentialsResponse));
    }

    @Test
    public void getUserCredentialsWithTokenNotFoundException() throws AuthorizationTokenNotFoundException {
        assertThat(tokenStore, anEmptyMap());
        assertThat(userTokens, anEmptyMap());

        final AuthorizationTokenNotFoundException exception = assertThrows(AuthorizationTokenNotFoundException.class, () -> {
            sut.getUserCredentials(token, userAgentHeader, forwardedHeader);
        });

        assertThat(exception.getMessage(), is("Authorization token is not registered \"" + token + "\""));
    }

    @Test
    public void registerUserCredentials() throws AuthorizationTokenDuplicateException {
        assertThat(tokenStore, anEmptyMap());
        assertThat(userTokens, anEmptyMap());

        sut.registerUserCredentials(userAgentHeader, forwardedHeader, createTokenInformation);

        assertThat(tokenStore, is(Map.of(token, userCredentials)));
        assertThat(userTokens, is(Map.of(id, Set.of(token))));
    }

    @Test
    public void registerUserCredentialsWithTokenDuplicateException() throws AuthorizationTokenDuplicateException {
        assertThat(tokenStore, anEmptyMap());
        assertThat(userTokens, anEmptyMap());

        tokenStore.put(token, userCredentials);
        userTokens.put(id, Set.of(token));

        final AuthorizationTokenDuplicateException exception = assertThrows(AuthorizationTokenDuplicateException.class, () -> {
            sut.registerUserCredentials(userAgentHeader, forwardedHeader, createTokenInformation);
        });

        assertThat(exception.getMessage(), is("Token cannot be saved in duplicate reason"));

        assertThat(tokenStore, is(Map.of(token, userCredentials)));
        assertThat(userTokens, is(Map.of(id, Set.of(token))));
    }

    @Test
    public void updateUserCredentials() throws AuthorizationTokenUpdateException {
        assertThat(tokenStore, anEmptyMap());
        assertThat(userTokens, anEmptyMap());

        tokenStore.put(token, userCredentials);
        userTokens.put(id, Set.of(token));

        sut.updateUserCredentials(updateTokenInformation);

        assertThat(tokenStore, is(Map.of(token, userCredentialsUpdated)));
        assertThat(userTokens, is(Map.of(id, Set.of(token))));
    }

    @Test
    public void updateUserCredentialsWithTokenUpdateException() throws AuthorizationTokenUpdateException {
        assertThat(tokenStore, anEmptyMap());
        assertThat(userTokens, anEmptyMap());

        final AuthorizationTokenUpdateException exception = assertThrows(AuthorizationTokenUpdateException.class, () -> {
            sut.updateUserCredentials(updateTokenInformation);
        });

        assertThat(exception.getMessage(), is("Token cannot be updated"));

        assertThat(tokenStore, anEmptyMap());
        assertThat(userTokens, anEmptyMap());
    }

    @Test
    public void deleteUserCredentials() {
        assertThat(tokenStore, anEmptyMap());
        assertThat(userTokens, anEmptyMap());

        tokenStore.put(token, userCredentials);
        userTokens.put(id, Set.of(token));

        sut.deleteUserCredentials(token);

        assertThat(tokenStore, anEmptyMap());
        assertThat(userTokens, anEmptyMap());
    }
}
