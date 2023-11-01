package org.kainos.ea.client;

public class FailedToCreateSalesEmployeeException extends Exception {
    public String getMessage() {
        return "Failed to create sales employee";
    }
}
