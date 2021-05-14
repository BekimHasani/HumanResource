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
@Table(name = "Attendance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Attendance.findAll", query = "SELECT a FROM Attendance a"),
    @NamedQuery(name = "Attendance.findByAttendanceID", query = "SELECT a FROM Attendance a WHERE a.attendanceID = :attendanceID"),
    @NamedQuery(name = "Attendance.findByAttendanceDate", query = "SELECT a FROM Attendance a WHERE a.attendanceDate = :attendanceDate"),
    @NamedQuery(name = "Attendance.findByRequiredHours", query = "SELECT a FROM Attendance a WHERE a.requiredHours = :requiredHours"),
    @NamedQuery(name = "Attendance.findByAttendedTime", query = "SELECT a FROM Attendance a WHERE a.attendedTime = :attendedTime"),
    @NamedQuery(name = "Attendance.findByAbssenceTime", query = "SELECT a FROM Attendance a WHERE a.abssenceTime = :abssenceTime"),
    @NamedQuery(name = "Attendance.findByOvertimeD", query = "SELECT a FROM Attendance a WHERE a.overtimeD = :overtimeD")})
public class Attendance implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "attendanceID")
    @GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
    private Long attendanceID;
    @Basic(optional = false)
    @Column(name = "attendanceDate")
    @Temporal(TemporalType.DATE)
    private Date attendanceDate;
    @Basic(optional = false)
    @Column(name = "requiredHours")
    private short requiredHours;
    @Column(name = "attendedTime")
    private Short attendedTime;
    @Column(name = "abssenceTime")
    private Short abssenceTime;
    @Column(name = "overtimeD")
    private Short overtimeD;
    @JoinColumn(name = "Employee", referencedColumnName = "employeeID")
    @ManyToOne(optional = false)
    private Employee employee;
    @JoinColumn(name = "Logins", referencedColumnName = "loginID")
    @ManyToOne(optional = false)
    private Logins logins;

    public Attendance() {
    }

    public Attendance(Long attendanceID) {
        this.attendanceID = attendanceID;
    }

    public Attendance(Long attendanceID, Date attendanceDate, short requiredHours) {
        this.attendanceID = attendanceID;
        this.attendanceDate = attendanceDate;
        this.requiredHours = requiredHours;
    }

    public Long getAttendanceID() {
        return attendanceID;
    }

    public void setAttendanceID(Long attendanceID) {
        this.attendanceID = attendanceID;
    }

    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public short getRequiredHours() {
        return requiredHours;
    }

    public void setRequiredHours(short requiredHours) {
        this.requiredHours = requiredHours;
    }

    public Short getAttendedTime() {
        return attendedTime;
    }

    public void setAttendedTime(Short attendedTime) {
        this.attendedTime = attendedTime;
    }

    public Short getAbssenceTime() {
        return abssenceTime;
    }

    public void setAbssenceTime(Short abssenceTime) {
        this.abssenceTime = abssenceTime;
    }

    public Short getOvertimeD() {
        return overtimeD;
    }

    public void setOvertimeD(Short overtimeD) {
        this.overtimeD = overtimeD;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
        hash += (attendanceID != null ? attendanceID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Attendance)) {
            return false;
        }
        Attendance other = (Attendance) object;
        if ((this.attendanceID == null && other.attendanceID != null) || (this.attendanceID != null && !this.attendanceID.equals(other.attendanceID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Attendance[ attendanceID=" + attendanceID + " ]";
    }
    
}
