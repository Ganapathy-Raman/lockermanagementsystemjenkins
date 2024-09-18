package com.gana.backend.model;

import java.util.Arrays;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class RentalAgreement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int agreementId;
	@ManyToOne(targetEntity = Customer.class, cascade = CascadeType.MERGE)
	@JoinColumn(name = "Customer")
	private Customer customerId;
	@OneToOne(targetEntity = Locker.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "Locker")
	private Locker lockerId;
	private Date startDate;
	private Date endDate;
	private String rentalFee;
	private String status;
	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] signature;

	public RentalAgreement() {
		super();

	}

	public RentalAgreement(int agreementId, Customer customerId, Locker lockerId, Date startDate, Date endDate,
			String rentalFee, String status, byte[] signature) {
		super();
		this.agreementId = agreementId;
		this.customerId = customerId;
		this.lockerId = lockerId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.rentalFee = rentalFee;
		this.status = status;
		this.signature = signature;
	}

	public int getAgreementId() {
		return agreementId;
	}

	public void setAgreementId(int agreementId) {
		this.agreementId = agreementId;
	}

	public Customer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}

	public Locker getLockerId() {
		return lockerId;
	}

	public void setLockerId(Locker lockerId) {
		this.lockerId = lockerId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getRentalFee() {
		return rentalFee;
	}

	public void setRentalFee(String rentalFee) {
		this.rentalFee = rentalFee;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public byte[] getSignature() {
		return signature;
	}

	public void setSignature(byte[] signature) {
		this.signature = signature;
	}

	@Override
	public String toString() {
		return "RentalAgreement [agreementId=" + agreementId + ", customerId=" + customerId + ", lockerId=" + lockerId
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", rentalFee=" + rentalFee + ", status="
				+ status + ", signature=" + Arrays.toString(signature) + "]";
	}

}
