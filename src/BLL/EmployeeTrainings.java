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
 * @author Bekim
 */
@Entity
@Table(name = "EmployeeTrainings")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeTrainings.findAll", query = "SELECT e FROM EmployeeTrainings e"),
    @NamedQuery(name = "EmployeeTrainings.findByEmployeeTrainingId", query = "SELECT e FROM EmployeeTrainings e WHERE e.employeeTrainingId = :employeeTrainingId"),
    @NamedQuery(name = "EmployeeTrainings.findByStartDate", query = "SELECT e FROM EmployeeTrainings e WHERE e.startDate = :startDate"),
    @NamedQuery(name = "EmployeeTrainings.findByEndDate", query = "SELECT e FROM EmployeeTrainings e WHERE e.endDate = :endDate")})
public class EmployeeTrainings implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "employeeTrainingId")
    @GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
    private Integer employeeTrainingId;
    @Basic(optional = false)
    @Column(name = "startDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Basic(optional = false)
    @Column(name = "endDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeTraining")
    private Collection<EmplooyeeTrainingAttendance> emplooyeeTrainingAttendanceCollection;
    @JoinColumn(name = "Certified", referencedColumnName = "certifiableID")
    @ManyToOne(optional = false)
    private Certifiable certified;
    @JoinColumn(name = "Employee", referencedColumnName = "employeeID")
    @ManyToOne(optional = false)
    private Employee employee;
    @JoinColumn(name = "TrainingStatus", referencedColumnName = "trainingStatusID")
    @ManyToOne(optional = false)
    private TrainingStatus trainingStatus;
    @JoinColumn(name = "Training", referencedColumnName = "trainingID")
    @ManyToOne(optional = false)
    private TrainingTypes training;

    public EmployeeTrainings() {
    }

    public EmployeeTrainings(Integer employeeTrainingId) {
        this.employeeTrainingId = employeeTrainingId;
    }

    public EmployeeTrainings(Integer employeeTrainingId, Date startDate, Date endDate) {
        this.employeeTrainingId = employeeTrainingId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getEmployeeTrainingId() {
        return employeeTrainingId;
    }

    public void setEmployeeTrainingId(Integer employeeTrainingId) {
        this.employeeTrainingId = employeeTrainingId;
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

    @XmlTransient
    public Collection<EmplooyeeTrainingAttendance> getEmplooyeeTrainingAttendanceCollection() {
        return emplooyeeTrainingAttendanceCollection;
    }

    public void setEmplooyeeTrainingAttendanceCollection(Collection<EmplooyeeTrainingAttendance> emplooyeeTrainingAttendanceCollection) {
        this.emplooyeeTrainingAttendanceCollection = emplooyeeTrainingAttendanceCollection;
    }

    public Certifiable getCertified() {
        return certified;
    }

    public void setCertified(Certifiable certified) {
        this.certified = certified;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public TrainingStatus getTrainingStatus() {
        return trainingStatus;
    }

    public void setTrainingStatus(TrainingStatus trainingStatus) {
        this.trainingStatus = trainingStatus;
    }

    public TrainingTypes getTraining() {
        return training;
    }

    public void setTraining(TrainingTypes training) {
        this.training = training;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeTrainingId != null ? employeeTrainingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeTrainings)) {
            return false;
        }
        EmployeeTrainings other = (EmployeeTrainings) object;
        if ((this.employeeTrainingId == null && other.employeeTrainingId != null) || (this.employeeTrainingId != null && !this.employeeTrainingId.equals(other.employeeTrainingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.EmployeeTrainings[ employeeTrainingId=" + employeeTrainingId + " ]";
    }
    
}
