package com.gana.backend.model;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Maintenance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maintenanceId;
	@OneToOne(targetEntity = Locker.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "Locker")
	private Locker lockerId;
	private Date maintenanceDate;
	private String description;
	private String maintenanceCost;
	private String status;

	public Maintenance() {
		super();

	}

	public Maintenance(int maintenanceId, Locker lockerId, Date maintenanceDate, String description,
			String maintenanceCost, String status) {
		super();
		this.maintenanceId = maintenanceId;
		this.lockerId = lockerId;
		this.maintenanceDate = maintenanceDate;
		this.description = description;
		this.maintenanceCost = maintenanceCost;
		this.status = status;
	}

	public int getMaintenanceId() {
		return maintenanceId;
	}

	public void setMaintenanceId(int maintenanceId) {
		this.maintenanceId = maintenanceId;
	}

	public Locker getLockerId() {
		return lockerId;
	}

	public void setLockerId(Locker lockerId) {
		this.lockerId = lockerId;
	}

	public Date getMaintenanceDate() {
		return maintenanceDate;
	}

	public void setMaintenanceDate(Date maintenanceDate) {
		this.maintenanceDate = maintenanceDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMaintenanceCost() {
		return maintenanceCost;
	}

	public void setMaintenanceCost(String maintenanceCost) {
		this.maintenanceCost = maintenanceCost;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Maintenance [maintenanceId=" + maintenanceId + ", lockerId=" + lockerId + ", maintenanceDate="
				+ maintenanceDate + ", description=" + description + ", maintenanceCost=" + maintenanceCost
				+ ", status=" + status + "]";
	}

}
