package mx.softixx.cis.cloud.participant.exposition.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.val;
import mx.softixx.cis.cloud.participant.converter.DoctorConverter;
import mx.softixx.cis.cloud.participant.persistence.repository.DoctorRepository;
import mx.softixx.cis.common.participant.exception.DoctorNotFoundException;
import mx.softixx.cis.common.participant.payload.DoctorResponse;

@Service
@Transactional(readOnly = true)
public class DoctorServiceImpl implements DoctorService {

	private final PersonService personService;
	private final DoctorRepository doctorRepository;

	public DoctorServiceImpl(PersonService personService, DoctorRepository doctorRepository) {
		this.personService = personService;
		this.doctorRepository = doctorRepository;
	}

	@Override
	public DoctorResponse findById(Long doctorId) {
		return doctorRepository.findByIdAndActiveTrue(doctorId)
							   .map(DoctorConverter::map)
							   .orElseThrow(() -> new DoctorNotFoundException(doctorId));
	}

	@Override
	public DoctorResponse findByDoctorAndPerson(Long doctorId, Long personId) {
		val doctor = findById(doctorId);
		val person = personService.findById(personId);
		doctor.setPerson(person);
		return doctor;
	}

	@Override
	public DoctorResponse findByProfessionalLicense(String professionalLicense) {
		val doctor = doctorRepository.findByProfessionalLicense(professionalLicense);
		if (doctor != null) {
			return DoctorConverter.map(doctor);
		}
		return null;
	}

}