package com.so.authentication.client.exception;

import org.jboss.resteasy.client.exception.ResteasyWebApplicationException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/*
* REQUEST_TIMEOUT(408, "Request Timeout")
* javax.ws.rs.core.Response.Status.REQUEST_TIMEOUT
* */

public class ResteasyWebApplication408Exception extends ResteasyWebApplicationException {

    public ResteasyWebApplication408Exception(final Response response) {
        super(new WebApplicationException(response));
    }
}
