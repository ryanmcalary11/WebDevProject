package org.kainos.ea.client;

public class SalesEmployeeDoesNotExistException extends Exception{
    public String getMessage() {
        return "Sales employee does not exist in the database";
    }
}
