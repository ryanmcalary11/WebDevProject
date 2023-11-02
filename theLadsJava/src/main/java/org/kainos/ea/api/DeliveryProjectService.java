package org.kainos.ea.api;

import org.kainos.ea.cli.DelivEmpRequest;
import org.kainos.ea.cli.DelivEmployee;
import org.kainos.ea.cli.DeliveryProject;
import org.kainos.ea.client.DeliveryEmployeeDoesNotExistException;
import org.kainos.ea.client.FailedToCreateDelivEmpException;
import org.kainos.ea.client.FailedToUpdateDelivEmpException;
import org.kainos.ea.client.InvalidDelivEmpException;
import org.kainos.ea.core.DelivEmpToProjectValidator;
import org.kainos.ea.db.DeliveryProjectDao;

import java.sql.SQLException;

public class DeliveryProjectService {
    DeliveryProjectDao deliveryProjectDao = new DeliveryProjectDao();

    public void assignDelivEmpToProject(int deliveryProjectId, int projectId) throws FailedToCreateDelivEmpException, InvalidDelivEmpException {
        try{
            String validation = DelivEmpToProjectValidator.isDelivEmpToProjectValid(deliveryProjectId, projectId);

            if(validation != null){
                throw new InvalidDelivEmpException(validation);
            }

            int id = deliveryProjectDao.assignDelivEmpToProject(deliveryProjectId, projectId);

            if(id == -1){
                throw new FailedToCreateDelivEmpException();
            }

        }
        catch(SQLException e){
            System.err.println(e.getMessage());
            throw new FailedToCreateDelivEmpException();
        }
    }

    public void removeDelivEmployeeFromProject(int delivEmpId, int projectId) throws InvalidDelivEmpException, DeliveryEmployeeDoesNotExistException, FailedToUpdateDelivEmpException {
        try{
            String validation = DelivEmpToProjectValidator.isDelivEmpToProjectValid(delivEmpId, projectId);

            if(validation != null){
                throw new InvalidDelivEmpException(validation);
            }


            DeliveryProjectDao.removeDelivEmployeeFromProject(delivEmpId, projectId);
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
            throw new FailedToUpdateDelivEmpException();

        }
    }

}
