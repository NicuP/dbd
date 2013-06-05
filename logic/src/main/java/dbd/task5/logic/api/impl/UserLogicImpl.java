package dbd.task5.logic.api.impl;

import dbd.task5.db.relational.repository.UserRepository;
import dbd.task5.domain.relational.User;
import dbd.task5.logic.api.UserLogic;
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
public class UserLogicImpl implements UserLogic {
    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user) {
        //logic on user
        userRepository.save(user);
    }

    @Override
    public List<User> listUsers() {
        //return userRepository.findAll();
//        User u = new User();
//        u.setName("asd");
//        u.setUsername("bla");
//        User u1 = new User();
//        u1.setName("fgh");
//        u1.setUsername("cda");
//        List<User> l = new ArrayList<User>();
//        l.add(u);
//        l.add(u1);
//        return l;
        return userRepository.findAll();

    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public User getUser(Long userId) {
        return userRepository.findOne(userId);
    }

    @Override
    public void updateUser(User user) {
        if(userRepository.exists(user.getId())){
            userRepository.delete(user.getId());
        }
        userRepository.save(user);
    }


}
