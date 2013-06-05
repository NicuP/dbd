package dbd.task5.logic.api;

import dbd.task5.domain.mongo.Homework;


/**
 * Created with IntelliJ IDEA.
 * Date: 5/28/13
 * Time: 9:05 PM
 * User: nicu
 */
public interface HomeworkLogic {
    public Homework addHomework(Homework homework,String userID) throws Exception;

}
