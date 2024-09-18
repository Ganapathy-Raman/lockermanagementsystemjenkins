package com.gana.backend.repoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gana.backend.model.Locker;
import com.gana.backend.repo.LockerRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class LockerRepoImpl implements LockerRepo {

	EntityManager entityManager;

	public LockerRepoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public String save(Locker locker) {
		if (locker != null) {
			entityManager.merge(locker);
			return "Added Successfully";
		} else {
			return "Failed to add";
		}
	}

	@Override
	public Locker findById(int lockerId) {
		return entityManager.find(Locker.class, lockerId);
	}

	@Override
	public List<Locker> findAll() {
		return entityManager.createQuery("from Locker", Locker.class).getResultList();
	}

	@Override
	public Locker findByCustomerId(int customerId) {
		String jpql = "SELECT l FROM Locker l WHERE l.customerId.id = :customerId";

		TypedQuery<Locker> query = entityManager.createQuery(jpql, Locker.class);

		query.setParameter("customerId", customerId);

		Locker locker = query.getResultStream().findFirst().orElse(null);

		return locker;
	}

	@Override
	public String update(Locker locker) {
		if (locker != null) {
			entityManager.merge(locker);
			return "Updated Successfully";
		} else {
			return "Failed to update";
		}

	}

	@Override
	public String deleteById(int lockerId) {
		Locker locker = entityManager.find(Locker.class, lockerId);
		if (locker != null) {
			entityManager.remove(locker);
			return "Deleted Successfully";
		} else {
			return "Failed to delete";
		}
	}

	@Override
	public List<Locker> getPendingLockers() {
		return entityManager.createQuery("from Locker t where t.status = 'Pending'").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Locker> getApprovedLockers() {
		return entityManager.createQuery("from Locker t where t.status = 'Approved'").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Locker> getRejectedLockers() {
		return entityManager.createQuery("from Locker t where t.status = 'Rejected'").getResultList();
	}

	@Override
	public Object getApprovedCount() {
		Query query = entityManager.createQuery("select count(*) from Locker t where t.status = 'Approved'");
		return query.getSingleResult();
	}

	@Override
	public Object getRejectedCount() {
		Query query = entityManager.createQuery("select count(*) from Locker t where t.status = 'Rejected'");
		return query.getSingleResult();
	}

	@Override
	public Object getPendingCount() {
		Query query = entityManager.createQuery("select count(*) from Locker t where t.status = 'pending'");
		return query.getSingleResult();
	}

	@Override
	public Object getLockerCount() {
		Query query = entityManager.createQuery("SELECT COUNT(l) FROM Locker l");
		return query.getSingleResult();
	}

	@Override
	public Object getSmallCount() {
		Query query = entityManager.createQuery("select count(*) from Locker t where t.lockerSize = 'small'");
		return query.getSingleResult();
	}

	@Override
	public Object getMediumCount() {
		Query query = entityManager.createQuery("select count(*) from Locker t where t.lockerSize = 'medium'");
		return query.getSingleResult();
	}

	@Override
	public Object getLargeCount() {
		Query query = entityManager.createQuery("select count(*) from Locker t where t.lockerSize = 'large'");
		return query.getSingleResult();
	}

	@Override
	public Object getExtraLargeCount() {
		Query query = entityManager.createQuery("select count(*) from Locker t where t.lockerSize = 'extra_large'");
		return query.getSingleResult();
	}

	@Override
	public Object getMaduraiCount() {
		Query query = entityManager.createQuery("select count(*) from Locker t where t.location = 'madurai'");
		return query.getSingleResult();
	}

	@Override
	public Object getDindigulCount() {
		Query query = entityManager.createQuery("select count(*) from Locker t where t.location = 'dindigul'");
		return query.getSingleResult();
	}

	@Override
	public Object getCoimbatoreCount() {
		Query query = entityManager.createQuery("select count(*) from Locker t where t.location = 'coimbatore'");
		return query.getSingleResult();
	}

	@Override
	public Object getTrichyCount() {
		Query query = entityManager.createQuery("select count(*) from Locker t where t.location = 'trichy'");
		return query.getSingleResult();
	}

	@Override
	public Object getTanjoreCount() {
		Query query = entityManager.createQuery("select count(*) from Locker t where t.location = 'tanjore'");
		return query.getSingleResult();
	}

	@Override
	public Object getChennaiCount() {
		Query query = entityManager.createQuery("select count(*) from Locker t where t.location = 'chennai'");
		return query.getSingleResult();
	}

	@Override
	public Object getSalemCount() {
		Query query = entityManager.createQuery("select count(*) from Locker t where t.location = 'salem'");
		return query.getSingleResult();
	}

	@Override
	public Object getKarurCount() {
		Query query = entityManager.createQuery("select count(*) from Locker t where t.location = 'karur'");
		return query.getSingleResult();
	}

	@Override
	public Object getThirunelveliCount() {
		Query query = entityManager.createQuery("select count(*) from Locker t where t.location = 'thirunelveli'");
		return query.getSingleResult();
	}

	@Override
	public Object getKovilpattiCount() {
		Query query = entityManager.createQuery("select count(*) from Locker t where t.location = 'kovilpatti'");
		return query.getSingleResult();
	}

	@Override
	public Object getTuticorinCount() {
		Query query = entityManager.createQuery("select count(*) from Locker t where t.location = 'tuticorin'");
		return query.getSingleResult();
	}

}
