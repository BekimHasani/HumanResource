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
@Table(name = "Holidays")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Holidays.findAll", query = "SELECT h FROM Holidays h"),
    @NamedQuery(name = "Holidays.findByHolidayID", query = "SELECT h FROM Holidays h WHERE h.holidayID = :holidayID"),
    @NamedQuery(name = "Holidays.findByStartDate", query = "SELECT h FROM Holidays h WHERE h.startDate = :startDate"),
    @NamedQuery(name = "Holidays.findByEndDate", query = "SELECT h FROM Holidays h WHERE h.endDate = :endDate"),
    @NamedQuery(name = "Holidays.findByHolidayDescription", query = "SELECT h FROM Holidays h WHERE h.holidayDescription = :holidayDescription")})
public class Holidays implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "holidayID")
    @GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
    private Short holidayID;
    @Basic(optional = false)
    @Column(name = "startDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Basic(optional = false)
    @Column(name = "endDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Basic(optional = false)
    @Column(name = "holidayDescription")
    private String holidayDescription;

    public Holidays() {
    }

    public Holidays(Short holidayID) {
        this.holidayID = holidayID;
    }

    public Holidays(Short holidayID, Date startDate, Date endDate, String holidayDescription) {
        this.holidayID = holidayID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.holidayDescription = holidayDescription;
    }

    public Short getHolidayID() {
        return holidayID;
    }

    public void setHolidayID(Short holidayID) {
        this.holidayID = holidayID;
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

    public String getHolidayDescription() {
        return holidayDescription;
    }

    public void setHolidayDescription(String holidayDescription) {
        this.holidayDescription = holidayDescription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (holidayID != null ? holidayID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Holidays)) {
            return false;
        }
        Holidays other = (Holidays) object;
        if ((this.holidayID == null && other.holidayID != null) || (this.holidayID != null && !this.holidayID.equals(other.holidayID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Holidays[ holidayID=" + holidayID + " ]";
    }
    
}
