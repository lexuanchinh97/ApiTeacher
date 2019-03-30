package net.teacher.api.dao;

import net.teacher.api.model.TeacherSubject;

public interface TeacherSubjectDao {
	void create(TeacherSubject teacherSubject);
	void update(TeacherSubject teacherSubject);
	TeacherSubject findOne(int id);
}
