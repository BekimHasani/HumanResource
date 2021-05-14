/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.Certifiable;
import DAL.CertifiableException;
import DAL.CertifiableInterface;
import DAL.CertifiableRepository;
import MODEL.CertifiableTableModel;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Ariot
 */
public class CertifiableForm extends javax.swing.JInternalFrame {

    CertifiableInterface cr = new CertifiableRepository();
    CertifiableTableModel ctm = new CertifiableTableModel();

    public CertifiableForm() {
        initComponents();
        loadTable();
        tableSelectedIndexChange();
    }

    public void loadTable() {
        try {
            List<Certifiable> lista = cr.findAll();
            ctm.add(lista);
            certifiableTable.setModel(ctm);
            ctm.fireTableDataChanged();
        } catch (CertifiableException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void tableSelectedIndexChange() {
        final ListSelectionModel rowSM = certifiableTable.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    Certifiable c = ctm.getCertifiable(selectedIndex);

                    certifiableIDTxt.setText(c.getCertifiableID() + "");
                    certifiableDescriptionTxt.setText(c.getCertifiableDescription() + "");
                }
            }

        });
    }

    public void clear() {
        certifiableTable.clearSelection();
        certifiableDescriptionTxt.setText("");
        certifiableIDTxt.setText("");
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        certifiableIDLbl = new javax.swing.JLabel();
        certifiableDescriptionLbl = new javax.swing.JLabel();
        certifiableIDTxt = new javax.swing.JTextField();
        certifiableDescriptionTxt = new javax.swing.JTextField();
        saveBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        certifiableTable = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);

        certifiableIDLbl.setText("ID:");

        certifiableDescriptionLbl.setText("* Description:");

        certifiableIDTxt.setEditable(false);
        certifiableIDTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                certifiableIDTxtActionPerformed(evt);
            }
        });

        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        cancelBtn.setText("Cancel");

        editBtn.setText("Edit");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Certifiable Form");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(certifiableIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(certifiableIDLbl)
                                .addGap(270, 270, 270)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(certifiableDescriptionLbl)
                            .addComponent(certifiableDescriptionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(44, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(certifiableDescriptionLbl)
                    .addComponent(certifiableIDLbl))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(certifiableIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(certifiableDescriptionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn)
                    .addComponent(editBtn)
                    .addComponent(cancelBtn)
                    .addComponent(deleteBtn)))
        );

        certifiableTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(certifiableTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void certifiableIDTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_certifiableIDTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_certifiableIDTxtActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
 int row = certifiableTable.getSelectedRow();
        if (row != -1) {
            Certifiable c = ctm.getCertifiable(row);
            c.setCertifiableDescription(certifiableDescriptionTxt.getText());
            if (c.getCertifiableDescription().length() > 3) {
                try {
                    cr.edit(c);
                    clear();
                    loadTable();
                } catch (CertifiableException e) {
                    JOptionPane.showMessageDialog(null, "Diqka Gabim!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Description Duhet te kete se paku 6 shkronja");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selektoni ate qe deshironi ta editoni");
        }    }//GEN-LAST:event_editBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
   int row = certifiableTable.getSelectedRow();
        if (row == -1) {
            Certifiable c = new Certifiable();
            c.setCertifiableDescription(certifiableDescriptionTxt.getText());
            if (c.getCertifiableDescription().length() >= 3) {
                try {
                    cr.create(c);
                    loadTable();
                    clear();
                } catch (CertifiableException e) {
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
      int row = certifiableTable.getSelectedRow();
        if (row != -1) {
            Object[] obj = {"PO", "JO"};
            int i = JOptionPane.showOptionDialog(this, "A deshironi ta fshni?", "fshirja",
                    JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, obj, obj[1]);
            if (i == 0) {
                Certifiable c = ctm.getCertifiable(row);
                try {
                    cr.delete(c);
                    clear();
                    loadTable();
                } catch (CertifiableException e) {
                    JOptionPane.showMessageDialog(null, "Gabim diqka");
                }

            }
        } else {
            JOptionPane.showMessageDialog(null, "Selektoni statusin te cilin deshironi ta fshini.");
        }
    }//GEN-LAST:event_deleteBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel certifiableDescriptionLbl;
    private javax.swing.JTextField certifiableDescriptionTxt;
    private javax.swing.JLabel certifiableIDLbl;
    private javax.swing.JTextField certifiableIDTxt;
    private javax.swing.JTable certifiableTable;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton saveBtn;
    // End of variables declaration//GEN-END:variables
}
