package com.gana.backend.service;

import java.util.List;

import com.gana.backend.model.Payment;

public interface PaymentService {

	public String addPayment(Payment payment);

	public Payment getPayment(int paymentId);

	public List<Payment> getAllPayments();

	public String updatePayment(Payment payment);

	public String deletePayment(int PaymentId);

}
