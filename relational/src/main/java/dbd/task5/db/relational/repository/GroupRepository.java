package dbd.task5.db.relational.repository;

import dbd.task5.domain.relational.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * Date: 6/1/13
 * Time: 4:32 PM
 * User: nicu
 */
@Transactional
public interface GroupRepository extends JpaRepository<Group, Long> {
}
