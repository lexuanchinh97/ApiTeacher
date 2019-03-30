package net.teacher.api.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.teacher.api.dao.TeacherClassDao;
import net.teacher.api.model.TeacherClass;

@Transactional
@Service("teacherClassService")
public class TeacherClassServiceImpl implements TeacherClassService{
	@Autowired TeacherClassDao dao;
	@Override
	public void create(TeacherClass teacherClass) {
		// TODO Auto-generated method stub
		dao.create(teacherClass);
	}

	@Override
	public void update(TeacherClass teacherClass) {
		// TODO Auto-generated method stub
		dao.create(teacherClass);
	}

	@Override
	public TeacherClass findOne(int id) {
		// TODO Auto-generated method stub
		return dao.findOne(id);
	}

}
