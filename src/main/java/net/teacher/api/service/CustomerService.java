package net.teacher.api.service;

import net.teacher.api.model.Customer;

public interface CustomerService {
	void create(Customer customer);
	void update(Customer customer);
	Customer findOne(int id);
	Customer findByUsername(String username);
}
