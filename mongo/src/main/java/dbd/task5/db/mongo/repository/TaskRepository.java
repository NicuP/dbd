package dbd.task5.db.mongo.repository;

import dbd.task5.domain.mongo.Task;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 * Date: 5/28/13
 * Time: 8:56 PM
 * User: nicu
 */
public interface TaskRepository extends CrudRepository<Task, Long> {
}
