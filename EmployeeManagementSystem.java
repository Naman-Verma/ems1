/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemanagementsystem;

import com.sun.javafx.webkit.Accessor;
import javax.swing.UIManager;

/**
 *
 * @author ask
 */
public class EmployeeManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }catch(Exception e){
            System.out.println("Here");
            e.printStackTrace();
        }
        new LoginPage().setVisible(true);
        
    }
    
}
