/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import BLL.Certifiable;
import BLL.Certifiable;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author BesaC
 */
public class CertifiableComboBoxModel extends AbstractListModel<Certifiable> implements ComboBoxModel<Certifiable>{
    
    private Certifiable selected;
    private List<Certifiable> list;
    
    public CertifiableComboBoxModel(){
    }
    
    public CertifiableComboBoxModel(List <Certifiable> list) {
        this.list = list;
    }
    
    public void add(List<Certifiable> list){
        this.list = list;
    }
    
    @Override
    public int getSize() {
        return list.size();
    }
    
    

    @Override
    public Certifiable getElementAt(int index) {
        return list.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selected = (Certifiable) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selected;
    }
}