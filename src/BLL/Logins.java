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
 * @author Armend
 */
@Entity
@Table(name = "Logins")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Logins.findAll", query = "SELECT l FROM Logins l"),
    @NamedQuery(name = "Logins.findByLoginID", query = "SELECT l FROM Logins l WHERE l.loginID = :loginID"),
    @NamedQuery(name = "Logins.findByLoginDate", query = "SELECT l FROM Logins l WHERE l.loginDate = :loginDate"),
    @NamedQuery(name = "Logins.findByLogined", query = "SELECT l FROM Logins l WHERE l.logined = :logined"),
    @NamedQuery(name = "Logins.findByLogouted", query = "SELECT l FROM Logins l WHERE l.logouted = :logouted"),
    @NamedQuery(name = "Logins.findByLoginedTime", query = "SELECT l FROM Logins l WHERE l.loginedTime = :loginedTime")})
public class Logins implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "loginID")
    @GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
    private Integer loginID;
    @Basic(optional = false)
    @Column(name = "loginDate")
    @Temporal(TemporalType.DATE)
    private Date loginDate;
    @Basic(optional = false)
    @Column(name = "logined")
    @Temporal(TemporalType.TIME)
    private Date logined;
    @Column(name = "logouted")
    @Temporal(TemporalType.TIME)
    private Date logouted;
    @Column(name = "loginedTime")
    @Temporal(TemporalType.TIME)
    private Date loginedTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "logins")
    private Collection<Attendance> attendanceCollection;
    @JoinColumn(name = "Employee", referencedColumnName = "employeeID")
    @ManyToOne(optional = false)
    private Employee employee;

    public Logins() {
    }

    public Logins(Integer loginID) {
        this.loginID = loginID;
    }

    public Logins(Integer loginID, Date loginDate, Date logined) {
        this.loginID = loginID;
        this.loginDate = loginDate;
        this.logined = logined;
    }

    public Integer getLoginID() {
        return loginID;
    }

    public void setLoginID(Integer loginID) {
        this.loginID = loginID;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public Date getLogined() {
        return logined;
    }

    public void setLogined(Date logined) {
        this.logined = logined;
    }

    public Date getLogouted() {
        return logouted;
    }

    public void setLogouted(Date logouted) {
        this.logouted = logouted;
    }

    public Date getLoginedTime() {
        return loginedTime;
    }

    public void setLoginedTime(Date loginedTime) {
        this.loginedTime = loginedTime;
    }

    @XmlTransient
    public Collection<Attendance> getAttendanceCollection() {
        return attendanceCollection;
    }

    public void setAttendanceCollection(Collection<Attendance> attendanceCollection) {
        this.attendanceCollection = attendanceCollection;
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
        hash += (loginID != null ? loginID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Logins)) {
            return false;
        }
        Logins other = (Logins) object;
        if ((this.loginID == null && other.loginID != null) || (this.loginID != null && !this.loginID.equals(other.loginID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Logins[ loginID=" + loginID + " ]";
    }
    
}
