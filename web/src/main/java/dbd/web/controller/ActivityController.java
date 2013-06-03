package dbd.web.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dbd.task5.domain.relational.Activity;
import dbd.task5.domain.relational.ActivityType;
import dbd.web.converter.ActivityConverter;
import dbd.web.dto.ActivityDTO;
import dbd.web.service.ActivityService;

@Controller
public class ActivityController {

	@Autowired
	private ActivityService activityService;

	@RequestMapping(value = "/activities", method = RequestMethod.GET)
	public ModelAndView showActivities(Model model) {
		ModelAndView mav = new ModelAndView("activities");
		List<Activity> activities = activityService.getAllActivities();
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
		
		Activity activity = ActivityConverter.getActivity(activityDTO);
		Long type = activityDTO.getType();
		if (type != null){
			ActivityType activityType =  activityService.getActivityTypeById(type);
			activity.setActivityType(activityType);
		}
		activityService.add(activity);
		ModelAndView mav = new ModelAndView("activities");
		List<Activity> activities = activityService.getAllActivities();
		mav.addObject("activities",
				ActivityConverter.getActivitiesDTO(activities));
		return mav;
	}

	@RequestMapping(value = "/editActivity", method = RequestMethod.POST)
	public String editActivity(Model model, Long id) {
		
		if (id != null){
			ActivityDTO activityDTO = ActivityConverter.getActivityDTO(activityService.getActivityById(id));
			model.addAttribute("activityDTO", activityDTO);
		}
		return "editActivity";
	}

	@RequestMapping(value = "/saveActivity", method = RequestMethod.POST)
	public ModelAndView editActivity(@ModelAttribute ActivityDTO activityDTO) {
		
		Activity activity = ActivityConverter.getActivity(activityDTO);
		Long type = activityDTO.getType();
		if (type != null){
			ActivityType activityType =  activityService.getActivityTypeById(type);
			activity.setActivityType(activityType);
		}
		activityService.update(activity);
		ModelAndView mav = new ModelAndView("activities");
		List<Activity> activities = activityService.getAllActivities();
		mav.addObject("activities",
				ActivityConverter.getActivitiesDTO(activities));
		return mav;
	}
	
	@RequestMapping(value = "/removeActivity", method = RequestMethod.POST)
	public ModelAndView removeActivity(Model model, String id) {
		
		if (id != null && StringUtils.isNotBlank(id)){
			activityService.remove(Long.valueOf(id));
		}
		ModelAndView mav = new ModelAndView("activities");
		List<Activity> activities = activityService.getAllActivities();
		mav.addObject("activities",
				ActivityConverter.getActivitiesDTO(activities));
		return mav;
	}
}
