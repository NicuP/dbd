package dbd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AssignmentController {

    @RequestMapping(value = "/assignment", method = RequestMethod.GET)
    public String showAssignment() {
        return "home";
    }
}
