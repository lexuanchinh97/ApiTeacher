package net.teacher.api.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.teacher.api.model.TeacherSubject;

@Repository("teacherSubjectDao")
public class TeacherSubjectDaoImpl extends AbstractDao<Integer, TeacherSubject> implements TeacherSubjectDao{
	
	@Autowired
	private SessionFactory sessionFactory; 
	
	@Override
	public void create(TeacherSubject teacherSubject) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(teacherSubject);
	}

	@Override
	public void update(TeacherSubject teacherSubject) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(teacherSubject);
	}

	@Override
	public TeacherSubject findOne(int id) {
		// TODO Auto-generated method stub
		return (TeacherSubject) sessionFactory.getCurrentSession().createCriteria(TeacherSubject.class).add(Restrictions.eq("id", id)).uniqueResult();
	}

}
