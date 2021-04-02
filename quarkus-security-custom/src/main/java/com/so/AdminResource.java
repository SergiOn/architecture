package com.so;

import com.so.security.TokenPrincipal;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/admin")
public class AdminResource {

    private final TokenPrincipal tokenPrincipal;

    public AdminResource(TokenPrincipal tokenPrincipal) {
        this.tokenPrincipal = tokenPrincipal;
    }

    @GET
    @RolesAllowed("admin")
    @Produces(MediaType.TEXT_PLAIN)
    public String adminResource() {
        final Long userId = tokenPrincipal.getUserId();
        final String token = tokenPrincipal.token();
        return "admin : " + tokenPrincipal;
    }

}
