package com.gana.backend.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gana.backend.model.Customer;
import com.gana.backend.model.Locker;
import com.gana.backend.service.CustomerService;
import com.gana.backend.service.EmailService;
import com.gana.backend.service.LockerService;
import com.gana.backend.serviceimpl.LockerServiceImpl;

import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/locker")
@CrossOrigin("http://localhost:3000")
public class LockerController {

	LockerServiceImpl service;

	public LockerController(LockerServiceImpl service) {
		super();
		this.service = service;
	}

	@Autowired
	private CustomerService customerService;

	@Autowired
	private LockerService lockerService;

	@Autowired
	private EmailService emailService;

	@PostMapping
	public String insertLocker(@RequestParam("customerId") int customerId,
			@RequestParam("lockerSize") String lockerSize, @RequestParam("location") String location,
			@RequestParam("belongingType") String belongingType, @RequestParam("status") String status,
			@RequestParam("idProof") MultipartFile idProof) {

		try {
			Customer customer = customerService.findById(customerId);
			if (customer == null) {
				return "Customer not found";
			}

			byte[] idProofBytes = idProof.getBytes();
			Locker locker = new Locker(0, customer, lockerSize, location, belongingType, status, idProofBytes);
			lockerService.addLocker(locker);

			return "Success";
		} catch (IOException e) {
			return "Failure: IOException";
		} catch (Exception e) {
			return "Failure: Exception";
		}
	}

	@GetMapping("{lockerId}")
	public Locker getLockerById(@PathVariable("lockerId") int lockerId) {
		return service.getLocker(lockerId);
	}

	@GetMapping("/customer/{customerId}")
	public Locker getLockerByCustomerId(@PathVariable("customerId") int customerId) {
		return service.getLockerByCustomer(customerId);
	}

	@GetMapping("/all")
	public List<Locker> getLockers() {
		return service.getAllLockers();
	}

	@PutMapping
	public ResponseEntity<String> updateLocker(@RequestBody Locker locker) {
		try {
			service.updateLocker(locker);
			return ResponseEntity.ok("Locker record updated successfully.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating locker record.");
		}
	}

	@DeleteMapping("{lockerId}")
	public String deletelockerById(@PathVariable("lockerId") int lockerId) {
		String msg = "";
		try {
			service.deleteLocker(lockerId);
			msg = "Fair";
		} catch (Exception e) {

			msg = "Not";

		}
		return msg;
	}

	@PostMapping("/sendEmail")
	public ResponseEntity<String> sendEmail(@RequestParam String from, @RequestParam String to,
			@RequestParam String subject, @RequestParam String body,
			@RequestParam(required = false) MultipartFile attachment) {
		try {

			emailService.sendEmail(to, subject, body, attachment);
			return ResponseEntity.ok("Email sent successfully");
		} catch (MessagingException | IOException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed to send email: " + e.getMessage());
		}
	}

	@GetMapping("/getpendingformList")
	public List<Locker> getBookings() {
		return lockerService.getPendingforms();
	}

	@GetMapping("/getApprovedformList")
	public List<Locker> getApproveBookings() {
		return lockerService.getApprovedforms();
	}

	@GetMapping("/getRejectedformList")
	public List<Locker> getRejectedBookings() {
		return lockerService.getRejectedforms();
	}

	@GetMapping("/getapproveCount")
	public Object getApprovedCount() {
		return lockerService.getApprovedCount();
	}

	@GetMapping("/getrejectedCount")
	public Object getRejectedCount() {
		return lockerService.getRejectedCount();
	}

	@GetMapping("/getpendingCount")
	public Object getPendingCount() {
		return lockerService.getPendingCount();
	}

	@GetMapping("/getlockerCount")
	public Object getLockerCount() {
		return lockerService.getLockerCount();
	}

	@GetMapping("/getsmallCount")
	public Object getSmallCount() {
		return lockerService.getSmallCount();
	}

	@GetMapping("/getmediumCount")
	public Object getMediumCount() {
		return lockerService.getMediumCount();
	}

	@GetMapping("/getlargeCount")
	public Object getLargeCount() {
		return lockerService.getLargeCount();
	}

	@GetMapping("/getextralargeCount")
	public Object getExtraLargeCount() {
		return lockerService.getExtraLargeCount();
	}

	@GetMapping("/getmaduraiCount")
	public Object getMaduraiCount() {
		return lockerService.getMaduraiCount();
	}

	@GetMapping("/getdindigulCount")
	public Object getDindigulCount() {
		return lockerService.getDindigulCount();
	}

	@GetMapping("/getcoimbatoreCount")
	public Object getCoimbatoreCount() {
		return lockerService.getCoimbatoreCount();
	}

	@GetMapping("/getsalemCount")
	public Object getSalemCount() {
		return lockerService.getSalemCount();
	}

	@GetMapping("/getkarurCount")
	public Object getKarurCount() {
		return lockerService.getKarurCount();
	}

	@GetMapping("/getthirunelveliCount")
	public Object getThirunelveliCount() {
		return lockerService.getThirunelveliCount();
	}

	@GetMapping("/getkovilpattiCount")
	public Object getKovilpattiCount() {
		return lockerService.getKovilpattiCount();
	}

	@GetMapping("/gettuticorinCount")
	public Object getTuticorinCount() {
		return lockerService.getTuticorinCount();
	}

	@GetMapping("/gettrichyCount")
	public Object getTrichyCount() {
		return lockerService.getTrichyCount();
	}

	@GetMapping("/gettanjoreCount")
	public Object getTanjoreCount() {
		return lockerService.getTanjoreCount();
	}

	@GetMapping("/getchennaiCount")
	public Object getChennaiCount() {
		return lockerService.getChennaiCount();
	}

}
