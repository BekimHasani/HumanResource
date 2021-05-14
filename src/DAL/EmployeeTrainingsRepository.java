/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Certifiable;
import BLL.Department;
import BLL.Employee;
import BLL.EmployeeTrainings;
import BLL.TrainingStatus;
import BLL.TrainingTypes;
import java.util.Date;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.swing.JOptionPane;

/**
 *
 * @author BesaC
 */
public class EmployeeTrainingsRepository extends EntMngClass implements EmployeeTrainingsInterface {

    @Override
    public void create(EmployeeTrainings et) throws EmployeeTrainingsException {
        try {
            em.getTransaction().begin();
            em.persist(et);
            em.getTransaction().commit();
        } catch (Throwable thro) {
            if (thro.getMessage().contains("2627")) {
                throw new EmployeeTrainingsException("E dhena ekziston");
            } else {
                throw new EmployeeTrainingsException("Gabim ne Create: " + thro.getMessage());
            }
        }
    }

    @Override
    public void edit(EmployeeTrainings et) throws EmployeeTrainingsException {
        try {
            em.getTransaction().begin();
            em.merge(et);
            em.getTransaction().commit();
        } catch (Throwable thro) {
            if (thro.getMessage().contains("2627")) {
                throw new EmployeeTrainingsException("e dhena ekziston");
            } else {
                throw new EmployeeTrainingsException("Gabim ne Update " + thro.getMessage());
            }
        }
    }

    @Override
    public void remove(EmployeeTrainings et) throws EmployeeTrainingsException {

        em.getTransaction().begin();
        em.remove(et);
        em.getTransaction().commit();
    }

    @Override
    public List<EmployeeTrainings> findAll() throws EmployeeTrainingsException {
        try{
            return (List<EmployeeTrainings>) em.createNamedQuery("EmployeeTrainings.findAll").getResultList();
        }catch(NullPointerException ex){
           throw new EmployeeTrainingsException("NULLLLLLL");
        }
    }
    
    @Override
    public EmployeeTrainings findById(Integer id) throws EmployeeTrainingsException {
        Query query = em.createQuery("SELECT e FROM EmployeeTrainings e WHERE e.employeeTrainingId = :employeeTrainingId");
        query.setParameter("employeeTrainingId", id);
        
        try {
            return (EmployeeTrainings) query.getSingleResult();
        } catch (NoResultException nre) {
            throw new EmployeeTrainingsException("e dhena nuk ekziston");
        }
    }

    @Override
    public List<EmployeeTrainings> findByEmployeeName(Employee e) throws EmployeeTrainingsException {
        Query query = em.createQuery("SELECT e FROM EmployeeTrainings e WHERE e.employee = :employee");
        query.setParameter("employee", e);

        try {
            return (List<EmployeeTrainings>) query.getResultList();

        } catch (NoResultException nre) {
            throw new EmployeeTrainingsException("Nuk ka asnje punetor me kete emer");
        }
    }

    @Override
    public List<EmployeeTrainings> findByEmployeeTrainingStatus(TrainingStatus ts) throws EmployeeTrainingsException {
        Query query = em.createQuery("SELECT e FROM EmployeeTrainings e WHERE e.trainingStatus = :trainingStatus");
        query.setParameter("trainingStatus", ts);

        try {
            return (List<EmployeeTrainings>) query.getResultList();
        } catch (NoResultException nre) {
            throw new EmployeeTrainingsException("Nuk ekziston ky trajnim");
        }
    }

    @Override
    public List<EmployeeTrainings> findByCertifiable(Certifiable c) throws EmployeeTrainingsException {
        Query query = em.createQuery("SELECT e FROM EmployeeTrainings e WHERE e.certified = :certified");
        query.setParameter("certified", c);

        try {
            return (List<EmployeeTrainings>) query.getResultList();
        } catch (NoResultException nre) {
            throw new EmployeeTrainingsException("Nuk ekziston kjo e dhene");
        }
    }

    @Override
    public List<EmployeeTrainings> findByStartDate(Date startDate) throws EmployeeTrainingsException {
        Query query = em.createQuery("SELECT e FROM EmployeeTrainings e WHERE e.startDate = :startDate");
        query.setParameter("starDate", startDate);

        try {
            return (List<EmployeeTrainings>) query.getResultList();
        } catch (NoResultException nre) {
            throw new EmployeeTrainingsException("Nuk ekziston kjo e dhene");
        }        
    }

    @Override
    public List<EmployeeTrainings> findByEndDate(Date endDate) throws EmployeeTrainingsException {
        Query query = em.createQuery("SELECT e FROM EmployeeTrainings e WHERE e.endDate = :endDate");
        query.setParameter("endDate", endDate);

        try {
            return (List<EmployeeTrainings>) query.getResultList();
        } catch (NoResultException nre) {
            throw new EmployeeTrainingsException("Nuk ekziston kjo e dhene");
        }          
    }

    @Override
    public List<EmployeeTrainings> findByEmployeeTraining(TrainingTypes tt) throws EmployeeTrainingsException {
        Query query = em.createQuery("SELECT e FROM EmployeeTrainings e WHERE e.training = :training");
        query.setParameter("training", tt);
        
        try{
            return (List<EmployeeTrainings>) query.getResultList();
        }
        catch(NoResultException nre){
            throw new EmployeeTrainingsException("Nuk ekziston kjo e dhene");
        }
    }
    
    @Override
    public List <Integer> search(String str) throws EmployeeTrainingsException {       
        Query query = em.createNativeQuery("searchEmployeeTraining_sp ?");
        query.setParameter(1,  str);
        
        try{
            return query.getResultList();
        }catch(NoResultException nre){
            throw new EmployeeTrainingsException("Theres no results"); // searchs into employeeTrainings records, taking a string as a prameter
        }
   }
    
    @Override
    public List<Integer> findValidEmployeesForTraining(Short id) {
        Query query = em.createNamedQuery("findForTraining_sp ?");
        query.setParameter(1, id);
        
            return (List<Integer>)query.getResultList(); //returns List of IDs of employees that are valid for trainings
        
    }
    
    @Override
    public Department findEmployeeDepartment (int empID){
        Query query = em.createNamedQuery("findEmployeeDepartment ?");
        query.setParameter(1, empID);
        
        return (Department) query.getSingleResult(); //Returns the department of an Employee(taking and id as a parameter)
    }
}
