package org.acme.ressource;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.acme.entity.Tache;
import org.acme.service.TacheService;

import java.util.List;

@Path("/tache")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TacheRessource {
    @Inject
    TacheService tacheService;

    @GET
    @RolesAllowed("Chef de chantier")
    public List<Tache> getTache(){
        return tacheService.listTache();
    }
    @GET
    @RolesAllowed("Chef de chantier")
    @Path("{id}")
    public Tache getTacheById(long id){
        return tacheService.listTacheById(id);
    }

    @POST
    @RolesAllowed("Chef de chantier")
    public Response postTache(Tache tache){
        tacheService.createTache(tache);
        return Response.ok(tache).build();
    }

    @PUT
    @RolesAllowed("Chef de chantier")
    @Path("{id}")
    public Response putTache(long id, Tache tache){
        tacheService.updateTache(id, tache);
        return Response.ok(tache).build();
    }

    @DELETE
    @RolesAllowed("Chef de chantier")
    @Path("{id}")
    public Response deleteTache(long id){
        tacheService.deleteTache(id);
        return  Response.ok().build();
    }
}
