package mx.softixx.cis.cloud.participant.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.participant.persistence.model.Doctor;

/**
 * Repository : Doctor
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

	/**
	 * Returns the Doctor that exactly matches the given id
	 * 
	 * @param id Long
	 * @return Doctor or null
	 */
	Optional<Doctor> findByIdAndActiveTrue(Long id);
	
	/**
	 * Returns the Doctor that exactly matches the given professionalLicense
	 * 
	 * @param pl String
	 * @return Doctor or null
	 */
	Doctor findByProfessionalLicense(String pl);
	
}