package com.gana.backend.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gana.backend.model.Locker;
import com.gana.backend.repo.LockerRepo;
import com.gana.backend.service.LockerService;

@Service
public class LockerServiceImpl implements LockerService {

	LockerRepo repo;

	public LockerServiceImpl(LockerRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public String addLocker(Locker locker) {

		return repo.save(locker);

	}

	@Override
	public Locker getLocker(int lockerId) {

		return repo.findById(lockerId);

	}

	@Override
	public List<Locker> getAllLockers() {
		return repo.findAll();

	}

	@Override
	public String updateLocker(Locker locker) {
		return repo.update(locker);

	}

	@Override
	public String deleteLocker(int lockerId) {
		return repo.deleteById(lockerId);
	}

	@Override
	public Locker findById(int lockerId) {
		return repo.findById(lockerId);
	}

	public Locker getLockerByCustomer(int customerId) {
		return repo.findByCustomerId(customerId);
	}

	public List<Locker> getPendingforms() {
		return repo.getPendingLockers();
	}

	public List<Locker> getApprovedforms() {
		return repo.getApprovedLockers();
	}

	public List<Locker> getRejectedforms() {
		return repo.getRejectedLockers();
	}

	public Object getApprovedCount() {
		return repo.getApprovedCount();
	}

	public Object getRejectedCount() {
		return repo.getRejectedCount();
	}

	public Object getPendingCount() {
		return repo.getPendingCount();
	}

	public Object getLockerCount() {
		return repo.getLockerCount();
	}

	public Object getSmallCount() {
		return repo.getSmallCount();
	}

	public Object getMediumCount() {
		return repo.getMediumCount();
	}

	public Object getLargeCount() {
		return repo.getLargeCount();
	}

	public Object getExtraLargeCount() {
		return repo.getExtraLargeCount();
	}

	public Object getMaduraiCount() {
		return repo.getMaduraiCount();
	}

	public Object getDindigulCount() {
		return repo.getDindigulCount();
	}

	public Object getCoimbatoreCount() {
		return repo.getCoimbatoreCount();
	}

	public Object getTrichyCount() {
		return repo.getTrichyCount();
	}

	public Object getTanjoreCount() {
		return repo.getTanjoreCount();
	}

	public Object getChennaiCount() {
		return repo.getChennaiCount();
	}

	public Object getSalemCount() {
		return repo.getSalemCount();
	}

	public Object getKarurCount() {
		return repo.getKarurCount();
	}

	public Object getThirunelveliCount() {
		return repo.getThirunelveliCount();
	}

	public Object getKovilpattiCount() {
		return repo.getKovilpattiCount();
	}

	public Object getTuticorinCount() {
		return repo.getTuticorinCount();
	}
}
