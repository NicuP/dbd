package dbd.task5.db.mongo.repository;

import dbd.task5.domain.mongo.Assignment;
import dbd.task5.domain.mongo.Homework;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AssignmentRepository extends CrudRepository<Assignment,Long> {
    List<Assignment> findByName(String name);
}
