package org.kainos.ea.client;

public class FailedToUpdateSalesEmployeeException extends Exception{
    public String getMessage() {
        return "Failed to update sales employee";
    }
}
