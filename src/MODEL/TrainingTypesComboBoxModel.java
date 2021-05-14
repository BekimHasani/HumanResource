/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import BLL.TrainingTypes;
import BLL.TrainingTypes;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author BesaC
 */
public class TrainingTypesComboBoxModel extends AbstractListModel <TrainingTypes> implements ComboBoxModel<TrainingTypes>{

    private TrainingTypes selected;
    private List<TrainingTypes> list;
    
    public TrainingTypesComboBoxModel(){
    }
    
    public TrainingTypesComboBoxModel(List<TrainingTypes> list){
        this.list = list;
        
    }
    
    @Override
    public int getSize() {
        return list.size();        
    }

    @Override
    public TrainingTypes getElementAt(int index) {
        return list.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
       selected = (TrainingTypes) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selected;
    }
    
    public void add(List<TrainingTypes> list){
        this.list = list;       
    }
    
}
