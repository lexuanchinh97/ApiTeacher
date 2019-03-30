package net.teacher.api.service;

import net.teacher.api.model.TeacherSubject;

public interface TeacherSubjectService {
	void create(TeacherSubject teacherSubject);
	void update(TeacherSubject teacherSubject);
	TeacherSubject findOne(int id);
}
