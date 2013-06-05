package dbd.task5.logic.api.impl;

import dbd.task5.db.relational.repository.GroupRepository;
import dbd.task5.domain.relational.Group;
import dbd.task5.logic.api.GroupLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 5/28/13
 * Time: 8:55 PM
 * User: nicu
 */
@Component
public class GroupLogicImpl implements GroupLogic {
    @Autowired
    private GroupRepository groupRepository;


    @Override
    public void saveGroup(Group group) {
        groupRepository.save(group);
    }

    @Override
    public List<Group> listGroups() {
        return groupRepository.findAll();
    }

    @Override
    public void deleteGroup(Group group) {
        if(groupRepository.exists(group.getId())){
            groupRepository.delete(group);
        }
    }

    @Override
    public Group getGroup(Long groupId) {
        return groupRepository.findOne(groupId);
    }

    @Override
    public void updateGroup(Group group) {
        if(groupRepository.exists(group.getId())){
            groupRepository.delete(group);
        }
        groupRepository.save(group);
    }
}
