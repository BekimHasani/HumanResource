/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.JobTitle;
import BLL.Logins;
import DAL.LoginsException;
import DAL.LoginsInterface;
import DAL.LoginsRepository;
import MODEL.LoginsTableModel;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Bekim
 */
public class LoginsForm extends javax.swing.JInternalFrame {

    private LoginsTableModel ltm = new LoginsTableModel();
    private LoginsInterface lr = new LoginsRepository();
    private List<Logins> logins;
    private List<Integer> integerList = new ArrayList<Integer>();
    private JobTitle jb = MainForm.getEmployee().getJobTitle();
    /**
     * Creates new form LoginForms
     */
    public LoginsForm() {
        initComponents();
        loadTable();
    }
    
    public void loadTable(){
        try{
            logins = lr.findAll();
            ltm.add(logins);
            loginsTbl.setModel(ltm);
            ltm.fireTableDataChanged();
        }catch(LoginsException e){
            JOptionPane.showMessageDialog(this,"[LoginsForm-ERROR]->loadTable: "+ e.getMessage());
        }
    }
    
    public void loadTable(String str,JobTitle jb){
        try{
            logins.clear();
            if(jb.getJobTitleID() ==  4){
                integerList = lr.searchEmployeeLoginsHR(str);
            }else if(jb.getJobTitleID() == 3){
                integerList = lr.searchEmployeeLoginsCEO(str);
            }else{
                 integerList = lr.searchEmployeeLoginsDIR(str);   
            }
            for (int i = 0; i < integerList.size(); i++) {
                logins.add(lr.findById(integerList.get(i)));
            }
            ltm.add(logins);
            loginsTbl.setModel(ltm);
            ltm.fireTableDataChanged();
        }catch(LoginsException  e){
            JOptionPane.showMessageDialog(this,"[LoginsForm-ERROR]->loadTable: "+ e.getMessage());
        }
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
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        loginsTbl = new javax.swing.JTable();
        searchLoginsTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setClosable(true);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Logins");

        loginsTbl.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(loginsTbl);

        searchLoginsTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchLoginsTxtKeyReleased(evt);
            }
        });

        jLabel1.setText("Search Logins:");

        jButton1.setText("Generate Reports");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 914, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(searchLoginsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 24, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchLoginsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(16, 16, 16))
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

    private void searchLoginsTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchLoginsTxtKeyReleased
        try {
            Utility.writeToExcell(loginsTbl,"C:/Users/Armend/Desktop/projektiLab/nes/test/raportet/EmployeeLogins"+LocalDate.now()+".xls");
        } catch (IOException ex) {
            Logger.getLogger(EmployeeLeavesForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchLoginsTxtKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable loginsTbl;
    private javax.swing.JTextField searchLoginsTxt;
    // End of variables declaration//GEN-END:variables
}