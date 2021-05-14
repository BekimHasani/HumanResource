/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.JobTitle;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Armend
 */
public class JobTitleRepository extends EntMngClass implements JobTitleInterface {

    @Override
    public void create(JobTitle jt) throws JobTitleException {
        try {
            em.getTransaction().begin();
            em.persist(jt);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new JobTitleException("Error creating" + e.getMessage());
        }
    }

    @Override
    public void edit(JobTitle jt) throws JobTitleException {
        try {
            em.getTransaction().begin();
            em.merge(jt);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new JobTitleException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public void delete(JobTitle jt) throws JobTitleException {
        try {
            em.getTransaction().begin();
            em.remove(jt);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new JobTitleException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public List<JobTitle> findAll() throws JobTitleException {
        try {
            return em.createNamedQuery("JobTitle.findAll").getResultList();
        } catch (Exception e) {
            throw new JobTitleException("Msg :\n" + e.getMessage());
        }
    }

    @Override
    public JobTitle findByID(Integer ID) {
        Query query = em.createQuery("JobTitle.findByJobTitleID");
        query.setParameter("jobTitleID", ID);
        return (JobTitle) query.getSingleResult();
    }

}
