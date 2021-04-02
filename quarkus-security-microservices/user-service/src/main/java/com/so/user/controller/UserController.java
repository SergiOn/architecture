package com.so.user.controller;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/")
public class UserController {

    @GET
    @Path("/hello")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    @PermitAll
    public Response getHello(@Context final SecurityContext securityContext) {
        final String entity = "hello [all], security context: " + securityContext.getUserPrincipal();
        return Response.ok().entity(entity).build();
    }

    @GET
    @Path("/hello/user")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed("user")
    public Response getHelloUser(@Context final SecurityContext securityContext) {
        final String entity = "hello [user], security context: " + securityContext.getUserPrincipal();
        return Response.ok().entity(entity).build();
    }

    @GET
    @Path("/hello/admin")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed("admin")
    public Response getHelloAdmin(@Context final SecurityContext securityContext) {
        final String entity = "hello [admin], security context: " + securityContext.getUserPrincipal();
        return Response.ok().entity(entity).build();
    }

    @GET
    @Path("/hello/superhero")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed("superhero")
    public Response getHelloSuperhero(@Context final SecurityContext securityContext) {
        final String entity = "hello [superhero], security context: " + securityContext.getUserPrincipal();
        return Response.ok().entity(entity).build();
    }

    @GET
    @Path("/hello/deny")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    @DenyAll
    public Response getHelloDenyAll(@Context final SecurityContext securityContext) {
        final String entity = "hello [deny], security context: " + securityContext.getUserPrincipal();
        return Response.ok().entity(entity).build();
    }
}
