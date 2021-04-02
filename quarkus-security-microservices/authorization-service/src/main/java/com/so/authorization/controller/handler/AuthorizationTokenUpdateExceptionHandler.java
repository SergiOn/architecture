package com.so.authorization.controller.handler;

import com.so.authorization.exception.AuthorizationTokenUpdateException;
import org.jboss.logging.Logger;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class AuthorizationTokenUpdateExceptionHandler implements ExceptionMapper<AuthorizationTokenUpdateException> {
    private static final Logger LOG = Logger.getLogger(AuthorizationTokenUpdateExceptionHandler.class);

    @Override
    public Response toResponse(final AuthorizationTokenUpdateException exception) {
        LOG.infov("Handler: TokenUpdateExceptionHandler, Exception: TokenNotFoundException, Message: {0}", exception.getMessage());

        return Response.status(Response.Status.UNAUTHORIZED)
                .entity(exception.getMessage())
                .type(MediaType.TEXT_PLAIN_TYPE)
                .build();
    }
}
