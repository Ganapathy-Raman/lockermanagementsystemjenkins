package com.gana.backend.repo;

import java.util.List;

import com.gana.backend.model.Feedback;

public interface FeedbackRepo {

	public String save(Feedback feedback);

	public Feedback findById(int feedbackId);

	public Feedback findByCustomerId(int customerId);

	public List<Feedback> findAll();

	public String update(Feedback feedback);

	public String deleteById(int feedbackId);

}
