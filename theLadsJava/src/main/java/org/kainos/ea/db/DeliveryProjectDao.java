package org.kainos.ea.db;

import org.kainos.ea.cli.DelivEmpRequest;
import org.kainos.ea.cli.DelivEmployee;
import org.kainos.ea.cli.DeliveryProject;
import org.kainos.ea.cli.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeliveryProjectDao {

    public int assignDelivEmpToProject(int deliveryProjectId, int projectId) throws SQLException {

        Connection c = DatabaseConnector.getConnection();

        String insertStatement = "INSERT INTO Project_DeliveryEmployee(dEmpID, projectID, activilyWorking) VALUES(?, ?, ?)";

        PreparedStatement st = c.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);

        st.setInt(1, deliveryProjectId);
        st.setInt(2, projectId);
        st.setBoolean(3, true);

        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();

        return 1;//problem here as not incrementing field therefore change code in service to not throw error
    }

    public static void removeDelivEmployeeFromProject(int delivEmpId, int projectId) throws SQLException{
        try{
            Connection c = DatabaseConnector.getConnection();

            String updateStringStatement = "UPDATE Project_DeliveryEmployee SET activilyWorking = ? " +
                    "WHERE dEmpID = "+ delivEmpId +" AND projectID = "+ projectId +";";

            PreparedStatement updatePSt = c.prepareStatement(updateStringStatement, Statement.RETURN_GENERATED_KEYS);


            updatePSt.setBoolean(1,false);


            updatePSt.executeUpdate();

        }
        catch(SQLException e){
            e.getMessage();
        }
    }


}
