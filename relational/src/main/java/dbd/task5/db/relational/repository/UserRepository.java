package dbd.task5.db.relational.repository;

import dbd.task5.domain.relational.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 5/28/13
 * Time: 8:47 PM
 * User: nicu
 */
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByName(String name);
    User findByUsernameAndPassword(String username, String password);
    @Query("select user.id from User user where user.username = ?1")
    List<Long> findIdsByUsername(String username);
}
