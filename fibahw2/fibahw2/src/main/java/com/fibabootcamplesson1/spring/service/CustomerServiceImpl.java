package com.fibabootcamplesson1.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fibabootcamplesson1.spring.Customer;


@Service
public class CustomerServiceImpl implements CustomerService{

	@Override
	public Customer find(long customerId) {
		Customer customer = new Customer(customerId,"Orhan Gencebay", 1200);
		System.out.println("İşgörü çalıştı. ");
		return customer;
	}

	
	@Override
	public List<Customer> findAll() {
		List<Customer> customerList = new ArrayList<>();
		customerList.add(new Customer(301, "Orhan Gencebay", 1200));
		customerList.add(new Customer(302, "Ferdi Tayfur", 2200));
		customerList.add(new Customer(303, "Cem Karaca", 3400));
		return customerList;
	}


	@Override
	public void createCustomer(Customer customer) {
		customer.setCustomerId(301);
		System.out.println("Müşteri eklendi " + customer.getCustomerId() + " " + customer.getCustomerName() + " "
				+ customer.getTotalDebit());
	}


	@Override
	public void updateCustomer(Customer customer) {
		System.out.println("Müşteri eklendi " + customer.getCustomerId() + " " + customer.getCustomerName() + " "
				+ customer.getTotalDebit());		
	}


	@Override
	public void deleteCustomer(long customerId) {
		System.out.println("Müşteri silindi " + customerId);		
	}

	
	
}
