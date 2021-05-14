/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.EmployeeLeaves;
import BLL.LeaveTypes;
import BLL.Request;
import BLL.RequestStatus;
import DAL.EmployeeLeavesException;
import DAL.EmployeeLeavesInterface;
import DAL.EmployeeLeavesRepository;
import DAL.LeaveTypesException;
import DAL.LeaveTypesInterface;
import DAL.LeaveTypesRepository;
import DAL.RequestException;
import DAL.RequestInterface;
import DAL.RequestRepository;
import DAL.RequestStatusException;
import DAL.RequestStatusInterface;
import DAL.RequestStatusRepository;
import MODEL.RequestTableModel;
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
 * @author Armend
 */
public class HrApprovementForm extends javax.swing.JInternalFrame {

    EmployeeLeavesInterface elr = new EmployeeLeavesRepository();
    LeaveTypesInterface ltr = new LeaveTypesRepository();
    RequestTableModel rtm = new RequestTableModel();
    RequestInterface rr = new RequestRepository();
    RequestStatusInterface rsr = new RequestStatusRepository();
    private List<EmployeeLeaves> employeeLeaves = null;
    private List<LeaveTypes> leaves = null;
    
    
    public HrApprovementForm() {
        initComponents();
        loadTable();
        tabelaSelectedIndexChange();
    }

    public void loadTable(){
        List<Request> list;
        try{
            leaves = ltr.findAll();
            list = rr.getPendingHr();
            if(list == null){
                JOptionPane.showMessageDialog(this,"[loadTable]: There is no request pending");
            }else{
                rtm.add(list);
                tabela.setModel(rtm);
                rtm.fireTableDataChanged();
            }
        } catch (RequestException ex) {
            JOptionPane.showMessageDialog(null,"[loadTable]:" + ex.getMessage());
        } catch (LeaveTypesException ex) {
            JOptionPane.showMessageDialog(null,"[loadTable]:" + ex.getMessage());
        }
    }
    
