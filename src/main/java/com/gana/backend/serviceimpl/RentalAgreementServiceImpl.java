package com.gana.backend.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gana.backend.model.RentalAgreement;
import com.gana.backend.repo.RentalAgreementRepo;
import com.gana.backend.service.RentalAgreementService;

@Service
public class RentalAgreementServiceImpl implements RentalAgreementService {

	RentalAgreementRepo repo;

	public RentalAgreementServiceImpl(RentalAgreementRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public int addRentalAgreement(RentalAgreement rentalAgreement) {

		return repo.save(rentalAgreement);

	}

	@Override
	public RentalAgreement getRentalAgreement(int agreementId) {

		return repo.findById(agreementId);

	}

	@Override
	public List<RentalAgreement> getAllRentalAgreements() {
		return repo.findAll();

	}

	@Override
	public String updateRentalAgreement(RentalAgreement rentalAgreement) {
		return repo.update(rentalAgreement);

	}

	@Override
	public String deleteRentalAgreement(int agreementId) {
		return repo.deleteById(agreementId);
	}

}
