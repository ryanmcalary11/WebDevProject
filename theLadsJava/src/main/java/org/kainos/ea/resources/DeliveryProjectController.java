package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.kainos.ea.api.DeliveryProjectService;
import org.kainos.ea.cli.DelivEmpRequest;
import org.kainos.ea.cli.DelivEmployee;
import org.kainos.ea.cli.Project;
import org.kainos.ea.client.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api("theLads API")
@Path("/api")
public class DeliveryProjectController {

    DeliveryProjectService deliveryProjectService = new DeliveryProjectService();
    @POST
    @Path("/addDeliveryEmployeeToProject/{delivEmpId}_{projectId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response assignDelivEmpToProject(@PathParam("delivEmpId") int delivEmpId, @PathParam("projectId") int projectId) {
        try {
            deliveryProjectService.assignDelivEmpToProject(delivEmpId, projectId);
            return Response.ok().build();
        } catch (InvalidDelivEmpException e) {
            System.err.println(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @PUT
    @Path ("/removeDeliveryEmployeeToProject/{delivEmpId}_{projectId}")
    @Produces (MediaType .APPLICATION_JSON)
    public Response removeDelivEmployeeFromProject (@PathParam("delivEmpId") int delivEmpId, @PathParam("projectId") int projectId) {
        try {
            deliveryProjectService.removeDelivEmployeeFromProject(delivEmpId, projectId);
            return Response.ok().build();

        } catch (InvalidDelivEmpException e) {
            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build(); //client side error
        }
        catch (FailedToRemoveDeliveryEmpFromProject e) {
            throw new RuntimeException(e);
        }
    }
}
