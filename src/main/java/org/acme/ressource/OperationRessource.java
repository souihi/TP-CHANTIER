package org.acme.ressource;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.entity.Operation;
import org.acme.service.OperationService;


import java.util.List;

@Path("/operation")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OperationRessource {

    @Inject
    OperationService operationService;

    @GET
    @RolesAllowed("Chef de chantier, Ouvrier")
    public List<Operation> getOperation(){
        return operationService.listOperation();
    }

    @GET
    @RolesAllowed("Chef de chantier")
    @Path("{id}")
    public Operation getOperationById(long id){
        return operationService.operationById(id);
    }

    @POST
    @RolesAllowed("Chef de chantier")
    public Response creatOperation(Operation operation){
        operationService.creatOperation(operation);
        return Response.ok(operation).build();
    }

    @PUT
    @RolesAllowed("Chef de chantier")
    @Path("{id}")
    public Response updateOperation(long id, Operation operation){
        operationService.updateOperation(id, operation);
        return Response.ok(operation).build();
    }

    @DELETE
    @RolesAllowed("Chef de chantier")
    @Path("{id}")
    public Response deleteOperation(long id){
         operationService.deleteOperation(id);
        return Response.ok().build();
    }
}
