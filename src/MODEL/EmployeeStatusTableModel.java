/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import BLL.EmployeeStatus;
import BLL.EmployeeStatus;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Armend
 */
public class EmployeeStatusTableModel extends AbstractTableModel {

    private String[] cols = {"employeeStatusID","employeeStatusDescription"};
    List<EmployeeStatus> list;
    
    public EmployeeStatusTableModel(){
        
    }
    
    public EmployeeStatusTableModel(List<EmployeeStatus> list){
        this.list = list;
    }
    
    public EmployeeStatus getEmployeeStatus(int i){
        return list.get(i);
    }
    
    public void add(List<EmployeeStatus> list){
        this.list = list;
    }
    
    public void remove(EmployeeStatus es){
        list.remove(es);
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
    public String getColumnName(int col){
        return cols[col];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        EmployeeStatus es = (EmployeeStatus)list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return es.getEmployeeStatusID();
            case 1:
                return es.getEmployeeStatusDescription();
            case 2:
            default:
                return null;
         }
    }
}
