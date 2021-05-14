/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Attendance;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Bekim
 */
public class AttendanceRepository extends EntMngClass implements AttendanceInterface{
    
    @Override
    public void create(Attendance a) throws AttendanceException {
        try{
            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();
        }catch(Exception e) {
            throw new AttendanceException("[AttendanceRepository]->create: "+ e.getMessage());
        }
    }

    @Override
    public void edit(Attendance a) throws AttendanceException {
        try{
            em.getTransaction().begin();
            em.merge(a);
            em.getTransaction().commit();
        }catch(Exception e) {
            throw new AttendanceException("[AttendanceRepository]->edit: "+ e.getMessage());
        }
    }

    @Override
    public void delete(Attendance a) throws AttendanceException {
        try{
            em.getTransaction().begin();
            em.remove(a);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new AttendanceException("[AttendanceRepository]->delete: "+ e.getMessage());
        }
    }

    @Override
    public List<Attendance> findAll() throws AttendanceException {
        try{
            return em.createNamedQuery("Attendance.findAll").getResultList();
        }catch(Exception e){
            throw new AttendanceException("[AttendanceRepository]->findAll: "+ e.getMessage());
        }
    }

    @Override
    public Attendance findByID(Integer ID) throws AttendanceException{
        try {
            Query query = em.createQuery("SELECT a FROM Attendance a WHERE a.attendanceID = :attendanceID");
            query.setParameter("attendanceID", ID);
            return(Attendance)query.getSingleResult();
        } catch (Exception e) {
            throw new AttendanceException("[AttendanceRepository]->findByID: " + e.getMessage());
        }
    }

    @Override
    public List<Integer> searchAttendanceHR(String str) throws AttendanceException {
        try {
            Query query = em.createNativeQuery("searchAttendance_udspHR ?");
            query.setParameter(1, str);
            return query.getResultList();
        } catch (Exception e) {
            throw new AttendanceException("[AttendanceRepository]->searchAttendanceHR: " + e.getMessage());
        }
    }

    @Override
    public List<Integer> searchAttendanceCEO(String str) throws AttendanceException {
        try {
            Query query = em.createNativeQuery("select * from udf_searchAttendanceCEO(?)");
            query.setParameter(1, str);
            return query.getResultList();
        } catch (Exception e) {
            throw new AttendanceException("[AttendanceRepository]->searchAttendanceCEO: " + e.getMessage());
        }
    }

    @Override
    public List<Integer> searchAttendanceDIR(String str) throws AttendanceException {
        try {
            Query query = em.createNativeQuery("select * from udf_searchAttendanceDIR(?)");
            query.setParameter(1, str);
            return query.getResultList();
        } catch (Exception e) {
            throw new AttendanceException("[AttendanceRepository]->searchAttendanceDIR: " + e.getMessage());
        }
    }
    
}
