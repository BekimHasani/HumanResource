package DAL;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Armend
 */
public abstract class EntMngClass {
    EntityManager em = Persistence.createEntityManagerFactory("LabKurs2PU").createEntityManager();
}
