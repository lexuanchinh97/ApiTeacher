package net.teacher.api.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.teacher.api.model.Teacher;


@Repository("teacherDao")
public class TeacherDaoImpl extends AbstractDao<Integer, Teacher> implements TeacherDao{
	@Autowired SessionFactory sessionFactory;
	
	@Override
	public void create(Teacher teacher) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(teacher);
	}

	@Override
	public void update(Teacher teacher) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(teacher);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> findAll() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(Teacher.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> findAll(int districtId, int subjectId, int classId, byte gender) {
		// TODO Auto-generated method stub
		Criteria criteria=sessionFactory.getCurrentSession()
				.createCriteria(Teacher.class)
				.addOrder(Property.forName("id").desc());
		if(districtId>0) {
			criteria.add(Restrictions.eq("district.id", districtId));
		}
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return criteria.list();
	}
	
	

}
