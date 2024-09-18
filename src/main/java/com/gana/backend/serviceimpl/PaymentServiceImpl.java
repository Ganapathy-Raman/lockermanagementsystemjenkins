package com.gana.backend.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gana.backend.model.Payment;
import com.gana.backend.repo.PaymentRepo;
import com.gana.backend.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	PaymentRepo repo;

	public PaymentServiceImpl(PaymentRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public String addPayment(Payment payment) {

		return repo.save(payment);

	}

	@Override
	public Payment getPayment(int paymentId) {

		return repo.findById(paymentId);

	}

	@Override
	public List<Payment> getAllPayments() {
		return repo.findAll();

	}

	@Override
	public String updatePayment(Payment payment) {
		return repo.update(payment);

	}

	@Override
	public String deletePayment(int paymentId) {
		return repo.deleteById(paymentId);
	}

}
