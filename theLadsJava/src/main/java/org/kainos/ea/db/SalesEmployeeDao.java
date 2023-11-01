package org.kainos.ea.db;

import org.kainos.ea.cli.SalesEmployee;
import org.kainos.ea.cli.SalesEmployeeRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class SalesEmployeeDao {
    private DatabaseConnector databaseConnector = new DatabaseConnector();

    public int createSalesEmployee(SalesEmployeeRequest salesEmployee) throws SQLException {
        Connection c = databaseConnector.getConnection();

        String insertStatement = "INSERT INTO SalesEmployee (forename, surname, salary, bankAccNum, nINumber, comRate) VALUES (?,?,?,?,?,?)";

        PreparedStatement s = c.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);

        s.setString(1, salesEmployee.getForename());
        s.setString(2, salesEmployee.getSurname());
        s.setBigDecimal(3, salesEmployee.getSalary());
        s.setString(4, salesEmployee.getBAN());
        s.setString(5, salesEmployee.getNINumber());
        s.setBigDecimal(6, salesEmployee.getComRate());

        s.executeUpdate();

        ResultSet rs = s.getGeneratedKeys();

        if (rs.next()) {
            return rs.getInt(1);
        }
        return -1;
    }

    public SalesEmployee getSalesEmployeeById(int id) throws SQLException {
        Connection connection = databaseConnector.getConnection();
        Statement s = connection.createStatement();

        ResultSet rs = s.executeQuery("SELECT salesEmpID, forename, surname, salary, bankAccNum, nINumber, comRate" +
                " FROM SalesEmployee where salesEmpID = " + id);

        while (rs.next()) {
            return new SalesEmployee(
                    rs.getInt("salesEmpID"),
                    rs.getString("forename"),
                    rs.getString("surname"),
                    rs.getBigDecimal("salary"),
                    rs.getString("bankAccNum"),
                    rs.getString("nINumber"),
                    rs.getBigDecimal("comRate")
            );
        }
        return null;
    }
    public void updateSalesEmployee(int id, SalesEmployeeRequest salesEmployee) throws SQLException {
        Connection connection = databaseConnector.getConnection();

        String updateStatement = "UPDATE SalesEmployee SET forename = ?, surname = ?, salary = ?, bankAccNum = ?, nINumber = ?, comRate = ? WHERE salesEmpID = ?";

        PreparedStatement s = connection.prepareStatement(updateStatement);

        s.setString(1, salesEmployee.getForename());
        s.setString(2, salesEmployee.getSurname());
        s.setBigDecimal(3, salesEmployee.getSalary());
        s.setString(4, salesEmployee.getBAN());
        s.setString(5, salesEmployee.getNINumber());
        s.setBigDecimal(6, salesEmployee.getComRate());
        s.setInt(7, id);

        s.executeUpdate();
    }
    public List<SalesEmployee> getAllSalesEmployees() throws SQLException {
        Connection connection = databaseConnector.getConnection();

        Statement s = connection.createStatement();

        ResultSet rs = s.executeQuery("SELECT salesEmpID, forename, surname, salary, bankAccNum, nINumber, comRate FROM SalesEmployee");

        List<SalesEmployee> salesEmployeeList = new ArrayList<>();

        while (rs.next()) {
            SalesEmployee salesEmployee = new SalesEmployee(
                    rs.getInt("salesEmpID"),
                    rs.getString("forename"),
                    rs.getString("surname"),
                    rs.getBigDecimal("salary"),
                    rs.getString("bankAccNum"),
                    rs.getString("nINumber"),
                    rs.getBigDecimal("comRate")
            );

            salesEmployeeList.add(salesEmployee);
        }
        return salesEmployeeList;
    }

    public void deleteSalesEmployee(int id) throws SQLException
    {
        Connection c = databaseConnector.getConnection();

        String deleteStatement = "DELETE FROM SalesEmployee WHERE salesEmpID = ?";

        PreparedStatement st = c.prepareStatement(deleteStatement);

        st.setInt(1,id);


        st.executeUpdate();
    }
}
