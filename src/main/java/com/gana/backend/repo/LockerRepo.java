package com.gana.backend.repo;

import java.util.List;

import com.gana.backend.model.Locker;

public interface LockerRepo {

	public String save(Locker locker);

	public Locker findById(int lockerId);

	public Locker findByCustomerId(int customerId);

	public List<Locker> findAll();

	public String update(Locker locker);

	public String deleteById(int lockerId);

	public List<Locker> getPendingLockers();

	public List<Locker> getApprovedLockers();

	public List<Locker> getRejectedLockers();

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
