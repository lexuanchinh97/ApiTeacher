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
	public List<Teacher> findAll(int gender,int subjectId,int classId,int districtId) {
		// TODO Auto-generated method stub
		Criteria criteria=sessionFactory.getCurrentSession()
				.createCriteria(Teacher.class)
				.addOrder(Property.forName("id").desc());
		if(districtId>0) {
			criteria.add(Restrictions.eq("district.id", districtId));
		}
		if(classId>0) {
			criteria.createAlias("classMate", "t");
			criteria.add(Restrictions.eq("t.id", classId));
		}
		if(subjectId>0) {
			criteria.createAlias("subjects", "f");
			criteria.add(Restrictions.eq("f.id", subjectId));
		}
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return criteria.list();
	}

	@Override
	public Teacher findByPhone(String phone) {
		// TODO Auto-generated method stub
		return (Teacher) sessionFactory.getCurrentSession().createCriteria(Teacher.class).add(Restrictions.eq("phone", phone)).uniqueResult();
	}

	@Override
	public Teacher findOne(int id) {
		// TODO Auto-generated method stub
		return (Teacher) sessionFactory.getCurrentSession().createCriteria(Teacher.class).add(Restrictions.eq("id", id)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> findByCustomer(int customerId) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(Teacher.class).add(Restrictions.eq("customer.id", customerId)).list();
	}
	
	

}
