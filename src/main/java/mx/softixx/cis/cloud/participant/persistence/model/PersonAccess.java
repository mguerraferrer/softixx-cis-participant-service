package mx.softixx.cis.cloud.participant.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import mx.softixx.cis.common.jpa.model.BaseEntity;

/**
 * Persistent class for entity stored in table "person_access"
 *
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 *
 */

@Entity
@Table(name = "person_access", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.person_access_id_seq", allocationSize = 1)
public class PersonAccess extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "person_id", referencedColumnName = "id")
	private Person person;

	@Column(name = "clinical_entity_id")
	private Long clinicalEntityId;

	@Column(name = "private_practice_id")
	private Long privatePracticeId;

	@Column(name = "active")
	private boolean active;

	@Transient
	public PersonAccess withPrivatePractice(Person person, Long privatePracticeId) {
		this.person = person;
		this.privatePracticeId = privatePracticeId;
		this.active = true;
		return this;
	}

	@Transient
	public PersonAccess withClinicalEntity(Person person, Long clinicalEntityId) {
		this.person = person;
		this.clinicalEntityId = clinicalEntityId;
		this.active = true;
		return this;
	}

	/* Getters and Setters */
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Long getClinicalEntityId() {
		return clinicalEntityId;
	}

	public void setClinicalEntityId(Long clinicalEntityId) {
		this.clinicalEntityId = clinicalEntityId;
	}

	public Long getPrivatePracticeId() {
		return privatePracticeId;
	}

	public void setPrivatePracticeId(Long privatePracticeId) {
		this.privatePracticeId = privatePracticeId;
	}

	/* toString */
	public String toString() {
		var sb = new StringBuilder();
		sb.append("[");
		sb.append(id);
		sb.append("]:");
		sb.append(active);
		return sb.toString();
	}

}