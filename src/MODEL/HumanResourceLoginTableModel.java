/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import BLL.HumanResourceLogin;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author USER
 */
public class HumanResourceLoginTableModel extends AbstractTableModel{
    
    List<HumanResourceLogin> list;
    private String [] columns = {"HumanResourceLogin ID", "HumanResourceLogin Username","HumanResourceLogin Password"};
    
            
    public HumanResourceLoginTableModel (){
    }
    
    public HumanResourceLoginTableModel(List<HumanResourceLogin> list){
        this.list = list;
    }
    
    public HumanResourceLogin getHumanResourceLogin(int index){
        return list.get(index);
    }
    
    @Override
    public String getColumnName(int col){
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
        
        HumanResourceLogin hrl = getHumanResourceLogin(rowIndex);
        
        switch (columnIndex){
            case 0:
                return hrl.getLoginID();
            case 1:
                return hrl.getLoginUsername();
            case 2:
                return hrl.getLoginPassword();
            case 3:
                return hrl.getEmployee();
            default :
                return null;
        }
    }
    
}