    public void tabelaSelectedIndexChange() {
        final ListSelectionModel rowSM = tabela.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Request r = rtm.getRequest(selectedIndex);
                    requestIDTxt.setText(r.getRequestID() + "");
                    employeeTxt.setText(r.getEmployee() + "");
                    daysRequestedTxt.setText(r.getRequestDays() + "");
                    startDateTxt.setText(sdf.format(r.getStartDate()) + "");
                    endDateTxt.setText(sdf.format(r.getEndDate()) + "");
                    requestedDateTxt.setText(sdf.format(r.getRequestDate()) + "");
                    requestDescriptionTxtArea.setText(r.getRequestDescription());
                    leaveTypeTxt.setText(r.getLeave() + "");
                    try {
                        employeeLeaves = elr.findByLeave(r.getLeave().getLeaveID());
                    } catch (EmployeeLeavesException ex) {
                        JOptionPane.showMessageDialog(null,"[tabelaSelectedIndexChange-ERROR]:" + ex.getMessage());
                    }
                    short daysleft = 0;
                    for(int i = 0; i < leaves.size(); i++){
                        if(r.getLeave().getLeaveID() == leaves.get(i).getLeaveID()){
                            daysleft = (short)(leaves.get(i).getLeaveDays() - calculate(employeeLeaves));
                            i = leaves.size();
                        }
                    }
                    daysLeftTxt.setText(daysleft + "");
                }
            }
        });
    }
    
    private static short calculate(List<EmployeeLeaves> list){
        short days = 0;
        for (int i = 0; i < list.size(); i++) {
            
            days += list.get(i).getLeaveDays();
        }
        return days;
    }
    
    public void clear(){
        leaveTypeTxt.setText("");
        employeeTxt.setText("");
        daysRequestedTxt.setText("");
        startDateTxt.setText("");
        endDateTxt.setText("");
        requestedDateTxt.setText("");
        requestDescriptionTxtArea.setText("");
        daysLeftTxt.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        employeeTxt = new javax.swing.JTextField();
        startDateTxt = new javax.swing.JTextField();
        leaveTypeTxt = new javax.swing.JTextField();
        endDateTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        daysRequestedTxt = new javax.swing.JTextField();
        requestedDateTxt = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        requestDescriptionTxtArea = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        daysLeftTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        requestIDTxt = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        approveBtn = new javax.swing.JButton();
        denyBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();

        setClosable(true);

        jLabel1.setText("Employee:");

        jLabel2.setText("Leave type:");

        jLabel3.setText("Start date:");

        employeeTxt.setEditable(false);

        startDateTxt.setEditable(false);

        leaveTypeTxt.setEditable(false);

        endDateTxt.setEditable(false);

        jLabel4.setText("End date:");

        jLabel5.setText("Requested days:");

        jLabel6.setText("Requested date:");

        daysRequestedTxt.setEditable(false);

        requestedDateTxt.setEditable(false);

        requestDescriptionTxtArea.setEditable(false);
        requestDescriptionTxtArea.setColumns(20);
        requestDescriptionTxtArea.setRows(5);
        jScrollPane2.setViewportView(requestDescriptionTxtArea);

        jLabel7.setText("Request description :");

        daysLeftTxt.setEditable(false);

        jLabel8.setText("Days left:");

        jLabel9.setText("Request ID:");

        requestIDTxt.setEditable(false);

        approveBtn.setText("Approve");
        approveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveBtnActionPerformed(evt);
            }
        });

        denyBtn.setText("Deny");
        denyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                denyBtnActionPerformed(evt);
            }
        });

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(approveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(denyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(denyBtn)
                    .addComponent(approveBtn)
                    .addComponent(cancelBtn))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(231, 231, 231)
                        .addComponent(jLabel3)
                        .addGap(227, 227, 227)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(requestIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)
                        .addComponent(startDateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(daysRequestedTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(239, 239, 239)
                        .addComponent(jLabel4)
                        .addGap(233, 233, 233)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(employeeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)
                        .addComponent(endDateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(daysLeftTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(231, 231, 231)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(leaveTypeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)
                        .addComponent(requestedDateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel9))
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(requestIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(startDateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(daysRequestedTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(employeeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endDateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(daysLeftTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(leaveTypeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(requestedDateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jLabel7)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tabela.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tabela);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setText("Human Resource Approvement");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void approveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveBtnActionPerformed
        int row = tabela.getSelectedRow();
        if(row != -1){
                try {
                    List<RequestStatus> list = rsr.findAll();
                    Request r = rtm.getRequest(row);
                    r.setRequestStatus((RequestStatus) list.get(2));
                    r.setApprovedDate(new Date());
                    
                    EmployeeLeaves el = new EmployeeLeaves();
                    el.setEmployee(r.getEmployee());
                    el.setEmployeeLeavesStatus(true);
                    el.setEndDate(r.getEndDate());
                    el.setStartDate(r.getStartDate());
                    el.setLeave(r.getLeave());
                    el.setLeaveDays(r.getRequestDays());
                    
                    elr.create(el);
                    rr.edit(r);
                    clear();
                    loadTable();
                } catch (RequestStatusException ex) {
                    JOptionPane.showMessageDialog(this,"[RequestStatusException]: " + ex.getMessage());
                } catch (RequestException ex) {
                    JOptionPane.showMessageDialog(this,"[RequestException]: " + ex.getMessage());
                } catch (EmployeeLeavesException ex) {
                    JOptionPane.showMessageDialog(this,"[EmployeeLeavesException]: " + ex.getMessage());
                }
        }else{
            JOptionPane.showMessageDialog(this,"[ERROR]: Please select the request");
        }
    }//GEN-LAST:event_approveBtnActionPerformed

    private void denyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_denyBtnActionPerformed
       int row = tabela.getSelectedRow();
        if(row != -1){
                try {
                    List<RequestStatus> list = rsr.findAll();
                    Request r = rtm.getRequest(row);
                    r.setRequestStatus((RequestStatus) list.get(3));
                    rr.edit(r);
                    clear();
                    loadTable();
                } catch (RequestStatusException ex) {
                    JOptionPane.showMessageDialog(this,"[RequestStatusException]: " + ex.getMessage());
                } catch (RequestException ex) {
                    JOptionPane.showMessageDialog(this,"[RequestException]: " + ex.getMessage());
                }
        }else{
            JOptionPane.showMessageDialog(this,"[ERROR]: Please select the request");
        }
    }//GEN-LAST:event_denyBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        clear();
    }//GEN-LAST:event_cancelBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton approveBtn;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JTextField daysLeftTxt;
    private javax.swing.JTextField daysRequestedTxt;
    private javax.swing.JButton denyBtn;
    private javax.swing.JTextField employeeTxt;
    private javax.swing.JTextField endDateTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField leaveTypeTxt;
    private javax.swing.JTextArea requestDescriptionTxtArea;
    private javax.swing.JTextField requestIDTxt;
    private javax.swing.JTextField requestedDateTxt;
    private javax.swing.JTextField startDateTxt;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
