package dbd.task5.logic.api;

import java.util.List;

import dbd.task5.domain.relational.Activity;

public interface ActivityLogic {

	public List<Activity> getActivities();
	public Activity addActivity(Activity activity) throws Exception;
	public Activity saveActivity(Activity activity) throws Exception;
	public void removeActivity(Activity activity) throws Exception;
}
