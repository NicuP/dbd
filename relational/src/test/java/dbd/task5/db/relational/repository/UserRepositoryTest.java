package dbd.task5.db.relational.repository;

import dbd.task5.domain.MockFactory;
import dbd.task5.domain.relational.User;
import dbd.task5.db.relational.config.JpaConfig;
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
 * Date: 5/28/13
 * Time: 9:16 PM
 * User: nicu
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JpaConfig.class)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    private User user;

    @Before
    public void init() {
        user = MockFactory.mock(User.class);
        user = userRepository.save(user);
    }

    @Test
    public void testSaveUser() {
        User dbUser = userRepository.findOne(user.getId());
        assertThat("Persisted user does not equal with db one", user, is(dbUser));
    }

    @Test
    public void testFindByUsername() {
        List<User> dbUsers = userRepository.findByName(user.getName());
        assertThat("User with given username not found in db", dbUsers, hasItem(user));
    }

    @After
    public void clean() {
        userRepository.deleteAll();
    }
}
