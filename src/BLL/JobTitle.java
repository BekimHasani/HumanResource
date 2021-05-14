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
@Table(name = "JobTitle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JobTitle.findAll", query = "SELECT j FROM JobTitle j"),
    @NamedQuery(name = "JobTitle.findByJobTitleID", query = "SELECT j FROM JobTitle j WHERE j.jobTitleID = :jobTitleID"),
    @NamedQuery(name = "JobTitle.findByJobTitleDescription", query = "SELECT j FROM JobTitle j WHERE j.jobTitleDescription = :jobTitleDescription"),
    @NamedQuery(name = "JobTitle.findByJobTitleStatus", query = "SELECT j FROM JobTitle j WHERE j.jobTitleStatus = :jobTitleStatus")})
public class JobTitle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "jobTitleID")
    @GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
    private Short jobTitleID;
    @Basic(optional = false)
    @Column(name = "jobTitleDescription")
    private String jobTitleDescription;
    @Basic(optional = false)
    @Column(name = "jobTitleStatus")
    private boolean jobTitleStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobTitle")
    private Collection<Employee> employeeCollection;

    public JobTitle() {
    }

    public JobTitle(Short jobTitleID) {
        this.jobTitleID = jobTitleID;
    }

    public JobTitle(Short jobTitleID, String jobTitleDescription, boolean jobTitleStatus) {
        this.jobTitleID = jobTitleID;
        this.jobTitleDescription = jobTitleDescription;
        this.jobTitleStatus = jobTitleStatus;
    }

    public Short getJobTitleID() {
        return jobTitleID;
    }

    public void setJobTitleID(Short jobTitleID) {
        this.jobTitleID = jobTitleID;
    }

    public String getJobTitleDescription() {
        return jobTitleDescription;
    }

    public void setJobTitleDescription(String jobTitleDescription) {
        this.jobTitleDescription = jobTitleDescription;
    }

    public boolean getJobTitleStatus() {
        return jobTitleStatus;
    }

    public void setJobTitleStatus(boolean jobTitleStatus) {
        this.jobTitleStatus = jobTitleStatus;
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
        hash += (jobTitleID != null ? jobTitleID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JobTitle)) {
            return false;
        }
        JobTitle other = (JobTitle) object;
        if ((this.jobTitleID == null && other.jobTitleID != null) || (this.jobTitleID != null && !this.jobTitleID.equals(other.jobTitleID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return jobTitleDescription;
    }
    
}
