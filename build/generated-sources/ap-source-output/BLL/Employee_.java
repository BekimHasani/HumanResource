package BLL;

import BLL.Attendance;
import BLL.EmployeeDepartmentHistory;
import BLL.EmployeeLeaves;
import BLL.EmployeeStatus;
import BLL.EmployeeTrainings;
import BLL.HumanResourceLogin;
import BLL.JobTitle;
import BLL.Logins;
import BLL.Request;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-28T16:44:48")
@StaticMetamodel(Employee.class)
public class Employee_ { 

    public static volatile SingularAttribute<Employee, String> employeeName;
    public static volatile CollectionAttribute<Employee, Request> requestCollection;
    public static volatile SingularAttribute<Employee, String> fathersName;
    public static volatile SingularAttribute<Employee, Character> gender;
    public static volatile SingularAttribute<Employee, String> mobileNumber;
    public static volatile SingularAttribute<Employee, JobTitle> jobTitle;
    public static volatile SingularAttribute<Employee, Integer> employeeID;
    public static volatile SingularAttribute<Employee, String> personalNumber;
    public static volatile SingularAttribute<Employee, String> employeeState;
    public static volatile CollectionAttribute<Employee, EmployeeDepartmentHistory> employeeDepartmentHistoryCollection;
    public static volatile SingularAttribute<Employee, Date> birthDate;
    public static volatile SingularAttribute<Employee, String> employeeAddress;
    public static volatile SingularAttribute<Employee, EmployeeStatus> employeeStatus;
    public static volatile CollectionAttribute<Employee, HumanResourceLogin> humanResourceLoginCollection;
    public static volatile SingularAttribute<Employee, String> employeeLastName;
    public static volatile CollectionAttribute<Employee, Attendance> attendanceCollection;
    public static volatile SingularAttribute<Employee, Date> hiredDate;
    public static volatile CollectionAttribute<Employee, Logins> loginsCollection;
    public static volatile CollectionAttribute<Employee, EmployeeTrainings> employeeTrainingsCollection;
    public static volatile CollectionAttribute<Employee, EmployeeLeaves> employeeLeavesCollection;
    public static volatile SingularAttribute<Employee, String> homeNumber;
    public static volatile SingularAttribute<Employee, String> email;

}