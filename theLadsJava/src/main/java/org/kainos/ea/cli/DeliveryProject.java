package org.kainos.ea.cli;

public class DeliveryProject {

    private int deliveryEmpId;
    private int projectId;
    private boolean activilyWorking;

    public DeliveryProject(int deliveryEmpId, int projectId, boolean activilyWorking) {
        this.deliveryEmpId = deliveryEmpId;
        this.projectId = projectId;
        this.activilyWorking = activilyWorking;
    }

    public int getDeliveryEmpId() {
        return deliveryEmpId;
    }

    public void setDeliveryEmpId(int deliveryEmpId) {
        this.deliveryEmpId = deliveryEmpId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public boolean isActivilyWorking() {
        return activilyWorking;
    }

    public void setActivilyWorking(boolean activilyWorking) {
        this.activilyWorking = activilyWorking;
    }
}
