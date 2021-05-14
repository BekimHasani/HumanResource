/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import BLL.Request;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bekim
 */
public class ApprovementTableModel extends AbstractTableModel {
     private String[] cols = {"Employee Name", "Employee ID", "Leave Type",
        "Start Date", "End Date", "Num of Days", "Request Description" };
    private List<Request> list;

    public ApprovementTableModel() {
    }

    public ApprovementTableModel(List<Request> list) {
        this.list = list;
    }

    public void add(List<Request> list) {
        this.list = list;
    }

    public Request getRequest(int index) {
        return list.get(index);
    }

    public void remove(Request r) {
        list.remove(r);
    }
    
    @Override
    public String getColumnName(int col){
        return cols[col];
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
        Request r = (Request) list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return r.getEmployee().getEmployeeName();
            case 1:
                return r.getEmployee().getEmployeeID();
            case 2:
                return r.getLeave().getLeaveDescription();
            case 3:
                return r.getStartDate();
            case 4:
                return r.getEndDate();
            case 5:
                return r.getRequestDays();
            case 6:
                return r.getRequestStatus().getRequestStatusDescription();
            default:
                return null;
        }
    }
}
