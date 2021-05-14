
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.Request;
import BLL.RequestStatus;
import DAL.RequestException;
import DAL.RequestRepository;
import DAL.RequestStatusException;
import DAL.RequestStatusRepository;
import MODEL.ApprovementTableModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Bekim
 */
public class ApprovementForm extends javax.swing.JInternalFrame {

    RequestStatusRepository rsr = new RequestStatusRepository();
    RequestRepository rr = new RequestRepository();
    ApprovementTableModel rtm = new ApprovementTableModel();

    public ApprovementForm() {
        initComponents();
        loadTable();
        tableSelectedIndexChanged();
    }

    public void loadTable() {
        try {
            rtm.add(rr.getPendingDirector());
            pendingReqTbl.setModel(rtm);
            rtm.fireTableDataChanged();
        } catch (RequestException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void clear() {
        employeeNameTxt.setText("");
        employeeIdTxt.setText("");
        leaveTypeTxt.setText("");
        startDateTxt.setText("");
        endDateTxt.setText("");
        daysTxt.setText("");
        requestDateTxt.setText("");
        requestDesTxtArea.setText("");
    }

    private void tableSelectedIndexChanged() {
        final ListSelectionModel rowSM = pendingReqTbl.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    Request rq = rtm.getRequest(selectedIndex);
                    employeeNameTxt.setText(rq.getEmployee().getEmployeeName());
                    employeeIdTxt.setText(rq.getEmployee().getEmployeeID() + "");
                    leaveTypeTxt.setText(rq.getLeave().getLeaveDescription());
                    startDateTxt.setText(rq.getStartDate() + "");
                    endDateTxt.setText(rq.getEndDate() + "");
                    requestDateTxt.setText(rq.getRequestDate() + "");
                    daysTxt.setText(rq.getLeave().getLeaveDays() + "");
                    requestDesTxtArea.setText(rq.getRequestStatus().getRequestStatusDescription());
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        requestDesTxtArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        deniedBtn = new javax.swing.JButton();
        approveBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pendingReqTbl = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        employeeNameTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        employeeIdTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        leaveTypeTxt = new javax.swing.JTextField();
        daysTxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        requestDateTxt = new javax.swing.JTextField();
        startDateTxt = new javax.swing.JTextField();
        endDateTxt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        checkBtn = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        requestDesTxtArea.setEditable(false);
        requestDesTxtArea.setColumns(20);
        requestDesTxtArea.setRows(5);
        jScrollPane2.setViewportView(requestDesTxtArea);

        jLabel2.setText("Request Description :");

        deniedBtn.setText("Deny");
        deniedBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deniedBtnActionPerformed(evt);
            }
        });

