package mx.softixx.cis.cloud.participant.exposition.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.val;
import mx.softixx.cis.cloud.participant.exposition.observavility.DoctorObservation;
import mx.softixx.cis.common.participant.payload.DoctorResponse;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {
	
	private final DoctorObservation doctorObservation;
	
	public DoctorController(DoctorObservation doctorObservation) {
		this.doctorObservation = doctorObservation;
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<DoctorResponse> findById(@PathVariable Long id) {
		val response = doctorObservation.findById(id);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/id/{doctorId}/person/{personId}")
	public ResponseEntity<DoctorResponse> findByDoctorAndPerson(@PathVariable Long doctorId,
																@PathVariable Long personId) {
		val response = doctorObservation.findByDoctorAndPerson(doctorId, personId);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/pl/{pl}")
	public ResponseEntity<DoctorResponse> findByProfessionalLicense(@PathVariable String pl) {
		val response = doctorObservation.findByProfessionalLicense(pl);
		return ResponseEntity.ok(response);
	}
	
}