package BLL;

import BLL.Employee;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-28T16:44:48")
@StaticMetamodel(HumanResourceLogin.class)
public class HumanResourceLogin_ { 

    public static volatile SingularAttribute<HumanResourceLogin, Integer> loginID;
    public static volatile SingularAttribute<HumanResourceLogin, String> loginUsername;
    public static volatile SingularAttribute<HumanResourceLogin, String> loginPassword;
    public static volatile SingularAttribute<HumanResourceLogin, Employee> employee;

}