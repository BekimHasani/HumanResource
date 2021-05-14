package BLL;

import BLL.EmployeeTrainings;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-28T16:44:48")
@StaticMetamodel(TrainingTypes.class)
public class TrainingTypes_ { 

    public static volatile SingularAttribute<TrainingTypes, String> trainingDescription;
    public static volatile SingularAttribute<TrainingTypes, Integer> trainingID;
    public static volatile CollectionAttribute<TrainingTypes, EmployeeTrainings> employeeTrainingsCollection;
    public static volatile SingularAttribute<TrainingTypes, Boolean> certifiable;

}