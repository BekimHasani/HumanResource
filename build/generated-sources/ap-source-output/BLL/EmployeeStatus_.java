package BLL;

import BLL.Employee;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-28T16:44:48")
@StaticMetamodel(EmployeeStatus.class)
public class EmployeeStatus_ { 

    public static volatile SingularAttribute<EmployeeStatus, String> employeeStatusDescription;
    public static volatile CollectionAttribute<EmployeeStatus, Employee> employeeCollection;
    public static volatile SingularAttribute<EmployeeStatus, Short> employeeStatusID;

}