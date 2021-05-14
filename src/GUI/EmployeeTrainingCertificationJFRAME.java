/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.EmployeeTrainings;
import DAL.EmployeeTrainingsException;
import DAL.EmployeeTrainingsInterface;
import DAL.EmployeeTrainingsRepository;
import MODEL.CertifiableTableModel;
import MODEL.EmployeeTrainingsTableModel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BesaC
 */
public class EmployeeTrainingCertificationJFRAME extends javax.swing.JFrame {

    EmployeeTrainingsInterface etr = new EmployeeTrainingsRepository();
    EmployeeTrainingsTableModel ettm = new EmployeeTrainingsTableModel();

    CertifiableTableModel ctm = new CertifiableTableModel();
    List<EmployeeTrainings> list;

    public EmployeeTrainingCertificationJFRAME() {
        initComponents();
        tableLoad();
    }

    public void tableLoad() {
        try {
            list = etr.findAll();
            for (int i = 0; i < list.size(); i++) {
                EmployeeTrainings e = list.get(i);
                if (e.getCertified() != null) {
                    list.remove(e);
                }
            }
            ettm = new EmployeeTrainingsTableModel(list);
            table.setModel(ettm);
            ettm.fireTableDataChanged();
        } catch (EmployeeTrainingsException ex) {
            Logger.getLogger(EmployeeTrainingCertificationJFRAME.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        notCertifyBtn = new javax.swing.JButton();
        certifyBtn = new javax.swing.JButton();
        CertifyAllBtn = new javax.swing.JButton();

        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        table.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table);

        jLabel1.setText("List of pending Certifications: ");

        notCertifyBtn.setText("Not Certified");
        notCertifyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notCertifyBtnActionPerformed(evt);
            }
        });

        certifyBtn.setText("Certified");
        certifyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                certifyBtnActionPerformed(evt);
            }
        });

        CertifyAllBtn.setText("Certify All");
        CertifyAllBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CertifyAllBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 739, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CertifyAllBtn)
                .addGap(38, 38, 38)
                .addComponent(certifyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(notCertifyBtn)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(certifyBtn)
                    .addComponent(notCertifyBtn)
                    .addComponent(CertifyAllBtn))
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void certifyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_certifyBtnActionPerformed

        int row = table.getSelectedRow();

        if (row != -1) {
            EmployeeTrainings et = ettm.getEmployeeTrainings(row);

            et.setCertified(ctm.getCertifiable(1));
            list.remove(et);
            table.clearSelection();
        }
    }//GEN-LAST:event_certifyBtnActionPerformed

    private void notCertifyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notCertifyBtnActionPerformed
        
        int row = table.getSelectedRow();

        if (row != -1) {
            EmployeeTrainings et = ettm.getEmployeeTrainings(row);

            et.setCertified(ctm.getCertifiable(2));
            list.remove(et);
            table.clearSelection();
        }
    }//GEN-LAST:event_notCertifyBtnActionPerformed

    private void CertifyAllBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CertifyAllBtnActionPerformed
        for(EmployeeTrainings et: list){
            et.setCertified(ctm.getCertifiable(1));
            list.remove(et);
        }
    }//GEN-LAST:event_CertifyAllBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmployeeTrainingCertificationJFRAME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeTrainingCertificationJFRAME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeTrainingCertificationJFRAME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeTrainingCertificationJFRAME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeTrainingCertificationJFRAME().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CertifyAllBtn;
    private javax.swing.JButton certifyBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton notCertifyBtn;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
