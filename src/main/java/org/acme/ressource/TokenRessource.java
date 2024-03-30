package org.acme.ressource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.acme.service.TokenService;
@Path("token")
public class TokenRessource {
    @Inject
    TokenService tokenService;


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getToken() {
        return tokenService.generateToken();
    }
}
