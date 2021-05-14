/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.EmployeeStatus;
import java.util.List;

/**
 *
 * @author Armend
 */
public interface EmployeeStatusInterface {
    void create(EmployeeStatus es) throws EmployeeStatusException;
    void edit(EmployeeStatus es) throws EmployeeStatusException;
    void delete(EmployeeStatus es) throws EmployeeStatusException;
    List<EmployeeStatus> findAll() throws EmployeeStatusException;
    EmployeeStatus findByID(Integer ID);
}
