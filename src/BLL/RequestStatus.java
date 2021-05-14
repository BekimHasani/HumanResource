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
@Table(name = "RequestStatus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RequestStatus.findAll", query = "SELECT r FROM RequestStatus r"),
    @NamedQuery(name = "RequestStatus.findByRequestStatusID", query = "SELECT r FROM RequestStatus r WHERE r.requestStatusID = :requestStatusID"),
    @NamedQuery(name = "RequestStatus.findByRequestStatusDescription", query = "SELECT r FROM RequestStatus r WHERE r.requestStatusDescription = :requestStatusDescription")})
public class RequestStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "requestStatusID")
    @GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
    private Short requestStatusID;
    @Basic(optional = false)
    @Column(name = "requestStatusDescription")
    private String requestStatusDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requestStatus")
    private Collection<Request> requestCollection;

    public RequestStatus() {
    }

    public RequestStatus(Short requestStatusID) {
        this.requestStatusID = requestStatusID;
    }

    public RequestStatus(Short requestStatusID, String requestStatusDescription) {
        this.requestStatusID = requestStatusID;
        this.requestStatusDescription = requestStatusDescription;
    }

    public Short getRequestStatusID() {
        return requestStatusID;
    }

    public void setRequestStatusID(Short requestStatusID) {
        this.requestStatusID = requestStatusID;
    }

    public String getRequestStatusDescription() {
        return requestStatusDescription;
    }

    public void setRequestStatusDescription(String requestStatusDescription) {
        this.requestStatusDescription = requestStatusDescription;
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
        hash += (requestStatusID != null ? requestStatusID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequestStatus)) {
            return false;
        }
        RequestStatus other = (RequestStatus) object;
        if ((this.requestStatusID == null && other.requestStatusID != null) || (this.requestStatusID != null && !this.requestStatusID.equals(other.requestStatusID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.RequestStatus[ requestStatusID=" + requestStatusID + " ]";
    }
    
}
