package Employee;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ask
 */
import images.YourImage;
import databaseConnections.Designation;
import databaseConnections.Departments;
import java.io.File;
import java.util.Calendar;
import javax.swing.JOptionPane;
import exceptions.EmployeeAlreadyExistsException;
import static databaseConnections.EmployeeNumberCode.getEmployeeNumber;
import databaseConnections.QueryExecution;
import exceptions.InvalidDateFoundException;
import exceptions.LetterFoundException;
import exceptions.ExceptionThrower;
import exceptions.NullFieldException;
import exceptions.RequiredLegthNotFoundException;
import exceptions.SymbolFoundException;
import exceptions.TooOldException;
import exceptions.TooYoungException;
import static utilities.Utilities.resetFields;

public class NewEmployee extends javax.swing.JFrame {

    /**
     * Creates new form NewEmployee
     */
    
    private String deptCode, desigCode, numberCode, yourID;
    private final QueryExecution empQuery;
    private File selectedFilePath;
    private final int MAX_LENGTH_CONTACT = 10;
    private final int MAX_LENGTH_AADHAAR = 12;
    
    public NewEmployee() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        
        empQuery = new QueryExecution();
        
        Departments.setDepartments(deptCombo);
        Designation.setDesignation(designationCombo);
        
        String fullDName = deptCombo.getSelectedItem().toString();
        deptCode = fullDName.substring(0, 3);
        
        fullDName = designationCombo.getSelectedItem().toString();
        desigCode = fullDName.substring(0, 3);
        
        numberCode = getEmployeeNumber()+"";
        
        yourID = deptCode + "-" + desigCode + "-" + numberCode;
        
        employeeIDField.setText(yourID);
        
        Calendar today = Calendar.getInstance();
        dojField.setDate(today.getTime());
        
        dojField.setEnabled(false);
        employeeIDField.setEnabled(false);
        
        male.setActionCommand("Male");
        female.setActionCommand("Female");
        others.setActionCommand("Others");
        
        new YourImage().setImage(passportSizePhoto, true);
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genderGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        employeeIDField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        fatherField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        motherField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        female = new javax.swing.JRadioButton();
        male = new javax.swing.JRadioButton();
        others = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        contactField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        marriedField = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        addressArea = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        cityCombo = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        stateCombo = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        aadhaarField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        designationCombo = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        deptCombo = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        qualificationArea = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        submit = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        noteLabel = new javax.swing.JLabel();
        errorLabel = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        nationalityField = new javax.swing.JTextField();
        dobField = new com.toedter.calendar.JDateChooser();
        dojField = new com.toedter.calendar.JDateChooser();
        passportSizePhoto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("New Employee Joining");

        jLabel1.setText("EmployeeID");

        jLabel2.setText("Name*");

        jLabel3.setText("Father Name*");

        jLabel4.setText("Mother Name*");

        jLabel5.setText("Gender*");

        genderGroup.add(female);
        female.setSelected(true);
        female.setText("Female");

        genderGroup.add(male);
        male.setText("Male");

        genderGroup.add(others);
        others.setText("Others");

        jLabel6.setText("Date of Birth*");

        jLabel7.setText("Contact No.*");

        jLabel8.setText("Marital Status*");

        jLabel9.setText("Address*");

        marriedField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single", "Married", "Divorced", "Widow" }));

        addressArea.setColumns(20);
        addressArea.setRows(5);
        jScrollPane1.setViewportView(addressArea);

        jLabel10.setText("City*");

        cityCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Karnal", "Hisar", "Gurgaon", "Rohtak", "Ambala", "Sirsa", "Panipat", "Yamuna Nagar", "Kaithal", "Chandigarh", "Kurukshetra", "Bhiwani", "Faridabad", "Jhajjar", "Bahadurgarh", "Jind", "Rewari", "Sonipat", "Fatehbad", "Nilokheri", "Panchkula" }));

        jLabel11.setText("State*");

        stateCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Haryana" }));

        jLabel12.setText("Aadhaar Card No.*");

