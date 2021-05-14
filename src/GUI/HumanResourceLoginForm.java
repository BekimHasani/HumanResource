/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.Employee;
import BLL.HumanResourceLogin;
import DAL.EmployeeException;
import DAL.EmployeeInterface;
import DAL.EmployeeRepository;
import DAL.HumanResourceLoginException;
import DAL.HumanResourceLoginInterface;
import DAL.HumanResourceLoginRepository;
import MODEL.EmployeeComboBoxModel;
import MODEL.HumanResourceLoginTableModel;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author AriotY
 */
public class HumanResourceLoginForm extends javax.swing.JInternalFrame {

    HumanResourceLoginInterface hrlr = new HumanResourceLoginRepository();
    HumanResourceLoginTableModel hrltm = new HumanResourceLoginTableModel();
    EmployeeComboBoxModel ecmb = new EmployeeComboBoxModel();
    EmployeeInterface er = new EmployeeRepository();

    
    
    public HumanResourceLoginForm() {
        initComponents();
        tableLoad();
        tabelaSelectedIndexChange();  
        loadEmployeeComboBox();
    }

    public void tableLoad() {

        try {
            List<HumanResourceLogin> list = hrlr.findAll();
            hrltm = new HumanResourceLoginTableModel(list);
            table.setModel(hrltm);
            hrltm.fireTableDataChanged();
           tabelaSelectedIndexChange();
        } catch (HumanResourceLoginException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

    }
    public void loadEmployeeComboBox() {
        try {
            List<Employee> lista = er.findAll();
            ecmb.add(lista);
            hrLoginEmployeeCmb.setModel(ecmb);
            hrLoginEmployeeCmb.repaint();
        } catch (EmployeeException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    public void clear() {
        table.clearSelection();
        hrLoginIDTxt.setText("");
        hrLoginUsernameTxt.setText("");
        hrLoginPasswordTxt.setText("");

    }

    public void tabelaSelectedIndexChange() {
        final ListSelectionModel rowSM = table.getSelectionModel();

        rowSM.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel rowSM = (ListSelectionModel) e.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    HumanResourceLogin hrl = hrltm.getHumanResourceLogin(selectedIndex);
                    hrLoginUsernameTxt.setText(hrl.getLoginUsername());
                    hrLoginPasswordTxt.setText("");
                    hrLoginEmployeeCmb.setSelectedItem(hrl.getEmployee());
                    
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        hrLoginIDLbl = new javax.swing.JLabel();
        hrLoginUsernameLbl = new javax.swing.JLabel();
        hrLoginPasswordLbl = new javax.swing.JLabel();
        hrLoginEmployeeLbl = new javax.swing.JLabel();
        hrLoginIDTxt = new javax.swing.JTextField();
        hrLoginUsernameTxt = new javax.swing.JTextField();
        hrLoginPasswordTxt = new javax.swing.JTextField();
        saveBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        hrLoginEmployeeCmb = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();

        hrLoginIDLbl.setText("Human Resouce ID :");

        hrLoginUsernameLbl.setText("* Username :");

        hrLoginPasswordLbl.setText("* Password :");

        hrLoginEmployeeLbl.setText("Employee");

        hrLoginIDTxt.setEditable(false);
        hrLoginIDTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hrLoginIDTxtActionPerformed(evt);
            }
        });

        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("HumanResouceLoginForm");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(hrLoginEmployeeLbl)
                            .addComponent(hrLoginEmployeeCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(hrLoginIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hrLoginIDLbl))
                                .addGap(62, 62, 62)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(hrLoginUsernameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hrLoginUsernameLbl))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(hrLoginPasswordLbl)
                                    .addComponent(hrLoginPasswordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(35, 35, 35))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hrLoginPasswordLbl)
                    .addComponent(hrLoginUsernameLbl)
                    .addComponent(hrLoginIDLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hrLoginIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hrLoginUsernameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hrLoginPasswordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(hrLoginEmployeeLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hrLoginEmployeeCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveBtn)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cancelBtn)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hrLoginIDTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hrLoginIDTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hrLoginIDTxtActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
       int row = table.getSelectedRow();
       if(row == -1){
           HumanResourceLogin hr = new HumanResourceLogin();
           if(hrLoginUsernameTxt.getText().isEmpty()){
              JOptionPane.showMessageDialog(null, "Username cannot be empty");
              return;
           }else if(hrLoginUsernameTxt.getText().length() < 3){
               JOptionPane.showMessageDialog(null,"Username cannot be less than 3 letters long");
               return;
           }else if(hrLoginUsernameTxt.getText().length() > 20){
               JOptionPane.showMessageDialog(null,"Username cannot be more than 20 letters long");
               return;
           }
           else{
                hr.setLoginUsername(hrLoginUsernameTxt.getText());
           }
           if(hrLoginPasswordTxt.getText().isEmpty()){
               JOptionPane.showMessageDialog(null,"Password cannot be empty");
               return;
           }else if(hrLoginPasswordTxt.getText().length() < 3){
               JOptionPane.showMessageDialog(null,"Password cannot be less than 3 letters long");
               return;
           }else if(hrLoginPasswordTxt.getText().length() > 20){
               JOptionPane.showMessageDialog(null,"Password cannot be more than 20 letters long");
               return;
           }
           else{
                hr.setLoginPassword(Utility.getMD5(hrLoginPasswordTxt.getText()));
           }
           hr.setEmployee((Employee) hrLoginEmployeeCmb.getSelectedItem());
           
           try {
               hrlr.create(hr);
               clear();
               tableLoad();
           } catch (Exception e) {
               JOptionPane.showMessageDialog(null, "Something is wrong with the database connection");
           }
       
       }else{
           JOptionPane.showMessageDialog(null, "If u want to create a new login dont select the table");
       }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
       int row = table.getSelectedRow();
       if(row != -1){
           HumanResourceLogin hr = new HumanResourceLogin();
           
           if(hrLoginUsernameTxt.getText().length() < 3){
               JOptionPane.showMessageDialog(null,"Username cannot be less than 3 letters long");
               return;
           }else if(hrLoginUsernameTxt.getText().length() > 20){
               JOptionPane.showMessageDialog(null,"Username cannot be more than 20 letters long");
               return;
           }
           else{
                hr.setLoginUsername(hrLoginUsernameTxt.getText());
           }
            if(hrLoginPasswordTxt.getText().length() < 3){
               JOptionPane.showMessageDialog(null,"Password cannot be less than 3 letters long");
               return;
           }else if(hrLoginPasswordTxt.getText().length() > 20){
               JOptionPane.showMessageDialog(null,"Password cannot be more than 20 letters long");
               return;
           }
           else{
                hr.setLoginPassword(Utility.getMD5(hrLoginPasswordTxt.getText()));
           }
           hr.setEmployee((Employee) hrLoginEmployeeCmb.getSelectedItem());
           
           try {
               hrlr.edit(hr);
               clear();
               tableLoad();
           } catch (Exception e) {
               JOptionPane.showMessageDialog(null, "Something is wrong with the database connection");
           }
       
       }else{
           JOptionPane.showMessageDialog(null, "If u want to create a new login dont select the table");
       }
    }//GEN-LAST:event_editBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
      int row = table.getSelectedRow();
        if (row != -1) {
            Object[] obj = {"YES", "NO"};
            int i = JOptionPane.showOptionDialog(this, "Do you want to delete this record?", "Deletion",
                    JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, obj, obj[1]);
            if (i == 0) {
                HumanResourceLogin hrl = hrltm.getHumanResourceLogin(row);
                try {
                    hrlr.delete(hrl);
                    clear();
                    tableLoad();
                } catch (HumanResourceLoginException e) {
                    JOptionPane.showMessageDialog(null, "Gabim diqka");
                }

            }
        } else {
            JOptionPane.showMessageDialog(null, "Selektoni statusin te cilin deshironi ta fshini.");
        }

    }//GEN-LAST:event_deleteBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JComboBox hrLoginEmployeeCmb;
    private javax.swing.JLabel hrLoginEmployeeLbl;
    private javax.swing.JLabel hrLoginIDLbl;
    private javax.swing.JTextField hrLoginIDTxt;
    private javax.swing.JLabel hrLoginPasswordLbl;
    private javax.swing.JTextField hrLoginPasswordTxt;
    private javax.swing.JLabel hrLoginUsernameLbl;
    private javax.swing.JTextField hrLoginUsernameTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}