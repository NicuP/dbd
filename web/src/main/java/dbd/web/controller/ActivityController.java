package dbd.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dbd.task5.domain.relational.Activity;
import dbd.web.controllers.ActivityConverter;
import dbd.web.dto.ActivityDTO;
import dbd.web.service.ActivityService;

@Controller
public class ActivityController {

	@Autowired
	private ActivityService activityService;

	@RequestMapping(value = "/activities", method = RequestMethod.GET)
	public ModelAndView showActivities(Model model) {
		ModelAndView mav = new ModelAndView("activities");
		List<Activity> activities = activityService.getActivities();
		mav.addObject("activities",
				ActivityConverter.getActivitiesDTO(activities));
		return mav;
	}

	@RequestMapping(value = "/createActivity", method = RequestMethod.GET)
	public String createActivity(Model model) {
		model.addAttribute("activityDTO", new ActivityDTO());
		return "createActivity";
	}

	@RequestMapping(value = "/createActivity", method = RequestMethod.POST)
	public ModelAndView createActivity(@ModelAttribute ActivityDTO activityDTO) {
		activityService.add(ActivityConverter.getActivity(activityDTO));

		ModelAndView mav = new ModelAndView("activities");
		List<Activity> activities = activityService.getActivities();
		mav.addObject("activities",
				ActivityConverter.getActivitiesDTO(activities));
		return mav;
	}

	@RequestMapping(value = "/editActivity", method = RequestMethod.GET)
	public ModelAndView editActivity() {
		ModelAndView view = new ModelAndView();
		view.setViewName("createActivity"); // name of the jsp-file in the
											// "page" folder

		String str = "MVC Spring is here!";
		view.addObject("message", str); // adding of str object as "message"
										// parameter
		return view;
	}

	@RequestMapping(value = "/removeActivity", method = RequestMethod.GET)
	public ModelAndView removeActivity() {
		ModelAndView view = new ModelAndView();
		view.setViewName("createActivity"); // name of the jsp-file in the
											// "page" folder

		String str = "MVC Spring is here!";
		view.addObject("message", str); // adding of str object as "message"
										// parameter
		return view;
	}
}
