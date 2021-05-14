/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Employee;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Armend
 */
public class EmployeeRepository extends EntMngClass implements EmployeeInterface {

    @Override
    public void create(Employee eps) throws EmployeeException {
        try{
            em.getTransaction().begin() ;
            em.persist(eps);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new EmployeeException("Msg :/n"+ e.getMessage());                 
        }
    }

    @Override
    public void edit(Employee eps) throws EmployeeException {
        try{
            em.getTransaction().begin();
            em.merge(eps);
            em.getTransaction().commit();
        } catch(Exception e){
            throw new EmployeeException("Msg :/n"+ e.getMessage());
        }
    }

    @Override
    public void delete(Employee eps) throws EmployeeException {
        try{
            em.getTransaction().begin();
            em.remove(eps);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new EmployeeException("Msg :/n"+ e.getMessage());
        }
    }

    @Override
    public List<Employee> findAll() throws EmployeeException {
        try{
            return em.createNamedQuery("Employee.findAll").getResultList();
        } catch(Exception e){
            throw new EmployeeException("Msg :/n"+ e.getMessage());
        }
    }

    @Override
    public Employee findById(Integer ID) throws EmployeeException {
        try{
           Query query = em.createNamedQuery("Employee.findByEmployeeID");
           query.setParameter("employeeID" , ID);
           return(Employee) query.getSingleResult();
       }catch(Exception e){
            throw new EmployeeException("Msg: /n"+ e.getMessage());
        }
    }
     public List<Employee> findEmployees() throws EmployeeException {
        try{
           Query query = em.createQuery("Select e from Employee e left join e.employeeStatus es where es.employeeStatusID = 1");
           return query.getResultList();
       }catch(Exception e){
            throw new EmployeeException("Msg: /n"+ e.getMessage());
        }
    }
   
}
