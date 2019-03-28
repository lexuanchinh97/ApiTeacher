package net.teacher.api.repository;


import org.springframework.data.repository.CrudRepository;

import net.teacher.api.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{
	Customer findByUsername(String username);
}
