package dbd.web.controller;

import dbd.task5.domain.relational.User;
import dbd.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class UserController {

    @Autowired
    private UserService userService;
    private Long userId;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String listUsers(Model model) {
        model.addAttribute("userList", userService.listUsers());
        return "users";
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String updateUser(User user, Model model) {
        return "/updateUser";
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.GET)
    public String onUpdateUser(Model model, Long id) {
        model.addAttribute("user", userService.getUser(id));
        this.userId = id;
        return "/updateUser";
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public String onSubmitUpdate(User user, Model model) {
        user.setId(userId);
        userService.updateUser(user);
        model.addAttribute("userList", userService.listUsers());
        return "users";
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public String deleteUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "deleteUser";
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public String onSubmitDelete(User user, Model model) {
        userService.deleteUser(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.GET)
    public String addUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "createUser";
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public String onSubmitCreate(User user, Model model) {
        userService.registerUser(user);
        return "redirect:/users";
    }
}
