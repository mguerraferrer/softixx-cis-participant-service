package mx.softixx.cis.cloud.participant.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.participant.persistence.model.Doctor;
import mx.softixx.cis.cloud.participant.persistence.model.DoctorSpeciality;

/**
 * Repository : DoctorSpeciality
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface DoctorSpecialityRepository extends JpaRepository<DoctorSpeciality, Long> {

	/**
	 * Returns the DoctorSpeciality associated with a {@link Doctor} and
	 * specialityId
	 * 
	 * @param doctor       {@link Doctor}
	 * @param specialityId Long
	 * @return DoctorSpeciality or null
	 */
	DoctorSpeciality findByDoctorAndDoctor_ActiveTrueAndSpecialityIdAndActiveTrue(Doctor doctor, Long specialityId);

	/**
	 * Returns the DoctorSpeciality that exactly matches the given
	 * professionalLicense
	 * 
	 * @param professionalLicense String
	 * @return DoctorSpeciality or null
	 */
	DoctorSpeciality findByDoctor_ActiveTrueAndProfessionalLicenseAndActiveTrue(String professionalLicense);

	/**
	 * Returns the list of DoctorSpeciality associated with a {@link Doctor}
	 * 
	 * @param doctor {@link Doctor}
	 * @return {@code List<DoctorSpeciality>} or empty list
	 */
	List<DoctorSpeciality> findByDoctorAndDoctor_ActiveTrueAndActiveTrue(Doctor doctor);

}