package org.kainos.ea.db;

import org.kainos.ea.cli.DelivEmpRequest;
import org.kainos.ea.cli.DelivEmployee;
import org.kainos.ea.cli.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DelivEmpDAO {
    DatabaseConnector dbConnector = new DatabaseConnector();

    public int createDelivEmp(DelivEmpRequest dEmp) throws SQLException {

        Connection c = DatabaseConnector.getConnection();

        String insertStatement = "INSERT INTO DeliveryEmployee(dEmpForename, dEmpSurname, dEMPBankNum, nationalInsuranceNum, salary) VALUES(?, ?, ?, ?, ?)";

        PreparedStatement st = c.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);

        st.setString(1, dEmp.getfName());
        st.setString(2, dEmp.getlName());
        st.setString(3, dEmp.getBankAccountNo());
        st.setString(4, dEmp.getNiNum());
        st.setDouble(5, dEmp.getSalary());

        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();

        if(rs.next()){
            return rs.getInt(1);
        }

        return -1;
    }
  
    public void updateDelivEmployee(int id, DelivEmpRequest delivEmp) throws SQLException{
        try{
            Connection c = dbConnector.getConnection();

            String updateStringStatement = "UPDATE DeliveryEmployee SET dEmpForename = ?, dEmpSurname = ?, " +
                    "salary = ?, nationalInsuranceNum = ?, dEMPBankNum = ? ";

            PreparedStatement updatePSt = c.prepareStatement(updateStringStatement, Statement.RETURN_GENERATED_KEYS);


            updatePSt.setString(1,delivEmp.getfName());
            updatePSt.setString(2, delivEmp.getlName());
            updatePSt.setDouble(3,delivEmp.getSalary());
            updatePSt.setString(4, delivEmp.getNiNum());
            updatePSt.setString(5, delivEmp.getBankAccountNo());
            updatePSt.setInt(6, id);

            updatePSt.executeUpdate();

        }
        catch(SQLException e){
            e.getMessage();
        }
    }

    public DelivEmployee getDelivEmployeeById(int id) throws SQLException{
        Connection c = dbConnector.getConnection();

        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT dEmpForename, dEmpSurname, dEMPBankNum, nationalInsuranceNum, salary FROM `DeliveryEmployee` " +
                "WHERE dEmpID="+id);

        while (rs.next()) {
            return new DelivEmployee(
                    rs.getString("dEmpForename"),
                    rs.getString("dEmpSurname"),
                    rs.getDouble("salary"),
                    rs.getString("nationalInsuranceNum"),
                    rs.getString("dEMPBankNum")
            );
        }
        return null;
    }

    public List<DelivEmployee> getAllDelivEmployees() throws SQLException {
        Connection c = dbConnector.getConnection();
        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT dEmpID, dEmpForename, dEmpSurname, dEMPBankNum, nationalInsuranceNum, salary FROM `DeliveryEmployee`;");
        List<DelivEmployee> delivEmpList = new ArrayList<>();
        while (rs.next()) {
            DelivEmployee delivEmp = new DelivEmployee(
                    rs.getInt("dEmpID"),
                    rs.getString("dEmpForename"),
                    rs.getString("dEmpSurname"),
                    rs.getDouble("salary"),
                    rs.getString("nationalInsuranceNum"),
                    rs.getString("dEMPBankNum")
            );
            delivEmpList.add(delivEmp);
        }
        return delivEmpList;

    }


    public void deleteDelivEmp(int id) throws SQLException{
        Connection c = DatabaseConnector.getConnection();

        String deleteStatement = "DELETE FROM `DeliveryEmployee` WHERE dEmpId = ?";

        PreparedStatement st = c.prepareStatement(deleteStatement);

        st.setInt(1, id);

        st.executeUpdate();
    }
}
