package net.teacher.api.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the districts database table.
 * 
 */
@Entity
@Table(name="districts")
@NamedQuery(name="District.findAll", query="SELECT d FROM District d")
public class District implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String code;

	private String name;

	//bi-directional many-to-one association to Teacher
	@OneToMany(mappedBy="district")
	private List<Teacher> teachers;

	public District() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Teacher> getTeachers() {
		return this.teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public Teacher addTeacher(Teacher teacher) {
		getTeachers().add(teacher);
		teacher.setDistrict(this);

		return teacher;
	}

	public Teacher removeTeacher(Teacher teacher) {
		getTeachers().remove(teacher);
		teacher.setDistrict(null);

		return teacher;
	}

}