package dbd.web.service;

import dbd.task5.domain.relational.User;
import dbd.task5.logic.api.UserLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserLogic userLogic;
    List<User> l = new ArrayList<User>();

    public UserService(){
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

    public List<User> listUsers() {
    return userLogic.listUsers();
    }

    public void registerUser(User user) {
        userLogic.saveUser(user);
    }

    public void deleteUser(User user) {
        userLogic.deleteUser(user);
    }

    public User getUser(Long userId) {
        return userLogic.getUser(userId);
    }

    public void updateUser(User user) {
        userLogic.updateUser(user);
    }

}
