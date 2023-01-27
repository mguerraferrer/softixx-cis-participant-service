package mx.softixx.cis.cloud.participant.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.participant.persistence.model.Nurse;

/**
 * Repository : Nurse
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface NurseRepository extends JpaRepository<Nurse, Long> {

	/**
	 * Returns the Nurse that exactly matches the given id
	 * 
	 * @param id Long
	 * @return Nurse or null
	 */
	Nurse findByIdAndActiveTrue(Long id);
	
}