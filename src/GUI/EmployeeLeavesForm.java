/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.EmployeeLeaves;
import BLL.JobTitle;
import DAL.EmployeeLeavesException;
import DAL.EmployeeLeavesRepository;
import MODEL.EmployeeLeavesTableModel;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Armend
 */
public class EmployeeLeavesForm extends javax.swing.JInternalFrame {

    private EmployeeLeavesTableModel eltm = new EmployeeLeavesTableModel();
    private EmployeeLeavesRepository elr = new EmployeeLeavesRepository();
    private List<Integer> integerList = null;
    private List<EmployeeLeaves> leaves = new ArrayList<EmployeeLeaves>();
    private JobTitle jb = MainForm.getEmployee().getJobTitle();
    
    public EmployeeLeavesForm() {
        initComponents();
        loadTable();
    }

    public void loadTable(){
        try{
            leaves = new ArrayList<EmployeeLeaves>();
            if(jb.getJobTitleID() == 4){
                integerList = elr.searchEmployeeLeavesHR("");
            }else if(jb.getJobTitleID() == 4){
                integerList = elr.searchEmployeeLeavesCEO("");
            }else{
                integerList = elr.searchEmployeeLeavesDIR("");
            }
            for (int i = 0; i < integerList.size(); i++) {
                leaves.add((EmployeeLeaves)elr.findById(integerList.get(i)));
            }
            eltm.add(leaves);
            employeeLeavesTbl.setModel(eltm);
            eltm.fireTableDataChanged();
        } catch (EmployeeLeavesException ex) {
            JOptionPane.showMessageDialog(this,"[loadTable-ERROR]: " + ex.getMessage());
        }
    }
    
    public void loadTable(String str,JobTitle jb){
        try{
            leaves = new ArrayList<EmployeeLeaves>();
            if(jb.getJobTitleID() == 4){
                integerList = elr.searchEmployeeLeavesHR(str);
            }else if(jb.getJobTitleID() == 4){
                integerList = elr.searchEmployeeLeavesCEO(str);
            }else{
                integerList = elr.searchEmployeeLeavesDIR(str);
            }
            for (int i = 0; i < integerList.size(); i++) {
                leaves.add((EmployeeLeaves)elr.findById(integerList.get(i)));
            }
            eltm.add(leaves);
            employeeLeavesTbl.setModel(eltm);
            eltm.fireTableDataChanged();
        } catch (EmployeeLeavesException ex) {
            JOptionPane.showMessageDialog(this,"[loadTable-ERROR]: " + ex.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        employeeLeavesTbl = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        searchEmployeeLeavesTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);

        employeeLeavesTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(employeeLeavesTbl);

        jButton1.setText("Generate Reports");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        searchEmployeeLeavesTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchEmployeeLeavesTxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchEmployeeLeavesTxtKeyReleased(evt);
            }
        });

        jLabel1.setText("Search Employee Leave :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Employee Department History");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 823, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(searchEmployeeLeavesTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 639, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchEmployeeLeavesTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchEmployeeLeavesTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchEmployeeLeavesTxtKeyPressed
        
    }//GEN-LAST:event_searchEmployeeLeavesTxtKeyPressed

    private void searchEmployeeLeavesTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchEmployeeLeavesTxtKeyReleased
        loadTable(searchEmployeeLeavesTxt.getText(),jb);
    }//GEN-LAST:event_searchEmployeeLeavesTxtKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Utility.writeToExcell(employeeLeavesTbl,"C:/Users/Armend/Desktop/projektiLab/nes/test/raportet/EmployeeLeaves"+LocalDate.now()+".xls");
        } catch (IOException ex) {
            Logger.getLogger(EmployeeLeavesForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable employeeLeavesTbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchEmployeeLeavesTxt;
    // End of variables declaration//GEN-END:variables
}
