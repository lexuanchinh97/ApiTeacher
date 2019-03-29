package net.teacher.api.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.teacher.api.dao.SubjectDao;
import net.teacher.api.model.Subject;

@Transactional
@Service("subjectService")
public class SubjectServiceImpl implements SubjectService{
	@Autowired private SubjectDao dao;
	@Override
	public void create(Subject subject) {
		// TODO Auto-generated method stub
		dao.create(subject);
	}

	@Override
	public void update(Subject subject) {
		// TODO Auto-generated method stub
		dao.update(subject);
	}

	@Override
	public Subject findOne(int id) {
		// TODO Auto-generated method stub
		return dao.findOne(id);
	}

}
