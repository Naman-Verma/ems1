package databaseConnections;



import java.sql.DriverManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ask
 */
import java.sql.Connection;
public class ConnectionClass {
    public  Connection con;
    public void connect() {
        try {
            String connectionUrl = "jdbc:sqlserver://localhost:1433; databaseName=EmployeeManagementSystem;integratedSecurity=true;";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);
            System.out.println("Connected");
        } catch(Exception ex) {
            System.out.println("Error in Connection"+ex);
        }
    }
    public void disconnect() {
        try {
            con.close();
            System.out.println("Disconnected");
        } catch(Exception ex) {
            System.out.println("Error while Disconnecting"+ex);
        }
    }
    public static void main(String... args) {
        ConnectionClass cn = new ConnectionClass();
        cn.connect();
        cn.disconnect();
    }
}

