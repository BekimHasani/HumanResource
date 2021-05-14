/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.EmployeeStatus;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Armend
 */
public class EmployeeStatusRepository extends EntMngClass implements EmployeeStatusInterface {

    @Override
    public void create(EmployeeStatus es) throws EmployeeStatusException {
        try{
            em.getTransaction().begin();
            em.persist(es);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new EmployeeStatusException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public void edit(EmployeeStatus es) throws EmployeeStatusException {
        try{
            em.getTransaction().begin();
            em.merge(es);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new EmployeeStatusException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public void delete(EmployeeStatus es) throws EmployeeStatusException {
        try{
            em.getTransaction().begin();
            em.remove(es);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new EmployeeStatusException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public List<EmployeeStatus> findAll() throws EmployeeStatusException {
        try{
            return em.createNamedQuery("EmployeeStatus.findAll").getResultList();
        }catch(Exception e){
            throw new EmployeeStatusException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public EmployeeStatus findByID(Integer ID) {
        Query query = em.createQuery("SELECT e FROM EmployeeStatus e WHERE e.employeeStatusID = :employeeStatusID");
        query.setParameter("employeeStatusID",ID);
        return (EmployeeStatus)query.getSingleResult();
    }
    
}
