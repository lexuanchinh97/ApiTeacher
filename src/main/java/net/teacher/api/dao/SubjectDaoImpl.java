package net.teacher.api.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.teacher.api.model.Subject;

@Repository("subjectDao")
public class SubjectDaoImpl extends AbstractDao<Integer, Subject> implements SubjectDao{
	
	@Autowired
	private SessionFactory sessionFactory; 
	
	@Override
	public void create(Subject subject) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(subject);
	}

	@Override
	public void update(Subject subject) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(subject);
	}

	@Override
	public Subject findOne(int id) {
		// TODO Auto-generated method stub
		return (Subject) sessionFactory.getCurrentSession().createCriteria(Subject.class).add(Restrictions.eq("id", id)).uniqueResult();
	}

}
