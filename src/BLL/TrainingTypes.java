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
@Table(name = "TrainingTypes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrainingTypes.findAll", query = "SELECT t FROM TrainingTypes t"),
    @NamedQuery(name = "TrainingTypes.findByTrainingID", query = "SELECT t FROM TrainingTypes t WHERE t.trainingID = :trainingID"),
    @NamedQuery(name = "TrainingTypes.findByTrainingDescription", query = "SELECT t FROM TrainingTypes t WHERE t.trainingDescription = :trainingDescription"),
    @NamedQuery(name = "TrainingTypes.findByCertifiable", query = "SELECT t FROM TrainingTypes t WHERE t.certifiable = :certifiable")})
public class TrainingTypes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "trainingID")
    @GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
    private Integer trainingID;
    @Basic(optional = false)
    @Column(name = "trainingDescription")
    private String trainingDescription;
    @Basic(optional = false)
    @Column(name = "certifiable")
    private boolean certifiable;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "training")
    private Collection<EmployeeTrainings> employeeTrainingsCollection;

    public TrainingTypes() {
    }

    public TrainingTypes(Integer trainingID) {
        this.trainingID = trainingID;
    }

    public TrainingTypes(Integer trainingID, String trainingDescription, boolean certifiable) {
        this.trainingID = trainingID;
        this.trainingDescription = trainingDescription;
        this.certifiable = certifiable;
    }

    public Integer getTrainingID() {
        return trainingID;
    }

    public void setTrainingID(Integer trainingID) {
        this.trainingID = trainingID;
    }

    public String getTrainingDescription() {
        return trainingDescription;
    }

    public void setTrainingDescription(String trainingDescription) {
        this.trainingDescription = trainingDescription;
    }

    public boolean getCertifiable() {
        return certifiable;
    }

    public void setCertifiable(boolean certifiable) {
        this.certifiable = certifiable;
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
        hash += (trainingID != null ? trainingID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrainingTypes)) {
            return false;
        }
        TrainingTypes other = (TrainingTypes) object;
        if ((this.trainingID == null && other.trainingID != null) || (this.trainingID != null && !this.trainingID.equals(other.trainingID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.TrainingTypes[ trainingID=" + trainingID + " ]";
    }
    
}
