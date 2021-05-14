/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.RequestStatus;
import DAL.RequestStatusException;
import DAL.RequestStatusInterface;
import DAL.RequestStatusRepository;
import MODEL.RequestStatusTableModel;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Ariot
 */
public class RequestStatusForm extends javax.swing.JInternalFrame {

    RequestStatusInterface rsr = new RequestStatusRepository();
    RequestStatusTableModel rstm = new RequestStatusTableModel();

    public RequestStatusForm() {
        initComponents();
        loadTable();
        tableSelectedIndexChange();
    }

    public void loadTable() {
        try {
            List<RequestStatus> lista = rsr.findAll();
            rstm.add(lista);
            requestStatusTable.setModel(rstm);
            rstm.fireTableDataChanged();
        } catch (RequestStatusException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void tableSelectedIndexChange() {
        final ListSelectionModel rowSM = requestStatusTable.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    RequestStatus rs = rstm.getRequestStatus(selectedIndex);

                    requestStatusIDTxt.setText(rs.getRequestStatusID() + "");
                    requestStatusDescriptionTxt.setText(rs.getRequestStatusDescription() + "");
                }
            }

        });
    }

    public void clear() {
        requestStatusTable.clearSelection();
        requestStatusDescriptionTxt.setText("");
        requestStatusIDTxt.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        requestStatusIdLbl = new javax.swing.JLabel();
        requestStatusDescriptionLbl = new javax.swing.JLabel();
        requestStatusIDTxt = new javax.swing.JTextField();
        requestStatusDescriptionTxt = new javax.swing.JTextField();
        saveBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        requestStatusTable = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);

        requestStatusIdLbl.setText("Request Status ID :");

        requestStatusDescriptionLbl.setText("* Description:");

        requestStatusIDTxt.setEditable(false);

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

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Request Status Form");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(requestStatusIdLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100))
                            .addComponent(requestStatusIDTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(requestStatusDescriptionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(requestStatusDescriptionLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(requestStatusDescriptionLbl, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(requestStatusIdLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(requestStatusDescriptionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(requestStatusIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelBtn)
                    .addComponent(saveBtn)
                    .addComponent(editBtn)
                    .addComponent(deleteBtn))
                .addContainerGap())
        );

        requestStatusTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(requestStatusTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        int row = requestStatusTable.getSelectedRow();
        if (row != -1) {
            RequestStatus rs = rstm.getRequestStatus(row);
            rs.setRequestStatusDescription(requestStatusDescriptionTxt.getText());
            if (rs.getRequestStatusDescription().length() > 3) {
                try {
                    rsr.edit(rs);
                    clear();
                    loadTable();
                } catch (RequestStatusException e) {
                    JOptionPane.showMessageDialog(null, "Diqka Gabim!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Description Duhet te kete se paku 6 shkronja");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selektoni ate qe deshironi ta editoni");
        }
    }//GEN-LAST:event_editBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        int row = requestStatusTable.getSelectedRow();
        if (row == -1) {
            RequestStatus rs = new RequestStatus();
            rs.setRequestStatusDescription(requestStatusDescriptionTxt.getText());
            if (rs.getRequestStatusDescription().length() >= 3) {
                try {
                    rsr.create(rs);
                    loadTable();
                    clear();
                } catch (RequestStatusException e) {
                    JOptionPane.showMessageDialog(null, "Gabim diqka!");
                }
            }else{
                JOptionPane.showMessageDialog(null,"Description duhet te jete se paku 3 shkronja.");
            }
        }else{
            JOptionPane.showMessageDialog(null,"Te dhenat duhet ti shenoni vet.");
            clear();
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int row = requestStatusTable.getSelectedRow();
        if (row != -1) {
            Object[] obj = {"PO", "JO"};
            int i = JOptionPane.showOptionDialog(this, "A deshironi ta fshni?", "fshirja",
                    JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, obj, obj[1]);
            if (i == 0) {
                RequestStatus rs = rstm.getRequestStatus(row);
                try {
                    rsr.delete(rs);
                    clear();
                    loadTable();
                } catch (RequestStatusException e) {
                    JOptionPane.showMessageDialog(null, "Gabim diqka");
                }

            }
        } else {
            JOptionPane.showMessageDialog(null, "Selektoni statusin te cilin deshironi ta fshini.");
        }

    }//GEN-LAST:event_deleteBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        clear();
    }//GEN-LAST:event_cancelBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel requestStatusDescriptionLbl;
    private javax.swing.JTextField requestStatusDescriptionTxt;
    private javax.swing.JTextField requestStatusIDTxt;
    private javax.swing.JLabel requestStatusIdLbl;
    private javax.swing.JTable requestStatusTable;
    private javax.swing.JButton saveBtn;
    // End of variables declaration//GEN-END:variables
}
