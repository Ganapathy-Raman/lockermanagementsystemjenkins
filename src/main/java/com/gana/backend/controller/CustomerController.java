package com.gana.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.gana.backend.model.Customer;
import com.gana.backend.service.CustomerService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000")
public class CustomerController {

	CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	@PostMapping("/register")
	public String register(@RequestBody Customer customer) {
		Customer existingCustomer = customerService.findByCustomerName(customer.getCustomerName());
		if (existingCustomer != null) {
			return "customer name already exists";
		}
		customerService.saveCustomer(customer);
		return "Customer registered successfully";
	}

	@PostMapping("/login")
	public Customer login(@RequestBody Customer customer) {
		Customer existingCustomer = customerService.findByCustomerName(customer.getCustomerName());
		if (existingCustomer != null && customer.getPassword().equals(existingCustomer.getPassword())) {
			return existingCustomer;
		} else {
			return null;
		}
	}

	@GetMapping("/{customerId}")
	public Customer getCustomerById(@PathVariable("customerId") int customerId) {
		return customerService.getCustomer(customerId);
	}

	@GetMapping("/all")
	public List<Customer> getCustomers() {
		return customerService.getAllCustomers();
	}

	@PutMapping
	public String updateCustomer(@RequestBody Customer customer) {

		String msg = "";
		try {
			customerService.updateCustomer(customer);
			msg = "Good";
		} catch (Exception e) {

			msg = "Bad";

		}
		return msg;
	}

	@DeleteMapping("{customerId}")
	public String deleteCustomerById(@PathVariable("customerId") int customerId) {
		String msg = "";
		try {
			customerService.deleteCustomer(customerId);
			msg = "Fair";
		} catch (Exception e) {

			msg = "Not";

		}
		return msg;
	}

}
