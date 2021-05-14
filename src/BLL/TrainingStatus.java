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
@Table(name = "TrainingStatus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrainingStatus.findAll", query = "SELECT t FROM TrainingStatus t"),
    @NamedQuery(name = "TrainingStatus.findByTrainingStatusID", query = "SELECT t FROM TrainingStatus t WHERE t.trainingStatusID = :trainingStatusID"),
    @NamedQuery(name = "TrainingStatus.findByTraningStatusDescription", query = "SELECT t FROM TrainingStatus t WHERE t.traningStatusDescription = :traningStatusDescription")})
public class TrainingStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "trainingStatusID")
    @GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
    private Short trainingStatusID;
    @Basic(optional = false)
    @Column(name = "traningStatusDescription")
    private String traningStatusDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trainingStatus")
    private Collection<EmployeeTrainings> employeeTrainingsCollection;

    public TrainingStatus() {
    }

    public TrainingStatus(Short trainingStatusID) {
        this.trainingStatusID = trainingStatusID;
    }

    public TrainingStatus(Short trainingStatusID, String traningStatusDescription) {
        this.trainingStatusID = trainingStatusID;
        this.traningStatusDescription = traningStatusDescription;
    }

    public Short getTrainingStatusID() {
        return trainingStatusID;
    }

    public void setTrainingStatusID(Short trainingStatusID) {
        this.trainingStatusID = trainingStatusID;
    }

    public String getTraningStatusDescription() {
        return traningStatusDescription;
    }

    public void setTraningStatusDescription(String traningStatusDescription) {
        this.traningStatusDescription = traningStatusDescription;
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
        hash += (trainingStatusID != null ? trainingStatusID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrainingStatus)) {
            return false;
        }
        TrainingStatus other = (TrainingStatus) object;
        if ((this.trainingStatusID == null && other.trainingStatusID != null) || (this.trainingStatusID != null && !this.trainingStatusID.equals(other.trainingStatusID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.TrainingStatus[ trainingStatusID=" + trainingStatusID + " ]";
    }
    
}
