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

import com.gana.backend.model.Maintenance;
import com.gana.backend.serviceimpl.MaintenanceServiceImpl;

@RestController
@RequestMapping("/maintenance")
@CrossOrigin("http://localhost:3000")
public class MaintenanceController {

	MaintenanceServiceImpl service;

	public MaintenanceController(MaintenanceServiceImpl service) {
		super();
		this.service = service;
	}

	@PostMapping
	public String insertMaintenance(@RequestBody Maintenance maintenance) {

		System.out.println(maintenance.getLockerId());
		String msg = "";
		try {
			service.addMaintenance(maintenance);
			msg = "Success";
		} catch (Exception e) {

			msg = "Failure";

		}
		return msg;
	}

	@GetMapping("{maintenanceId}")
	public Maintenance getMaintenanceById(@PathVariable("maintenanceId") int maintenanceId) {
		return service.getMaintenance(maintenanceId);
	}

	@GetMapping("/all")
	public List<Maintenance> getMaintenances() {
		return service.getAllMaintenances();
	}

	@PutMapping
	public String updateMaintenance(@RequestBody Maintenance maintenance) {

		String msg = "";
		try {
			service.updateMaintenance(maintenance);
			msg = "Good";
		} catch (Exception e) {

			msg = "Bad";

		}
		return msg;
	}

	@DeleteMapping("{maintenanceId}")
	public String deleteMaintenanceById(@PathVariable("maintenanceId") int maintenanceId) {
		String msg = "";
		try {
			service.deleteMaintenance(maintenanceId);
			msg = "Fair";
		} catch (Exception e) {

			msg = "Not";

		}
		return msg;
	}

}
