/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import BLL.TrainingTypes;
import BLL.TrainingTypes;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author BesaC
 */
public class TrainingTypesTableModel extends AbstractTableModel {
    List<TrainingTypes> list;
    private String [] columns = {"Training ID", "Training Description", "Certifiable/Not Certifiable"};

    public TrainingTypesTableModel(){
    
    }
    
    public TrainingTypesTableModel(List<TrainingTypes> list) {
        this.list = list;
    }
    
    public TrainingTypes getTrainingTypes(int index){
        return list.get(index);
    }
    
    @Override
    public String getColumnName(int col){
        return columns [col];
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
        
        TrainingTypes h = getTrainingTypes(rowIndex);
        
        switch(columnIndex){
            
            case 0:
                return h.getTrainingID();
            case 1:
                return h.getTrainingDescription();
            case 2:
                return h.getCertifiable();
            default:
                return null;
        }
    }
}
