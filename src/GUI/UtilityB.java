/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.toedter.calendar.JDateChooser;
import java.util.Date;

/**
 *
 * @author BesaC
 */
public class UtilityB {
    
    public static boolean isNotNull(Object obj){
        
            return obj != null;
    }
    
    public static boolean isValidDate(JDateChooser startDate, JDateChooser endDate){
        if(startDate != null && endDate != null){
            return true;
        }else {
            return false;
        }
    }
}
