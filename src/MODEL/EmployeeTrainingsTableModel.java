/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import BLL.EmployeeTrainings;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author BesaC
 */
public class EmployeeTrainingsTableModel extends AbstractTableModel {

    List<EmployeeTrainings> list;
    private String[] columns = {"ID", "Employee", "Training","StartDate","EndDate", "TrainingStatus", "Certificate:"};

    public EmployeeTrainingsTableModel() {
    }

    public EmployeeTrainingsTableModel(List<EmployeeTrainings> list) {
        this.list = list;
    }

    public EmployeeTrainings getEmployeeTrainings(int index) {
        return list.get(index);
    }

    public void add(List<EmployeeTrainings> list) {
        this.list = list;
    }
    
    public EmployeeTrainings getRow(int i){
        return list.get(i);
    }
    
    @Override
    public String getColumnName(int col) {

        return columns[col];
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
        EmployeeTrainings et = getEmployeeTrainings(rowIndex);
        switch (columnIndex) {
            case 0:
              return et.getEmployeeTrainingId();
            case 1:
                return et.getEmployee();
            case 2:
                return et.getTraining();
            case 3:
                return et.getStartDate();
            case 4:
                return et.getEndDate();
            case 5:
                return et.getTrainingStatus();                
            case 6:
                return et.getCertified();
            default:
                return null;
        }
    }

}
