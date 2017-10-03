/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author ask
 */
abstract public class ExceptionThrower {
    
    public static final void nullFields(JTextField... fields) throws NullFieldException{
        for( JTextField yourField : fields) {
            if(yourField.getText().equals(""))
                throw new NullFieldException("null textfield exception");
        }
    }
    
    public static final void letterFound(boolean trueToAllowDecimalPoint,JTextField... fields) throws LetterFoundException
    {
        String regexString;
        if( !trueToAllowDecimalPoint )
                regexString = "[0-9]+";
        else
            regexString = "[0-9]+([\\.]+[0-9]+)*";
        
        for( JTextField yourField : fields ) {
            if( !yourField.getText().matches(regexString) )
                throw new LetterFoundException("letter found Exception");
        }
    }
    
    public static final void nullArea(JTextArea... areas){
        for( JTextArea yourArea : areas) {
            if(yourArea.getText().equals("")) {
                throw new NullFieldException("null textarea found");
            }
        }
    }
    
    public static final void requiredLength(int MAX_LENGTH, JTextField yourField){
        if(yourField.getText().length()!=MAX_LENGTH) {
            throw new RequiredLegthNotFoundException("not requried length");
        }
    }
    
    public static final void ageCheck(JDateChooser dateField,String textFieldName,JFrame frame){
        
        String str = new String(new SimpleDateFormat("yyyy-mm-dd").format(dateField.getDate()));
        Date currentDate = new Date();
        
        Calendar startCalendar = new GregorianCalendar();
        startCalendar.setTime(dateField.getDate());
        
        Calendar currentCalendar = new GregorianCalendar();
        currentCalendar.setTime(currentDate);
        
        int diffYear = currentCalendar.get(Calendar.YEAR)-startCalendar.get(Calendar.YEAR);
        Double presentAgeWithNoOfDays=(diffYear*12+currentCalendar.get(Calendar.MONTH)-startCalendar.get(Calendar.MONTH))/12d;
        
        if(presentAgeWithNoOfDays<20.0){
            throw new TooYoungException("age less than 18");
        }else if(presentAgeWithNoOfDays>50.0){
            throw new TooYoungException("age more than 55");
        }
    }
    
    public static final void invalidDate(JDateChooser... fields) {
        
        for(JDateChooser dates : fields){
            
            if(dates.getDate()==null){
                throw new InvalidDateFoundException("This Employee Already Working in Company");
            }
        //    new String(new SimpleDateFormat("yyyy-mm-dd").format(dates.getDate()));
        }
        
    }
    
    public static final void symbolFound(JTextField... fields){
        
        for( JTextField yourField : fields){
            String regexString = "[a-zA-Z]+([\\.]+[\\s]+[a-zA-Z]+)*+(\\s+[a-zA-Z]+)*";
            if(!yourField.getText().matches(regexString)){
                throw new SymbolFoundException("symbols found exception");
            }
        }
        
    }
    
    
}
