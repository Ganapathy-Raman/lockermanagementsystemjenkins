package com.gana.backend.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gana.backend.model.Feedback;
import com.gana.backend.repo.FeedbackRepo;
import com.gana.backend.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	FeedbackRepo repo;

	public FeedbackServiceImpl(FeedbackRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public String addFeedback(Feedback feedback) {

		return repo.save(feedback);

	}

	@Override
	public Feedback getFeedback(int feedbackId) {

		return repo.findById(feedbackId);

	}

	@Override
	public List<Feedback> getAllFeedbacks() {
		return repo.findAll();

	}

	@Override
	public String updateFeedback(Feedback feedback) {
		return repo.update(feedback);

	}

	@Override
	public String deleteFeedback(int feedbackId) {
		return repo.deleteById(feedbackId);
	}

	@Override
	public Feedback getFeedbackByCustomer(int customerId) {
		return repo.findByCustomerId(customerId);
	}

}
