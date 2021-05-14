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
@Table(name = "EmployeeLeaves")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeLeaves.findAll", query = "SELECT e FROM EmployeeLeaves e"),
    @NamedQuery(name = "EmployeeLeaves.findByEmployeeLeaveID", query = "SELECT e FROM EmployeeLeaves e WHERE e.employeeLeaveID = :employeeLeaveID"),
    @NamedQuery(name = "EmployeeLeaves.findByLeaveDays", query = "SELECT e FROM EmployeeLeaves e WHERE e.leaveDays = :leaveDays"),
    @NamedQuery(name = "EmployeeLeaves.findByStartDate", query = "SELECT e FROM EmployeeLeaves e WHERE e.startDate = :startDate"),
    @NamedQuery(name = "EmployeeLeaves.findByEndDate", query = "SELECT e FROM EmployeeLeaves e WHERE e.endDate = :endDate"),
    @NamedQuery(name = "EmployeeLeaves.findByEmployeeLeavesStatus", query = "SELECT e FROM EmployeeLeaves e WHERE e.employeeLeavesStatus = :employeeLeavesStatus")})
public class EmployeeLeaves implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "employeeLeaveID")
    @GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
    private Integer employeeLeaveID;
    @Basic(optional = false)
    @Column(name = "leaveDays")
    private short leaveDays;
    @Basic(optional = false)
    @Column(name = "startDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Basic(optional = false)
    @Column(name = "endDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Basic(optional = false)
    @Column(name = "employeeLeavesStatus")
    private boolean employeeLeavesStatus;
    @JoinColumn(name = "Employee", referencedColumnName = "employeeID")
    @ManyToOne(optional = false)
    private Employee employee;
    @JoinColumn(name = "Leave", referencedColumnName = "leaveID")
    @ManyToOne(optional = false)
    private LeaveTypes leave;

    public EmployeeLeaves() {
    }

    public EmployeeLeaves(Integer employeeLeaveID) {
        this.employeeLeaveID = employeeLeaveID;
    }

    public EmployeeLeaves(Integer employeeLeaveID, short leaveDays, Date startDate, Date endDate, boolean employeeLeavesStatus) {
        this.employeeLeaveID = employeeLeaveID;
        this.leaveDays = leaveDays;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employeeLeavesStatus = employeeLeavesStatus;
    }

    public Integer getEmployeeLeaveID() {
        return employeeLeaveID;
    }

    public void setEmployeeLeaveID(Integer employeeLeaveID) {
        this.employeeLeaveID = employeeLeaveID;
    }

    public short getLeaveDays() {
        return leaveDays;
    }

    public void setLeaveDays(short leaveDays) {
        this.leaveDays = leaveDays;
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

    public boolean getEmployeeLeavesStatus() {
        return employeeLeavesStatus;
    }

    public void setEmployeeLeavesStatus(boolean employeeLeavesStatus) {
        this.employeeLeavesStatus = employeeLeavesStatus;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LeaveTypes getLeave() {
        return leave;
    }

    public void setLeave(LeaveTypes leave) {
        this.leave = leave;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeLeaveID != null ? employeeLeaveID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeLeaves)) {
            return false;
        }
        EmployeeLeaves other = (EmployeeLeaves) object;
        if ((this.employeeLeaveID == null && other.employeeLeaveID != null) || (this.employeeLeaveID != null && !this.employeeLeaveID.equals(other.employeeLeaveID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.EmployeeLeaves[ employeeLeaveID=" + employeeLeaveID + " ]";
    }
    
}
