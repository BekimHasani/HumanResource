/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.EmployeeLeaves;
import java.util.List;

/**
 *
 * @author Armend
 */
public interface EmployeeLeavesInterface {
    void create(EmployeeLeaves el) throws EmployeeLeavesException; 
    void edit(EmployeeLeaves el) throws EmployeeLeavesException;
    void delete(EmployeeLeaves el) throws EmployeeLeavesException;
    List<EmployeeLeaves> findAll() throws EmployeeLeavesException;
    EmployeeLeaves findById(Integer ID) throws EmployeeLeavesException;
    List<EmployeeLeaves> findByLeave(short ID) throws EmployeeLeavesException;
    List<Integer> searchEmployeeLeavesHR(String str) throws EmployeeLeavesException;
    List<Integer> searchEmployeeLeavesCEO(String str) throws EmployeeLeavesException;
    List<Integer> searchEmployeeLeavesDIR(String str) throws EmployeeLeavesException;
    List<EmployeeLeaves> findActive() throws EmployeeLeavesException;
}
