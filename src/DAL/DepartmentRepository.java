/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Department;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Bekim
 */
public class DepartmentRepository extends EntMngClass implements DepartmentInterface {

    @Override
    public void create(Department eps) throws DepartmentException {
        try{
            em.getTransaction().begin() ;
            em.persist(eps);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new DepartmentException("Msg :/n"+ e.getMessage());                 
        }
    }

    @Override
    public void edit(Department eps) throws DepartmentException {
        try{
            em.getTransaction().begin();
            em.merge(eps);
            em.getTransaction().commit();
        } catch(Exception e){
            throw new DepartmentException("Msg :/n"+ e.getMessage());
        }
    }

    @Override
    public void delete(Department eps) throws DepartmentException {
        try{
            em.getTransaction().begin();
            em.remove(eps);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new DepartmentException("Msg :/n"+ e.getMessage());
        }
    }

    @Override
    public List<Department> findAll() throws DepartmentException {
        try{
            return em.createNamedQuery("Department.findAll").getResultList();
        } catch(Exception e){
            throw new DepartmentException("Msg :\n"+ e.getMessage());
        }
    }

    @Override
    public Department findById(Integer ID) throws DepartmentException {
        try{
           Query query = em.createQuery("SELECT d FROM Department d WHERE d.departmentID = :departmentID");
           query.setParameter("departmentID" , ID);
           return(Department) query.getSingleResult();
       }catch(Exception e){
            throw new DepartmentException("Msg: /n"+ e.getMessage());
        }
    }
    
}
