package in.co.sunrays.bean;

/**
 * Course JavaBean encapsulates Course attributes
 * 
 *
 * @author Ritesh Patidar
 *
 */
public class CourseBean extends BaseBean {
	private String Course_Name;
	private String Description;
	private String Duration;
	
	
	
	public String getCourse_Name() {
		return Course_Name;
	}
	public void setCourse_Name(String course_Name) {
		Course_Name = course_Name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getDuration() {
		return Duration;
	}
	public void setDuration(String duration) {
		Duration = duration;
	}
	public String getKey() {
		// TODO Auto-generated method stub
		return id + "";
	}
	public String getValue() {
		// TODO Auto-generated method stub
		return Course_Name;
	}
	public int compareTo(BaseBean o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
