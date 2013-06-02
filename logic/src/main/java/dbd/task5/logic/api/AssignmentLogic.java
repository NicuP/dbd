package dbd.task5.logic.api;

import dbd.task5.domain.mongo.Assignment;

public interface AssignmentLogic {
    public Assignment addAssignment(Assignment assignment) throws Exception;
}
