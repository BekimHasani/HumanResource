/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Logins;
import GUI.Utility;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Armend
 */
public class LoginsRepository extends EntMngClass implements LoginsInterface {

    @Override
    public void create(Logins l) throws LoginsException {
        try {
            em.getTransaction().begin();
            em.persist(l);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new LoginsException("[LoginRepository]->create:" + e.getMessage());
        }
    }

    @Override
    public void edit(Logins l) throws LoginsException {
        try {
            em.getTransaction().begin();
            em.merge(l);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new LoginsException("[LoginRepository]->edit:" + e.getMessage());
        }
    }

    @Override
    public void delete(Logins l) throws LoginsException {
        try {
            em.getTransaction().begin();
            em.remove(l);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new LoginsException("[LoginRepository]->delete:" + e.getMessage());
        }
    }

    @Override
    public List<Logins> findAll() throws LoginsException {
        try {
            return em.createNamedQuery("Logins.findAll").getResultList();
        } catch (Exception e) {
            throw new LoginsException("[LoginRepository]->findAll:" + e.getMessage());
        }
    }

    @Override
    public Logins findById(Integer ID) throws LoginsException {
        try {
            Query query = em.createQuery("SELECT l FROM Logins l WHERE l.loginID = :loginID");
            query.setParameter("loginID", ID);
            return (Logins) query.getSingleResult();
        } catch (Exception e) {
            throw new LoginsException("[LoginRepository]->findById:" + e.getMessage());
        }
    }

    @Override
    public List<Logins> findByEmployeeId(Integer ID) throws LoginsException {
        try {
            Query query = em.createQuery("SELECT l FROM Logins l left join l.employee e WHERE e.employeeID = :employeeID");
            query.setParameter("employeeID", ID);
            return query.getResultList();
        } catch (Exception e) {
            throw new LoginsException("[LoginRepository]->findByEmployeeId:" + e.getMessage());
        }
    }

    @Override
    public Integer findLogin(int employeeID) throws LoginsException {
        try{
            Query query = em.createNativeQuery("select * from udf_findLogin(?)");
            query.setParameter(1,employeeID);
            return (Integer)query.getSingleResult();
        }catch(Exception e){
            throw new LoginsException("[LoginRepository]->findLogin:" + e.getMessage());
        }
    }

    @Override
    public List<Integer> searchEmployeeLoginsHR(String str) throws LoginsException {
        try{
            Query query = em.createNativeQuery("select * from udf_searchEmployeeLoginsHR(?)");
            query.setParameter(1,str);
            return query.getResultList();
        }catch(Exception e){
            throw new LoginsException("[LoginRepository]->searchEmployeeLoginsHR:" + e.getMessage());
        }
    }

    @Override
    public List<Integer> searchEmployeeLoginsCEO(String str) throws LoginsException {
        try{
            Query query = em.createNativeQuery("select * from udf_searchEmployeeLoginsCEO(?)");
            query.setParameter(1,str);
            return query.getResultList();
        }catch(Exception e){
            throw new LoginsException("[LoginRepository]->searchEmployeeLoginsCEO:" + e.getMessage());
        }
    }

    @Override
    public List<Integer> searchEmployeeLoginsDIR(String str) throws LoginsException {
        try{
            Query query = em.createNativeQuery("select * from udf_searchEmployeeLoginsDIR(?)");
            query.setParameter(1,str);
            return query.getResultList();
        }catch(Exception e){
            throw new LoginsException("[LoginRepository]->searchEmployeeLoginsDIR:" + e.getMessage());
        }
    }
    
    public List<Logins> getTodayLogins(int employeeID) throws LoginsException {
        try{
            Query query = em.createQuery("select l from Logins l where l.employee = :employee AND l.loginDate = :loginDate");
            query.setParameter("loginDate",Utility.toDate(LocalDate.now()));
            query.setParameter("employee",employeeID);
            return query.getResultList();
        }catch(Exception e){
            throw new LoginsException("[LoginRepository]->searchEmployeeLoginsDIR:" + e.getMessage());
        }
    }
    
    
    
}
