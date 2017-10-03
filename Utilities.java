package utilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.toedter.calendar.JDateChooser;
import images.YourImage;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;

/**
 * This is an abstract class.
 * This class is just for reseting the Components i.e enabling or disabling, making visible or invisible,
 * emptying fields and setting opaque to false
 * All methods of this class uses var-args method and all are static and final methods 
 * @author ask
 */
abstract public class Utilities {
    
    /**
     * Enable or disable the Components according to the Boolean value provided
     * @param b if true enable the components else disable
     * @param x array of object i.e components 
     * before calling setEnabled first we have to cast the object to that particular type
     * after checking its type by instanceof keyword
     */
    public final static void resetEnabled(boolean b,Object... x){
        for (Object x1 : x) {
            if (x1 instanceof JTextField) {
                ((JTextField) x1).setEnabled(b);
            } else if (x1 instanceof JComboBox) {
                ((JComboBox) x1).setEnabled(b);
            } else if (x1 instanceof JButton) {
                ((JButton) x1).setEnabled(b);
            } else if (x1 instanceof JRadioButton) {
                ((JRadioButton) x1).setEnabled(b);
            } else if (x1 instanceof JDateChooser) {
                ((JDateChooser) x1).setEnabled(b);
            } else if (x1 instanceof JTextArea) {
                ((JTextArea) x1).setEnabled(b);
            }
        }
    }
    
    /**
     * make Components visible or invisible according to boolean b
     * @param b if true make visible else invisible
     * @param x array of object i.e components 
     * before calling setVisible first we have to cast the object to that particular type
     * after checking its type by instanceof keyword
     */
    public final static void turnVisible(boolean b,Object... x){
        for (Object x1 : x) {
            if (x1 instanceof JTextField) {
                ((JTextField) x1).setVisible(b);
            } else if (x1 instanceof JComboBox) {
                ((JComboBox) x1).setVisible(b);
            } else if (x1 instanceof JButton) {
                ((JButton) x1).setVisible(b);
            } else if (x1 instanceof JRadioButton) {
                ((JRadioButton) x1).setVisible(b);
            } else if (x1 instanceof JPanel) {
                ((JPanel) x1).setVisible(b);
            }
        }
    }
    
    /**
     * This method will empty the textfields, set the top item in jcombobox, empty the jtextareas, 
     * set null date and set unknown image of labels
     * @param x array of object i.e components 
     * before calling suitable methods first we have to cast the object to that particular type
     * after checking its type by instanceof keyword
     */
    public final static void resetFields(Object... x){
        for (Object x1 : x) {
            if (x1 instanceof JTextField) {
                ((JTextField) x1).setText("");
            } else if (x1 instanceof JComboBox) {
                ((JComboBox) x1).setSelectedIndex(0);
            } else if (x1 instanceof JRadioButton) {
                ((JRadioButton) x1).setSelected(true);
            } else if (x1 instanceof JTextArea) {
                ((JTextArea) x1).setText("");
            } else if (x1 instanceof JDateChooser) {
                ((JDateChooser) x1).setDate(null);
            } else if (x1 instanceof JLabel) {
                new YourImage().setImage((JLabel) x1, true);
            }
        }
    }
    
    /**
     * This method will set the Opaque to false of the components.
     * @param x array of object i.e components 
     * before calling setOpaque first we have to cast the object to that particular type
     * after checking its type by instanceof keyword
     */
    public final static void resetOpaque(Object... x){
        for (Object x1 : x) {
            if (x1 instanceof JTextField) {
                ((JTextField) x1).setOpaque(false);
            } else if (x1 instanceof JComboBox) {
                ((JComboBox) x1).setOpaque(false);
            } else if (x1 instanceof JRadioButton) {
                ((JRadioButton) x1).setOpaque(false);
            } else if (x1 instanceof JTextArea) {
                ((JTextArea) x1).setOpaque(false);
            } else if (x1 instanceof JPanel) {
                ((JPanel) x1).setOpaque(false);
            } else if(x1 instanceof JDateChooser) {
                ((JDateChooser)x1).setOpaque(false);
            }
        }
    }
}
