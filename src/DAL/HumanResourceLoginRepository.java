/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.HumanResourceLogin;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Armend
 */
public class HumanResourceLoginRepository extends EntMngClass implements HumanResourceLoginInterface {

    @Override
    public void create(HumanResourceLogin hrl) throws HumanResourceLoginException {
        try{
            em.getTransaction().begin();
            em.persist(hrl);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new HumanResourceLoginException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public void edit(HumanResourceLogin hrl) throws HumanResourceLoginException {
        try{
            em.getTransaction().begin();
            em.merge(hrl);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new HumanResourceLoginException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public void delete(HumanResourceLogin hrl) throws HumanResourceLoginException {
        try{
            em.getTransaction().begin();
            em.remove(hrl);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new HumanResourceLoginException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public List<HumanResourceLogin> findAll() throws HumanResourceLoginException {
        return em.createNamedQuery("HumanResourceLogin.findAll").getResultList();
    }

    @Override
    public HumanResourceLogin findById(Integer ID) throws HumanResourceLoginException {
        Query query = em.createQuery("HumanResourceLogin.findByLoginID");
        query.setParameter("loginID",ID);
        return (HumanResourceLogin)query.getSingleResult();
    }

    @Override
    public HumanResourceLogin loginByUsernameAndPassword(String u, String p) throws HumanResourceLoginException {
        try {
            Query query = 
            em.createQuery("SELECT a FROM HumanResourceLogin a WHERE a.loginUsername = :us AND a.loginPassword= :psw");
            query.setParameter("us", u);
            query.setParameter("psw", p);
            return (HumanResourceLogin) query.getSingleResult();
        } catch (Exception e) {
            throw new HumanResourceLoginException("Msg! \n" + e.getMessage());
        }
    }    
}
