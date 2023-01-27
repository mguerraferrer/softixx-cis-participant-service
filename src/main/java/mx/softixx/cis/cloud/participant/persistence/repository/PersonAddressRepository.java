package mx.softixx.cis.cloud.participant.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.participant.persistence.model.PersonAddress;
import mx.softixx.cis.cloud.participant.persistence.model.Person;

/**
 * Repository : PersonAddress
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface PersonAddressRepository extends JpaRepository<PersonAddress, Long> {
	
	/**
	 * Returns the PersonAddress that exactly matches the given id
	 * 
	 * @param id Long
	 * @return PersonAddress or null
	 */
	PersonAddress findByIdAndActiveTrue(Long id);

	/**
	 * Returns the PersonAddress associated with a {@link Person} if
	 * {@link PersonAddress#getPerson()} is equal to person param and
	 * {@link Person#getDeleted()} is false and
	 * {@link PersonAddress#getDeleted()} is false
	 * 
	 * @param person {@link Person}
	 * @return PersonAddress or null
	 */
	PersonAddress findByPersonAndPerson_ActiveTrueAndActiveTrue(Person person);
	
}