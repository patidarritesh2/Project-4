package in.co.sunrays.bean;

import java.util.Date;

/**
 * Student JavaBean encapsulates Student attributes
 *  @author Ritesh Patidar
 *
 */
public class StudentBean extends BaseBean {
	private String firstName;
	private String lastName;
	private Date dob;
	private long mobileNo;
	private String email;
	private long collegeId;
	private String collegeName;
	
	public StudentBean() {
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(long collegeId) {
		this.collegeId = collegeId;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getKey() {
		// TODO Auto-generated method stub
		return id + "";
	}

	public String getValue() {
		// TODO Auto-generated method stub
		return firstName;
	}

	public int compareTo(BaseBean o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
