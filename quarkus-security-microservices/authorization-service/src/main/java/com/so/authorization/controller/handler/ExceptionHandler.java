package com.so.authorization.controller.handler;

import org.jboss.logging.Logger;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

//@Provider
public class ExceptionHandler implements ExceptionMapper<Exception> {
    private static final Logger LOG = Logger.getLogger(ExceptionHandler.class);

    @Override
    public Response toResponse(final Exception exception) {
        LOG.infov("Handler: ExceptionHandler, Exception: Exception, Message: {0}", exception.getMessage());

        return Response.serverError()
                .entity(exception.getMessage())
                .type(MediaType.TEXT_PLAIN_TYPE)
                .build();
    }
}
