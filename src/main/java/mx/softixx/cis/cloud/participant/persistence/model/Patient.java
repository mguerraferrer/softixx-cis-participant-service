package mx.softixx.cis.cloud.participant.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.softixx.cis.common.jpa.model.BaseEntity;

/**
 * Persistent class for entity stored in table "patient"
 *
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 *
 */

@Entity
@Table(name = "patient", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.patient_id_seq", allocationSize = 1)
public class Patient extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "person_id", referencedColumnName = "id")
	private Person person;

	@Column(name = "blood_type_rh_id")
	private Long bloodTypeRhId;

	@Column(name = "active")
	private boolean active;

	public Patient() {
	}

	public Patient(Person person) {
		this.person = person;
		this.active = true;
	}

	public Patient(Person person, Long bloodTypeRhId) {
		this.person = person;
		this.bloodTypeRhId = bloodTypeRhId;
		this.active = true;
	}

	/* Getters and Setters */
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Long getBloodTypeRhId() {
		return bloodTypeRhId;
	}

	public void setBloodTypeRhId(Long bloodTypeRhId) {
		this.bloodTypeRhId = bloodTypeRhId;
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