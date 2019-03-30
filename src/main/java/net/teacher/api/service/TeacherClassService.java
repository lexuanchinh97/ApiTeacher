package net.teacher.api.service;

import net.teacher.api.model.TeacherClass;

public interface TeacherClassService {
	void create(TeacherClass teacherClass);
	void update(TeacherClass teacherClass);
	TeacherClass findOne(int id);
}
