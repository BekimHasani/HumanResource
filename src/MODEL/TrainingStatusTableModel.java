/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import BLL.TrainingStatus;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author BesaC
 */
public class TrainingStatusTableModel extends AbstractTableModel{
    
    List<TrainingStatus> list;
    private String [] columns = {"TrainingStatus ID", "Status Description"};
    
            
    public TrainingStatusTableModel (){
    }
    
    public TrainingStatusTableModel(List<TrainingStatus> list){
        this.list = list;
    }
    
    public TrainingStatus getTrainingStatus(int index){
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
        
        TrainingStatus ts = getTrainingStatus(rowIndex);
        
        switch (columnIndex){
            case 0:
                return ts.getTrainingStatusID();
            case 1:
                return ts.getTraningStatusDescription();
            default :
                return null;
        }
    }
    
}
