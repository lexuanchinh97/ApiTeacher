package net.teacher.api.model.request;


public class TeacherRequest {

	private String address;
	
	private String name;

	private String description;

	private String email;

	private byte gender;

	private String job;

	private String phone;

	private int salary;

	private byte status;

	private String university;
	
	private String username;
	
	private int number;
	
	private String time;
	
	private int districtId;
	
	private String listSubjectId;
	
	private String listClassId;
	

	public int getDistrictId() {
		return districtId;
	}

	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}
	
	
	
	public String getListSubjectId() {
		return listSubjectId;
	}

	public void setListSubjectId(String listSubjectId) {
		this.listSubjectId = listSubjectId;
	}

	public String getListClassId() {
		return listClassId;
	}

	public void setListClassId(String listClassId) {
		this.listClassId = listClassId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte getGender() {
		return gender;
	}

	public void setGender(byte gender) {
		this.gender = gender;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
	
}
