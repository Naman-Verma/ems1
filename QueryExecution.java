/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseConnections;

import com.toedter.calendar.JDateChooser;
import images.YourImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.ParameterMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import static java.sql.Types.BIGINT;
import static java.sql.Types.DATE;
import static java.sql.Types.VARCHAR;
import java.util.Collections;
import java.util.Enumeration;
import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ask
 */
public class QueryExecution {
    
    CallableStatement statement;
    ConnectionClass cobj;
    ResultSet result;
    
    final int MONEY = 3;
    final int INT = 4;
    final int IMAGE = -4;
    
    int returnedValue = -1;
    
    public QueryExecution() {
        cobj = new ConnectionClass();
    }
    
    public void setParameters(String procedureName,Object... parameters) {
        
        //--------------------------------setting query--------------------
        
        String query;
        
        if(parameters == null)
            query = "{?=call " + procedureName + "()}";
        else {
            String questionMarks = String.join("", Collections.nCopies(parameters.length-1, "?,"));
            query = "{?=call " + procedureName + "(" + questionMarks + "?)}";
        }
        
        //---------------------------------Setting parameters to Statement---------------
        
        try {
            cobj.connect();
            statement = cobj.con.prepareCall(query);
            statement.registerOutParameter(1, INT);     //---------registering 1st parameter to be returned value
            ParameterMetaData metaData = statement.getParameterMetaData();  //-------metadata of statement
            int columnCount = metaData.getParameterCount();
            
            for(int pIndex = 0;pIndex < columnCount;pIndex++) {
                int pType = pIndex + 1;
                int sIndex = pIndex + 2;
                
                switch (metaData.getParameterType(pType)) {
                    case VARCHAR:
                        if(parameters[pIndex] instanceof JPasswordField) {
                            statement.setString(sIndex, new String(((JPasswordField)parameters[pIndex]).getPassword()));
                        } else if(parameters[pIndex] instanceof JTextField) {
                            statement.setString(sIndex, ((JTextField)parameters[pIndex]).getText());
                        } else if(parameters[pIndex] instanceof JTextArea) {
                                statement.setString(sIndex, ((JTextArea)parameters[pIndex]).getText());
                        } else if(parameters[pIndex] instanceof JComboBox) {
                            statement.setString(sIndex, ((JComboBox)parameters[pIndex]).getSelectedItem().toString());
                        } else if(parameters[pIndex] instanceof ButtonGroup) {
                            ButtonGroup bg=(ButtonGroup)parameters[pIndex];
                            String selection=bg.getSelection().getActionCommand();
                            statement.setString(sIndex,selection);
                        }
                        break;
                    case BIGINT:
                        statement.setLong(sIndex, Long.parseLong(((JTextField)parameters[pIndex]).getText()));
                        break;
                    case INT:
                        statement.setInt(sIndex, Integer.parseInt(((JTextField)parameters[pIndex]).getText()));
                        break;
                    case DATE:
                        JDateChooser jdc = (JDateChooser)parameters[pIndex];
                        if( jdc.getDate() != null ) {
                            java.sql.Date dateField = new java.sql.Date(jdc.getDate().getTime());
                            statement.setString(sIndex, dateField.toString());
                        } else {
                            statement.setString(sIndex, null);
                        }
                        break;
                    case MONEY:
                        statement.setDouble(sIndex, Double.parseDouble(((JTextField)parameters[pIndex]).getText()));
                        break;
                    case IMAGE:
                        if(parameters[pIndex] != null) {
                            FileInputStream fis = new FileInputStream((File)parameters[pIndex]);
                            int len = (int)((File)parameters[pIndex]).length();
                            statement.setBinaryStream(sIndex, fis,len);
                        } else {
                            statement.setBinaryStream(sIndex, null);
                        }
                        break;
                    default:
                        break;
                }
            }
        } catch(SQLException e) {
            System.out.println("Here1");
        } catch(Exception e) {
            System.out.println("Here 2");
        }
    }
     
