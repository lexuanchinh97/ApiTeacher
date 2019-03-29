package net.teacher.api.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the teacher_subject database table.
 * 
 */
@Entity
@Table(name="teacher_subject")
@NamedQuery(name="TeacherSubject.findAll", query="SELECT t FROM TeacherSubject t")
public class TeacherSubject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to Subject
	@ManyToOne
	private Subject subject;

	//bi-directional many-to-one association to Teacher
	@ManyToOne
	private Teacher teacher;

	public TeacherSubject() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}