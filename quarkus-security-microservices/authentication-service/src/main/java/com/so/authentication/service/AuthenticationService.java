package com.so.authentication.service;

import com.so.authentication.client.AuthorizationServiceClient;
import com.so.authentication.client.request.CreateTokenInformation;
import com.so.authentication.client.request.CreateUserCredentials;
import com.so.authentication.exception.UserDeleteException;
import com.so.authentication.exception.UserExistedException;
import com.so.authentication.exception.UserNotFoundException;
import com.so.authentication.model.UserCredentials;
import com.so.authentication.model.request.DeleteRequest;
import com.so.authentication.model.request.LoginRequest;
import com.so.authentication.model.request.RegistrationRequest;
import com.so.authentication.model.response.UserCredentialsResponse;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;
import org.jboss.resteasy.client.exception.ResteasyWebApplicationException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.ProcessingException;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class AuthenticationService {
    private static final Logger LOG = Logger.getLogger(AuthenticationService.class);

    private final Map<String, UserCredentials> users = new ConcurrentHashMap<>();

    private final AuthorizationServiceClient authorizationServiceClient;

    @Inject
    public AuthenticationService(@RestClient final AuthorizationServiceClient authorizationServiceClient) {
        this.authorizationServiceClient = authorizationServiceClient;
    }

    public UserCredentialsResponse login(final LoginRequest loginRequest) throws UserNotFoundException {
        LOG.infov("Method: login, LoginRequest: {0}", loginRequest);
        final String email = loginRequest.getEmail();
        final UserCredentials userCredentials = users.get(email);

        if (userCredentials == null) {
            throw new UserNotFoundException("User is not found with email: " + email);
        }

        final String algorithm = "algorithm";
        final String hash = "hash";
        final String tokenType = "Bearer";
//        final String tokenValue = "token-" + userCredentials.getName() + "-" + userCredentials.getId() + "-" + LocalDateTime.now();
        final String tokenValue = "token-" + userCredentials.getName() + "-" + userCredentials.getId();
        final String token = tokenType + " " + tokenValue;
        final LocalDateTime created = LocalDateTime.now();

        final CreateTokenInformation createTokenInformation = new CreateTokenInformation(
                algorithm,
                hash,
                new CreateUserCredentials(
                        token,
                        tokenType,
                        tokenValue,
                        created,
                        userCredentials.getId(),
                        userCredentials.getName(),
                        userCredentials.getRoles(),
                        userCredentials.getCredentials(),
                        userCredentials.getAttributes()
                )
        );

        authorizationServiceClientPostUserCredentials(createTokenInformation);

        return new UserCredentialsResponse(
                token,
                created,
                userCredentials.getName(),
                userCredentials.getEmail(),
                userCredentials.getPhone(),
                userCredentials.getId(),
                userCredentials.getRoles(),
                userCredentials.getCredentials(),
                userCredentials.getAttributes()
        );
    }

    @Retry(maxRetries = 2, delay = 1000, jitter = 0)
//    @Retry(maxRetries = 2, delay = 1000, jitter = 0, retryOn = ProcessingException.class)
//    @Retry(maxRetries = 2, delay = 1000, jitter = 0, retryOn = ResteasyWebApplicationException.class)
    protected void authorizationServiceClientPostUserCredentials(final CreateTokenInformation createTokenInformation) {
        LOG.infov("Rest Client: authorizationServiceClient, Request: postUserCredentials, CreateTokenInformation: {0}", createTokenInformation);
        authorizationServiceClient.postUserCredentials(createTokenInformation);
    }

    public void registration(final RegistrationRequest registrationRequest) throws UserExistedException {
        LOG.infov("Method: registration, RegistrationRequest: {0}", registrationRequest);
        final String email = registrationRequest.getEmail();
        final boolean userExisted = users.containsKey(email);

        if (userExisted) {
            throw new UserExistedException("User is existed with email: " + email);
        }

        final long id = (long) users.size() + 1;
        final UserCredentials userCredentials = new UserCredentials(
                registrationRequest.getName(),
                registrationRequest.getPassword(),
                email,
                registrationRequest.getPhone(),
                id,
                Set.of("admin", "user"),
                Set.of(),
                Map.of()
        );

        users.put(email, userCredentials);
    }

    public void logout() {
        LOG.info("Method: logout");
        authorizationServiceClientDeleteUserCredentials();
    }

    @Retry(maxRetries = 2, delay = 1000, jitter = 0, retryOn = ProcessingException.class)
    protected void authorizationServiceClientDeleteUserCredentials() {
        LOG.info("Rest Client: authorizationServiceClient, Request: deleteUserCredentials");
        authorizationServiceClient.deleteUserCredentials();
    }

    public void delete(final DeleteRequest deleteRequest) throws UserDeleteException {
        LOG.infov("Method: delete, DeleteRequest: {0}", deleteRequest);
        final String email = deleteRequest.getEmail();
        final String password = deleteRequest.getPassword();
        final UserCredentials userCredentials = users.get(email);

        if (userCredentials == null || !userCredentials.getPassword().equals(password)) {
            throw new UserDeleteException("Cannot delete user with email: " + email);
        }

        authorizationServiceClientDeleteAllUserCredentials(userCredentials.getId());

        users.remove(email);
    }

    @Retry(maxRetries = 2, delay = 1000, jitter = 0, retryOn = ProcessingException.class)
    protected void authorizationServiceClientDeleteAllUserCredentials(final Long userId) {
        LOG.info("Rest Client: authorizationServiceClient, Request: deleteAllUserCredentials");
        authorizationServiceClient.deleteAllUserCredentials(userId);
    }
}
