/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import BLL.Attendance;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Armend
 */
public class AttendanceTableModel extends AbstractTableModel{

    private String [] colums = {"Employee","AttendanceDate","RequiredHours","AttendedTime","AbbssenceTime","Overtime","AttendanceStatus"};
    private List<Attendance> list = null;
    
    public AttendanceTableModel(){
        
    }
    
    public AttendanceTableModel(List<Attendance> list){
        this.list = list;
    }
    
    public void add(List<Attendance> list){
        this.list = list;
    }
    
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public String getColumnName(int col){
        return colums[col];
    }
    
    @Override
    public int getColumnCount() {
        return colums.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Attendance att = (Attendance) list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return att.getEmployee();
            case 1:
                return att.getAttendanceDate();
            case 2:
                return att.getRequiredHours();
            case 3:
                return att.getAttendedTime();
            case 4:
                return att.getAbssenceTime();
            case 5:
                return att.getOvertimeD();
            default:
                return null;
        }
    }
    
}
