/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.Department;
import BLL.Employee;
import BLL.EmployeeDepartmentHistory;
import BLL.EmployeeStatus;
import BLL.JobTitle;
import DAL.DepartmentException;
import DAL.DepartmentRepository;
import DAL.EmployeeDepHistoryException;
import DAL.EmployeeDepHistoryRepository;
import DAL.EmployeeException;
import DAL.EmployeeInterface;
import DAL.EmployeeRepository;
import DAL.EmployeeStatusException;
import DAL.EmployeeStatusInterface;
import DAL.EmployeeStatusRepository;
import DAL.JobTitleException;
import DAL.JobTitleInterface;
import DAL.JobTitleRepository;
import static GUI.Utility.toDate;
import MODEL.DepartmentComboBoxModel;
import MODEL.DepartmentTableModel;
import MODEL.EmployeeDepHistoryTableModel;
import MODEL.EmployeeStatusComboBoxModel;
import MODEL.EmployeeTableModel;
import MODEL.JobTitleComboBoxModel;
import java.awt.HeadlessException;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Bekim
 */
public class EmployeeForm extends javax.swing.JInternalFrame {

    private EmployeeInterface er = new EmployeeRepository();
    private EmployeeTableModel etm = new EmployeeTableModel();
    private JobTitleComboBoxModel jtcmb = new JobTitleComboBoxModel();
    private JobTitleInterface jtr = new JobTitleRepository();
    private EmployeeStatusComboBoxModel escmb = new EmployeeStatusComboBoxModel();
    private EmployeeStatusInterface esr = new EmployeeStatusRepository();
    private DepartmentComboBoxModel dcbm = new DepartmentComboBoxModel();
    private EmployeeDepHistoryRepository edhr = new EmployeeDepHistoryRepository();
    private DepartmentRepository dr = new DepartmentRepository();
    private DepartmentTableModel dtm = new DepartmentTableModel();
    private EmployeeDepHistoryTableModel edhtm = new EmployeeDepHistoryTableModel();

    private char gender = 0;

    public EmployeeForm() {
        initComponents();
        loadTable();
        loadEmployeeStatusComboBox();
        loadJobTitleComboBox();
        tabelaSelectedIndexChange();
        loadDepartmentComboBox();
        stateCmb.setSelectedIndex(-1);
        stateCmb.repaint();
        emailTxt.setText("@CompanyName.com");
        mobileNumberTxt.setText("003834");
        homeNumberTxt.setText("0038338");
    }

