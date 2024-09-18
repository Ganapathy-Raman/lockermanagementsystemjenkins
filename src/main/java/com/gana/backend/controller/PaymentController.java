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

import com.gana.backend.model.Payment;
import com.gana.backend.serviceimpl.PaymentServiceImpl;

@RestController
@RequestMapping("/payment")
@CrossOrigin("http://localhost:3000")
public class PaymentController {

	PaymentServiceImpl service;

	public PaymentController(PaymentServiceImpl service) {
		super();
		this.service = service;
	}

	@PostMapping
	public String insertPayment(@RequestBody Payment payment) {

		String msg = "";
		try {
			service.addPayment(payment);
			msg = "Success";
		} catch (Exception e) {

			msg = "Failure";

		}
		return msg;
	}

	@GetMapping("{paymentId}")
	public Payment getPaymentById(@PathVariable("paymentId") int paymentId) {
		return service.getPayment(paymentId);
	}

	@GetMapping("/all")
	public List<Payment> getPayments() {
		return service.getAllPayments();
	}

	@PutMapping
	public String updatePayment(@RequestBody Payment payment) {

		String msg = "";
		try {
			service.updatePayment(payment);
			msg = "Good";
		} catch (Exception e) {

			msg = "Bad";

		}
		return msg;
	}

	@DeleteMapping("{paymentId}")
	public String deletePaymentById(@PathVariable("paymentId") int paymentId) {
		String msg = "";
		try {
			service.deletePayment(paymentId);
			msg = "Fair";
		} catch (Exception e) {

			msg = "Not";

		}
		return msg;
	}

}
