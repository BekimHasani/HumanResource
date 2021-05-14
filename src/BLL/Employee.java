/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Bekim
 */
@Entity
@Table(name = "Employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findByEmployeeID", query = "SELECT e FROM Employee e WHERE e.employeeID = :employeeID"),
    @NamedQuery(name = "Employee.findByEmployeeName", query = "SELECT e FROM Employee e WHERE e.employeeName = :employeeName"),
    @NamedQuery(name = "Employee.findByEmployeeLastName", query = "SELECT e FROM Employee e WHERE e.employeeLastName = :employeeLastName"),
    @NamedQuery(name = "Employee.findByFathersName", query = "SELECT e FROM Employee e WHERE e.fathersName = :fathersName"),
    @NamedQuery(name = "Employee.findByBirthDate", query = "SELECT e FROM Employee e WHERE e.birthDate = :birthDate"),
    @NamedQuery(name = "Employee.findByPersonalNumber", query = "SELECT e FROM Employee e WHERE e.personalNumber = :personalNumber"),
    @NamedQuery(name = "Employee.findByHiredDate", query = "SELECT e FROM Employee e WHERE e.hiredDate = :hiredDate"),
    @NamedQuery(name = "Employee.findByGender", query = "SELECT e FROM Employee e WHERE e.gender = :gender"),
    @NamedQuery(name = "Employee.findByMobileNumber", query = "SELECT e FROM Employee e WHERE e.mobileNumber = :mobileNumber"),
    @NamedQuery(name = "Employee.findByHomeNumber", query = "SELECT e FROM Employee e WHERE e.homeNumber = :homeNumber"),
    @NamedQuery(name = "Employee.findByEmployeeAddress", query = "SELECT e FROM Employee e WHERE e.employeeAddress = :employeeAddress"),
    @NamedQuery(name = "Employee.findByEmployeeState", query = "SELECT e FROM Employee e WHERE e.employeeState = :employeeState"),
    @NamedQuery(name = "Employee.findByEmail", query = "SELECT e FROM Employee e WHERE e.email = :email")})
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "employeeID")
    @GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
    private Integer employeeID;
    @Basic(optional = false)
    @Column(name = "employeeName")
    private String employeeName;
    @Basic(optional = false)
    @Column(name = "employeeLastName")
    private String employeeLastName;
    @Basic(optional = false)
    @Column(name = "fathersName")
    private String fathersName;
    @Basic(optional = false)
    @Column(name = "birthDate")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Column(name = "personalNumber")
    private String personalNumber;
    @Basic(optional = false)
    @Column(name = "hiredDate")
    @Temporal(TemporalType.DATE)
    private Date hiredDate;
    @Basic(optional = false)
    @Column(name = "gender")
    private Character gender;
    @Column(name = "mobileNumber")
    private String mobileNumber;
    @Column(name = "homeNumber")
    private String homeNumber;
    @Basic(optional = false)
    @Column(name = "employeeAddress")
    private String employeeAddress;
    @Basic(optional = false)
    @Column(name = "employeeState")
    private String employeeState;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private Collection<Attendance> attendanceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private Collection<EmployeeLeaves> employeeLeavesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private Collection<HumanResourceLogin> humanResourceLoginCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private Collection<EmployeeDepartmentHistory> employeeDepartmentHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private Collection<Request> requestCollection;
    @JoinColumn(name = "EmployeeStatus", referencedColumnName = "employeeStatusID")
    @ManyToOne(optional = false)
    private EmployeeStatus employeeStatus;
    @JoinColumn(name = "JobTitle", referencedColumnName = "jobTitleID")
    @ManyToOne(optional = false)
    private JobTitle jobTitle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private Collection<Logins> loginsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private Collection<EmployeeTrainings> employeeTrainingsCollection;

    public Employee() {
    }

    public Employee(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public Employee(Integer employeeID, String employeeName, String employeeLastName, String fathersName, Date birthDate, Date hiredDate, Character gender, String employeeAddress, String employeeState, String email) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeeLastName = employeeLastName;
        this.fathersName = fathersName;
        this.birthDate = birthDate;
        this.hiredDate = hiredDate;
        this.gender = gender;
        this.employeeAddress = employeeAddress;
        this.employeeState = employeeState;
        this.email = email;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public Date getHiredDate() {
        return hiredDate;
    }

    public void setHiredDate(Date hiredDate) {
        this.hiredDate = hiredDate;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeeState() {
        return employeeState;
    }

    public void setEmployeeState(String employeeState) {
        this.employeeState = employeeState;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<Attendance> getAttendanceCollection() {
        return attendanceCollection;
    }

    public void setAttendanceCollection(Collection<Attendance> attendanceCollection) {
        this.attendanceCollection = attendanceCollection;
    }

    @XmlTransient
    public Collection<EmployeeLeaves> getEmployeeLeavesCollection() {
        return employeeLeavesCollection;
    }

    public void setEmployeeLeavesCollection(Collection<EmployeeLeaves> employeeLeavesCollection) {
        this.employeeLeavesCollection = employeeLeavesCollection;
    }

    @XmlTransient
    public Collection<HumanResourceLogin> getHumanResourceLoginCollection() {
        return humanResourceLoginCollection;
    }

    public void setHumanResourceLoginCollection(Collection<HumanResourceLogin> humanResourceLoginCollection) {
        this.humanResourceLoginCollection = humanResourceLoginCollection;
    }

    @XmlTransient
    public Collection<EmployeeDepartmentHistory> getEmployeeDepartmentHistoryCollection() {
        return employeeDepartmentHistoryCollection;
    }

    public void setEmployeeDepartmentHistoryCollection(Collection<EmployeeDepartmentHistory> employeeDepartmentHistoryCollection) {
        this.employeeDepartmentHistoryCollection = employeeDepartmentHistoryCollection;
    }

    @XmlTransient
    public Collection<Request> getRequestCollection() {
        return requestCollection;
    }

    public void setRequestCollection(Collection<Request> requestCollection) {
        this.requestCollection = requestCollection;
    }

    public EmployeeStatus getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(EmployeeStatus employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }

    @XmlTransient
    public Collection<Logins> getLoginsCollection() {
        return loginsCollection;
    }

    public void setLoginsCollection(Collection<Logins> loginsCollection) {
        this.loginsCollection = loginsCollection;
    }

    @XmlTransient
    public Collection<EmployeeTrainings> getEmployeeTrainingsCollection() {
        return employeeTrainingsCollection;
    }

    public void setEmployeeTrainingsCollection(Collection<EmployeeTrainings> employeeTrainingsCollection) {
        this.employeeTrainingsCollection = employeeTrainingsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeID != null ? employeeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.employeeID == null && other.employeeID != null) || (this.employeeID != null && !this.employeeID.equals(other.employeeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return employeeName + " " + employeeLastName + " : " + personalNumber;
    }
    
}
