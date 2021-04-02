package com.so;

import com.so.security.TokenPrincipal;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.security.Principal;

@Path("/user")
public class UserResource {

    private final TokenPrincipal tokenPrincipal;

    public UserResource(final TokenPrincipal tokenPrincipal) {
        this.tokenPrincipal = tokenPrincipal;
    }

    @GET
    @RolesAllowed("user")
    @Produces(MediaType.TEXT_PLAIN)
    public String me(@Context SecurityContext securityContext) {
        final Principal principal = securityContext.getUserPrincipal();
        final Long userId = tokenPrincipal.getUserId();
        final String token = tokenPrincipal.token();
        return principal.getName() + " : " + tokenPrincipal;
    }

}
