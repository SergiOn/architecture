package com.so.authentication.controller.handler;

import com.so.authentication.exception.UserExistedException;
import org.jboss.logging.Logger;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class UserExistedExceptionHandler implements ExceptionMapper<UserExistedException> {
    private static final Logger LOG = Logger.getLogger(UserExistedExceptionHandler.class);

    @Override
    public Response toResponse(final UserExistedException exception) {
        LOG.infov("Handler: UserExistedExceptionHandler, Exception: UserExistedException, Message: {0}", exception.getMessage());

        return Response.status(Response.Status.BAD_REQUEST)
                .entity(exception.getMessage())
                .type(MediaType.TEXT_PLAIN_TYPE)
                .build();
    }
}
