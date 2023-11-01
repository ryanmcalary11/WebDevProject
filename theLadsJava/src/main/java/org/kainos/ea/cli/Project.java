package org.kainos.ea.cli;

public class Project {
    private int projectId;
    private int clientId;
    private String projectName;
    private double projectValue;
    private int techLead;
    private boolean isComplete;

    public Project(int projectId, int clientId, String projectName, double projectValue, int techLead, boolean isComplete) {
        this.projectId = projectId;
        this.clientId = clientId;
        this.projectName = projectName;
        this.projectValue = projectValue;
        this.techLead = techLead;
        this.isComplete = isComplete;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public double getProjectValue() {
        return projectValue;
    }

    public void setProjectValue(double projectValue) {
        this.projectValue = projectValue;
    }

    public int getTechLead() {
        return techLead;
    }

    public void setTechLead(int techLead) {
        this.techLead = techLead;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }
}

