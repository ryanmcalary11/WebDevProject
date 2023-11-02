package org.kainos.ea.cli;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
public class ProjectRequest {
    private String projectName;
    private float projectValue;
    private int clientId;
    private int techLeadId;
    private boolean isCompleted;

    public ProjectRequest(String projectName, float projectValue, int clientId, int techLeadId, boolean isCompleted) {
        this.projectName = projectName;
        this.projectValue = projectValue;
        this.clientId = clientId;
        this.techLeadId = techLeadId;
        this.isCompleted = isCompleted;
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
