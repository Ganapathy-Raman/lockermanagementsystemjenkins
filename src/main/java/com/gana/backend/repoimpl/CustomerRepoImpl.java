package com.gana.backend.repoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gana.backend.model.Customer;
import com.gana.backend.repo.CustomerRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CustomerRepoImpl implements CustomerRepo {

	EntityManager entityManager;

	public CustomerRepoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override

	public Customer findByCustomerName(String customerName) {
		String jpql = "SELECT c FROM Customer c WHERE c.customerName = :customerName";
		TypedQuery<Customer> query = entityManager.createQuery(jpql, Customer.class);
		query.setParameter("customerName", customerName);

		try {
			return query.getSingleResult();
		} catch (NoResultException | NonUniqueResultException e) {
			return null;
		}
	}

	@Override
	public Customer save(Customer customer) {
		entityManager.merge(customer);
		return null;
	}

	@Override
	public Customer findById(int customerId) {
		return entityManager.find(Customer.class, customerId);
	}

	@Override
	public List<Customer> findAll() {
		return entityManager.createQuery("from Customer", Customer.class).getResultList();
	}

	@Override
	public String update(Customer customer) {
		if (customer != null) {
			entityManager.merge(customer);
			return "Updated Successfully";
		} else {
			return "Failed to update";
		}

	}

	@Override
	public String deleteById(int customerId) {
		Customer customer = entityManager.find(Customer.class, customerId);
		if (customer != null) {
			entityManager.remove(customer);
			return "Deleted Successfully";
		} else {
			return "Failed to delete";
		}
	}

}
