package BLL;

import BLL.EmployeeTrainings;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-28T16:44:48")
@StaticMetamodel(TrainingStatus.class)
public class TrainingStatus_ { 

    public static volatile SingularAttribute<TrainingStatus, Short> trainingStatusID;
    public static volatile SingularAttribute<TrainingStatus, String> traningStatusDescription;
    public static volatile CollectionAttribute<TrainingStatus, EmployeeTrainings> employeeTrainingsCollection;

}