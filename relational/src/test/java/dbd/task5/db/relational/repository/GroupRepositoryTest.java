package dbd.task5.db.relational.repository;

import dbd.task5.db.relational.config.JpaConfig;
import dbd.task5.domain.MockFactory;
import dbd.task5.domain.relational.Group;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * Date: 6/1/13
 * Time: 4:54 PM
 * Group: nicu
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JpaConfig.class)
public class GroupRepositoryTest {
    @Autowired
    private GroupRepository groupRepository;
    private Group group;

    @Before
    public void init() {
        group = MockFactory.mock(Group.class);
        group = groupRepository.save(group);
    }

    @Test
    public void testSaveGroup() {
        Group dbGroup = groupRepository.findOne(group.getId());
        assertThat("Persisted group does not equal with db one", group, is(dbGroup));
    }

    @After
    public void clean() {
        groupRepository.deleteAll();
    }
}