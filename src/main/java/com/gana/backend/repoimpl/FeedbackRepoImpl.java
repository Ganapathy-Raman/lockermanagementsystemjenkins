package com.gana.backend.repoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gana.backend.model.Feedback;
import com.gana.backend.repo.FeedbackRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class FeedbackRepoImpl implements FeedbackRepo {

	EntityManager entityManager;

	public FeedbackRepoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public String save(Feedback feedback) {
		if (feedback != null) {
			entityManager.merge(feedback);
			return "Added Successfully";
		} else {
			return "Failed to add";
		}
	}

	@Override
	public Feedback findByCustomerId(int customerId) {
		String jpql = "SELECT c FROM Customer c WHERE c.customerId.id = :customerId";

		TypedQuery<Feedback> query = entityManager.createQuery(jpql, Feedback.class);

		query.setParameter("customerId", customerId);

		Feedback feedback = query.getResultStream().findFirst().orElse(null);

		return feedback;
	}

	@Override
	public Feedback findById(int feedbackId) {
		return entityManager.find(Feedback.class, feedbackId);
	}

	@Override
	public List<Feedback> findAll() {
		return entityManager.createQuery("from Feedback", Feedback.class).getResultList();
	}

	@Override
	public String update(Feedback feedback) {
		if (feedback != null) {
			entityManager.merge(feedback);
			return "Updated Successfully";
		} else {
			return "Failed to update";
		}

	}

	@Override
	public String deleteById(int feedbackId) {
		Feedback feedback = entityManager.find(Feedback.class, feedbackId);
		if (feedback != null) {
			entityManager.remove(feedback);
			return "Deleted Successfully";
		} else {
			return "Failed to delete";
		}
	}

}
