package dbd.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dbd.task5.domain.relational.Activity;
import dbd.task5.domain.relational.ActivityType;
import dbd.task5.logic.api.ActivityLogic;

@Service
@Transactional
public class ActivityService {

    @Autowired
    private ActivityLogic activityLogic;

    public Activity getActivityById(Long id) {
    	return activityLogic.getActivity(id);
    }
    
    public List<Activity> getAllActivities() {
    	return activityLogic.getAllActivities();
    }
    
    public void add(Activity activity) {
    	try {
			activityLogic.addActivity(activity);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	public void update(Activity activity) {
    	try {
			activityLogic.saveActivity(activity);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void remove(Long id) {
    	try {
			activityLogic.removeActivity(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	public ActivityType getActivityTypeById(Long id) {
		try {
			return activityLogic.getActivityType(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
