package dbd.task5.logic.api;

import java.util.List;

import dbd.task5.domain.relational.Activity;
import dbd.task5.domain.relational.ActivityType;

public interface ActivityLogic {

	public List<Activity> getAllActivities();
	public Activity addActivity(Activity activity) throws Exception;
	public Activity saveActivity(Activity activity) throws Exception;
	public void removeActivity(Long id) throws Exception;
	public Activity getActivity(Long id);
	public ActivityType getActivityType(Long id);
}
