package BLL;

import BLL.Request;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-28T16:44:48")
@StaticMetamodel(RequestStatus.class)
public class RequestStatus_ { 

    public static volatile CollectionAttribute<RequestStatus, Request> requestCollection;
    public static volatile SingularAttribute<RequestStatus, Short> requestStatusID;
    public static volatile SingularAttribute<RequestStatus, String> requestStatusDescription;

}