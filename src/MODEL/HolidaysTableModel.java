/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import BLL.Holidays;
import BLL.Holidays;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author BesaC
 */
public class HolidaysTableModel extends AbstractTableModel{
    
    List<Holidays> list;
    private String [] columns = {"HolidayID", "StartDate", "EndDate", "HolidayDescription"};

    public HolidaysTableModel(){
    
    }
    
    public HolidaysTableModel(List<Holidays> list) {
        this.list = list;
    }
    
    public Holidays getHolidays(int index){
        return list.get(index);
    }
    
    @Override
    public String getColumnName(int col){
        return columns [col];
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Holidays h = getHolidays(rowIndex);
        
        switch(columnIndex){
            
            case 0:
                return h.getHolidayID();
            case 1:
                return h.getStartDate();
            case 2:
                return h.getEndDate();
            case 3:
                return h.getHolidayDescription();
            default:
                return null;
        }
    }
    
    
}
