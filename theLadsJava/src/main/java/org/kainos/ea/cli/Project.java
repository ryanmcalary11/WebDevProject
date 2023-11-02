package org.kainos.ea.cli;

public class Project {
    private int projectId;
    private String projectName;
    private float projectValue;
    private int clientId;
    private int techLeadId;
    private boolean isCompleted;

    public Project(int projectId, String projectName, float projectValue, int clientId, int techLeadId, boolean isCompleted) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectValue = projectValue;
        this.clientId = clientId;
        this.techLeadId = techLeadId;
        this.isCompleted = isCompleted;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public float getProjectValue() {
        return projectValue;
    }

    public void setProjectValue(float projectValue) {
        this.projectValue = projectValue;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getTechLeadId() {
        return techLeadId;
    }

    public void setTechLeadId(int techLeadId) {
        this.techLeadId = techLeadId;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
