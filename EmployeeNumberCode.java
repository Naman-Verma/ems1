/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseConnections;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ask
 */
abstract public class EmployeeNumberCode {
    
    public static final long getEmployeeNumber() {
        ConnectionClass connection = new ConnectionClass();
        ResultSet result;
        PreparedStatement statement;
        
        long numberCode = 1001l;
        
        try{
            connection.connect();
            statement = connection.con.prepareStatement("select count(*) from Employee");
            result = statement.executeQuery();
            
            if(result.next())
                numberCode += result.getLong(1);
            
            result.close();
            
        } catch(SQLException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
        return numberCode;
    }
}