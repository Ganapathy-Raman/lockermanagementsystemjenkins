package com.gana.backend.service;

import java.util.List;

import com.gana.backend.model.Customer;

public interface CustomerService {

	public Customer getCustomer(int customerId);

	public List<Customer> getAllCustomers();

	public String updateCustomer(Customer customer);

	public String deleteCustomer(int customerId);

	public Customer findByCustomerName(String customerName);

	public Customer saveCustomer(Customer customer);

	public Customer findById(int customerId);

}
