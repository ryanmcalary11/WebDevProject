package org.kainos.ea.db;
import org.kainos.ea.cli.Project;
import org.kainos.ea.cli.ProjectRequest;
import org.kainos.ea.cli.SalesEmployee;
import org.kainos.ea.cli.SalesEmployeeRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectDao {
    DatabaseConnector databaseConnector = new DatabaseConnector();


    public int createProject(ProjectRequest projectRequest) throws SQLException {

        Connection c = databaseConnector.getConnection();

        String insertStatement = "INSERT INTO Project (projectName, projectValue, clientID, techLeadID, isComplete) VALUES (?,?,?,?,?)";

        PreparedStatement s = c.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);

        s.setString(1, projectRequest.getProjectName());
        s.setDouble(2, projectRequest.getProjectValue());
        s.setInt(3, projectRequest.getClientId());
        s.setInt(4, projectRequest.getTechLeadId());
        s.setInt(5, projectRequest.getTechLeadId());

        s.executeUpdate();

        ResultSet rs = s.getGeneratedKeys();

        if (rs.next()) {
            return rs.getInt(1);
        }
        return -1;
    }


    public List<Project> getAllProjectsWithClient(int clientId) throws SQLException {
        Connection connection = DatabaseConnector.getConnection();
        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery("SELECT projectID, projectName, projectValue, clientID, techLeadID, isComplete FROM Project WHERE clientID=" + clientId  + ";");

        List<Project> projectList = new ArrayList<>();

        while (rs.next()) {
            Project project = new Project(
                    rs.getInt("projectID"),
                    rs.getString("projectName"),
                    rs.getFloat("projectValue"),
                    rs.getInt("clientID"),
                    rs.getInt("techLeadID"),
                    rs.getBoolean("isComplete")
            );

            projectList.add(project);
        }

        return projectList;
    }


    public void updateProjectToComplete(int id) throws SQLException {
        Connection connection = databaseConnector.getConnection();

        String updateStatement = "UPDATE Project SET isComplete = ? WHERE projectID =" + id;

        PreparedStatement s = connection.prepareStatement(updateStatement);

        s.setBoolean(1, true);

        s.executeUpdate();
    }

    public Project getProjectById(int id) throws SQLException {
        Connection connection = databaseConnector.getConnection();
        Statement s = connection.createStatement();

        ResultSet rs = s.executeQuery("SELECT *" +
                " FROM Project where projectID = " + id);

        while (rs.next()) {
            return new Project(
                    rs.getInt("projectID"),
                    rs.getString("projectName"),
                    rs.getFloat("projectValue"),
                    rs.getInt("clientID"),
                    rs.getInt("techLeadID"),
                    rs.getBoolean("isComplete")
            );
        }
        return null;
    }

}
