package com.gana.backend.service;

import java.util.List;

import com.gana.backend.model.RentalAgreement;

public interface RentalAgreementService {

	public int addRentalAgreement(RentalAgreement rentalAgreement);

	public RentalAgreement getRentalAgreement(int agreementId);

	public List<RentalAgreement> getAllRentalAgreements();

	public String updateRentalAgreement(RentalAgreement rentalAgreement);

	public String deleteRentalAgreement(int agreementId);

}
