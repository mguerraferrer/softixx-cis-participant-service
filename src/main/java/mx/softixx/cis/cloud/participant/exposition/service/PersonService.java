package mx.softixx.cis.cloud.participant.exposition.service;

import mx.softixx.cis.common.participant.payload.PersonResponse;

public interface PersonService {
	
	PersonResponse findById(Long personId);
	
}