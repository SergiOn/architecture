package com.so.authorization.controller.handler;

import com.so.authorization.exception.AuthorizationTokenDuplicateException;
import org.jboss.logging.Logger;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class AuthorizationTokenDuplicateExceptionHandler implements ExceptionMapper<AuthorizationTokenDuplicateException> {
    private static final Logger LOG = Logger.getLogger(AuthorizationTokenDuplicateExceptionHandler.class);

    @Override
    public Response toResponse(final AuthorizationTokenDuplicateException exception) {
        LOG.infov("Handler: TokenDuplicateExceptionHandler, Exception: TokenDuplicateException, Message: {0}", exception.getMessage());
        return Response.status(Response.Status.CONFLICT)
                .entity(exception.getMessage())
                .type(MediaType.TEXT_PLAIN_TYPE)
                .build();
    }
}