        jLabel13.setText("EmailID");

        jLabel14.setText("Designation*");

        designationCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                designationComboItemStateChanged(evt);
            }
        });

        jLabel15.setText("Department*");

        deptCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                deptComboItemStateChanged(evt);
            }
        });

        jLabel16.setText("Qualifications");

        qualificationArea.setColumns(20);
        qualificationArea.setRows(5);
        jScrollPane2.setViewportView(qualificationArea);

        jLabel17.setText("Date of Joining*");

        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        noteLabel.setText("Note : * fieldds are Mandatory");

        jLabel20.setText("Nationality*");

        passportSizePhoto.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        passportSizePhoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passportSizePhotoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel20)
                    .addComponent(jLabel2))
                .addGap(131, 131, 131)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(female)
                            .addGap(18, 18, 18)
                            .addComponent(male)
                            .addGap(18, 18, 18)
                            .addComponent(others))
                        .addComponent(contactField)
                        .addComponent(marriedField, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                        .addComponent(cityCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(stateCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(aadhaarField)
                        .addComponent(nationalityField))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(employeeIDField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                        .addComponent(nameField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                        .addComponent(fatherField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                        .addComponent(motherField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                        .addComponent(dobField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(noteLabel))
                            .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel16)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel15)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel14))))
                                .addGap(104, 104, 104)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(submit)
                                        .addGap(56, 56, 56)
                                        .addComponent(reset))
                                    .addComponent(designationCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(deptCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2)
                                    .addComponent(emailField)
                                    .addComponent(dojField, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(158, 158, 158))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(passportSizePhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(250, 250, 250))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(employeeIDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(fatherField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(motherField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(female)
                        .addComponent(male)
                        .addComponent(others))
                    .addComponent(passportSizePhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(nationalityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(dobField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(contactField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(marriedField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cityCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(stateCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(aadhaarField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(designationCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(deptCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(dojField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(submit)
                                    .addComponent(reset)))
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addComponent(noteLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        
        try{
            ExceptionThrower.nullFields(nameField,fatherField,motherField,nationalityField,contactField, aadhaarField);
            ExceptionThrower.nullArea(addressArea, qualificationArea);
            ExceptionThrower.letterFound(false, contactField, aadhaarField);
            ExceptionThrower.requiredLength(MAX_LENGTH_CONTACT, contactField);
            ExceptionThrower.invalidDate(dobField);
            ExceptionThrower.ageCheck(dobField, "Date Of Birth", this);
            ExceptionThrower.requiredLength(MAX_LENGTH_AADHAAR, aadhaarField);
            ExceptionThrower.symbolFound(nameField,fatherField,motherField,nationalityField);
            
            int yourOption = JOptionPane.showConfirmDialog(this, "Are you Sure ?");
            if( yourOption == JOptionPane.YES_OPTION ) {
                
                empQuery.setParameters( "AddEmployee", employeeIDField, nameField,
                        fatherField, motherField, genderGroup,
                        nationalityField, dobField, contactField,
                        marriedField, addressArea, cityCombo,
                        stateCombo, aadhaarField, emailField,
                        designationCombo, deptCombo, qualificationArea,
                        selectedFilePath );
                
                empQuery.getResult();
                
                int returnedValue = empQuery.getReturnedValue();
                if( returnedValue == 1 ) {
                    JOptionPane.showMessageDialog(this, "Saved Successfully!", "Done.", JOptionPane.NO_OPTION);
                    numberCode = Long.parseLong(numberCode)+1+"";
                    
                    //Reset Fields
                    yourID = deptCode + "-" + desigCode + "-" + numberCode;
                    employeeIDField.setText(yourID);
                    resetFields( nameField, fatherField, motherField, dobField, nationalityField,
                                contactField, marriedField, addressArea, cityCombo, 
                                stateCombo, aadhaarField, emailField, designationCombo,
                                deptCombo, marriedField, qualificationArea,
                                female, passportSizePhoto );

                } else {
                    throw new EmployeeAlreadyExistsException("Aadhaar Card No", this);
                }
            }
            
        }catch(NullFieldException e){
            JOptionPane.showMessageDialog(this, "* fields must not be empty", "Empty * field", JOptionPane.INFORMATION_MESSAGE);
        }catch(LetterFoundException e){
            JOptionPane.showMessageDialog(this, "** must contain only numbers", "Invalid ** fields", JOptionPane.INFORMATION_MESSAGE);
        }catch(RequiredLegthNotFoundException e){
            JOptionPane.showMessageDialog(this, "Contact No must be "+MAX_LENGTH_CONTACT+" characters long\nAadhaar Card No must be "+MAX_LENGTH_AADHAAR+" characters long", "Required Length Not Found", JOptionPane.INFORMATION_MESSAGE);
        }catch(TooYoungException e){
            JOptionPane.showMessageDialog(this, "Too young to work", "Age Restrictions", JOptionPane.INFORMATION_MESSAGE);
        }catch(TooOldException e){
            JOptionPane.showMessageDialog(this, "Too old to work", "Age Restrictions", JOptionPane.INFORMATION_MESSAGE);
        }catch(InvalidDateFoundException e){
            JOptionPane.showMessageDialog(this, "Select a Valid Date", "Invalid date ", JOptionPane.INFORMATION_MESSAGE);
        }catch(EmployeeAlreadyExistsException e){
            e.printStackTrace();
        }catch(SymbolFoundException e){
            JOptionPane.showMessageDialog(this, "Fields Like Name should be filled alphabets only", "SymbolFoundException", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_submitActionPerformed
    
    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        
        yourID = deptCode + "-" + desigCode + "-" + numberCode;
        employeeIDField.setText(yourID);
        resetFields( nameField, fatherField, motherField, dobField, nationalityField,
                    contactField, marriedField, addressArea, cityCombo, 
                    stateCombo, aadhaarField, emailField, designationCombo,
                    deptCombo, marriedField, qualificationArea,
                    female, passportSizePhoto );
        
    }//GEN-LAST:event_resetActionPerformed

    private void passportSizePhotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passportSizePhotoMouseClicked
        selectedFilePath = new YourImage().setImage(passportSizePhoto, false);
    }//GEN-LAST:event_passportSizePhotoMouseClicked

    private void designationComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_designationComboItemStateChanged
        desigCode = designationCombo.getSelectedItem().toString().substring(0, 3);
        yourID = deptCode + "-" + desigCode + "-" + numberCode;
        employeeIDField.setText(yourID);
    }//GEN-LAST:event_designationComboItemStateChanged

    private void deptComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_deptComboItemStateChanged
        deptCode = deptCombo.getSelectedItem().toString().substring(0, 3);
        yourID = deptCode + "-" + desigCode + "-" + numberCode;
        employeeIDField.setText(yourID);
    }//GEN-LAST:event_deptComboItemStateChanged
    
    
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
            java.util.logging.Logger.getLogger(NewEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewEmployee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aadhaarField;
    private javax.swing.JTextArea addressArea;
    private javax.swing.JComboBox<String> cityCombo;
    private javax.swing.JTextField contactField;
    private javax.swing.JComboBox<String> deptCombo;
    private javax.swing.JComboBox<String> designationCombo;
    private com.toedter.calendar.JDateChooser dobField;
    private com.toedter.calendar.JDateChooser dojField;
    private javax.swing.JTextField emailField;
    private javax.swing.JTextField employeeIDField;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JTextField fatherField;
    private javax.swing.JRadioButton female;
    private javax.swing.ButtonGroup genderGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton male;
    private javax.swing.JComboBox<String> marriedField;
    private javax.swing.JTextField motherField;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField nationalityField;
    private javax.swing.JLabel noteLabel;
    private javax.swing.JRadioButton others;
    private javax.swing.JLabel passportSizePhoto;
    private javax.swing.JTextArea qualificationArea;
    private javax.swing.JButton reset;
    private javax.swing.JComboBox<String> stateCombo;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}
