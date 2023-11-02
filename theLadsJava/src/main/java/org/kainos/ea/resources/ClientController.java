package org.kainos.ea.resources;
import io.swagger.annotations.Api;
import org.kainos.ea.api.ClientService;
import org.kainos.ea.client.FailedToGetClientsException;
import org.kainos.ea.client.FailedToGetProjectsException;
import org.kainos.ea.client.FailedToGetSalesEmployeeException;
import org.kainos.ea.client.SalesEmployeeDoesNotExistException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api("theLads API")
@Path("/api")
public class ClientController {
    ClientService clientService = new ClientService();

    @GET
    @Path("/clients")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllClientsInfo() {
        try {
            return Response.ok(clientService.getAllClientsInfo()).build();
        } catch (FailedToGetClientsException | FailedToGetProjectsException |
                 FailedToGetSalesEmployeeException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        } catch (SalesEmployeeDoesNotExistException e) {
            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @GET
    @Path("/clientHighestProjectValue")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClientHighestProjectValue() {
        try {
            return Response.ok(clientService.getClientHighestProjectValue()).build();
        } catch (FailedToGetClientsException | FailedToGetProjectsException |
                 FailedToGetSalesEmployeeException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        } catch (SalesEmployeeDoesNotExistException e) {
            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }


}
