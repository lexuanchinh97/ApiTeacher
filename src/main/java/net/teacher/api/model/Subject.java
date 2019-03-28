package net.teacher.api.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the subjects database table.
 * 
 */
@Entity
@Table(name="subjects")
@NamedQuery(name="Subject.findAll", query="SELECT s FROM Subject s")
public class Subject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String code;

	private String name;

	private byte status;

	//bi-directional many-to-one association to Teacher
	@OneToMany(mappedBy="subject")
	private List<Teacher> teachers;

	public Subject() {
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

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public List<Teacher> getTeachers() {
		return this.teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public Teacher addTeacher(Teacher teacher) {
		getTeachers().add(teacher);
		teacher.setSubject(this);

		return teacher;
	}

	public Teacher removeTeacher(Teacher teacher) {
		getTeachers().remove(teacher);
		teacher.setSubject(null);

		return teacher;
	}

}