/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.TrainingTypes;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author BesaC
 */
public class TrainingTypesRepository extends EntMngClass implements TrainingTypesInterface {

    @Override
    public void create(TrainingTypes tt) throws TrainingTypesException {
        try {
            em.getTransaction().begin();
            em.persist(tt);
            em.getTransaction().commit();
        } catch (Throwable thro) {
            if (thro.getMessage().contains("2627")) {
                throw new TrainingTypesException("E dhena ekziston");
            } else {
                throw new TrainingTypesException("GABIM NE Create: " + thro.getClass() + "-" + thro.getMessage());
            }
        }
    }

    @Override
    public void edit(TrainingTypes tt) throws TrainingTypesException {
        try {
            em.getTransaction().begin();
            em.merge(tt);
            em.getTransaction().commit();
        } catch (Throwable thro) {
            if (thro.getMessage().contains("2627")) {
                throw new TrainingTypesException("E dhena ekziston");
            } else {
                throw new TrainingTypesException("Update: " + thro.getClass() + "-" + thro.getMessage());

            }
        }
    }

    @Override
    public void remove(TrainingTypes tt) throws TrainingTypesException {
        em.getTransaction().begin();
        em.remove(tt);
        em.getTransaction().commit();
    }

    @Override
    public List<TrainingTypes> findAll() throws TrainingTypesException {
    return (List<TrainingTypes>) em.createNamedQuery("TrainingTypes.findAll").getResultList();
        
    }

    @Override
    public TrainingTypes findById(Integer ID) throws TrainingTypesException {
      Query query = em.createQuery("SELECT t FROM TrainingTypes t WHERE t.trainingID = :trainingID");
        query.setParameter("trainingID", ID);
        
        try{
            return (TrainingTypes) query.getSingleResult();
        }catch(NoResultException nre){
            throw new TrainingTypesException("E dhena nuk ekziston");
        }
    }
}


