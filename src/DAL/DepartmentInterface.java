/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Department;
import java.util.List;

/**
 *
 * @author Bekim
 */
public interface DepartmentInterface {
    void create(Department eps) throws DepartmentException; 
    void edit(Department eps) throws DepartmentException;
    void delete(Department eps) throws DepartmentException;
    List<Department> findAll() throws DepartmentException;
    Department findById(Integer ID) throws DepartmentException;
}
