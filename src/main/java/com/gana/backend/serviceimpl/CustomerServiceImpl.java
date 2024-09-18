package com.gana.backend.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gana.backend.model.Customer;
import com.gana.backend.repo.CustomerRepo;
import com.gana.backend.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	CustomerRepo repo;

	public CustomerServiceImpl(CustomerRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Customer getCustomer(int customerId) {

		return repo.findById(customerId);

	}

	@Override
	public List<Customer> getAllCustomers() {
		return repo.findAll();

	}

	@Override
	public String updateCustomer(Customer customer) {
		return repo.update(customer);

	}

	@Override
	public String deleteCustomer(int customerId) {
		return repo.deleteById(customerId);
	}

	@Override
	public Customer findByCustomerName(String customerName) {
		return repo.findByCustomerName(customerName);
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		customer.setPassword((customer.getPassword()));
		return repo.save(customer);
	}

	@Override
	public Customer findById(int customerId) {
		return repo.findById(customerId);
	}

}
