package com.gana.backend.repoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gana.backend.model.Maintenance;
import com.gana.backend.repo.MaintenanceRepo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MaintenanceRepoImpl implements MaintenanceRepo {

	EntityManager entityManager;

	public MaintenanceRepoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public String save(Maintenance maintenance) {
		if (maintenance != null) {
			entityManager.merge(maintenance);
			return "Added Successfully";
		} else {
			return "Failed to add";
		}
	}

	@Override
	public Maintenance findById(int maintenanceId) {
		return entityManager.find(Maintenance.class, maintenanceId);
	}

	@Override
	public List<Maintenance> findAll() {
		return entityManager.createQuery("from Maintenance", Maintenance.class).getResultList();
	}

	@Override
	public String update(Maintenance maintenance) {
		if (maintenance != null) {
			entityManager.merge(maintenance);
			return "Updated Successfully";
		} else {
			return "Failed to update";
		}

	}

	@Override
	public String deleteById(int maintenanceId) {
		Maintenance maintenance = entityManager.find(Maintenance.class, maintenanceId);
		if (maintenance != null) {
			entityManager.remove(maintenance);
			return "Deleted Successfully";
		} else {
			return "Failed to delete";
		}
	}

}
