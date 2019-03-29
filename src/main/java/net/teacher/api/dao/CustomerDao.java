package net.teacher.api.dao;

import net.teacher.api.model.Customer;

public interface CustomerDao {
	void create(Customer customer);
	void update(Customer customer);
	Customer findOne(int id);
}
