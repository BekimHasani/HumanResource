/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Bekim
 */
@Entity
@Table(name = "Department")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d"),
    @NamedQuery(name = "Department.findByDepartmentID", query = "SELECT d FROM Department d WHERE d.departmentID = :departmentID"),
    @NamedQuery(name = "Department.findByDepartmentName", query = "SELECT d FROM Department d WHERE d.departmentName = :departmentName"),
    @NamedQuery(name = "Department.findByEmployees", query = "SELECT d FROM Department d WHERE d.employees = :employees"),
    @NamedQuery(name = "Department.findByDepartmentStatus", query = "SELECT d FROM Department d WHERE d.departmentStatus = :departmentStatus")})
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "departmentID")
    @GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
    private Short departmentID;
    @Basic(optional = false)
    @Column(name = "departmentName")
    private String departmentName;
    @Basic(optional = false)
    @Column(name = "employees")
    private short employees;
    @Basic(optional = false)
    @Column(name = "departmentStatus")
    private boolean departmentStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private Collection<EmployeeDepartmentHistory> employeeDepartmentHistoryCollection;

    public Department() {
    }

    public Department(Short departmentID) {
        this.departmentID = departmentID;
    }

    public Department(Short departmentID, String departmentName, short employees, boolean departmentStatus) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.employees = employees;
        this.departmentStatus = departmentStatus;
    }

    public Short getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Short departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public short getEmployees() {
        return employees;
    }

    public void setEmployees(short employees) {
        this.employees = employees;
    }

    public boolean getDepartmentStatus() {
        return departmentStatus;
    }

    public void setDepartmentStatus(boolean departmentStatus) {
        this.departmentStatus = departmentStatus;
    }

    @XmlTransient
    public Collection<EmployeeDepartmentHistory> getEmployeeDepartmentHistoryCollection() {
        return employeeDepartmentHistoryCollection;
    }

    public void setEmployeeDepartmentHistoryCollection(Collection<EmployeeDepartmentHistory> employeeDepartmentHistoryCollection) {
        this.employeeDepartmentHistoryCollection = employeeDepartmentHistoryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (departmentID != null ? departmentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        if ((this.departmentID == null && other.departmentID != null) || (this.departmentID != null && !this.departmentID.equals(other.departmentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return departmentName;
    }
    
}
