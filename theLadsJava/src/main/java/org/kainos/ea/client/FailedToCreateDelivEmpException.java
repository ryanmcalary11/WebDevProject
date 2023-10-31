package org.kainos.ea.client;

public class FailedToCreateDelivEmpException extends Throwable{
    @Override
    public String getMessage(){
        return "Failed to create delivery employee";
    }
}
