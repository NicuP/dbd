package dbd.web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import dbd.task5.domain.relational.Activity;
import dbd.web.dto.ActivityDTO;

public class ActivityConverter {

	public static Activity getActivity(ActivityDTO activityDTO){
			
		Activity activity  = new Activity();
		activity.setName(activityDTO.getName());
		activity.setDuration(Integer.valueOf(activityDTO.getDuration()));
		
		return activity;
	}

	public static List<ActivityDTO> getActivitiesDTO(List<Activity> activities) {
		List<ActivityDTO> activityDTOs = new ArrayList<ActivityDTO>();
		if (!CollectionUtils.isEmpty(activities)){
			for (Activity activity : activities) {
				activityDTOs.add(getActivityDTO(activity));
			}
		}
		return activityDTOs;
	}
	
	public static ActivityDTO getActivityDTO(Activity activity){
		
		ActivityDTO activityDTO  = new ActivityDTO();
		activityDTO.setId(activity.getId());
		activityDTO.setName(activity.getName());
		activityDTO.setDuration(String.valueOf(activity.getDuration()));
		return activityDTO;
	}
}
