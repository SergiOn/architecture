package com.so.authentication.controller.handler;

import org.jboss.logging.Logger;
import org.jboss.resteasy.client.exception.ResteasyWebApplicationException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ResteasyWebApplicationExceptionHandler implements ExceptionMapper<ResteasyWebApplicationException> {
    private static final Logger LOG = Logger.getLogger(ResteasyWebApplicationExceptionHandler.class);

    @Override
    public Response toResponse(final ResteasyWebApplicationException exception) {
        LOG.infov("Handler: ResteasyWebApplicationExceptionHandler, Exception: ResteasyWebApplicationException, Message: {0}", exception.getMessage());
        LOG.infov("Handler: ResteasyWebApplicationExceptionHandler, Exception: WebApplicationException, Message: {0}", exception.unwrap().getMessage());

        return exception.unwrap().getResponse();
    }
}
