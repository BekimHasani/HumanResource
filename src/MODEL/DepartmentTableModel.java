/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import BLL.Department;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bekim
 */
public class DepartmentTableModel extends AbstractTableModel {
    
    private String[] cols = {"DepartmentID","DepartmentName", "Empolyess", "DepartmentStatus"};
    List<Department> list ;

    public DepartmentTableModel() {
    }

    public DepartmentTableModel(List<Department> list) {
        this.list = list;
    }
    
    public void addList(List<Department> list){
        this.list =list ;
    }
    
    public Department getDepartment(int index){
        return list.get(index);
    }
    
    public Department getRow(int i){
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
    public String getColumnName(int col){
        return cols[col];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Department d = (Department)list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return d.getDepartmentID();
            case 1:
                return d.getDepartmentName();
            case 2:
                return d.getEmployees();
            case 3:
                return d.getDepartmentStatus();
            default:
                return null;
        }
    }
    
}