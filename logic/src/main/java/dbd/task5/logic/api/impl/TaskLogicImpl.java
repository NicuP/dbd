package dbd.task5.logic.api.impl;

import dbd.task5.db.mongo.repository.TaskRepository;
import dbd.task5.domain.mongo.Task;
import dbd.task5.logic.api.TaskLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Date: 5/28/13
 * Time: 8:56 PM
 * User: nicu
 */
@Component
public class TaskLogicImpl implements TaskLogic {
    @Autowired
    private TaskRepository taskRepository;

    public void saveTask(Task task) {
        //logic here
        taskRepository.save(task);
    }
}
