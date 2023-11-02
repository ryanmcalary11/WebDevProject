package org.kainos.ea.api;
import org.kainos.ea.cli.Project;
import org.kainos.ea.cli.ProjectRequest;
import org.kainos.ea.cli.SalesEmployee;
import org.kainos.ea.cli.SalesEmployeeRequest;
import org.kainos.ea.client.*;
import org.kainos.ea.core.ProjectValidator;
import org.kainos.ea.db.ProjectDao;

import java.sql.SQLException;
import java.util.List;

public class ProjectService {
    ProjectDao projectDao = new ProjectDao();
    ProjectValidator projectValidator = new ProjectValidator();


    public int createProject(ProjectRequest projectRequest)
            throws FailedToCreateProjectException, InvalidProjectException {
        try {
            String validation = projectValidator.isValidProject(projectRequest);

            if (validation != null) {
                throw new InvalidProjectException(validation);
            }

            int id = projectDao.createProject(projectRequest);

            if (id == -1) {
                throw new FailedToCreateProjectException();
            }

            return id;
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToCreateProjectException();
        }
    }
    public List<Project> getAllProjectsWithClient(int clientId) throws FailedToGetProjectsException {
        List<Project> projectList;

        try {
            projectList = projectDao.getAllProjectsWithClient(clientId);
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetProjectsException();
        }

        return projectList;
    }


    public void updateProjectToComplete(int id) throws InvalidProjectException, ProjectDoesNotExistException, FailedToUpdateProjectException {
        try {
            //String validation = projectValidator.isValidProject(projectRequest);

//            if (validation != null) {
//                throw new InvalidProjectException(validation);
//            }

            projectDao.updateProjectToComplete(id);
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToUpdateProjectException();
        }
    }
}
