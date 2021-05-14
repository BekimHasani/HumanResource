/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;


import BLL.EmployeeDepartmentHistory;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bekim
 */
public class EmployeeDepHistoryTableModel extends AbstractTableModel {

    String[] cols = {"EmployeeDepHistoryID","Department","Employee","Start Date","End Date"};
    List<EmployeeDepartmentHistory> list ;
    
    public EmployeeDepHistoryTableModel(){
    }
    
    public EmployeeDepHistoryTableModel(List<EmployeeDepartmentHistory>list){
        this.list = list ;
    }
    
    public void addList(List<EmployeeDepartmentHistory> list){
        this.list =list ;
    }
    
    public EmployeeDepartmentHistory getEmployee(int index){
        return list.get(index);
    }
   
    public EmployeeDepartmentHistory getRow(int i){
        return list.get(i);
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
    public Object getValueAt(int rowIndex, int columnIndex) {
        EmployeeDepartmentHistory e = (EmployeeDepartmentHistory)list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return e.getDepartmentHistoriID();
            case 1:
                return e.getDepartment();
            case 2:
                return e.getEmployee();   
            case 3:
                return e.getStartDate();
            case 4:
                return e.getEndDate(); 
            default:
                return null;
        }
    } 
}
