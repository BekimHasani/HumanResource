/*
 * To change this license header, choose License Headers in Project Propertijt.
 * To change this template file, choose Tools | Templatjt
 * and open the template in the editor.
 */
package GUI;

import BLL.JobTitle;
import DAL.JobTitleException;
import DAL.JobTitleInterface;
import DAL.JobTitleRepository;
import MODEL.JobTitleTableModel;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Armend
 */
public class JobTitleForm extends javax.swing.JInternalFrame {

    JobTitleInterface jtr = new JobTitleRepository();
    JobTitleTableModel jttm = new JobTitleTableModel();
    private boolean status;

    public JobTitleForm() {
        initComponents();
        loadTable();
        tabelaSelectedIndexChange();
    }

    public void loadTable() {
        try {
            List<JobTitle> list = jtr.findAll();
            jttm.add(list);
            jobTitleTbl.setModel(jttm);
            jttm.fireTableDataChanged();
        } catch (JobTitleException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void tabelaSelectedIndexChange() {
        final ListSelectionModel rowSM = jobTitleTbl.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    JobTitle jt = jttm.getJobTitle(selectedIndex);

                    jobTitleIDTxt.setText(jt.getJobTitleID() + "");
                    jobTitleDescriptionTxt.setText(jt.getJobTitleDescription());
                    if (jt.getJobTitleStatus()) {
                        activeRbt.setSelected(true); ;
                    }else{
                        inactiveRbt.setSelected(true);
                    }
                }
            }
        });
    }

    public void clear() {
        jobTitleTbl.clearSelection();
        jobTitleIDTxt.setText("");
        jobTitleDescriptionTxt.setText("");
        activeRbt.setSelected(false);
        inactiveRbt.setSelected(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        saveBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        inactiveRbt = new javax.swing.JRadioButton();
        activeRbt = new javax.swing.JRadioButton();
        jobTitleStatusLbl = new javax.swing.JLabel();
        jobTitleDescriptionTxt = new javax.swing.JTextField();
        jobTitleDescriptionLbl = new javax.swing.JLabel();
        jobTitleIDTxt = new javax.swing.JTextField();
        jobTitleIDLbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jobTitleTbl = new javax.swing.JTable();

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

        buttonGroup.add(inactiveRbt);
        inactiveRbt.setText("inactive");
        inactiveRbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inactiveRbtActionPerformed(evt);
            }
        });

        buttonGroup.add(activeRbt);
        activeRbt.setText("active");
        activeRbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activeRbtActionPerformed(evt);
            }
        });

        jobTitleStatusLbl.setText("Status");

        jobTitleDescriptionLbl.setText("Description:");

        jobTitleIDTxt.setEditable(false);

        jobTitleIDLbl.setText("ID:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Job Title Form");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel1))
                            .addComponent(jobTitleIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jobTitleIDLbl))
                        .addGap(59, 59, 59)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jobTitleDescriptionLbl)
                            .addComponent(jobTitleDescriptionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(activeRbt)
                                .addGap(45, 45, 45)
                                .addComponent(inactiveRbt))
                            .addComponent(jobTitleStatusLbl))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jobTitleIDLbl)
                    .addComponent(jobTitleDescriptionLbl)
                    .addComponent(jobTitleStatusLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jobTitleIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jobTitleDescriptionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(activeRbt)
                    .addComponent(inactiveRbt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteBtn)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveBtn)
                    .addComponent(editBtn))
                .addContainerGap())
        );

        jobTitleTbl.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jobTitleTbl);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        int row = jobTitleTbl.getSelectedRow();
        if (row == -1) {
            JobTitle jt = new JobTitle();
            if(Utility.validName(jobTitleDescriptionTxt.getText())){
                jt.setJobTitleDescription(jobTitleDescriptionTxt.getText());
            }else{
                JOptionPane.showMessageDialog(this, "Invalid JobTitle description ");
            }
            jt.setJobTitleStatus(status);
            if (jt.getJobTitleDescription().length() >= 3) {
                try {
                    jtr.create(jt);
                    clear();
                    loadTable();
                } catch (JobTitleException e) {
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

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
         int row = jobTitleTbl.getSelectedRow();
        if (row != -1) {
            JobTitle jt = jttm.getJobTitle(row);
            jt.setJobTitleDescription(jobTitleDescriptionTxt.getText());
            jt.setJobTitleStatus(status);
            if (jt.getJobTitleDescription().length() >= 3) {
                try {
                    jtr.edit(jt);
                    clear();
                    loadTable();
                } catch(JobTitleException e) {
                    JOptionPane.showMessageDialog(null, "diqka gabim");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Description duhet te kete se paku 6 shkronja");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selektoni ate qe deshironi te editonis");
        }
    }//GEN-LAST:event_editBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int row = jobTitleTbl.getSelectedRow();
        if (row != -1) {
            Object[] obj = {"Po", "Jo"};
            int i = JOptionPane.showOptionDialog(this, "A deshironi ta fshini ", "fshirja",
                    JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, obj, obj[1]);
            if (i == 0) {
                JobTitle jt = jttm.getJobTitle(row);
                try {
                    jtr.delete(jt);
                    clear();
                    loadTable();
                } catch (JobTitleException e) {
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

    private void activeRbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activeRbtActionPerformed
        status = true;
    }//GEN-LAST:event_activeRbtActionPerformed

    private void inactiveRbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inactiveRbtActionPerformed
        status = false;
    }//GEN-LAST:event_inactiveRbtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton activeRbt;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JRadioButton inactiveRbt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jobTitleDescriptionLbl;
    private javax.swing.JTextField jobTitleDescriptionTxt;
    private javax.swing.JLabel jobTitleIDLbl;
    private javax.swing.JTextField jobTitleIDTxt;
    private javax.swing.JLabel jobTitleStatusLbl;
    private javax.swing.JTable jobTitleTbl;
    private javax.swing.JButton saveBtn;
    // End of variables declaration//GEN-END:variables
}