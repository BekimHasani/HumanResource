package BLL;

import BLL.EmployeeTrainings;
import BLL.Logins;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-28T16:44:48")
@StaticMetamodel(EmplooyeeTrainingAttendance.class)
public class EmplooyeeTrainingAttendance_ { 

    public static volatile SingularAttribute<EmplooyeeTrainingAttendance, Boolean> attended;
    public static volatile SingularAttribute<EmplooyeeTrainingAttendance, EmployeeTrainings> employeeTraining;
    public static volatile SingularAttribute<EmplooyeeTrainingAttendance, Integer> trainingAttendanceID;
    public static volatile SingularAttribute<EmplooyeeTrainingAttendance, Date> endAt;
    public static volatile SingularAttribute<EmplooyeeTrainingAttendance, Date> attendanceDate;
    public static volatile SingularAttribute<EmplooyeeTrainingAttendance, Logins> logins;
    public static volatile SingularAttribute<EmplooyeeTrainingAttendance, Date> startAt;

}