/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import BLL.JobTitle;
import BLL.JobTitle;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Armend
 */
public class JobTitleComboBoxModel extends AbstractListModel<JobTitle> implements ComboBoxModel<JobTitle> {
    
    private List<JobTitle> list;
    private JobTitle selected; 
    
    public JobTitleComboBoxModel(){
        
    }
    
    public JobTitleComboBoxModel(List<JobTitle> list){
        this.list = list;
    }
    
    public void add(List<JobTitle> list){
        this.list = list;
    }
    
    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public JobTitle getElementAt(int index) {
        return list.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selected = (JobTitle)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selected;
    }
    
}
