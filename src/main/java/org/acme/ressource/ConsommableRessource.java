package org.acme.ressource;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.entity.Consommable;
import org.acme.service.ConsommableService;

import java.util.List;

@Path("/consommable")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ConsommableRessource {
    @Inject
    ConsommableService consommableService;

    @GET
    @RolesAllowed("Chef de chantier")
    public List<Consommable> getConsommable(){
        return consommableService.listConsommable();
    }

    @GET
    @RolesAllowed("Chef de chantier")
    @Path("{id}")
    public Consommable getConsommable(long id){
        return consommableService.listConsommableById(id);
    }

    @POST
    @RolesAllowed("Chef de chantier")
    public Response postConsommable(Consommable consommable){
        consommableService.createConsommable(consommable);
        return Response.ok(consommable).build();
    }

    @PUT
    @RolesAllowed("Chef de chantier")
    @Path("{id}")
    public Response putConsommable(long id, Consommable consommable){
        consommableService.updateConsommable(id, consommable);
        return  Response.ok(consommable).build();
    }

    @DELETE
    @RolesAllowed("Chef de chantier")
    @Path("{id}")
    public Response deleteConsommable(long id){
        consommableService.delete(id);
        return Response.ok().build();
    }
}
