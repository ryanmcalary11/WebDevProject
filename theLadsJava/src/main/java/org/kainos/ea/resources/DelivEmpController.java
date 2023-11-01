package org.kainos.ea.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import io.swagger.annotations.Api;
import org.kainos.ea.api.DelivEmpService;
import org.kainos.ea.cli.DelivEmpRequest;
import org.kainos.ea.cli.DelivEmployee;
import org.kainos.ea.client.*;
import java.sql.SQLException;
import java.util.List;

@Api("theLads API")
@Path("/api")
public class DelivEmpController {
    private DelivEmpService delivEmpService = new DelivEmpService();
    @POST
    @Path("/deliveryEmployees")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createDelivEmployee(DelivEmpRequest delivEmp) {
        try {
            return Response.ok().entity(delivEmpService.createDelivEmployee(delivEmp)).build();
        }
        catch (FailedToCreateDelivEmpException e) {
            System.err.println(e.getMessage());
            return Response.serverError().build();
        } catch (InvalidDelivEmpException e) {
            System.err.println(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/deliveryEmployee/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDeliveryEmployeeById(@PathParam("id") int id)
    {
        try {
            return Response.ok(delivEmpService.getDelivEmpById(id)).build();
        } catch (FailedToGetDelivEmpException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        }catch(DeliveryEmployeeDoesNotExistException e){
            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @DELETE
    @Path("/deleteDeliveryEmployee/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteDEmp(@PathParam("id") int id){
        try{
            delivEmpService.deleteDelivEmployee(id);

            return Response.ok().build();
        }catch (DeliveryEmployeeDoesNotExistException e) {
            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).build();
        }catch (FailedToDeleteDelivEmpException e){
            System.err.println(e.getMessage());

            return Response.serverError().build();

        }
    }

    @GET
    @Path("/deliveryEmployees")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DelivEmployee> getDelivEmployees() throws SQLException {
        try {
            return delivEmpService.getAllDelivEmployees();
        } catch (FailedToGetDelivEmpException e) {
            throw new RuntimeException(e);
        }
    }

    @PUT
    @Path ("/deliveryEmployees/{id}")
    @Produces (MediaType .APPLICATION_JSON)
    public Response createDelivEmployee (@PathParam("id") int id, DelivEmpRequest delivEmp) {
        try {
            delivEmpService.updateDelivEmployee(id, delivEmp);
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
