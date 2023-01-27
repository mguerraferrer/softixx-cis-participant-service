package mx.softixx.cis.cloud.participant.converter;

import mx.softixx.cis.cloud.participant.persistence.model.Person;
import mx.softixx.cis.common.participant.payload.PersonResponse;

public final class PersonConverter {
	
	private PersonConverter() {		
	}
	
	public static final PersonResponse map(Person person) {
		if (person == null) {
			return null;
		}
		
		return PersonResponse
				.builder()
				.id(person.getId())
				.raceId(person.getRaceId())
				.academicStatusId(person.getAcademicStatusId())
				.maritalStatusId(person.getMaritalStatusId())
				.sexId(person.getSexId())
				.countryId(person.getCountryId())
				.name(person.getName())
				.paternalSurname(person.getPaternalSurname())
				.maternalSurname(person.getMaternalSurname())
				.dob(person.getDob())
				.photo(person.getPhoto())
				.rfc(person.getRfc())
				.curp(person.getCurp())
				.occupation(person.getOccupation())
				.religion(person.getReligion())
				.identity(person.getIdentity())
				.active(person.isActive())
				.build();
	}

}