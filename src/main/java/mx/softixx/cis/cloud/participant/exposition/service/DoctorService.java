package mx.softixx.cis.cloud.participant.exposition.service;

import mx.softixx.cis.common.participant.payload.DoctorResponse;

public interface DoctorService {
	
	DoctorResponse findById(Long doctorId);
	
	DoctorResponse findByDoctorAndPerson(Long doctorId, Long personId);
	
	DoctorResponse findByProfessionalLicense(String professionalLicense);
	
}