        approveBtn.setText("Approve");
        approveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveBtnActionPerformed(evt);
            }
        });

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(316, Short.MAX_VALUE)
                .addComponent(approveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(deniedBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(approveBtn)
                    .addComponent(cancelBtn)
                    .addComponent(deniedBtn))
                .addGap(13, 13, 13))
        );

        pendingReqTbl.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(pendingReqTbl);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Pending Requests List");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 153, 153));
        jLabel11.setText("Approvement Form");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel11)
                .addGap(11, 11, 11)
                .addComponent(jLabel10)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel3.setText("Employee Name :");

        employeeNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeNameTxtActionPerformed(evt);
            }
        });

        jLabel4.setText("Employee ID :");

        jLabel5.setText("Days :");

        jLabel6.setText("Leave Type :");

        jLabel8.setText("End Date :");

        leaveTypeTxt.setEditable(false);

        daysTxt.setEditable(false);

        jLabel9.setText("Start Date :");

        jLabel7.setText("Request Date :");

        requestDateTxt.setEditable(false);
        requestDateTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestDateTxtActionPerformed(evt);
            }
        });

        startDateTxt.setEditable(false);
        startDateTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startDateTxtActionPerformed(evt);
            }
        });

        endDateTxt.setEditable(false);
        endDateTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endDateTxtActionPerformed(evt);
            }
        });

        jLabel12.setText("Check for Trainigns :");

        checkBtn.setText("Check");
        checkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(203, 203, 203)
                        .addComponent(jLabel6)
                        .addGap(67, 67, 67)
                        .addComponent(jLabel5)
                        .addGap(89, 89, 89)
                        .addComponent(jLabel7))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(employeeIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107)
                        .addComponent(leaveTypeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(daysTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(requestDateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(187, 187, 187)
                        .addComponent(jLabel9)
                        .addGap(73, 73, 73)
                        .addComponent(jLabel8)
                        .addGap(69, 69, 69)
                        .addComponent(jLabel12))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(employeeNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107)
                        .addComponent(startDateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(endDateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(checkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(employeeIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leaveTypeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(daysTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(requestDateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(employeeNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startDateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endDateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void employeeNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeNameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeNameTxtActionPerformed

    private void approveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveBtnActionPerformed
        int row = pendingReqTbl.getSelectedRow();
        if (row != -1) {
            Object[] obj = {"Yes", "No"};
            int i = JOptionPane.showOptionDialog(this, "Confirm your decision ", "DECISION",
                    JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, obj, obj[1]);
            if (i == 0) {
                Request r = rtm.getRequest(row);
                List<RequestStatus> rsList;
                try {
                    rsList = rsr.findAll();
                    Date date = new Date();
                    SimpleDateFormat fr = new SimpleDateFormat("yyyy-MM-dd");
                    r.setApprovedDate(fr.parse(fr.format(date)));
                    r.setRequestStatus((RequestStatus) rsList.get(1));
                } catch (RequestStatusException | ParseException ex) {
                    Logger.getLogger(ApprovementForm.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    rr.edit(r);
                    clear();
                    loadTable();
                } catch (RequestException ex) {
                    JOptionPane.showMessageDialog(null, "Something is wrong with the database connection");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select application you want to approve");
        }
    }//GEN-LAST:event_approveBtnActionPerformed

    private void deniedBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deniedBtnActionPerformed
        int row = pendingReqTbl.getSelectedRow();
        if (row != -1) {
            Object[] obj = {"Yes", "No"};
            int i = JOptionPane.showOptionDialog(this, "Confirm your decision", "DECISION",
                    JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, obj, obj[1]);
            if (i == 0) {
                try {
                    List<RequestStatus> rsList;
                    rsList = rsr.findAll();
                    Request r = rtm.getRequest(row);
                    r.setRequestStatus((RequestStatus) rsList.get(3));
                    SimpleDateFormat fr = new SimpleDateFormat("yyyy-MM-dd");
                    r.setApprovedDate(fr.parse(fr.format(new Date())));
                    try {
                        rr.edit(r);
                        clear();
                        loadTable();
                    } catch (RequestException ex) {
                        JOptionPane.showMessageDialog(null, "Something is wrong with the database connection");
                    }
                } catch (RequestStatusException ex) {
                    JOptionPane.showMessageDialog(null, "[RequestStatusException-ERROR]: " + ex.getMessage());
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "[ParseException-ERROR]: " + ex.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select application you want to approve");
        }
    }//GEN-LAST:event_deniedBtnActionPerformed

    private void requestDateTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestDateTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_requestDateTxtActionPerformed

    private void endDateTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endDateTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_endDateTxtActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        clear();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void startDateTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startDateTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startDateTxtActionPerformed

    private void checkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBtnActionPerformed
        int row = pendingReqTbl.getSelectedRow();
        if (row != -1) {
            Request r = rtm.getRequest(row);
            TrainingCheckForm tcf = new TrainingCheckForm(r.getEmployee(), r.getStartDate(), r.getEndDate());
            tcf.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Plese select request if you want to know training detail ");
        }

    }//GEN-LAST:event_checkBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton approveBtn;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton checkBtn;
    private javax.swing.JTextField daysTxt;
    private javax.swing.JButton deniedBtn;
    private javax.swing.JTextField employeeIdTxt;
    private javax.swing.JTextField employeeNameTxt;
    private javax.swing.JTextField endDateTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField leaveTypeTxt;
    private javax.swing.JTable pendingReqTbl;
    private javax.swing.JTextField requestDateTxt;
    private javax.swing.JTextArea requestDesTxtArea;
    private javax.swing.JTextField startDateTxt;
    // End of variables declaration//GEN-END:variables
}
