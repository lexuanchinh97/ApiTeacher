package net.teacher.api.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the class_mate database table.
 * 
 */
@Entity
@Table(name="class_mate")
@NamedQuery(name="ClassMate.findAll", query="SELECT c FROM ClassMate c")
public class ClassMate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String code;

	private String name;

	private byte status;

	//bi-directional many-to-one association to TeacherClass
	@JsonIgnore
	@OneToMany(mappedBy="classMate")
	private List<TeacherClass> teacherClasses;

	public ClassMate() {
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

	public List<TeacherClass> getTeacherClasses() {
		return this.teacherClasses;
	}

	public void setTeacherClasses(List<TeacherClass> teacherClasses) {
		this.teacherClasses = teacherClasses;
	}

	public TeacherClass addTeacherClass(TeacherClass teacherClass) {
		getTeacherClasses().add(teacherClass);
		teacherClass.setClassMate(this);

		return teacherClass;
	}

	public TeacherClass removeTeacherClass(TeacherClass teacherClass) {
		getTeacherClasses().remove(teacherClass);
		teacherClass.setClassMate(null);

		return teacherClass;
	}

}