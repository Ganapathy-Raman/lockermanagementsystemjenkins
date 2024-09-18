package com.gana.backend.repoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gana.backend.model.Payment;
import com.gana.backend.repo.PaymentRepo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PaymentRepoImpl implements PaymentRepo {

	EntityManager entityManager;

	public PaymentRepoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public String save(Payment payment) {
		if (payment != null) {
			entityManager.merge(payment);
			return "Added Successfully";
		} else {
			return "Failed to add";
		}
	}

	@Override
	public Payment findById(int paymentId) {
		return entityManager.find(Payment.class, paymentId);
	}

	@Override
	public List<Payment> findAll() {
		return entityManager.createQuery("from Payment", Payment.class).getResultList();
	}

	@Override
	public String update(Payment payment) {
		if (payment != null) {
			entityManager.merge(payment);
			return "Updated Successfully";
		} else {
			return "Failed to update";
		}

	}

	@Override
	public String deleteById(int paymentId) {
		Payment payment = entityManager.find(Payment.class, paymentId);
		if (payment != null) {
			entityManager.remove(payment);
			return "Deleted Successfully";
		} else {
			return "Failed to delete";
		}
	}

}
