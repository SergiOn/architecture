package com.so.authentication.client.exception;

import org.jboss.resteasy.client.exception.ResteasyWebApplicationException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class ResteasyWebApplication5xxException extends ResteasyWebApplicationException {

    public ResteasyWebApplication5xxException(final Response response) {
        super(new WebApplicationException(response));
    }
}
