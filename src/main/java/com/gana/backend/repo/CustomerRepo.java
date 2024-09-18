package com.gana.backend.repo;

import java.util.List;

import com.gana.backend.model.Customer;

public interface CustomerRepo {

	public Customer findByCustomerName(String customerName);

	public Customer save(Customer customer);

	public Customer findById(int customerId);

	public List<Customer> findAll();

	public String update(Customer customer);

	public String deleteById(int customerId);

}
