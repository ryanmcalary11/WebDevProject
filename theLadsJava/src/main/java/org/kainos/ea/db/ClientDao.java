package org.kainos.ea.db;
import org.kainos.ea.cli.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class ClientDao {
    public List<ClientOutput> getAllClientsInfo() throws SQLException {
        Connection connection = DatabaseConnector.getConnection();
        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery("SELECT " +
                "Client.clientID, Client.forename, Client.surname, " +
                "Client.salesEmpID, " +
                "SalesEmployee.forename, " +
                "SalesEmployee.surname, SalesEmployee.salary, SalesEmployee.bankAccNum, " +
                "SalesEmployee.nINumber, SalesEmployee.comRate, projectID, " +
                "Project.projectName, Project.projectValue, Project.techLeadID, " +
                "Project.isComplete " +
                "FROM Client " +
                "JOIN SalesEmployee USING (salesEmpID) " +
                "JOIN Project USING (clientID)");

        HashMap<Integer, Client> clientIdToClient = new HashMap<>();
        HashMap<Integer, SalesEmployee> clientIdToSalesEmployee = new HashMap<>();
        HashMap<Integer, List<Project>> clientIdToProjectList = new HashMap<>();

        while (rs.next()) {
            Client client = new Client(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4)
            );
            clientIdToClient.put(client.getClientId(), client);

            SalesEmployee salesEmployee = new SalesEmployee(
                    client.getSalesEmpId(),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getBigDecimal(7),
                    rs.getString(8),
                    rs.getString(9),
                    rs.getBigDecimal(10)
            );
            clientIdToSalesEmployee.put(client.getClientId(), salesEmployee);

            Project project = new Project(
                    rs.getInt(11),
                    rs.getString(12),
                    rs.getFloat(13),
                    client.getClientId(),
                    rs.getInt(14),
                    rs.getBoolean(15)
            );

            List<Project> projectList = clientIdToProjectList.getOrDefault(
                    client.getClientId(), new ArrayList<>());
            projectList.add(project);
            clientIdToProjectList.put(client.getClientId(), projectList);
        }

        List<ClientOutput> clientOutputList = new ArrayList<>();
        for (int clientId: clientIdToClient.keySet()) {
            Client client = clientIdToClient.get(clientId);
            SalesEmployee salesEmployee = clientIdToSalesEmployee.get(clientId);
            List<Project> projectList = clientIdToProjectList.get(clientId);

            ClientOutput clientOutput = new ClientOutput(client, salesEmployee, projectList);
            clientOutputList.add(clientOutput);
        }
        return clientOutputList;
    }


    public Client getClientHighestProject() throws SQLException {
        Connection connection = DatabaseConnector.getConnection();
        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery("SELECT CONCAT(`Client`.forename,' ', `Client`.surname) as client_name, SUM(projectValue) AS total_project_value " +
                "FROM Project Join `Client` on `Client`.clientID = Project.clientID " +
                "ORDER BY total_project_value DESC " +
                "LIMIT 1;");

        while (rs.next()) {
            return new Client(
                    rs.getString("client_name"),
                    rs.getDouble("total_project_value")

            );

        }
        return null;

    }

}
