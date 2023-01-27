package mx.softixx.cis.cloud.participant.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.participant.persistence.model.Patient;
import mx.softixx.cis.cloud.participant.persistence.model.Person;

/**
 * Repository : Patient
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface PatientRepository extends JpaRepository<Patient, Long> {

	/**
	 * Returns the Patient that exactly matches the given id
	 * 
	 * @param id Long
	 * @return Patient or null
	 */
	Patient findByIdAndActiveTrue(Long id);

	/**
	 * Returns the Patient if {@link Patient#getPerson()} is equal to
	 * person param and {@link Patient#getPerson#getDeleted()} is false and
	 * {@link Patient#getDeleted()} is false
	 * 
	 * @param person {@link Person}
	 * @return Patient or null
	 */
	Patient findByPersonAndPerson_ActiveTrueAndActiveTrue(Person person);	
	
}