package dbd.task5.logic.api;

import dbd.task5.domain.relational.User;

/**
 * Created with IntelliJ IDEA.
 * Date: 6/5/13
 * Time: 8:24 PM
 * User: nicu
 */
public interface AuthenticationLogic {
    boolean isValidUser(User user);

    boolean isAvailableUsername(String username);

    void createUser(User user);
}
