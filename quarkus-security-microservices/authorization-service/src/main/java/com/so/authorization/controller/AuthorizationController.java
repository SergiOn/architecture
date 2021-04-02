package com.so.authorization.controller;

import com.so.authorization.exception.AuthorizationTokenDuplicateException;
import com.so.authorization.exception.AuthorizationTokenNotFoundException;
import com.so.authorization.exception.AuthorizationTokenUpdateException;
import com.so.authorization.model.request.CreateTokenInformation;
import com.so.authorization.model.request.UpdateTokenInformation;
import com.so.authorization.model.response.UserCredentialsResponse;
import com.so.authorization.service.AuthorizationService;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/*
 * @Context HttpServerRequest httpServerRequest
 * @Context HttpRequest httpRequest
 * @Context Request request
 * @Context UriInfo uriInfo
 * @Context HttpHeaders httpHeaders
 * @HeaderParam("a") final String a
 * @HeaderParam("x") final String x
 * @Context SecurityContext securityContext
 * */

@Path("/")
public class AuthorizationController {
    private static final Logger LOG = Logger.getLogger(AuthorizationController.class);

    private final AuthorizationService authorizationService;

    @Inject
    public AuthorizationController(final AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @GET
    @Path("/user-credentials")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserCredentials(@Context final HttpHeaders httpHeaders) throws AuthorizationTokenNotFoundException {
        LOG.infov("GET: /user-credentials, HttpHeaders: {0}", httpHeaders.getRequestHeaders());
        final String authorizationHeader = httpHeaders.getHeaderString(HttpHeaders.AUTHORIZATION);
        final String userAgentHeader = httpHeaders.getHeaderString(HttpHeaders.USER_AGENT);
        final String forwardedHeader = httpHeaders.getHeaderString("Forwarded");
        final UserCredentialsResponse response = authorizationService.getUserCredentials(authorizationHeader, userAgentHeader, forwardedHeader);
        return Response.ok().entity(response).build();
    }

    @POST
    @Path("/user-credentials")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response postUserCredentials(
            @Context final HttpHeaders httpHeaders,
            @Valid final CreateTokenInformation createTokenInformation
    ) throws AuthorizationTokenDuplicateException {
        LOG.infov("POST: /user-credentials, CreateTokenInformation: {0}", createTokenInformation);
        final String userAgentHeader = httpHeaders.getHeaderString(HttpHeaders.USER_AGENT);
        final String forwarded = httpHeaders.getHeaderString("Forwarded");
        authorizationService.registerUserCredentials(userAgentHeader, forwarded, createTokenInformation);
        return Response.ok().build();
    }

    @PUT
    @Path("/user-credentials")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response putUserCredentials(
            @Context final HttpHeaders httpHeaders,
            @Valid final UpdateTokenInformation updateTokenInformation
    ) throws AuthorizationTokenUpdateException {
        LOG.infov("PUT: /user-credentials, UpdateTokenInformation: {0}", updateTokenInformation);
        authorizationService.updateUserCredentials(updateTokenInformation);
        return Response.ok().build();
    }

    @DELETE
    @Path("/user-credentials")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteUserCredentials(@HeaderParam(HttpHeaders.AUTHORIZATION) final String authorizationHeader) {
        LOG.infov("DELETE: /user-credentials, HttpHeader Authorization: {0}", authorizationHeader);
        authorizationService.deleteUserCredentials(authorizationHeader);
        return Response.ok().build();
    }

    @DELETE
    @Path("/user-credentials/{user-id}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteAllUserCredentials(@PathParam("user-id") final Long userId) {
        LOG.infov("DELETE: /user-credentials/{user-id}, User Id: {0}", userId);
        authorizationService.deleteAllUserCredentials(userId);
        return Response.ok().build();
    }
}
