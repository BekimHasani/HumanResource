/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Employee;
import java.util.List;

/**
 *
 * @author Armend
 */
public interface EmployeeInterface {
    void create(Employee eps) throws EmployeeException; 
    void edit(Employee eps) throws EmployeeException;
    void delete(Employee eps) throws EmployeeException;
    List<Employee> findAll() throws EmployeeException;
    Employee findById(Integer ID) throws EmployeeException;
}
