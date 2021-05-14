/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.EmployeeStatus;
import DAL.EmployeeStatusException;
import DAL.EmployeeStatusInterface;
import DAL.EmployeeStatusRepository;
import MODEL.EmployeeStatusTableModel;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


/**
 *
 * @author Armend
 */
public class EmployeeStatusForm extends javax.swing.JInternalFrame {

    EmployeeStatusInterface esr = new EmployeeStatusRepository();
    EmployeeStatusTableModel estm = new EmployeeStatusTableModel();
    
    public EmployeeStatusForm() {
        initComponents();
        loadTable();
        tabelaSelectedIndexChange();
    }
    
    public void loadTable(){
        try{
            List<EmployeeStatus> lista = esr.findAll();
            estm.add(lista);
            employeeStatusTbl.setModel(estm);
            estm.fireTableDataChanged();
        }catch(EmployeeStatusException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void tabelaSelectedIndexChange() {
        final ListSelectionModel rowSM = employeeStatusTbl.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    EmployeeStatus es = estm.getEmployeeStatus(selectedIndex);

                    employeeStatusIDTxt.setText(es.getEmployeeStatusID()+ "");
                    employeeStatusDescriptionTxt.setText(es.getEmployeeStatusDescription());
                }
            }
        });
    }
    
    public void clear(){
        employeeStatusTbl.clearSelection();
        employeeStatusDescriptionTxt.setText("");
        employeeStatusIDTxt.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        employeeStatusIDLbl = new javax.swing.JLabel();
        employeeStatusDescriptionLbl = new javax.swing.JLabel();
        employeeStatusIDTxt = new javax.swing.JTextField();
        employeeStatusDescriptionTxt = new javax.swing.JTextField();
        saveBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        employeeStatusTbl = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);

        employeeStatusIDLbl.setText("Employee Status ID:");

        employeeStatusDescriptionLbl.setText("Description:");

        employeeStatusIDTxt.setEditable(false);
        employeeStatusIDTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeStatusIDTxtActionPerformed(evt);
            }
        });

        employeeStatusDescriptionTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeStatusDescriptionTxtActionPerformed(evt);
            }
        });

        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        editBtn.setText("Edit");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Employee Status Form ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(employeeStatusIDLbl)
                            .addComponent(employeeStatusIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(employeeStatusDescriptionLbl)
                            .addComponent(employeeStatusDescriptionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeStatusDescriptionLbl)
                    .addComponent(employeeStatusIDLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeStatusIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(employeeStatusDescriptionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 264, Short.MAX_VALUE)
        );

        employeeStatusTbl.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(employeeStatusTbl);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void employeeStatusDescriptionTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeStatusDescriptionTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeStatusDescriptionTxtActionPerformed

    private void employeeStatusIDTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeStatusIDTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeStatusIDTxtActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
       int row = employeeStatusTbl.getSelectedRow();
        if (row == -1) {
            EmployeeStatus es = new EmployeeStatus();
            es.setEmployeeStatusDescription(employeeStatusDescriptionTxt.getText());
            if (es.getEmployeeStatusDescription().length() >= 3) {
                try {
                    esr.create(es);
                    loadTable();
                    clear();
                } catch (EmployeeStatusException e) {
                    JOptionPane.showMessageDialog(null, "Gabim diqka");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Description duhet te kete se paku 3 shkronja");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Te dhenat duhet ti shenoni vet");
            clear();
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int row = employeeStatusTbl.getSelectedRow();
        if (row != -1) {
            Object[] obj = {"Po", "Jo"};
            int i = JOptionPane.showOptionDialog(this, "A deshironi ta fshini ", "fshirja",
                    JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, obj, obj[1]);
            if (i == 0) {
                EmployeeStatus es = estm.getEmployeeStatus(row);
                try {
                    esr.delete(es);
                    clear();
                    loadTable();
                } catch (EmployeeStatusException e) {
                    JOptionPane.showMessageDialog(null, "Gabim diqka");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selektoni statusin te cilin deshironi ta fshini");
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        clear();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        int row = employeeStatusTbl.getSelectedRow();
        if (row != -1) {
            EmployeeStatus es = estm.getEmployeeStatus(row);
            es.setEmployeeStatusDescription(employeeStatusDescriptionTxt.getText());
            if (es.getEmployeeStatusDescription().length() >= 3) {
                try {
                    esr.edit(es);
                    clear();
                    loadTable();
                } catch (EmployeeStatusException e) {
                    JOptionPane.showMessageDialog(null, "diqka gabim");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Description duhet te kete se paku 6 shkronja");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selektoni ate qe deshironi te editonis");
        }
    }//GEN-LAST:event_editBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JLabel employeeStatusDescriptionLbl;
    private javax.swing.JTextField employeeStatusDescriptionTxt;
    private javax.swing.JLabel employeeStatusIDLbl;
    private javax.swing.JTextField employeeStatusIDTxt;
    private javax.swing.JTable employeeStatusTbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton saveBtn;
    // End of variables declaration//GEN-END:variables
}
