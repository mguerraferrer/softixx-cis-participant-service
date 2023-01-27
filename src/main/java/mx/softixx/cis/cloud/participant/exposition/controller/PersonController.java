package mx.softixx.cis.cloud.participant.exposition.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.val;
import mx.softixx.cis.cloud.participant.exposition.observavility.PersonObservation;
import mx.softixx.cis.common.participant.payload.PersonResponse;

@RestController
@RequestMapping("/api/v1/persons")
public class PersonController {
	
	private final PersonObservation personObservation;
	
	public PersonController(PersonObservation personObservation) {
		this.personObservation = personObservation;
	}

	@GetMapping("/{id}")
	public ResponseEntity<PersonResponse> findById(@PathVariable Long id) {
		val response = personObservation.findById(id);
		return ResponseEntity.ok(response);
	}
	
}