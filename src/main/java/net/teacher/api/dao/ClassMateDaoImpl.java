package net.teacher.api.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.teacher.api.model.ClassMate;

@Repository("ClassMateDao")
public class ClassMateDaoImpl extends AbstractDao<Integer, ClassMate> implements ClassMateDao{
	
	@Autowired
	private SessionFactory sessionFactory; 
	
	@Override
	public void create(ClassMate classMate) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(classMate);
	}

	@Override
	public void update(ClassMate classMate) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(classMate);
	}

	@Override
	public ClassMate findOne(int id) {
		// TODO Auto-generated method stub
		return (ClassMate) sessionFactory.getCurrentSession().createCriteria(ClassMate.class).add(Restrictions.eq("id", id)).uniqueResult();
	}

}
