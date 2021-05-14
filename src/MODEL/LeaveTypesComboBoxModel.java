/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import BLL.LeaveTypes;
import BLL.LeaveTypes;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Armend
 */
public class LeaveTypesComboBoxModel extends AbstractListModel<LeaveTypes> implements ComboBoxModel<LeaveTypes>{

    private List<LeaveTypes> list;
    private LeaveTypes selected;
    
    public LeaveTypesComboBoxModel(){
        
    }
    
    public LeaveTypesComboBoxModel(List<LeaveTypes> list){
        this.list = list;
    }
    
    public void add(List<LeaveTypes> list){
        this.list = list;
    }
    
    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public LeaveTypes getElementAt(int index) {
        return list.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selected = (LeaveTypes)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selected;
    }
    
}
