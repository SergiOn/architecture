package com.so.authentication.client.factory;

import org.eclipse.microprofile.rest.client.ext.ClientHeadersFactory;
import org.jboss.logging.Logger;
import org.jboss.resteasy.specimpl.MultivaluedMapImpl;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ApplicationScoped
public class AuthorizationServiceClientHeadersFactory implements ClientHeadersFactory {
    private static final Logger LOG = Logger.getLogger(AuthorizationServiceClientHeadersFactory.class);

    private static final List<String> headersName = List.of(
            HttpHeaders.AUTHORIZATION,
            HttpHeaders.USER_AGENT,
            "Forwarded"
    );

    @Override
    public MultivaluedMap<String, String> update(
            final MultivaluedMap<String, String> incomingHeaders,
            final MultivaluedMap<String, String> clientOutgoingHeaders
    ) {
        LOG.infov(
                "ClientHeadersFactory: AuthorizationServiceClientHeadersFactory, IncomingHeaders: {0}, ClientOutgoingHeaders: {1}",
                incomingHeaders,
                clientOutgoingHeaders
        );

        final MultivaluedMap<String, String> headers = new MultivaluedMapImpl<>();
        headers.putAll(clientOutgoingHeaders);

        final Map<String, List<String>> incomingFilteredHeaders = headersName.stream()
                .filter(incomingHeaders::containsKey)
                .map(header -> Map.entry(header, incomingHeaders.get(header)))
                .collect(Collectors.toUnmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));

        headers.putAll(incomingFilteredHeaders);

        return headers;
    }
}
