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

import com.gana.backend.model.Feedback;

import com.gana.backend.serviceimpl.FeedbackServiceImpl;

@RestController
@RequestMapping("/feedback")
@CrossOrigin("http://localhost:3000")

public class FeedbackController {

	FeedbackServiceImpl service;

	public FeedbackController(FeedbackServiceImpl service) {
		super();
		this.service = service;
	}

	@PostMapping
	public String insertFeedback(@RequestBody Feedback feedback) {

		String msg = "";
		try {
			service.addFeedback(feedback);
			msg = "Success";
		} catch (Exception e) {

			msg = "Failure";

		}
		return msg;
	}

	@GetMapping("{feedbackId}")
	public Feedback getFeedbackById(@PathVariable("feedbackId") int feedbackId) {
		return service.getFeedback(feedbackId);
	}

	@GetMapping("/customer/{customerId}")
	public Feedback getFeedbackByCustomerId(@PathVariable("customerId") int customerId) {
		return service.getFeedbackByCustomer(customerId);
	}

	@GetMapping("/all")
	public List<Feedback> getFeedbacks() {
		return service.getAllFeedbacks();
	}

	@PutMapping
	public String updateFeedback(@RequestBody Feedback feedback) {

		String msg = "";
		try {
			service.updateFeedback(feedback);
			msg = "Good";
		} catch (Exception e) {

			msg = "Bad";

		}
		return msg;
	}

	@DeleteMapping("{feedbackId}")
	public String deleteFeedbackById(@PathVariable("feedbackId") int feedbackId) {
		String msg = "";
		try {
			service.deleteFeedback(feedbackId);
			msg = "Fair";
		} catch (Exception e) {

			msg = "Not";

		}
		return msg;
	}

}
