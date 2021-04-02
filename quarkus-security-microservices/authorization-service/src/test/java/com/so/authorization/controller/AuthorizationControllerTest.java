package com.so.authorization.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.so.authorization.exception.AuthorizationTokenDuplicateException;
import com.so.authorization.exception.AuthorizationTokenNotFoundException;
import com.so.authorization.exception.AuthorizationTokenUpdateException;
import com.so.authorization.model.Forwarded;
import com.so.authorization.model.request.CreateTokenInformation;
import com.so.authorization.model.request.CreateUserCredentials;
import com.so.authorization.model.request.UpdateTokenInformation;
import com.so.authorization.model.request.UpdateUserCredentials;
import com.so.authorization.model.response.ConstraintViolationExceptionResponse;
import com.so.authorization.model.response.UserCredentialsResponse;
import com.so.authorization.service.AuthorizationService;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.inject.Inject;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;

@QuarkusTest
@TestHTTPEndpoint(AuthorizationController.class)
@Tag("unit")
class AuthorizationControllerTest {

    @Inject
    ObjectMapper objectMapper;

    @InjectMock
    AuthorizationService authorizationService;

    private String token;
    private String tokenType;
    private String tokenValue;
    private LocalDateTime created;
    private LocalDateTime updated;
    private Long id;
    private String name;
    private Set<String> roles;
    private Set<String> rolesUpdate;
    private Set<Object> credentials;
    private Map<String, Object> attributes;
    private String userAgentHeader;
    private String forwardedHeader;
    private List<Forwarded> forwardedList;

    private Header authorizationHttpHeader;
    private Header userAgentHttpHeader;
    private Header forwardedHttpHeader;
    private Header applicationJSONHttpHeader;
    private Headers headers;

    private CreateUserCredentials createUserCredentials;
    private UpdateUserCredentials updatedUserCredentials;
    private UserCredentialsResponse userCredentialsResponse;

    private String algorithm;
    private String hash;
    private CreateTokenInformation createTokenInformation;
    private CreateTokenInformation createTokenInformationInvalid;
    private List<ConstraintViolationExceptionResponse> createTokenInformationInvalidResponse;
    private UpdateTokenInformation updateTokenInformation;
    private UpdateTokenInformation updateTokenInformationInvalid;
    private List<ConstraintViolationExceptionResponse> updateTokenInformationInvalidResponse;

    @BeforeEach
    public void beforeEach() {
        tokenType = "Bearer";
        tokenValue = "token-value";
        token = tokenType + " " + tokenValue;
        created = LocalDateTime.of(2021, Month.MARCH, 22, 1, 1);
        updated = LocalDateTime.of(2021, Month.APRIL, 23, 1, 1);
        id = 1L;
        name = "User name";
        roles = Set.of("ADMIN");
        rolesUpdate = Set.of("ADMIN", "USER");
        credentials = Set.of();
        attributes = Map.of();
        userAgentHeader = "Mozilla/5.0 (Macintosh; Intel Mac OS X 11_2_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.90 Safari/537.36";
        forwardedHeader = "by=127.0.0.1;for=127.0.0.1;host=localhost:8081;proto=http";

        authorizationHttpHeader = new Header(HttpHeaders.AUTHORIZATION, token);
        userAgentHttpHeader = new Header(HttpHeaders.USER_AGENT, userAgentHeader);
        forwardedHttpHeader = new Header("Forwarded", forwardedHeader);
        applicationJSONHttpHeader = new Header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
        headers = new Headers(authorizationHttpHeader, userAgentHttpHeader, forwardedHttpHeader, applicationJSONHttpHeader);

        createUserCredentials = new CreateUserCredentials(token, tokenType, tokenValue, created, id, name, roles, credentials, attributes);
        updatedUserCredentials = new UpdateUserCredentials(updated, id, name, rolesUpdate, credentials, attributes);
        userCredentialsResponse = new UserCredentialsResponse(token, id, name, roles, credentials, attributes);

        algorithm = "RSA";
        hash = "hash";
        createTokenInformation = new CreateTokenInformation(algorithm, hash, createUserCredentials);
        createTokenInformationInvalid = new CreateTokenInformation(null, null, null);
        createTokenInformationInvalidResponse = List.of(
                new ConstraintViolationExceptionResponse("algorithm", null, "must not be null"),
                new ConstraintViolationExceptionResponse("hash", null, "must not be null"),
                new ConstraintViolationExceptionResponse("userCredentials", null, "must not be null")
        );
        updateTokenInformation = new UpdateTokenInformation(algorithm, hash, updatedUserCredentials);
        updateTokenInformationInvalid = new UpdateTokenInformation(null, null, null);
        updateTokenInformationInvalidResponse = List.of(
                new ConstraintViolationExceptionResponse("algorithm", null, "must not be null"),
                new ConstraintViolationExceptionResponse("hash", null, "must not be null"),
                new ConstraintViolationExceptionResponse("userCredentials", null, "must not be null")
        );
    }

    @Test
    public void getUserCredentials() throws JsonProcessingException, AuthorizationTokenNotFoundException {
        final String responseJson = objectMapper.writeValueAsString(userCredentialsResponse);

        Mockito.when(authorizationService.getUserCredentials(anyString(), anyString(), anyString())).thenReturn(userCredentialsResponse);

        RestAssured.given()
                .when()
                .headers(headers)
                .get(URI.create("/user-credentials"))
                .then()
                .statusCode(Response.Status.OK.getStatusCode())
                .body(is(responseJson));

        Mockito.verify(authorizationService, Mockito.times(1)).getUserCredentials(eq(token), eq(userAgentHeader), eq(forwardedHeader));
    }

