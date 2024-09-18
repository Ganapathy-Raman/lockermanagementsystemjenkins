package com.gana.backend.repo;

import java.util.List;

import com.gana.backend.model.Maintenance;

public interface MaintenanceRepo {

	public String save(Maintenance maintenance);

	public Maintenance findById(int maintenanceId);

	public List<Maintenance> findAll();

	public String update(Maintenance maintenance);

	public String deleteById(int maintenanceId);

}
