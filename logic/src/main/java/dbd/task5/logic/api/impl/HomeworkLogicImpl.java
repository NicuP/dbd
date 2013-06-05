package dbd.task5.logic.api.impl;

import dbd.task5.db.mongo.repository.HomeworkRepository;
import dbd.task5.logic.api.HomeworkLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Date: 5/28/13
 * Time: 9:00 PM
 * User: nicu
 */
@Component
public class HomeworkLogicImpl implements HomeworkLogic {
    @Autowired
    private HomeworkRepository homeworkRepository;

}
