/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import BLL.Employee;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author BesaC
 */
public class TrainingsEmployeeTableModel extends AbstractTableModel {
    
    List <Employee> list;
    
    String [] columns = {"Name" , "Last Name" , "EmployeeID", "JobTitle"};
    
    public TrainingsEmployeeTableModel(){
    
    }
    
    public TrainingsEmployeeTableModel(List<Employee> list){
        this.list = list;
    }
    
    public Employee getEmployee(int index){
        return list.get(index);
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
    public String getColumnName(int column){
        return columns[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Employee te = (Employee) list.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return te.getEmployeeName();
            case 1:
                return te.getEmployeeLastName();
            case 2: 
                return te.getEmployeeID();
            case 3:
                return te.getJobTitle();
            default:
                return null;
                      
        }
    }
    
    
}
