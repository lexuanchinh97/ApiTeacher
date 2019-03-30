package net.teacher.api.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.teacher.api.dao.TeacherSubjectDao;
import net.teacher.api.model.TeacherSubject;

@Transactional
@Service("teacherSubjectService")
public class TeacherSubjectServiceImpl implements TeacherSubjectService{
	@Autowired private TeacherSubjectDao dao;

	@Override
	public void create(TeacherSubject teacherSubject) {
		// TODO Auto-generated method stub
		dao.create(teacherSubject);
	}

	@Override
	public void update(TeacherSubject teacherSubject) {
		// TODO Auto-generated method stub
		dao.update(teacherSubject);
	}

	@Override
	public TeacherSubject findOne(int id) {
		// TODO Auto-generated method stub
		return dao.findOne(id);
	}
	
}
