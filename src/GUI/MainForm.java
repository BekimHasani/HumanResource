/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.Employee;
import BLL.EmployeeLeaves;
import BLL.Logins;
import DAL.EmployeeLeavesException;
import DAL.EmployeeLeavesInterface;
import DAL.EmployeeLeavesRepository;
import DAL.HumanResourceLoginException;
import DAL.LoginsException;
import DAL.LoginsInterface;
import DAL.LoginsRepository;
import GUI.ApprovementForm;
import GUI.CertifiableForm;
import GUI.DepartmentForm;
import GUI.EmployeeDepHistoryForm;
import GUI.EmployeeForm;
import GUI.EmployeeLeavesForm;
import GUI.EmployeeStatusForm;
import GUI.EmployeeTrainingInsertForm;
import GUI.EmployeeTrainingsForm;
import GUI.HrApprovementForm;
import GUI.HumanResourceLoginForm;
import GUI.JobTitleForm;
import GUI.LeaveTypesForm;
import GUI.LoginsForm;
import GUI.RequestForm;
import GUI.RequestStatusForm;
import GUI.TrainingStatusForm;
import GUI.TrainingTypesForm;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Armend
 */
public class MainForm extends javax.swing.JFrame {

    private EmployeeLeavesInterface elr = new EmployeeLeavesRepository();
    private LoginsInterface lr = new LoginsRepository();
    private static Employee on = null;
    private Time loginedTime;
    private RequestForm rf;
    private JobTitleForm jtf;
    private DepartmentForm df;
    private EmployeeStatusForm esf;
    private LeaveTypesForm ltf;
    private ApprovementForm af;
    private RequestStatusForm rsf;
    private EmployeeForm ef;
    private CertifiableForm cf;
    private TrainingStatusForm tsf;
    private TrainingTypesForm ttf;
    private EmployeeDepHistoryForm edhf;
    private HumanResourceLoginForm hrlf;
    private HrApprovementForm hraf;
    private EmployeeTrainingInsertForm etif;
    private EmployeeTrainingsForm etf;
    private EmployeeLeavesForm elf ;
    private LoginsForm lf;
    private AttendanceForm atf;


    /**
     * Creates new form FormaMain
     */
    private MainForm() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public MainForm(Employee e,Time t) throws HumanResourceLoginException {
        checkLeaves();
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        JobTitleMenuBar.setVisible(false);
        StatusMenu.setVisible(false);
        if (e.getJobTitle().getJobTitleDescription().toLowerCase().contains("director")) {
            JobTitleMenuBar.setVisible(false);
            EmployeeMenuBar.setVisible(false);
            LeaveMenuBar.setVisible(false);
            HrApprovementMenuBar.setVisible(false);
            TrainingMenuBar.setVisible(false);
            DepartmentMenuBar.setVisible(false);
            NewUserMenuBar.setVisible(false);
        }else if (e.getJobTitle().getJobTitleDescription().toLowerCase().contains("ceo")) {
            EmployeeMenuBar.setVisible(false);
            LeaveMenuBar.setVisible(false);
            HrApprovementMenuBar.setVisible(false);
            EmployeeTrainingsMenuBar.setVisible(false);
            DepartmentMenuBar.setVisible(false);
            NewUserMenuBar.setVisible(false);
        }else if (e.getJobTitle().getJobTitleDescription().toLowerCase().contains("hr")) {
            TrainingMenuBar.setVisible(false);
            ApproveMenuBar.setVisible(false);
            EmployeeTrainingsMenuBar.setVisible(false);
        } else {
            NewUserMenuBar.setVisible(false);
            DepartmentMenuBar.setVisible(false);
            EmployeeTrainingsMenuBar.setVisible(false);
            TrainingMenuBar.setVisible(false);
            EmployeeMenuBar.setVisible(false);
            ApprovementMenu.setVisible(false);
            LeaveMenuBar.setVisible(false);
            SearchAndReportsMenu.setVisible(false);
        }
        on = e;
        loginedTime = t;
    }

