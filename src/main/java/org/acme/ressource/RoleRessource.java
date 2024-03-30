package org.acme.ressource;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.entity.Role;
import org.acme.service.RoleService;
import java.util.List;

@Path("/role")
@Consumes("application/json")
@Produces(MediaType.APPLICATION_JSON)
public class RoleRessource {

    @Inject
    RoleService roleService;

    @GET
    @RolesAllowed("Admin")
    public List<Role> getRole(){
        return roleService.listRole();
    }

    @GET
    @RolesAllowed("Admin")
    @Path("{id}")
    public Role getRole( long id){
        return roleService.listRoleById(id);
    }

    @POST
    @RolesAllowed("Admin")
    public Response postRole(Role role){
        roleService.createRole(role);
        return Response.ok(role).build();
    }

    @PUT
    @RolesAllowed("Admin")
    @Path("{id}")
    public Response putRole(long id, Role role){
        roleService.updateRole(id, role);
        return Response.ok().build();
    }

    @DELETE
    @RolesAllowed("Admin")
    @Path("{id}")
    public Response deleteRole(long id){
        roleService.deleteRole(id);
        return Response.ok().build();
    }
}
