package databaseConnections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ask
 */

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JComboBox;

abstract public class Departments {
    
    public final static void setDepartments(JComboBox deptCombo) {
        ConnectionClass connection = new ConnectionClass();
        ResultSet result;
        PreparedStatement statement;
        
        try {
            connection.connect();
            statement = connection.con.prepareStatement("Select DepartmentName from Departments where Status = 'Yes'");
            result = statement.executeQuery();
            
            while(result.next())
                deptCombo.addItem(result.getString(1).trim());
            
            result.close();
            
        } catch(SQLException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
    }
}
