package org.kainos.ea.client;

public class DeliveryEmployeeDoesNotExistException extends Throwable{
    @Override
    public String getMessage() {
        return "The delivery employee does not exist";
    }
}
