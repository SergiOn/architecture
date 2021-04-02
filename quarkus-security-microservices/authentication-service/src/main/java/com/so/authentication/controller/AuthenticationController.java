package com.so.authentication.controller;

import com.so.authentication.exception.UserDeleteException;
import com.so.authentication.exception.UserExistedException;
import com.so.authentication.exception.UserNotFoundException;
import com.so.authentication.model.request.DeleteRequest;
import com.so.authentication.model.request.LoginRequest;
import com.so.authentication.model.request.RegistrationRequest;
import com.so.authentication.model.response.UserCredentialsResponse;
import com.so.authentication.service.AuthenticationService;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class AuthenticationController {
    private static final Logger LOG = Logger.getLogger(AuthenticationController.class);

    private final AuthenticationService authenticationService;

    @Inject
    public AuthenticationController(final AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@Valid final LoginRequest body) throws UserNotFoundException {
        LOG.infov("POST: /login, LoginRequest: {0}", body);
        final UserCredentialsResponse userCredentials = authenticationService.login(body);
        return Response.ok()
                .header(HttpHeaders.AUTHORIZATION, userCredentials.getToken())
                .entity(userCredentials)
                .build();
    }

    @POST
    @Path("/registration")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response registration(@Valid final RegistrationRequest body) throws UserExistedException {
        LOG.infov("POST: /registration, RegistrationRequest: {0}", body);
        authenticationService.registration(body);
        return Response.ok().build();
    }

    @DELETE
    @Path("/logout")
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.TEXT_PLAIN)
    public Response logout() {
        LOG.infov("DELETE: /logout");
        authenticationService.logout();
        return Response.ok().build();
    }

    @DELETE
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response delete(@Valid final DeleteRequest body) throws UserDeleteException {
        LOG.infov("DELETE: /delete, DeleteRequest: {1}", body);
        authenticationService.delete(body);
        return Response.ok().build();
    }
}
