package com.gana.backend.service;

import java.util.List;

import com.gana.backend.model.Maintenance;

public interface MaintenanceService {

	public String addMaintenance(Maintenance maintenance);

	public Maintenance getMaintenance(int maintenanceId);

	public List<Maintenance> getAllMaintenances();

	public String updateMaintenance(Maintenance maintenance);

	public String deleteMaintenance(int maintenanceId);

}
