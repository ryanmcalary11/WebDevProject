package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.kainos.ea.api.SalesEmployeeService;
import org.kainos.ea.cli.SalesEmployeeRequest;
import org.kainos.ea.client.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api("theLads API")
@Path("/api")
public class SalesEmployeeController {
    private SalesEmployeeService salesEmployeeService = new SalesEmployeeService();

    @POST
    @Path("/sales-employees")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createSalesEmployee(SalesEmployeeRequest salesEmployeeRequest) {
        try {
            return Response.ok(salesEmployeeService.createSalesEmployee(salesEmployeeRequest)).build();
        }
        catch (FailedToCreateSalesEmployeeException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        }
        catch (InvalidSalesEmployeeException e) {
            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/sales-employees/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSalesEmployeeById(@PathParam("id") int id) {
        try {
            return Response.ok(salesEmployeeService.getSalesEmployeeById(id)).build();
        }
        catch (FailedToGetSalesEmployeeException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        }
        catch (SalesEmployeeDoesNotExistException e) {
            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
    @PUT
    @Path("/sales-employees/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateSalesEmployee(@PathParam("id") int id,SalesEmployeeRequest salesEmployee) {
        try {
            salesEmployeeService.updateSalesEmployee(id, salesEmployee);

            return Response.ok().build();
        }
        catch (FailedToUpdateSalesEmployeeException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        }
        catch (SalesEmployeeDoesNotExistException | InvalidSalesEmployeeException e) {
            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
    @GET
    @Path("/all-sales-employees")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllSalesEmployees() {
        try {
            return Response.ok(salesEmployeeService.getAllSalesEmployees()).build();
        } catch (FailedToGetAllSalesEmployeesException e) {
            System.err.println(e.getMessage());

            return  Response.serverError().build();
        }
    }

    @DELETE
    @Path("/sales-employee/{id}")
    @Produces(MediaType.APPLICATION_JSON)

    public Response deleteSalesEmployee(@PathParam("id") int id)
    {
        try
        {
            salesEmployeeService.deleteSalesEmployee(id);

            return Response.ok().build();
        }
        catch (SalesEmployeeDoesNotExistException e)
        {
            System.err.println(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        catch (FailedToDeleteSalesEmployeeException e)
        {
            System.err.println(e.getMessage());
            return Response.serverError().build();
        }

    }



}
