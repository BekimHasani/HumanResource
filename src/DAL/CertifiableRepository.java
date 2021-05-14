/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Certifiable;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Bekim
 */
public class CertifiableRepository extends EntMngClass implements CertifiableInterface{
    
    @Override
    public void create(Certifiable c) throws CertifiableException {
        try{
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        }catch(Exception e) {
            throw new CertifiableException("Msg! \n"+ e.getMessage());
        }
    }

    @Override
    public void edit(Certifiable c) throws CertifiableException {
        try{
            em.getTransaction().begin();
            em.merge(c);
            em.getTransaction().commit();
        }catch(Exception e) {
            throw new CertifiableException("Msg! \n"+ e.getMessage());
        }
    }

    @Override
    public void delete(Certifiable c) throws CertifiableException {
        try{
            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new CertifiableException("Msg! \n"+ e.getMessage());
        }
    }

    @Override
    public List<Certifiable> findAll() throws CertifiableException {
        try{
            return  (List<Certifiable> ) em.createNamedQuery("Certifiable.findAll").getResultList();
        }catch(Exception e){
            throw new CertifiableException("Msg! \n"+ e.getMessage());
        }
    }

    @Override
    public Certifiable findByID(Short ID) {
       Query query = em.createQuery("SELECT c FROM Certifiable c WHERE c.certifiableID = :certifiableID");
       query.setParameter("certifiableID", ID);
       return(Certifiable)query.getSingleResult();
    }
    
}
