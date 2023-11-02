package org.kainos.ea.resources;
import io.swagger.annotations.Api;
import org.kainos.ea.api.ProjectService;
import org.kainos.ea.cli.ProjectRequest;
import org.kainos.ea.cli.SalesEmployeeRequest;
import org.kainos.ea.client.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api("theLads API")
@Path("/api")
public class ProjectController {
    ProjectService projectService = new ProjectService();


    @POST
    @Path("/project")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createProject(ProjectRequest projectRequest) {
        try {
            return Response.ok(projectService.createProject(projectRequest)).build();
        }
        catch (FailedToCreateProjectException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        }
        catch (InvalidProjectException e) {
            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/projects/{clientId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProjectsWithClient(@PathParam("clientId") int clientId) {
        try {
            return Response.ok(projectService.getAllProjectsWithClient(clientId)).build();
        } catch (FailedToGetProjectsException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/updateProjectToComplete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateProjectToComplete(@PathParam("id") int id) {
        try {
            projectService.updateProjectToComplete(id);

            return Response.ok().build();
        }
        catch (FailedToUpdateProjectException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        }
        catch (ProjectDoesNotExistException | InvalidProjectException e) {
            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

}
