/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ask
 */

public class EmployeeAlreadyExistsException extends RuntimeException {

    public EmployeeAlreadyExistsException(String description,JFrame frame) {
        super("Two Employees with same "+description);
        JOptionPane.showMessageDialog(frame, "Two different employees with same "+description+" cannot exists", "Invalid "+description, JOptionPane.INFORMATION_MESSAGE);
    }
    
}
