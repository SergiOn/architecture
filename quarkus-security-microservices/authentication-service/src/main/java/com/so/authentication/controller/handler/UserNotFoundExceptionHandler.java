package com.so.authentication.controller.handler;

import com.so.authentication.exception.UserNotFoundException;
import org.jboss.logging.Logger;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class UserNotFoundExceptionHandler implements ExceptionMapper<UserNotFoundException> {
    private static final Logger LOG = Logger.getLogger(UserNotFoundExceptionHandler.class);

    @Override
    public Response toResponse(final UserNotFoundException exception) {
        LOG.infov("Handler: UserNotFoundExceptionHandler, Exception: UserNotFoundException, Message: {0}", exception.getMessage());

        return Response.status(Response.Status.BAD_REQUEST)
                .entity(exception.getMessage())
                .type(MediaType.TEXT_PLAIN_TYPE)
                .build();
    }
}
