package mx.softixx.cis.cloud.participant.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.participant.persistence.model.PersonContactInfo;
import mx.softixx.cis.cloud.participant.persistence.model.Person;

/**
 * Repository : PersonContactInfo
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface PersonContactInfoRepository extends JpaRepository<PersonContactInfo, Long> {

	/**
	 * Returns the AcademicStatusEntity that exactly matches the given id
	 * 
	 * @param id Long
	 * @return PersonContactInfo or null
	 */
	PersonContactInfo findByIdAndActiveTrue(Long id);
	
	/**
	 * Returns the PersonContactInfo associated with a {@link Person} if
	 * {@link PersonContactInfo#getPerson()} is equal to person param and
	 * {@link Person#getDeleted()} is false and
	 * {@link PersonContactInfo#getDeleted()} is false
	 * 
	 * @param person
	 * @return PersonContactInfo or null
	 */
	PersonContactInfo findByPersonAndPerson_ActiveTrueAndActiveTrue(Person person);
	
	/**
	 * Returns the AcademicStatusEntity that exactly matches the given hash
	 * 
	 * @param hash
	 * @return PersonContactInfo or null
	 */
	PersonContactInfo findByHashAndActiveTrue(String hash);
	
}