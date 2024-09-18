package com.gana.backend.service;

import java.util.List;

import com.gana.backend.model.Feedback;

public interface FeedbackService {

	public String addFeedback(Feedback feedback);

	public Feedback getFeedback(int feedbackId);

	public List<Feedback> getAllFeedbacks();

	public String updateFeedback(Feedback feedback);

	public String deleteFeedback(int feedbackId);

	public Feedback getFeedbackByCustomer(int customerId);

}
