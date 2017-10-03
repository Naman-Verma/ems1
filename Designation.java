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

abstract public class Designation {

    public final static void setDesignation(JComboBox designationCombo) {
        ConnectionClass cobj = new ConnectionClass();
        ResultSet result;
        PreparedStatement statement;
        
        try {
            cobj.connect();
            statement = cobj.con.prepareStatement("Select * from Designation");
            result = statement.executeQuery();
            
            while(result.next())
                designationCombo.addItem(result.getString(1));
            
            result.close();
            
        } catch(SQLException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            cobj.disconnect();
        }
    }
    
}
