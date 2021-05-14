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
 * @author Armend
 */
@Entity
@Table(name = "Request")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Request.findAll", query = "SELECT r FROM Request r"),
    @NamedQuery(name = "Request.findByRequestID", query = "SELECT r FROM Request r WHERE r.requestID = :requestID"),
    @NamedQuery(name = "Request.findByRequestDescription", query = "SELECT r FROM Request r WHERE r.requestDescription = :requestDescription"),
    @NamedQuery(name = "Request.findByRequestDate", query = "SELECT r FROM Request r WHERE r.requestDate = :requestDate"),
    @NamedQuery(name = "Request.findByRequestDays", query = "SELECT r FROM Request r WHERE r.requestDays = :requestDays"),
    @NamedQuery(name = "Request.findByStartDate", query = "SELECT r FROM Request r WHERE r.startDate = :startDate"),
    @NamedQuery(name = "Request.findByEndDate", query = "SELECT r FROM Request r WHERE r.endDate = :endDate"),
    @NamedQuery(name = "Request.findByApprovedDate", query = "SELECT r FROM Request r WHERE r.approvedDate = :approvedDate")})
public class Request implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "requestID")
    @GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
    private Integer requestID;
    @Column(name = "requestDescription")
    private String requestDescription;
    @Basic(optional = false)
    @Column(name = "requestDate")
    @Temporal(TemporalType.DATE)
    private Date requestDate;
    @Basic(optional = false)
    @Column(name = "requestDays")
    private short requestDays;
    @Basic(optional = false)
    @Column(name = "startDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Basic(optional = false)
    @Column(name = "endDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Column(name = "approvedDate")
    @Temporal(TemporalType.DATE)
    private Date approvedDate;
    @JoinColumn(name = "Employee", referencedColumnName = "employeeID")
    @ManyToOne(optional = false)
    private Employee employee;
    @JoinColumn(name = "Leave", referencedColumnName = "leaveID")
    @ManyToOne(optional = false)
    private LeaveTypes leave;
    @JoinColumn(name = "RequestStatus", referencedColumnName = "requestStatusID")
    @ManyToOne(optional = false)
    private RequestStatus requestStatus;

    public Request() {
    }

    public Request(Integer requestID) {
        this.requestID = requestID;
    }

    public Request(Integer requestID, Date requestDate, short requestDays, Date startDate, Date endDate) {
        this.requestID = requestID;
        this.requestDate = requestDate;
        this.requestDays = requestDays;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getRequestID() {
        return requestID;
    }

    public void setRequestID(Integer requestID) {
        this.requestID = requestID;
    }

    public String getRequestDescription() {
        return requestDescription;
    }

    public void setRequestDescription(String requestDescription) {
        this.requestDescription = requestDescription;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public short getRequestDays() {
        return requestDays;
    }

    public void setRequestDays(short requestDays) {
        this.requestDays = requestDays;
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

    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
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

    public RequestStatus getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(RequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requestID != null ? requestID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Request)) {
            return false;
        }
        Request other = (Request) object;
        if ((this.requestID == null && other.requestID != null) || (this.requestID != null && !this.requestID.equals(other.requestID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Request[ requestID=" + requestID + " ]";
    }
    
}
