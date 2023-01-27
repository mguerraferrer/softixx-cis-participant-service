package mx.softixx.cis.cloud.participant.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.participant.persistence.model.Person;
import mx.softixx.cis.cloud.participant.persistence.model.PersonAccess;

/**
 * Repository : PersonAccess
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface PersonAccessRepository extends JpaRepository<PersonAccess, Long> {
	
	/**
	 * Returns the PersonAccess that exactly matches the given id
	 * 
	 * @param id Long
	 * @return PersonAccess or null
	 */
	PersonAccess findByIdAndActiveTrue(Long id);
	
	/**
	 * Returns the PersonAccess if {@link PersonAccess#getPerson()} is equal to person param
	 * and {@link PersonAccess#getPrivatePracticeId()} is equal to privatePracticeId param
	 * and {@link PersonAccess#isActive()} is false
	 * 
	 * @param person {@link Person}
	 * @param privatePracticeId {@link Long}
	 * @return PersonAccess or null
	 */
	PersonAccess findByPersonAndPrivatePracticeIdAndActiveTrue(Person person, Long privatePracticeId);
	
	/**
	 * Returns the PersonAccess if {@link PersonAccess#getPerson()} is equal to person param
	 * and {@link PersonAccess#getClinicalEntityId()} is equal to cinicalEntityId param
	 * and {@link PersonAccess#isActive()} is false
	 * 
	 * @param person {@link Person}
	 * @param cinicalEntityId {@link Long}
	 * @return PersonAccess or null
	 */
	PersonAccess findByPersonAndClinicalEntityIdAndActiveTrue(Person person, Long cinicalEntityId);
	
	/**
	 * Returns the list of PersonAccess if {@link PersonAccess#getPrivatePractice#getId()} is equal to id param
	 * and {@link PersonAccess#getPerson#getIdentity()} contain the value of the searchValue param
	 * 
	 * @param searchValue String
	 * @param id Long
	 * @return {@code List<PersonAccess>} or empty list
	 
	@Query("FROM PersonAccess pa " +
	 	   "INNER JOIN pa.person pe " +
	 	   "INNER JOIN pa.privatePracticeId cp " +
	 	   "INNER JOIN cp.doctor m " +
	 	   "WHERE lower(pe.identity) LIKE lower(concat('%', :val, '%')) " +
	 	   "AND cp.id = :id " +
	 	   "AND pa.deleted = false " +
	 	   "AND pe.deleted = false " +
	 	   "AND cp.deleted = false " +
	 	   "AND m.active = true")
	List<PersonAccess> findAllForPrivatePractice(@Param("val") String searchValue, @Param("id") Long id);*/
	
}