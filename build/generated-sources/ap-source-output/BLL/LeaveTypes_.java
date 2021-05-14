package BLL;

import BLL.EmployeeLeaves;
import BLL.Request;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-28T16:44:48")
@StaticMetamodel(LeaveTypes.class)
public class LeaveTypes_ { 

    public static volatile CollectionAttribute<LeaveTypes, Request> requestCollection;
    public static volatile SingularAttribute<LeaveTypes, Short> leaveDays;
    public static volatile SingularAttribute<LeaveTypes, Short> leaveID;
    public static volatile SingularAttribute<LeaveTypes, String> leaveDescription;
    public static volatile CollectionAttribute<LeaveTypes, EmployeeLeaves> employeeLeavesCollection;
    public static volatile SingularAttribute<LeaveTypes, Boolean> leaveStatus;

}