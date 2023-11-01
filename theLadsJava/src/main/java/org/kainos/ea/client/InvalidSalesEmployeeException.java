package org.kainos.ea.client;

public class InvalidSalesEmployeeException extends Exception{
    public InvalidSalesEmployeeException(String validation) {
        super(validation);
    }
}
