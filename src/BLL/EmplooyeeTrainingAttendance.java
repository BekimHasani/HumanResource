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
@Table(name = "EmplooyeeTrainingAttendance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmplooyeeTrainingAttendance.findAll", query = "SELECT e FROM EmplooyeeTrainingAttendance e"),
    @NamedQuery(name = "EmplooyeeTrainingAttendance.findByTrainingAttendanceID", query = "SELECT e FROM EmplooyeeTrainingAttendance e WHERE e.trainingAttendanceID = :trainingAttendanceID"),
    @NamedQuery(name = "EmplooyeeTrainingAttendance.findByAttendanceDate", query = "SELECT e FROM EmplooyeeTrainingAttendance e WHERE e.attendanceDate = :attendanceDate"),
    @NamedQuery(name = "EmplooyeeTrainingAttendance.findByStartAt", query = "SELECT e FROM EmplooyeeTrainingAttendance e WHERE e.startAt = :startAt"),
    @NamedQuery(name = "EmplooyeeTrainingAttendance.findByEndAt", query = "SELECT e FROM EmplooyeeTrainingAttendance e WHERE e.endAt = :endAt"),
    @NamedQuery(name = "EmplooyeeTrainingAttendance.findByAttended", query = "SELECT e FROM EmplooyeeTrainingAttendance e WHERE e.attended = :attended")})
public class EmplooyeeTrainingAttendance implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "trainingAttendanceID")
    @GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
    private Integer trainingAttendanceID;
    @Basic(optional = false)
    @Column(name = "attendanceDate")
    @Temporal(TemporalType.DATE)
    private Date attendanceDate;
    @Basic(optional = false)
    @Column(name = "startAt")
    @Temporal(TemporalType.TIME)
    private Date startAt;
    @Basic(optional = false)
    @Column(name = "endAt")
    @Temporal(TemporalType.TIME)
    private Date endAt;
    @Column(name = "attended")
    private Boolean attended;
    @JoinColumn(name = "EmployeeTraining", referencedColumnName = "employeeTrainingId")
    @ManyToOne(optional = false)
    private EmployeeTrainings employeeTraining;
    @JoinColumn(name = "Logins", referencedColumnName = "loginID")
    @ManyToOne(optional = false)
    private Logins logins;

    public EmplooyeeTrainingAttendance() {
    }

    public EmplooyeeTrainingAttendance(Integer trainingAttendanceID) {
        this.trainingAttendanceID = trainingAttendanceID;
    }

    public EmplooyeeTrainingAttendance(Integer trainingAttendanceID, Date attendanceDate, Date startAt, Date endAt) {
        this.trainingAttendanceID = trainingAttendanceID;
        this.attendanceDate = attendanceDate;
        this.startAt = startAt;
        this.endAt = endAt;
    }

    public Integer getTrainingAttendanceID() {
        return trainingAttendanceID;
    }

    public void setTrainingAttendanceID(Integer trainingAttendanceID) {
        this.trainingAttendanceID = trainingAttendanceID;
    }

    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public Date getStartAt() {
        return startAt;
    }

    public void setStartAt(Date startAt) {
        this.startAt = startAt;
    }

    public Date getEndAt() {
        return endAt;
    }

    public void setEndAt(Date endAt) {
        this.endAt = endAt;
    }

    public Boolean getAttended() {
        return attended;
    }

    public void setAttended(Boolean attended) {
        this.attended = attended;
    }

    public EmployeeTrainings getEmployeeTraining() {
        return employeeTraining;
    }

    public void setEmployeeTraining(EmployeeTrainings employeeTraining) {
        this.employeeTraining = employeeTraining;
    }

    public Logins getLogins() {
        return logins;
    }

    public void setLogins(Logins logins) {
        this.logins = logins;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trainingAttendanceID != null ? trainingAttendanceID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmplooyeeTrainingAttendance)) {
            return false;
        }
        EmplooyeeTrainingAttendance other = (EmplooyeeTrainingAttendance) object;
        if ((this.trainingAttendanceID == null && other.trainingAttendanceID != null) || (this.trainingAttendanceID != null && !this.trainingAttendanceID.equals(other.trainingAttendanceID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.EmplooyeeTrainingAttendance[ trainingAttendanceID=" + trainingAttendanceID + " ]";
    }
    
}
