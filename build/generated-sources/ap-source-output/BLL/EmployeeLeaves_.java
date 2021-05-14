package BLL;

import BLL.Employee;
import BLL.LeaveTypes;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-28T16:44:48")
@StaticMetamodel(EmployeeLeaves.class)
public class EmployeeLeaves_ { 

    public static volatile SingularAttribute<EmployeeLeaves, Short> leaveDays;
    public static volatile SingularAttribute<EmployeeLeaves, Date> endDate;
    public static volatile SingularAttribute<EmployeeLeaves, LeaveTypes> leave;
    public static volatile SingularAttribute<EmployeeLeaves, Boolean> employeeLeavesStatus;
    public static volatile SingularAttribute<EmployeeLeaves, Employee> employee;
    public static volatile SingularAttribute<EmployeeLeaves, Date> startDate;
    public static volatile SingularAttribute<EmployeeLeaves, Integer> employeeLeaveID;

}