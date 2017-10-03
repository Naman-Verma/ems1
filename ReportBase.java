/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports;

import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ask
 */
abstract public class ReportBase extends JPanel {
    
    public static DefaultTableModel model;
    
    public static void setTable(JFrame frame,int x,int y,int width, int height) {
        
        model = new DefaultTableModel();
        JTable table = new JTable(model);
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(x, y, width, height);
        Container cp = frame.getContentPane();
        cp.add(pane);
        table.setFillsViewportHeight(true);
        
    }
}
