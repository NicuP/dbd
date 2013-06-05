package dbd.task5.domain.relational;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Andrei
 * Date: 5/31/13
 * Time: 7:54 AM
 */
@Entity
public class Activity {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private ActivityGroup activityGroup;

    private String name;
    @OneToOne
    private ActivityType activityType;
    private int duration;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public ActivityGroup getActivityGroup() {
        return activityGroup;
    }

    public void setActivityGroup(ActivityGroup activityGroup) {
        this.activityGroup = activityGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Activity activity = (Activity) o;

        if (duration != activity.duration) return false;
        if (activityGroup != null ? !activityGroup.equals(activity.activityGroup) : activity.activityGroup != null)
            return false;
        if (activityType != null ? !activityType.equals(activity.activityType) : activity.activityType != null)
            return false;
        if (id != null ? !id.equals(activity.id) : activity.id != null) return false;
        if (name != null ? !name.equals(activity.name) : activity.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (activityGroup != null ? activityGroup.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (activityType != null ? activityType.hashCode() : 0);
        result = 31 * result + duration;
        return result;
    }
}
