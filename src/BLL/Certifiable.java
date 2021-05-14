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
@Table(name = "Certifiable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Certifiable.findAll", query = "SELECT c FROM Certifiable c"),
    @NamedQuery(name = "Certifiable.findByCertifiableID", query = "SELECT c FROM Certifiable c WHERE c.certifiableID = :certifiableID"),
    @NamedQuery(name = "Certifiable.findByCertifiableDescription", query = "SELECT c FROM Certifiable c WHERE c.certifiableDescription = :certifiableDescription")})
public class Certifiable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "certifiableID")
    @GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
    private Short certifiableID;
    @Basic(optional = false)
    @Column(name = "certifiableDescription")
    private String certifiableDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "certified")
    private Collection<EmployeeTrainings> employeeTrainingsCollection;

    public Certifiable() {
    }

    public Certifiable(Short certifiableID) {
        this.certifiableID = certifiableID;
    }

    public Certifiable(Short certifiableID, String certifiableDescription) {
        this.certifiableID = certifiableID;
        this.certifiableDescription = certifiableDescription;
    }

    public Short getCertifiableID() {
        return certifiableID;
    }

    public void setCertifiableID(Short certifiableID) {
        this.certifiableID = certifiableID;
    }

    public String getCertifiableDescription() {
        return certifiableDescription;
    }

    public void setCertifiableDescription(String certifiableDescription) {
        this.certifiableDescription = certifiableDescription;
    }

    @XmlTransient
    public Collection<EmployeeTrainings> getEmployeeTrainingsCollection() {
        return employeeTrainingsCollection;
    }

    public void setEmployeeTrainingsCollection(Collection<EmployeeTrainings> employeeTrainingsCollection) {
        this.employeeTrainingsCollection = employeeTrainingsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (certifiableID != null ? certifiableID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Certifiable)) {
            return false;
        }
        Certifiable other = (Certifiable) object;
        if ((this.certifiableID == null && other.certifiableID != null) || (this.certifiableID != null && !this.certifiableID.equals(other.certifiableID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Certifiable[ certifiableID=" + certifiableID + " ]";
    }
    
}
