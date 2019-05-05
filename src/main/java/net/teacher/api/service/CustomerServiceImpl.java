package net.teacher.api.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.teacher.api.dao.CustomerDao;
import net.teacher.api.model.Customer;

@Transactional
@Service("customerService")
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDao dao;
	
	@Override
	public void create(Customer customer) {
		// TODO Auto-generated method stub
		dao.create(customer);
	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		dao.update(customer);
	}

	@Override
	public Customer findOne(int id) {
		// TODO Auto-generated method stub
		return dao.findOne(id);
	}

	@Override
	public Customer findByUsername(String username) {
		// TODO Auto-generated method stub
		return dao.findByUsername(username);
	}

}
