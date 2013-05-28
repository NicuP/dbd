package dbd.task5.db.relational.repository;

import dbd.task5.domain.relational.User;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created with IntelliJ IDEA.
 * Date: 5/28/13
 * Time: 8:58 PM
 * User: nicu
 */
/*This class shouldn't be needed; if needed though, it must be declared as a Spring bean*/
@Transactional
public class OldSchoolUserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void saveUser(User user) {
        entityManager.persist(user);
    }

}