    public void tabelaSelectedIndexChange() {
        final ListSelectionModel rowSM = employeeTbl.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    Employee e = etm.getEmployee(selectedIndex);
                    employeeIDTxt.setText(e.getEmployeeID() + "");
                    nameTxt.setText(e.getEmployeeName());
                    lastNameTxt.setText(e.getEmployeeLastName());
                    birthDateCalendar.setDate(e.getBirthDate());
                    fatherNameTxt.setText(e.getFathersName());
                    personalNumberTxt.setText(e.getPersonalNumber() + "");
                    if (e.getGender() == 'M') {
                        maleRbt.setSelected(true);
                    } else {
                        femaleRbt.setSelected(true);
                    }
                    mobileNumberTxt.setText(e.getMobileNumber() + "");
                    if(e.getHomeNumber() == null){
                        homeNumberTxt.setText("");
                    }else{
                        homeNumberTxt.setText(e.getHomeNumber() + "");
                    }
                    addressTxt.setText(e.getEmployeeAddress());
                    stateCmb.setSelectedItem(e.getEmployeeState());
                    emailTxt.setText(e.getEmail());
                    jobTitleCmb.setSelectedItem(e.getJobTitle());
                    employeeStatusCmb.setSelectedItem(e.getEmployeeStatus());
                    departmentCmb.setSelectedItem(etm.getValueAt(selectedIndex, 15));
                }
            }
        });
    }

    public void clear() {
        employeeTbl.clearSelection();
        employeeIDTxt.setText("");
        nameTxt.setText("");
        lastNameTxt.setText("");
        fatherNameTxt.setText("");
        birthDateCalendar.setDate(null);
        personalNumberTxt.setText("");
        mobileNumberTxt.setText("003834");
        homeNumberTxt.setText("0038338");
        maleRbt.setSelected(false);
        femaleRbt.setSelected(false);
        addressTxt.setText("");
        stateCmb.setSelectedIndex(-1);
        stateCmb.repaint();
        emailTxt.setText("@CompanyName.com");
        jobTitleCmb.setSelectedIndex(-1);
        jobTitleCmb.repaint();
        employeeStatusCmb.setSelectedIndex(-1);
        employeeStatusCmb.repaint();
        departmentCmb.setSelectedIndex(-1);
        departmentCmb.repaint();
    }

    public void loadTable() {
        List<Employee> lista;
        try {
            lista = er.findAll();
            etm = new EmployeeTableModel(lista);
            employeeTbl.setModel(etm);
            etm.fireTableDataChanged();
        } catch (EmployeeException ex) {;
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void loadJobTitleComboBox() {
        try {
            List<JobTitle> lista = jtr.findAll();
            jtcmb.add(lista);
            jobTitleCmb.setModel(jtcmb);
            jobTitleCmb.repaint();
        } catch (JobTitleException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    public void loadEmployeeStatusComboBox() {
        try {
            List<EmployeeStatus> list = esr.findAll();
            escmb.add(list);
            employeeStatusCmb.setModel(escmb);
            employeeStatusCmb.repaint();
        } catch (EmployeeStatusException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    public void loadDepartmentComboBox() {
        try {
            dcbm.add(dr.findAll());
            departmentCmb.setModel(dcbm);
            departmentCmb.repaint();
        } catch (DepartmentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
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

        buttonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        employeeIDTxt = new javax.swing.JTextField();
        addressTxt = new javax.swing.JTextField();
        emailTxt = new javax.swing.JTextField();
        nameTxt = new javax.swing.JTextField();
        lastNameTxt = new javax.swing.JTextField();
        homeNumberTxt = new javax.swing.JTextField();
        fatherNameTxt = new javax.swing.JTextField();
        mobileNumberTxt = new javax.swing.JTextField();
        maleRbt = new javax.swing.JRadioButton();
        femaleRbt = new javax.swing.JRadioButton();
        birthDateCalendar = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        personalNumberTxt = new javax.swing.JTextField();
        jobTitleCmb = new javax.swing.JComboBox();
        employeeStatusCmb = new javax.swing.JComboBox();
        saveBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        stateCmb = new javax.swing.JComboBox();
        departmentCmb = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        employeeTbl = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);

        jLabel1.setText("Employee ID:");

        jLabel2.setText("* Name:");

        jLabel3.setText("* Last Name:");

        jLabel4.setText("* Father Name: ");

        jLabel5.setText("* Birth Date:");

        jLabel7.setText("* Gender:");

        jLabel8.setText("* MobileNr:");

        jLabel9.setText("* Home Nr:");

        jLabel10.setText("* Address:");

        jLabel11.setText("* State:");

        jLabel12.setText("* Email :");

        jLabel13.setText("* Job Title ID:");

        employeeIDTxt.setEditable(false);
        employeeIDTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeIDTxtActionPerformed(evt);
            }
        });

        addressTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressTxtActionPerformed(evt);
            }
        });

        emailTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTxtActionPerformed(evt);
            }
        });

        nameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTxtActionPerformed(evt);
            }
        });

        lastNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameTxtActionPerformed(evt);
            }
        });

        homeNumberTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeNumberTxtActionPerformed(evt);
            }
        });

        fatherNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fatherNameTxtActionPerformed(evt);
            }
        });

        mobileNumberTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobileNumberTxtActionPerformed(evt);
            }
        });

        buttonGroup.add(maleRbt);
        maleRbt.setText("Male");
        maleRbt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maleRbtMouseClicked(evt);
            }
        });
        maleRbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleRbtActionPerformed(evt);
            }
        });

        buttonGroup.add(femaleRbt);
        femaleRbt.setText("Female");
        femaleRbt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                femaleRbtMouseClicked(evt);
            }
        });
        femaleRbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleRbtActionPerformed(evt);
            }
        });

        jLabel6.setText("* Personal Nr. :");

        personalNumberTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personalNumberTxtActionPerformed(evt);
            }
        });

        jobTitleCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobTitleCmbActionPerformed(evt);
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
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        editBtn.setText("Edit");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        jLabel15.setText(" * Status: ");

        stateCmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Afghanistan", "Akrotiri", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Ashmore and Cartier Islands", "Australia", "Austria", "Azerbaijan", "Bahamas, The", "Bahrain", "Bangladesh", "Barbados", "Bassas da India", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory", "British Virgin Islands", "Brunei", "Bulgaria", "Burkina Faso", "Burma", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands", "Central African Republic", "Chad", "Chile", "China", "Christmas Island", "Clipperton Island", "Cocos (Keeling) Islands", "Colombia", "Comoros", "Congo, Democratic Republic of the", "Congo, Republic of the", "Cook Islands", "Coral Sea Islands", "Costa Rica", "Cote d'Ivoire", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Dhekelia", "Djibouti", "Dominica", "Dominican Republic", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Europa Island", "Falkland Islands (Islas Malvinas)", "Faroe Islands", "Fiji", "Finland", "France", "French Guiana", "French Polynesia", "French Southern and Antarctic Lands", "Gabon", "Gambia, The", "Gaza Strip", "Georgia", "Germany", "Ghana", "Gibraltar", "Glorioso Islands", "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guernsey", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Heard Island and McDonald Islands", "Holy See (Vatican City)", "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Isle of Man", "Israel", "Italy", "Jamaica", "Jan Mayen", "Japan", "Jersey", "Jordan", "Juan de Nova Island", "Kazakhstan", "Kenya", "Kiribati", "Korea, North", "Korea, South", "Kosova", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Micronesia, Federated States of", "Moldova", "Monaco", "Mongolia", "Montserrat", "Morocco", "Mozambique", "Namibia", "Nauru", "Navassa Island", "Nepal", "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "Northern Mariana Islands", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paracel Islands", "Paraguay", "Peru", "Philippines", "Pitcairn Islands", "Poland", "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania", "Russia", "Rwanda", "Saint Helena", "Saint Kitts and Nevis", "Saint Lucia", "Saint Pierre and Miquelon", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Serbia and Montenegro", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Georgia and the South Sandwich Islands", "Spain", "Spratly Islands", "Sri Lanka", "Sudan", "Suriname", "Svalbard", "Swaziland", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Timor-Leste", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tromelin Island", "Tunisia", "Turkey", "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Virgin Islands", "Wake Island", "Wallis and Futuna", "West Bank", "Western Sahara", "Yemen", "Zambia", "Zimbabwe" }));
        stateCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stateCmbActionPerformed(evt);
            }
        });

        departmentCmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel14.setText("* Department:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(153, 153, 153));
        jLabel16.setText("Employee Form :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel16))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jLabel1)
                .addGap(326, 326, 326)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(375, 375, 375)
                .addComponent(jLabel15))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(employeeIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(175, 175, 175)
                .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(215, 215, 215)
                .addComponent(employeeStatusCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jLabel2)
                .addGap(350, 350, 350)
                .addComponent(jLabel9))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(175, 175, 175)
                .addComponent(homeNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(215, 215, 215)
                .addComponent(jLabel13))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(fatherNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(lastNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(175, 175, 175)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(mobileNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(addressTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(215, 215, 215)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jobTitleCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(departmentCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jLabel6)
                .addGap(315, 315, 315)
                .addComponent(jLabel7)
                .addGap(32, 32, 32)
                .addComponent(maleRbt)
                .addGap(33, 33, 33)
                .addComponent(femaleRbt)
                .addGap(211, 211, 211)
                .addComponent(jLabel11))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(personalNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(605, 605, 605)
                .addComponent(stateCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jLabel5))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(birthDateCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(510, 510, 510)
                .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(employeeIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(employeeStatusCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(homeNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel4)
                        .addGap(6, 6, 6)
                        .addComponent(fatherNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lastNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(mobileNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel10)
                        .addGap(6, 6, 6)
                        .addComponent(addressTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jobTitleCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel14)
                        .addGap(6, 6, 6)
                        .addComponent(departmentCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maleRbt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(femaleRbt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(personalNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stateCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jLabel5)
                .addGap(6, 6, 6)
                .addComponent(birthDateCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveBtn)
                    .addComponent(editBtn)
                    .addComponent(cancelBtn)
                    .addComponent(deleteBtn))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        employeeTbl.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(employeeTbl);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void stateCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stateCmbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stateCmbActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        int row = employeeTbl.getSelectedRow();
        if (row != -1) {
            Employee e = etm.getEmployee(row);
            try {
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                gender = e.getGender();
                /*---NAME---*/
                if (Utility.isEmpty(nameTxt.getText())) {
                    JOptionPane.showMessageDialog(this, "Name cannot be empty");
                    return;
                } else if (!Utility.validName(nameTxt.getText())) {
                    JOptionPane.showMessageDialog(this, "Name should contain only letters");
                    return;
                } else if (nameTxt.getText().length() <= 2) {
                    JOptionPane.showMessageDialog(this, "Name should contain at least 3 characters");
                    return;
                } else if (nameTxt.getText().length() >= 20) {
                    JOptionPane.showMessageDialog(this, "Name should contain at most 20 characters");
                    return;
                } else {
                    e.setEmployeeName(nameTxt.getText());
                }

                /*---LAST_NAME---*/
                if (Utility.isEmpty(lastNameTxt.getText())) {
                    JOptionPane.showMessageDialog(this, "LastName cannot be empty");
                    return;
                } else if (!Utility.validName(lastNameTxt.getText())) {
                    JOptionPane.showMessageDialog(this, "LastName should contain only letters");
                    return;
                } else if (lastNameTxt.getText().length() <= 2) {
                    JOptionPane.showMessageDialog(this, "LastName should contain at least 3 characters");
                    return;
                } else if (lastNameTxt.getText().length() >= 20) {
                    JOptionPane.showMessageDialog(this, "LastName should contain at most 20 characters");
                    return;
                } else {
                    e.setEmployeeLastName(lastNameTxt.getText());
                }

                /*---FATHERS_NAME---*/
                if (Utility.isEmpty(fatherNameTxt.getText())) {
                    JOptionPane.showMessageDialog(this, "FathersName cannot be empty");
                    return;
                } else if (!Utility.validName(fatherNameTxt.getText())) {
                    JOptionPane.showMessageDialog(this, "FathersName should contain only letters");
                    return;
                } else if (fatherNameTxt.getText().length() <= 2) {
                    JOptionPane.showMessageDialog(this, "FathersName should contain at least 3 characters");
                    return;
                } else if (fatherNameTxt.getText().length() >= 20) {
                    JOptionPane.showMessageDialog(this, "FathersName should contain at most 20 characters");
                    return;
                } else {
                    e.setFathersName(fatherNameTxt.getText());
                }

                /*---BIRTH_DATE---*/
                LocalDate minBirthDate = LocalDate.now().minusYears(18);
                LocalDate maxBirthDate = LocalDate.now().minusYears(64);
                Date birthDate = birthDateCalendar.getDate();
                if (birthDate.compareTo(Utility.toDate(minBirthDate)) <= 0
                        && birthDate.compareTo(Utility.toDate(maxBirthDate)) >= 0) {
                    e.setBirthDate(birthDateCalendar.getDate());
                } else {
                    JOptionPane.showMessageDialog(null, "You cant add an employee who's yunger than 18 and older than 64");
                    return;
                }

                /*---PERSONAL_NUMBER---*/
                if (!Utility.validPersonalNumber(personalNumberTxt.getText())) {
                    JOptionPane.showMessageDialog(null, "This is not a valid PN 12******** ");
                    return;
                } else {
                    e.setPersonalNumber(personalNumberTxt.getText());
                }

                /*---GENDER---*/
                if (gender == 0) {
                    JOptionPane.showMessageDialog(this, "Please select the gender");
                    return;
                } else {
                    e.setGender(gender);
                }

                /*----MOBILENUMBER--*/
                if (Utility.validMobileNumber(mobileNumberTxt.getText())) {
                    e.setMobileNumber(mobileNumberTxt.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "Mobile number is invalid -> 003834*******");
                    return;
                }

                /*----HOMENUMBER--*/
                if(Utility.isEmpty(homeNumberTxt.getText()) || homeNumberTxt.getText().equals("0038338")){
                    e.setHomeNumber(null);
                }else if (Utility.validHomeNumber(homeNumberTxt.getText())) {
                    e.setHomeNumber(homeNumberTxt.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "Home number is invalid -> 0038338******");
                    return;
                }

                /*---STATE---*/
                if (stateCmb.getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(this, "State is not selected");
                    return;
                } else {
                    e.setEmployeeState((String) stateCmb.getSelectedItem());
                }

                /*---ADDRESS-*/
                if (!Utility.isEmpty(addressTxt.getText())) {
                    e.setEmployeeAddress(addressTxt.getText());
                } else {
                    JOptionPane.showMessageDialog(this, "Address cannot be empty");
                    return;
                }

                /*---EMAIL---*/
                if (Utility.validEmail(emailTxt.getText())) {
                    e.setEmail(emailTxt.getText());
                } else {
                    JOptionPane.showMessageDialog(this, "Email should start with a non-digit and end with @CompanyName.com)");
                    return;
                }

                /*---JOBTITLE---*/
                if (jobTitleCmb.getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(this, "JobTitle is not selected");
                    return;
                } else {
                    e.setJobTitle((JobTitle) jobTitleCmb.getSelectedItem());
                }

                /*---EMPLOYEE_STATUS---*/
                if (employeeStatusCmb.getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(this, "EmployeeStatus is not selected");
                    return;
                } else {
                    e.setEmployeeStatus((EmployeeStatus) employeeStatusCmb.getSelectedItem());
                }
                
                /*---EMPLOYEE_DEPARTMENT_HISTORY---*/
                List<EmployeeDepartmentHistory> list = edhr.findAll();
                edhtm = new EmployeeDepHistoryTableModel(list);
                for (int i = 0; i < edhtm.getRowCount(); i++) {
                    if (edhtm.getValueAt(i, 4) == null && ((Employee) edhtm.getValueAt(i, 2)).equals(e)) {
                        Department dep = (Department) edhtm.getValueAt(i, 1);
                        Department dep1 = (Department) departmentCmb.getSelectedItem();
                        Employee em = (Employee) edhtm.getValueAt(i, 2);
                        JobTitle jobTitle = (JobTitle) jobTitleCmb.getSelectedItem();
                        EmployeeStatus ems = (EmployeeStatus) employeeStatusCmb.getSelectedItem();
                        if (dep.getDepartmentID() != dep1.getDepartmentID() || em.getJobTitle().getJobTitleID() != jobTitle.getJobTitleID() 
                                || em.getEmployeeStatus().getEmployeeStatusID() != ems.getEmployeeStatusID() ) {
                            EmployeeDepartmentHistory edh = (EmployeeDepartmentHistory) edhtm.getRow(i);
                            LocalDate endDate = LocalDate.now();
                            edh.setEndDate(toDate(endDate));
                            edhr.edit(edh);
                            EmployeeDepartmentHistory edhnew = new EmployeeDepartmentHistory();
                            edhnew.setDepartment((Department) departmentCmb.getSelectedItem());
                         
                            edhnew.setEmployee(e);
                            edhnew.setStartDate(toDate(LocalDate.now()));
                            edhr.create(edhnew);

                        }
                    }
                }
                
                er.edit(e);
                clear();
                loadTable();
            } catch (EmployeeException | EmployeeDepHistoryException ex) {
                JOptionPane.showMessageDialog(null, "Something is wrong with the database connection");
            } catch (HeadlessException ex) {
                JOptionPane.showMessageDialog(null, "Msg : Headless Exception -- Fill all the required text boxes");
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select the employee you want to edit ");
        }
    }//GEN-LAST:event_editBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        clear();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int row = employeeTbl.getSelectedRow();
        if (row != -1) {
            Object[] obj = {"Yes", "No"};
            int i = JOptionPane.showOptionDialog(null, "Confirm your decision", "DELETION",
                    JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, obj, obj[1]);
            if (i == 0) {
                Employee e = etm.getEmployee(row);
                try {
                    er.delete(e);
                    clear();
                    loadTable();
                } catch (EmployeeException ex) {
                    JOptionPane.showMessageDialog(null, "Something is wrong with the database connection");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select the employee you want to delete ");
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        int row = employeeTbl.getSelectedRow();
        if (row == -1) {
            Employee e = new Employee();
            EmployeeDepartmentHistory edh = new EmployeeDepartmentHistory();
            try {
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                /*---NAME---*/
                if (Utility.isEmpty(nameTxt.getText())) {
                    JOptionPane.showMessageDialog(this, "Name cannot be empty");
                    return;
                } else if (!Utility.validName(nameTxt.getText())) {
                    JOptionPane.showMessageDialog(this, "Name should contain only letters");
                    return;
                } else if (nameTxt.getText().length() <= 2) {
                    JOptionPane.showMessageDialog(this, "Name should contain at least 3 characters");
                    return;
                } else if (nameTxt.getText().length() >= 20) {
                    JOptionPane.showMessageDialog(this, "Name should contain at most 20 characters");
                    return;
                } else {
                    e.setEmployeeName(nameTxt.getText());
                }

                /*---LAST_NAME---*/
                if (Utility.isEmpty(lastNameTxt.getText())) {
                    JOptionPane.showMessageDialog(this, "LastName cannot be empty");
                    return;
                } else if (!Utility.validName(lastNameTxt.getText())) {
                    JOptionPane.showMessageDialog(this, "LastName should contain only letters");
                    return;
                } else if (lastNameTxt.getText().length() <= 2) {
                    JOptionPane.showMessageDialog(this, "LastName should contain at least 3 characters");
                    return;
                } else if (lastNameTxt.getText().length() >= 20) {
                    JOptionPane.showMessageDialog(this, "LastName should contain at most 20 characters");
                    return;
                } else {
                    e.setEmployeeLastName(lastNameTxt.getText());
                }

                /*---FATHERS_NAME---*/
                if (Utility.isEmpty(fatherNameTxt.getText())) {
                    JOptionPane.showMessageDialog(this, "FathersName cannot be empty");
                    return;
                } else if (!Utility.validName(fatherNameTxt.getText())) {
                    JOptionPane.showMessageDialog(this, "FathersName should contain only letters");
                    return;
                } else if (fatherNameTxt.getText().length() <= 2) {
                    JOptionPane.showMessageDialog(this, "FathersName should contain at least 3 characters");
                    return;
                } else if (fatherNameTxt.getText().length() >= 20) {
                    JOptionPane.showMessageDialog(this, "FathersName should contain at most 20 characters");
                    return;
                } else {
                    e.setFathersName(fatherNameTxt.getText());
                }

                /*---BIRTH_DATE---*/
                LocalDate minBirthDate = LocalDate.now().minusYears(18);
                LocalDate maxBirthDate = LocalDate.now().minusYears(64);
                Date birthDate = birthDateCalendar.getDate();
                if (birthDate.compareTo(Utility.toDate(minBirthDate)) <= 0
                        && birthDate.compareTo(Utility.toDate(maxBirthDate)) >= 0) {
                    e.setBirthDate(birthDateCalendar.getDate());
                } else {
                    JOptionPane.showMessageDialog(null, "U cant add an employee who's yunger than 18 and older than 64");
                    return;
                }

                /*---PERSONAL_NUMBER---*/
                if (!Utility.validPersonalNumber(personalNumberTxt.getText())) {
                    JOptionPane.showMessageDialog(null, "This is not a valid PN 12******** ");
                    return;
                } else {
                    e.setPersonalNumber(personalNumberTxt.getText());
                }

                /*---HIRED_DATE---*/
                e.setHiredDate(sdf.parse(sdf.format(date)));

                /*---GENDER---*/
                if (gender == 0) {
                    JOptionPane.showMessageDialog(this, "Please select the gender");
                    return;
                } else {
                    e.setGender(gender);
                }

                /*----MOBILENUMBER--*/
                if (Utility.validMobileNumber(mobileNumberTxt.getText())) {
                    e.setMobileNumber(mobileNumberTxt.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "Mobile number is invalid");
                    return;
                }

                /*----HOMENUMBER--*/
                if(Utility.isEmpty(homeNumberTxt.getText()) || homeNumberTxt.getText().equals("0038338")){
                    e.setHomeNumber(null);
                } else if (Utility.validHomeNumber(homeNumberTxt.getText())) {
                    e.setHomeNumber(homeNumberTxt.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "Home number is invalid");
                    return;
                }

                /*---STATE---*/
                if (stateCmb.getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(this, "State is not selected");
                    return;
                } else {
                    e.setEmployeeState((String) stateCmb.getSelectedItem());
                }

                /*---ADDRESS-*/
                if (!Utility.isEmpty(addressTxt.getText())) {
                    e.setEmployeeAddress(addressTxt.getText());
                } else {
                    JOptionPane.showMessageDialog(this, "Address cannot be empty");
                    return;
                }

                /*---EMAIL---*/
                if (Utility.validEmail(emailTxt.getText())) {
                    e.setEmail(emailTxt.getText());
                } else {
                    JOptionPane.showMessageDialog(this, "Email should start with a non-digit and end with @CompanyName.com)");
                    return;
                }

                /*---JOBTITLE---*/
                if (jobTitleCmb.getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(this, "JobTitle is not selected");
                    return;
                } else {
                    e.setJobTitle((JobTitle) jobTitleCmb.getSelectedItem());
                }

                /*---EMPLOYEE_STATUS---*/
                if (employeeStatusCmb.getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(this, "EmployeeStatus is not selected");
                    return;
                } else {
                    e.setEmployeeStatus((EmployeeStatus) employeeStatusCmb.getSelectedItem());
                }

                /*---EMPLOYEE_DEPARTMENT_HISTORY---*/
                if (departmentCmb.getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(this, "Department is not selected");
                    return;
                } else {
                    edh.setDepartment((Department) departmentCmb.getSelectedItem());
                }

                /*---EMPLOYEE_DEPARTMENT_HISTORY---*/
                edh.setEmployee(e);
                LocalDate startDate = LocalDate.now();
                edh.setStartDate(toDate(startDate));
                
                er.create(e);
                edhr.create(edh);
                clear();
                loadTable();
            } catch (EmployeeException  ex) {
                JOptionPane.showMessageDialog(this, "[EmployeeException] : Something is wrong with the database connection \n" + ex.getMessage());
            } catch(EmployeeDepHistoryException ex){
                JOptionPane.showMessageDialog(this, "[EmployeeDepHistoryException] : Something is wrong with the database connection \n" + ex.getMessage());
            }   catch (HeadlessException | ParseException ex) {
                JOptionPane.showMessageDialog(this, "Msg : Headless Exception -- Fill all the required text boxes\n" + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "If u want to add a new employee do not select the table");
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void personalNumberTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personalNumberTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_personalNumberTxtActionPerformed

    private void femaleRbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleRbtActionPerformed
        gender = 'F';
    }//GEN-LAST:event_femaleRbtActionPerformed

    private void maleRbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleRbtActionPerformed
        gender = 'M';
    }//GEN-LAST:event_maleRbtActionPerformed

    private void mobileNumberTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobileNumberTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mobileNumberTxtActionPerformed

    private void fatherNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fatherNameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fatherNameTxtActionPerformed

    private void homeNumberTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeNumberTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_homeNumberTxtActionPerformed

    private void lastNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastNameTxtActionPerformed

    private void nameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTxtActionPerformed

    private void emailTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTxtActionPerformed

    private void addressTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressTxtActionPerformed

    private void employeeIDTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeIDTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeIDTxtActionPerformed

    private void jobTitleCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobTitleCmbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jobTitleCmbActionPerformed

    private void femaleRbtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_femaleRbtMouseClicked
        gender = 'F';
    }//GEN-LAST:event_femaleRbtMouseClicked

    private void maleRbtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maleRbtMouseClicked
        gender = 'M';
    }//GEN-LAST:event_maleRbtMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressTxt;
    private com.toedter.calendar.JDateChooser birthDateCalendar;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JComboBox departmentCmb;
    private javax.swing.JButton editBtn;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JTextField employeeIDTxt;
    private javax.swing.JComboBox employeeStatusCmb;
    private javax.swing.JTable employeeTbl;
    private javax.swing.JTextField fatherNameTxt;
    private javax.swing.JRadioButton femaleRbt;
    private javax.swing.JTextField homeNumberTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox jobTitleCmb;
    private javax.swing.JTextField lastNameTxt;
    private javax.swing.JRadioButton maleRbt;
    private javax.swing.JTextField mobileNumberTxt;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JTextField personalNumberTxt;
    private javax.swing.JButton saveBtn;
    private javax.swing.JComboBox stateCmb;
    // End of variables declaration//GEN-END:variables
}
