package dbd.task5.logic.api;

import dbd.task5.domain.relational.Group;
import dbd.task5.domain.relational.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 5/28/13
 * Time: 9:05 PM
 * User: nicu
 */
public interface GroupLogic {
    void saveGroup(Group group);
    List<Group> listGroups();
    void deleteGroup(Group group);
    Group getGroup(Long groupId);
    void updateGroup(Group group);
}
