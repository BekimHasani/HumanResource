package BLL;

import BLL.Employee;
import BLL.Logins;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-28T16:44:48")
@StaticMetamodel(Attendance.class)
public class Attendance_ { 

    public static volatile SingularAttribute<Attendance, Short> abssenceTime;
    public static volatile SingularAttribute<Attendance, Short> overtimeD;
    public static volatile SingularAttribute<Attendance, Short> attendedTime;
    public static volatile SingularAttribute<Attendance, Employee> employee;
    public static volatile SingularAttribute<Attendance, Date> attendanceDate;
    public static volatile SingularAttribute<Attendance, Logins> logins;
    public static volatile SingularAttribute<Attendance, Long> attendanceID;
    public static volatile SingularAttribute<Attendance, Short> requiredHours;

}