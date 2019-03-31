package net.teacher.api.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.teacher.api.dao.TeacherDao;
import net.teacher.api.model.Teacher;

@Transactional
@Service("teacherService")
public class TeacherServiceImpl implements TeacherService{
	@Autowired private TeacherDao dao;
	@Override
	public void create(Teacher teacher) {
		// TODO Auto-generated method stub
		dao.create(teacher);
	}

	@Override
	public void update(Teacher teacher) {
		// TODO Auto-generated method stub
		dao.update(teacher);
	}

	@Override
	public List<Teacher> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public List<Teacher> findAll(int gender, int subjectId, int classId, int districtId) {
		// TODO Auto-generated method stub
		return dao.findAll(gender, subjectId, classId, districtId);
	}

	@Override
	public Teacher findByPhone(String phone) {
		// TODO Auto-generated method stub
		return dao.findByPhone(phone);
	}

	@Override
	public Teacher findOne(int id) {
		// TODO Auto-generated method stub
		return dao.findOne(id);
	}

	
	
}
