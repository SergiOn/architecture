package com.so.user.security.client;

import com.so.user.security.client.response.UserCredentialResponse;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

@Path("/")
//@RegisterRestClient(baseUri = "http://localhost:8081/authorization")
@RegisterRestClient(configKey = "authorization-service-client")
public interface AuthorizationServiceClient {

    @GET
    @Path("/user-credentials")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    Uni<UserCredentialResponse> getUserCredential(
            @HeaderParam(HttpHeaders.AUTHORIZATION) String authorizationHeader,
            @HeaderParam(HttpHeaders.USER_AGENT) String userAgentHeader
    );
}
