/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import BLL.Logins;
import GUI.Utility;
import java.sql.Time;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Armend
 */
public class LoginsTableModel extends AbstractTableModel {

    private List<Logins> list = null;
    private String [] colums = {"ID","Employee","LoginDate","logined","logout","Time online"};
    
    public LoginsTableModel(){
        
    }
    
    public LoginsTableModel(List<Logins> list){
        this.list = list;
    }
    
    public Logins getLogin(int i){
        return list.get(i);
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public String getColumnName(int col){
        return colums[col];
    }
    @Override
    public int getColumnCount() {
        return colums.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Logins login = (Logins) list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return login.getLoginID();
            case 1:
                return login.getEmployee();
            case 2:
                return Utility.format(login.getLoginDate());
            case 3:
                return login.getLogined();
            case 4:
                return login.getLogouted();
            case 5:
                return login.getLoginedTime();
            default:
                return null;
        }
    }

    public void add(List<Logins> list) {
        this.list = list;
    }
    
}
