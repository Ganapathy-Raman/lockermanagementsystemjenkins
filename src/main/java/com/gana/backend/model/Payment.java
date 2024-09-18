package com.gana.backend.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentId;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RentalAgreement")
	@JsonIgnore
	private RentalAgreement agreementId;
	private Date paymentDate;
	private String amount;
	private String paymentMethod;
	private String status;

	public Payment() {
		super();

	}

	public Payment(int paymentId, RentalAgreement agreementId, Date paymentDate, String amount, String paymentMethod,
			String status) {
		super();
		this.paymentId = paymentId;
		this.agreementId = agreementId;
		this.paymentDate = paymentDate;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.status = status;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public RentalAgreement getAgreementId() {
		return agreementId;
	}

	public void setAgreementId(RentalAgreement agreementId) {
		this.agreementId = agreementId;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", agreementId=" + agreementId + ", paymentDate=" + paymentDate
				+ ", amount=" + amount + ", paymentMethod=" + paymentMethod + ", status=" + status + "]";
	}

}
