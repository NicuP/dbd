package dbd.web.service;

import dbd.task5.domain.relational.Group;
import dbd.task5.domain.relational.User;
import dbd.task5.logic.api.GroupLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class GroupService {

    @Autowired
    private GroupLogic groupLogic;
    List<User> l = new ArrayList<User>();

    public GroupService(){
        User u = new User();
        u.setId(1L);
        u.setName("asd");
        u.setUsername("bla");
        User u1 = new User();
        u1.setId(2L);
        u1.setName("fgh");
        u1.setUsername("cda");

        l.add(u);
        l.add(u1);
    }

    public List<Group> listGroups() {
        return groupLogic.listGroups();
    }

    public void registerGroup(Group group) {
        groupLogic.saveGroup(group);
    }

    public void deleteGroup(Group group) {
        groupLogic.deleteGroup(group);
    }

    public Group getGroup(Long groupId) {
        return groupLogic.getGroup(groupId);
    }

    public void updateGroup(Group group) {
        groupLogic.updateGroup(group);
    }
}
