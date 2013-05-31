package dbd.task5.domain.relational;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * User: Andrei
 * Date: 5/31/13
 * Time: 7:54 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Timesheet {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int activityGroupId;
    private int userId;

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

    public int getActivityGroupId() {
        return activityGroupId;
    }

    public void setActivityGroupId(int activityGroupId) {
        this.activityGroupId = activityGroupId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
