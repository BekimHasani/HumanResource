/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.RequestStatus;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author USER
 */
public class RequestStatusRepository extends EntMngClass implements RequestStatusInterface {

    @Override
    public void create(RequestStatus rs) throws RequestStatusException {
        try {
            em.getTransaction().begin();
            em.persist(rs);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RequestStatusException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public void edit(RequestStatus rs) throws RequestStatusException {
        try {
            em.getTransaction().begin();
            em.merge(rs);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RequestStatusException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public void delete(RequestStatus rs) throws RequestStatusException {
        try {
            em.getTransaction().begin();
            em.remove(rs);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RequestStatusException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public List<RequestStatus> findAll() throws RequestStatusException {
        try {
            return em.createNamedQuery("RequestStatus.findAll").getResultList();
        } catch (Exception e) {
            throw new RequestStatusException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public RequestStatus findByID(Integer ID) throws RequestStatusException {
        try {
            Query query = em.createQuery("SELECT r FROM RequestStatus r WHERE r.requestStatusID = :requestStatusID");
            query.setParameter("requestStatusID", ID);
            return (RequestStatus) query.getSingleResult();
        } catch (Exception e) {
            throw new RequestStatusException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public RequestStatus getPending() throws RequestStatusException {
        try {
            Query query = em.createQuery("SELECT r FROM RequestStatus r WHERE r.requestStatusID = :requestStatusID");
            query.setParameter("requestStatusID", 1);
            return (RequestStatus) query.getSingleResult();
        } catch (Exception e) {
            throw new RequestStatusException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public RequestStatus getPendingHR() throws RequestStatusException {
        try {
            Query query = em.createQuery("SELECT r FROM RequestStatus r WHERE r.requestStatusID = :requestStatusID");
            query.setParameter("requestStatusID", 2);
            return (RequestStatus) query.getSingleResult();
        } catch (Exception e) {
            throw new RequestStatusException("Msg! \n" + e.getMessage());
        }
    }

}
