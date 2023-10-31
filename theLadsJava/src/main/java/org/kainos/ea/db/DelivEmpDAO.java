package org.kainos.ea.db;

import org.kainos.ea.cli.DelivEmpRequest;
import org.kainos.ea.cli.DelivEmployee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DelivEmpDAO {
    DatabaseConnector dbConnector = new DatabaseConnector();

    public int createDelivEmp(DelivEmpRequest dEmp) throws SQLException {

        Connection c = DatabaseConnector.getConnection();

        String insertStatement = "INSERT INTO DelivEmployee(fName, lName, niNum, salary, bankAccountNo) VALUES(?, ?, ?, ?, ?)";

        PreparedStatement st = c.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);

        st.setString(1, dEmp.getfName());
        st.setString(2, dEmp.getlName());
        st.setString(3, dEmp.getNiNum());
        st.setDouble(4, dEmp.getSalary());
        st.setString(4, dEmp.getBankAccountNo());

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

            String updateStringStatement = "UPDATE DelivEmployee SET fName = ?, lName = ?, " +
                    "salary = ?, niNum = ?, bankAccountNo = ? ";

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

        ResultSet rs = st.executeQuery("SELECT delivEmpId, fName, lName, salary, niNum, bankAccountNo FROM `DelivEmployee` " +
                "WHERE productId="+id);

        while (rs.next()) {
            return new DelivEmployee(
                    rs.getInt("delivEmpId"),
                    rs.getString("fName"),
                    rs.getString("lName"),
                    rs.getFloat("salary"),
                    rs.getString("niNum"),
                    rs.getString("bankAccountNo")
            );
        }
        return null;
    }

    public List<DelivEmployee> getAllDelivEmployees() throws SQLException {
        Connection c = dbConnector.getConnection();
        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT fName, lName, salary, niNum, bankAccountNo FROM `DelivEmployee`;");
        List<DelivEmployee> delivEmpList = new ArrayList<>();
        while (rs.next()) {
            DelivEmployee delivEmp = new DelivEmployee(
                    rs.getString("fName"),
                    rs.getString("lName"),
                    rs.getFloat("salary"),
                    rs.getString("niNum"),
                    rs.getString("bankAccountNo")
            );
            delivEmpList.add(delivEmp);
        }
        return delivEmpList;

//           catch (SQLException e) {
//            e.getMessage();
//            throw new RuntimeException(e);
    }


    public void deleteDelivEmp(int id) throws SQLException{
        Connection c = DatabaseConnector.getConnection();

        String deleteStatement = "DELETE FROM `DelivEmployee` WHERE delivEmpId = ?";

        PreparedStatement st = c.prepareStatement(deleteStatement);

        st.setInt(1, id);

        st.executeUpdate();
    }
}
