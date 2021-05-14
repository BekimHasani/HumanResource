/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import BLL.LeaveTypes;
import BLL.LeaveTypes;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bekim
 */
public class LeaveTypesTableModel extends AbstractTableModel {
    private String[] cols = {"Leave ID","Leave Description","Leave Days" , "Leave Status"};
    List<LeaveTypes> list ;
    
    public LeaveTypesTableModel(){
    }

    public LeaveTypesTableModel(List<LeaveTypes> list){
        this.list = list;
    }
    
    public void addList(List<LeaveTypes>list){
        this.list = list ; 
    }
    
    public LeaveTypes getLeaveTypes(int index){
        return list.get(index);
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
        LeaveTypes lt = (LeaveTypes) list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return lt.getLeaveID();
            case 1:
                return lt.getLeaveDescription();
            case 2:
                return lt.getLeaveDays();
            case 3:
                if(lt.getLeaveStatus()){
                    return "active";
                }else{
                    return "inactive";
                }
            default:
                return null ;
        }
    }
}
