package org.acme.ressource;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.entity.Utilisateur;
import org.acme.service.UtilisateurService;
import java.util.List;

@Path("/utilisateur")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UtlisateurRessource {

    @Inject
    UtilisateurService utilisateurService;

    @GET
    @RolesAllowed("Admin")
    public List<Utilisateur> getUtilisateurs() {
        return utilisateurService.utilisateurList();
    }

    @GET
    @RolesAllowed("Admin")
    @Path("{id}")
    public Utilisateur getUtilisateurById(long id){
        return utilisateurService.listUtilidateurById(id);
    }

    @POST
    @RolesAllowed("Admin")
    @Path("sign")
    public Response addUtilisateur(Utilisateur utilisateur) {
        utilisateurService.creatUtilisateur(utilisateur);
        return Response.ok(utilisateur).build();
    }

    @PUT
    @RolesAllowed("Admin")
    @Path("{id}")
    public Response updateUtilisateur(long id, Utilisateur utilisateur){
        utilisateurService.updateUtilisateur(id, utilisateur);
        return Response.ok().build();
    }
    @DELETE
    @RolesAllowed("Admin")
    @Path("{id}")
    public Response deleteUtilisateur(long id){
        utilisateurService.deleteUtilisateur(id);
        return Response.ok().build();
    }
}
