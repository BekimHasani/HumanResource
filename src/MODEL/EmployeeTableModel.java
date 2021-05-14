/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import BLL.Employee;
import BLL.EmployeeDepartmentHistory;
import DAL.EmployeeDepHistoryException;
import DAL.EmployeeDepHistoryRepository;
import GUI.Utility;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Armend
 */
public class EmployeeTableModel extends AbstractTableModel {

    EmployeeDepHistoryRepository edhr = new EmployeeDepHistoryRepository();
    EmployeeDepHistoryTableModel edhtm = new EmployeeDepHistoryTableModel();

    public void createEmpDepHisList(){
        try {
           edhtm.addList(edhr.findAll());
           edhtm.fireTableDataChanged();           
        } catch (EmployeeDepHistoryException ex) {
            Logger.getLogger(EmployeeTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    String[] cols = {"EmployeeID", "Name", "LastName", "FathersName", "BirthDate", "PersonalNr", "HiredDate",
        "gender", "MobileNumber", "HomeNumber", "Address", "State", "Email", "Status", "JobTitle", "Department"};
    List<Employee> list;

    public EmployeeTableModel() {
    }

    public EmployeeTableModel(List<Employee> list) {
        this.list = list;
    }
    
    public void add(List<Employee> list){
        this.list =list ;
    }

    public Employee getEmployee(int index) {
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
    public String getColumnName(int col) {
        return cols[col];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Employee e = (Employee) list.get(rowIndex);
        createEmpDepHisList();
        switch (columnIndex) {
            case 0:
                return e.getEmployeeID();
            case 1:
                return e.getEmployeeName();
            case 2:
                return e.getEmployeeLastName();
            case 3:
                return e.getFathersName();
            case 4:
                return Utility.format(e.getBirthDate());
            case 5:
                return e.getPersonalNumber();
            case 6:
                return Utility.format(e.getHiredDate());
            case 7:
                return e.getGender();
            case 8:
                return e.getMobileNumber();
            case 9:
                return e.getHomeNumber();
            case 10:
                return e.getEmployeeAddress();
            case 11:
                return e.getEmployeeState();
            case 12:
                return e.getEmail();
            case 13:
                return e.getEmployeeStatus();
            case 14:
                return e.getJobTitle();
            case 15:
                for(int i=0 ; i< edhtm.getRowCount() ; i++){
                    if(e.equals(edhtm.getValueAt(i,2)) && edhtm.getValueAt(i,4)== null){
                        return edhtm.getValueAt(i,1);
                    }
                }
            default:
                return null;
        }
    }
}
