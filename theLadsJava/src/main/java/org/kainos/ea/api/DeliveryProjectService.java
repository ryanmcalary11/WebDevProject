package org.kainos.ea.api;

import org.kainos.ea.cli.DelivEmpRequest;
import org.kainos.ea.cli.DelivEmployee;
import org.kainos.ea.cli.DeliveryProject;
import org.kainos.ea.client.*;
import org.kainos.ea.core.DelivEmpToProjectValidator;
import org.kainos.ea.db.DeliveryProjectDao;

import java.sql.SQLException;

public class DeliveryProjectService {
    DeliveryProjectDao deliveryProjectDao = new DeliveryProjectDao();

    public void assignDelivEmpToProject(int deliveryProjectId, int projectId) throws FailedToAddDeliveryEmployeeToProject, InvalidDelivEmpException {
        try{
            String validation = DelivEmpToProjectValidator.isDelivEmpToProjectValid(deliveryProjectId, projectId);

            if(validation != null){
                throw new InvalidDelivEmpException(validation);
            }

            int id = deliveryProjectDao.assignDelivEmpToProject(deliveryProjectId, projectId);

            if(id == -1){
                throw new FailedToAddDeliveryEmployeeToProject();
            }

        }
        catch(SQLException e){
            System.err.println(e.getMessage());
            throw new FailedToAddDeliveryEmployeeToProject();
        }
    }

    public void removeDelivEmployeeFromProject(int delivEmpId, int projectId) throws InvalidDelivEmpException, FailedToRemoveDeliveryEmpFromProject {
        try{
            String validation = DelivEmpToProjectValidator.isDelivEmpToProjectValid(delivEmpId, projectId);

            if(validation != null){
                throw new InvalidDelivEmpException(validation);
            }


            DeliveryProjectDao.removeDelivEmployeeFromProject(delivEmpId, projectId);
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
            throw new FailedToRemoveDeliveryEmpFromProject();

        }
    }

}
