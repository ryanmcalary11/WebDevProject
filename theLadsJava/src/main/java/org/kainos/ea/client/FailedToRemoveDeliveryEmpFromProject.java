package org.kainos.ea.client;

public class FailedToRemoveDeliveryEmpFromProject extends Exception{
    public String getMessage() {
        return "Failed to remove delivery employee from the project";
    }
}
