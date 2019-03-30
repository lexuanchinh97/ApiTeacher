package net.teacher.api.dao;

import net.teacher.api.model.TeacherClass;

public interface TeacherClassDao {
	void create(TeacherClass teacherClass);
	void update(TeacherClass teacherClass);
	TeacherClass findOne(int id);
}
