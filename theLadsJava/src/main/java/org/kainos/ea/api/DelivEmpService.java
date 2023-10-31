package org.kainos.ea.api;

import org.kainos.ea.cli.DelivEmpRequest;
import org.kainos.ea.cli.DelivEmployee;
import org.kainos.ea.client.*;
import org.kainos.ea.core.DelivEmployeeValidator;
import org.kainos.ea.db.DelivEmpDAO;

import java.sql.SQLException;
import java.util.List;


public class DelivEmpService {

    private DelivEmpDAO delivEmpDAO = new DelivEmpDAO();
    private DelivEmployeeValidator delivEmployeeValidator = new DelivEmployeeValidator();
  
    public int createDelivEmployee(DelivEmpRequest dEmp) throws FailedToCreateDelivEmpException, InvalidDelivEmpException {
        try{
            String validation = delivEmployeeValidator.isDelivEmployeeValid(dEmp);

            if(validation != null){
                throw new InvalidDelivEmpException(validation);
            }

            int id = delivEmpDAO.createDelivEmp(dEmp);

            if(id == -1){
                throw new FailedToCreateDelivEmpException();
            }

            return id;
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
            throw new FailedToCreateDelivEmpException();
        }
    }

    public void updateDelivEmployee(int id, DelivEmpRequest delivEmp) throws InvalidDelivEmpException, DeliveryEmployeeDoesNotExistException, FailedToUpdateDelivEmpException {
        try{
            String validation = delivEmployeeValidator.isDelivEmployeeValid(delivEmp);

            if(validation != null){
                throw new InvalidDelivEmpException(validation);
            }

            DelivEmployee delivEmpToUpdate = delivEmpDAO.getDelivEmployeeById(id);

            if(delivEmpToUpdate == null){
                throw new DeliveryEmployeeDoesNotExistException();
            }

            delivEmpDAO.updateDelivEmployee(id, delivEmp);
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
            throw new FailedToUpdateDelivEmpException();

        }
    }

    public List<DelivEmployee> getAllDelivEmployees() throws SQLException, FailedToGetDelivEmpException {
        List<DelivEmployee> productList = delivEmpDAO.getAllDelivEmployees();
        try {
            return productList;
        } catch (IndexOutOfBoundsException IOBE) {
            IOBE.getMessage();
        } catch (Throwable T) {
            T.getMessage();
        }

        throw new FailedToGetDelivEmpException();
    }

    public DelivEmployee getDelivEmpById(int id) throws FailedToGetDelivEmpException, DeliveryEmployeeDoesNotExistException {
        try {
            DelivEmployee delivEmployee = delivEmpDAO.getDelivEmployeeById(id);

            if (delivEmployee == null) {
                throw new DeliveryEmployeeDoesNotExistException();
            }

            return delivEmployee;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetDelivEmpException();
        }
    }

    public void deleteDelivEmployee(int id) throws FailedToDeleteDelivEmpException, DeliveryEmployeeDoesNotExistException {
        try{
            DelivEmployee delivEmpToDelete = delivEmpDAO.getDelivEmployeeById(id);

            if(delivEmpToDelete == null){
                throw new DeliveryEmployeeDoesNotExistException();
            }

            delivEmpDAO.deleteDelivEmp(id);
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }
}

