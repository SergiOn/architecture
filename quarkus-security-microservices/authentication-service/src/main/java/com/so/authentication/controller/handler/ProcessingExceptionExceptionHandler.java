package com.so.authentication.controller.handler;

import org.jboss.logging.Logger;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ProcessingExceptionExceptionHandler implements ExceptionMapper<ProcessingException> {
    private static final Logger LOG = Logger.getLogger(ProcessingExceptionExceptionHandler.class);

    @Override
    public Response toResponse(final ProcessingException exception) {
        LOG.infov("Handler: ProcessingExceptionExceptionHandler, Exception: ProcessingException, Message: {0}", exception.getMessage());

        return Response.status(Response.Status.SERVICE_UNAVAILABLE)
                .entity(exception.getMessage())
                .type(MediaType.TEXT_PLAIN_TYPE)
                .build();
    }
}
