/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import BLL.EmployeeStatus;
import BLL.EmployeeStatus;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Armend
 */
public class EmployeeStatusComboBoxModel extends AbstractListModel<EmployeeStatus> implements ComboBoxModel<EmployeeStatus> {

    private EmployeeStatus selected;
    private List<EmployeeStatus> list;

    public EmployeeStatusComboBoxModel() {

    }

    public EmployeeStatusComboBoxModel(List<EmployeeStatus> list) {
        this.list = list;
    }

    public void add(List<EmployeeStatus> list) {
        this.list = list;
    }

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public EmployeeStatus getElementAt(int index) {
        return list.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selected = (EmployeeStatus) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selected;
    }

}
