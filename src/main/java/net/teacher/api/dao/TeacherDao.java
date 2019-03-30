package net.teacher.api.dao;

import java.util.List;

import net.teacher.api.model.Teacher;

public interface TeacherDao {
	void create(Teacher teacher);
	void update(Teacher teacher);
	List<Teacher>findAll();
	List<Teacher>findAll(int gender,int subjectId,int classId,int districtId);
	Teacher findByPhone(String phone);
}
