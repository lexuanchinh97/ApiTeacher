package net.teacher.api.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;


/**
 * The persistent class for the teachers database table.
 * 
 */
@Entity
@Table(name="teachers")
@NamedQuery(name="Teacher.findAll", query="SELECT t FROM Teacher t")
public class Teacher implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String address;
	
	private String name;

	@Lob
	private String description;

	private String email;

	private byte gender;

	private String job;

	private String phone;

	private int salary;

	private byte status;

	private String university;

	//bi-directional many-to-one association to TeacherClass
	@JsonIgnore
	@OneToMany(mappedBy="teacher")
	private List<TeacherClass> teacherClasses;

	//bi-directional many-to-one association to TeacherSubject
	@JsonIgnore
	@OneToMany(mappedBy="teacher")
	private List<TeacherSubject> teacherSubjects;

	//bi-directional many-to-one association to District
	@ManyToOne()
	private District district;
	
	@ManyToMany
	@JoinTable(name = "teacher_subject",
	joinColumns = @JoinColumn(name = "teacher_id"),
	inverseJoinColumns = @JoinColumn(name = "subject_id"))
	@JsonManagedReference
	private List<Subject> subjects;
	
	@ManyToMany
	@JoinTable(name = "teacher_class",
	joinColumns = @JoinColumn(name = "teacher_id"),
	inverseJoinColumns = @JoinColumn(name = "classes_id"))
	@JsonManagedReference
	private List<ClassMate> classMate;

	public Teacher() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte getGender() {
		return this.gender;
	}

	public void setGender(byte gender) {
		this.gender = gender;
	}

	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getSalary() {
		return this.salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public String getUniversity() {
		return this.university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public District getDistrict() {
		return this.district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public List<ClassMate> getClassMate() {
		return classMate;
	}

	public void setClassMate(List<ClassMate> classMate) {
		this.classMate = classMate;
	}
	
	
}