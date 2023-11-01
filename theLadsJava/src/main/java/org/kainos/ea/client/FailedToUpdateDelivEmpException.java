package org.kainos.ea.client;

public class FailedToUpdateDelivEmpException extends Throwable {
    @Override
    public String getMessage(){
        return "Failed to update delivery employee";
    }
}
