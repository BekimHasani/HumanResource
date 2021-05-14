package BLL;

import BLL.Certifiable;
import BLL.EmplooyeeTrainingAttendance;
import BLL.Employee;
import BLL.TrainingStatus;
import BLL.TrainingTypes;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-28T16:44:48")
@StaticMetamodel(EmployeeTrainings.class)
public class EmployeeTrainings_ { 

    public static volatile SingularAttribute<EmployeeTrainings, Integer> employeeTrainingId;
    public static volatile CollectionAttribute<EmployeeTrainings, EmplooyeeTrainingAttendance> emplooyeeTrainingAttendanceCollection;
    public static volatile SingularAttribute<EmployeeTrainings, Date> endDate;
    public static volatile SingularAttribute<EmployeeTrainings, TrainingStatus> trainingStatus;
    public static volatile SingularAttribute<EmployeeTrainings, Certifiable> certified;
    public static volatile SingularAttribute<EmployeeTrainings, TrainingTypes> training;
    public static volatile SingularAttribute<EmployeeTrainings, Employee> employee;
    public static volatile SingularAttribute<EmployeeTrainings, Date> startDate;

}