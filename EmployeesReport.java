/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports;

import databaseConnections.Departments;
import databaseConnections.QueryExecution;

/**
 *
 * @author ask
 */
public class EmployeesReport extends javax.swing.JFrame {

    /**
     * Creates new form EmployeesReport
     */
    QueryExecution empQuery;
    
    public EmployeesReport() {
        initComponents();
        
        empQuery = new QueryExecution();
        ReportBase.setTable(this, 30, 90, 1300, 570);
        
        setExtendedState(MAXIMIZED_BOTH);
        Departments.setDepartments(deptCombo);
        deptCombo.setEnabled(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchNav = new javax.swing.ButtonGroup();
        allEmployees = new javax.swing.JRadioButton();
        show = new javax.swing.JButton();
        inService = new javax.swing.JRadioButton();
        preEmployee = new javax.swing.JRadioButton();
        departmentWise = new javax.swing.JRadioButton();
        deptCombo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Employee Report");

        searchNav.add(allEmployees);
        allEmployees.setSelected(true);
        allEmployees.setText("All");

        show.setText("Show");
        show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showActionPerformed(evt);
            }
        });

        searchNav.add(inService);
        inService.setText("In Service");

        searchNav.add(preEmployee);
        preEmployee.setText("Previous Employees");

        departmentWise.setText("Department Wise");
        departmentWise.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                departmentWiseItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(allEmployees)
                .addGap(18, 18, 18)
                .addComponent(inService)
                .addGap(18, 18, 18)
                .addComponent(preEmployee)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(deptCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(departmentWise, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(61, 61, 61)
                .addComponent(show)
                .addGap(143, 143, 143))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(allEmployees)
                    .addComponent(show)
                    .addComponent(inService)
                    .addComponent(preEmployee)
                    .addComponent(departmentWise))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deptCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(303, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showActionPerformed
        
        if(allEmployees.isSelected() && !departmentWise.isSelected()) {
            empQuery.setParameters("ReportForAllEmployees", null);
            empQuery.getReport(ReportBase.model);
        } else if(inService.isSelected() && !departmentWise.isSelected()) {
            empQuery.setParameters("ReportInServiceEmployees", null);
            empQuery.getReport(ReportBase.model);
        } else if(preEmployee.isSelected() && !departmentWise.isSelected()) {
            empQuery.setParameters("ReportOutOfServiceEmployees", null);
            empQuery.getReport(ReportBase.model);
        } else if(departmentWise.isSelected() && allEmployees.isSelected()) {
            empQuery.setParameters("ReportDepartmentWiseAll", deptCombo);
            empQuery.getReport(ReportBase.model);
        } else if(departmentWise.isSelected() && inService.isSelected()) {
            empQuery.setParameters("ReportDepartmentWiseInService", deptCombo);
            empQuery.getReport(ReportBase.model);
        } else if(departmentWise.isSelected() && preEmployee.isSelected()) {
            empQuery.setParameters("ReportDepartmentWiseOutOfService", deptCombo);
            empQuery.getReport(ReportBase.model);
        }
    }//GEN-LAST:event_showActionPerformed

    private void departmentWiseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_departmentWiseItemStateChanged
        
        if(departmentWise.isSelected()){
            deptCombo.setEnabled(true);
        }else{
            deptCombo.setEnabled(false);
        }
    }//GEN-LAST:event_departmentWiseItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmployeesReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeesReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeesReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeesReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeesReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton allEmployees;
    private javax.swing.JRadioButton departmentWise;
    private javax.swing.JComboBox<String> deptCombo;
    private javax.swing.JRadioButton inService;
    private javax.swing.JRadioButton preEmployee;
    private javax.swing.ButtonGroup searchNav;
    private javax.swing.JButton show;
    // End of variables declaration//GEN-END:variables
}