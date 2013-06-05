package dbd.task5.logic.api;

import dbd.task5.domain.relational.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 5/28/13
 * Time: 9:05 PM
 * User: nicu
 */
public interface UserLogic {
    void saveUser(User user);
    List<User> listUsers();
    void deleteUser(User user);
    User getUser(Long userId);
    void updateUser(User user);
}
