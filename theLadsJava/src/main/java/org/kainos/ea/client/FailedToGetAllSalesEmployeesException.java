package org.kainos.ea.client;

public class FailedToGetAllSalesEmployeesException extends Exception{
    public String getMessage() {
        return "Failed to select all of the sales employees";
    }
}
