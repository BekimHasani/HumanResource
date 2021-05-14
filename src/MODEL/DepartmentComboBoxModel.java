/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import BLL.Department;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Bekim
 */
public class DepartmentComboBoxModel extends AbstractListModel<Department> implements ComboBoxModel<Department> {

    private List<Department> list ;
    private Department selectedItem ;
    
    public DepartmentComboBoxModel(){
    }
    
    public DepartmentComboBoxModel(List<Department> list){
        this.list = list ;
    }
    
    public void add(List<Department> list){
        this.list = list ;
    }
    @Override
    public int getSize() {
        return list.size() ;
    }
    
    @Override
    public Department getElementAt(int index) {
        return list.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem =(Department) anItem ;
    }

    @Override
    public Object getSelectedItem(){
        return selectedItem;
    }
    
}
