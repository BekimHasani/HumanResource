package BLL;

import BLL.Employee;
import BLL.LeaveTypes;
import BLL.RequestStatus;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-28T16:44:48")
@StaticMetamodel(Request.class)
public class Request_ { 

    public static volatile SingularAttribute<Request, Date> approvedDate;
    public static volatile SingularAttribute<Request, Short> requestDays;
    public static volatile SingularAttribute<Request, Date> endDate;
    public static volatile SingularAttribute<Request, Integer> requestID;
    public static volatile SingularAttribute<Request, LeaveTypes> leave;
    public static volatile SingularAttribute<Request, Date> requestDate;
    public static volatile SingularAttribute<Request, Employee> employee;
    public static volatile SingularAttribute<Request, String> requestDescription;
    public static volatile SingularAttribute<Request, Date> startDate;
    public static volatile SingularAttribute<Request, RequestStatus> requestStatus;

}