    private void closeAll() {
        if (lf != null) {
            if (lf.isVisible()) {
                lf.setVisible(false);
                lf = null;
            }
        }
        if (ttf != null) {
            if (ttf.isVisible()) {
                ttf.setVisible(false);
                ttf = null;
            }
        }
        if (elf != null) {
            if (elf.isVisible()) {
                elf.setVisible(false);
                elf = null;
            }
        }
        if (rf != null) {
            if (rf.isVisible()) {
                rf.setVisible(false);
                rf = null;
            }
        }
        if (jtf != null) {
            if (jtf.isVisible()) {
                jtf.setVisible(false);
                jtf = null;
            }
        }
        if (df != null) {
            if (df.isVisible()) {
                df.setVisible(false);
                df = null;
            }
        }
        if (esf != null) {
            if (esf.isVisible()) {
                esf.setVisible(false);
                esf = null;
            }
        }
        if (ltf != null) {
            if (ltf.isVisible()) {
                ltf.setVisible(false);
                ltf = null;
            }
        }
        if (af != null) {
            if (af.isVisible()) {
                af.setVisible(false);
                af = null;
            }
        }
        if (rsf != null) {
            if (rsf.isVisible()) {
                rsf.setVisible(false);
                rsf = null;
            }
        }
        if (ef != null) {
            if (ef.isVisible()) {
                ef.setVisible(false);
                ef = null;
            }
        }
        if (cf != null) {
            if (cf.isVisible()) {
                cf.setVisible(false);
                cf = null;
            }
        }
        if (tsf != null) {
            if (tsf.isVisible()) {
                tsf.setVisible(false);
                tsf = null;
            }
        }
        if (edhf != null) {
            if (edhf.isVisible()) {
                edhf.setVisible(false);
                edhf = null;
            }
        }
        if (hrlf != null) {
            if (hrlf.isVisible()) {
                hrlf.setVisible(false);
                hrlf = null;
            }
        }

        if (hraf != null) {
            if (hraf.isVisible()) {
                hraf.setVisible(false);
                hraf = null;
            }
        }
        if (etf != null) {
            if (etf.isVisible()) {
                etf.setVisible(false);
                etf = null;
            }
        }
        if (etif != null) {
            if (etif.isVisible()) {
                etif.setVisible(false);
                etif = null;
            }
        }
        if (atf != null) {
            if (atf.isVisible()) {
                atf.setVisible(false);
                atf = null;
            }
        }
        
    }

    public static Employee getEmployee() {
        return on;
    }

    private void checkLeaves() {
        try {
            List<EmployeeLeaves> leaves;
            leaves = elr.findActive();
            if (LocalDate.now().getMonth().getValue() == 1 && LocalDate.now().getDayOfMonth() == 1) {
                for (int i = 0; i < leaves.size(); i++) {
                    leaves.get(i).setEmployeeLeavesStatus(false);
                }
            }
        } catch (EmployeeLeavesException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
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

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenu10 = new javax.swing.JMenu();
        jMenu11 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuBar5 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        desktopPane = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        EmployeeMenu = new javax.swing.JMenu();
        EmployeeMenuBar = new javax.swing.JMenuItem();
        JobTitleMenuBar = new javax.swing.JMenuItem();
        DepartmentMenuBar = new javax.swing.JMenuItem();
        NewUserMenuBar = new javax.swing.JMenuItem();
        LogoutMenuBar = new javax.swing.JMenuItem();
        LeaveMenu = new javax.swing.JMenu();
        LeaveMenuBar = new javax.swing.JMenuItem();
        RequestMenuBar = new javax.swing.JMenuItem();
        TrainingsMenu = new javax.swing.JMenu();
        TrainingMenuBar = new javax.swing.JMenuItem();
        AddEmployeeTrainingsMenuBar = new javax.swing.JMenuItem();
        ApprovementMenu = new javax.swing.JMenu();
        ApproveMenuBar = new javax.swing.JMenuItem();
        HrApprovementMenuBar = new javax.swing.JMenuItem();
        SearchAndReportsMenu = new javax.swing.JMenu();
        EmployeeDepartmentHistoryMenuBar = new javax.swing.JMenuItem();
        EmployeeTrainingsMenuBar = new javax.swing.JMenuItem();
        EmployeeLeavesMenuBar = new javax.swing.JMenuItem();
        EmployeeLoginsMenuBar = new javax.swing.JMenuItem();
        AttendanceMenuBar = new javax.swing.JMenuItem();
        StatusMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenuItem3.setText("jMenuItem3");

        jMenuItem5.setText("jMenuItem5");

        jMenu6.setText("File");
        jMenuBar3.add(jMenu6);

        jMenu7.setText("Edit");
        jMenuBar3.add(jMenu7);

        jMenu9.setText("jMenu9");

        jMenu10.setText("File");
        jMenuBar4.add(jMenu10);

        jMenu11.setText("Edit");
        jMenuBar4.add(jMenu11);

        jMenuItem8.setText("jMenuItem8");

        jMenu5.setText("File");
        jMenuBar5.add(jMenu5);

        jMenu8.setText("Edit");
        jMenuBar5.add(jMenu8);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        desktopPane.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/hr copy.png"))); // NOI18N

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, desktopPaneLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 2468, Short.MAX_VALUE)
                .addContainerGap())
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, desktopPaneLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        desktopPane.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        menuBar.setBorder(null);
        menuBar.setPreferredSize(new java.awt.Dimension(391, 40));

