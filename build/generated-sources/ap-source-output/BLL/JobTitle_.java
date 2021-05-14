package BLL;

import BLL.Employee;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-28T16:44:48")
@StaticMetamodel(JobTitle.class)
public class JobTitle_ { 

    public static volatile SingularAttribute<JobTitle, Short> jobTitleID;
    public static volatile SingularAttribute<JobTitle, Boolean> jobTitleStatus;
    public static volatile CollectionAttribute<JobTitle, Employee> employeeCollection;
    public static volatile SingularAttribute<JobTitle, String> jobTitleDescription;

}