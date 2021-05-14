package BLL;

import BLL.EmployeeTrainings;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-28T16:44:48")
@StaticMetamodel(Certifiable.class)
public class Certifiable_ { 

    public static volatile CollectionAttribute<Certifiable, EmployeeTrainings> employeeTrainingsCollection;
    public static volatile SingularAttribute<Certifiable, Short> certifiableID;
    public static volatile SingularAttribute<Certifiable, String> certifiableDescription;

}