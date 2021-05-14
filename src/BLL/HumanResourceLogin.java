/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bekim
 */
@Entity
@Table(name = "HumanResourceLogin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HumanResourceLogin.findAll", query = "SELECT h FROM HumanResourceLogin h"),
    @NamedQuery(name = "HumanResourceLogin.findByLoginID", query = "SELECT h FROM HumanResourceLogin h WHERE h.loginID = :loginID"),
    @NamedQuery(name = "HumanResourceLogin.findByLoginUsername", query = "SELECT h FROM HumanResourceLogin h WHERE h.loginUsername = :loginUsername"),
    @NamedQuery(name = "HumanResourceLogin.findByLoginPassword", query = "SELECT h FROM HumanResourceLogin h WHERE h.loginPassword = :loginPassword")})
public class HumanResourceLogin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "loginID")
    @GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
    private Integer loginID;
    @Basic(optional = false)
    @Column(name = "loginUsername")
    private String loginUsername;
    @Basic(optional = false)
    @Column(name = "loginPassword")
    private String loginPassword;
    @JoinColumn(name = "Employee", referencedColumnName = "employeeID")
    @ManyToOne(optional = false)
    private Employee employee;

    public HumanResourceLogin() {
    }

    public HumanResourceLogin(Integer loginID) {
        this.loginID = loginID;
    }

    public HumanResourceLogin(Integer loginID, String loginUsername, String loginPassword) {
        this.loginID = loginID;
        this.loginUsername = loginUsername;
        this.loginPassword = loginPassword;
    }

    public Integer getLoginID() {
        return loginID;
    }

    public void setLoginID(Integer loginID) {
        this.loginID = loginID;
    }

    public String getLoginUsername() {
        return loginUsername;
    }

    public void setLoginUsername(String loginUsername) {
        this.loginUsername = loginUsername;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
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
        if (!(object instanceof HumanResourceLogin)) {
            return false;
        }
        HumanResourceLogin other = (HumanResourceLogin) object;
        if ((this.loginID == null && other.loginID != null) || (this.loginID != null && !this.loginID.equals(other.loginID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.HumanResourceLogin[ loginID=" + loginID + " ]";
    }
    
}
