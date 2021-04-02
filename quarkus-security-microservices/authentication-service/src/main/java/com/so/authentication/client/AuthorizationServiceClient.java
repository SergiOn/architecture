package com.so.authentication.client;

import com.so.authentication.client.factory.AuthorizationServiceClientHeadersFactory;
import com.so.authentication.client.provider.ExceptionResponseExceptionMapper;
import com.so.authentication.client.request.CreateTokenInformation;
import com.so.authentication.client.response.UserCredentialsResponse;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
@RegisterRestClient
@RegisterClientHeaders(AuthorizationServiceClientHeadersFactory.class)
@RegisterProvider(ExceptionResponseExceptionMapper.class)
public interface AuthorizationServiceClient {

    @GET
    @Path("/user-credentials")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    UserCredentialsResponse getUserCredentials();

    @POST
    @Path("/user-credentials")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    void postUserCredentials(final CreateTokenInformation createTokenInformation);

    @DELETE
    @Path("/user-credentials")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    void deleteUserCredentials();

    @DELETE
    @Path("/user-credentials/{user-id}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    void deleteAllUserCredentials(@PathParam("user-id") final Long userId);
}
