package dbd.web.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import dbd.task5.domain.relational.Activity;
import dbd.task5.domain.relational.ActivityType;
import dbd.web.dto.ActivityDTO;

public class ActivityConverter {

	public static Activity getActivity(ActivityDTO activityDTO){
			
		Activity activity  = new Activity();
		if (activityDTO !=  null){
			activity.setId(activityDTO.getId());
			activity.setName(activityDTO.getName());
			
			try {
				activity.setDuration(Integer.valueOf(activityDTO.getDuration()));
			}
			catch (NumberFormatException e){
				activity.setDuration(0);
			}
		}
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
		if (activity != null){
			activityDTO.setId(activity.getId());
			activityDTO.setName(activity.getName());
			activityDTO.setDuration(String.valueOf(activity.getDuration()));
			ActivityType activityType = activity.getActivityType();
			if (activityType != null){
				activityDTO.setType(activityType.getId());
			}
		}
		return activityDTO;
	}
}
