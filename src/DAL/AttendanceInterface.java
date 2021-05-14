/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Attendance;
import java.util.List;

/**
 *
 * @author USER
 */
public interface AttendanceInterface {
    void create(Attendance a) throws AttendanceException;
    void edit(Attendance a) throws AttendanceException;
    void delete(Attendance a) throws AttendanceException;
    List<Attendance> findAll() throws AttendanceException;
    Attendance findByID(Integer ID) throws AttendanceException;
    List<Integer> searchAttendanceHR(String str) throws AttendanceException;
    List<Integer> searchAttendanceCEO(String str) throws AttendanceException;
    List<Integer> searchAttendanceDIR(String str) throws AttendanceException;
}
