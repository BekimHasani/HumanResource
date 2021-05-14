/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import BLL.TrainingStatus;
import BLL.TrainingStatus;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author BesaC
 */
public class TrainingStatusComboBoxModel extends AbstractListModel<TrainingStatus> implements ComboBoxModel<TrainingStatus>{
    
    private TrainingStatus selected;
    private List<TrainingStatus> list;
    
    public TrainingStatusComboBoxModel(){
    }
    
    public TrainingStatusComboBoxModel(List <TrainingStatus> list) {
        this.list = list;
    }
    
    public void add(List<TrainingStatus> list){
        this.list = list;
    }
    
    @Override
    public int getSize() {
        return list.size();
    }
    
    

    @Override
    public TrainingStatus getElementAt(int index) {
        return list.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selected = (TrainingStatus) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selected;
    }
    
    
    
}
