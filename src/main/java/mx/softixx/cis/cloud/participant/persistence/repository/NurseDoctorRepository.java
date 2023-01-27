package mx.softixx.cis.cloud.participant.persistence.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.participant.persistence.model.Doctor;
import mx.softixx.cis.cloud.participant.persistence.model.NurseDoctor;
import mx.softixx.cis.cloud.participant.persistence.model.Nurse;

/**
 * Repository : NurseDoctor
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface NurseDoctorRepository extends JpaRepository<NurseDoctor, Long> {

	/**
	 * Returns the NurseDoctor that exactly matches the given id
	 * 
	 * @param id Long
	 * @return NurseDoctor or null
	 */
	NurseDoctor findByIdAndActiveTrue(Long id);

	/**
	 * Returns the NurseDoctor that exactly matches the given
	 * {@link Nurse} and {@link Doctor}
	 * 
	 * @param nurse  {@link Nurse}
	 * @param doctor {@link Doctor}
	 * @return NurseDoctor or null
	 */
	NurseDoctor findByNurseAndNurse_ActiveTrueAndDoctorAndDoctor_ActiveTrueAndActiveTrue(Nurse nurse,
			Doctor doctor);

	/**
	 * Returns a {@code Page<NurseDoctor>} object associated to the given
	 * {@link Doctor} and sorted by pageable param
	 * 
	 * @param doctor   {@link Doctor}
	 * @param pageable {@link Pageable}
	 * @return {@code Page<NurseDoctor>} or empty page
	 */
	Page<NurseDoctor> findByDoctorAndDoctor_ActiveTrueAndDoctor_ActiveTrueAndActiveTrue(Doctor doctor, Pageable pageable);

	/**
	 * Returns a {@code List<NurseDoctor>} associated to the given
	 * {@link Doctor}
	 * 
	 * @param doctor {@link Pageable}
	 * @return {@code List<NurseDoctor>}
	 */
	List<NurseDoctor> findByDoctorAndDoctor_ActiveTrueAndDoctor_ActiveTrueAndActiveTrue(Doctor doctor);

	/**
	 * Returns a {@code Page<NurseDoctor>} object associated to the given
	 * {@link Nurse} and sorted by pageable param
	 * 
	 * @param nurse    {@link Nurse}
	 * @param pageable {@link Pageable}
	 * @return {@code Page<NurseDoctor>} or empty page
	 */
	Page<NurseDoctor> findByNurseAndNurse_ActiveTrueAndActiveTrue(Nurse nurse, Pageable pageable);

	/**
	 * Returns a {@code List<NurseDoctor>} associated to the given
	 * {@link Nurse}
	 * 
	 * @param nurse {@link Nurse}
	 * @return {@code List<NurseDoctor>}
	 */
	List<NurseDoctor> findByNurseAndNurse_ActiveTrueAndActiveTrue(Nurse nurse);

	/**
	 * Returns a {@code List<NurseDoctor>} associated to the given
	 * {@link Doctor}
	 * 
	 * @param doctor {@link Doctor}
	 * @return {@code List<NurseDoctor>}
	 */
	List<NurseDoctor> findByDoctorAndDoctor_ActiveTrueAndNurse_ActiveTrueAndActiveTrue(Doctor doctor);

}