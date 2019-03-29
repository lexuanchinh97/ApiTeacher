package net.teacher.api.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the teacher_class database table.
 * 
 */
@Entity
@Table(name="teacher_class")
@NamedQuery(name="TeacherClass.findAll", query="SELECT t FROM TeacherClass t")
public class TeacherClass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to ClassMate
	@ManyToOne
	@JoinColumn(name="classes_id")
	private ClassMate classMate;

	//bi-directional many-to-one association to Teacher
	@ManyToOne
	private Teacher teacher;

	public TeacherClass() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ClassMate getClassMate() {
		return this.classMate;
	}

	public void setClassMate(ClassMate classMate) {
		this.classMate = classMate;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}