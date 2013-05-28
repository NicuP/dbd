package dbd.task5.db.relational.repository;

import dbd.task5.domain.relational.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 5/28/13
 * Time: 8:47 PM
 * User: nicu
 */
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByName(String name);
}
