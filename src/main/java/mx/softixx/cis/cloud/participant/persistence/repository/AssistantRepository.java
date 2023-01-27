package mx.softixx.cis.cloud.participant.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.participant.persistence.model.Assistant;

/**
 * Repository : Assistant
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface AssistantRepository extends JpaRepository<Assistant, Long> {

	/**
	 * Returns the Assistant that exactly matches the given id and have the active field set to true
	 * 
	 * @param id
	 * @return Assistant or null
	 */
	Assistant findByIdAndActiveTrue(Long id);
	
}