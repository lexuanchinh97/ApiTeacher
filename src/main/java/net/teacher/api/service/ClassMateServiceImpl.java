package net.teacher.api.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.teacher.api.dao.ClassMateDao;
import net.teacher.api.model.ClassMate;

@Transactional
@Service("classMateService")
public class ClassMateServiceImpl implements ClassMateService{
	@Autowired private ClassMateDao dao;
	@Override
	public void create(ClassMate classMate) {
		// TODO Auto-generated method stub
		dao.create(classMate);
	}

	@Override
	public void update(ClassMate classMate) {
		// TODO Auto-generated method stub
		dao.update(classMate);
	}

	@Override
	public ClassMate findOne(int id) {
		// TODO Auto-generated method stub
		return dao.findOne(id);
	}

}
