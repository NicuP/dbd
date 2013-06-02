package dbd.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dbd.task5.domain.relational.Activity;
import dbd.task5.logic.api.ActivityLogic;

@Service
@Transactional
public class ActivityService {

    @Autowired
    private ActivityLogic activityLogic;

    public List<Activity> getActivities() {
    	return activityLogic.getActivities();
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
	
	public void remove(Activity activity) {
    	try {
			activityLogic.removeActivity(activity);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
