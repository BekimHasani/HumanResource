/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.TrainingStatus;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author BesaC
 */
public class TrainingStatusRepository extends EntMngClass implements TrainingStatusInterface{

    @Override
    public void create(TrainingStatus ts) throws TrainingStatusException {
        try{
            em.getTransaction().begin();
            em.persist(ts);
            em.getTransaction().commit();
        }catch(Throwable thro ){
            if(thro.getMessage().contains("2627")){
                throw new TrainingStatusException("E dhena tashme ekziston");
            }
            else{
                throw new TrainingStatusException ("Gabim ne Create:" + thro.getClass() + "-" + thro.getMessage());
            }
        }
    }

    @Override
    public void edit(TrainingStatus ts) throws TrainingStatusException {
        try{
            em.getTransaction().begin();
            em.merge(ts);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                throw new TrainingStatusException("E dhena tashme ekziston");
            }
            else{
                throw new TrainingStatusException ("Update: " + thro.getClass() + "-" + thro.getMessage());
            }
        }
    }

    @Override
    public void remove(TrainingStatus ts) throws TrainingStatusException {
        
        em.getTransaction().begin();
        em.remove(ts);
        em.getTransaction().commit();
    }

    @Override
    public List<TrainingStatus> findAll() throws TrainingStatusException {
        return (List<TrainingStatus>) em.createNamedQuery("TrainingStatus.findAll").getResultList();
    }

    @Override
    public TrainingStatus findById(Short id) throws TrainingStatusException {
        
        Query query = em.createQuery("SELECT t FROM TrainingStatus t WHERE t.trainingStatusID = :trainingStatusID");
            query.setParameter("trainingStatusID", id);
            
            try{
                return (TrainingStatus) query.getSingleResult();
            }catch(NoResultException nre){
                throw new TrainingStatusException("E dhena nuk ekziston");
            }
    }
    
    
}
