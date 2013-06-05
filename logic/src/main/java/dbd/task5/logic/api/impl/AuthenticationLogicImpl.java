package dbd.task5.logic.api.impl;

import dbd.task5.db.relational.repository.UserRepository;
import dbd.task5.domain.relational.User;
import dbd.task5.logic.api.AuthenticationLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 6/5/13
 * Time: 8:26 PM
 * User: nicu
 */
@Component
public class AuthenticationLogicImpl implements AuthenticationLogic {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean isValidUser(User user) {
        User dbUser = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        return dbUser != null;
    }

    @Override
    public boolean isAvailableUsername(String username) {
        List<Long> ids = userRepository.findIdsByUsername(username);
        return ids.isEmpty();
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }
}
