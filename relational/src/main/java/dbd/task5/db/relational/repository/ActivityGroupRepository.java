package dbd.task5.db.relational.repository;

import dbd.task5.domain.relational.ActivityGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * Date: 6/1/13
 * Time: 4:31 PM
 * User: nicu
 */
@Transactional
public interface ActivityGroupRepository extends JpaRepository<ActivityGroup, Long> {
}
