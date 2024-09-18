package com.gana.backend.model;

import java.util.Arrays;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
public class Locker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lockerId;
	@ManyToOne(targetEntity = Customer.class, cascade = CascadeType.MERGE)
	@JoinColumn(name = "Customer")
	private Customer customerId;
	private String lockerSize;
	private String location;
	private String belongingType;
	private String status;
	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] idProof;

	public Locker() {
		super();

	}

	public Locker(int lockerId, Customer customerId, String lockerSize, String location, String belongingType,
			String status, byte[] idProof) {
		super();
		this.lockerId = lockerId;
		this.customerId = customerId;
		this.lockerSize = lockerSize;
		this.location = location;
		this.belongingType = belongingType;
		this.status = status;
		this.idProof = idProof;
	}

	public int getLockerId() {
		return lockerId;
	}

	public void setLockerId(int lockerId) {
		this.lockerId = lockerId;
	}

	public Customer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}

	public String getLockerSize() {
		return lockerSize;
	}

	public void setLockerSize(String lockerSize) {
		this.lockerSize = lockerSize;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBelongingType() {
		return belongingType;
	}

	public void setBelongingType(String belongingType) {
		this.belongingType = belongingType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public byte[] getIdProof() {
		return idProof;
	}

	public void setIdProof(byte[] idProof) {
		this.idProof = idProof;
	}

	@Override
	public String toString() {
		return "Locker [lockerId=" + lockerId + ", customerId=" + customerId + ", lockerSize=" + lockerSize
				+ ", location=" + location + ", belongingType=" + belongingType + ", status=" + status + ", idProof="
				+ Arrays.toString(idProof) + "]";
	}

}
