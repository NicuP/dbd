package dbd.task5.db.mongo.repository;

import dbd.task5.domain.mongo.Homework;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 5/28/13
 * Time: 8:39 PM
 * User: nicu
 */
public interface HomeworkRepository extends CrudRepository<Homework,Long> {
    List<Homework> findByName(String name);
}
