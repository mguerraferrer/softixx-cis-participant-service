package mx.softixx.cis.cloud.participant.exposition.observavility;

import org.springframework.stereotype.Component;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import lombok.val;
import mx.softixx.cis.cloud.participant.exposition.service.PersonService;
import mx.softixx.cis.common.participant.payload.PersonResponse;

@Component
public class PersonObservation {

	private final PersonService personService;
	private final ObservationRegistry observationRegistry;

	public PersonObservation(PersonService personService, ObservationRegistry observationRegistry) {
		this.personService = personService;
		this.observationRegistry = observationRegistry;
	}
	
	public PersonResponse findById(Long id) {
		val observationName = "PersonController#findById";
		return Observation
				.createNotStarted(observationName, observationRegistry)
				.lowCardinalityKeyValue("id", String.valueOf(id))
				.observe(() -> personService.findById(id));
	}

}