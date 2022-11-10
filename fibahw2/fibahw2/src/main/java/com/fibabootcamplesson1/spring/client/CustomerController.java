package com.fibabootcamplesson1.spring.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fibabootcamplesson1.spring.Customer;

@Controller
public class CustomerController {

	@GetMapping("/customer/get") 
	@ResponseBody
	public String getCustomer() {
		long customerId = 301;
		String url = "http://localhost:8080/api/customer/" + customerId;
		RestTemplate restTemplate = new RestTemplate();
		Customer customer = restTemplate.getForObject(url, Customer.class);
		System.out.println("ürün:  " + customer.getCustomerName());
		return "Edinme başarılı " + customer.getCustomerName() + " " + customer.getTotalDebit();
	}

	@GetMapping("/customer/post") 
	@ResponseBody
	public String postCustomer() {
		Customer customer = new Customer(0, "Orhan Gencebay", 1200);
		String url = "http://localhost:8080/api/customer";
		RestTemplate restTemplate = new RestTemplate();
		Customer result = restTemplate.postForObject(url, customer, Customer.class);
		return "Yollama başarılı " + result.getCustomerId();
	}

	@GetMapping("/customer/put") 
	@ResponseBody
	public String putCustomer() {
		Customer customer = new Customer(302, "Ferdi Tayfur", 2200);
		String url = "http://localhost:8080/api/customer";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<Customer>(customer), void.class); 
		return "Koyma başarılı ";
	}

	@GetMapping("/customer/delete") 
	@ResponseBody
	public String deleteCustomer() {
		long customerId = 303;
		String url = "http://localhost:8080/api/customer/"+customerId;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(url);
		return "Silme başarılı ";
	}
	
}
