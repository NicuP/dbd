package dbd.task5.logic.api.impl;

import dbd.task5.domain.relational.User;
import dbd.task5.logic.api.UserLogic;
import dbd.task5.db.relational.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    //same with others
}
