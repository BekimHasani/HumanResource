/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Holidays;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author BesaC
 */
public class HolidaysRepository extends EntMngClass implements HolidaysInterface {

    @Override
    public void create(Holidays rs) throws HolidaysException {
        try{
            em.getTransaction().begin();
            em.persist(rs);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                throw new HolidaysException("E dhena ekziston");
            }
            else{
                throw new HolidaysException("GABIM NE Create: " + thro.getClass() + "-" + thro.getMessage());
            }
        }
    }

    @Override
    public void edit(Holidays rs) throws HolidaysException {
        
        try{
            em.getTransaction().begin();
            em.merge(rs);
            em.getTransaction().commit();
        }catch (Throwable thro){
            if(thro.getMessage().contains("2627")){
                throw new HolidaysException("E dhena ekziston");
            }else{
                throw new HolidaysException("Update: " + thro.getClass() + "-" + thro.getMessage());
                       
            }
        }
    }

    @Override
    public void remove(Holidays rs) throws HolidaysException {
        em.getTransaction().begin();
        em.remove(rs);
        em.getTransaction().commit();
    }

    @Override
    public List<Holidays> findAll() throws HolidaysException {
        return (List<Holidays>) em.createNamedQuery("Holidays.findAll").getResultList();
    }

    @Override
    public Holidays findByID(Short id) throws HolidaysException {
        Query query = em.createQuery("SELECT h FROM Holidays h WHERE h.holidayID = :holidayID");
        query.setParameter("holidayID", id);
        
        try{
            return (Holidays) query.getSingleResult();
        }catch(NoResultException nre){
            throw new HolidaysException("E dhena nuk ekziston");
        }
    }

    @Override
    public List<Holidays> findByHolidayDescription(String description) throws HolidaysException {
        Query query = em.createQuery("SELECT h FROM Holidays h WHERE h.holidayDescription = :holidayDescription");
        query.setParameter("holidayDescription", description);
        
        try{
            return(List<Holidays>) query.getResultList();
        }catch(NoResultException nre){
            throw new HolidaysException("nuk ka asnje pushim me kete emertim ");
        }
    }
    
    
}
