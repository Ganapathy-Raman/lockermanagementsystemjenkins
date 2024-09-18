package com.gana.backend.repo;

import java.util.List;

import com.gana.backend.model.Payment;

public interface PaymentRepo {

	public String save(Payment Payment);

	public Payment findById(int PaymentId);

	public List<Payment> findAll();

	public String update(Payment Payment);

	public String deleteById(int PaymentId);

}