        EmployeeMenu.setMnemonic('h');
        EmployeeMenu.setText("Employee");
        EmployeeMenu.setPreferredSize(new java.awt.Dimension(61, 30));

        EmployeeMenuBar.setMnemonic('a');
        EmployeeMenuBar.setText("Add New Employee");
        EmployeeMenuBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmployeeMenuBarActionPerformed(evt);
            }
        });
        EmployeeMenu.add(EmployeeMenuBar);

        JobTitleMenuBar.setMnemonic('c');
        JobTitleMenuBar.setText("Add Job Title");
        JobTitleMenuBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JobTitleMenuBarActionPerformed(evt);
            }
        });
        EmployeeMenu.add(JobTitleMenuBar);

        DepartmentMenuBar.setMnemonic('o');
        DepartmentMenuBar.setText("Add New Department");
        DepartmentMenuBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepartmentMenuBarActionPerformed(evt);
            }
        });
        EmployeeMenu.add(DepartmentMenuBar);

        NewUserMenuBar.setText("Add New User");
        NewUserMenuBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewUserMenuBarActionPerformed(evt);
            }
        });
        EmployeeMenu.add(NewUserMenuBar);

        LogoutMenuBar.setText("Log Out");
        LogoutMenuBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutMenuBarActionPerformed(evt);
            }
        });
        EmployeeMenu.add(LogoutMenuBar);

        menuBar.add(EmployeeMenu);

        LeaveMenu.setText("Leaves");

        LeaveMenuBar.setText("Add leave Types");
        LeaveMenuBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LeaveMenuBarActionPerformed(evt);
            }
        });
        LeaveMenu.add(LeaveMenuBar);

        RequestMenuBar.setText("Request Leave");
        RequestMenuBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RequestMenuBarActionPerformed(evt);
            }
        });
        LeaveMenu.add(RequestMenuBar);

        menuBar.add(LeaveMenu);

        TrainingsMenu.setText("Trainings");

        TrainingMenuBar.setText("Add New Training Type");
        TrainingMenuBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrainingMenuBarActionPerformed(evt);
            }
        });
        TrainingsMenu.add(TrainingMenuBar);

        AddEmployeeTrainingsMenuBar.setText("Add Employee to Training");
        AddEmployeeTrainingsMenuBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddEmployeeTrainingsMenuBarActionPerformed(evt);
            }
        });
        TrainingsMenu.add(AddEmployeeTrainingsMenuBar);

        menuBar.add(TrainingsMenu);

        ApprovementMenu.setText("Leave Approvements");

        ApproveMenuBar.setText("Approve");
        ApproveMenuBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApproveMenuBarActionPerformed(evt);
            }
        });
        ApprovementMenu.add(ApproveMenuBar);

        HrApprovementMenuBar.setText("HrApprovement");
        HrApprovementMenuBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HrApprovementMenuBarActionPerformed(evt);
            }
        });
        ApprovementMenu.add(HrApprovementMenuBar);

        menuBar.add(ApprovementMenu);

        SearchAndReportsMenu.setText("Search and Reports");

        EmployeeDepartmentHistoryMenuBar.setMnemonic('x');
        EmployeeDepartmentHistoryMenuBar.setText("Employee Department History");
        EmployeeDepartmentHistoryMenuBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmployeeDepartmentHistoryMenuBarActionPerformed(evt);
            }
        });
        SearchAndReportsMenu.add(EmployeeDepartmentHistoryMenuBar);

        EmployeeTrainingsMenuBar.setText("Employee Trainings");
        EmployeeTrainingsMenuBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmployeeTrainingsMenuBarActionPerformed(evt);
            }
        });
        SearchAndReportsMenu.add(EmployeeTrainingsMenuBar);

        EmployeeLeavesMenuBar.setText("Employee Leaves");
        EmployeeLeavesMenuBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmployeeLeavesMenuBarActionPerformed(evt);
            }
        });
        SearchAndReportsMenu.add(EmployeeLeavesMenuBar);

        EmployeeLoginsMenuBar.setText("Employee Logins");
        EmployeeLoginsMenuBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmployeeLoginsMenuBarActionPerformed(evt);
            }
        });
        SearchAndReportsMenu.add(EmployeeLoginsMenuBar);

        AttendanceMenuBar.setText("Employee Attendance");
        AttendanceMenuBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AttendanceMenuBarActionPerformed(evt);
            }
        });
        SearchAndReportsMenu.add(AttendanceMenuBar);

        menuBar.add(SearchAndReportsMenu);

        StatusMenu.setMnemonic('e');
        StatusMenu.setText("Status");

        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("EmployeeProjectStatusForm");
        cutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutMenuItemActionPerformed(evt);
            }
        });
        StatusMenu.add(cutMenuItem);

        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("EmployeeStatusForm");
        copyMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyMenuItemActionPerformed(evt);
            }
        });
        StatusMenu.add(copyMenuItem);

        jMenuItem4.setText("Certifiable");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        StatusMenu.add(jMenuItem4);

        deleteMenuItem.setMnemonic('d');
        deleteMenuItem.setText("ProjectStatusForm");
        deleteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMenuItemActionPerformed(evt);
            }
        });
        StatusMenu.add(deleteMenuItem);

        jMenuItem2.setText("RequestStatusForm");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        StatusMenu.add(jMenuItem2);

        pasteMenuItem.setMnemonic('p');
        pasteMenuItem.setText("RecruitmentStatusForm");
        pasteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteMenuItemActionPerformed(evt);
            }
        });
        StatusMenu.add(pasteMenuItem);

        jMenuItem11.setText("TrainingStatusForm");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        StatusMenu.add(jMenuItem11);

        menuBar.add(StatusMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EmployeeDepartmentHistoryMenuBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmployeeDepartmentHistoryMenuBarActionPerformed
        closeAll();
        edhf = new EmployeeDepHistoryForm();
        desktopPane.add(edhf);
        edhf.setVisible(true);
    }//GEN-LAST:event_EmployeeDepartmentHistoryMenuBarActionPerformed

    private void JobTitleMenuBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JobTitleMenuBarActionPerformed
        closeAll();
        jtf = new JobTitleForm();
        desktopPane.add(jtf);
        jtf.setVisible(true);
    }//GEN-LAST:event_JobTitleMenuBarActionPerformed

    private void DepartmentMenuBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepartmentMenuBarActionPerformed
        closeAll();
        df = new DepartmentForm();
        desktopPane.add(df);
        df.setVisible(true);
    }//GEN-LAST:event_DepartmentMenuBarActionPerformed

    private void cutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutMenuItemActionPerformed

    }//GEN-LAST:event_cutMenuItemActionPerformed

    private void pasteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasteMenuItemActionPerformed

    }//GEN-LAST:event_pasteMenuItemActionPerformed

    private void deleteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMenuItemActionPerformed

    }//GEN-LAST:event_deleteMenuItemActionPerformed

    private void copyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyMenuItemActionPerformed
        closeAll();
        esf = new EmployeeStatusForm();
        desktopPane.add(esf);
        esf.setVisible(true);
    }//GEN-LAST:event_copyMenuItemActionPerformed

    private void LeaveMenuBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LeaveMenuBarActionPerformed
        closeAll();
        ltf = new LeaveTypesForm();
        desktopPane.add(ltf);
        ltf.setVisible(true);
    }//GEN-LAST:event_LeaveMenuBarActionPerformed

    private void RequestMenuBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RequestMenuBarActionPerformed
        closeAll();
        rf = new RequestForm();
        desktopPane.add(rf);
        rf.setVisible(true);
    }//GEN-LAST:event_RequestMenuBarActionPerformed


    private void ApproveMenuBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApproveMenuBarActionPerformed
        closeAll();
        af = new ApprovementForm();
        desktopPane.add(af);
        af.setVisible(true);
    }//GEN-LAST:event_ApproveMenuBarActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        closeAll();
        rsf = new RequestStatusForm();
        desktopPane.add(rsf);
        rsf.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void EmployeeMenuBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmployeeMenuBarActionPerformed
        closeAll();
        ef = new EmployeeForm();
        desktopPane.add(ef);
        ef.setVisible(true);
    }//GEN-LAST:event_EmployeeMenuBarActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        closeAll();
        cf = new CertifiableForm();
        desktopPane.add(cf);
        cf.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void HrApprovementMenuBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HrApprovementMenuBarActionPerformed
        closeAll();
        hraf = new HrApprovementForm();
        desktopPane.add(hraf);
        hraf.setVisible(true);
    }//GEN-LAST:event_HrApprovementMenuBarActionPerformed

    private void AddEmployeeTrainingsMenuBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddEmployeeTrainingsMenuBarActionPerformed
        closeAll();
        etif = new EmployeeTrainingInsertForm();
        desktopPane.add(etif);
        etif.setVisible(true);
    }//GEN-LAST:event_AddEmployeeTrainingsMenuBarActionPerformed

    private void EmployeeTrainingsMenuBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmployeeTrainingsMenuBarActionPerformed
        closeAll();
        etf = new EmployeeTrainingsForm();
        desktopPane.add(etf);
        etf.setVisible(true);
    }//GEN-LAST:event_EmployeeTrainingsMenuBarActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        closeAll();
        tsf = new TrainingStatusForm();
        desktopPane.add(tsf);
        tsf.setVisible(true);    // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void TrainingMenuBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrainingMenuBarActionPerformed
        closeAll();
        ttf = new TrainingTypesForm();
        desktopPane.add(ttf);
        ttf.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_TrainingMenuBarActionPerformed

    private void EmployeeLeavesMenuBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmployeeLeavesMenuBarActionPerformed
        closeAll();
        elf = new EmployeeLeavesForm();
        desktopPane.add(elf);
        elf.setVisible(true);
    }//GEN-LAST:event_EmployeeLeavesMenuBarActionPerformed

    private void LogoutMenuBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutMenuBarActionPerformed
        try {
            LocalTime localLogoutTime = LocalTime.now();
            Logins l = lr.findById(lr.findLogin(on.getEmployeeID()));
            Time logoutTime = Time.valueOf(localLogoutTime);
            l.setLogouted(logoutTime);
            l.setLoginedTime(new Time(logoutTime.getHours() - loginedTime.getHours(),
                    logoutTime.getMinutes() - loginedTime.getMinutes(),logoutTime.getSeconds()- loginedTime.getSeconds()));
            lr.edit(l);
        } catch (LoginsException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
        new LoginForm().setVisible(true);
    }//GEN-LAST:event_LogoutMenuBarActionPerformed

    private void EmployeeLoginsMenuBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmployeeLoginsMenuBarActionPerformed
        closeAll();
        lf = new LoginsForm();
        desktopPane.add(lf);
        lf.setVisible(true);
    }//GEN-LAST:event_EmployeeLoginsMenuBarActionPerformed

    private void NewUserMenuBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewUserMenuBarActionPerformed
        closeAll();
        hrlf = new HumanResourceLoginForm();
        desktopPane.add(hrlf);
        hrlf.setVisible(true);
    }//GEN-LAST:event_NewUserMenuBarActionPerformed

    private void AttendanceMenuBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AttendanceMenuBarActionPerformed
        closeAll();
        atf = new AttendanceForm();
        desktopPane.add(atf);
        atf.setVisible(true);
    }//GEN-LAST:event_AttendanceMenuBarActionPerformed

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AddEmployeeTrainingsMenuBar;
    private javax.swing.JMenuItem ApproveMenuBar;
    private javax.swing.JMenu ApprovementMenu;
    private javax.swing.JMenuItem AttendanceMenuBar;
    private javax.swing.JMenuItem DepartmentMenuBar;
    private javax.swing.JMenuItem EmployeeDepartmentHistoryMenuBar;
    private javax.swing.JMenuItem EmployeeLeavesMenuBar;
    private javax.swing.JMenuItem EmployeeLoginsMenuBar;
    private javax.swing.JMenu EmployeeMenu;
    private javax.swing.JMenuItem EmployeeMenuBar;
    private javax.swing.JMenuItem EmployeeTrainingsMenuBar;
    private javax.swing.JMenuItem HrApprovementMenuBar;
    private javax.swing.JMenuItem JobTitleMenuBar;
    private javax.swing.JMenu LeaveMenu;
    private javax.swing.JMenuItem LeaveMenuBar;
    private javax.swing.JMenuItem LogoutMenuBar;
    private javax.swing.JMenuItem NewUserMenuBar;
    private javax.swing.JMenuItem RequestMenuBar;
    private javax.swing.JMenu SearchAndReportsMenu;
    private javax.swing.JMenu StatusMenu;
    private javax.swing.JMenuItem TrainingMenuBar;
    private javax.swing.JMenu TrainingsMenu;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JMenuBar jMenuBar5;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem pasteMenuItem;
    // End of variables declaration//GEN-END:variables

}
