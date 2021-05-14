/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.EmployeeDepartmentHistory;
import java.util.List;

/**
 *
 * @author Bekim
 */
public interface EmployeeDepHistoryInterface {
    void create(EmployeeDepartmentHistory ed) throws EmployeeDepHistoryException; 
    void edit(EmployeeDepartmentHistory ed) throws EmployeeDepHistoryException; 
    void delete(EmployeeDepartmentHistory ed) throws EmployeeDepHistoryException; 
    List <EmployeeDepartmentHistory> findAll() throws EmployeeDepHistoryException ;
    EmployeeDepartmentHistory findById(Integer ID) throws EmployeeDepHistoryException;
    
}
