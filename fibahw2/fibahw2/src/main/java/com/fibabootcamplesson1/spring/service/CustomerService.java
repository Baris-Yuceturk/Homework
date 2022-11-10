package com.fibabootcamplesson1.spring.service;

import java.util.List;

import com.fibabootcamplesson1.spring.Customer;


public interface CustomerService {

	Customer find(long customerId);
	
	List<Customer> findAll();
	
	void createCustomer(Customer customer);

	void updateCustomer(Customer customer);
	
	void deleteCustomer(long customerId);
}