    public void getResult(Object... fields) {
        
        int columnCount = -1;
        //---------------------------------------getting result set 
        //--------------------if statement didn't return resultSet then exception will be caught------------------
        
        try{
            result = statement.executeQuery();
            ResultSetMetaData metaData = result.getMetaData();
            columnCount = metaData.getColumnCount();
            
            while(result.next()) {
                for(int fIndex = 0; fIndex < columnCount; fIndex++){    //-----fIndex-->field_Index
                    int rIndex = fIndex + 1;                            //-----rIndex --->resultset_index
                    switch (metaData.getColumnType(rIndex)) {
                        case VARCHAR:
                            if(fields[fIndex] instanceof JTextField) {
                                ((JTextField)fields[fIndex]).setText(result.getString(rIndex));
                            } else if(fields[fIndex] instanceof JTextArea) {
                                ((JTextArea)fields[fIndex]).setText(result.getString(rIndex));
                            } else if(fields[fIndex] instanceof JComboBox) {
                                ((JComboBox)fields[fIndex]).setSelectedItem(result.getString(rIndex).trim());
                            } else if(fields[fIndex] instanceof ButtonGroup) {
                                ButtonGroup genderGroup = (ButtonGroup)fields[fIndex];
                                String gender = result.getString(rIndex).trim();
                                Enumeration<AbstractButton> allRadioButton = genderGroup.getElements();
                                while(allRadioButton.hasMoreElements()) {
                                    JRadioButton temp = (JRadioButton)allRadioButton.nextElement();
                                    if(gender.equals(temp.getText())) {
                                        temp.setSelected(true);
                                        break;
                                    }
                                }
                            }
                            break;
                        case BIGINT:
                            ((JTextField)fields[fIndex]).setText(result.getString(rIndex));  
                            break;
                        case INT:
                            ((JTextField)fields[fIndex]).setText(result.getString(rIndex));
                            break;
                        case DATE:
                            ((JDateChooser)fields[fIndex]).setDate(result.getDate(rIndex));
                            break;
                        case MONEY:
                            ((JTextField)fields[fIndex]).setText(result.getString(rIndex));
                            break;
                        case IMAGE:
                            Blob image = result.getBlob(rIndex);
                            if(image != null) {
                                try {
                                    File tmpFile = new File("tmpImage");
                                    FileOutputStream fos = new FileOutputStream(tmpFile);
                                    fos.write( image.getBytes(1L, (int)image.length()));
                                    fos.close();
                                    ImageIcon icon2 = new ImageIcon(new YourImage().resizeYourImage(ImageIO.read(tmpFile), (JLabel)fields[fIndex]));
                                    ((JLabel)fields[fIndex]).setIcon(icon2);
                                    tmpFile.deleteOnExit();
                                } catch(Exception e)  {  }
                            } else {
                                new YourImage().setImage((JLabel)fields[fIndex], true);
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
            returnedValue = statement.getInt(1);  //geting returned value by procedure
            result.close();
        } catch(Exception e){
            System.out.println("Here");
            e.printStackTrace();
            try {
                returnedValue = statement.getInt(1);  //geting returned value by procedure if exception occurs
            } catch(Exception ex) {
                
            }
        } finally {
            cobj.disconnect();
        }
        
    }
    
    public void getReport(DefaultTableModel model){
        try {
            int columnCount = model.getColumnCount();
            int rowCount = model.getRowCount();
            
            for( int index = rowCount - 1; index >= 0; index-- )
                model.removeRow(index);
            
            result = statement.executeQuery();
            ResultSetMetaData metaData = result.getMetaData();
            
            if(columnCount == 0)
            for(int index = 0;index < metaData.getColumnCount();index++)
                model.addColumn(metaData.getColumnName(index + 1));
            
            
            while(result.next()) {
                Object[] object = getObject(result);
                model.insertRow(model.getRowCount(), object);
            }
            
            returnedValue = statement.getInt(1); //geting returned value by procedure
            result.close();
            
        } catch(Exception e) {
            
            try {
                returnedValue = statement.getInt(1);  //geting returned value by procedure if exception occurs
            } catch(Exception ex) {
                
            }
        } finally {
            cobj.disconnect();
        }
    }
    
    private final Object[] getObject(ResultSet resultSet) {
        Object[] object = null;
        try {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            object = new Object[columnCount];
            
            for(int index = 1; index <= columnCount; index++) {
                object[index - 1] = result.getString(index);
            }
            
        } catch(Exception e) {
            
        }
        return object;
    }
    
    public int getReturnedValue() {
        return returnedValue;
    }
}
