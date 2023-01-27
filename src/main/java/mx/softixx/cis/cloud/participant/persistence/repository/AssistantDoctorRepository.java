package mx.softixx.cis.cloud.participant.persistence.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.participant.persistence.model.AssistantDoctor;
import mx.softixx.cis.cloud.participant.persistence.model.Assistant;
import mx.softixx.cis.cloud.participant.persistence.model.Doctor;

/**
 * Repository : AssistantDoctor
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface AssistantDoctorRepository extends JpaRepository<AssistantDoctor, Long> {

	/**
	 * Returns the AssistantDoctor that exactly matches the given id
	 * 
	 * @param id Long
	 * @return AssistantDoctor or null
	 */
	AssistantDoctor findByIdAndActiveTrue(Long id);

	/**
	 * Returns the AssistantDoctor that exactly matches the given
	 * {@link Assistant} and {@link Doctor}
	 * 
	 * @param assistant {@link Assistant}
	 * @param doctor    {@link Doctor}
	 * @return AssistantDoctor or null
	 */
	AssistantDoctor findByAssistantAndAssistant_ActiveTrueAndDoctorAndDoctor_ActiveTrueAndActiveTrue(
			Assistant assistant, Doctor doctor);

	/**
	 * Returns a {@code Page<AssistantDoctor>} object associated to the given
	 * {@link Doctor} and sorted by pageable param
	 * 
	 * @param doctor   {@link Doctor}
	 * @param pageable {@link Pageable}
	 * @return {@code Page<AssistantDoctor>} or empty page
	 */
	Page<AssistantDoctor> findByDoctorAndDoctor_ActiveTrueAndDoctor_ActiveTrueAndActiveTrue(Doctor doctor,
			Pageable pageable);

	/**
	 * Returns a {@code List<AssistantDoctor>} associated to the given
	 * {@link Doctor}
	 * 
	 * @param doctor {@link Doctor}
	 * @return {@code List<AssistantDoctor>}
	 */
	List<AssistantDoctor> findByDoctorAndDoctor_ActiveTrueAndDoctor_ActiveTrueAndActiveTrue(Doctor doctor);

	/**
	 * Returns a {@code Page<AssistantDoctor>} object associated to the given
	 * {@link Assistant} and sorted by pageable param
	 * 
	 * @param assistant {@link Assistant}
	 * @param pageable  {@link Pageable}
	 * @return {@code Page<AssistantDoctor>} or empty page
	 */
	Page<AssistantDoctor> findByAssistantAndAssistant_ActiveTrueAndActiveTrue(Assistant assistant,
			Pageable pageable);

	/**
	 * Returns a {@code List<AssistantDoctor>} associated to the given
	 * {@link Assistant}
	 * 
	 * @param assistant {@link Assistant}
	 * @return {@code List<AssistantDoctor>}
	 */
	List<AssistantDoctor> findByAssistantAndAssistant_ActiveTrueAndActiveTrue(Assistant assistant);

	/**
	 * Returns a {@code List<AssistantDoctor>} associated to the given
	 * {@link Doctor}
	 * 
	 * @param doctor {@link Doctor}
	 * @return {@code List<AssistantDoctor>}
	 */
	List<AssistantDoctor> findByDoctorAndDoctor_ActiveTrueAndAssistant_ActiveTrueAndActiveTrue(
			Doctor doctor);

}