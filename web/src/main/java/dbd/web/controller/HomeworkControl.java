/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbd.web.controller;

import dbd.task5.domain.mongo.Homework;
import dbd.task5.logic.api.HomeworkLogic;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Dan
 */

public class HomeworkControl {
    @Autowired
     private HomeworkLogic homeworkLogic;
    public  void addHomework(String file,String Hname ,String desc,String userId)
    {
        Homework h = new Homework();
        h.setFile(file);
        h.setName(Hname);
        h.setDesc(desc);
        try {
            Homework addAssignment;
            addAssignment = homeworkLogic.addHomework(h, userId);
        } catch (Exception ex) {
            Logger.getLogger(HomeworkControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
