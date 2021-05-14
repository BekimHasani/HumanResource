/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Request;
import java.util.List;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author Armend
 */
public class RequestRepository extends EntMngClass implements RequestInterface {

    @Override
    public void create(Request r) throws RequestException {
        try {
            em.getTransaction().begin();
            em.persist(r);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RequestException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public void edit(Request r) throws RequestException {
        try {
            em.getTransaction().begin();
            em.merge(r);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RequestException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Request r) throws RequestException {
        try {
            em.getTransaction().begin();
            em.remove(r);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RequestException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public List<Request> findAll() throws RequestException {
        try {
            return em.createNamedQuery("Request.findAll").getResultList();
        } catch (Exception ex) {
            throw new RequestException("Msg : /n" + ex.getMessage());
        }

    }

    @Override
    public Request findById(Integer ID) throws RequestException {
        try {
            Query query = em.createNamedQuery("Request.findByRequestID");
            query.setParameter("requestID", ID);
            return (Request) query.getSingleResult();
        } catch (Exception e) {
             throw new RequestException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public List<Request> getPendingHr() throws RequestException {
        try {
            Query query = em.createQuery("SELECT r FROM Request r LEFT JOIN r.requestStatus rs WHERE rs.requestStatusID = :rsID ");
            query.setParameter("rsID", 2);
            return query.getResultList();
        } catch (Exception e) {
            throw new RequestException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public List<Integer> findEmployeeRequests(int employeeId ,String str) throws RequestException {
        try {
            Query query = em.createNativeQuery("select * from udf_findEmployeeRequests(?,?)");
            query.setParameter(1, employeeId);
            query.setParameter(2,str);
            return query.getResultList();
        } catch (Exception e) {
            throw new RequestException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public List<Request> getPendingDirector() throws RequestException {
        try {
            Query query = em.createQuery("select r from Request r left join r.requestStatus rs where rs.requestStatusID = 1 ");
            return query.getResultList();
        } catch (Exception e) {
            throw new RequestException("Msg! \n" + e.getMessage());
        }
    }
    
}
