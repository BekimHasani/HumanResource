/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.Department;
import DAL.DepartmentException;
import DAL.DepartmentRepository;
import MODEL.DepartmentTableModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Bekim
 */
public class DepartmentForm extends javax.swing.JInternalFrame {

    DepartmentRepository dr = new DepartmentRepository();
    DepartmentTableModel dtm = new DepartmentTableModel();
    private boolean status;

    public DepartmentForm() {
        initComponents();
        loadTable();
        tableSelectedIndexChanged();
    }

    public void loadTable() {
        try {
            dtm.addList(dr.findAll());
            departmentTbl.setModel(dtm);
            dtm.fireTableDataChanged();
        } catch (DepartmentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void tableSelectedIndexChanged() {
        final ListSelectionModel rowSM = departmentTbl.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();

                if (selectedIndex > -1) {
                    Department d = dtm.getDepartment(selectedIndex);
                    departmentIdTxt.setText(d.getDepartmentID() + "");
                    departmentNameTxt.setText(d.getDepartmentName());
                    numOfEmployeesTxt.setText(d.getEmployees() + "");
                    if (d.getDepartmentStatus()) {
                        activeRBtn.setSelected(true);
                    } else {
                        activeRBtn.setSelected(false);
                    }
                }
            }
        });
    }

    public void clear() {
        departmentTbl.clearSelection();
        departmentIdTxt.setText("");
        departmentNameTxt.setText("");
        numOfEmployeesTxt.setText("");
        activeRBtn.setSelected(false);
        inactiveRBtn.setSelected(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        grupRBtn = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        departmentTbl = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        saveBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        departmentIdTxt = new javax.swing.JTextField();
        DepartmentIdLbl = new javax.swing.JLabel();
        departmentNameTxt = new javax.swing.JTextField();
        DepartmentNameLbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        numOfEmployeesTxt = new javax.swing.JTextField();
        activeRBtn = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        inactiveRBtn = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        departmentTbl.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(departmentTbl);

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn)
                    .addComponent(editBtn)
                    .addComponent(cancelBtn)
                    .addComponent(deleteBtn))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        departmentIdTxt.setEditable(false);
        departmentIdTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentIdTxtActionPerformed(evt);
            }
        });

        DepartmentIdLbl.setText("Department Id :");

        departmentNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentNameTxtActionPerformed(evt);
            }
        });

        DepartmentNameLbl.setText("* Department Name :");

        jLabel2.setText("* Num. of Employees : ");

        grupRBtn.add(activeRBtn);
        activeRBtn.setText("Active");
        activeRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activeRBtnActionPerformed(evt);
            }
        });

        jLabel3.setText("* Department Status :");

        grupRBtn.add(inactiveRBtn);
        inactiveRBtn.setText("Inactive");
        inactiveRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inactiveRBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DepartmentIdLbl)
                            .addComponent(departmentIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DepartmentNameLbl)
                            .addComponent(departmentNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numOfEmployeesTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(170, 170, 170)
                                .addComponent(activeRBtn)
                                .addGap(41, 41, 41)
                                .addComponent(inactiveRBtn))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(159, 159, 159)
                                .addComponent(jLabel3)))))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DepartmentIdLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DepartmentNameLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(departmentNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(departmentIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numOfEmployeesTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(activeRBtn)
                    .addComponent(inactiveRBtn))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Department ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 353, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int row = departmentTbl.getSelectedRow();
        if (row != -1) {
            Object[] obj = {"Yes", "No"};
            int i = JOptionPane.showOptionDialog(this, "Confirm your decision", "DELETION",
                    JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, obj, obj[1]);
            if (i == 0) {
                Department d = dtm.getDepartment(row);
                try {
                    dr.delete(d);
                    clear();
                    loadTable();
                } catch (DepartmentException e) {
                    JOptionPane.showMessageDialog(null, "Something is wrong with the database connection");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select the employee you want to delete");
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        clear();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        int row = departmentTbl.getSelectedRow();
        if (row != -1) {
            Department d = dtm.getDepartment(row);

            /*-- DEPARTMENT NAME --*/
            if (Utility.isEmpty(departmentNameTxt.getText())) {
                JOptionPane.showMessageDialog(this, "Department name cannot be empty");
                return;
            } else if (!Utility.validDepartmentName(departmentNameTxt.getText())) {
                JOptionPane.showMessageDialog(this, "Department name should contain only letters");
                return;
            } else if (departmentNameTxt.getText().length() <= 2) {
                JOptionPane.showMessageDialog(this, "Department name should contain at least 3 characters");
                return;
            } else if (departmentNameTxt.getText().length() >= 50) {
                JOptionPane.showMessageDialog(this, "Department name should contain at most 50 characters");
                return;
            } else {
                d.setDepartmentName(departmentNameTxt.getText());
            }

            /*-- NUMBERS OF EMPLOYEE --*/
            if (Utility.isEmpty(numOfEmployeesTxt.getText())) {
                JOptionPane.showMessageDialog(this, "Department should have at least one employee");
                return;
            } else if (!Utility.validEmployeeNubers(numOfEmployeesTxt.getText())) {
                JOptionPane.showMessageDialog(this, "Employee_Numbers should contain only numbers");
                return;
            } else {
                d.setEmployees((short) Integer.parseInt(numOfEmployeesTxt.getText()));
            }

            /*-- DEPARTMENT STATUS --*/
            d.setDepartmentStatus(status);

            try {
                dr.edit(d);
                clear();
                loadTable();
            } catch (DepartmentException e) {
                JOptionPane.showMessageDialog(null, "Something is wrong with the database connection");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Select the employee you want to edit ");
        }
    }//GEN-LAST:event_editBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        int row = departmentTbl.getSelectedRow();
        if (row == -1) {
            Department d = new Department();

            /*-- DEPARTMENT NAME --*/
            if (Utility.isEmpty(departmentNameTxt.getText())) {
                JOptionPane.showMessageDialog(this, "Department name cannot be empty");
                return;
            } else if (!Utility.validDepartmentName(departmentNameTxt.getText())) {
                JOptionPane.showMessageDialog(this, "Department name should contain only letters");
                return;
            } else if (departmentNameTxt.getText().length() <= 2) {
                JOptionPane.showMessageDialog(this, "Department name should contain at least 3 characters");
                return;
            } else if (departmentNameTxt.getText().length() >= 50) {
                JOptionPane.showMessageDialog(this, "Department name should contain at most 50 characters");
                return;
            } else {
                d.setDepartmentName(departmentNameTxt.getText());
            }

            /*-- NUMBERS OF EMPLOYEE --*/
            if (Utility.isEmpty(numOfEmployeesTxt.getText())) {
                JOptionPane.showMessageDialog(this, "Department should have at least one employee");
                return;
            } else if (!Utility.validEmployeeNubers(numOfEmployeesTxt.getText())) {
                JOptionPane.showMessageDialog(this, "Employee_Numbers should contain only numbers");
                return;
            } else {
                d.setEmployees((short) Integer.parseInt(numOfEmployeesTxt.getText()));
            }

            /*-- Department Status --*/
            d.setDepartmentStatus(status);

            try {
                dr.create(d);
                loadTable();
                clear();
            } catch (DepartmentException e) {
                JOptionPane.showMessageDialog(null, "Something is wrong with the database connection");
            }
        } else {
            JOptionPane.showMessageDialog(null, "If you want to add a new department do not select the table");
        }

    }//GEN-LAST:event_saveBtnActionPerformed

    private void departmentIdTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentIdTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_departmentIdTxtActionPerformed

    private void departmentNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentNameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_departmentNameTxtActionPerformed

    private void activeRBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activeRBtnActionPerformed
        status = true;
    }//GEN-LAST:event_activeRBtnActionPerformed

    private void inactiveRBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inactiveRBtnActionPerformed
        status = false;
    }//GEN-LAST:event_inactiveRBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DepartmentIdLbl;
    private javax.swing.JLabel DepartmentNameLbl;
    private javax.swing.JRadioButton activeRBtn;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextField departmentIdTxt;
    private javax.swing.JTextField departmentNameTxt;
    private javax.swing.JTable departmentTbl;
    private javax.swing.JButton editBtn;
    private javax.swing.ButtonGroup grupRBtn;
    private javax.swing.JRadioButton inactiveRBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField numOfEmployeesTxt;
    private javax.swing.JButton saveBtn;
    // End of variables declaration//GEN-END:variables
}
