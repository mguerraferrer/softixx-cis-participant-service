package mx.softixx.cis.cloud.participant.exposition.observavility;

import org.springframework.stereotype.Component;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import lombok.val;
import mx.softixx.cis.cloud.participant.exposition.service.DoctorService;
import mx.softixx.cis.common.participant.payload.DoctorResponse;

@Component
public class DoctorObservation {
	
	private final DoctorService doctorService;
	private final ObservationRegistry observationRegistry;
	
	public DoctorObservation(DoctorService doctorService, ObservationRegistry observationRegistry) {
		this.doctorService = doctorService;
		this.observationRegistry = observationRegistry;
	}
	
	public DoctorResponse findById(Long id) {
		val observationName = "DoctorController#findById";
		return Observation
				.createNotStarted(observationName, observationRegistry)
				.lowCardinalityKeyValue("id", String.valueOf(id))
				.observe(() -> doctorService.findById(id));
	}
	
	public DoctorResponse findByDoctorAndPerson(Long doctorId, Long personId) {
		val observationName = "DoctorController#findByDoctorAndPerson";
		return Observation
				.createNotStarted(observationName, observationRegistry)
				.lowCardinalityKeyValue("doctorId", String.valueOf(doctorId))
				.lowCardinalityKeyValue("personId", String.valueOf(personId))
				.observe(() -> doctorService.findByDoctorAndPerson(doctorId, personId));
	}
	
	public DoctorResponse findByProfessionalLicense(String professionalLicense) {
		val observationName = "DoctorController#findByProfessionalLicense";
		return Observation
				.createNotStarted(observationName, observationRegistry)
				.lowCardinalityKeyValue("professionalLicense", professionalLicense)
				.observe(() -> doctorService.findByProfessionalLicense(professionalLicense));
	}
	
}