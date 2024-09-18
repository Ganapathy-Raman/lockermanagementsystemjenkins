package com.gana.backend.service;

import java.util.List;

import com.gana.backend.model.Locker;

public interface LockerService {

	public String addLocker(Locker locker);

	public Locker getLocker(int lockerId);

	public List<Locker> getAllLockers();

	public String updateLocker(Locker locker);

	public String deleteLocker(int lockerId);

	public Locker findById(int lockerId);

	public Locker getLockerByCustomer(int customerId);

	public List<Locker> getPendingforms();

	public List<Locker> getApprovedforms();

	public List<Locker> getRejectedforms();

	Object getApprovedCount();

	Object getRejectedCount();

	Object getPendingCount();

	Object getLockerCount();

	Object getSmallCount();

	Object getMediumCount();

	Object getLargeCount();

	Object getExtraLargeCount();

	Object getMaduraiCount();

	Object getDindigulCount();

	Object getCoimbatoreCount();

	Object getTrichyCount();

	Object getTanjoreCount();

	Object getChennaiCount();

	Object getSalemCount();

	Object getKarurCount();

	Object getThirunelveliCount();

	Object getKovilpattiCount();

	Object getTuticorinCount();

}
