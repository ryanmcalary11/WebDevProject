package org.kainos.ea.api;
import org.kainos.ea.cli.Client;
import org.kainos.ea.cli.ClientOutput;
import org.kainos.ea.cli.Project;
import org.kainos.ea.cli.SalesEmployee;
import org.kainos.ea.client.FailedToGetClientsException;
import org.kainos.ea.client.FailedToGetProjectsException;
import org.kainos.ea.client.FailedToGetSalesEmployeeException;
import org.kainos.ea.client.SalesEmployeeDoesNotExistException;
import org.kainos.ea.db.ClientDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ClientService {
    ClientDao clientDao = new ClientDao();
    SalesEmployeeService salesEmployeeService = new SalesEmployeeService();
    ProjectService projectService = new ProjectService();

    public List<ClientOutput> getAllClientsInfo()
            throws FailedToGetClientsException,
            FailedToGetSalesEmployeeException,
            SalesEmployeeDoesNotExistException,
            FailedToGetProjectsException {
        List<ClientOutput> clientOutputList = null;

        try {
            clientOutputList = clientDao.getAllClientsInfo();
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetClientsException();
        }

        return clientOutputList;
    }

    public Client getClientHighestProjectValue()
            throws FailedToGetClientsException,
            FailedToGetSalesEmployeeException,
            SalesEmployeeDoesNotExistException,
            FailedToGetProjectsException {

        Client client = new Client();


        try {
            client = clientDao.getClientHighestProject();
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetClientsException();
        }

        return client;
    }
}
