package org.kainos.ea.client;

public class ProjectDoesNotExistException extends Exception{
    @Override
    public String getMessage(){
        return "Project does not exist";
    }
}
