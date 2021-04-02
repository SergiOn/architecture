package com.so.authentication.controller.handler;

import com.so.authentication.model.response.ConstraintViolationExceptionResponse;
import org.jboss.logging.Logger;
import org.jboss.resteasy.spi.HttpRequest;

import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Provider
public class ConstraintViolationExceptionHandler implements ExceptionMapper<ConstraintViolationException> {
    private static final Logger LOG = Logger.getLogger(ConstraintViolationExceptionHandler.class);

    @Context
    private HttpRequest httpRequest;

    @Override
    public Response toResponse(final ConstraintViolationException exception) {
        LOG.infov("Handler: ConstraintViolationExceptionHandler, Exception: ConstraintViolationException, Message: {0}", exception.getMessage());
        LOG.infov("{0}: {1}, HttpHeaders: {2}", httpRequest.getHttpMethod(), httpRequest.getUri().getPath(), httpRequest.getHttpHeaders().getRequestHeaders());

        final List<ConstraintViolationExceptionResponse> validationResult = exception.getConstraintViolations().stream()
                .map(cv -> {
                    final String path = StreamSupport.stream(cv.getPropertyPath().spliterator(), false)
                            .map(Path.Node::getName)
                            .skip(2)
                            .collect(Collectors.joining("."));

                    return new ConstraintViolationExceptionResponse(path, cv.getInvalidValue(), cv.getMessage());
                })
                .sorted(Comparator.comparing(ConstraintViolationExceptionResponse::getPath))
                .collect(Collectors.toList());

        return Response.status(Response.Status.BAD_REQUEST)
                .entity(validationResult)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }
}
