package dbd.task5.domain.relational;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Andrei
 * Date: 5/31/13
 * Time: 7:54 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class ActivityGroup {
    @Id
    @GeneratedValue
    private Long id;

    private int activityId;
    private int groupId;
    private Date start_date;
    private Date end_date;


    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }
}
