package dbd.web.dto;

public class ActivityDTO {

	private Long id;
    private String name;
    private String duration;

    public Long getId() {
        return id;
    }

    public void setId(Long long1) {
        this.id = long1;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

   
}
