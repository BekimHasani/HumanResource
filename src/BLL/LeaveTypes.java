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
 * @author Armend
 */
@Entity
@Table(name = "LeaveTypes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LeaveTypes.findAll", query = "SELECT l FROM LeaveTypes l"),
    @NamedQuery(name = "LeaveTypes.findByLeaveID", query = "SELECT l FROM LeaveTypes l WHERE l.leaveID = :leaveID"),
    @NamedQuery(name = "LeaveTypes.findByLeaveDescription", query = "SELECT l FROM LeaveTypes l WHERE l.leaveDescription = :leaveDescription"),
    @NamedQuery(name = "LeaveTypes.findByLeaveDays", query = "SELECT l FROM LeaveTypes l WHERE l.leaveDays = :leaveDays"),
    @NamedQuery(name = "LeaveTypes.findByLeaveStatus", query = "SELECT l FROM LeaveTypes l WHERE l.leaveStatus = :leaveStatus")})
public class LeaveTypes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "leaveID")
    @GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
    private Short leaveID;
    @Basic(optional = false)
    @Column(name = "leaveDescription")
    private String leaveDescription;
    @Column(name = "leaveDays")
    private Short leaveDays;
    @Basic(optional = false)
    @Column(name = "leaveStatus")
    private boolean leaveStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leave")
    private Collection<EmployeeLeaves> employeeLeavesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leave")
    private Collection<Request> requestCollection;

    public LeaveTypes() {
    }

    public LeaveTypes(Short leaveID) {
        this.leaveID = leaveID;
    }

    public LeaveTypes(Short leaveID, String leaveDescription, boolean leaveStatus) {
        this.leaveID = leaveID;
        this.leaveDescription = leaveDescription;
        this.leaveStatus = leaveStatus;
    }

    public Short getLeaveID() {
        return leaveID;
    }

    public void setLeaveID(Short leaveID) {
        this.leaveID = leaveID;
    }

    public String getLeaveDescription() {
        return leaveDescription;
    }

    public void setLeaveDescription(String leaveDescription) {
        this.leaveDescription = leaveDescription;
    }

    public Short getLeaveDays() {
        return leaveDays;
    }

    public void setLeaveDays(Short leaveDays) {
        this.leaveDays = leaveDays;
    }

    public boolean getLeaveStatus() {
        return leaveStatus;
    }

    public void setLeaveStatus(boolean leaveStatus) {
        this.leaveStatus = leaveStatus;
    }

    @XmlTransient
    public Collection<EmployeeLeaves> getEmployeeLeavesCollection() {
        return employeeLeavesCollection;
    }

    public void setEmployeeLeavesCollection(Collection<EmployeeLeaves> employeeLeavesCollection) {
        this.employeeLeavesCollection = employeeLeavesCollection;
    }

    @XmlTransient
    public Collection<Request> getRequestCollection() {
        return requestCollection;
    }

    public void setRequestCollection(Collection<Request> requestCollection) {
        this.requestCollection = requestCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (leaveID != null ? leaveID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LeaveTypes)) {
            return false;
        }
        LeaveTypes other = (LeaveTypes) object;
        if ((this.leaveID == null && other.leaveID != null) || (this.leaveID != null && !this.leaveID.equals(other.leaveID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.LeaveTypes[ leaveID=" + leaveID + " ]";
    }
    
}
