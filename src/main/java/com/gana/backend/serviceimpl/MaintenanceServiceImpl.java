package com.gana.backend.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gana.backend.model.Maintenance;
import com.gana.backend.repo.MaintenanceRepo;
import com.gana.backend.service.MaintenanceService;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

	MaintenanceRepo repo;

	public MaintenanceServiceImpl(MaintenanceRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public String addMaintenance(Maintenance maintenance) {

		return repo.save(maintenance);

	}

	@Override
	public Maintenance getMaintenance(int maintenanceId) {

		return repo.findById(maintenanceId);

	}

	@Override
	public List<Maintenance> getAllMaintenances() {
		return repo.findAll();

	}

	@Override
	public String updateMaintenance(Maintenance maintenance) {
		return repo.update(maintenance);

	}

	@Override
	public String deleteMaintenance(int maintenanceId) {
		return repo.deleteById(maintenanceId);
	}

}
