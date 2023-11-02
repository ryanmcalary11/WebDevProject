package org.kainos.ea.client;

public class FailedToGetClientsException extends Exception{
    public String getMessage() {
        return "Failed to get clients from the database";
    }
}
