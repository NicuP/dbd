package dbd.web.controller;

import dbd.task5.domain.relational.Group;
import dbd.task5.domain.relational.User;
import dbd.web.service.GroupService;
import dbd.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class GroupController {

    @Autowired
    private GroupService groupService;
    private Long groupId;

    @RequestMapping(value = "/groups", method = RequestMethod.GET)
    public String listGroups(Model model) {
        model.addAttribute("groupList", groupService.listGroups());
        return "groups";
    }

    @RequestMapping(value = "/groups", method = RequestMethod.POST)
    public String updateGroup(Group group, Model model) {
        return "/updateGroup";
    }

    @RequestMapping(value = "/updateGroup", method = RequestMethod.GET)
    public String onUpdateGroup(Model model, Long id) {
        model.addAttribute("group", groupService.getGroup(id));
        this.groupId = id;
        return "/updateGroup";
    }

    @RequestMapping(value = "/updateGroup", method = RequestMethod.POST)
    public String onSubmitUpdate(Group group, Model model) {
        group.setId(groupId);
        groupService.updateGroup(group);
        model.addAttribute("groupList", groupService.listGroups());
        return "groups";
    }

    @RequestMapping(value = "/deleteGroup", method = RequestMethod.GET)
    public String deleteGroupForm(Model model) {
        Group group = new Group();
        model.addAttribute("group", group);
        return "deleteGroup";
    }

    @RequestMapping(value = "/deleteGroup", method = RequestMethod.POST)
    public String onSubmitDelete(Group group, Model model) {
        groupService.deleteGroup(group);
        return "redirect:/groups";
    }

    @RequestMapping(value = "/createGroup", method = RequestMethod.GET)
    public String addGroupForm(Model model) {
        Group group = new Group();
        model.addAttribute("group", group);
        return "createGroup";
    }

    @RequestMapping(value = "/createGroup", method = RequestMethod.POST)
    public String onSubmitCreate(Group group, Model model) {
        groupService.registerGroup(group);
        return "redirect:/groups";
    }
}
