/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.EmployeeLeaves;
import java.util.List;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author Armend
 */
public class EmployeeLeavesRepository extends EntMngClass implements EmployeeLeavesInterface {

    @Override
    public void create(EmployeeLeaves el) throws EmployeeLeavesException {
        try {
            em.getTransaction().begin();
            em.persist(el);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new EmployeeLeavesException("[EmployeeLeavesRepository]->create: " + e.getMessage());
        }
    }

    @Override
    public void edit(EmployeeLeaves el) throws EmployeeLeavesException {
        try {
            em.getTransaction().begin();
            em.merge(el);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new EmployeeLeavesException("[EmployeeLeavesRepository]->edit: " + e.getMessage());
        }
    }

    @Override
    public void delete(EmployeeLeaves el) throws EmployeeLeavesException {
        try {
            em.getTransaction().begin();
            em.remove(el);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new EmployeeLeavesException("[EmployeeLeavesRepository]->delete: " + e.getMessage());
        }
    }

    @Override
    public List<EmployeeLeaves> findAll() throws EmployeeLeavesException {
        try {
            return em.createNamedQuery("EmployeeLeaves.findAll").getResultList();
        } catch (Exception e) {
            throw new EmployeeLeavesException("[EmployeeLeavesRepository]->findAll: " + e.getMessage());
        }
    }

    @Override
    public EmployeeLeaves findById(Integer ID) throws EmployeeLeavesException {
        try {
            Query query = em.createNamedQuery("EmployeeLeaves.findByEmployeeLeaveID");
            query.setParameter("employeeLeaveID", ID);
            return (EmployeeLeaves) query.getSingleResult();
        } catch (Exception e) {
            throw new EmployeeLeavesException("[EmployeeLeavesRepository]->findById: " + e.getMessage());
        }
    }

    @Override
    public List<EmployeeLeaves> findByLeave(short ID) throws EmployeeLeavesException {
        try {
            Query query = em.createQuery("SELECT el FROM EmployeeLeaves el left join el.leave lt WHERE lt.leaveID = :ltID AND el.employeeLeavesStatus = :els");
            query.setParameter("ltID", ID);
            query.setParameter("els", true);
            return query.getResultList();
        } catch (Exception e) {
            throw new EmployeeLeavesException("[EmployeeLeavesRepository]->findByLeave: " + e.getMessage());
        }
    }
    
    @Override 
    public List<EmployeeLeaves> findActive() throws EmployeeLeavesException{
        try {
            Query query = em.createQuery("SELECT el FROM EmployeeLeaves el  WHERE  el.employeeLeavesStatus = :els");
            query.setParameter("els", true);
            return query.getResultList();
        } catch (Exception e) {
            throw new EmployeeLeavesException("[EmployeeLeavesRepository]->findByLeave: " + e.getMessage());
        }
    }
    
    @Override
    public List<Integer> searchEmployeeLeavesHR(String str) throws EmployeeLeavesException {
        try {
            Query query = em.createNativeQuery("searchEmployeeLeaves_udspHR ? ");
            query.setParameter(1, str);
            return query.getResultList();
        } catch (Exception e) {
            throw new EmployeeLeavesException("[EmployeeLeavesRepository]->searchEmployeeLeavesHR: " + e.getMessage());
        }
    }

    @Override
    public List<Integer> searchEmployeeLeavesCEO(String str) throws EmployeeLeavesException {
        try {
            Query query = em.createNativeQuery("select * from udf_searchEmployeeLeavesCEO(?) ");
            query.setParameter(1, str);
            return query.getResultList();
        } catch (Exception e) {
            throw new EmployeeLeavesException("[EmployeeLeavesRepository]->searchEmployeeLeavesCEO: " + e.getMessage());
        }
    }

    @Override
    public List<Integer> searchEmployeeLeavesDIR(String str) throws EmployeeLeavesException {
        try {
            Query query = em.createNativeQuery("select * from udf_searchEmployeeLeavesDIR(?) ");
            query.setParameter(1, str);
            return query.getResultList();
        } catch (Exception e) {
            throw new EmployeeLeavesException("[EmployeeLeavesRepository]->searchEmployeeLeavesDIR: " + e.getMessage());
        }
    }

}
