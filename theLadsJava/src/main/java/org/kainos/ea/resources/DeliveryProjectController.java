package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.kainos.ea.api.DeliveryProjectService;
import org.kainos.ea.cli.DelivEmpRequest;
import org.kainos.ea.cli.DelivEmployee;
import org.kainos.ea.cli.Project;
import org.kainos.ea.client.DeliveryEmployeeDoesNotExistException;
import org.kainos.ea.client.FailedToCreateDelivEmpException;
import org.kainos.ea.client.FailedToUpdateDelivEmpException;
import org.kainos.ea.client.InvalidDelivEmpException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api("theLads API")
@Path("/api")
public class DeliveryProjectController {

    DeliveryProjectService deliveryProjectService = new DeliveryProjectService();
    @POST
    @Path("/addDeliveryEmployeeToProject/{id1D}_{id2P}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response assignDelivEmpToProject(@PathParam("id1D") int delivEmpId, @PathParam("id2P") int projectId) {
        try {
            deliveryProjectService.assignDelivEmpToProject(delivEmpId, projectId);
            return Response.ok().build();
        }
        catch (FailedToCreateDelivEmpException e) {
            System.err.println(e.getMessage());
            return Response.serverError().build();
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

        } catch (InvalidDelivEmpException | DeliveryEmployeeDoesNotExistException e) {
            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build(); //client side error
        } catch (FailedToUpdateDelivEmpException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        }
    }
}
