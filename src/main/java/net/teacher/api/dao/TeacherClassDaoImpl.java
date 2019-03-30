package net.teacher.api.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.teacher.api.model.TeacherClass;

@Repository("teacherClassDao")
public class TeacherClassDaoImpl extends AbstractDao<Integer, TeacherClass> implements TeacherClassDao{
	
	@Autowired
	private SessionFactory sessionFactory; 
	
	@Override
	public void create(TeacherClass teacherClass) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(teacherClass);
	}

	@Override
	public void update(TeacherClass teacherClass) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(teacherClass);
	}

	@Override
	public TeacherClass findOne(int id) {
		// TODO Auto-generated method stub
		return (TeacherClass) sessionFactory.getCurrentSession().createCriteria(TeacherClass.class).add(Restrictions.eq("id", id)).uniqueResult();
	}

}
