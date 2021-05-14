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
@Table(name = "EmployeeStatus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeStatus.findAll", query = "SELECT e FROM EmployeeStatus e"),
    @NamedQuery(name = "EmployeeStatus.findByEmployeeStatusID", query = "SELECT e FROM EmployeeStatus e WHERE e.employeeStatusID = :employeeStatusID"),
    @NamedQuery(name = "EmployeeStatus.findByEmployeeStatusDescription", query = "SELECT e FROM EmployeeStatus e WHERE e.employeeStatusDescription = :employeeStatusDescription")})
public class EmployeeStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "employeeStatusID")
    @GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
    private Short employeeStatusID;
    @Basic(optional = false)
    @Column(name = "employeeStatusDescription")
    private String employeeStatusDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeStatus")
    private Collection<Employee> employeeCollection;

    public EmployeeStatus() {
    }

    public EmployeeStatus(Short employeeStatusID) {
        this.employeeStatusID = employeeStatusID;
    }

    public EmployeeStatus(Short employeeStatusID, String employeeStatusDescription) {
        this.employeeStatusID = employeeStatusID;
        this.employeeStatusDescription = employeeStatusDescription;
    }

    public Short getEmployeeStatusID() {
        return employeeStatusID;
    }

    public void setEmployeeStatusID(Short employeeStatusID) {
        this.employeeStatusID = employeeStatusID;
    }

    public String getEmployeeStatusDescription() {
        return employeeStatusDescription;
    }

    public void setEmployeeStatusDescription(String employeeStatusDescription) {
        this.employeeStatusDescription = employeeStatusDescription;
    }

    @XmlTransient
    public Collection<Employee> getEmployeeCollection() {
        return employeeCollection;
    }

    public void setEmployeeCollection(Collection<Employee> employeeCollection) {
        this.employeeCollection = employeeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeStatusID != null ? employeeStatusID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeStatus)) {
            return false;
        }
        EmployeeStatus other = (EmployeeStatus) object;
        if ((this.employeeStatusID == null && other.employeeStatusID != null) || (this.employeeStatusID != null && !this.employeeStatusID.equals(other.employeeStatusID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return employeeStatusDescription;
    }
    
}
