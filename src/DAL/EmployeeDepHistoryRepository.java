/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.EmployeeDepartmentHistory;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Query;

/**
 *
 * @author Bekim
 */
@Entity
public class EmployeeDepHistoryRepository extends EntMngClass implements Serializable, EmployeeDepHistoryInterface {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeDepHistoryRepository)) {
            return false;
        }
        EmployeeDepHistoryRepository other = (EmployeeDepHistoryRepository) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAL.EmployeeDepHistoryRepository[ id=" + id + " ]";
    }

    @Override
    public void create(EmployeeDepartmentHistory ed) throws EmployeeDepHistoryException {
        try {
            em.getTransaction().begin();
            em.persist(ed);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new EmployeeDepHistoryException("Msg : /n" + ex.getMessage());
        }
    }

    @Override
    public void edit(EmployeeDepartmentHistory ed) throws EmployeeDepHistoryException {
        try {
            em.getTransaction().begin();
            em.merge(ed);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new EmployeeDepHistoryException("Msg :/n" + ex.getMessage());
        }
    }

    @Override
    public void delete(EmployeeDepartmentHistory ed) throws EmployeeDepHistoryException {
        try {
            em.getTransaction().begin();
            em.remove(ed);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new EmployeeDepHistoryException("Msg : /n" + ex.getMessage());
        }
    }

    @Override
    public List<EmployeeDepartmentHistory> findAll() throws EmployeeDepHistoryException {
        try {
            return em.createNamedQuery("EmployeeDepartmentHistory.findAll").getResultList();
        } catch (Exception ex) {
            throw new EmployeeDepHistoryException("Msg : /n" + ex.getMessage());
        }
    }

    @Override
    public EmployeeDepartmentHistory findById(Integer ID) throws EmployeeDepHistoryException {
        try{
            Query query = em.createQuery("SELECT e FROM EmployeeDepartmentHistory e WHERE e.departmentHistoriID = :departmentHistoriID");
            query.setParameter("DepartmentHistoryID", ID);
            return (EmployeeDepartmentHistory) query.getSingleResult() ;
        }catch(Exception ex){
            throw new EmployeeDepHistoryException("Msg : /n" + ex.getMessage());
        }
    }

}
