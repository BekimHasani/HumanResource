/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bekim
 */
@Entity
@Table(name = "EmployeeDepartmentHistory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeDepartmentHistory.findAll", query = "SELECT e FROM EmployeeDepartmentHistory e"),
    @NamedQuery(name = "EmployeeDepartmentHistory.findByDepartmentHistoriID", query = "SELECT e FROM EmployeeDepartmentHistory e WHERE e.departmentHistoriID = :departmentHistoriID"),
    @NamedQuery(name = "EmployeeDepartmentHistory.findByStartDate", query = "SELECT e FROM EmployeeDepartmentHistory e WHERE e.startDate = :startDate"),
    @NamedQuery(name = "EmployeeDepartmentHistory.findByEndDate", query = "SELECT e FROM EmployeeDepartmentHistory e WHERE e.endDate = :endDate")})
public class EmployeeDepartmentHistory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "departmentHistoriID")
    @GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
    private Integer departmentHistoriID;
    @Basic(optional = false)
    @Column(name = "startDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "endDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @JoinColumn(name = "Department", referencedColumnName = "departmentID")
    @ManyToOne(optional = false)
    private Department department;
    @JoinColumn(name = "Employee", referencedColumnName = "employeeID")
    @ManyToOne(optional = false)
    private Employee employee;

    public EmployeeDepartmentHistory() {
    }

    public EmployeeDepartmentHistory(Integer departmentHistoriID) {
        this.departmentHistoriID = departmentHistoriID;
    }

    public EmployeeDepartmentHistory(Integer departmentHistoriID, Date startDate) {
        this.departmentHistoriID = departmentHistoriID;
        this.startDate = startDate;
    }

    public Integer getDepartmentHistoriID() {
        return departmentHistoriID;
    }

    public void setDepartmentHistoriID(Integer departmentHistoriID) {
        this.departmentHistoriID = departmentHistoriID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (departmentHistoriID != null ? departmentHistoriID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeDepartmentHistory)) {
            return false;
        }
        EmployeeDepartmentHistory other = (EmployeeDepartmentHistory) object;
        if ((this.departmentHistoriID == null && other.departmentHistoriID != null) || (this.departmentHistoriID != null && !this.departmentHistoriID.equals(other.departmentHistoriID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.EmployeeDepartmentHistory[ departmentHistoriID=" + departmentHistoriID + " ]";
    }
    
}
