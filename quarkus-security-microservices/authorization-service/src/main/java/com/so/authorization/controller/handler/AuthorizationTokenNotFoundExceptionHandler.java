package com.so.authorization.controller.handler;

import com.so.authorization.exception.AuthorizationTokenNotFoundException;
import org.jboss.logging.Logger;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class AuthorizationTokenNotFoundExceptionHandler implements ExceptionMapper<AuthorizationTokenNotFoundException> {
    private static final Logger LOG = Logger.getLogger(AuthorizationTokenNotFoundExceptionHandler.class);

    @Override
    public Response toResponse(final AuthorizationTokenNotFoundException exception) {
        LOG.infov("Handler: TokenNotFoundExceptionHandler, Exception: TokenNotFoundException, Message: {0}", exception.getMessage());

        return Response.status(Response.Status.UNAUTHORIZED)
                .entity(exception.getMessage())
                .type(MediaType.TEXT_PLAIN_TYPE)
                .build();
    }
}
