package dbd.web.dto;


public class ActivityDTO {

	private Long id;
	private String name;
	private String duration;
	private Long type;
	private String typeAsString;

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

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}
	
	public String getTypeAsString(){
		if (type == null){
			this.typeAsString = "Undefined";
		}
		else if (type == 1){
			this.typeAsString = "Lecture";
		}
		else if (type == 2){
			this.typeAsString = "Laboratory";
		} 
		else {
			this.typeAsString = "Others";
		}
		return typeAsString;
	}

	public void setTypeAsString(String typeAsString) {
		this.typeAsString = typeAsString;
	}
}
