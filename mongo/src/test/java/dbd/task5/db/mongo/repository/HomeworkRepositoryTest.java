package dbd.task5.db.mongo.repository;

import dbd.task5.db.mongo.config.MongoConfig;
import dbd.task5.domain.MockFactory;
import dbd.task5.domain.mongo.Homework;
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
 * Time: 9:47 PM
 * User: nicu
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MongoConfig.class)
public class HomeworkRepositoryTest {
    @Autowired
    private HomeworkRepository homeworkRepository;
    
    private Homework homework;

    @Before
    public void init() {
        homework = MockFactory.mock(Homework.class);
        homework = homeworkRepository.save(homework);
    }

    @Test
    public void testSaveUser() {
        Homework dbHomework = homeworkRepository.findOne(homework.getId());
        assertThat("Persisted homework does not equal with db one", homework, is(dbHomework));
    }

    @Test
    public void testFindByUsername() {
        List<Homework> dbHomeworks = homeworkRepository.findByName(homework.getName());
        assertThat("User with given homeworkname not found in db", dbHomeworks, hasItem(homework));
    }

    @After
    public void clean() {
        homeworkRepository.deleteAll();
    }
}
