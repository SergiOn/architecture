package com.so.authorization.controller.handler;

import org.jboss.logging.Logger;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

// io.quarkus.resteasy.runtime.NotFoundExceptionMapper
// https://docs.jboss.org/resteasy/docs/2.2.1.GA/userguide/html/ExceptionHandling.html

//@Provider
public class NotFoundExceptionHandler implements ExceptionMapper<NotFoundException> {
    private static final Logger LOG = Logger.getLogger(NotFoundExceptionHandler.class);

    @Override
    public Response toResponse(final NotFoundException exception) {
        LOG.infov("Handler: NotFoundExceptionHandler, Exception: NotFoundException, Message: {0}", exception.getMessage());

        return Response.status(Response.Status.NOT_FOUND)
                .entity(exception.getMessage())
                .type(MediaType.TEXT_PLAIN_TYPE)
                .build();
    }
}
