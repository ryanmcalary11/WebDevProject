package org.kainos.ea.client;

public class FailedToGetDelivEmpException extends Throwable {
    @Override
    public String getMessage(){
        return "Failed to get delivery employee";
    }
}
