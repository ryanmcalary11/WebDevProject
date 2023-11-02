package org.kainos.ea.cli;

public class Client {
    private int clientId;
    private int salesEmpId;
    private String clientName;

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getSalesEmpId() {
        return salesEmpId;
    }

    public void setSalesEmpId(int salesEmpId) {
        this.salesEmpId = salesEmpId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Client(int clientId, int salesEmpId, String clientName) {
        this.clientId = clientId;
        this.salesEmpId = salesEmpId;
        this.clientName = clientName;
    }
}