    @Test
    public void getUserCredentialsWithTokenNotFoundException() throws AuthorizationTokenNotFoundException {
        final String exceptionMessage = "Authorization token is not registered: " + token;

        Mockito.when(authorizationService.getUserCredentials(anyString(), anyString(), anyString())).thenThrow(new AuthorizationTokenNotFoundException(exceptionMessage));

        RestAssured.given()
                .when()
                .headers(headers)
                .get(URI.create("/user-credentials"))
                .then()
                .statusCode(Response.Status.UNAUTHORIZED.getStatusCode())
                .body(is(exceptionMessage));

        Mockito.verify(authorizationService, Mockito.times(1)).getUserCredentials(eq(token), eq(userAgentHeader), eq(forwardedHeader));
    }

    @Test
    public void postUserCredentials() throws AuthorizationTokenDuplicateException {
        Mockito.doNothing().when(authorizationService)
                .registerUserCredentials(anyString(), anyString(), any(CreateTokenInformation.class));

        RestAssured.given()
                .when()
                .headers(headers)
                .body(createTokenInformation)
                .post(URI.create("/user-credentials"))
                .then()
                .statusCode(Response.Status.OK.getStatusCode());

        Mockito.verify(authorizationService, Mockito.times(1))
                .registerUserCredentials(eq(userAgentHeader), eq(forwardedHeader), eq(createTokenInformation));
    }

    @Test
    public void postUserCredentialsWithConstraintViolationException() throws JsonProcessingException, AuthorizationTokenDuplicateException {
        final String responseJson = objectMapper.writeValueAsString(createTokenInformationInvalidResponse);

        Mockito.doNothing().when(authorizationService)
                .registerUserCredentials(anyString(), anyString(), any(CreateTokenInformation.class));

        RestAssured.given()
                .when()
                .headers(headers)
                .body(createTokenInformationInvalid)
                .post(URI.create("/user-credentials"))
                .then()
                .statusCode(Response.Status.BAD_REQUEST.getStatusCode())
                .body(is(responseJson));

        Mockito.verify(authorizationService, Mockito.never()).registerUserCredentials(any(), any(), any());
    }

    @Test
    public void postUserCredentialsWithTokenDuplicateException() throws AuthorizationTokenDuplicateException {
        final String message = "Token cannot be saved in duplicate reason";

        Mockito.doThrow(new AuthorizationTokenDuplicateException(message)).when(authorizationService)
                .registerUserCredentials(anyString(), anyString(), any(CreateTokenInformation.class));

        RestAssured.given()
                .when()
                .headers(headers)
                .body(createTokenInformation)
                .post(URI.create("/user-credentials"))
                .then()
                .statusCode(Response.Status.CONFLICT.getStatusCode())
                .body(is(message));

        Mockito.verify(authorizationService, Mockito.times(1))
                .registerUserCredentials(eq(userAgentHeader), eq(forwardedHeader), eq(createTokenInformation));
    }

    @Test
    public void putUserCredentials() throws AuthorizationTokenUpdateException {
        Mockito.doNothing().when(authorizationService).updateUserCredentials(any(UpdateTokenInformation.class));

        RestAssured.given()
                .when()
                .headers(headers)
                .body(updateTokenInformation)
                .put(URI.create("/user-credentials"))
                .then()
                .statusCode(Response.Status.OK.getStatusCode());

        Mockito.verify(authorizationService, Mockito.times(1)).updateUserCredentials(eq(updateTokenInformation));
    }

    @Test
    public void putUserCredentialsWithConstraintViolationException() throws JsonProcessingException, AuthorizationTokenUpdateException {
        final String responseJson = objectMapper.writeValueAsString(updateTokenInformationInvalidResponse);

        Mockito.doNothing().when(authorizationService).updateUserCredentials(any(UpdateTokenInformation.class));

        RestAssured.given()
                .when()
                .headers(headers)
                .body(updateTokenInformationInvalid)
                .put(URI.create("/user-credentials"))
                .then()
                .statusCode(Response.Status.BAD_REQUEST.getStatusCode())
                .body(is(responseJson));

        Mockito.verify(authorizationService, Mockito.never()).updateUserCredentials(any());
    }

    @Test
    public void putUserCredentialsWithTokenUpdateException() throws AuthorizationTokenUpdateException {
        final String message = "Token cannot be updated";

        Mockito.doThrow(new AuthorizationTokenUpdateException(message)).when(authorizationService).updateUserCredentials(any(UpdateTokenInformation.class));

        RestAssured.given()
                .when()
                .headers(headers)
                .body(updateTokenInformation)
                .put(URI.create("/user-credentials"))
                .then()
                .statusCode(Response.Status.UNAUTHORIZED.getStatusCode())
                .body(is(message));

        Mockito.verify(authorizationService, Mockito.times(1)).updateUserCredentials(eq(updateTokenInformation));
    }

    @Test
    public void deleteUserCredentials() {
        Mockito.doNothing().when(authorizationService).deleteUserCredentials(any(String.class));

        RestAssured.given()
                .when()
                .headers(headers)
                .delete(URI.create("/user-credentials"))
                .then()
                .statusCode(Response.Status.OK.getStatusCode());

        Mockito.verify(authorizationService, Mockito.times(1)).deleteUserCredentials(eq(token));
    }
}
