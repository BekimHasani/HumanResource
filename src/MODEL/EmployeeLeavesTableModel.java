/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import BLL.EmployeeLeaves;
import GUI.Utility;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Armend
 */
public class EmployeeLeavesTableModel extends AbstractTableModel{
    
    private String [] cols = {"ID","Employee" ,"Leave Days","Start Date","End Date","Leave","Status" };
    private List<EmployeeLeaves> list ;
    
    public EmployeeLeavesTableModel(){
        
    }
    
    public EmployeeLeavesTableModel(List<EmployeeLeaves> list){
        this.list = list;
    }
    
    public void add(List<EmployeeLeaves> list){
        this.list = list;
    }
    
    public EmployeeLeaves getEmployeeLeaves(int index){
        return list.get(index);
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }
    
    @Override
    public String getColumnName(int index){
        return cols[index];
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        EmployeeLeaves el = (EmployeeLeaves)list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return el.getEmployeeLeaveID();
            case 1:
                return el.getEmployee();
            case 2:
                return el.getLeaveDays();
            case 3:
                return Utility.format(el.getStartDate());
            case 4:
                return Utility.format(el.getEndDate());
            case 5: 
                return el.getLeave();
            case 6:
                return el.getEmployeeLeavesStatus() ? "Active" : "Unactive";
            default:
                return null;
        }
    }
    
}
