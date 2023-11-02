package org.kainos.ea.client;

public class FailedToGetProjectsException extends Exception{
    public String getMessage() {
        return "Failed to get projects from the database";
    }
}
