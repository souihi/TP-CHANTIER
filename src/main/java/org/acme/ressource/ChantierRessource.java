package org.acme.ressource;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.entity.Chantier;
import org.acme.service.ChantierService;

import java.util.List;

@Path("/chantier")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ChantierRessource {

    @Inject
    ChantierService chantierService;

    @GET
    @RolesAllowed("Chef de chantier")
    public List<Chantier> getChantier() {
        return chantierService.listChantier();
    }
    @GET
    @RolesAllowed("Chef de chantier")
    @Path("{id}")
    public Chantier getChantierById(long id){
        return chantierService.listChantierById(id);
    }

    @POST
    @RolesAllowed("Chef de chantier")
    public Response creatChantier(Chantier chantier){
        chantierService.creatChantier(chantier);
        return Response.ok(chantier).build();
    }

    @PUT
    @RolesAllowed("Chef de chantier")
    @Path("{id}")
    public Response updateChantier(long id, Chantier chantier){
        chantierService.updateChantier(id, chantier);
        return Response.ok().build();
    }
    @DELETE
    @RolesAllowed("Chef de chantier")
    @Path("{id}")
    public Response deleteChantier(long id){
       chantierService.deleteChantier(id);
       return Response.ok().build();
    }
}
