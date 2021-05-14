/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import BLL.Employee;
import BLL.Employee;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author BesaC
 */
public class EmployeeComboBoxModel extends AbstractListModel<Employee> implements ComboBoxModel<Employee>{
    
    private Employee selected;
    private List<Employee> list;
 
    public EmployeeComboBoxModel(){
    }
    
    public EmployeeComboBoxModel(List<Employee> list){
        this.list = list;
    }

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Employee getElementAt(int index) {
        return list.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selected = (Employee) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selected;
    }
    
    public void add(List<Employee> list){
        this.list = list;
    }    
}


    
 
