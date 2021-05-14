/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import BLL.Request;
import BLL.Request;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Armend
 */
public class RequestTableModel extends AbstractTableModel {

    private String[] cols = {"requestID", "requestDays", "requestDate",
        "startDate", "endDate", "approvedDate", "Employee", "Leave", "RequestStatus"};
    private List<Request> list;

    public RequestTableModel() {

    }

    public RequestTableModel(List<Request> list) {
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
    public int getRowCount() {
        return list.size();
    }

    @Override
    public String getColumnName(int col) {
        return cols[col];
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
                return r.getRequestID();
            case 1:
                return r.getRequestDays();
            case 2:
                return r.getRequestDate();
            case 3:
                return r.getStartDate();
            case 4:
                return r.getEndDate();
            case 5:
                return r.getApprovedDate();
            case 6:
                return r.getEmployee();
            case 7:
                return r.getLeave();
            case 8:
                return r.getRequestStatus();
            default:
                return null;
        }
    }

}
