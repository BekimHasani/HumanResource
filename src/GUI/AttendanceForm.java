/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.Attendance;
import BLL.Employee;
import BLL.JobTitle;
import BLL.Logins;
import DAL.AttendanceException;
import DAL.AttendanceInterface;
import DAL.AttendanceRepository;
import DAL.EmployeeException;
import DAL.EmployeeRepository;
import DAL.LoginsException;
import DAL.LoginsRepository;
import GUI.MainForm;
import GUI.Utility;
import MODEL.AttendanceTableModel;
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
public class AttendanceForm extends javax.swing.JInternalFrame {

    private AttendanceInterface ar = new AttendanceRepository();
    private List<Attendance> attendance = null;
    private List<Integer> integerList = null;
    private AttendanceTableModel atm = new AttendanceTableModel();
    private JobTitle jb = MainForm.getEmployee().getJobTitle();
    private LoginsRepository lr = new LoginsRepository();
    private List<Employee> employeeList = null;
    private EmployeeRepository er = new EmployeeRepository();
    /**
     * Creates new form AttendanceForm
     */
    public AttendanceForm() {
        initComponents();
        loadTable();
    }
    
   public void loadTable(){
        try{
            attendance = ar.findAll();
            atm.add(attendance);
            attendanceTbl.setModel(atm);
            atm.fireTableDataChanged();
        } catch (AttendanceException ex) {
            JOptionPane.showMessageDialog(this,"[loadTable-ERROR]: " + ex.getMessage());
        }
    }
    
    public void loadTable(String str,JobTitle jb){
        try{
            attendance = new ArrayList<Attendance>();
            if(jb.getJobTitleID() == 4){
                integerList = ar.searchAttendanceHR(str);
            }else if(jb.getJobTitleID() == 3){
                integerList = ar.searchAttendanceCEO(str);
            }else{
                integerList = ar.searchAttendanceDIR(str);
            }
            for (Integer integerList1 : integerList) {
                attendance.add((Attendance) ar.findByID(integerList1));
            }
            atm.add(attendance);
            attendanceTbl.setModel(atm);
            atm.fireTableDataChanged();
        } catch (AttendanceException ex) {
            JOptionPane.showMessageDialog(this,"[loadTable-ERROR]: " + ex.getMessage());
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        attendanceSearchTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        attendanceTbl = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Attendance Form");

        attendanceSearchTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attendanceSearchTxtActionPerformed(evt);
            }
        });
        attendanceSearchTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                attendanceSearchTxtKeyReleased(evt);
            }
        });

        jLabel2.setText("Search Attendance:");

        attendanceTbl.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(attendanceTbl);

        jButton1.setText("Generate Reports");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Generate Attendance");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(attendanceSearchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addGap(3, 3, 3)
                .addComponent(attendanceSearchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void attendanceSearchTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attendanceSearchTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_attendanceSearchTxtActionPerformed

    private void attendanceSearchTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_attendanceSearchTxtKeyReleased
        loadTable(attendanceSearchTxt.getText(),jb);
    }//GEN-LAST:event_attendanceSearchTxtKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            List<Logins> loginsList = null;
            employeeList = er.findEmployees();
            for(int i = 0 ; i < employeeList.size();i++){
               loginsList = lr.getTodayLogins(employeeList.get(i).getEmployeeID());
               short time = 0;
               for (int j = 0; j < loginsList.size(); j++) {
                   time += loginsList.get(i).getLoginedTime().getHours() * 60 + loginsList.get(i).getLoginedTime().getMinutes();
               }
               Attendance at = new Attendance();
               at.setEmployee(employeeList.get(i));
               at.setLogins(loginsList.get(loginsList.size()-1));
               at.setAttendanceDate(Utility.toDate(LocalDate.now()));
               at.setRequiredHours((short)420);
               at.setAttendedTime(time);
               at.setAbssenceTime((short)(420 - time));
                if (time - 420 > 0) {
                    at.setOvertimeD((short)(time - 420));
                }else{
                    at.setOvertimeD((short)0);
                }
            }
        } catch (EmployeeException ex) {
            JOptionPane.showMessageDialog(this,"[EmployeeException]:GenerateAttendance->" +ex.getMessage());
        } catch (LoginsException ex) {
            JOptionPane.showMessageDialog(this,"[LoginsException]:GenerateAttendance->" +ex.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Utility.writeToExcell(attendanceTbl,"C:/Users/Armend/Desktop/projektiLab/nes/test/raportet/EmployeeAttendance"+LocalDate.now()+".xls");
        } catch (IOException ex) {
            Logger.getLogger(EmployeeLeavesForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField attendanceSearchTxt;
    private javax.swing.JTable attendanceTbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
