package com.gana.backend.repo;

import java.util.List;

import com.gana.backend.model.RentalAgreement;

public interface RentalAgreementRepo {

	public int save(RentalAgreement RentalAgreement);

	public RentalAgreement findById(int agreementId);

	public List<RentalAgreement> findAll();

	public String update(RentalAgreement RentalAgreement);

	public String deleteById(int agreementId);

}
