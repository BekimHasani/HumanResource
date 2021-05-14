/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import BLL.Certifiable;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bekim
 */
public class CertifiableTableModel extends AbstractTableModel{

    private String [] cols = {"CertifiableID","CertifiableDescription"};
    List<Certifiable> list;
    
    public CertifiableTableModel(){
    
    }
    
    public CertifiableTableModel(List<Certifiable> list) {
        this.list = list;
    }
    
    public Certifiable getCertifiable(int i){
        return list.get(i);
    }
    public void add(List<Certifiable> list){
        this.list = list;
    }
    
    public void remove(Certifiable c) {
        list.remove(c);
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }
    
    @Override
    public String getColumnName(int col){
        return cols[col];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Certifiable c = (Certifiable) list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return c.getCertifiableID();
            case 1:
                return c.getCertifiableDescription();
            default:
                return null;
        }
    }    
}
