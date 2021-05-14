/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import BLL.RequestStatus;
import BLL.RequestStatus;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author USER
 */
public class RequestStatusTableModel extends AbstractTableModel{

    private String [] cols = {"requestStatusID","requestStatusDescription"};
    List<RequestStatus> list;
    
    public RequestStatusTableModel(){
    
    }
    
    public RequestStatusTableModel(List<RequestStatus> list) {
        this.list = list;
    }
    
    public RequestStatus getRequestStatus(int i){
        return list.get(i);
    }
    public void add(List<RequestStatus> list){
        this.list = list;
    }
    
    public void remove(RequestStatus rs) {
        list.remove(rs);
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
        RequestStatus rs = (RequestStatus) list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return rs.getRequestStatusID();
            case 1:
                return rs.getRequestStatusDescription();
            case 2:
            default:
                return null;
        }
    }    
}
