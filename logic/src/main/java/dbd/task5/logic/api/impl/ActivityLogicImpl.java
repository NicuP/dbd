package dbd.task5.logic.api.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dbd.task5.db.relational.repository.ActivityRepository;
import dbd.task5.domain.relational.Activity;
import dbd.task5.logic.api.ActivityLogic;

@Component
public class ActivityLogicImpl implements ActivityLogic {
    @Autowired
    private ActivityRepository activityRepository;

    public Activity addActivity(Activity activity) throws Exception {
        return activityRepository.save(activity);
    }

	public List<Activity> getAllActivities() {
		return activityRepository.findAll();
	}

	public Activity saveActivity(Activity activity) throws Exception {
		return activityRepository.save(activity);
	}

	public void removeActivity(Long id) throws Exception {
		activityRepository.delete(id);
	}

	public Activity getActivity(Long id) {
		return activityRepository.findOne(id);
	}
}
