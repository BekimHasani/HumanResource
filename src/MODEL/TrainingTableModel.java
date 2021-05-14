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
 * @author Bekim
 */
public class TrainingTableModel extends AbstractTableModel {

    private String[] cols = {"TrainingId", "TraningStatus", "StartDate", "EndDate"};
    private List<EmployeeTrainings> list;

    public TrainingTableModel() {

    }

    public TrainingTableModel(List<EmployeeTrainings> list) {
        this.list = list;
    }

    public void add(List<EmployeeTrainings> list) {
        this.list = list;
    }
    
    private EmployeeTrainings getEmployeeTrainings(int rowIndex) {
        return list.get(rowIndex);
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
            default:
                return null;
        }
    }
}
