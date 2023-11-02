package org.kainos.ea.cli;

public class Client { private int clientId;
    private String forename;
    private String surname;
    private int salesEmpId;

    private double projectValue;

    public Client(int clientId, String forename, String surname, int salesEmpId) {
        this.clientId = clientId;
        this.forename = forename;
        this.surname = surname;
        this.salesEmpId = salesEmpId;
    }

    public Client(String forename, double projectValue) {
        this.forename = forename;
        this.projectValue = projectValue;
    }

    public Client() {

    }

    public double getProjectValue() {
        return projectValue;
    }

    public void setProjectValue(double projectValue) {
        this.projectValue = projectValue;
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

    public int getSalesEmpId() {
        return salesEmpId;
    }

    public void setSalesEmpId(int salesEmpId) {
        this.salesEmpId = salesEmpId;
    }
}
