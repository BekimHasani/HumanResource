package BLL;

import BLL.EmployeeDepartmentHistory;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-28T16:44:48")
@StaticMetamodel(Department.class)
public class Department_ { 

    public static volatile SingularAttribute<Department, String> departmentName;
    public static volatile SingularAttribute<Department, Boolean> departmentStatus;
    public static volatile SingularAttribute<Department, Short> departmentID;
    public static volatile SingularAttribute<Department, Short> employees;
    public static volatile CollectionAttribute<Department, EmployeeDepartmentHistory> employeeDepartmentHistoryCollection;

}