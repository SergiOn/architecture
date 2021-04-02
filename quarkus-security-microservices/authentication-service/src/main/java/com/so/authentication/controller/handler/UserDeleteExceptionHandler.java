package com.so.authentication.controller.handler;

import com.so.authentication.exception.UserDeleteException;
import org.jboss.logging.Logger;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class UserDeleteExceptionHandler implements ExceptionMapper<UserDeleteException> {
    private static final Logger LOG = Logger.getLogger(UserDeleteExceptionHandler.class);

    @Override
    public Response toResponse(final UserDeleteException exception) {
        LOG.infov("Handler: UserDeleteExceptionHandler, Exception: UserDeleteException, Message: {0}", exception.getMessage());

        return Response.status(Response.Status.BAD_REQUEST)
                .entity(exception.getMessage())
                .type(MediaType.TEXT_PLAIN_TYPE)
                .build();
    }
}
