package mx.softixx.cis.cloud.participant.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.softixx.cis.cloud.participant.persistence.model.Person;

/**
 * Repository : Person
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

	/**
	 * Returns the Person that exactly matches the given id if
	 * {@code Person#isActive()} is true
	 * 
	 * @param id Long
	 * @return Person or null
	 */
	Optional<Person> findByIdAndActiveTrue(Long id);

	/**
	 * @param name      String
	 * @param plastname String
	 * @param mlastname String
	 * @return Person or null
	 */
	Person findByNameAndPaternalSurnameAndMaternalSurname(String name, String plastname, String mlastname);

	/**
	 * Returns the Person that exactly matches the given rfc
	 * 
	 * @param rfc String
	 * @return Person or null
	 */
	Person findByRfc(String rfc);

	/**
	 * Returns the Person that exactly matches the given curp
	 * 
	 * @param curp String
	 * @return Person or null
	 */
	Person findByCurp(String curp);

	/**
	 * Returns the list of Person sorted by the sort param if
	 * {@link Person#getIdentity()} contain the value of the searchValue param
	 * 
	 * @param searchValue String
	 * @param sort        {@link Sort}
	 * @return {@code List<Person>} or empty list
	 */
	@Query("""
			FROM Person pe
			WHERE lower(pe.identity) like lower(concat('%', :val, '%'))
			AND pe.active = true
			""")
	List<Person> findAll(@Param("val") String searchValue, Sort sort);

}