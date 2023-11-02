package org.kainos.ea.cli;

import java.util.List;

public class ClientOutput {

    private int clientId;
    private String forename;
    private String surname;
    private SalesEmployee salesEmployee;
    private List<Project> projectList;


    public ClientOutput(Client client, SalesEmployee salesEmployee, List<Project> projectList) {
        this.clientId = clientId;
        this.forename = forename;
        this.surname = surname;
        this.salesEmployee = salesEmployee;
        this.projectList = projectList;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public SalesEmployee getSalesEmployee() {
        return salesEmployee;
    }

    public void setSalesEmployee(SalesEmployee salesEmployee) {
        this.salesEmployee = salesEmployee;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }
}
