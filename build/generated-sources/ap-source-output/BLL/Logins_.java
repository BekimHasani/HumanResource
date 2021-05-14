package BLL;

import BLL.Attendance;
import BLL.Employee;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-28T16:44:48")
@StaticMetamodel(Logins.class)
public class Logins_ { 

    public static volatile SingularAttribute<Logins, Date> logouted;
    public static volatile SingularAttribute<Logins, Date> loginedTime;
    public static volatile SingularAttribute<Logins, Integer> loginID;
    public static volatile CollectionAttribute<Logins, Attendance> attendanceCollection;
    public static volatile SingularAttribute<Logins, Date> loginDate;
    public static volatile SingularAttribute<Logins, Employee> employee;
    public static volatile SingularAttribute<Logins, Date> logined;

}