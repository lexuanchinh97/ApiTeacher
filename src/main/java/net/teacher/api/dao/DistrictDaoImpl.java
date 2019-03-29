package net.teacher.api.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.teacher.api.model.District;

@Repository("districtDao")
public class DistrictDaoImpl extends AbstractDao<Integer, District> implements DistrictDao{
	
	@Autowired
	private SessionFactory sessionFactory; 
	
	@Override
	public void create(District district) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(district);
	}

	@Override
	public void update(District district) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(district);
	}

	@Override
	public District findOne(int id) {
		// TODO Auto-generated method stub
		return (District) sessionFactory.getCurrentSession().createCriteria(District.class).add(Restrictions.eq("id", id)).uniqueResult();
	}

}
