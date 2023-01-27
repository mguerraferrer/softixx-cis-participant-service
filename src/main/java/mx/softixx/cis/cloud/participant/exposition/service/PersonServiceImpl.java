package mx.softixx.cis.cloud.participant.exposition.service;

import org.springframework.stereotype.Service;

import mx.softixx.cis.cloud.participant.converter.PersonConverter;
import mx.softixx.cis.cloud.participant.persistence.repository.PersonRepository;
import mx.softixx.cis.common.participant.exception.PersonNotFoundException;
import mx.softixx.cis.common.participant.payload.PersonResponse;

@Service
public class PersonServiceImpl implements PersonService {

	private final PersonRepository personRepository;
	
	public PersonServiceImpl(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Override
	public PersonResponse findById(Long personId) {
		return personRepository.findByIdAndActiveTrue(personId)
							   .map(PersonConverter::map)
							   .orElseThrow(() -> new PersonNotFoundException(personId));
	}

}