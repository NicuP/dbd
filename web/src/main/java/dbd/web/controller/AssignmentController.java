package dbd.web.controller;

import dbd.web.dto.AssignmentDTO;
import dbd.web.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @RequestMapping(value = "/assignment", method = RequestMethod.GET)
    public String showAssignment(Model model) {
        model.addAttribute(new AssignmentDTO());

        return "assignment";
    }

    @RequestMapping(value = "/addAssignment", method = RequestMethod.POST)
    public String addAssignment(HttpServletRequest request, @ModelAttribute AssignmentDTO assignmentDTO) throws Exception {
        assignmentService.add(assignmentDTO);

        return "assignment";
    }
}
