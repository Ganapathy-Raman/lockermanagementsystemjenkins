package com.gana.backend.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gana.backend.model.Customer;
import com.gana.backend.model.Locker;
import com.gana.backend.model.RentalAgreement;
import com.gana.backend.service.CustomerService;
import com.gana.backend.service.LockerService;
import com.gana.backend.service.RentalAgreementService;
import com.gana.backend.serviceimpl.RentalAgreementServiceImpl;

@RestController
@RequestMapping("/rentalAgreement")
@CrossOrigin("http://localhost:3000")
public class RentalAgreementController {

	RentalAgreementServiceImpl service;

	public RentalAgreementController(RentalAgreementServiceImpl service) {
		super();
		this.service = service;
	}

	@Autowired
	private CustomerService customerService;

	@Autowired
	private LockerService lockerService;

	@Autowired
	private RentalAgreementService rentalAgreementService;

	@PostMapping
	public String insertRentalAgreement(@RequestParam("customerId") int customerId,
			@RequestParam("lockerId") int lockerId, @RequestParam("startDate") Date startDate,
			@RequestParam("endDate") Date endDate, @RequestParam("rentalFee") String rentalFee,
			@RequestParam("status") String status, @RequestParam("signature") MultipartFile signature) {

		try {
			Customer customer = customerService.findById(customerId);
			if (customer == null) {
				return "Customer not found";
			}

			Locker locker = lockerService.findById(lockerId);
			if (locker == null) {
				return "Locker not found";
			}

			byte[] signatureBytes = signature.getBytes();
			RentalAgreement rentalAgreement = new RentalAgreement(0, customer, locker, startDate, endDate, rentalFee,
					status, signatureBytes);
			int agreementId = rentalAgreementService.addRentalAgreement(rentalAgreement);

			String result = "";
			result = result + agreementId;

			return result;
		} catch (IOException e) {
			return "Failure: IOException";
		} catch (Exception e) {
			return "Failure: Exception";
		}
	}

	@GetMapping("{agreementId}")
	public RentalAgreement getRentalAgreementById(@PathVariable("agreementId") int agreementId) {
		return service.getRentalAgreement(agreementId);
	}

	@GetMapping("/all")
	public List<RentalAgreement> getRentalAgreements() {
		return service.getAllRentalAgreements();
	}

	@PutMapping
	public String updateRentalAgreement(@RequestParam("agreementId") int agreementId,
			@RequestParam("customerId") int customerId, @RequestParam("lockerId") int lockerId,
			@RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate,
			@RequestParam("rentalFee") String rentalFee, @RequestParam("status") String status,
			@RequestParam("signature") MultipartFile signature) {

		try {
			Customer customer = customerService.findById(customerId);
			if (customer == null) {
				return "Customer not found";
			}

			Locker locker = lockerService.findById(lockerId);
			if (locker == null) {
				return "Locker not found";
			}

			byte[] signatureBytes = signature.getBytes();
			RentalAgreement rentalAgreement = new RentalAgreement(agreementId, customer, locker, startDate, endDate,
					rentalFee, status, signatureBytes);
			rentalAgreementService.updateRentalAgreement(rentalAgreement);

			return "Success";
		} catch (IOException e) {
			return "Failure: IOException";
		} catch (Exception e) {
			return "Failure: Exception";
		}
	}

	@DeleteMapping("{agreementId}")
	public String deleteRentalAgreementById(@PathVariable("agreementId") int agreementId) {
		String msg = "";
		try {
			service.deleteRentalAgreement(agreementId);
			msg = "Fair";
		} catch (Exception e) {

			msg = "Not";

		}
		return msg;
	}

}
