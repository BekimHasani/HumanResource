/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Certifiable;
import BLL.Department;
import BLL.Employee;
import BLL.EmployeeTrainings;
import BLL.TrainingStatus;
import BLL.TrainingTypes;
import java.util.Date;
import java.util.List;

/**
 *
 * @author BesaC
 */
public interface EmployeeTrainingsInterface {
    
    
    void create(EmployeeTrainings et) throws EmployeeTrainingsException;
    void edit (EmployeeTrainings et) throws EmployeeTrainingsException;
    void remove (EmployeeTrainings et) throws EmployeeTrainingsException;
    List <EmployeeTrainings> findAll() throws EmployeeTrainingsException;
    EmployeeTrainings findById(Integer id) throws EmployeeTrainingsException;
    List<EmployeeTrainings> findByEmployeeName (Employee e) throws EmployeeTrainingsException;
    List<EmployeeTrainings> findByEmployeeTraining(TrainingTypes tt) throws EmployeeTrainingsException;
    List<EmployeeTrainings> findByEmployeeTrainingStatus(TrainingStatus ts) throws EmployeeTrainingsException;
    List<EmployeeTrainings> findByCertifiable(Certifiable c) throws EmployeeTrainingsException;
    List<EmployeeTrainings> findByStartDate(Date startDate) throws EmployeeTrainingsException;
    List<EmployeeTrainings> findByEndDate(Date endDate) throws EmployeeTrainingsException;
    List <Integer> search(String str) throws EmployeeTrainingsException;
    List<Integer> findValidEmployeesForTraining(Short id) throws EmployeeTrainingsException; 
    Department findEmployeeDepartment (int empID) throws EmployeeTrainingsException;
}
