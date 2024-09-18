package com.gana.backend.repoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gana.backend.model.RentalAgreement;
import com.gana.backend.repo.RentalAgreementRepo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class RentalAgreementRepoImpl implements RentalAgreementRepo {

	EntityManager entityManager;

	public RentalAgreementRepoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public int save(RentalAgreement rentalAgreement) {
		if (rentalAgreement != null) {
			RentalAgreement agreement = entityManager.merge(rentalAgreement);
			return agreement.getAgreementId();
		} else {
			return 0;
		}
	}

	@Override
	public RentalAgreement findById(int agreementId) {
		return entityManager.find(RentalAgreement.class, agreementId);
	}

	@Override
	public List<RentalAgreement> findAll() {
		return entityManager.createQuery("from RentalAgreement", RentalAgreement.class).getResultList();
	}

	@Override
	public String update(RentalAgreement rentalAgreement) {
		if (rentalAgreement != null) {
			entityManager.merge(rentalAgreement);
			return "Updated Successfully";
		} else {
			return "Failed to update";
		}

	}

	@Override
	public String deleteById(int agreementId) {
		RentalAgreement rentalAgreement = entityManager.find(RentalAgreement.class, agreementId);
		if (rentalAgreement != null) {
			entityManager.remove(rentalAgreement);
			return "Deleted Successfully";
		} else {
			return "Failed to delete";
		}
	}

}
