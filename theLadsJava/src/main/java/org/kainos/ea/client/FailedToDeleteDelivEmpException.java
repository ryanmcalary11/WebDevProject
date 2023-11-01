package org.kainos.ea.client;

public class FailedToDeleteDelivEmpException extends Throwable{
    @Override
    public String getMessage(){
        return "Failed to delete delivery employee.";
    }
}
