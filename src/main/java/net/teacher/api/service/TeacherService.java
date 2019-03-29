package net.teacher.api.service;

import java.util.List;

import net.teacher.api.model.Teacher;

public interface TeacherService {
	void create(Teacher teacher);
	void update(Teacher teacher);
	List<Teacher>findAll();
	List<Teacher>findAll(int gender,int subjectId,int classId,int districtId);
}
