package BLL;

import BLL.Department;
import BLL.Employee;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-28T16:44:48")
@StaticMetamodel(EmployeeDepartmentHistory.class)
public class EmployeeDepartmentHistory_ { 

    public static volatile SingularAttribute<EmployeeDepartmentHistory, Integer> departmentHistoriID;
    public static volatile SingularAttribute<EmployeeDepartmentHistory, Date> endDate;
    public static volatile SingularAttribute<EmployeeDepartmentHistory, Department> department;
    public static volatile SingularAttribute<EmployeeDepartmentHistory, Employee> employee;
    public static volatile SingularAttribute<EmployeeDepartmentHistory, Date> startDate;

}