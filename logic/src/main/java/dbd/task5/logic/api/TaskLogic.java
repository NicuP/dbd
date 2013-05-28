package dbd.task5.logic.api;

import dbd.task5.domain.mongo.Task;

/**
 * Created with IntelliJ IDEA.
 * Date: 5/28/13
 * Time: 9:06 PM
 * User: nicu
 */
public interface TaskLogic {
    void saveTask(Task task);
}
