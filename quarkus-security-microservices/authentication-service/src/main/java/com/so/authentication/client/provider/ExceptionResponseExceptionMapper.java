package com.so.authentication.client.provider;

import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

/*
* https://itnext.io/how-to-deal-with-4xx-5xx-responses-in-microprofile-rest-client-2e16559f542
* */

public class ExceptionResponseExceptionMapper implements ResponseExceptionMapper<Exception> {

    @Override
    public Exception toThrowable(final Response response) {
        return new Exception();
    }

    @Override
    public boolean handles(final int status, final MultivaluedMap<String, Object> headers) {
        return false;
    }
}
