package net.teacher.api.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.teacher.api.model.Customer;

@Repository("customerDao")
public class CustomerDaoImpl extends AbstractDao<Integer, Customer> implements CustomerDao{
	
	@Autowired
	private SessionFactory sessionFactory; 
	
	@Override
	public void create(Customer customer) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(customer);
	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(customer);
	}

	@Override
	public Customer findOne(int id) {
		// TODO Auto-generated method stub
		return (Customer) sessionFactory.getCurrentSession().createCriteria(Customer.class).add(Restrictions.eq("id", id)).uniqueResult();
	}

}
