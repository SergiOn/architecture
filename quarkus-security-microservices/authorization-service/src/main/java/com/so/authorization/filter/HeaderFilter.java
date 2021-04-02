package com.so.authorization.filter;

import io.vertx.core.http.HttpServerRequest;
import org.jboss.logging.Logger;
import org.jboss.resteasy.spi.Dispatcher;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import java.io.IOException;

//@Provider
public class HeaderFilter implements ContainerRequestFilter {
    private static final Logger LOG = Logger.getLogger(HeaderFilter.class);

    @Context
    HttpServerRequest request;

    @Context
    HttpHeaders httpHeaders;

    @Context
    Dispatcher dispatcher;

    @Override
    public void filter(final ContainerRequestContext requestContext) throws IOException {
        System.out.println(requestContext);
    }

}
