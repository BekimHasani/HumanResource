/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.LeaveTypes;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Bekim
 */
public class LeaveTypesRepository extends EntMngClass implements LeaveTypesInterface {
    @Override
    public void create(LeaveTypes lt) throws LeaveTypesException {
        try{
            em.getTransaction().begin();
            em.persist(lt);
            em.getTransaction().commit();
        } catch(Exception e){
            throw new LeaveTypesException("[LeaveTypesRepository]->create:"+ e.getMessage());
        }
    }

    @Override
    public void edit(LeaveTypes lt) throws LeaveTypesException {
        try{
            em.getTransaction().begin();
            em.merge(lt);
            em.getTransaction().commit();
        } catch(Exception e){
            throw new LeaveTypesException("[LeaveTypesRepository]->edit:"+ e.getMessage());
        }
    }

    @Override
    public void delete(LeaveTypes lt) throws LeaveTypesException {
        try{
            em.getTransaction().begin();
            em.remove(lt);
            em.getTransaction().commit();
        } catch(Exception e){
            throw new LeaveTypesException("[LeaveTypesRepository]->remove:"+ e.getMessage());
        }
    }

    @Override
    public List<LeaveTypes> findAll() throws LeaveTypesException {
        try{
            return em.createNamedQuery("LeaveTypes.findAll").getResultList(); 
        } catch(Exception e){
            throw new LeaveTypesException("[LeaveTypesRepository]->findAll:"+ e.getMessage());
        }
    }

    @Override
    public LeaveTypes findById(Integer ID) throws LeaveTypesException {
        try{
            Query query = em.createQuery("SELECT l FROM LeaveTypes l WHERE l.leaveID = :leaveID");
            query.setParameter("leaveID",ID);
            return (LeaveTypes) query.getSingleResult();
        }catch(Exception e){
            throw new LeaveTypesException("[LeaveTypesRepository]->findById:"+ e.getMessage());
        }
    }
}
