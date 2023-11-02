package org.kainos.ea.client;

public class FailedToAddDeliveryEmployeeToProject extends Exception{
    public String getMessage() {
        return "Failed to add delivery employee to project";
    }
}
