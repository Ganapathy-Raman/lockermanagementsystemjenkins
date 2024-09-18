package com.gana.backend.model;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int feedbackId;
	@ManyToOne(targetEntity = Customer.class, cascade = CascadeType.MERGE)
	@JoinColumn(name = "Customer")
	private Customer customerId;
	private Date feedbackDate;
	private String rating;
	private String comments;

	public Feedback() {
		super();

	}

	public Feedback(int feedbackId, Customer customerId, Date feedbackDate, String rating, String comments) {
		super();
		this.feedbackId = feedbackId;
		this.customerId = customerId;
		this.feedbackDate = feedbackDate;
		this.rating = rating;
		this.comments = comments;
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public Customer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}

	public Date getFeedbackDate() {
		return feedbackDate;
	}

	public void setFeedbackDate(Date feedbackDate) {
		this.feedbackDate = feedbackDate;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", customerId=" + customerId + ", feedbackDate=" + feedbackDate
				+ ", rating=" + rating + ", comments=" + comments + "]";
	}

}
