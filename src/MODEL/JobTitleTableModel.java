/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import BLL.JobTitle;
import BLL.JobTitle;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Armend
 */
public class JobTitleTableModel extends AbstractTableModel {

    private String[] cols = {"jobTitleID","jobTitleDescription","jobTitleStatus"};
    private List<JobTitle> list;
    
    public JobTitleTableModel(){
        
    }
    
    public JobTitleTableModel(List<JobTitle> list){
        this.list = list;
    }
    
    public void add(List<JobTitle> list){
        this.list = list;
    }
    
    public JobTitle getJobTitle(int i){
        return list.get(i);
    }
    
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
        JobTitle jb = (JobTitle)list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return jb.getJobTitleID();
            case 1:
                return jb.getJobTitleDescription();
            case 2:
                if (jb.getJobTitleStatus()) {
                    return "active";
                }
                return "inactive";
            default:
                return null;
        }
    }
    
}
