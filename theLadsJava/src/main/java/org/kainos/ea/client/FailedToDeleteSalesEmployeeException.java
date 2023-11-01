package org.kainos.ea.client;

public class FailedToDeleteSalesEmployeeException extends Exception{
    public String getMessage() {
        return "Failed to delete sales employee";
    }
}
